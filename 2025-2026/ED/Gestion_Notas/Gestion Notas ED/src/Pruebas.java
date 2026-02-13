public class Pruebas {
    public static void main(String[] args) {
        Alumno felipe = new Alumno("Felipe Arias González", "aa1253");
        felipe.calificarParcial1(9);
        felipe.calificarPractica2(5, 7.1);
        felipe.calificarParcial2(6.1);
        felipe.calificarPractica3(10, 7);
        felipe.mostrarDetalleNotas();
    }

}
