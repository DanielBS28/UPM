public class Ejercicio7 {

    static Pila pilaMenores(Cola cola1, Cola cola2){

        Pila pila = new Pila();

        while(!cola1.vacia() && !cola2.vacia()){

            if(cola1.getPrimero() > cola2.getPrimero())
                pila.apilar(cola1.desencolar());
            else
                pila.apilar(cola2.desencolar());
        }

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
