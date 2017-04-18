import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;

public class Main extends Application {
    private static final double SCENE_WIDTH = 300;
    private static final double SCENE_HEIGHT = 250;

    private static final double MARGIN = SCENE_HEIGHT * 0.04;
    private static final double CAR_MARGIN = MARGIN * 4;
    private static final double CAR_WIDTH = SCENE_WIDTH - CAR_MARGIN * 2;
    private static final double CAR_HEIGHT = (SCENE_HEIGHT - CAR_MARGIN * 2) / 2;
    private static final double CABIN_WIDTH = CAR_WIDTH * 0.4;
    private static final double CABIN_MARGIN = CABIN_WIDTH * 0.2;
    private static final double WINDOW_MARGIN = CABIN_WIDTH * 0.05;
    private static final double WHEEL_MARGIN = CABIN_WIDTH * 0.5;
    private static final double WHEEL_RADIUS = CAR_MARGIN;
    private static final double AXIS_RADIUS = WHEEL_RADIUS * 0.05;

    private static final Color MAIN = Color.YELLOW;
    private static final Color WHEEL = Color.BLACK;
    private static final Color WINDOW = Color.BLUE;
    private static final Color DORE = Color.GRAY;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        scene.setFill(Color.WHITE);

        double bodyY = CAR_MARGIN + CAR_HEIGHT;
        Rectangle body = new Rectangle();
        body.setX(CAR_MARGIN);
        body.setY(bodyY);
        body.setWidth(CAR_WIDTH);
        body.setHeight(CAR_HEIGHT);
        body.setFill(MAIN);
        root.getChildren().add(body);

        double cabin1X = CAR_MARGIN + CAR_WIDTH - CABIN_WIDTH;
        double cabin2X = SCENE_WIDTH - CAR_MARGIN;
        double cabin3X = SCENE_WIDTH - CABIN_MARGIN - CAR_MARGIN;
        Polygon cabin = new Polygon();
        cabin.getPoints().addAll(
                cabin1X, CAR_MARGIN,
                cabin1X, bodyY,
                cabin2X, bodyY,
                cabin3X, CAR_MARGIN
        );
        cabin.setFill(MAIN);
        root.getChildren().add(cabin);

        Polygon window = new Polygon();
        window.getPoints().addAll(
                cabin1X + WINDOW_MARGIN, CAR_MARGIN + WINDOW_MARGIN,
                cabin1X + WINDOW_MARGIN, bodyY,
                cabin2X - WINDOW_MARGIN, bodyY,
                cabin3X - WINDOW_MARGIN, CAR_MARGIN + WINDOW_MARGIN
        );
        window.setFill(WINDOW);
        root.getChildren().add(window);

        double wheel1X = CAR_MARGIN + WHEEL_MARGIN;
        double wheelY = bodyY + CAR_HEIGHT;
        Ellipse wheel1 = new Ellipse();
        wheel1.setCenterX(wheel1X);
        wheel1.setCenterY(wheelY);
        wheel1.setRadiusX(WHEEL_RADIUS);
        wheel1.setRadiusY(WHEEL_RADIUS);
        wheel1.setFill(WHEEL);
        root.getChildren().add(wheel1);

        double wheel2X = SCENE_WIDTH - CAR_MARGIN - WHEEL_MARGIN;
        Ellipse wheel2 = new Ellipse();
        wheel2.setCenterX(wheel2X);
        wheel2.setCenterY(wheelY);
        wheel2.setRadiusX(WHEEL_RADIUS);
        wheel2.setRadiusY(WHEEL_RADIUS);
        wheel2.setFill(WHEEL);
        root.getChildren().add(wheel2);

        Ellipse axis1 = new Ellipse();
        axis1.setCenterX(wheel1X);
        axis1.setCenterY(wheelY);
        axis1.setRadiusX(AXIS_RADIUS);
        axis1.setRadiusY(AXIS_RADIUS);
        axis1.setFill(MAIN);
        root.getChildren().add(axis1);

        Ellipse axis2 = new Ellipse();
        axis2.setCenterX(wheel2X);
        axis2.setCenterY(wheelY);
        axis2.setRadiusX(AXIS_RADIUS);
        axis2.setRadiusY(AXIS_RADIUS);
        axis2.setFill(MAIN);
        root.getChildren().add(axis2);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
