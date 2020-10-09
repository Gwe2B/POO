package root.dim3;

public class Cylindre extends Forme3D {
	/*** Instance attribute ***/
	private double rayon, hauteur;
	
	public Cylindre(String nom, double r, double h)
	{
		super(nom);
		this.rayon = r;
		this.hauteur = h;
	}

	/*** Accessor & mutator ***/
	
	/**
	 * @return the rayon
	 */
	public double getRayon()
	{ return this.rayon; }

	/**
	 * @param rayon the rayon to set
	 */
	public void setRayon(double rayon)
	{ this.rayon = rayon; }

	/**
	 * @return the hauteur
	 */
	public double getHauteur()
	{ return this.hauteur; }

	/**
	 * @param hauteur the hauteur to set
	 */
	public void setHauteur(double hauteur)
	{ this.hauteur = hauteur; }
	
	/*** Inherited methods from Object ***/
	
	@Override
	public String toString()
	{
		return "La forme " + this.identifiant + " est un cylindre de rayon " + 
				this.rayon + " et de hauteur " + this.hauteur;
	}
	
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
			Cylindre hCylindre = (Cylindre)obj;
			equal = this.rayon == hCylindre.rayon &&
					this.hauteur == hCylindre.hauteur;
		}
		
		return equal;
	}
	
	/*** Instance methods ***/
	
	@Override
	public double getSurface()
	{ return 2*Math.PI*this.rayon*this.hauteur; }

	@Override
	public double getVolume()
	{ return Math.PI*Math.pow(this.rayon, 2)*this.hauteur; }

}
