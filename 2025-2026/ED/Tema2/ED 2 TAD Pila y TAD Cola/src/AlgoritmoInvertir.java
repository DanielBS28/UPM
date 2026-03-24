import java.util.Stack;

public class AlgoritmoInvertir {
    public static void invertir(int[] vector) {
        Pila pilaAux = new Pila();
        int posicion = 0;
        for (int i = 0; i < vector.length; i++) {
            pilaAux.apilar(vector[i]);
        }
        while (!pilaAux.vacia()) {
            vector[posicion] = pilaAux.desapilar();
            posicion++;
        }
    }

    public static void invertir2(int[] vector) {
        Stack<Integer> pilaAux = new Stack<Integer>();
        int posicion = 0;
        for (int i = 0; i < vector.length; i++) {
            pilaAux.push(vector[i]);
        }
        while (!pilaAux.empty()) {
            vector[posicion] = pilaAux.pop();
            posicion++;
        }
    }

    public static void main(String[] args) {
        int[] vector = new int[10];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = i * i;
        }
        System.out.print("Array antes de invertir: ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(" " + vector[i]);
        }
        System.out.println();
        invertir(vector);
        System.out.print("Array después de invertir: ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(" " + vector[i]);
        }
        System.out.println();

    }
}
