package com.cmapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cmapp.entities.Contact;
import com.cmapp.ui.UIAdministrateur;
import com.cmapp.ui.UIAuthentification;
import com.cmapp.ui.UIListe;
import com.cmapp.utilitaire.Utilitaire;
import com.cmapp.utils.Services;

public class AdministrateurController {
	private UIAdministrateur uiadministrateur;
	private UIListe uiliste = new UIListe();
	private UIAuthentification uiauthentiffication;
	private Services service;
	
	public AdministrateurController(UIAdministrateur uiadministrateur)
	{
		this.uiadministrateur = uiadministrateur;
		addListener();
		Utilitaire.getCurrentTime();
	}

	private void addListener() {
		uiadministrateur.addCreerListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nom = uiadministrateur.getNomField();
				String prenom = uiadministrateur.getPrenomField();
				
				String numero = uiadministrateur.getLoginField();
				String email = uiadministrateur.getPasswordField();
				Contact contact = new Contact(nom,prenom,numero,email);
				if(contact.getNom().compareTo("")== 0||contact.getPrenom().compareTo("")==0)
				{
					Utilitaire.displayErrorMessage("Veuille reseigner les champs......" );
				}
					service = new Services();
					try {
						service.ajouterUnContacts(contact);
						Utilitaire.displayNotification("Enregistrement du contact " + contact.getNom() + contact.getPrenom() + "Effectue avec success...");
						uiadministrateur.nottoyer();
					} catch (Exception e1) {
						Utilitaire.displayErrorMessage("Probleme d'enregistrement du contact..."+e1.getMessage());
					}
			}
		}
		);
		uiadministrateur.addUpdateListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int id = uiadministrateur.getIdField();
				String nom = uiadministrateur.getNomField();
				String prenom = uiadministrateur.getPrenomField();
				
				String numero = uiadministrateur.getLoginField();
				String email = uiadministrateur.getPasswordField();
				
				Contact contact = new Contact(id,nom,prenom,numero,email);
				if(contact.getNom().compareTo("")== 0|| contact.getPrenom().compareTo("")== 0 ) {
					Utilitaire.displayErrorMessage("Veuille selectionne un Utilisateur ......" );
				}else {
					service = new Services();
					try {
						service.mettreAJourUnContacts(contact);
						Utilitaire.displayNotification("Mis en Jour effctue  avec success...");
						uiadministrateur.nottoyer();
					} catch (Exception e1) {
						Utilitaire.displayErrorMessage("Error:"+ e1.getMessage());
					}
			}
			}
		});
		uiadministrateur.addListeListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				uiadministrateur.hide();
				Listercontroller listeControlleur = new Listercontroller(uiliste,uiauthentiffication);
				listeControlleur.run();
				
			}
			
		});
		uiadministrateur.addCancelListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				uiliste.setVisible(false);
				uiadministrateur.disposeFenetre();
				UIAuthentification uiAuthentification = new UIAuthentification();
				AuthentificationController authentificationController = new AuthentificationController(uiAuthentification);				
				authentificationController.run ();
			}
		
			
		});
		uiadministrateur.addSearchListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int elementCherche = uiadministrateur.getSaerchField();
				if(elementCherche > 0) {
					service = new Services();
					
				try {
					uiadministrateur.remplirchamp(service.rechercherUnContactsSelonSonId(elementCherche));
				} catch (Exception e1) {
					Utilitaire.displayErrorMessage("Cet utilisateur n'existe pas : " + e1.getMessage());
				}
			}else if(String.valueOf(elementCherche).compareTo("") == 0) {
				Utilitaire.displayNotification("Veuillez remplier le champs rechercher");
			}else {
				Utilitaire.displayErrorMessage("Cet utilisateur n'existe pas  ");
			}
				}
			
			
		});
		uiadministrateur.addClearListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				uiadministrateur.nottoyer();	
			}
		});
		
		uiadministrateur.adddeleteListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int id = uiadministrateur.getIdField();
				if(String.valueOf(id).compareTo("")== 0) {
					Utilitaire.displayNotification("Veuillez donne l'element a supprimer...");
				}else {
					service = new Services();
					try {
						service.supprimerUnContacts(id);
						Utilitaire.displayNotification("Utilisateur d'identifiant:"+ id + "a ete supprimer avec success");
						
					} catch (Exception e2) {
						Utilitaire.displayErrorMessage("Error: " + e2.getMessage());
					}
				uiadministrateur.nottoyer();
			 }
			}
			
		});
	}
	
	public void run() {
		
		uiadministrateur.setVisible(true);
		
		 
	}
}