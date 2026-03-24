public class PruebasListaArray {

    public static void main(String[] args) {
        ListaArray lista = new ListaArray();
        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                lista.insertar(i);
            } else {
                lista.insertar(i * 10);
            }
        }
        System.out.println("Despues de insertar " + lista.getNumElementos() + " elementos:");
        System.out.println(lista.toString());
        System.out.println("---------------------------");
        int borrados = 0;
        for (int i = 0; i < 10; i++) {
            if (lista.borrar(i))
                borrados++;
        }
        System.out.println("Se han borrado " + borrados +" menores de 10");
        System.out.println(lista.toString());
        System.out.println("---------------------------");

        int dato1 = lista.getElemento(2);
        if (dato1 >= 0) {
            System.out.println("El tercer elemento es: " + dato1);
        }

    }

}
