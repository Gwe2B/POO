package root;

import root.dim2.*;
import root.dim3.*;

/**
 * 
 * @author Gwena�l
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
	}

}