package com.cmapp.entities;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.cmapp.dbManager.DBManager;
import com.cmapp.exceptions.ContactManagerException;
import com.cmapp.utils.ContactManager;


public class Contacts implements Serializable, IContacts {
	private static final long serialVersionUID = -6741931543013158652L;

	private List<Contact> liste;

	public Contacts() {
		liste = new ArrayList<>();
	}

	public List<Contact> getListe() {
		return liste;
	}

	@Override
	public void sort() {
		Collections.sort(liste);
	}

	@Override
	public void sort(Comparator<Contact> comparator) {
		Collections.sort(liste, comparator);
	}

	@Override
	public void delete(int id) {
		int position = Collections.binarySearch(liste, find(id));
		try{
			liste.remove(Math.abs(position));
		}catch (IndexOutOfBoundsException ignored){}
	}
	@Override
	public void update(Contact contact) {
		delete(contact.getId());
		add(contact);
		
	}

	@Override
	public void add(Contact contact) {
		int position = Collections.binarySearch(liste, contact);
		liste.add(Math.abs(position) - 1, contact);
	}

	@Override
	public Contact find(int id) {
		for (int i = 0 ; i < liste.size() ; i ++) {
			if (liste.get(i).getId() == id) {
				return liste.get(i);
			}
		}
		
		return null;
	}

	@Override
	public Contact find(String nom) {
		for (int i = 0 ; i < liste.size() ; i ++) {
			if (liste.get(i).getNom().equals(nom)) {
				return liste.get(i);
			}
		}
		
		return null;
	}
	
	/**
	 * @return
	 * @throws ContactManagerException
	 */
	public static int getUniqueId () throws ContactManagerException {
		
		Contacts contacts = ContactManager.deserialiseContacts();
		List<Contact> liste = contacts.getListe();
		if (liste.isEmpty()) return 1;
		
		int maxId = Collections.max(liste).getId();		
		return maxId + 1;
	}

	@Override
	public String toString() {
		return "Contacts [liste=\n" + liste + "\n]";
	}

	@Override
	public void deletes(int id) throws Exception {
		Connection conn = DBManager.getConnection();
		String query = "Delete from T_contact Where id=?";
		PreparedStatement prepare = conn.prepareStatement(query);
		
		prepare.setInt(1, id);
		prepare.execute();
		conn.close();
	}

	@Override
	public void updates(Contact contact) throws Exception {
		Connection conn = DBManager.getConnection();
		String query = "Update T_contact Set nom=?,prenom=?,numero=?,email=?";
		PreparedStatement prepare = conn.prepareStatement(query);
		prepare.setString(1, contact.getNom());
		prepare.setString(2, contact.getPrenom());
		prepare.setString(3, contact.getTelephone());
		prepare.setString(4, contact.getEmail());
		prepare.execute();
		conn.close();
	}

	@Override
	public void ajouterConctact(Contact contact) throws Exception {
		Connection conn = DBManager.getConnection();
		
		String query = "Insert Into T_contact(nom,prenom,numero,email) values (?,?, ?, ?)";
		
		PreparedStatement prepare = conn.prepareStatement(query);
		
		prepare.setString(1, contact.getNom());
		prepare.setString(2, contact.getPrenom());
		prepare.setString(3, contact.getTelephone());
		prepare.setString(4, contact.getEmail());
		
		prepare.execute();
		conn.close();
	}

	@Override
	public Contact recherchesContactById(int id) throws Exception {
		Connection conn = DBManager.getConnection();
		List<Contact> list = new ArrayList<Contact>();
		String query = "Select * from where id=?";
		PreparedStatement prepare = conn.prepareStatement(query);
		prepare.setInt(1, id);
		ResultSet result = prepare.executeQuery();
		if(result.next()) {
			int idd = result.getInt("id");
			String nom = result.getString("nom");
			String prenom = result.getString("prenom");
			String tel = result.getString("numero");
			String email = result.getString("email");
			Contact contact = new Contact(idd,nom,prenom,tel,email);
			
			list.add(contact);
		}
		conn.close();
		return list.get(0);
	}
	public List<Contact> recherchesListeContactById (int id) throws Exception
	{
		Connection conn = DBManager.getConnection();
		List<Contact> list = new ArrayList<Contact>();
		String query = "Select * from T_contact where id=?";
		PreparedStatement prepare = conn.prepareStatement(query);
		prepare.setInt(1, id);
		ResultSet result = prepare.executeQuery();
		if(result.next()) {
			int idd = result.getInt("id");
			String nom = result.getString("nom");
			String prenom = result.getString("prenom");
			String tel = result.getString("numero");
			String email = result.getString("email");
			Contact contact = new Contact(idd,nom,prenom,tel,email);
			
			list.add(contact);
		}
		conn.close();
		return list;
	}
	@Override
	public Contact recherchesContactByNom(String nom) throws Exception {
		Connection conn = DBManager.getConnection();
		List<Contact> list = new ArrayList<Contact>();
		String query = "Select * from T_contact  where nom=?";
		PreparedStatement prepare = conn.prepareStatement(query);
		prepare.setString(1, nom);
		ResultSet result = prepare.executeQuery();
		if(result.next()) {
			int idd = result.getInt("id");
			String name = result.getString("nom");
			String prenom = result.getString("prenom");
			String tel = result.getString("numero");
			String email = result.getString("email");
			Contact contact = new Contact(idd,name,prenom,tel,email);
			
			list.add(contact);
		}
		conn.close();
		return list.get(0);
	}

	@Override
	public List<Contact> getListeContact() throws Exception {
		Connection conn = DBManager.getConnection();
		List<Contact> list = new ArrayList<Contact>();
		String query = "Select * from T_contact";
		PreparedStatement prepare = conn.prepareStatement(query);
		ResultSet result = prepare.executeQuery();
		while(result.next()) {
			int idd = result.getInt("id");
			String name = result.getString("nom");
			String prenom = result.getString("prenom");
			String tel = result.getString("numero");
			String email = result.getString("email");
			Contact contact = new Contact(idd,name,prenom,tel,email);
			
			list.add(contact);
		}
		conn.close();
		return list;
	}

	@Override
	public User authentification(String login, String password) throws Exception {
		Connection conn = DBManager.getConnection();
		
		String query = "Select * from T_user Where login=? And password=?";
		
		PreparedStatement prepare = conn.prepareStatement(query);
		prepare.setString(1, login);
		prepare.setString(2,password);
		prepare.execute();
		ResultSet result = prepare.executeQuery();
		if(result.next()) {
			int id = result.getInt("id");
			String logins = result.getString("login");
			String pass = result.getString("password");
			return new User(id,logins,pass);
		}
		return null;
	}
}
