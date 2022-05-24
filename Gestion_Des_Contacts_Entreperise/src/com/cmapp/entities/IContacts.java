package com.cmapp.entities;

import java.util.Comparator;
import java.util.List;

/**
 * @author Cheickna Doumbia
 *
 */
public interface IContacts{
	/**
	 * 
	 */
	public void sort ();
	/**
	 * @param comparator
	 */
	public void sort (Comparator<Contact> comparator);
	/**
	 * @param id
	 */
	public void delete (int id);
	/**
	 * @param contact
	 * @throws Exception 
	 */
	public void deletes (int id) throws Exception;
	/**
	 * @param contact
	 */
	public void update (Contact contact);
	/**
	 * @param contact
	 * @throws Exception 
	 */
	public void updates (Contact contact) throws Exception;
	/**
	 * @param contact
	 */
	public void add (Contact contact);
	/**
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public void ajouterConctact (Contact contact) throws Exception;
	/**
	 * @param id
	 * @return
	 */
	public Contact find (int id);
	/**
	 * @param nom
	 * @return
	 * @throws Exception 
	 */
	public Contact recherchesContactById (int id) throws Exception;
	/**
	 * @param nom
	 * @return
	 */
	public List<Contact> recherchesListeContactById (int id) throws Exception;
	/**
	 * @param nom
	 * @return
	 */
	public List<Contact> getListeContact () throws Exception;
	/**
	 * @param nom
	 * @return
	 */
	public Contact find (String nom);
	public Contact recherchesContactByNom (String nom) throws Exception;
	/**
	 * @param nom
	 * @return
	 * @throws Exception 
	 */
	public User authentification(String login,String password) throws Exception;
}
