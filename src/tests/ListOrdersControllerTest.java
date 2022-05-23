import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
//import org.loose.fis.sre.model.User;
import static org.testfx.assertions.api.Assertions.assertThat;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.loose.fis.sre.services.OrderBookService;
import org.loose.fis.sre.services.FileSystemService;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)

public class ListOrdersControllerTest {

    @BeforeEach
    void setUp() throws Exception {
        FileSystemService.APPLICATION_FOLDER = ".registration-example";
        FileUtils.cleanDirectory(FileSystemService.getApplicationHomeFolder().toFile());
        OrderBookService.initDatabase();
    }

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("listOrders.fxml"));
        primaryStage.setTitle("List of Orders");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Test
    void testListOrders(FxRobot robot){
        robot.clickOn("#cancelButton");
    }

}
