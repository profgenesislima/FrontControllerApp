package ds.webapp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import d.webapp.model.Client;
import ds.webapp.dao.ClientDAO;

public class ReturnClientCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Client client = new Client();
		//repository.persist(client);
		client.setName(request.getParameter("clientName"));
		
		Client cli = new ClientDAO().getClient(client);
		  request.setAttribute("client", cli);
		  request.setAttribute("msg", "Successfully returned");
		System.out.println("Returning Client with id: "+request.getParameter("id")+" and name "+request.getParameter("name"));
		return "main.jsp";
		}

}
