package sample;

import com.sun.prism.paint.Paint;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Obstacle1 {
    Pane pane=new Pane();
    RotateTransition rotate=new RotateTransition();
    Line line1=new Line();
    Line line2=new Line();
    Line line3=new Line();
    Line line4=new Line();
    Obstacle1(){
        line1.setStartX(200);
        line1.setStartY(200);
        line1.setEndX(300);
        line1.setEndY(200);
        line1.setStrokeType(StrokeType.CENTERED);
        line1.setStroke(Color.RED);
        line1.setStrokeWidth(10);

        line2.setStartX(200);
        line2.setStartY(200);
        line2.setEndX(200);
        line2.setEndY(100);
        line2.setStrokeType(StrokeType.CENTERED);
        line2.setStroke(Color.BLUE);
        line2.setStrokeWidth(10);

        line3.setStartX(200);
        line3.setStartY(200);
        line3.setEndX(100);
        line3.setEndY(200);
        line3.setStrokeType(StrokeType.CENTERED);
        line3.setStroke(Color.VIOLET);
        line3.setStrokeWidth(10);

        line4.setStartX(200);
        line4.setStartY(200);
        line4.setEndX(200);
        line4.setEndY(300);
        line4.setStrokeType(StrokeType.CENTERED);
        line4.setStroke(Color.YELLOW);
        line4.setStrokeWidth(10);

        Group group=new Group();
        group.getChildren().addAll(line1,line2,line3,line4);

        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setToAngle(720);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.millis(6000));
        rotate.setAutoReverse(false);
        rotate.setNode(group);
        rotate.play();
        pane.getChildren().add(group);
    }
}