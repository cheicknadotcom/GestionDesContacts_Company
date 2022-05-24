package com.cmapp.utils;

import java.util.List;

import com.cmapp.entities.Contact;
import com.cmapp.entities.User;
import com.cmapp.exceptions.ContactManagerException;

public interface IService {	
	public void creerNouvelleListe () throws ContactManagerException;
	public void ajouterUnContact () throws ContactManagerException;
	public void afficherLaListeDesContacts () throws ContactManagerException;
	public void rechercherUnContactSelonSonId () throws ContactManagerException;
	public void rechercherUnContactSelonSonNom () throws ContactManagerException;
	public void supprimerUnContact () throws ContactManagerException;
	public void mettreAJourUnContact () throws ContactManagerException;
	public void mettreAJourUnContacts (Contact contact) throws Exception;
	public void ajouterUnContacts (Contact contact) throws Exception;
	public Contact rechercherUnContactsSelonSonId (int id) throws Exception;
	public Contact rechercherUnContactsSelonSonNom (String nom) throws Exception;
	public void supprimerUnContacts (int id) throws Exception;
	public List<Contact> rechercherListeContactsSelonSonId (int id) throws Exception;
	public List<Contact> getListeContacts () throws Exception;
	public User authentifier(String login,String password) throws Exception;
}