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
        String[] NombresEvaluaciones = new String[]{"ED", "Algebra", "Fundamentos de programación"};

        System.out.println("\n------------ Apartado 5.1 -----------\n");
        for (String s : NombresEvaluaciones)
            System.out.println("Convocatorias en: " + s + ": " + lista.numConvocatorias(s));

    }

    public static void apartado6_7() {

        System.out.println("\n------------ Apartado 6.7 -----------\n");


        Alumno felipe = new Alumno("Felipe García Gómez", 1253);
        Alumno alicia = new Alumno("Alicia Blázquez Martín", 5622);

        felipe.nuevaEvaluacion(new Evaluacion("ED", "Junio 19", 4.5));
        felipe.nuevaEvaluacion(new Evaluacion("ED", "Julio 19", -1));
        felipe.nuevaEvaluacion(new Evaluacion("ED", "Junio 20", 7.4)); // Usamos Junio 20 para que cuadre con la salida del PDF
        felipe.nuevaEvaluacion(new Evaluacion("Algebra", "Junio 18", 6.4));

        felipe.nuevaEvaluacion(new Evaluacion("ED", "Junio 20", 3));

        System.out.println("--------- Asignaturas aprobadas por " + felipe.getNombre() + " ---------");
        Lista aprobadasFelipe = felipe.asignaturasAprobadas();
        Iterador iterador = aprobadasFelipe.getIterador();

        while (iterador.hasNext())
            iterador.next().mostrar();

        Lista aprobadasAlicia = alicia.asignaturasAprobadas();
        Iterador iteradorAlicia = aprobadasAlicia.getIterador();
        System.out.println("--------- Asignaturas aprobadas por " + alicia.getNombre() + " ---------");

        while (iteradorAlicia.hasNext()) {
            iteradorAlicia.next().mostrar();
        }

        System.out.println("----------- MOSTRAR LOS ALUMNOS ------------");
        felipe.mostrar();
        alicia.mostrar();

    }

    public static void apartado7() {

        System.out.println("\n----------- MOSTRAR LOS ALUMNOS BIBLIOTECA ------------");

        AlumnoBib eduardo = new AlumnoBib("Eduardo Parra Martín", 8765);
        AlumnoBib sonia = new AlumnoBib("Sonia Torres Pardo", 2345);

        eduardo.nuevaEvaluacion(new Evaluacion("ED", "Junio 19", 4.5));
        eduardo.nuevaEvaluacion(new Evaluacion("ED", "Julio 19", -1));
        eduardo.nuevaEvaluacion(new Evaluacion("ED", "Junio 20", 7.4));
        eduardo.nuevaEvaluacion(new Evaluacion("Algebra", "Junio 18", 6.4));

        eduardo.mostrar();
        sonia.mostrar();
    }

    public static void main(String[] args) {
        System.out.println("********** PRUEBAS **********");
        
        // Nota: He estructurado el metodo main en funciones separadas para facilitar la
        // visualización y corrección de las pruebas de cada apartado.

        Lista lista = new Lista();
        apartado5(lista);
        apartado6(lista);
        apartado6_7();
        apartado7();

    }


}
