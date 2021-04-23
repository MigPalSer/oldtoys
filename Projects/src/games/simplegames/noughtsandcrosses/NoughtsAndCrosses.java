package games.simplegames.noughtsandcrosses;

import java.util.Scanner;

/*Very basic noughts and crosses game designed for 1 player and displayed
 *in the console. The text are in Spanish and the game don't support incorrect
 *console input (I think it was written before I learn to manage exceptions).
 *
 *Maybe it can be improved by add a initial menu which can allow a 2 players
 *game and by a final display which give option to play a new game without end
 *the program.  
*/

public class NoughtsAndCrosses {
	static Scanner miscan;

	public static void main(String[] args) {
		miscan = new Scanner(System.in);
		char[][] tablero = { { '.', '.', '.' }, { '.', '.', '.' }, { '.', '.', '.' } };

		imprimetablero(tablero);

		boolean ganador = false;

		
		/*CONFIGURATION:
		 *In my first steps as programmer I usually configure the program
		 *options directly in the code.
		 *This configuration, with turnoa and turnoia, assign the x to the human
		 *player and the o to an ia player. If we want to assign the x to an ia, we can
		 *comment turnoa and uncomment turnoia2. Also, if we want to assign the o to an human
		 *player we can uncomment turnob and comment turnoia. 
		 * */
		while (ganador == false) {
			turnoa(tablero);
			// turnoia2(tablero);
			ganador = compruebasiganaa(tablero);
			if (ganador == false) {
				// turnob(tablero);
				turnoia(tablero);
				ganador = compruebasiganab(tablero);
			}

		}

	}

