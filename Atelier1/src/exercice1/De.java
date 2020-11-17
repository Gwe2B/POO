package exercice1;

import java.util.*;

/**
 * @author Gwenaël
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
	/**
	 * Constructor
	 * @param deName The dice's name
	 * @throws IllegalArgumentException See exercice1.De.setNbFaces()
	 */
	public De(String deName) throws IllegalArgumentException
	{ this(DEFAULT_FACES, deName); }

	/**
	 * Constructor
	 * @param faces The faces count
	 * @param deName the dice name
	 * @throws IllegalArgumentException See exercice1.De.setNbFaces()
	 */
	public De(int faces, String deName) throws IllegalArgumentException
	{
		De.nbrInstances++;
		this.setNbFaces(faces);
		
		if(deName != null && deName.length() > 0)
			this.nom = deName;
		else
			this.nom = "Dé n°" + De.nbrInstances;
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
	/**
	 * Set the number of faces
	 * @param faces The face count
	 * @throws IllegalArgumentException if the face count is not between
	 * MIN_FACES & MAX_FACES
	 */
	public void setNbFaces(int faces) throws IllegalArgumentException
	{
		if(faces >= De.MIN_FACES && faces <= De.MAX_FACES)
			this.nbFaces = faces;
		else
			throw new IllegalArgumentException("Le nombre de faces du dés doit"+
				" être compris entre " + De.MIN_FACES + " et " + De.MAX_FACES);
	}
	
	/*** METHODS ***/
	@Override
	public String toString()
	{ return "Le Dé \"" + this.nom + "\" posséde " + this.nbFaces + " faces"; }
	
	@Override
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
	
	/**
	 * Make a launch
	 * @return The launch result
	 */
	public int lancer()
	{ return De.r.nextInt(this.nbFaces) + 1; }
	
	/**
	 * Make nb launch
	 * @param nb Number of launch
	 * @return The best result of the launchs
	 */
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
