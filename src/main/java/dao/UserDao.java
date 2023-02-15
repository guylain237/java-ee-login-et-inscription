/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.User;

public class UserDao {

	private Connection con;

	public UserDao(Connection con) {
		this.con = con;
	}

	// method to insert user to data base:
	public boolean saveUser(User user) {
		boolean f = false;
		try {
			// user -->database

			String query = "insert into utilisateur(Nom,Genre,Email,Password,Telephone)values(?,?,?,?,?)";
			PreparedStatement pstmt = this.con.prepareStatement(query);
			pstmt.setString(1, user.getNom());
			pstmt.setString(2, user.getGenre());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getTelephone());

			pstmt.executeUpdate();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

	// get user by useremail and userpassword:
	public User getUserByEmailAndPassword(String email, String password) {
		User user = null;

		try {

			String query = "select * from utilisateur where email =? and password=?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			ResultSet set = pstmt.executeQuery();

			if (set.next()) {
				user = new User();

//             data from db
				String name = set.getString("nom");
//             set to user object
				user.setNom(name);

				user.setId(set.getInt("id"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setGenre(set.getString("gender"));
				user.setTelephone(set.getString("telephone"));
				user.setDateTime(set.getTimestamp("date"));
				user.setProfile(set.getString("photo"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

	public boolean updateUser(User user) {

		boolean f = false;
		try {

			String query = "update utulisateur set Photo=? ,Nom=?, gender=?  , Email=? , Password=? ,Telephone? , where  Id =?";
			PreparedStatement p = con.prepareStatement(query);
			p.setString(1, user.getProfile());
			p.setString(2, user.getNom());
			p.setString(3, user.getGenre());
			p.setString(4, user.getEmail());
			p.setString(5, user.getPassword());
			p.setString(6, user.getTelephone());
			p.setInt(7, user.getId());
			p.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User getUserByUserId(int userId) {
		User user = null;
		try {
			String q = "select * from utilisateur where id=?";
			PreparedStatement ps = this.con.prepareStatement(q);
			ps.setInt(1, userId);
			ResultSet set = ps.executeQuery();
			if (set.next()) {
				user = new User();

//             data from db
				String name = set.getString("nom");
//             set to user object
				user.setNom(name);

				user.setId(set.getInt("id"));
				user.setEmail(set.getString("email"));
				user.setPassword(set.getString("password"));
				user.setGenre(set.getString("gender"));
				user.setTelephone(set.getString("telephone"));
				user.setDateTime(set.getTimestamp("date"));
				user.setProfile(set.getString("photo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
}
