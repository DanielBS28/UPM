public class Cita {

    private String paciente, telefono;
    private int dia, hora, minuto;

    public Cita(String paciente, String telefono, int dia, int hora, int minuto){

        this.paciente = paciente;
        this.telefono = telefono;
        this.dia = dia;
        this.minuto = minuto;
        this.hora = hora;
    }

    public String getPaciente(){
        return paciente;
    }

    public int getDia(){
        return dia;
    }

    public String toString(){
        return paciente + " (" + telefono + ") - " + dia + ", " + hora+":" + minuto;
    }
}
