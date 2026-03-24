public class ejercicio3 {

        public static int subSecuenciaMayor(int array[], int k){

            int peso = 0;
            int aux = Integer.MIN_VALUE;

            Cola cola = new Cola();

            for (int i = 0; i < k; i++) {
                cola.encolar(array[i]);
                peso += array[i];
            }

            for (int i = k; i < array.length; i++) {
                int primero = cola.desencolar();
                aux = peso + array[i] - primero;

                        if(aux > peso)
                            peso = aux;
            }
            return peso;

        }
        static void main(String[] args) {
            int array[] = { 1, 3, 5, 4, 6, 2};
            System.out.println("El número de mayor de la suma de las subsecuencias es: " + subSecuenciaMayor(array, 3));
        }

}
