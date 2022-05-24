package com.cmapp.utils;

import java.util.List;

import com.cmapp.entities.Contact;
import com.cmapp.entities.Contacts;
import com.cmapp.entities.User;
import com.cmapp.exceptions.ContactManagerException;

public class Services implements IService{

	@Override
	public void creerNouvelleListe() throws ContactManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ajouterUnContact() throws ContactManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afficherLaListeDesContacts() throws ContactManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rechercherUnContactSelonSonId() throws ContactManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rechercherUnContactSelonSonNom() throws ContactManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public  void supprimerUnContact() throws ContactManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mettreAJourUnContact() throws ContactManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mettreAJourUnContacts(Contact contact) throws Exception {
		Contacts cont = new Contacts();
		cont.updates(contact);
		
	}

	@Override
	public void ajouterUnContacts(Contact contact) throws Exception {
		Contacts cont = new Contacts();
		cont.ajouterConctact(contact);	
	}

	@Override
	public Contact rechercherUnContactsSelonSonId(int id) throws Exception {
		Contacts cont = new Contacts();
		return cont.recherchesContactById(id);	
	}
 
	@Override
	public Contact rechercherUnContactsSelonSonNom(String nom) throws Exception {
		Contacts cont = new Contacts();
		return cont.recherchesContactByNom(nom);	
	}

	@Override
	public void supprimerUnContacts(int id) throws Exception {
		Contacts cont = new Contacts();
		
		cont.deletes(id);
	}

	@Override
	public List<Contact> rechercherListeContactsSelonSonId(int id) throws Exception {
		Contacts contact = new Contacts();
		return contact.recherchesListeContactById(id);
	}

	@Override
	public List<Contact> getListeContacts() throws Exception {
		Contacts cont = new Contacts();
		return cont.getListeContact();
	}

	@Override
	public User authentifier(String login, String password) throws Exception {
		Contacts cont = new Contacts();
		return cont.authentification(login, password);
	}
}
