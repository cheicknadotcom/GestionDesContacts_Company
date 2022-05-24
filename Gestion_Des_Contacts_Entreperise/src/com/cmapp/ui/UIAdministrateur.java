package com.cmapp.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.cmapp.entities.Contact;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;


public class UIAdministrateur extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField NomField;
	private JTextField PrenomField;
	private JTextField LoginField;
	private JTextField saerchField;
	private JTextField idField;
	private JButton createButton;
	private JButton updateButton;
	private JButton deleteButton;
	private JButton clearButton;
	private JButton searchButton;
	private JButton listeButton;
	private JButton cancelButton;
	private JComboBox<String> comboBox;
	private Contact contact;
	private JPanel panel;
	private JLabel Labelvague;
	private JTextField passwordField;
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public Contact getUser() {
		return contact;
	}
	public void setUser(Contact contact) {
		this.contact = contact;
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UIAdministrateur() {
		getContentPane().setForeground(Color.BLUE);
		setResizable(false);
		setFont(new Font("Verdana", Font.PLAIN, 12));
		getContentPane().setFont(new Font("Dialog", Font.BOLD, 14));
		getContentPane().setBackground(Color.BLUE);
		setForeground(Color.GREEN);
		setBackground(SystemColor.inactiveCaptionBorder);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Administrateur");
		this.setSize(811, 417);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 139, 139));
		panel_1.setBounds(111, 315, 681, 44);
		getContentPane().add(panel_1);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		createButton = new JButton("CREATE");
		Image create = new ImageIcon(this.getClass().getResource("/valide.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		createButton.setIcon(new ImageIcon(create));
		createButton.setForeground(SystemColor.window);
		createButton.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(createButton, "2, 2");
		createButton.setBackground(Color.GREEN);
		
		updateButton = new JButton("UPDATE");
		Image update = new ImageIcon(this.getClass().getResource("/update.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		updateButton.setIcon(new ImageIcon(update));
		updateButton.setForeground(SystemColor.window);
		updateButton.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(updateButton, "6, 2");
		updateButton.setBackground(new Color(72, 61, 139));
		
		 deleteButton = new JButton("DELETE");
		 Image delete = new ImageIcon(this.getClass().getResource("/delete.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		 deleteButton.setIcon(new ImageIcon(delete));
		 deleteButton.setForeground(SystemColor.window);
		 deleteButton.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(deleteButton, "10, 2");
		deleteButton.setBackground(Color.RED);
		
		 clearButton = new JButton("CLEAR");
		 Image clear = new ImageIcon(this.getClass().getResource("/clear.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		 clearButton.setIcon(new ImageIcon(clear));
		 clearButton.setForeground(SystemColor.window);
		 clearButton.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(clearButton, "14, 2");
		clearButton.setBackground(Color.ORANGE);
		
		 listeButton = new JButton("LISTE");
		 Image liste = new ImageIcon(this.getClass().getResource("/submit.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		 listeButton.setIcon(new ImageIcon(liste));
		 listeButton.setForeground(SystemColor.window);
		 listeButton.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(listeButton, "18, 2");
		listeButton.setBackground(new Color(65, 105, 225));
		
		cancelButton = new JButton("CANCEL");
		Image cancel = new ImageIcon(this.getClass().getResource("/cancel.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		cancelButton.setIcon(new ImageIcon(cancel));
		cancelButton.setForeground(SystemColor.window);
		cancelButton.setFont(new Font("Dialog", Font.BOLD, 14));
		panel_1.add(cancelButton, "22, 2");
		cancelButton.setBackground(new Color(255, 69, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 139, 139));
		panel_2.setBounds(10, 8, 323, 252);
		getContentPane().add(panel_2);
		panel_2.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel idLabel = new JLabel("Id");
		idLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		panel_2.add(idLabel, "2, 2");
		
		idField = new JTextField();
		idField.setFont(new Font("Verdana", Font.PLAIN, 14));
		idField.setEnabled(false);
		panel_2.add(idField, "8, 2, 7, 1, fill, default");
		idField.setColumns(10);
		
		JLabel NomLabel = new JLabel("Nom");
		NomLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_2.add(NomLabel, "2, 4");
		
		NomField = new JTextField();
		NomField.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_2.add(NomField, "8, 4, 7, 1");
		NomField.setColumns(10);
		
		JLabel PrenomLabel = new JLabel("Prenom");
		PrenomLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_2.add(PrenomLabel, "2, 6");
		
		PrenomField = new JTextField();
		PrenomField.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_2.add(PrenomField, "8, 6, 7, 1");
		PrenomField.setColumns(10);
		
		JLabel LoginLabel = new JLabel("Numero");
		LoginLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_2.add(LoginLabel, "2, 8");
		
		LoginField = new JTextField();
		LoginField.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_2.add(LoginField, "8, 8, 7, 1");
		LoginField.setColumns(10);
		
		JLabel PasswordLabel = new JLabel("Email");
		PasswordLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_2.add(PasswordLabel, "2, 10");
		
		passwordField = new JTextField();
		passwordField.setFont(new Font("Verdana", Font.BOLD, 11));
		panel_2.add(passwordField, "8, 10, 7, 1, fill, default");
		passwordField.setColumns(10);
			
			panel = new JPanel();
			panel.setBackground(new Color(0, 128, 128));
			panel.setBounds(343, 11, 449, 33);
			getContentPane().add(panel);
			panel.setLayout(new GridLayout(1, 0, 0, 0));
				
				JLabel lblNewLabel_4 = new JLabel("Rechercher ");
				panel.add(lblNewLabel_4);
				lblNewLabel_4.setBackground(SystemColor.inactiveCaptionBorder);
				lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 14));
			
				comboBox = new JComboBox();
				panel.add(comboBox);
				comboBox.setForeground(Color.WHITE);
				comboBox.setFont(new Font("Verdana", Font.BOLD, 14));
				comboBox.addItem("ID");
			
			saerchField = new JTextField();
			panel.add(saerchField);
			saerchField.setFont(new Font("Verdana", Font.PLAIN, 14));
			saerchField.setColumns(10);
			
			searchButton = new JButton("SEARCH");
			Image search = new ImageIcon(this.getClass().getResource("/search.png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
			searchButton.setIcon(new ImageIcon(search));
			panel.add(searchButton);
			searchButton.setForeground(Color.WHITE);
			searchButton.setFont(new Font("Verdana", Font.BOLD, 14));
			searchButton.setBackground(new Color(0, 0, 128));
			
			JLabel Labelimg = new JLabel("");
			Image admi = new ImageIcon(this.getClass().getResource("/tel.png")).getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH);
			Labelimg.setIcon(new ImageIcon(admi));
			Labelimg.setBounds(517, 55, 193, 237);
			getContentPane().add(Labelimg);
			
			Labelvague = new JLabel("");
			Image vague = new ImageIcon(this.getClass().getResource("/vague.png")).getImage().getScaledInstance(370, 65, Image.SCALE_SMOOTH);
			Labelvague.setIcon(new ImageIcon(vague));
			Labelvague.setBounds(10, 271, 323, 44);
			getContentPane().add(Labelvague);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public int  getIdField() {
		return Integer.parseInt(idField.getText());
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void addCreerListener(ActionListener actionListener)
	{
		this.createButton.addActionListener(actionListener);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void addUpdateListener(ActionListener actionListener)
	{
		this.updateButton.addActionListener(actionListener);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void addClearListener(ActionListener actionListenr)
	{
		this.clearButton.addActionListener(actionListenr);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void adddeleteListener(ActionListener actionLstener)
	{
		this.deleteButton.addActionListener(actionLstener);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void addListeListener(ActionListener actionListener)
	{
		this.listeButton.addActionListener(actionListener);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void addCancelListener(ActionListener actionListener)
	{
		this.cancelButton.addActionListener(actionListener);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void addSearchListener(ActionListener actionListener)
	{
		this.searchButton.addActionListener(actionListener);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void addRemplirChampListener(Contact contact)
	{
		this.idField.setColumns(contact.getId());
		this.NomField.setName(contact.getNom());
		this.PrenomField.setName(contact.getPrenom());
		this.LoginField.setName(contact.getTelephone());
		this.passwordField.setName(contact.getEmail());
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public String getNomField() {
		return NomField.getText();
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void setNomField(JTextField nomField) {
		NomField = nomField;
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public String getPrenomField() {
		return PrenomField.getText();
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void setPrenomField(JTextField prenomField) {
		PrenomField = prenomField;
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public String getLoginField() {
		return LoginField.getText();
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void setLoginField(JTextField loginField) {
		LoginField = loginField;
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public String getPasswordField() {
		return String.valueOf(this.passwordField.getText());
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public int  getSaerchField() {
		return Integer.parseInt(saerchField.getText());
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void setSaerchField(JTextField saerchField) {
		this.saerchField = saerchField;
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void setIdField( JTextField idField) {
		this.idField = idField;
	}

	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void remplirchamp(Contact contact)
	{
		idField.setEnabled(true);
		idField.setText(String.valueOf(contact.getId()));
		NomField.setText(contact.getNom());
		PrenomField.setText(contact.getPrenom());
		
		LoginField.setText(contact.getTelephone());
		passwordField.setText(contact.getEmail());
		
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public Contact remplirchamps(Contact contact)
	{
		idField.setEnabled(true);
		idField.setText(String.valueOf(contact.getId()));
		NomField.setText(contact.getNom());
		PrenomField.setText(contact.getPrenom());
		
		LoginField.setText(contact.getTelephone());
		passwordField.setText(contact.getEmail());
		
		return contact;
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public Contact remplirchampreturn(Contact contact)
	{
		idField.setEnabled(true);
		idField.setText(String.valueOf(contact.getId()));
		NomField.setText(contact.getNom());
		PrenomField.setText(contact.getPrenom());
		
		LoginField.setText(contact.getTelephone());
		passwordField.setText(contact.getEmail());
		return contact;
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void nottoyer() {
		idField.setEnabled(false);
		NomField.setText(null);
		PrenomField.setText(null);
		saerchField.setText(null);
		LoginField.setText(null);
		passwordField.setText(null);
		idField.setText(null);
	}
	/*---------------------------------------------------------------------------------------------------------------------------*/	
	public void disposeFenetre()
	{
		this.setVisible(false);
	}
}
