package testDB;

import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.rowset.serial.SerialBlob;

import testModel.PersonId;

public class IdDataController {
	private DBConnectionManager mngr;
	
	public IdDataController(DBConnectionManager mngr) {
		this.mngr = mngr;
	}
	
	public int insertData(String firstName, String lastName, String  birthDate,
			String country, String state, String city, String email, 
			String photograph) throws SQLException {
		int res = 0;
		String request = "INSERT INTO student_project.person (firstName,"
				+ "lastName,country,state,city,birthDate,email,"
				+ "photograph) VALUES ('" + firstName + "','"
				+ lastName + "','" + birthDate + "','" + country + "','" 
				+ state + "','" + city + "','" + email + "','"
				+ photograph + "')";
		try {
			mngr.connect();
			if(mngr.getConnection() != null) {
				res = mngr.executeUpdate(request);
				mngr.getConnection().commit();
			}
		} catch(SQLException e) {
			//mngr.getConnection().rollback();
			System.out.println(e);
			throw(e);
		} finally {
			if(mngr.getConnection() != null)
				mngr.closeConnection();
		}
		return res;
	}
	
	//public PersonId[]
	public ArrayList<PersonId> retrieveData() throws SQLException {
		ResultSet rs;
		ArrayList<PersonId> ids = new ArrayList<PersonId>();
		PersonId id;
		String query = "SELECT * FROM student_project.person";
		try {
			mngr.connect();
			if(mngr.isConnected()) {
				rs = mngr.executeQuery(query);
				while(rs.next()){
		        	id = new PersonId(rs.getString("firstName"), 
		        			rs.getString("lastName"), rs.getString("birthDate"),
		        			rs.getString("country"), rs.getString("state"), 
		        			rs.getString("city"), rs.getString("email"));
		        	SerialBlob photo = new SerialBlob(rs.getBlob("photograph"));
		        	id.setPhoto(photo);
		        	ids.add(id);
		    	}
			}
		} catch(SQLException e) {
			System.out.println(e);
			throw(e);
		} finally {
			if(mngr.isConnected())
				mngr.closeConnection();
		}
		return ids;
	}
}
