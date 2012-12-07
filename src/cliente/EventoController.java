/**
 * Sample Skeleton for "evento.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

package cliente;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


public class EventoController
implements Initializable {

	@FXML //  fx:id="descripcionUsuario"
	private TextArea descripcionUsuario; // Value injected by FXMLLoader

	@FXML //  fx:id="favorito"
	private ImageView favorito; // Value injected by FXMLLoader

	@FXML //  fx:id="screename"
	private Label screename; // Value injected by FXMLLoader

	@FXML //  fx:id="seguir"
	private ImageView seguir; // Value injected by FXMLLoader

	@FXML //  fx:id="tweetBox"
	private HBox tweetBox; // Value injected by FXMLLoader

	@FXML //  fx:id="userImage"
	private ImageView userImage; // Value injected by FXMLLoader

	@FXML //  fx:id="username"
	private Hyperlink username; // Value injected by FXMLLoader

	@FXML //  fx:id="worldTweetContainer"
	private AnchorPane worldTweetContainer; // Value injected by FXMLLoader


	// Handler for Hyperlink[fx:id="username"] onAction
	// Handler for Hyperlink[fx:id="username"] onMouseClicked
	// Handler for ImageView[fx:id="userImage"] onMouseClicked
	public void goToPerfilUsuario(Event event) {
		// handle the event here
	}

	@Override // This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert descripcionUsuario != null : "fx:id=\"descripcionUsuario\" was not injected: check your FXML file 'evento.fxml'.";
		assert favorito != null : "fx:id=\"favorito\" was not injected: check your FXML file 'evento.fxml'.";
		assert screename != null : "fx:id=\"screename\" was not injected: check your FXML file 'evento.fxml'.";
		assert seguir != null : "fx:id=\"seguir\" was not injected: check your FXML file 'evento.fxml'.";
		assert tweetBox != null : "fx:id=\"tweetBox\" was not injected: check your FXML file 'evento.fxml'.";
		assert userImage != null : "fx:id=\"userImage\" was not injected: check your FXML file 'evento.fxml'.";
		assert username != null : "fx:id=\"username\" was not injected: check your FXML file 'evento.fxml'.";
		assert worldTweetContainer != null : "fx:id=\"worldTweetContainer\" was not injected: check your FXML file 'evento.fxml'.";

		// initialize your logic here: all @FXML variables will have been injected

	}

}


