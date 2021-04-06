package games.simplegames.guessnumber;

import java.util.*;

/*Very simple, console displayed, game of "Guess a number" between 0 and 100.
 *I believe this is the first game I wrote with java. 
 * */

public class GuessNumber {

	public static void main(String[] args) {
		double num1 = Math.random();
		int num = (int) (num1 * 100);
		int numa = -1;
		int intentos = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.println("-Guess a number between 0 and 100");
		System.out.println("Try to write it in the console");
		while (numa != num) {
			intentos++;
			numa = entrada.nextInt();
			if (numa > num) {
				System.out.println("Too high");
			} else if (numa < num) {
				System.out.println("Too low");
			} else {
			}
		}
		System.out.println("GG, you spend " + intentos + " chances");
		entrada.close();
	}
}
