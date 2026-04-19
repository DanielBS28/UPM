public class ejercicio3 {

        public static int subSecuenciaMayor(int array[], int k){

            int peso = 0;
            int aux = Integer.MIN_VALUE;

            Cola cola = new Cola();

            //Encolo los k primeros números y hago su suma.
            for (int i = 0; i < k; i++) {
                cola.encolar(array[i]);
                peso += array[i];
            }

            //Empezando en i = k (los posteriores a los k primeros, desencolo el primero y se los resto a una variable auxiliar donde tenia el peso y el array con un nuevo número)
            for (int i = k; i < array.length; i++) {
                int primero = cola.desencolar();
                aux = peso + array[i] - primero;

                //Si el auxiliar es > peso entonces peso = aux
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
