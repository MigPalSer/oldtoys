package math.calculators.polishcalculator;

import java.util.Scanner;

/*Inverse polish calculator. With console-scanner-based interface 
 *and text in spanish. It doesn't manage the exceptions, so one need to
 *be careful with the console inputs. */

public class PolishCalculator {

	public static void main(String[] args) {
		Scanner miscan = new Scanner(System.in);
		System.out.println("introduce término entero 1");
		int n1 = miscan.nextInt();

		System.out.println("introduce operación + - * / ^ %");
		char op = miscan.next().charAt(0);

		System.out.println("introduce término entero 2");
		int n2 = miscan.nextInt();

		double res = 0;
		switch (op) {
		case '+':
			res = n1 + n2;
			break;
		case '-':
			res = n1 - n2;
			break;
		case '*':
			res = n1 * n2;
			break;
		case '/':
			res = n1 / n2;
			break;
		case '^':
			res = Math.pow(n1, n2);
			break;
		case '%':
			res = n1 % n2;
			break;
		default:
			res = 0;
			break;
		}

		System.out.println("El resultado es " + res);
		miscan.close();
	}
}
