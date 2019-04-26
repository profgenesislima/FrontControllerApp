package ds.nabuco.webapp.testdrive;

import ds.nabuco.webapp.dao.ClientDAO;
import ds.nabuco.webapp.model.Client;

public class TestDAO {

	
	public static void main(String[] args) {
		Client client = new Client(2,"test");
		new ClientDAO().save(client);
		
	
		
	}
}
