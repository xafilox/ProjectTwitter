package cliente;

import interfacesComunes.Conexion;
import interfacesComunes.Message;
import interfacesComunes.Twitter;
import interfacesComunes.TwitterInit;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import servidor.ServerCommon;
import servidor.db.ConexionImpl;


public class TestTwitterClient {

	private static Conexion con;
	private static int id;

	public static void main(String[] args){
		
		con=new ConexionImpl();
		TwitterInit stub;
		ClientCallbackListener cliente;
		String rmiUrl = "rmi://localhost/Conectar";
		try {
			stub = (TwitterInit) Naming.lookup(rmiUrl);
			cliente = new ClientCallbackListener();
			Twitter twitter = stub.login("Antonio", "pajarito", cliente);
			if(twitter ==  null){
				System.out.println("Login invalido");
				return;
			}
			else{
				System.out.println((twitter.isValidLogin() ? "Logueado" : "No logueado"));
			}
/*******************************PRUEBAS***********************************************/
			//1
			twitter.updateStatus("nadie me sigue...forever alone");
			if(buscaTwitter("nadie me sigue...forever alone")){
				System.out.println("prueba1-> crear twitter: OK");
			}
			else{
				System.out.println("prueba1-> crear twitter: FAIL");
			}
			//2
			twitter.destroyStatus(id);
			
			if(!buscaTwitter("nadie me sigue...forever alone")){
				System.out.println("prueba1-> borrar twitter: OK");
			}
			else{
				System.out.println("prueba1-> borrar twitter: FAIL");
			}
			
			//3
			twitter.sendMessage("kmilinho","esto es un mensaje para kmilinho");
			
			if(buscaMensaje("esto es un mensaje para kmilinho")){
				System.out.println("prueba3-> enviar mensaje: OK");
			}
			else{
				System.out.println("prueba3-> enviar mensaje: FAIL");
			}
			
			//4
			List<Message> lm=twitter.getDirectMessagesSent();
			System.out.println("Imprimiendo mensaje");
			for(int i=0;i<lm.size();i++){
				System.out.println(lm.get(i).getDisplayText());
			}
			
			//5
			twitter.updateStatus("blablabla 1234 mi tweet");
			System.out.println("tweets del usuario: "+twitter.getSelf().getStatusesCount());
			twitter.updateStatus("otro mas buaaag");
			System.out.println("tweets del usuario: "+twitter.getSelf().getStatusesCount());

/*******************************FIN PRUEBAS***********************************************/			
		} 
		catch (MalformedURLException | RemoteException | NotBoundException e1) {
			e1.printStackTrace();
			return;
		}
	}
	
	private static boolean buscaTwitter(String texto){
		boolean sol=false;
		ResultSet res = con.query("SELECT id FROM tweet WHERE texto=\""+texto+"\"");
		try {
			if(res.next()){
				sol=true;
				id=res.getInt("id");
			}
		} 
		catch (SQLException e) {
			ServerCommon.TwitterWarning(e, "Error al buscar info en BD");
		}
		
		return sol;
	}
	private static boolean buscaMensaje(String texto){
		boolean sol=false;
		ResultSet res = con.query("SELECT id FROM mensajes WHERE texto=\"" + texto+"\"");
		try {
			if(res.next()){
				sol=true;
				id=res.getInt("id");
			}
		} 
		catch (SQLException e) {
			ServerCommon.TwitterWarning(e, "Error al buscar info en BD");
		}
		
		return sol;
	}
	
	
}
