import org.jetbrains.annotations.NotNull;
//import org.loose.fis.sre.model.User;
import static org.testfx.assertions.api.Assertions.assertThat;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)

public class ListBooksControllerTest {

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("listBooks.fxml"));
        primaryStage.setTitle("List of Books");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Test
    void testListBooks(FxRobot robot) {
        robot.clickOn("#addButton");
        robot.clickOn("#cancelButton");
        robot.clickOn("#editButton");
        robot.clickOn("#cancelButton");
        robot.clickOn("#deleteButton");
        robot.clickOn("#cancelButton");

        /*
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
        */
    }
}
