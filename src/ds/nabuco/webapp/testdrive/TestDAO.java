package ds.nabuco.webapp.testdrive;

import d.webapp.model.Client;
import ds.webapp.dao.ClientDAO;

public class TestDAO {

	
	public static void main(String[] args) {
		Client client = new Client(2,"test");
		new ClientDAO().save(client);
		
	
		
	}
}
