import java.util.ArrayDeque;

public class Ejercicio6 {

    public static int posicionPila(Pila pila, int valor){

        Pila pilaAux = new Pila();
        int posicion = 1;
        boolean encontrado = false;

        while(!encontrado && !pila.vacia()){
            int elem = pila.desapilar();

            pilaAux.apilar(elem);

            if(elem == valor)
                encontrado = true;
            else
                posicion++;
        }

        while(!pilaAux.vacia()){
            pila.apilar(pilaAux.desapilar());
        }
        return encontrado ? posicion : -1;

    }

    public static int posicionCola(Cola cola, int valor){

        int posicion = 1;
        boolean encontrado = false;

        for(int i = 0; i< cola.getNumElementos(); i++){

            int elem = cola.desencolar();
            if(elem == valor && !encontrado){
                posicion = (i+1);
                encontrado = true;
            }

            cola.encolar(elem);
        }
        return posicion;
    }

    public static int posicionCola2(ArrayDeque<Integer> cola, int valor){

        int posicion = 1;
        boolean encontrado = false;

        for(int i = 0; i< cola.size(); i++){

            int elem = cola.remove();
            if(elem == valor && !encontrado){
                posicion = (i+1);
                encontrado = true;
            }

            cola.add(elem);
        }
        return posicion;
    }

    static void main() {

        Pila pila = new Pila();
        Cola cola = new Cola();
        pila.apilar(7);
        pila.apilar(5);
        pila.apilar(3);
        pila.apilar(1);
        pila.apilar(9);
        pila.apilar(0);

        cola.encolar(7);
        cola.encolar(5);
        cola.encolar(3);
        cola.encolar(1);
        cola.encolar(9);
        cola.encolar(0);


        System.out.println("Pila inicial: " + pila.toString());
        System.out.println("posición del 3: " + posicionPila(pila,3));
        System.out.println("Pila final: " + pila.toString());


        System.out.println("Cola inicial: " + cola.toString());
        System.out.println("posición del 3: " + posicionCola(cola,3));
        System.out.println("Cola inicial: " + cola.toString());

        ArrayDeque<Integer> OtraCola = new ArrayDeque<Integer>();

        OtraCola.add(7);
        OtraCola.add(5);
        OtraCola.add(3);
        OtraCola.add(1);
        OtraCola.add(9);
        OtraCola.add(0);

        System.out.println("OtraCola inicial: " + OtraCola.toString());
        System.out.println("posición del 3: " + posicionCola2(OtraCola,3));
        System.out.println("OtraCola inicial: " + OtraCola.toString());



    }
}
