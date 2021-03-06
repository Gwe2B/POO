package root.dim3;

import root.dim2.Cercle;

public class Sphere extends Forme3D {
	/*** Instances attributes ***/
	private double rayon;
	
	/**
	 * Constructeur
	 * @param nom Nom de la sphere
	 * @param rayon Rayon de la sphere
	 */
	public Sphere(String nom, double rayon)
	{
		super(nom);
		this.setRayon(rayon);
	}
	
	/*** Accessor & mutators ***/
	
	/**
	 * @return the rayon
	 */
	public double getRayon()
	{ return rayon; }
	
	/**
	 * @param rayon the rayon to set
	 */
	public void setRayon(double rayon)
	{ this.rayon = rayon; }
	
	/*** Override of object methods ***/
	
	@Override
	public String toString()
	{ return "La forme " + this.identifiant + " est une spehere de rayon " + 
			this.rayon; }
	
	@Override
	public boolean equals(Object obj)
	{
		boolean equal;
		
		if(this == obj)
			equal = true;
		else if(obj == null || obj instanceof Sphere)
			equal = false;
		else
		{
			Sphere hSphere = (Sphere)obj;
			equal = this.rayon == hSphere.rayon;
		}
		
		return equal;
	}
	
	/*** Instances methods **/
	
	@Override
	public double getSurface()
	{ return 4 * Math.PI * Math.pow(this.rayon, 2); }

	@Override
	public double getVolume()
	{ return (4*Math.PI*Math.pow(this.rayon, 3))/3; }

}
