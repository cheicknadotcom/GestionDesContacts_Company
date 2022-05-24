package com.cmapp.entities;

public class User {
	//Les attributs d'instance de la classe user
	private int id;
	private String login;
	private String password;
	//Les construsteurs de la classe user
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	public User(int id, String login, String password) {
		this(login,password);
		this.id = id;
	}
	//Les getters et setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//le toString d'affiche de l'objet user
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
	
}
