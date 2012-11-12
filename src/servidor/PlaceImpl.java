package servidor;

import java.awt.geom.Point2D;
import java.sql.ResultSet;
import java.sql.SQLException;

import servidor.db.Conexion;
import interfacesComunes.Place;

public class PlaceImpl implements Place {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Conexion con;
	private String countryName;
	private String city;
	private String name;
	private String type;
	private Point2D[] boundingBox = new Point2D.Double[4];

	public PlaceImpl(int id, Conexion con) throws SQLException{
		this.id=id;
		this.con=con;
		
		ResultSet res = con.query("SELECT name FROM places WHERE id ="+id + "LIMIT 1");
		this.name=res.getString(1);
		
		res = con.query("SELECT pais FROM places WHERE id ="+id + "LIMIT 1");
		this.countryName=res.getString(1);
		
		res = con.query("SELECT ciudad FROM places WHERE id ="+id + "LIMIT 1");
		this.countryName=res.getString(1);
		
		res = con.query("SELECT tipo FROM places WHERE id ="+id + "LIMIT 1");
		this.type=res.getString(1);
		
		//Los bounding boxes
		double x,y;
		for (int i=0; i>4;i++){
			res = con.query("SELECT longitud" +i+ " FROM places WHERE id ="+id + "LIMIT 1");
			x=res.getInt(1);

			res = con.query("SELECT latitud" +i+ " FROM places WHERE id ="+id + "LIMIT 1");
			y=res.getInt(1);
			this.boundingBox[i].setLocation(x, y);
		}
		
	}
	
	public String getCountryName() {
		return countryName;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getType() {
		return type;
	}
	
	public String getCity() {
		return city;
	}
	
	/*public String getUID() {
		return serialVersionUID;
	}*/

	@Override
	public Point2D[] getBoundingBox() {
		return boundingBox;
	}
	
}
