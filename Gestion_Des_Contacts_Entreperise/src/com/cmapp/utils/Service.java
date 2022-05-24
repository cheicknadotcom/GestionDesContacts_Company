 package com.cmapp.utils;

import java.util.List;

import com.cmapp.entities.Contact;
import com.cmapp.entities.Contacts;
import com.cmapp.entities.User;
import com.cmapp.exceptions.ContactManagerException;
import com.cmapp.utilitaire.Utilitaire;
import com.esmt.formation.java.clavier.Clavier;

public class Service implements IService {
	@Override
	public void creerNouvelleListe() throws ContactManagerException {
		System.out.println("\n- DEBUT - CREATION NOUVELLE LISTE - ");
		String fileName = getDataSource();
		if (!fileName.equals("default")) {
			ContactManager.setFileName(fileName);
		}
		
		ContactManager.serialiseContacts(new Contacts());
		System.out.println("\n- FIN - CREATION NOUVELLE LISTE - ");
	}
	@Override
	public void ajouterUnContact() throws ContactManagerException {
		
		System.out.println("\n- DEBUT - AJOUT DE CONTACT - ");
	
		String fileName = getDataSource();
		if (!fileName.equals("default")) {
			ContactManager.setFileName(fileName);
		}
		Contact contact = ContactManager.lireContact();
		
		ContactManager.addContact(contact);		
		System.out.println("Ajout effectué avec succès.");
		System.out.println("\n- FIN - AJOUT DE CONTACT - ");
		}
	private String getDataSource () {
		
		System.out.println("Entrez le nom du fichier de contact svp (tapez 'default' si vous utilisez le fichier par defaut) : ");
		return Clavier.lireString();
	}
	@Override
	public void afficherLaListeDesContacts() throws ContactManagerException {
		System.out.println("\n- DEBUT - AFFICHER LA LISTE DE CONTACTS - ");
		String fileName = getDataSource();
		if (!fileName.equals("default")) {
			ContactManager.setFileName(fileName);
		}
		
		ContactManager.displayContacts();
		System.out.println("\n- FIN - AFFICHER LA LISTE DE CONTACTS - ");
	}

	@Override
	public void rechercherUnContactSelonSonId() throws ContactManagerException{
		
		@SuppressWarnings("unused")
		Contact contact = new Contact();
		Contacts contacts = ContactManager.deserialiseContacts();
		List<Contact> list = contacts.getListe();
		System.out.println("Entrer l'identifiant du contatct à rechercher svp !!");
		int idContact = Clavier.lireInt();
		
		if(contacts.find(idContact) != null)
		{

			for(int i = 0; i < list.size(); i ++)
			{
				if(list.get(i).getId() == idContact)
					System.out.println(list.get(i).toString());
			}
		}

		else
			System.out.println(" Désolé !. Ce contact n'existe pas ");

	}
	

	@SuppressWarnings("unused")
	@Override
	public void rechercherUnContactSelonSonNom() throws ContactManagerException {
		
		Contact contact = new Contact();
		Contacts contacts = ContactManager.deserialiseContacts();
		List<Contact> list = contacts.getListe();
		System.out.println("Entrer le nom du contatct à rechercher svp !!");
		String nomContact = Clavier.lireString();
		
		if(contacts.find(nomContact) != null)
		{
			for(int i = 0; i < list.size(); i ++)
			{
				if(list.get(i).getNom().equals(nomContact))
					System.out.println(list.get(i).toString());
			}
		}		
		else
			System.out.println("Désolé!. Ce contact n'existe pas ");

	}

	@SuppressWarnings("unused")
	@Override
	public void supprimerUnContact() throws ContactManagerException {
		
		
		Contacts contacts = ContactManager.deserialiseContacts();
		Contact contact = new Contact();
		List<Contact> list = contacts.getListe();
		System.out.println("Entrer l'identifiant du contact dont vous souhaitez supprimer svp !");
		int idContactASupprimer = Clavier.lireInt();
		
		if(contacts.find(idContactASupprimer) != null)
		{
			contacts.delete(idContactASupprimer);  
			ContactManager.serialiseContacts(contacts);
			
		}
		else
			System.out.println(" Désolé!. Ce contact n'existe pas ");
		

	}

	@SuppressWarnings("unused")
	@Override
	public void mettreAJourUnContact() throws ContactManagerException {
		
		
		Contacts contacts = ContactManager.deserialiseContacts();
		Contact contact = new Contact();
		List<Contact> list = contacts.getListe();
		System.out.println("Entrer l'identifiant du contact dont vous souhaitez mettre à svp !");
		int idContactAMettreAJour = Clavier.lireInt();
		for(int i= 0; i< list.size(); i ++) 
		{
			if(list.get(i).getId() == idContactAMettreAJour)
			{
				System.out.println("Tapez 1 pour modifier le nom, 2 pour le prenom, 3 pour le telephone, 4 pour l'email");
				int choix = Clavier.lireInt();
				switch(choix)
				{
				    case 1: System.out.println("Tapez le nouveau nom svp");
				    String newName = Clavier.lireString();
				    list.get(i).setNom(newName);
				    break;
				    
				    case 2: System.out.println("Tapez le nouveau prénom svp");
				    String newLastName = Clavier.lireString();
				    list.get(i).setPrenom(newLastName);
				    break;
				    
				    case 3: System.out.println("Tapez le nouveau numéro svp");
				    String newPhone = Clavier.lireString();
				    list.get(i).setTelephone(newPhone);
				    break;
				    
				    case 4: System.out.println("Tapez le nouveau email svp");
				    String newEmail = Clavier.lireString();
				    list.get(i).setEmail(newEmail);
				    break;
				}
				ContactManager.serialiseContacts(contacts);
				
			}
			ContactManager.updateContact(list.get(i));
		}
			
		
	}



	@Override
	public void mettreAJourUnContacts(Contact contact) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void ajouterUnContacts(Contact contact) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Contact rechercherUnContactsSelonSonId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Contact rechercherUnContactsSelonSonNom(String nom) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void supprimerUnContacts(int id) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Contact> rechercherListeContactsSelonSonId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Contact> getListeContacts() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User authentifier(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
