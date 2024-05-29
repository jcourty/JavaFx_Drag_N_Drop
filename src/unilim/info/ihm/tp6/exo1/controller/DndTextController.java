package unilim.info.ihm.tp6.exo1.controller;

import javafx.event.EventHandler;
import javafx.scene.input.*;
import javafx.scene.text.Text;

public class DndTextController {
    public static void manageSourceDragAndDrop(Text source) {
        source.setOnDragDetected(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
            	Dragboard db = source.startDragAndDrop(TransferMode.ANY);
            	ClipboardContent content = new ClipboardContent();
                content.putString(source.getText());
                db.setContent(content);
                event.consume();
            }
        });
        
        source.setOnDragDone(new EventHandler<DragEvent>() {
        	public void handle(DragEvent event) {
        		if (event.getTransferMode() == TransferMode.MOVE) {
        			source.setText("");
                }
                event.consume();
        		}
        });
    }
    
    public static void manageTargetDragAndDrop(Text source) {
    	source.setOnDragOver(new EventHandler<DragEvent>() {
    		public void handle(DragEvent event) {
    			if (event.getGestureSource() != source && event.getDragboard().hasString()) {
    				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
    			}
    			event.consume();
            }
    	});
    
    	source.setOnDragEntered(new EventHandler<DragEvent>() {
    		public void handle(DragEvent event) {
    			if (event.getGestureSource() != source &&
                    event.getDragboard().hasString()) {
    				source.setStyle("-fx-border-color: blue;");
    			}
            event.consume();
    		}
    	});
    	
    	 source.setOnDragExited(new EventHandler<DragEvent>() {
             public void handle(DragEvent event) {
                 source.setStyle("");
                 event.consume();
             }
         });
    	 
    	 source.setOnDragDropped(new EventHandler<DragEvent>() {
             public void handle(DragEvent event) {
                 Dragboard db = event.getDragboard();
                 boolean success = false;
                 if (db.hasString()) {
                     source.setText(db.getString());
                     success = true;
                 }
                 event.setDropCompleted(success);
                 event.consume();
             }
         });
    }
}
        
             