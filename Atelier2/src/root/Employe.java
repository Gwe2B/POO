package root;

import java.util.*;

/**
 * @author  Gwenaël
 * @date    28/08/2020
 * @version 1
 */

public class Employe extends Personne
{
	/*** CST de classe ***/
	private static final int AGEMIN = 16;
	private static final int AGEMAX = 65;
	
	/*** CST d'instance ***/
	private final GregorianCalendar dateEmbauche;
	
	/*** Attributs d'instance ***/
	private float salaire;
	
	/*** Constructors ***/
	/**
	 * Constructeur
	 * @param hPersonne
	 * @param embauche Date d'embauche
	 * @param salaire Salaire de l'employe
	 */
	protected Employe(String leNom, String lePrenom, GregorianCalendar laDate, Adresse lAdresse,
			GregorianCalendar embauche, float salaire)
	{
		super(leNom, lePrenom, laDate, lAdresse);
		this.dateEmbauche = embauche;
		this.salaire = salaire;
	}
	
	/*** Accesseur et mutateurs ***/
	public float getSalaire()
	{ return this.salaire; }

	public GregorianCalendar getDateEmbauche()
	{ return this.dateEmbauche; }
	
	/*** Class Methods ***/
	public static Employe createEmploye(String leNom,String lePrenom, GregorianCalendar laDate,
			Adresse lAdresse, GregorianCalendar embauche, float salaire)
	{
		Employe toReturn = null;
		
		if(Employe.ageValide(laDate, embauche))
			toReturn = new Employe(leNom, lePrenom, laDate, lAdresse, embauche, salaire);
		
		return toReturn;
	}
	
	public static Employe createEmploye(String leNom,String lePrenom, int j, int m, int a, int numero,
			String rue, String code_postal, String ville, GregorianCalendar embauche, float salaire)
	{
		return Employe.createEmploye(leNom, lePrenom, new GregorianCalendar(a, m, j),
				new Adresse(numero, rue, code_postal, ville), embauche, salaire);
	}
	
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
		adresse.toString()+"\nStatus: Employé";
		return result;
	}
	
	/*** Instance methods ***/
	/***
	 * Augmente/diminue le salaire
	 * @param percentage Taux d'augmentation (> 0) ou de diminution (< 0)
	 */
	public void augmenteSalaire(float percentage)
	{
		if(percentage > 0)
			this.salaire = this.salaire*(1 + percentage/100);
		else if(percentage < 0)
			this.salaire = this.salaire*(1 - percentage/100);
	}
	
	/**
	 * Calcul l'annuité de l'employé
	 * @return le nombre d'année depuis la date d'embauche
	 */
	public int calculAnnuite()
	{
		int curYear = Calendar.getInstance().get(Calendar.YEAR);
		return curYear - this.dateEmbauche.get(Calendar.YEAR);
	}

	/**
	 * Verifie si la personne peut travailler
	 * @param date
	 * @param embauche
	 * @return true si age valide false sinon
	 */
	public static boolean ageValide(GregorianCalendar date, GregorianCalendar embauche)
	{
		return (embauche.get(Calendar.YEAR) > (date.get(Calendar.YEAR) + Employe.AGEMIN) &&
				embauche.get(Calendar.YEAR) < (date.get(Calendar.YEAR) + Employe.AGEMAX));
	}
}
