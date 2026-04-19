public class Ejercicio7 {

    static Pila pilaMenores(Cola cola1, Cola cola2){

        Pila pila = new Pila();

        //Mientras haya elementos en las dos colas
        while(!cola1.vacia() && !cola2.vacia()){

            //Si el primer elemento de la cola1 es mayor que el de la cola2 es mayor, se apila en nuestra cola ese elemento
            if(cola1.getPrimero() > cola2.getPrimero())
                pila.apilar(cola1.desencolar());
            else //Si no es que el de la cola2 era mayor
                pila.apilar(cola2.desencolar());
        }

        //Una de las dos colas se ha tenido que vaciar si me salí del while... en estos dos while rellene la cola a devolver
        while(!cola1.vacia())
            pila.apilar(cola1.desencolar());

        while(!cola2.vacia())
            pila.apilar(cola2.desencolar());

        return pila;


    }

    static void main() {

        Cola cola1 = new Cola();
        Cola cola2 = new Cola();

        cola1.encolar(1);
        cola1.encolar(5);
        cola1.encolar(5);
        cola1.encolar(6);
        cola1.encolar(9);

        cola1.encolar(4);
        cola1.encolar(6);
        cola1.encolar(7);
        cola1.encolar(15);

        Pila pila3 = pilaMenores(cola1 , cola2);
    }
}
