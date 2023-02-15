package com.servelet.client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Inscription
 */
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Nom = request.getParameter("name");
		String Email = request.getParameter("email");
		String Password = request.getParameter("password");
		String Rpassword = request.getParameter("re_password");
		String Telephone = request.getParameter("contact");
		String Genre = request.getParameter("genre");
		String Date = request.getParameter("date");
		String Term = request.getParameter("term");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		if (Term == null || Nom.equals("")) {
			request.setAttribute("status", "invalidTerm");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}

		if (Genre == null || Nom.equals("")) {
			request.setAttribute("status", "invalidGenre");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		if (Nom == null || Nom.equals("")) {
			request.setAttribute("status", "invalidNom");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		if (Email == null || Email.equals("")) {
			request.setAttribute("status", "invalidEmail");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		if (Password.length() > 8) {
			request.setAttribute("status", "invalidPwd");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		} else if (!Password.equals(Rpassword)) {
			request.setAttribute("status", "invalidPwdConf");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}

		if (Telephone == null || Telephone.equals("")) {
			request.setAttribute("status", "invalidMobile");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		} else if (Telephone.length() > 10) {
			request.setAttribute("status", "invalidMobileLength");
			dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mspr?useSSL=false", "root", "");
			PreparedStatement pst = con
					.prepareStatement("insert into utilisateur(Nom,Genre,Email,Password,Telephone)values(?,?,?,?,?)");
			pst.setString(1, Nom);
			pst.setString(2, Genre);
			pst.setString(3, Email);
			pst.setString(4, Password);
			pst.setString(5, Telephone);
			// pst.setString(5, Date);

			int rowCount = pst.executeUpdate();
			// dispatcher = getServletContext().getRequestDispatcher("registration.jsp");
			dispatcher = request.getRequestDispatcher("registration.jsp");

			if (rowCount > 0) {
				request.setAttribute("status", "success");
			} else {

				request.setAttribute("status", "failed");

			}
			dispatcher.forward(request, response);

		} catch (Exception e) {
			System.out.print(e.getMessage());
			System.out.print("error");

		}

		finally {
			try {
				con.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
