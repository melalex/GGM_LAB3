import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.util.Duration;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

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
    private static final double DORE_WIDTH = 2;
    private static final double KNOB_X = 4;
    private static final double KNOB_Y = 2;
    private static final double KNOB_MARGIN = 5;

    private static final Color MAIN = Color.YELLOW;
    private static final Color SECONDARY = Color.STEELBLUE;
    private static final Color WHEEL = Color.BLACK;
    private static final Color WINDOW = Color.BLUE;
    private static final Color DORE = Color.GRAY;


    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        scene.setFill(Color.WHITE);

        double bodyY = CAR_MARGIN + CAR_HEIGHT;

        Polygon tipper = new Polygon();
        tipper.getPoints().addAll(
                MARGIN, 70D,
                MARGIN, bodyY + CAR_HEIGHT * 0.5,
                150D, (CAR_WIDTH - CABIN_WIDTH) * 0.5,
                100D, 0D
        );
        tipper.setFill(SECONDARY);
        root.getChildren().add(tipper);

        Polygon bumper = new Polygon();
        bumper.getPoints().addAll(
                MARGIN * 3, bodyY + CAR_HEIGHT * 0.8,
                MARGIN * 3, bodyY + CAR_HEIGHT,
                CAR_MARGIN, bodyY + CAR_HEIGHT,
                CAR_MARGIN, bodyY + CAR_HEIGHT * 0.8
        );
        bumper.setFill(SECONDARY);
        root.getChildren().add(bumper);

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

        Line doreDivider = new Line();
        doreDivider.setStartX(cabin1X);
        doreDivider.setStartY(bodyY);
        doreDivider.setEndX(cabin1X);
        doreDivider.setEndY(bodyY + CAR_HEIGHT);
        doreDivider.setStrokeWidth(DORE_WIDTH);
        doreDivider.setStroke(DORE);
        root.getChildren().add(doreDivider);

        Ellipse knob = new Ellipse();
        knob.setCenterX(cabin1X + KNOB_MARGIN + KNOB_X);
        knob.setCenterY(bodyY + KNOB_MARGIN + KNOB_Y);
        knob.setRadiusX(KNOB_X);
        knob.setRadiusY(KNOB_Y);
        knob.setStrokeWidth(DORE_WIDTH);
        knob.setStroke(DORE);
        knob.setFill(MAIN);
        root.getChildren().add(knob);

        FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), root);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.0f);
        fadeTransition.setCycleCount(Timeline.INDEFINITE);
        fadeTransition.setAutoReverse(true);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), root);
        translateTransition.setFromX(30);
        translateTransition.setToX(200);
        translateTransition.setCycleCount(Timeline.INDEFINITE);
        translateTransition.setAutoReverse(true);

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000),root);
        rotateTransition.setByAngle(360f);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        rotateTransition.setAutoReverse(true);

        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), root);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(Timeline.INDEFINITE);
        scaleTransition.setAutoReverse(true);
        ParallelTransition parallelTransition =new ParallelTransition();
        parallelTransition.getChildren().addAll(
                fadeTransition,
                translateTransition,
                rotateTransition,
                scaleTransition);

        parallelTransition.play();
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
