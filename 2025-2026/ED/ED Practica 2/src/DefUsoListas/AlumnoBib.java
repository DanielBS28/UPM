/**
 * @author Nombre y apellidos
 *
 */

package DefUsoListas;

import java.util.Iterator;
import java.util.LinkedList;

public class AlumnoBib {

    private String nombre;
    private int matricula;
    private LinkedList<Evaluacion> expediente;

    public AlumnoBib(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        expediente = new LinkedList<>();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean nuevaEvaluacion(Evaluacion evaluacion) {

        Iterator <Evaluacion> iterador = expediente.iterator();

        while (iterador.hasNext()) {

            Evaluacion EvaluacionActual = iterador.next();

            if (EvaluacionActual.mismaEvaluacion(evaluacion)) {
                if (EvaluacionActual.getNota() == evaluacion.getNota())
                    return true;
                else {
                    System.out.println("Calificación previamente insertada con nota: " + EvaluacionActual.getNota());
                    return false;
                }
            }
        }
        expediente.add(evaluacion);

        return true;
    }

    public boolean estaAprobado(String nombreAsig) {
        Iterator <Evaluacion> iterador = expediente.iterator();
        boolean aprobado = false;

        while (iterador.hasNext() && !aprobado) {

            Evaluacion evaluacionActual = iterador.next();

            if (evaluacionActual.getNombreAsignatura().equals(nombreAsig) && evaluacionActual.getNota() >= 5.0) {
                aprobado = true;
            }
        }
        return aprobado;
    }

    public Lista asignaturasAprobadas() {

        Iterator <Evaluacion> iterador = expediente.iterator();
        Lista asignaturasAprobadas = new Lista();

        while (iterador.hasNext()) {

            Evaluacion evaluacionActual = iterador.next();

            if (evaluacionActual.getNota() >= 5)
                asignaturasAprobadas.insertar(evaluacionActual);
        }
        return asignaturasAprobadas;
    }

    public double mediaAprobadas() {

		/* Opción sin usar asignaturass aprobadas
		double media = 0;
		int aprobadas = 0;

		Iterador iterador = expediente.getIterador();

		while (iterador.hasNext()){

			Evaluacion evaluacionActual = iterador.next();
			if(evaluacionActual.getNota() >= 5){
				aprobadas++;
				media += evaluacionActual.getNota();
			}
		}

		if(aprobadas != 0)
			media /= aprobadas;

		return media;*/

        double media = 0;
        Lista listaAprobadas = asignaturasAprobadas();
        int cantidadAprobadas = listaAprobadas.getNumElementos();

        if (cantidadAprobadas == 0)
            return media;

        Iterador iterador = listaAprobadas.getIterador();

        while (iterador.hasNext())
            media += iterador.next().getNota();

        return media / cantidadAprobadas;

    }

    public int getNumAprobadas() {

        return this.asignaturasAprobadas().getNumElementos();  // Eliminar esta línea
    }

    public void mostrar() {

        Iterator <Evaluacion>  iterador = expediente.iterator();

        System.out.println(this.getNombre() + ". Matrícula: " + this.getMatricula());

        if (!expediente.isEmpty()) {

            while (iterador.hasNext()) {

                Evaluacion evaluacionActual = iterador.next();
                System.out.println("\t" + evaluacionActual.getNombreAsignatura() + " " +
                        "(" + evaluacionActual.getConvocatoria() + "): " +
                        (evaluacionActual.getNota() >= 0 ? evaluacionActual.getNota() : "NP"));

            }
            System.out.println(expediente.size() + " evaluaciones y " + this.getNumAprobadas() +
                    " asignaturas aprobadas con calificación media " + this.mediaAprobadas());
        } else
            System.out.println("No ha realizado ninguna evaluación.");
        System.out.println("------------------------------");

    }
}


