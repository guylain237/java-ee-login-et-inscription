package com.servelet.client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Email = request.getParameter("email");
		String Password = request.getParameter("password");

		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		if (Email == null || Email.equals("")) {
			request.setAttribute("status", "invalideEmail");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		if (Password == null || Password.equals("")) {
			request.setAttribute("status", "invalidePwd");
			dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mspr?useSSL=false", "root", "");
			PreparedStatement pst = con.prepareStatement("select * from utilisateur where Email=? and Password=?");

			pst.setString(1, Email);
			pst.setString(2, Password);

			ResultSet rst = pst.executeQuery();
			if (rst.next()) {
				session.setAttribute("id", rst.getString("Id"));
				session.setAttribute("photo", rst.getString("Photo"));
				session.setAttribute("name", rst.getString("Nom"));
				session.setAttribute("genre", rst.getString("Genre"));
				session.setAttribute("email", rst.getString("Email"));
				session.setAttribute("password", rst.getString("Password"));
				session.setAttribute("telephone", rst.getString("Telephone"));
				session.setAttribute("date", rst.getString("Date"));
				dispatcher = request.getRequestDispatcher("index.jsp");
			} else {

				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");

			}
			dispatcher.forward(request, response);

		} catch (Exception e) {
			System.out.print(e.getMessage());

		}
	}

}
