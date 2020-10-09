package root.dim2;

/**
 * 
 * @author Gwenaël
 * @date 29/09/2020
 * @version 1
 *
 */

public class Rectangle extends Forme2D
{
	/*** Instance attributes ***/
	private double longueur, largeur;
	
	/**
	 * Constructeur
	 * @param nom Nom du rectangle
	 * @param L	Longueur
	 * @param l	Largeur
	 */
	public Rectangle(String nom, double L, double l)
	{
		super(nom);
		this.longueur = L;
		this.largeur  = l;
	}
	
	/*** Redefine from Object class ***/
	
	/**
	 * @see Object.toString()
	 */
	public String toString()
	{
		return "La Forme " + this.identifiant +
				" est un rectangle.\nSes dimensions sont " +
				this.largeur + "x" + this.longueur; 
	}
	
	/**
	 * @see Object.equals()
	 */
	public boolean equals(Object obj)
	{
		boolean equal;
		
		if(this == obj)
			equal = true;
		else if(obj == null || this.getClass() != obj.getClass())
			equal = false;
		else
		{
			Rectangle hRectangle = (Rectangle)obj;
			equal = (this.longueur == hRectangle.longueur &&
					this.largeur == hRectangle.largeur);
		}
		
		return equal;
	}
	
	/*** Instance attribute ***/
	
	/**
	 * @see Forme2D.getPerimetre()
	 */
	@Override
	public double getPerimetre()
	{ return 2*this.largeur + 2*this.longueur; }

	/**
	 * @see Forme2D.getSurface()
	 */
	@Override
	public double getSurface()
	{ return this.largeur * this.longueur; }
}
