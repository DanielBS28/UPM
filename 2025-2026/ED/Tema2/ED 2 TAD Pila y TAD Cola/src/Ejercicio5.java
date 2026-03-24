public class Ejercicio5 {

    public static void invertirCola(Cola cola){

        Pila pila = new Pila();

        while (!cola.vacia())
            pila.apilar(cola.desencolar());

        while(!pila.vacia())
            cola.encolar(pila.desapilar());

        System.out.println("Cola final: " + cola.toString());
    }

    static void main() {

        Cola cola = new Cola();

        cola.encolar(7);
        cola.encolar(5);
        cola.encolar(3);
        cola.encolar(1);
        cola.encolar(8);

        System.out.println("Cola inicial: " + cola.toString());

        invertirCola(cola);

    }
}