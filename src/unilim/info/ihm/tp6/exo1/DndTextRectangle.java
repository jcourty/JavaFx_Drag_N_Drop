package unilim.info.ihm.tp6.exo1;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import unilim.info.ihm.tp6.exo1.controller.*;

public class DndTextRectangle extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Création des objets Text
        Text dragText = new Text(50, 50, "DRAG ME");
        Text dropText = new Text(300, 50, "DROP HERE");

        Rectangle rectangle1 = new Rectangle(50, 100, 150, 100);
        rectangle1.setFill(Color.BLUE);

        Rectangle rectangle2 = new Rectangle(300, 200, 150, 100);
        rectangle2.setFill(Color.GREEN);

        
        Group group = new Group(dragText, dropText,rectangle1, rectangle2);
        DndTextController.manageSourceDragAndDrop(dragText);
        DndTextController.manageTargetDragAndDrop(dropText);
        DndRectangleControler.manageSourceDragAndDrop(rectangle1);
        DndRectangleControler.manageTargetDragAndDrop(rectangle2);
        
        
        Scene scene = new Scene(group, 500, 350);
        scene.setFill(Color.LIGHTGREEN);

        // Configuration de la scène et affichage de la scène sur la stage
        stage.setTitle("Drag and Drop Rectangle");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}