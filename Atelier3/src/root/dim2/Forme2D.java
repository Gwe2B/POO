package root.dim2;

import root.Forme;

/**
 * 
 * @author Gwenaël
 * @date 29/09/2020
 * @version 1
 *
 */

public abstract class Forme2D extends Forme
{
	/**
	 * Constructeur
	 * @param nom Nom de la Forme
	 */
	public Forme2D(String nom)
	{ super(nom); }
	
	/*** Abstracts methods ***/
	
	/**
	 * Calcule la surface de la forme
	 * @return Surface de la forme
	 */
	public abstract double getSurface();
	
	/**
	 * Calcul le perimetre de la forme
	 * @return Le perimetre de la forme
	 */
	public abstract double getPerimetre();
}