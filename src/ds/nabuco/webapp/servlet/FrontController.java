package ds.nabuco.webapp.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ds.webapp.command.Command;
import ds.webapp.command.RegisterClientComand;
import ds.webapp.command.ReturnClientCommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	 Map<String,Command> registerService = new HashMap<String,Command>(); 
	 
	/**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        registerService.put("registerClient", new RegisterClientComand());
        registerService.put("returnClient", new ReturnClientCommand());

        
        // TODO Auto-generated constructor stub
    }
    
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.getWriter().append("Served at: ").append(request.getContextPath());			
		Command command = (Command)registerService.get(request.getParameter("cmd"));		
		String page = command.execute(request, response);
		request.getRequestDispatcher(page).forward(request, response);
	}
	
    

}