	// The "graphic" display
	public static void imprimetablero(char tab[][]) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(tab[i][j]);
			}
			System.out.println("");
		}
		System.out.println("______________________");

	}

	// Basic methods to print in the tabletop
	public static void jugadora(char tab[][], int f, int c) {
		tab[f][c] = 'x';
	}

	public static void jugadorb(char tab[][], int f, int c) {
		tab[f][c] = 'o';
	}

	//Method to manage the human turn of x
	//It announces the turn in the console and ask the human for an input.
	//Then, it check if the input is valid with the tabletop
	public static void turnoa(char tab[][]) {
		System.out.println("Turno del jugador A (x)");
		boolean casillacorrecta = false;
		int casilla = 0;
		int a, b;
		while (casillacorrecta == false) {
			System.out.println("Introduce casilla que quieres tachar \n 1/2/3 \n 4/5/6 \n 7/8/9");
			casilla = miscan.nextInt();
			switch (casilla) {
			case 1:
				a = 0;
				b = 0;
				break;
			case 2:
				a = 0;
				b = 1;
				break;
			case 3:
				a = 0;
				b = 2;
				break;
			case 4:
				a = 1;
				b = 0;
				break;
			case 5:
				a = 1;
				b = 1;
				break;
			case 6:
				a = 1;
				b = 2;
				break;
			case 7:
				a = 2;
				b = 0;
				break;
			case 8:
				a = 2;
				b = 1;
				break;
			case 9:
				a = 2;
				b = 2;
				break;
			default:
				a = -1;
				b = -1;
				break;
			}
			if (a == -1) {
				System.out.println("Valor incorrecto");
			} else if (tab[a][b] == 'x' || tab[a][b] == 'o') {
				System.out.println("Casilla ocupada");
			} else {
				jugadora(tab, a, b);
				casillacorrecta = true;
				imprimetablero(tab);
			}
		}
	}

	// Not used. Prepared for a second human player.
	public static void turnob(char tab[][]) {
		System.out.println("Turno del jugador B (o)");
		boolean casillacorrecta = false;
		int casilla = 0;
		int a, b;
		while (casillacorrecta == false) {
			System.out.println("Introduce casilla que quieres tachar \n 1/2/3 \n 4/5/6 \n 7/8/9");
			casilla = miscan.nextInt();
			switch (casilla) {
			case 1:
				a = 0;
				b = 0;
				break;
			case 2:
				a = 0;
				b = 1;
				break;
			case 3:
				a = 0;
				b = 2;
				break;
			case 4:
				a = 1;
				b = 0;
				break;
			case 5:
				a = 1;
				b = 1;
				break;
			case 6:
				a = 1;
				b = 2;
				break;
			case 7:
				a = 2;
				b = 0;
				break;
			case 8:
				a = 2;
				b = 1;
				break;
			case 9:
				a = 2;
				b = 2;
				break;
			default:
				a = -1;
				b = -1;
				break;
			}
			if (a == -1) {
				System.out.println("Valor incorrecto");
			} else if (tab[a][b] == 'x' || tab[a][b] == 'o') {
				System.out.println("Casilla ocupada");
			} else {
				jugadorb(tab, a, b);
				casillacorrecta = true;
				imprimetablero(tab);
			}
		}
	}

	public static boolean compruebaganador(char tab[][], char sim) {
		boolean ganador = false;
		int k;
		for (int i = 0; i < 3; i++) {
			k = 0;
			for (int j = 0; j < 3; j++) {
				if (tab[i][j] == sim) {
					k++;
				}
			}
			ganador = k == 3 ? true : ganador;
		}
		for (int i = 0; i < 3; i++) {
			k = 0;
			for (int j = 0; j < 3; j++) {
				if (tab[j][i] == sim) {
					k++;
				}
			}
			ganador = k == 3 ? true : ganador;
		}
		k = 0;
		for (int i = 0; i < 3; i++) {

			if (tab[i][i] == sim) {
				k++;
			}
		}
		ganador = k == 3 ? true : ganador;
		k = 0;
		for (int i = 0; i < 3; i++) {

			if (tab[i][2 - i] == sim) {
				k++;
			}
		}
		ganador = k == 3 ? true : ganador;

		return ganador;
	}

	public static boolean compruebasiganaa(char tab[][]) {
		boolean fin = compruebaganador(tab, 'x');
		if (fin) {
			System.out.println("Gano jugador A");
		}
		return fin;
	}

	public static boolean compruebasiganab(char tab[][]) {
		boolean fin = compruebaganador(tab, 'o');
		if (fin) {
			System.out.println("Ganó jugador B");
		}
		return fin;
	}

	public static boolean compruebapuntob(char tab[][], char sim, int f, int c) {
		boolean ganador = false;
		if (tab[f][c] != '.') {

		} else {
			int k = 0;
			for (int i = 0; i < 3; i++) {

				if (tab[f][i] == sim) {
					k++;
				}

			}
			ganador = k == 2 ? true : ganador;
			k = 0;
			for (int i = 0; i < 3; i++) {

				if (tab[i][c] == sim) {
					k++;
				}

			}
			ganador = k == 2 ? true : ganador;
			k = 0;
			if (f == c) {
				for (int i = 0; i < 3; i++) {

					if (tab[i][i] == sim) {
						k++;
					}
				}
				ganador = k == 2 ? true : ganador;
				k = 0;
			}
			if (f + c == 2) {
				for (int i = 0; i < 3; i++) {

					if (tab[i][2 - i] == sim) {
						k++;
					}
				}
				ganador = k == 2 ? true : ganador;
			}
		}

		return ganador;
	}

	//AI manage method
	public static void turnoia(char tab[][]) {
		boolean eligiendo = true;
		int f = -1;
		int c = -1;
		// Analizaremos varias condiciones, lo primero si el punto da la victoria, lo
		// segundo si da la victoria al otro, lo tercero es poner un punto cualquiera
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (compruebapuntob(tab, 'o', i, j)) {
					f = i;
					c = j;
				}
			}
		}
		eligiendo = f != -1 ? false : true;
		if (eligiendo) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (compruebapuntob(tab, 'x', i, j)) {
						f = i;
						c = j;
					}
				}
			}
			eligiendo = f != -1 ? false : true;
		}
		if (eligiendo) {
			while (eligiendo) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (tab[i][j] == '.') {
							f = i;
							c = j;
						}
					}
				}
				eligiendo = f != -1 ? false : true;
			}
		}

		jugadorb(tab, f, c);
		imprimetablero(tab);
	}

	//Second AI method
	public static void turnoia2(char tab[][]) {
		boolean eligiendo = true;
		int f = -1;
		int c = -1;
		// Analizaremos varias condiciones, lo primero si el punto da la victoria, lo
		// segundo si da la victoria al otro, lo tercero es poner un punto cualquiera
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (compruebapuntob(tab, 'x', i, j)) {
					f = i;
					c = j;
				}
			}
		}
		eligiendo = f != -1 ? false : true;
		if (eligiendo) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (compruebapuntob(tab, 'o', i, j)) {
						f = i;
						c = j;
					}
				}
			}
			eligiendo = f != -1 ? false : true;
		}
		if (eligiendo) {
			while (eligiendo) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (tab[i][j] == '.') {
							f = i;
							c = j;
						}
					}
				}
				eligiendo = f != -1 ? false : true;
			}
		}

		jugadora(tab, f, c);
		imprimetablero(tab);
	}
}
