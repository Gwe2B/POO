package exercice1;

import java.util.*;

/**
 * @author Gwena�l
 * @date 24/09/2020
 */

public class De {
	/*** CONSTANTES ***/
	public static final int MIN_FACES = 3;
	public static final int DEFAULT_FACES = 6;
	public static final int MAX_FACES = 120;
	
	/*** ATTRIBUTS STATIQUE ***/
	private static Random r = new Random();
	private static int nbrInstances = 0;
	
	/*** ATTRIBUTS ***/
	private int nbFaces;
	private String nom;
	
	/*** CONSTRUCTEURS ***/
	public De(String deName)
	{ this(DEFAULT_FACES, deName); }

	public De(int faces, String deName)
	{
		De.nbrInstances++;
		this.setNbFaces(faces);
		
		if(deName != null && deName.length() > 0)
			this.nom = deName;
		else
			this.nom = "D� n�" + De.nbrInstances;
	}
	
	/*** GETTEURS STATIC ***/
	public static int getNbrInstances()
	{ return De.nbrInstances; }
	
	/*** GETTEURS ***/
	public String getNom()
	{ return this.nom; }
	
	public int getNbFaces()
	{ return this.nbFaces; }
	
	/*** SETTEURS ***/
	public void setNbFaces(int faces)
	{
		if(faces >= De.MIN_FACES && faces <= De.MAX_FACES)
			this.nbFaces = faces;
		else
			System.err.println("Le nombre de faces est invalide");
	}
	
	/*** METHODS ***/
	public String toString()
	{ return "Le D� \"" + this.nom + "\" poss�de " + this.nbFaces + " faces"; }
	
	public boolean equals(Object obj)
	{
		boolean eval;
		
		if(this == obj)
			eval = true;
		else if(obj == null || this.getClass() != obj.getClass())
			eval = false;
		else
		{
			De de = (De)obj;
			eval = de.nbFaces == this.nbFaces && de.nom.equals(this.nom);
		}
		
		return eval;
	}
	
	public int lancer()
	{
		return De.r.nextInt(this.nbFaces) + 1;
	}
	
	public int lancer(int nb)
	{
		int meilleur = 0;
		int lancer = 0;
		
		for(int i = 0; i < nb; i++)
		{
			lancer = this.lancer();
			if(lancer > meilleur)
				meilleur = lancer;
		}
		
		return meilleur;
	}
}