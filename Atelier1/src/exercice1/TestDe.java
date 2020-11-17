/**
 * class: TestDe
 * @author Gwena�l
 * @date 24/09/2020
 */

package exercice1;

public class TestDe {
	public static void main(String[] args)
	{
		try {
			// De hDe6 = new De(null);
			De hDePipe = new DePipe(null, 800);
			
			for(int i = 0; i < 10; i++)
				System.out.println("Lancer " + i + ": " + hDePipe.lancer());
		} catch (IllegalArgumentException ex) {
			System.err.println("Une Erreur vient d'etre catcher");
			System.err.println(ex.getMessage());
		}
	}
}
