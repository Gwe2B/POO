package com.exo5;

import java.util.*;

public class Personne implements Comparable<Personne> {
	/*** CST de classe ***/
    private static final Adresse ADRESSE_INCONNUE = null;
    
    /*** CST d'instance ***/
    protected final GregorianCalendar dateNaissance;
    
    /*** Attributs de classe ***/
    private static int nbrInstances = 0;
    
    /*** Attributs d'instance ***/
    protected String nom;
    protected String prenom;
    protected Adresse adresse=ADRESSE_INCONNUE;
	
    /*** Constructors ***/
    
	/**
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param laDate la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
	 */
	public Personne(String leNom,String lePrenom, GregorianCalendar laDate, Adresse lAdresse) {
		Personne.nbrInstances++;
		
		nom = leNom.toUpperCase();
		prenom=lePrenom;
		dateNaissance=laDate;
		adresse=lAdresse;
	}
	
	/** 
	 * Constructeur de Personne
	 * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param j le jour de naissance
	 * @param m le mois de naissance
	 * @param a l'année de naissance
	 * @param numero le n° de la rue
	 * @param rue la rue
	 * @param code_postal le code postal de l'adresse
	 * @param ville la ville ou la personne habite
	 */
	public Personne(String leNom,String lePrenom, int j, int m, int a, int numero, String rue,
			String code_postal, String ville)
	{ this(leNom, lePrenom, new GregorianCalendar(a,m,j), new Adresse(numero,rue,code_postal,ville)); }
	
	/**
	 * Constructeur par copie
	 * @param hPersonne instance a copier
	 */
	public Personne(Personne hPersonne)
	{ this(hPersonne.nom, hPersonne.prenom, hPersonne.dateNaissance, hPersonne.adresse); }

	/*** Accesseur et mutateurs ***/
	
	/**
	 * Accesseur
	 * @return le nom
	 */
	public String getNom()
	{ return nom; }
	
	/**
	 * Accesseur
	 * @return retourne le prénom
	 */
	public String getPrenom()
	{ return prenom; }
	
	/**
	 * Accesseur
	 * @return la date de naissance	 
	 */
	public GregorianCalendar getDateNaissance()
	{ return dateNaissance; }
	
	/**
	 * Accesseur
	 * @return l'adresse	 
	 */
	public Adresse getAdresse()
	{ return adresse; }
	
	/**
	 * Modificateur
	 * @param retourne l'adresse	 
	 */
	public void setAdresse(Adresse a)
	{ adresse=a; }
	
	/*** Accesseur de classe ***/
	/**
	 * Accesseur
	 * @return le nombre d'instances de la classe
	 */
	public static int getNbrInstances()
	{ return Personne.nbrInstances; }
	
	/*** Redéfinition des méthodes Hérité de Object ***/
	
	@Override
	public String toString(){
		String result="\nNom : "+nom+"\n"
		+"Prénom : "+prenom+"\n"+
		"Né(e) le : "+dateNaissance.get(Calendar.DAY_OF_MONTH)+
		"-"+dateNaissance.get(Calendar.MONTH)+
		"-"+dateNaissance.get(Calendar.YEAR)+"\n"+
		"Adresse : "+
		adresse.toString();
		return result;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		boolean eval;
		
		if(this == obj)
			eval = true;
		else if(obj == null || obj instanceof Personne)
			eval = false;
		else
		{
			Personne pe = (Personne)obj;
			eval = this.nom.equals(pe.nom) && this.prenom.equals(pe.prenom) && this.dateNaissance.equals(pe.dateNaissance);
		}
		
		return eval;
	}

/* ----------------- Inherited Comparable interface methods ----------------- */

	@Override
	public int compareTo(Personne o) {
		int result = 0;

		if(o.dateNaissance.compareTo(this.dateNaissance) > 0)
			result = 1;
		else if(o.dateNaissance.compareTo(this.dateNaissance) < 0)
			result = -1;
		else {
			result = this.nom.compareTo(o.nom);
			if(result == 0)
				result = this.prenom.compareTo(o.prenom);
		}

		return result;
	}
	
/* ---------------------------- Instance Methods ---------------------------- */

	/**
	 * Compare l'age de personne 1 et personne 2
	 * @param personne1
	 * @param personne2
	 * @return true si personne1 est plus agee, false sinon
	 */
	public static boolean plusAgee(Personne personne1, Personne personne2)
	{ return personne1.dateNaissance.compareTo(personne2.dateNaissance) < 0; }
	
	/**
	 * Compare l'age de l'objet courant a hPersonne
	 * @param hPersonne
	 * @return true si l'objet courant est plus agee, false sinon
	 */
	public boolean plusAgeeQue(Personne hPersonne)
	{ return Personne.plusAgee(this, hPersonne); }
}

    
   
   
