package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Games;

/**
 * Servlet implementation class addGameServlet
 */
@WebServlet("/addGameServlet")
public class AddGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

			String name = request.getParameter("name");
			String priceString = request.getParameter("price");
			if (name.isEmpty() || priceString.isEmpty() || name == null || priceString == null) {
				getServletContext().getRequestDispatcher("/add-game.jsp").forward(request, response);
			} else {
				double price = Double.parseDouble(priceString);
				Games game = new Games(name, price);
				GamesHelper gh = new GamesHelper();
				gh.insertGame(game);

				getServletContext().getRequestDispatcher("/viewAllGamesServlet").forward(request, response);
			}
	}

}
