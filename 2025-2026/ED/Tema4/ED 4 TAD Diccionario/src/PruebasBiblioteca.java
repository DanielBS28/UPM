import java.util.TreeMap;

public class PruebasBiblioteca {
    public static void main(String[] args) {
        TreeMap<Integer, Alumno> diccionario = new TreeMap<Integer, Alumno>();
        Alumno pepe = new Alumno("Pepe", "Pso. La Parra");
        Alumno juan = new Alumno("Juan", "C/ El Duende");
        Alumno sandra = new Alumno("Sandra", "C/ Miralles");
        Alumno maria = new Alumno("María", "Avda. Marqués de Lino");
        diccionario.put(7, pepe);
        diccionario.put(17, juan);
        diccionario.put(1, sandra);
        diccionario.put(27, maria);
        System.out.println("Tenemos " + diccionario.size() + " alumnos.");
        Alumno alumno = diccionario.get(7);
        if (alumno != null) {
            System.out.println("Alumno con matricula 7: " + alumno.toString());
        }
        diccionario.remove(7);
        if (!diccionario.containsKey(7)) {
            System.out.println("Ahora no existe el alumno con matrícula 7");
        }
    }
}
