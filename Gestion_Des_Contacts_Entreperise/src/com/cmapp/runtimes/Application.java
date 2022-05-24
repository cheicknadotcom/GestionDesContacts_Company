package com.cmapp.runtimes;

import com.cmapp.controller.AuthentificationController;
import com.cmapp.ui.UIAuthentification;

public class Application {

	public static void main(String[] args) {
		UIAuthentification uiAuthentification = new UIAuthentification();
		AuthentificationController authentificationController = new AuthentificationController(uiAuthentification);
		
		authentificationController.run ();
	}

}
 