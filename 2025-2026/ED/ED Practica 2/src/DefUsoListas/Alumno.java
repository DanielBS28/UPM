/**
 * @author Nombre y apellidos
 * */

package DefUsoListas;

public class Alumno {

	private String nombre;
	private int matricula;
	private Lista expediente;

	public Alumno(String nombre, int matricula) {
		this.nombre = nombre;
		this.matricula = matricula;
		expediente = new Lista();
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

		Iterador iterador = expediente.getIterador();

		while(iterador.hasNext()){

			Evaluacion EvaluacionActual = iterador.next();

			if(EvaluacionActual.mismaEvaluacion(evaluacion)){
				if(EvaluacionActual.getNota() == evaluacion.getNota())
					return true;
				else {
					System.out.println("Calificación previamente insertada con nota: " + EvaluacionActual.getNota());
					return false;
				}
			}
		}
			expediente.insertar(evaluacion);

		return true;
	}

	public boolean estaAprobado(String nombreAsig) {
		Iterador iterador = expediente.getIterador();
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

		Iterador iterador = expediente.getIterador();
		Lista asignaturasAprobadas = new Lista();

		while (iterador.hasNext()){

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

		if (cantidadAprobadas  == 0)
			return media;

		Iterador iterador = listaAprobadas.getIterador();

		while (iterador.hasNext())
			media += iterador.next().getNota();

		return media/cantidadAprobadas;

	}

	public int getNumAprobadas() {

		return this.asignaturasAprobadas().getNumElementos();  // Eliminar esta línea
	}

	public void mostrar() {
		// TODO
	}

}


