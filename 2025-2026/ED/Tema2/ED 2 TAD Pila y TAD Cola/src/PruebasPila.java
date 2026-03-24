public class PruebasPila {
    public static void main(String[] args) {

        PilaArray pila = new PilaArray();   // Probamos PilaArray
        // Pila pila = new Pila();   // Probamos  Pila

        for (int i = 0; i < 5; i++) {
            pila.apilar(i);
        }
        pila.apilar(19);
        pila.apilar(24);
        pila.apilar(48);

        System.out.println("Contenido de la pila: " + pila.toString());
        System.out.println("Sacamos un elemento de la pila: "
                + pila.desapilar());
        System.out.println("Ahora la cima de la pila es " + pila.getCima());
        System.out.println("Y el número de elementos de la pila es "
                + pila.getNumElementos());
        System.out.println("Contenido de la pila: " + pila.toString());

    }



}
