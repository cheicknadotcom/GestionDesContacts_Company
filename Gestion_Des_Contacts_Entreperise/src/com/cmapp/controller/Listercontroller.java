package com.cmapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.cmapp.entities.Contact;
import com.cmapp.ui.UIAdministrateur;
import com.cmapp.ui.UIAuthentification;
import com.cmapp.ui.UIListe;
import com.cmapp.utilitaire.Utilitaire;
import com.cmapp.utils.Services;


public class Listercontroller {

	private UIAdministrateur uiadministrateur;
	private AdministrateurController controller;
	private UIAuthentification uIauthentification;
	private UIListe uiliste;
	Services service;
	public AdministrateurController getController() {
		return controller;
	}

	public void setController(AdministrateurController controller) {
		this.controller = controller;
	}

	public UIAuthentification getuIauthentification() {
		return uIauthentification;
	}

	public void setuIauthentification(UIAuthentification uIauthentification) {
		this.uIauthentification = uIauthentification;
	}

	public Listercontroller(UIListe uiliste,UIAuthentification uIauthentification)
	{
		this.uiliste = uiliste;
		this.uIauthentification = uIauthentification;
		
		List<Contact> contact = new ArrayList<Contact>();
		
		try {
			//user = Service.listerUser();
			service = new Services();
			contact = service.getListeContacts();
			uiliste.loadContact(contact);
		} catch (Exception e) {
			Utilitaire.displayErrorMessage("Error :" + e.getMessage());
		}
		addListener();
	}

	private void addListener() {
		uiliste.AddOuvrirListener(new ActionListener() {
			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				uiliste.setVisible(false);
				int id = uiliste.getUserId();
				if(id != -1) {
				try {
					service = new Services();
					//User user = Service.giveUser(id);
					Contact cont = service.rechercherListeContactsSelonSonId(id).get(0);
					
					UIAdministrateur uiadministrateur = new UIAdministrateur();
					AdministrateurController controller = new AdministrateurController(uiadministrateur);
					controller.run();
				} catch (Exception e1) {
					Utilitaire.displayErrorMessage("Error :" + e1.getMessage());
				}	
			}
			}
			
		});
		uiliste.AddFermerListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				uiliste.dispose();
				uiadministrateur = new UIAdministrateur();
				controller = new AdministrateurController(uiadministrateur);
				controller.run();
			}
			
		});
		
	}

	public void run() {
		uiliste.setVisible(true);
	}

}
