package root.dim2;

public class Ellipse extends Forme2D {
	/*** Instance attributes ***/
	private double grandAxe, petitAxe;
	
	/*** Constructors ***/
	
	/**
	 * Constructeur
	 * @param nom Nom de l'ellipse
	 * @param ga Grand-Axe de l'ellipse
	 * @param pa Petit-Axe de l'ellipse
	 */
	public Ellipse(String nom, double ga, double pa)
	{
		super(nom);
		this.setGrandAxe(ga);
		this.setPetitAxe(pa);
	}
	
	/*** Accesor & mutator ***/
	
	/**
	 * Getteur de grandAxe
	 * @return le grand axe de l'ellipse
	 */
	public double getGrandAxe()
	{ return grandAxe; }
	
	/**
	 * Getteur de petitAxe
	 * @return le petit axe de l'ellipse
	 */
	public double getPetitAxe()
	{ return petitAxe; }

	/**
	 * Setteut de grandAxe
	 * @param grandAxe le nouveau grand axe
	 */
	public void setGrandAxe(double grandAxe)
	{ this.grandAxe = grandAxe; }

	/**
	 * Setteut de petitAxe
	 * @param grandAxe le nouveau petit axe
	 */
	public void setPetitAxe(double petitAxe)
	{ this.petitAxe = petitAxe;}
	
	/*** Object Redefine ***/
	
	/**
	 * @see Object.toString
	 */
	@Override
	public String toString()
	{
		return "La forme " + this.identifiant +
				" est une ellipse.\nSon grand-axe vaut " + this.grandAxe + 
				" et son petit-axe vaut " + this.petitAxe;
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
		else if(obj == null || obj instanceof Ellipse)
			equal = false;
		else
		{
			Ellipse hEllipse = (Ellipse)obj;
			equal = this.grandAxe == hEllipse.grandAxe &&
					this.petitAxe == hEllipse.petitAxe;
		}
		
		return equal;
	}
	
	/*** Instance methods ***/
	
	/**
	 * @see Forme2D.getSurface()
	 */
	@Override
	public double getSurface()
	{ return Math.PI * (this.grandAxe/2) * (this.petitAxe/2); }

	/**
	 * @see Forme2D.getPerimetre()
	 */
	@Override
	public double getPerimetre()
	{
		double racine = (Math.pow(this.grandAxe/2, 2) +
				Math.pow(this.petitAxe/2, 2))/2;
		
		return 2 * Math.PI * Math.sqrt(racine);
	}

}
