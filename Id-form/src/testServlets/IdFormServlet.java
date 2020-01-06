package testServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import testDB.DBConnectionManager;
import testDB.IdDataController;
import testModel.PersonId;

/**
 * Servlet implementation class IdFormServlet
 */
@WebServlet("/IdFormServlet")
public class IdFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try {
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String birthDate = request.getParameter("birthDate");
			String country = request.getParameter("country");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			String email = request.getParameter("email");
			String photograph = request.getParameter("photograph");
			
			ServletContext ctx = this.getServletContext();
			String user = ctx.getInitParameter("DB_USER");
			String password = ctx.getInitParameter("DB_PASSWORD");
			String url = ctx.getInitParameter("DB_URL");
			
			ArrayList<PersonId> list = new ArrayList<PersonId>();
			try {
				DBConnectionManager mngr = 
						(DBConnectionManager) ctx.getAttribute("DB_MANAGER");
				mngr = new DBConnectionManager(url, user, password);
				IdDataController ctrllr = new IdDataController(mngr);
				if(ctrllr.insertData(firstName, lastName, birthDate, country, 
						state, city, email, photograph) > 0) {
					list = ctrllr.retrieveData();
					pw.write("<table><th>First Name</th><th>Last Name</th>"
							+ "<th>Birth Date</th><th>Country</th>"
							+ "<th>State</th><th>City</th><th>E-mail</th>"
							+ "<th>Photo</th>");
					for(PersonId id : list) {
						pw.write("<tr><td>" + id.getFirstName() + "</td><td>"
								+ id.getLastName() + "</td><td>"
								+ id.getBirthDate() + "</td><td>"
								+ id.getCountry() + "</td><td>" + id.getState() 
								+ "</td><td>" + id.getCity() + "</td><td>"
								+ id.getEmail() + "</td><td>" + id.getPhoto()
								+ "</td></tr>");
					}
					pw.write("</table>");
				} else {
					pw.write("No data to retrieve");
				}
			} catch(SQLException e) {
				System.out.println(e);
				pw.write(e.toString());
			}	
		} catch(Exception e) {
			System.out.println(e);
			pw.write("Transaction Specific Error: " + e.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
