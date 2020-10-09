package root;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Gwenaël
 * @date 28/09/2020
 * @version 1
 */

public class Secretaire extends Employe {
	private ArrayList<Manager> mManager = new ArrayList<>();
	
	/***
	 * Constructeur
	 * @param leNom
	 * @param lePrenom
	 * @param date
	 * @param addr
	 * @param embauche
	 * @param salaire
	 */
	private Secretaire(String leNom, String lePrenom, GregorianCalendar date, Adresse addr, GregorianCalendar embauche, float salaire)
	{ super(leNom, lePrenom, date, addr, embauche, salaire); }

	/*** Class Methods ***/
	/**
	 * Creation de la classe
	 * @param leNom
	 * @param lePrenom
	 * @param date
	 * @param addr
	 * @param embauche
	 * @param salaire
	 * @return Instance crée ou null si not 16 < age < 65
	 */
	public static Secretaire createSecretaire(String leNom,String lePrenom, GregorianCalendar date, Adresse addr,
			GregorianCalendar embauche, float salaire)
	{
		Secretaire toReturn = null;
		
		if(Employe.ageValide(date, embauche))
			toReturn = new Secretaire(leNom, lePrenom, date, addr, embauche, salaire);
		
		return toReturn;
	}
	
	/**
	 * Creation de la classe
	 * @param leNom
	 * @param lePrenom
	 * @param j
	 * @param m
	 * @param a
	 * @param numero
	 * @param rue
	 * @param code_postal
	 * @param ville
	 * @param embauche
	 * @param salaire
	 * @return Instance crée ou null si not 16 < age < 65
	 */
	public static Secretaire createSecretaire(String leNom,String lePrenom, int j, int m, int a, int numero,
			String rue, String code_postal, String ville, GregorianCalendar embauche, float salaire)
	{ return Secretaire.createSecretaire(leNom, lePrenom, new GregorianCalendar(a, m, j), 
			new Adresse(numero, rue, code_postal, ville), embauche, salaire); }
	
	/*** RedÃ©finition des mÃ©thodes HÃ©ritÃ© de Object ***/
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String result="\nNom : "+nom+"\n"
		+"PrÃ©nom : "+prenom+"\n"+
		"NÃ©(e) le : "+dateNaissance.get(Calendar.DAY_OF_MONTH)+
		"-"+dateNaissance.get(Calendar.MONTH)+
		"-"+dateNaissance.get(Calendar.YEAR)+"\n"+
		"Adresse : "+
		adresse.toString()+"\nStatus: Secretaire";
		return result;
	}
	
	/*** instance methods ***/
	
	/**
	 * Augmentation du salaire avec majoration par rapport à la charge de travail
	 * @param percentage pourcentage d'augmentation
	 */
	public void augmenterSalaire(float percentage)
	{ super.augmenteSalaire((float) (percentage + 0.1*mManager.size())); }
	
	/**
	 * Ajout d'un manager à la secretaire
	 * @param hManager
	 * @return false si la secretaire a déjà 5 manager, true sinon
	 */
	public boolean addManager(Manager hManager)
	{
		boolean ajouter = false;
		int nbManagers = this.mManager.size();
		
		if(nbManagers < 5)
		{
			ajouter = true;
			mManager.add(hManager);
		}
		
		return ajouter;
	}
	
	/**
	 * Suppression d'un manager
	 * @param hManager
	 * @return false si le manager n'a pas ete trouver, true sinon
	 */
	public boolean delManager(Manager hManager)
	{
		boolean rm = false;
		
		if(this.mManager.contains(hManager))
		{
			rm = true;
			this.mManager.remove(hManager);
		}
		
		return rm;
	}
}
