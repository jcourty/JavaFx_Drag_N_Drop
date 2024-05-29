package unilim.info.ihm.tp6.exo1.controller;

import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DndRectangleControler {

    public static void manageSourceDragAndDrop(Rectangle source) {
        source.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
            	Dragboard db = source.startDragAndDrop(TransferMode.ANY);
            	ClipboardContent content = new ClipboardContent();
            	content.putString(source.getFill().toString());
                db.setContent(content);
                event.consume();
            }
        });
        
        source.setOnDragDone(new EventHandler<DragEvent>() {
        	public void handle(DragEvent event) {
        		if (event.getGestureSource() == TransferMode.MOVE) {
        			source.setFill(Color.TRANSPARENT);
                }
                event.consume();
        		}
        });
    }
    
    public static void manageTargetDragAndDrop(Rectangle source) {
    	source.setOnDragOver(new EventHandler<DragEvent>() {
    		public void handle(DragEvent event) {
    			if (event.getGestureSource() != source && event.getDragboard().hasString()) {
    				event.acceptTransferModes(TransferMode.MOVE);
    			}
    			event.consume();
            }
    	});
    
    	source.setOnDragEntered(new EventHandler<DragEvent>() {
    		public void handle(DragEvent event) {
    			if (event.getGestureSource() != source &&
                    event.getDragboard().hasString()) {
    				source.setOpacity(0.7);
    			}
            event.consume();
    		}
    	});
    	
    	 source.setOnDragExited(new EventHandler<DragEvent>() {
             public void handle(DragEvent event) {
                 source.setOpacity(1.0);
                 event.consume();
             }
         });
    	 
    	 source.setOnDragDropped(new EventHandler<DragEvent>() {
             public void handle(DragEvent event) {
                 Dragboard db = event.getDragboard();
                 boolean success = false;
                 if (db.hasString()) {
                     Color droppedColor = Color.valueOf(db.getString());
                     Color targetColor = (Color) source.getFill();
                     source.setFill(droppedColor);
                     ((Rectangle) event.getGestureSource()).setFill(targetColor);
                     success = true;
                 }
                 event.setDropCompleted(success);
                 event.consume();
             }
         });
    }


}
