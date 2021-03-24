package math.calculators.geometric;

import java.util.Scanner;

import javax.swing.JOptionPane;

/*Simple area calculator for squares, rectangles, triangles and circles.
 *A rude interface with JOptionPane and console and the app text in spanish.
 * */

public class GeometricCalculator {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("Elige figura: \n1 cuadrado \n2 rectángulo \n3 triángulo \n4 círculo");

		int figura = entrada.nextInt();

		switch (figura) {
		case 1:
			String lado = JOptionPane.showInputDialog("Indica el lado");
			System.out.println("El área del cuadrado es " + Math.pow(Integer.parseInt(lado), 2));
			break;
		case 2:
			String lado1 = JOptionPane.showInputDialog("Indica la base");
			String lado2 = JOptionPane.showInputDialog("Indica la altura");
			System.out.println("El área del rectángulo es " + ((Integer.parseInt(lado1)) * (Integer.parseInt(lado2))));
			break;
		case 3:
			String lado3 = JOptionPane.showInputDialog("Indica la base");
			String lado4 = JOptionPane.showInputDialog("Indica la altura");
			System.out.println(
					"El área del triángulo es " + (0.5 * (Integer.parseInt(lado3)) * (Integer.parseInt(lado4))));
			break;
		case 4:
			int radio = Integer.parseInt(JOptionPane.showInputDialog("Indica el radio"));
			System.out.print("El área del círculo es ");
			System.out.printf("%1.2f", Math.PI * (Math.pow(radio, 2)));
			break;
		}

		entrada.close();
	}
	
}