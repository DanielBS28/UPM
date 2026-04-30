public class PruebasEjercicios {

    static void main() {
        ArbolBinarioBusqueda abb = new ArbolBinarioBusqueda();

        //Hay que insertar por niveles
        abb.insertar(50);

        abb.insertar(25);
        abb.insertar(75);

        abb.insertar(15);
        abb.insertar(40);
        abb.insertar(60);
        abb.insertar(90);

        abb.insertar(13);
        abb.insertar(21);
        abb.insertar(32);
        abb.insertar(45);
        abb.insertar(58);
        abb.insertar(64);

        abb.insertar(11);
        abb.insertar(14);
        abb.insertar(43);
        abb.insertar(59);

        abb.insertar(10);

        abb.mostrarClavesDescendentes();
        System.out.println("\n-------------------------");
        abb.mostrarUnHijoDescendentes();
        System.out.println("\n-------------------------");
        abb.mostrarClavesEntreDos(57,90);




    }

}
