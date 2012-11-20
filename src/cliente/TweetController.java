/**
 * Sample Skeleton for "tweet.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/
package cliente;

import interfacesComunes.Status;

import java.awt.TextArea;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


public class TweetController extends Controller{

	@FXML //  fx:id="tweetTextArea"
	private TextArea tweetTextArea; // Value injected by FXMLLoader
	
    @FXML //  fx:id="worldContainer"
    private AnchorPane worldContainer; // Value injected by FXMLLoader
    
    private Status status;


    // Handler for Label[id="opcion"] onMouseClicked
    public void abrirTweet(MouseEvent event) {
        // handle the event here
    }

    // Handler for Label[id="opcion"] onMouseClicked
    public void anadirFavorito(MouseEvent event) {
        // handle the event here
    }

    // Handler for Hyperlink[id="screenName"] onAction
    // Handler for ImageView[id="profileImage"] onMouseClicked
    public void goToPerfilUsuario(Event event) {
        // handle the event here
    }

    // Handler for Label[id="opcion"] onMouseClicked
    public void responderTweet(MouseEvent event) {
        // handle the event here
    }

    // Handler for Label[id="opcion"] onMouseClicked
    public void retwittearTweet(MouseEvent event) {
        // handle the event here
    }

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert tweetTextArea != null : "fx:id=\"tweetTextArea\" was not injected: check your FXML file 'tweet.fxml'.";
    	assert worldContainer != null : "fx:id=\"worldContainer\" was not injected: check your FXML file 'tweet.fxml'.";
        
        // initialize your logic here: all @FXML variables will have been injected

    }

	@Override
	public void postInitialize() {
		this.tweetTextArea.setText(this.status.getText());
		
	}
	
	protected void setStatus(Status status){
		this.status = status;
	}

}
