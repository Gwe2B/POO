package root.dim3;

import root.Forme;

public abstract class Forme3D extends Forme
{
	/**
	 * Constructeur
	 * @param nom Nom de la forme
	 */
	public Forme3D(String nom)
	{ super(nom); }
	
	/*** Abstracts methods ***/
	/**
	 * Calcule la surface de la forme
	 * @return Surface de la forme
	 */
	public abstract double getSurface();
	
	/**
	 * Calcul le volume de la forme
	 * @return Le volume de la forme
	 */
	public abstract double getVolume();
}