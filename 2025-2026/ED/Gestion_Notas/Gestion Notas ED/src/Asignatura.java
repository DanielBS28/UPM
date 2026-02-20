public class Asignatura {

    private String nombre;
    private Alumno ALUMNOS[];
    private int num_alumnos;

    public Asignatura(String nombre, int max_alumnos){
        this.nombre = nombre;
        ALUMNOS = new Alumno[max_alumnos];
        num_alumnos= 0;
    }

    public boolean insertar(Alumno alumno){
        boolean resultado = false;
        if(ALUMNOS.length > num_alumnos){
            ALUMNOS[num_alumnos] = alumno;
            num_alumnos++;
            resultado = true;
        }

        return resultado;
    }

    public int getNum_alumnos() {
        return num_alumnos;
    }

    public void verCalificaciones(){
        System.out.println(nombre + ": " + num_alumnos + " alumnos");

        for (int i = 0; i < num_alumnos; i++) {
            System.out.println(ALUMNOS[i].getNombre() +  " (" + ALUMNOS[i].getMatricula()+") " + "NOTA: " +ALUMNOS[i].notaFinal());
        }
    }
}
