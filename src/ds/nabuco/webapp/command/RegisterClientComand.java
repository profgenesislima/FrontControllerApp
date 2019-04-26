package ds.nabuco.webapp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ds.nabuco.webapp.dao.ClientDAO;
import ds.nabuco.webapp.model.Client;

public class RegisterClientComand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		 // Client client = new Client(10,"Nabuco");
		Client client = new Client(Integer.parseInt(request.getParameter("id")),request.getParameter("name"));
		//repository.persist(client);
		new ClientDAO().save(client);
		  request.setAttribute("client", client);
		  request.setAttribute("msg", "Successfully registered");
		System.out.println("Registering Client with id: "+request.getParameter("id")+" and name "+request.getParameter("name"));
		return "main.jsp";
	}
	
	

}
