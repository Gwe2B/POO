package root;

/**
 * 
 * @author Gwenaël
 * @date 29/09/2020
 * @version 1
 *
 */

public abstract class Forme {
	/*** Class attributes ***/
	private static int nbInstances = 0;
	
	/*** Instance CST ***/
	public final String identifiant;
	
	/*** Constructors ***/
	
	/**
	 * Constructeur
	 * @param nom Nom de la forme géométrique
	 */
	public Forme(String nom)
	{
		Forme.nbInstances++;
		this.identifiant = nom + " " + Forme.nbInstances;
	}
	
	/*** Abstract methods ***/
	
	/**
	 * Calcule la surface de la forme
	 * @return Surface de la forme
	 */
	public abstract double getSurface();
}
