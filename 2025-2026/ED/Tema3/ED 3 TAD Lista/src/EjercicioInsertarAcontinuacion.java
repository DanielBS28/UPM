public class EjercicioInsertarAcontinuacion {

    static void main() {

        Lista lista1 = new Lista();
        lista1.insertar(3);
        lista1.insertar(4);
        lista1.insertar(1);
        lista1.insertar(3);

        System.out.println(lista1.toString());
        lista1.insertarAcontinuacion(3,0);

        System.out.println(lista1.toString());
    }
}
