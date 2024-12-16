package hust.soict.hedspi.aims.screen;

import java.util.ArrayList;
import javax.swing.JDialog;
import hust.soict.hedspi.aims.cart.HungNT_Cart;
import hust.soict.hedspi.aims.media.HungNT_Media;
import hust.soict.hedspi.aims.media.HungNT_Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HungNT_CartScreenController {
	private HungNT_Cart cart;

	@FXML
	private TableView<HungNT_Media> tblMedia;
	@FXML
	private TextField tfFilter;
	@FXML
	private TableColumn<HungNT_Media, Float> colMediaCost;
	@FXML
	private TableColumn<HungNT_Media, String> colMediaTitle;
	@FXML
	private TableColumn<HungNT_Media, String> colMediacategory;
	@FXML
	private ToggleGroup filterCategory;
	@FXML
    private Label price;
	@FXML
    private Button btnPlaceOrder;
	@FXML
	private Button btnPlay;
	@FXML
	private Button btnRemove;
	@FXML
	private RadioButton radioBtnFilterId;
	@FXML
	private RadioButton radioBtnFilterTitle;

	public HungNT_CartScreenController(HungNT_Cart cart) {
		super();
		this.cart = cart;
	}

	@FXML
	private void initialize() {
		colMediaTitle.setCellValueFactory(new PropertyValueFactory<HungNT_Media, String>("title"));
		colMediacategory.setCellValueFactory(new PropertyValueFactory<HungNT_Media, String>("category"));
		colMediaCost.setCellValueFactory(new PropertyValueFactory<HungNT_Media, Float>("cost"));
		tblMedia.setItems(this.cart.getItemsOrdered());

		btnPlay.setVisible(false);
		btnRemove.setVisible(false);

		tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<HungNT_Media>() {
			@Override
			public void changed(ObservableValue<? extends HungNT_Media> observable, HungNT_Media oldValue,
					HungNT_Media newValue) {
				if (newValue != null)
					updateButtonBar(newValue);
			}
		});

		tfFilter.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (filterCategory.getSelectedToggle() == radioBtnFilterId && !newValue.isEmpty()
						&& !isInteger(newValue)) {
					tfFilter.setText(oldValue);
				} else {
					showFilteredMedia(newValue);
				}
			}
			private boolean isInteger(String newValue) {
				try {
					Integer.parseInt(newValue);
					return true;
				} catch (NumberFormatException e) {
					return false;
				}
			}
		});
		price.setText(" " + Float.toString(cart.totalCost()) + "$");
	}

	protected void showFilteredMedia(String newValue) {
		if (filterCategory.getSelectedToggle() == radioBtnFilterTitle) {
			ArrayList<HungNT_Media> filterByTitle = new ArrayList<HungNT_Media>();
			for (HungNT_Media item : cart.getItemsOrdered()) {
				if (item.getTitle().contains(newValue)) {
					filterByTitle.add(item);
				}
			}
			tblMedia.setItems(FXCollections.observableList(filterByTitle));
		} else if (filterCategory.getSelectedToggle() == radioBtnFilterId) {
			ArrayList<HungNT_Media> filterByID = new ArrayList<HungNT_Media>();
			if (!newValue.isEmpty()) {
				int id = Integer.parseInt(newValue);
				for (HungNT_Media item : cart.getItemsOrdered()) {
					if (item.getId() == id) {
						filterByID.add(item);
					}
				}
				tblMedia.setItems(FXCollections.observableList(filterByID));
			} else {
				tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
			}
		}
	}

	private void updateButtonBar(HungNT_Media media) {
		btnRemove.setVisible(true);
		if (media instanceof HungNT_Playable) {
			btnPlay.setVisible(true);
		} else {
			btnPlay.setVisible(false);
		}
	}

	@FXML
	void btnRemovePressed(ActionEvent event) {
		HungNT_Media media = tblMedia.getSelectionModel().getSelectedItem();
		cart.removeMedia(media);
		price.setText(" " + Float.toString(cart.totalCost()) + "$");
	}
	@FXML
	void btnPlayPressed(ActionEvent event) {
		JDialog playDialog = HungNT_MediaStore.createPlayDialog(tblMedia.getSelectionModel().getSelectedItem());
        playDialog.setVisible(true);
        playDialog.setSize(300,200);
        playDialog.pack();
	}


    @FXML
    void placeOrderPressed(ActionEvent event) {
    	createPopUp();
        cart.getItemsOrdered().clear();
        tblMedia.setItems(FXCollections.observableList(cart.getItemsOrdered()));
        price.setText(" 0$");
    }

	private void createPopUp() {
		Stage popupwindow = new Stage();
        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Confirmation");

        Label label1 = new Label("Your order has been purchased!");
        label1.setFont(Font.font("Arial", FontWeight.BOLD,14));
        Label label2 = new Label("Your price: " + Float.toString(cart.totalCost()) + "$");
        Button button1= new Button("Accept!");
        label2.setTextFill(Color.RED);
        button1.setOnAction(e -> popupwindow.close());
        VBox layout= new VBox(10);
        layout.getChildren().addAll(label1, label2, button1);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 300, 200);
        popupwindow.setScene(scene);
        popupwindow.show();		
	}
}
