import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private static final double SCENE_WIDTH = 300;
    private static final double SCENE_HEIGHT = 250;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);



        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
