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
	
	/*** Class methods ***/
	
	/**
	 * f1 is bigger than f2?
	 * @param f1 First shape to compare
	 * @param f2 Second shape to compare
	 * @return true if the area of f1 > f2, else return false
	 */
	public static boolean plusGrandeSurface(Forme f1, Forme f2)
	{ return f1.getSurface() > f2.getSurface(); }
	
	/*** Abstract methods ***/
	
	/**
	 * Calcule la surface de la forme
	 * @return Surface de la forme
	 */
	public abstract double getSurface();
}
