package exercice1;

/**
 * class: TestDe
 * @author Gwenaël
 * @date 24/09/2020
 */

public class DePipe extends De {
	private int bInf;
	
	public DePipe(String deName, int bInf)
	{ this(6, deName, bInf); }
	
	public DePipe(int faces, String deName, int bInf)
	{
		super(faces, deName);
		
		if(bInf > 0 && bInf <= faces)
			this.bInf = bInf;
		else
			System.err.println("La borne inferieur doit etre compris entre 0 et le nbr max de faces");
	}
	
	public int getBorneInf()
	{ return this.bInf; }
	
	public int lancer()
	{
		int retour;
		
		do { retour = super.lancer(); }
		while(retour < bInf);
		
		return retour;
	}
}
