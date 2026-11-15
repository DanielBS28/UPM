package upm.etsisi.poo.citim21_13;

public class App {

	public static void main(String[] args) {

		GestorParque.getInstancia();
		Persistencia.inicializar();
		LecturaComandos.iniciar(args);

	}
}
