public class EjercicioExamen2025 {

    //Recibir una cola y devolver su capicua en esa misma cola, por ejemplo si recibo la cola 123 devolveré en la misma tad cola el número 321123

    static void capicuaInvertida(Cola cola){

        Pila pila = new Pila();
        Cola colaAux = new Cola();

        int numElementos = cola.getNumElementos();


        //Relleno en una cola auxiliar y en una pila los datos de la cola original y la vacío.
        for (int i = 0; i < numElementos; i++) {
            int dato = cola.desencolar();
            colaAux.encolar(dato);
            pila.apilar(dato);
        }

        //Relleno primero con los datos de la pila.
        while (!pila.vacia())
            cola.encolar(pila.desapilar());

        //Relleno después con los datos de la cola.
        while (!colaAux.vacia())
            cola.encolar(colaAux.desencolar());

    }

    static void main() {

        Cola cola = new Cola();

        for (int i = 0; i < 3; i++)
            cola.encolar(i + 1);

        System.out.println("Cola inicial: " + cola.toString());

        capicuaInvertida(cola);

        System.out.println("Cola final: " + cola.toString());

    }


}
