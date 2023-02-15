package entities;

import java.sql.Timestamp;

public class User {

	private int id;
	private String Nom;
	private String Genre;
	private String Email;
	private String Password;

	private Timestamp dateTime;
	private String Telephone;
	private String profile;

	public User(int id, String nom, String email, String password, String genre, Timestamp dateTime, String telephone,
			String profile) {
		super();
		this.id = id;
		Nom = nom;
		Genre = genre;
		Email = email;
		Password = password;

		this.dateTime = dateTime;
		Telephone = telephone;
		this.profile = profile;
	}

	public User(String nom, String email, String password, String genre, String telephone, String profile) {
		super();
		this.profile = profile;
		Nom = nom;
		Genre = genre;
		Email = email;
		Password = password;

		Telephone = telephone;

	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public String getTelephone() {
		return Telephone;
	}

	public void setTelephone(String telephone) {
		Telephone = telephone;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
