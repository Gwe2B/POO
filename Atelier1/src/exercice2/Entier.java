package exercice2;

/**
 * class Entier
 * @author Gwena�l
 * @date 24/09/2020
 */

public class Entier {
	protected int valeur;
	protected int bInf;
	protected int bSup;
	
	/**
	 * Class Constructor
	 * @param bInf Minimum of the integer
	 * @param bSup Maximum of the integer
	 */
	public Entier(int bInf, int bSup)
	{
		this.bInf = bInf;
		this.bSup = bSup;
		this.valeur = 0;
	}
	
	/**
	 * Class Constructor
	 * @param entier Value of the integer
	 * @param bInf Minimum of the integer
	 * @param bSup Maximum of the integer
	 */
	public Entier(int entier, int bInf, int bSup)
	{
		if(entier >= bInf && entier < bSup)
		{
			this.bInf = bInf;
			this.bSup = bSup;
			this.valeur = entier;
		}
		else
			System.err.println("L'entier ne correspond pas aux bornes sp�cifi�");
	}

	/*** GETTEURS ***/
	public int getbSup() 
	{ return this.bSup; }

	public int getbInf() 
	{ return this.bInf; }
	
	public int getEntier()
	{ return this.valeur; }
	
	/*** SETTEURS ***/
	public void setEntier(int val)
	{
		if(val >= this.bInf && val <= this.bSup)
			this.valeur = val;
	}
	
	/*** HERITE DE OBJECT ***/
	public String toString()
	{ return Integer.toString(this.valeur); }
	
	public boolean equals(Object obj)
	{
		boolean eval = false;
		
		if(this == obj)
			eval = true;
		else if(obj == null || this.getClass() != obj.getClass())
			eval = false;
		else
		{
			Entier ent = (Entier)obj;
			eval = ent.valeur == this.valeur;
		}
		
		return eval;
	}
	
	/*** METHODS ***/
	/**
	 * Increment the value of the integer
	 * If the value after increment exceed the maximum or minimum value, nothing appen
	 */
	public void incremente()
	{
		if(this.valeur + 1 >= this.bInf && this.valeur + 1 <= this.bSup)
			this.valeur++;
	}
	
	/**
	 * Increment the value of the integer by n
	 * If the value after increment exceed the maximum or minimum value, nothing appen
	 * @param n Value of the increment
	 */
	public void incremente(int n)
	{
		if(this.valeur + n >= this.bInf && this.valeur + n <= this.bSup)
			this.valeur += n;
	}
}
