import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;

class UserServiceTest {

    public static final String ADMIN = "admin";
    public static final String ADMIN2 = "admin2";
    public static final String ROLE = "Customer";
    public static final String ROLE2 = "BookShop Manager";


    @BeforeAll
    static void beforeAll() {
        System.out.println("Before Class");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After Class");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After each");
    }

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
    }

    @Test
    @DisplayName("Database is initialized, and there are no users")
    void testDatabaseIsInitializedAndNoUserIsPersisted() {
        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isEmpty();
    }

    @Test
    @DisplayName("User is successfully persisted to Database")
    void testUserIsAddedToDatabase() throws UsernameAlreadyExistsException {
        UserService.addUser(ADMIN, ADMIN, ADMIN, ADMIN, ROLE);
        assertThat(UserService.getAllUsers()).isNotEmpty();
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        User user = UserService.getAllUsers().get(0);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(ADMIN);
        assertThat(user.getPassword()).isEqualTo(UserService.encodePassword(ADMIN, ADMIN));
        assertThat(user.getRole()).isEqualTo(ROLE);
    }

    @Test
    @DisplayName("User can not be added twice")
    void testUserCanNotBeAddedTwice() {
        assertThrows(UsernameAlreadyExistsException.class, () -> {
            UserService.addUser(ADMIN, ADMIN, ADMIN, ADMIN, ROLE);
            UserService.addUser(ADMIN, ADMIN, ADMIN, ADMIN, ROLE);
        });
    }

    @Test
    void testCheckRole() throws UsernameAlreadyExistsException{
        UserService.addUser(ADMIN, ADMIN, ADMIN, ADMIN, ROLE);
        assertThat(UserService.checkRole(ADMIN)).isEqualTo(true);
    }

    @Test
    void testCheckRole2() throws UsernameAlreadyExistsException{
        UserService.addUser(ADMIN, ADMIN, ADMIN, ADMIN, ROLE2);
        assertThat(UserService.checkRole(ADMIN)).isEqualTo(false);
    }

    @Test
    void testReturnUsernameCurrent() throws UsernameAlreadyExistsException{
        UserService.addUser(ADMIN, ADMIN, ADMIN, ADMIN, ROLE);
        assertThat(UserService.returnUsernameCurrent(ADMIN)).isEqualTo(ADMIN);
    }

    @Test
    void testReturnUsernameCurrent2() throws UsernameAlreadyExistsException{
        UserService.addUser(ADMIN2, ADMIN, ADMIN, ADMIN, ROLE);
        assertThat(UserService.returnUsernameCurrent(ADMIN)).isEqualTo("");
    }

    @Test
    void testDoesCredsMatchForLogin() throws UsernameAlreadyExistsException{
        UserService.addUser(ADMIN, ADMIN, ADMIN, ADMIN, ROLE);
        assertThat(UserService.doesCredsMatchForLogin(ADMIN)).isEqualTo(true);
    }

    @Test
    void testDoesCredsMatchForLogin2() throws UsernameAlreadyExistsException{
        UserService.addUser(ADMIN2, ADMIN, ADMIN, ADMIN, ROLE);
        assertThat(UserService.doesCredsMatchForLogin(ADMIN)).isEqualTo(false);
    }
}
