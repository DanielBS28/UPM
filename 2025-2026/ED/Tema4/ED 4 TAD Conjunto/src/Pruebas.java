public class Pruebas {
    public static void main(String[] args) {
        Conjunto conjunto = new Conjunto();
        conjunto.insertar(7);
        conjunto.insertar(17);
        conjunto.insertar(1);
        conjunto.insertar(27);
        System.out.println("Tenemos " + conjunto.getNumElementos() + " enteros.");
        if (conjunto.contiene(7)) {
            System.out.println("Contiene el elemento 7:");
        } else {
            System.out.println("No contiene el elemento 7");
        }
        conjunto.borrar(7);
        if (conjunto.contiene(7)) {
            System.out.println("\nSigue existiendo el elemento 7");
        } else {
            System.out.println("\nAhora no existe el elemento 7");
        }
    }

}
