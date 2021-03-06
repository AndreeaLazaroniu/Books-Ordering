import org.junit.Before;
import org.junit.jupiter.api.*;
//import org.loose.fis.sre.model.User;
import org.loose.fis.sre.controllers.RegistrationController;
import static org.testfx.assertions.api.Assertions.assertThat;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)

public class RegistrationControllerTest {
    public static final String USERNAME = "user";
    public static final String PASSWORD = "password";
    public static final String ADDRESS = "address";
    public static final String PHONENUMBER = "phonenumber";
    public static final String ROLE = "Customer";

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        UserService.initDatabase();
    }

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("register.fxml"));
        primaryStage.setTitle("Registration");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Test
    void testRegistration(FxRobot robot) {
        robot.clickOn("#usernameField");
        robot.write(USERNAME);
        robot.clickOn("#passwordField");
        robot.write(PASSWORD);
        robot.clickOn("#addressField");
        robot.write(ADDRESS);
        robot.clickOn("#phoneNumberField");
        robot.write(PHONENUMBER);
        robot.clickOn("#role");
        robot.clickOn("Customer");
        robot.clickOn("#registerButton");

        //assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Account created successfully!");
        assertThat(UserService.getAllUsers()).size().isEqualTo(1);
        robot.clickOn("#registerButton");

        robot.clickOn("#usernameField");
        robot.write(USERNAME);
        robot.clickOn("#passwordField");
        robot.write(PASSWORD);
        robot.clickOn("#addressField");
        robot.write(ADDRESS);
        robot.clickOn("#phoneNumberField");
        robot.write(PHONENUMBER);
        robot.clickOn("#role");
        robot.clickOn("Customer");
        robot.clickOn("#registerButton");
        assertThat(robot.lookup("#registrationMessage").queryText()).hasText(
                String.format("An account with the username %s already exists!", USERNAME)
        );

        robot.clickOn("#usernameField");
        robot.write("1");
        robot.clickOn("#registerButton");

        //assertThat(robot.lookup("#registrationMessage").queryText()).hasText("Account created successfully!");
        assertThat(UserService.getAllUsers()).size().isEqualTo(2);
        robot.clickOn("#cancelButton");
    }
}
