package cliente;

/**
 * Sample Skeleton for "conecta.fxml" Controller Class
 * You can copy and paste this code into your favorite IDE
 **/

import interfacesComunes.AStream;
import interfacesComunes.Status;
import interfacesComunes.Twitter.ITweet;
import interfacesComunes.TwitterEvent;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class ConectaController extends Controller implements AStream.IListen {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4970760782255840436L;

	@FXML //  fx:id="cajaInteracciones"
    private VBox cajaInteracciones; // Value injected by FXMLLoader

    @FXML //  fx:id="imagenFondo"
    private AnchorPane imagenFondo; // Value injected by FXMLLoader

    @FXML //  fx:id="tweetsMenciones"
    private VBox tweetsMenciones; // Value injected by FXMLLoader

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert cajaInteracciones != null : "fx:id=\"cajaInteracciones\" was not injected: check your FXML file 'conecta.fxml'.";
        assert imagenFondo != null : "fx:id=\"imagenFondo\" was not injected: check your FXML file 'conecta.fxml'.";
        assert tweetsMenciones != null : "fx:id=\"tweetsMenciones\" was not injected: check your FXML file 'conecta.fxml'.";
       
        // initialize your logic here: all @FXML variables will have been injected

    }


	@Override
	public boolean processEvent(TwitterEvent event) throws RemoteException {
		this.addEvent(cajaInteracciones, event);
		return true;
	}


	@Override
	public boolean processSystemEvent(Object[] obj) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean processTweet(ITweet tweet) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void postInitialize() {
		//Inicializar tweets hay que hacer getMentions xD
		/*Iterator<Status> menciones = super.getTwitter().getMentions().iterator();
		tweetsMenciones.getChildren().clear();
		while(menciones.hasNext()){
			this.addTweet(tweetsMenciones, menciones.next());
		}*/
		
		Iterator<TwitterEvent> interacciones =super.getTwitter().stream().getEvents().iterator();
		cajaInteracciones.getChildren().clear();
		while(interacciones.hasNext()){
			this.addEvent(cajaInteracciones, interacciones.next());
		}
		
	}


	@Override
	protected AnchorPane getContainer() {
		// TODO Auto-generated method stub
		return imagenFondo;
	}
	
	/**
	 * Añade un tweet al final de la lista.
	 * @param contendor VBox a la que añadir el tweet.
	 * @param tweet Tweet a añadir.
	 */
	private void addTweet(VBox contendor, ITweet tweet){
		addTweet(contendor, tweet, false);
	}
	
	/**
	 * Añade un tweet.
	 * @param contendor VBox a la que añadir el tweet.
	 * @param tweet Tweet a añadir.
	 * @param onTop True si el tweet se tiene que añadir al principio de la lista.
	 */
	private void addTweet(VBox contendor,ITweet tweet, boolean onTop){
		try {
			FXMLTweetAutoLoader tweetUI = new FXMLTweetAutoLoader(getTwitter(), (Status) tweet);
			if(!onTop)
				contendor.getChildren().add(tweetUI.getRoot());
			else{
				LinkedList<Node> list = new LinkedList<Node>(contendor.getChildren());
				list.addFirst(tweetUI.getRoot());
				contendor.getChildren().clear();
				contendor.getChildren().addAll(list);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addEvent(VBox contendor, TwitterEvent event){
		addEvent(contendor, event, false);
	}
	
	private void addEvent(VBox contendor,TwitterEvent event, boolean onTop){
		if(event.getType().equals(TwitterEvent.Type.FAVORITE) || event.getType().equals(TwitterEvent.Type.FOLLOW)){
			try {
				FXMLEventAutoLoader eventUI = new FXMLEventAutoLoader(getTwitter(), (TwitterEvent)event);
				if(!onTop)
					contendor.getChildren().add(eventUI.getRoot());
				else{
					LinkedList<Node> list = new LinkedList<Node>(contendor.getChildren());
					list.addFirst(eventUI.getRoot());
					contendor.getChildren().clear();
					contendor.getChildren().addAll(list);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(event.getType().equals(TwitterEvent.Type.UNFAVORITE)){
			postInitialize();
		}
	}
	
	 
}

