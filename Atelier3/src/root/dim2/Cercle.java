package root.dim2;

/**
 * 
 * @author Gwenaël
 * @date 29/09/2020
 * @version 1
 *
 */

public class Cercle extends Forme2D
{
	
	/*** Instance attributes ***/
	private double rayon;
	
	/*** Constructors ***/
	
	/**
	 * Constructor
	 * @param nom Nom du cercle
	 * @param rayon Rayon du cercle
	 */
	public Cercle(String nom, double rayon)
	{
		super(nom);
		this.rayon = rayon;
	}
	
	/*** Accessor & mutator ***/
	
	/**
	 * Getteur de this.rayon
	 * @return le rayon du cercle
	 */
	public double getRayon()
	{ return this.rayon; }

	/**
	 * Setteur de this.rayon
	 * @param rayon Le rayon du cercle
	 */
	public void setRayon(float rayon)
	{ this.rayon = rayon; }
	
	/*** Object Redefine ***/
	
	/**
	 * @see Object.toString
	 */
	@Override
	public String toString()
	{
		return "La forme " + this.identifiant +
				" est un Cercle.\nSon rayon vaut " + this.rayon;
	}
	
	/**
	 * @see Object.equals
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean equal;
		
		if(this == obj)
			equal = true;
		else if(obj == null || this.getClass() != obj.getClass())
			equal = false;
		else
		{
			Cercle hCercle = (Cercle)obj;
			equal = this.rayon == hCercle.rayon;
		}
		
		return equal;
	}
	
	/*** Instance Methods ***/
	
	/**
	 * @see Forme2D.getSurface()
	 */
	@Override
	public double getSurface()
	{ return Math.pow(this.rayon, 2) * Math.PI; }

	/**
	 * @see Forme2D.getPerimetre()
	 */
	@Override
	public double getPerimetre()
	{ return 2 * Math.PI * this.rayon; }

}
