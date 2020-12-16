package sample;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class PauseMenuController implements Initializable {
    @FXML private AnchorPane pane;
    @FXML private Button play;
    @FXML private Button home;
    Button button=new Button();

    void addScaleTransition() {
        ScaleTransition st1 = new ScaleTransition(Duration.millis(500), play);
        ScaleTransition st2 = new ScaleTransition(Duration.millis(500), home);
        st1.setByY(0.05);
        st1.setByX(0.05);
        st1.setCycleCount(Timeline.INDEFINITE);
        st1.setAutoReverse(true);
        st1.play();
        st2.setByY(0.05);
        st2.setByX(0.05);
        st2.setCycleCount(Timeline.INDEFINITE);
        st2.setAutoReverse(true);
        st2.play();
    }

    @FXML
    void home(MouseEvent event) throws IOException {
        //go to home
        AnchorPane pane1= FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        pane.getChildren().setAll(pane1);
    }
    @FXML
    void saveGame(MouseEvent event) throws IOException {
        //save this game
        System.out.println("File batao");
        Scanner ins=new Scanner(System.in);
        String check=ins.next();
        File oldName =
                new File("Pause.txt");
        File newName =
                new File(check+".txt");

        if (oldName.renameTo(newName))
            System.out.println("Renamed successfully");
        else
            System.out.println("Error");
        AnchorPane pane1= FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        pane.getChildren().setAll(pane1);
    }
    @FXML
    void resumeGame(MouseEvent event) throws IOException {
        //resume the game
        pane.getChildren().removeAll();
        serializehelp object1 = null;
//        System.out.println("File batao");
//        Scanner ins=new Scanner(System.in);
 //       String check=ins.next();
        //game.savedgames.contains(check);
        // Deserialization
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("Pause.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (serializehelp) in.readObject();
            System.out.println("ok");
//            while (object1!=null && !(object1.saveAs.equals(check))){
//                System.out.println(object1.saveAs);
//                System.out.println("check: "+object1.saveAs.equals(check));
//                object1=(serializehelp) in.readObject();
//            }
            System.out.println("chill1");

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("ballY = " + object1.ballY);
            //System.out.println("Coordinate of Obstacle: "+ object1.ObstaclenowY);
            //System.out.println("b = " + object1.b);
            //Parent root=object1.pane;
            //primaryStage.setTitle("Color Switch");
            //primaryStage.setScene(new Scene(root, 400, 600));
            //primaryStage.show();


            //game.initialise_load(object1);

//            AnchorPane pane1= FXMLLoader.load(getClass().getResource("LoadGame.fxml"));
//            pane.getChildren().setAll(pane1);
        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
        }
        Game game = new Game(pane, object1);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addScaleTransition();
    }
}
