/**
 * @author Nombre y apellidos
 *
 */

package DefUsoListas;

public class Pruebas {

    public static void apartado5(Lista lista) {

        Evaluacion evaluacion1 = new Evaluacion("ED", "Junio 19", 4.5);
        Evaluacion evaluacion2 = new Evaluacion("ED", "Julio 19", -1);
        Evaluacion evaluacion3 = new Evaluacion("ED", "Julio 20", 7.4);
        Evaluacion evaluacion4 = new Evaluacion("Algebra", "Junio 18", 6.4);

        lista.insertar(evaluacion1);
        lista.insertar(evaluacion2);
        lista.insertar(evaluacion3);
        lista.insertar(evaluacion4);

        System.out.println("------------ EVALUACIONES EN LA LISTA -----------");
        Iterador iterador = lista.getIterador();
        while (iterador.hasNext()) {
            iterador.next().mostrar();
        }

    }

    public static void apartado6(Lista lista) {

        Evaluacion evaluacion5 = new Evaluacion("Fundamentos de programación", "Enero 26", -1);
        String [] NombresEvaluaciones = new String[]{"ED","Algebra","Fundamentos de programación"};

        System.out.println("\n------------ Apartado 5.1 -----------\n");
        for (String s : NombresEvaluaciones)
            System.out.println("Convocatorias en: " + s + ": " + lista.numConvocatorias(s));

    }


    public static void main(String[] args) {
        System.out.println("********** PRUEBAS **********");

        Lista lista = new Lista();
        apartado5(lista);
        apartado6(lista);


    }

}
