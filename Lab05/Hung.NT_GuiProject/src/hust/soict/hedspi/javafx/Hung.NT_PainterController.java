package hust.soict.hedspi.javafx;

import java.util.Iterator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class HungNT_PainterController {
	@FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraser;

    @FXML
    private RadioButton pen;
    
    @FXML
    private ToggleGroup toolGroup;

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	if(pen.isSelected()) {
    		Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        	drawingAreaPane.getChildren().add(newCircle);
    	}
    	else if (eraser.isSelected()) {
    	    Iterator<Node> iter = drawingAreaPane.getChildren().iterator();
    	    while (iter.hasNext()) {
    	        Node c = iter.next();
    	        if (c instanceof Circle circle) {
    	            if (circle.getCenterX() <= event.getX() + 10 && circle.getCenterX() >= event.getX() - 10) {
    	                if (circle.getCenterY() <= event.getY() + 10 && circle.getCenterY() >= event.getY() - 10) iter.remove();
    	            }
    	        }
    	    }
    	}
    }
}
