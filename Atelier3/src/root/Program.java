package root;

import root.dim2.*;
import root.dim3.*;

/**
 * 
 * @author Gwenaël
 * @date 29/09/2020
 * @version 1
 *
 */

public class Program {

	/**
	 * Main function
	 * @param args
	 */
	public static void main(String[] args)
	{
		Forme[] hFormes = {
				new Cercle("Cercle", 10),
				new Ellipse("Ellipse", 10, 5),
				new Rectangle("Rectangle", 5, 2),
				new Cylindre("Cylindre", 2, 10),
				new Sphere("Sphere", 10)
		};
		
		Cylindre hCylindreTest = new Cylindre("Cylindre de test", 2, 10);
		Cylindre hCylindreTest2 = new Cylindre("Cylindre de test", 3, 10);
		
		System.out.println((Cercle)hFormes[0]);
		System.out.println((Ellipse)hFormes[1]);
		System.out.println((Rectangle)hFormes[2]);
		System.out.println((Cylindre)hFormes[3]);
		System.out.println((Sphere)hFormes[4]);
		
		System.out.println("hFormes[3] == hCylindreTest: " +
				hFormes[3].equals(hCylindreTest));
		
		System.out.println("hFormes[3] == hCylindreTest2: " +
				hFormes[3].equals(hCylindreTest2));
	}

}
