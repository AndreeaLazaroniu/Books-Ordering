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

public class ShopControllerTest {

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("shop.fxml"));
        primaryStage.setTitle("Shop");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Test
    void shopTest(FxRobot robot) throws InterruptedException {
        robot.clickOn("#booksButton");
        robot.clickOn("#cancelButton");
        robot.clickOn("#ordersButton");
        robot.clickOn("#cancelButton");
        robot.clickOn("#cancelButton");
    }



}
