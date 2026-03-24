public class PruebasCola {
    public static void main(String[] args) {
        Cola cola = new Cola(); // Se crea un objeto Cola con el constructor
        for (int i = 0; i < 5; i ++) {
            cola.encolar(i * 2);
        }
        System.out.println("Contenido de la cola:  " + cola.toString());
        int elemento = cola.desencolar();
        System.out.println("Se ha desencolado el " + elemento);
        System.out.println("La cola queda ahora:  " + cola.toString());
        System.out.println("La cola tiene " + cola.getNumElementos() + " elementos");
    }
}
