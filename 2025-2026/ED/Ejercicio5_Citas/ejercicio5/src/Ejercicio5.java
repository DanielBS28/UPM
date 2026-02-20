public class Ejercicio5 {

    static void main() {

        Cita cita1 = new Cita("Daniel", "123456789",20,16,00);
        Cita cita2 = new Cita("Javier", "987654321",30,15,30);
        Cita cita3 = new Cita("Alberto", "123456789",20,16,30);

        System.out.println(cita1.toString());
        System.out.println(cita2.toString());

        Agenda agenda = new Agenda("Enero",100);
        agenda.insertarCita(cita1);
        agenda.insertarCita(cita2);
        agenda.insertarCita(cita3);


        System.out.println("Contenido de la agenda");
        agenda.mostrarCitas2();
        agenda.mostrarCitasDia(20);
        agenda.eliminarCita(2);
        agenda.mostrarCitas2();
    }
}
