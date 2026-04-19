public class Lista {
    private Nodo inicio, fin;
    private int numElementos;

    // Inicializa una lista vac�a (sin elementos)
    public Lista() {
        inicio = null;
        fin = null;
        numElementos = 0;
    }

    // Determina si la lista est� vac�a o no (sin elementos)
    public boolean vacia() {
        return inicio == null;
    }

    // A�ade un nuevo dato al final de la lista
    public void insertar(int dato) {
        Nodo nuevo = new Nodo(dato, null);  // Crear un nodo nuevo
        if (inicio == null) {  // Insertar el nodo al final de la lista enlazada
            inicio = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        numElementos++;
    }


    // Devuelve el elemento que ocupa una posicion dada.
    // Si no existe la posici�n, devuelve -1
    public int getElemento(int posicion) {
        if (posicion < 0 || posicion >= numElementos) {
            return -1;
        } else {
            // Avanzar en la lista enlazada tantos nodos como indique posicion
            Nodo actual = inicio;
            for (int i = 0; i < posicion; i++) {
                actual = actual.getSiguiente();
            }
            return actual.getDato();
        }
    }

    // Almacena elemento en la posicion indicada por posicion
    // Si la posici�n es incorrecta, devuelve false
    public boolean setElemento(int dato, int posicion) {
        if (posicion < 0 || posicion >= numElementos) {
            return false;
        } else {
            Nodo actual = inicio;
            for (int i = 0; i < posicion; i++) {
                actual = actual.getSiguiente();
            }
            actual.setDato(dato);
            return true;
        }
    }

    // Borra la primera ocurrencia del par�metro dato (si existe)
    public boolean borrar(int dato) {
        Nodo actual = inicio;
        Nodo anterior = null;
        while (actual != null && actual.getDato() != dato) {
            anterior = actual;
            actual = actual.getSiguiente();
        }
        if (actual != null) {  // dato encontrado.
            if (actual == inicio) {   // Borrar el primero de la lista
                inicio = actual.getSiguiente();
            } else {  // Borrar nodo que no es el primero
                anterior.setSiguiente(actual.getSiguiente());
            }
            if (actual == fin) {  // Se ha borrado el �ltimo de la lista
                fin = anterior;
            }
            numElementos--;
            return true;
        } else {
            return false;
        }
    }

    // Devuelve la primera posici�n en la que se encuentra el par�metro dato (si existe)
    public int posicion(int dato) {
        Nodo actual = inicio;
        int posicion = 0;
        while (actual != null && actual.getDato() != dato) {
            actual = actual.getSiguiente();
            posicion++;
        }
        if (actual != null) {  // Dato encontrado
            return posicion;
        } else {
            return -1;
        }
    }

    // Determina si el par�metro dato existe en la lista.
    public boolean contiene(int dato) {
        return this.posicion(dato) >= 0;
    }

    // Devuelve el n�mero de elementos que tiene la lista
    public int getNumElementos() {
        return numElementos;
    }

    // Devuelve un iterador para recorrer la lista desde el principio
    public Iterador getIterador() {
        return new Iterador(inicio);
    }

    // Devuelve una representaci�n de la lista en forma de String.
    public String toString() {
        String resultado = "[";
        if (!this.vacia()) {
            resultado +=inicio.getDato();
            Nodo actual = inicio.getSiguiente();
            while (actual != null) {
                resultado += "," + actual.getDato();
                actual = actual.getSiguiente();
            }
        }
        resultado += "]";
        return resultado;
    }

    public void insertarCeros(){

            int suma = 0;
            Nodo actual = inicio;

            while(actual != null){
                suma += actual.getDato();
                actual = actual.getSiguiente();
            }

            actual = inicio;
            while(actual != null){

                if(actual.getDato() == suma){
                    Nodo nuevoNodo = new Nodo(0,actual.getSiguiente());
                    actual.setSiguiente(nuevoNodo);
                    actual = nuevoNodo.getSiguiente();
                }else
                    actual = actual.getSiguiente();
            }
    }

    public void aniadirSumaMayoresDe(int dato){

        if(inicio == null){
            Nodo nuevo = new Nodo(dato, null);
            inicio = nuevo;
        }else{
            Nodo actual = inicio;
            int suma = 0;
            while(actual != null){
                if(actual.getDato() > dato)
                    suma += actual.getDato();
                actual = actual.getSiguiente();
            }

            Nodo nuevo = new Nodo(suma, null); // PODRÍA HABER PUESTO EN VEZ DE NULL: INICIO
            nuevo.setSiguiente(inicio);
            inicio = nuevo;

            // PODRÍA HABER PUESTO
            // inicio = new Nodo(suma, inicio); el mismo codigo de antes pero en una sola línea.

        }

        numElementos++;

    }

    public void triplicar(){

        Nodo actual = inicio;
        while(actual != null){
            //Tratar nodo

            Nodo nuevo1 = new Nodo(actual.getDato(),actual.getSiguiente());
            Nodo nuevo2 = new Nodo(actual.getDato(), nuevo1);
            actual.setSiguiente(nuevo2);
            actual = nuevo1.getSiguiente();
            numElementos += 2;
        }
    }

    //Ejercicio 2.7

    public void insertarAcontinuacion(int base, int num_insertar){

        Nodo actual = this.inicio;

        while(actual != null){
            if(actual.getDato() != base){
                actual = actual.getSiguiente();
            }else{

                Nodo nuevo = new Nodo(num_insertar, actual.getSiguiente());
                actual.setSiguiente(nuevo);
                numElementos++;
                actual = nuevo.getSiguiente();
            }
        }

    }

    //Ejercicio 2.3

    public void imagenEspecular(){

        Nodo actual = inicio;

        while(actual != null){
            Nodo nuevo = new Nodo(actual.getDato(), inicio);
            inicio = nuevo;
            numElementos++;
            actual = actual.getSiguiente();
        }

    }

    // Ejercicio 2.9
    public boolean contieneReorganizable(int valor){

        boolean encontrado = false;
        Nodo actual = inicio;
        Nodo anterior = null;
        while(actual != null && actual.getDato() != valor){
            anterior = actual;
            actual = actual.getSiguiente();

        }
        if(actual != null){

            if(actual != inicio){
                // ¡Si el objeto es NULL no se pueden ejecutar métodos!
                anterior.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(inicio);
                inicio = actual;
            }

            return true;
        }else
            return false;

    }

    public void eliminarRepetidos(int dato) {

        // 1. Caso base: Si la lista está vacía, no hay nada que hacer.
        if (this.inicio == null) {
            return;
        }

        // 2. Variables de control
        boolean encontrado = false;
        Nodo actual = this.inicio;
        Nodo anterior = null;

        // 3. Recorremos la lista hasta llegar al final (null)
        while (actual != null) {

            // ¿El nodo actual tiene el número que buscamos?
            if (actual.getDato() == dato) {

                if (!encontrado) {
                    // Es la PRIMERA vez. Lo marcamos y lo perdonamos.
                    encontrado = true;
                    anterior = actual; // El anterior avanza normalmente
                } else {
                    // Ya lo habíamos visto. ¡Toca borrarlo!
                    // Hacemos que el nodo anterior apunte al nodo que va después del actual,
                    // "saltándonos" el nodo actual y dejándolo desconectado.
                    anterior.setSiguiente(actual.getSiguiente());

                    // IMPORTANTE: Actualizamos el tamaño de la lista
                    this.numElementos--;

                    // OJO AQUÍ: Cuando borramos, NO movemos el puntero 'anterior'.
                    // Se queda apuntando donde estaba, esperando al siguiente ciclo.
                }

            } else {
                // Si no es el número que buscamos, los punteros avanzan normalmente
                anterior = actual;
            }

            // El puntero actual SIEMPRE avanza para seguir explorando la lista
            actual = actual.getSiguiente();
        }

        /*OTRA ALTERNATIVA

        // OJO: Forma alternativa usando solo un puntero
Nodo actual = this.inicio;

while (actual != null && actual.getSiguiente() != null) {

    // Miramos el dato del nodo que va DESPUÉS del nuestro
    if (actual.getSiguiente().getDato() == dato) {

        // Hacemos el puente saltándonos el siguiente
        actual.setSiguiente(actual.getSiguiente().getSiguiente());
        this.numElementos--;

    } else {
        // Solo avanzamos si no hemos borrado nada
        actual = actual.getSiguiente();
    }
}
        *
        * */
    }

}
