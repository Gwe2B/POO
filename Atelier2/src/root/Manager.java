package root;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author  Gwena�l
 * @date    28/09/2020
 * @version 1
 */

public class Manager extends Employe {
	private Secretaire mSecretaire = null;
	
	/***
	 * Constructeur
	 * @param leNom
	 * @param lePrenom
	 * @param date
	 * @param addr
	 * @param embauche
	 * @param salaire
	 */
	private Manager(String leNom, String lePrenom, GregorianCalendar date, Adresse addr, GregorianCalendar embauche, float salaire)
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
	 * @return Instance cr�e ou null si not 16 < age < 65
	 */
	public static Manager createManager(String leNom,String lePrenom, GregorianCalendar date, Adresse addr,
			GregorianCalendar embauche, float salaire)
	{
		Manager toReturn = null;
		
		if(Employe.ageValide(date, embauche))
			toReturn = new Manager(leNom, lePrenom, date, addr, embauche, salaire);
		
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
	 * @return Instance cr�e ou null si not 16 < age < 65
	 */
	public static Manager createManager(String leNom,String lePrenom, int j, int m, int a, int numero,
			String rue, String code_postal, String ville, GregorianCalendar embauche, float salaire)
	{ return Manager.createManager(leNom, lePrenom, new GregorianCalendar(a, m, j), 
			new Adresse(numero, rue, code_postal, ville), embauche, salaire); }
	
	/*** Redéfinition des méthodes Hérité de Object ***/
	
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String result="\nNom : "+nom+"\n"
		+"Prénom : "+prenom+"\n"+
		"Né(e) le : "+dateNaissance.get(Calendar.DAY_OF_MONTH)+
		"-"+dateNaissance.get(Calendar.MONTH)+
		"-"+dateNaissance.get(Calendar.YEAR)+"\n"+
		"Adresse : "+
		adresse.toString()+"\nStatus: Manager";
		return result;
	}
	
	/*** instance methods ***/
	/**
	 * Augmente le salaire avec majoration d'ancienete
	 * @param percentage pourcentage d'augmentation
	 */
	public void augmenterSalaire(float percentage)
	{
		int anciennete = super.calculAnnuite();
		super.augmenteSalaire((float) (percentage + 0.5*anciennete));
	}
	
	/**
	 * Changement de secretaire
	 * @param hSecretaire nouvelle secretaire
	 */
	public void changeSecretaire(Secretaire hSecretaire)
	{
		if(this.mSecretaire != null)
		{
			this.mSecretaire.delManager(this);
			this.mSecretaire = hSecretaire;
			this.mSecretaire.addManager(this);
		}
		else
		{
			this.mSecretaire = hSecretaire;
			this.mSecretaire.addManager(this);
		}
	}
}
