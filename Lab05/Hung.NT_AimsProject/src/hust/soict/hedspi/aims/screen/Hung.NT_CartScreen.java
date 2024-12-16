package hust.soict.hedspi.aims.screen;

import java.io.IOException;
import javax.swing.JFrame;
import hust.soict.hedspi.aims.cart.HungNT_Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class HungNT_CartScreen extends JFrame {
	private static final long serialVersionUID = 1L;

	public HungNT_CartScreen(HungNT_Cart cart) {
		super();

		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);

		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/hedspi/aims/screen/HungNT_cart.fxml"));
					HungNT_CartScreenController controller = new HungNT_CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
