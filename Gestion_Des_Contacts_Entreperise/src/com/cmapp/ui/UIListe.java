package com.cmapp.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import com.cmapp.entities.Contact;
import com.cmapp.tableModel.ContactModel;
import com.cmapp.utilitaire.Utilitaire;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.SystemColor;

public class UIListe extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable tableUser;
	private JButton buttonOuvrir;
	private JButton buttonFermer;
	private ContactModel contactmodel;
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public UIListe() {
		setFont(new Font("Verdana", Font.PLAIN, 13));
		setForeground(Color.BLUE);
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(new Dimension(929, 471));
		setResizable(false);
		setTitle("Visualiser les Utilisateurs");
		
		JPanel panelListeIncidents = new JPanel();
		panelListeIncidents.setBorder(new TitledBorder(null, "Liste Des Utlisateur ...", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panelListeIncidents, BorderLayout.CENTER);
		panelListeIncidents.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panelListeIncidents.add(scrollPane, BorderLayout.CENTER);
		
		tableUser = new JTable();
		
		contactmodel = new ContactModel();
		tableUser.setModel(contactmodel);
		scrollPane.setViewportView(tableUser);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBackground(new Color(0, 139, 139));
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		buttonOuvrir = new JButton("Ouvrir");
		Image ouv = new ImageIcon(this.getClass().getResource("/ouvrir.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		buttonOuvrir.setIcon(new ImageIcon(ouv));
		buttonOuvrir.setForeground(SystemColor.window);
		buttonOuvrir.setBackground(Color.GREEN);
		buttonOuvrir.setFont(new Font("Verdana", Font.BOLD, 12));
		panelButtons.add(buttonOuvrir);
		
		buttonFermer = new JButton("Fermer");
		Image fer = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		buttonFermer.setIcon(new ImageIcon(fer));
		buttonFermer.setForeground(SystemColor.window);
		buttonFermer.setBackground(Color.RED);
		buttonFermer.setFont(new Font("Verdana", Font.BOLD, 12));
		panelButtons.add(buttonFermer);	
		
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, this.getSize());
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void AddOuvrirListener(ActionListener actionListener) {
		buttonOuvrir.addActionListener(actionListener);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void AddFermerListener(ActionListener actionListener) {
		buttonFermer.addActionListener(actionListener);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public int getUserId() {		
		int idRow = tableUser.getSelectedRow();
		
		if (idRow == -1) return idRow;
		else {
			return (int) contactmodel.getValueAt(idRow, 0);
		}		
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void loadContact (List<Contact> contact) {
		contactmodel.setContact(contact);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void montre()
	{
		this.setVisible(true);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
}
