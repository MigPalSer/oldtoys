package games.simplegames.guessnumber;

import java.util.*;

/*Versión original en español (dialecto callejero) del juego adivina un número
 * */

public class AdivinaNumero {

	public static void main(String[] args) {
		double num1 = Math.random();
		int num = (int) (num1 * 100);
		int numa = -1;
		int intentos = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.println("-Adivina número de 0 a 100");
		System.out.println("¡Escríbelo en la consola a ver si lo pillas!");
		while (numa != num) {
			intentos++;
			numa = entrada.nextInt();
			if (numa > num) {
				System.out.println("Tas pasao");
			} else if (numa < num) {
				System.out.println("Tas quedao corto");
			} else {
			}
		}
		System.out.println("Bien hecho, has gastado " + intentos + " intentos");
		entrada.close();
	}
}
