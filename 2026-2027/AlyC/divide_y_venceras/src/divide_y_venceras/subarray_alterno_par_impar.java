package divide_y_venceras;

import java.util.Arrays;

public class subarray_alterno_par_impar {

	private static int maximoAlterno(int[] v) {

		return maximoSubarrayAlternoRec(v, 0, v.length - 1);
	}

	private static int maximoSubarrayAlternoRec(int[] v, int i0, int iN) {

		if (i0 == iN)
			return v[i0];
		else {

			int k = (i0 + iN) / 2;

			int p1 = maximoSubarrayAlternoRec(v, i0, k);
			int p2 = maximoSubarrayAlternoRec(v, k + 1, iN);
			int p3 = maximoSubarrayAlternoCruzada(v, k, i0, iN);

			return Math.max(p1, Math.max(p2, p3));

		}

	}

	private static int maximoSubarrayAlternoCruzada(int[] v, int k, int i0, int iN) {
	
		if (esPar(v[k]) == esPar(v[k + 1])) {
			return Integer.MIN_VALUE;
		}

		// Calculamos el máximo hacia la izquierda partiendo desde v[k]
		int sumaParcialIzquierda = bucleWhileCruzadaIzquierda(v, k, i0);

		// Calculamos el máximo hacia la derecha partiendo desde v[k+1]
		int sumaParcialDerecha = bucleWhileCruzadaDerecha(v, k + 1, iN);

		// El total es la suma de las dos partes óptimas
		return sumaParcialIzquierda + sumaParcialDerecha;
	}

	private static int bucleWhileCruzadaIzquierda(int[] v, int k, int iFrontera) {
		int suma = v[k]; // Ya sumamos el primer elemento (el epicentro)
		int max = suma;
		boolean error = false;

		// Si v[k] es par, el siguiente a su izquierda DEBE SER IMPAR (!par)
		boolean buscarPar = !esPar(v[k]);

		int indice = k - 1; // Empezamos a evaluar desde el de al lado

		while (indice >= iFrontera && !error) {
			if (buscarPar) {
				if (esPar(v[indice])) {
					suma += v[indice];
					if (suma > max)
						max = suma;
					buscarPar = false;
				} else {
					error = true;
				}
			} else {
				if (!esPar(v[indice])) {
					suma += v[indice];
					if (suma > max)
						max = suma;
					buscarPar = true; 
				} else {
					error = true;
				}
			}
			indice--;
		}
		return max;
	}

	private static int bucleWhileCruzadaDerecha(int[] v, int k, int iFrontera) {
		int suma = v[k];
		int max = suma;
		boolean error = false;

		boolean buscarPar = !esPar(v[k]);

		int indice = k + 1;

		while (indice <= iFrontera && !error) {
			if (buscarPar) {
				if (esPar(v[indice])) {
					suma += v[indice];
					if (suma > max)
						max = suma;
					buscarPar = false;
				} else {
					error = true;
				}
			} else {
				if (!esPar(v[indice])) {
					suma += v[indice];
					if (suma > max)
						max = suma;
					buscarPar = true;
				} else {
					error = true;
				}
			}
			indice++;
		}
		return max;
	}

	private static boolean esPar(int n) {

		return n % 2 == 0;
	}

	public static void main(String[] args) {

		int[] v = { 2, -1, -4, 3, 2, -1, 8, 4, 8 };

		System.out.println("La suma del máximo subarray: " + Arrays.toString(v) + " es: " + maximoAlterno(v));

	}

}
