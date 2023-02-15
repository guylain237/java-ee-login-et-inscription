package com.servelet.client;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import com.client.helper.ConnectionProvider;
import com.client.helper.Helpers;

import dao.UserDao;
import entities.Message;
import entities.User;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class Modifier
 */
//@Before
public class Modifier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Modifier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "Short description";
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();

		String Email = request.getParameter("email");
		String Nom = request.getParameter("nom");
		String Password = request.getParameter("password");
		String Telephone = request.getParameter("telephone");
		// String imageName = request.getParameter("image");
		Part part = request.getPart("image");
		String imageName = part.getSubmittedFileName();

		// get the user from the session...
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentUser");
		String oldFile = user.getProfile();

		user.setProfile(imageName);
		user.setEmail(Email);
		user.setNom(Nom);
		user.setPassword(Password);
		user.setTelephone(Telephone);

		// update database....
		UserDao userDao = new UserDao(ConnectionProvider.getConnection());

		boolean ans = userDao.updateUser(user);
		if (ans) {

			String path = request.getRealPath("/") + "pics" + File.separator + user.getProfile();

			// start of photo work
			// delete code
			String pathOldFile = request.getRealPath("/") + "pics" + File.separator + oldFile;

			if (!oldFile.equals("default.png")) {
				Helpers.deleteFile(pathOldFile);
			}

			if (Helpers.saveFile(part.getInputStream(), path)) {
				out.println("Profile updated...");
				Message msg = new Message("Profile details updated...", "success", "alert-success");
				s.setAttribute("msg", msg);

			} else {
				//////////////
				Message msg = new Message("Something went wrong..", "error", "alert-danger");
				s.setAttribute("msg", msg);
			}

			// end of phots work
		} else {
			out.println("not updated..");
			Message msg = new Message("Something went wrong..", "error", "alert-danger");
			s.setAttribute("msg", msg);

		}

		response.sendRedirect("index.jsp");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String Email = request.getParameter("email");
		String Nom = request.getParameter("nom");
		String Genre = request.getParameter("genre");
		String Password = request.getParameter("password");
		String Telephone = request.getParameter("telephone");
		// String imageName = request.getParameter("image");
		Part part = request.getPart("image");
		String imageName = part.getSubmittedFileName();

		// get the user from the session...
		HttpSession s = request.getSession();
		User user = (User) s.getAttribute("currentUser");
		String oldFile = user.getProfile();
		user.setProfile(imageName);
		user.setNom(Nom);
		user.setGenre(Genre);
		user.setEmail(Email);
		user.setPassword(Password);
		user.setTelephone(Telephone);

		// update database....
		UserDao userDao = new UserDao(ConnectionProvider.getConnection());

		boolean ans = userDao.updateUser(user);
		if (ans) {

			String path = request.getRealPath("/") + "pics" + File.separator + user.getProfile();

			// start of photo work
			// delete code
			String pathOldFile = request.getRealPath("/") + "pics" + File.separator + oldFile;

			if (!oldFile.equals("default.png")) {
				Helpers.deleteFile(pathOldFile);
			}

			if (Helpers.saveFile(part.getInputStream(), path)) {
				out.println("Profile updated...");
				Message msg = new Message("Profile details updated...", "success", "alert-success");
				s.setAttribute("msg", msg);

			} else {
				//////////////
				Message msg = new Message("Something went wrong..", "error", "alert-danger");
				s.setAttribute("msg", msg);
			}

			// end of phots work
		} else {
			out.println("not updated..");
			Message msg = new Message("Something went wrong..", "error", "alert-danger");
			s.setAttribute("msg", msg);

		}

		response.sendRedirect("index.jsp");
	}

}
