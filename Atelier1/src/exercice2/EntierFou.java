package exercice2;

/**
 * class EntierFou
 * extend from Entier
 * @author Gwena�l
 * @date 24/09/2020
 */

import java.util.*;

public class EntierFou extends Entier {
	private static Random r;
	
	private int niveauFolie;

	/**
	 * Class Constructor
	 * @param bInf Minimum of the integer
	 * @param bSup Maximum of the integer
	 * @param folie Value of the crazy level
	 */
	public EntierFou(int bInf, int bSup, int folie)
	{
		super(bInf, bSup);
		this.niveauFolie = folie;
	}
	
	/**
	 * Class Constructor
	 * @param entier Value of the integer
	 * @param bInf Minimum of the integer
	 * @param bSup Maximum of the integer
	 * @param folie Value of the crazy level
	 */
	public EntierFou(int entier, int bInf, int bSup, int folie)
	{
		super(entier, bInf, bSup);
		this.niveauFolie = folie;
	}

	public int getNiveauFolie()
	{ return this.niveauFolie; }
	
	/**
	 * Increment the value of the integer by a random number between 0 and niveauFolie attr
	 * If the value after increment exceed the maximum or minimum value, nothing appen
	 */
	public void incremente()
	{
		int increment = EntierFou.r.nextInt(this.niveauFolie);
		
		while(!(this.valeur + increment >= this.bInf && this.valeur + increment <= this.bSup))
			increment = EntierFou.r.nextInt(this.niveauFolie);
		
		this.valeur += increment;
	}
}
