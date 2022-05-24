package com.cmapp.tableModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.cmapp.entities.Contact;


public class ContactModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	public static final int OBJECT_COL = -1;
	
	private Vector<Object[]> rows = new Vector<>();
	
	private List<Contact> contacts = new ArrayList<>();
	
	private String[] columns = {"Id", "Nom", "Prenom", "Numero de Tel", "Adresse Email"};
	
	public ContactModel() {}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public int getRowCount() {		
		return rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case OBJECT_COL : return contacts.get(rowIndex);
			default : return rows.get(rowIndex)[columnIndex];
		}
	}

	public List<Contact> getContact() {
		return contacts;
	}
	
	@Override
	public String getColumnName(int column) {
		return columns[column];
	}
	
	public void setContact (List<Contact> users) {		
		rows.clear();
		this.contacts.clear();
		this.contacts.addAll(0, users);
		
		for (Contact contact : contacts ){			
			rows.add( new Object [] {
					contact.getId(), 
					contact.getNom(), 
					contact.getPrenom(),
					contact.getTelephone(),
					contact.getEmail()
				});
		}
		
		fireTableDataChanged();
	}
	
	public void delete(Contact contact) {
		int indexOf = contacts.indexOf(contact);
		contacts.remove(contact);
		rows.remove(indexOf);
		
		fireTableDataChanged();
	}
	
	public void update (int id,String nom,String prenom,String numero,String email) {
		Contact contact = new Contact(id,nom,prenom,numero,email);
		int indexOf = contacts.indexOf(contact);
		contacts.get(indexOf).setNom(nom);
		contacts.get(indexOf).setPrenom(prenom);
		contacts.get(indexOf).setTelephone(numero);
		contacts.get(indexOf).setEmail(email);
		
		Object [] obj = rows.get(indexOf);
		obj[0] = id;
		obj[1] = nom;
		obj[2] = prenom;
		obj[3] = numero;
		obj[4] = email;
		fireTableDataChanged();
	}
	public void add(int id,String nom,String prenom,String numero, String email) {
		Contact contact = new Contact(id,nom,prenom,numero, email);
		contacts.add(contact);
		rows.add( new Object [] {
				contact.getId(),
				contact.getNom(), 
				contact.getPrenom(),
				contact.getTelephone(),
				contact.getEmail()
		});
		
		fireTableDataChanged();
	}
	
	public void clear() {
		rows.clear();
		this.contacts.clear();
		
		fireTableDataChanged();
	}
}
