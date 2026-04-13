public class Ejercicio2_9 {

    static void main() {

        Lista lista = new Lista();

        for(int i =0; i< 10; i++)
            lista.insertar(i);

        System.out.println(lista.toString());
        if(lista.contieneReorganizable(4)){
            System.out.println("Encontrado el: " +  4);
        }
        System.out.println(lista.toString());

        if(lista.contieneReorganizable(80)){
            System.out.println("Encontrado el: " +  80);
        }else
            System.out.println("No he encontrado el 80");

        System.out.println(lista.toString());

        lista.insertar(4);

        if(lista.contieneReorganizable(4)){
            System.out.println("Encontrado el: " +  4);
        }
        System.out.println(lista.toString());
    }

}
