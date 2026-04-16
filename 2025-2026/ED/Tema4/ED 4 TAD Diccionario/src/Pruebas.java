public class Pruebas {
    public static void main(String[] args) {
        Diccionario diccionario = new Diccionario();
        Alumno pepe = new Alumno("Pepe", "Pso. La Parra");
        Alumno juan = new Alumno("Juan", "C/ El Duende");
        Alumno sandra = new Alumno("Sandra", "C/ Miralles");
        Alumno maria = new Alumno("María", "Avda. Marqués de Lino");
        diccionario.insertar(7, pepe);
        diccionario.insertar(17, juan);
        diccionario.insertar(1, sandra);
        diccionario.insertar(27, maria);
        System.out.println("Tenemos " + diccionario.getNumElementos() +
                " alumnos.");
        Alumno alumno = diccionario.getElemento(7);
        if (alumno != null) {
            System.out.println("Alumno con matricula 7: " + alumno.toString());
        } else {
            System.out.println("No existe el alumno con matrícula 7");
        }
        diccionario.borrar(7);
        if (diccionario.contiene(7)) {
            System.out.println("\nSigue existiendo el alumno con matrícula 7");
        } else {
            System.out.println("\nAhora no existe el alumno con matrícula 7");
        }
        System.out.println("Tenemos " + diccionario.getNumElementos() +
                " alumnos.");
    }

}
