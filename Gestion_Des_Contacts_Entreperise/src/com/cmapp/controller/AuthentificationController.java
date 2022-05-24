package com.cmapp.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.cmapp.entities.User;
import com.cmapp.ui.UIAdministrateur;
import com.cmapp.ui.UIAuthentification;
import com.cmapp.utilitaire.Utilitaire;
import com.cmapp.utils.Services;

public class AuthentificationController {

	private UIAuthentification uiAuthentification;
	private Services service;
	public AuthentificationController(UIAuthentification uiAuthentification) {
		this.uiAuthentification = uiAuthentification;
		
		addListeners();
	}
	
	private void addListeners () {
		
		uiAuthentification.addValiderListener ( new ActionListener() {			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String login = uiAuthentification.getLogin();
				String password = uiAuthentification.getPassword();
				service = new Services();
				User status;
				try {
					status = service.authentifier(login, password);
					if(status.getLogin().compareTo("null")==0 && status.getPassword().compareTo("null")==0) {
						uiAuthentification.dispose();
					}
					UIAdministrateur uiadministrateur = new UIAdministrateur();
					AdministrateurController administrateur = new AdministrateurController(uiadministrateur);
					administrateur.run();
					uiAuthentification.dispose();
				} catch (Exception e2) {
					Utilitaire.displayErrorMessage("Erreur d'authentification " + e2.getMessage());
				}
				if (login.equals("") || password.equals("")) {
					
					Utilitaire.displayNotification("Renseigne les champs correctement svp....");
					return;
				}
			}
		});
		
		uiAuthentification.addQuitterListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				uiAuthentification.dispose();				
			}
		});
	}

	public void run() {
		uiAuthentification.montrer();
	}
}
