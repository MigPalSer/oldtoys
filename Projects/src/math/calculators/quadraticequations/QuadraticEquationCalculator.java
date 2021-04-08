package math.calculators.quadraticequations;

import java.util.Scanner;

/*Another basic calculator. This class was for quadratic equation.
 *As usual in that age, the interface is console-scanner-designed and the
 *text in Spanish.
 * */

public class QuadraticEquationCalculator {

	public static void main(String[] args) {

		Scanner miscan = new Scanner(System.in);
		System.out.println("Para resolver una ecuación de segundo grado en la forma ax^2+bx+c=0 \nintroduce a");
		double a = miscan.nextDouble();
		System.out.println("introduce b");
		double b = miscan.nextDouble();
		System.out.println("introduce c");
		double c = miscan.nextDouble();

		if (Math.pow(b, 2) < (4 * a * c)) {
			System.out.println("La ecuación no tiene solución real");
		} else if (a == 0 && b != 0) {
			double solpri = (-c) / b;
			System.out.println("La ecuación no es de segundo grado, la solución es " + solpri);
		} else if (a == 0) {
			System.out.println("No hay incognita");
		} else {
			double sol1 = (-b + Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
			double sol2 = (-b - Math.sqrt(Math.pow(b, 2) - (4 * a * c))) / (2 * a);
			System.out.println("Las soluciones son: \n" + sol1 + " y " + sol2);
		}

		miscan.close();
	}

}
