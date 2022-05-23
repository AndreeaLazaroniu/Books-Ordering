//import org.loose.fis.sre.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.loose.fis.sre.controllers.RegistrationController;
import static org.testfx.assertions.api.Assertions.assertThat;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.fis.sre.services.BookService;
import org.loose.fis.sre.services.FileSystemService;
import org.loose.fis.sre.services.UserService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)

public class EditBookControllerTest {
    public static final String TITLE = "title";
    public static final String AUTHOR = "author";
    public static final String PRICE = "price";
    public static final String PAGENUMBER = "pagenumber";
    public static final String GENRE = "Romance";

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        BookService.initDatabase();
    }

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("editBook.fxml"));
        primaryStage.setTitle("Edit Book");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Test
    void testDeleteBook(FxRobot robot){
        robot.clickOn("#cancelButton");
        robot.clickOn("#addButton");

        robot.clickOn("#titleField");
        robot.write(TITLE);
        robot.clickOn("#authorField");
        robot.write(AUTHOR);
        robot.clickOn("#priceField");
        robot.write(PRICE);
        robot.clickOn("#pageNumberField");
        robot.write(PAGENUMBER);
        robot.clickOn("#genre");
        robot.clickOn("Romance");

        robot.clickOn("#addingButton");
        assertThat(BookService.getBooks()).size().isEqualTo(1);

        robot.clickOn("#editButton");
        robot.clickOn("#titleField");
        robot.write(TITLE);
        robot.clickOn("#priceField");
        robot.write("new price");
        robot.clickOn("#doneButton");
        assertThat(BookService.getBooks()).size().isEqualTo(1);
        assertThat(BookService.getBookPrice(TITLE)).isEqualTo("new price");
    }
}
