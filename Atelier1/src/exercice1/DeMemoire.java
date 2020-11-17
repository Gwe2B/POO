package exercice1;

/**
 * class: TestDe
 * @author Gwenaël
 * @date 24/09/2020
 */

public class DeMemoire extends De {
	private int lastLaunch = 0;
	
	public DeMemoire(String deName) throws IllegalArgumentException
	{ super(deName); }
	
	public DeMemoire(int faces, String deName) throws IllegalArgumentException
	{ super(faces, deName);	}
	
	public int lancer()
	{
		int launch;
		
		do { launch = super.lancer(); }
		while(launch == this.lastLaunch);
		
		this.lastLaunch = launch;
		return launch;
	}
}
