package com.servelet.client;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class ModifierProfile
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)

public class ModifierProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Nom = request.getParameter("nom");
		String Email = request.getParameter("email");
		String Genre = request.getParameter("genre");
		String Telephone = request.getParameter("telephone");
		String Password = request.getParameter("password");
		int Id = Integer.parseInt(request.getParameter("id"));
		// String Photo = request.getParameter("image");
		Part part = request.getPart("image");
		String Photo = part.getSubmittedFileName();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mspr?useSSL=false", "root", "");
			PreparedStatement pst = con.prepareStatement(
					"update  utilisateur set Photo=?, Nom = ? ,Genre=?, Email=? , Password =?, Telephone=?  where Id =?");
			pst.setString(1, Photo);
			pst.setString(2, Nom);
			pst.setString(3, Genre);
			pst.setString(4, Email);
			pst.setString(5, Password);
			pst.setString(6, Telephone);
			pst.setInt(7, Id);

			request.setAttribute("message", "profil modifie avec success");
			pst.executeUpdate();
			request.setAttribute("message", "profil modifie avec success");
			request.getRequestDispatcher("index.js").forward(request, response);
			// response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
