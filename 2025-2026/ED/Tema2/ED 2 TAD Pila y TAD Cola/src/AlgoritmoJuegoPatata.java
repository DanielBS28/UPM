import java.util.ArrayDeque;

public class AlgoritmoJuegoPatata {

    public static int jugar(int[] jugadores, int saltos) {
        Cola circulo = new Cola();
        for (int i = 0; i < jugadores.length; i++) {
            circulo.encolar(jugadores[i]);
        }
        int jugador;
        while (circulo.getNumElementos() > 1) {
            for (int i = 0; i < saltos; i++) { // Saltar n jugadores
                jugador = circulo.desencolar();
                circulo.encolar(jugador);
            }
            jugador = circulo.desencolar();  // Eliminar siguiente jugador
            System.out.println ("Eliminado el jugador " + jugador);
        }
        jugador = circulo.desencolar();
        return jugador;
    }

    // Con ArrayDeque
    public static String jugar2(String[] jugadores, int saltos) {
        ArrayDeque<String> circulo = new ArrayDeque<String>();
        for (int i = 0; i < jugadores.length; i++) {
            circulo.add(jugadores[i]);
        }
        String jugador;
        while (circulo.size() > 1) {
            for (int i = 0; i < saltos; i++) { // Saltar n jugadores
                jugador = circulo.remove();
                circulo.add(jugador);
            }
            jugador = circulo.remove();  // Eliminar siguiente jugador
            System.out.println ("Eliminado el jugador " + jugador);
        }
        jugador = circulo.remove();
        return jugador;
    }

    public static void main(String[] args) {
        int[] jugadores = new int[]{5, 3, 9, 12, 33, 22, 11, 7, 19};
        int saltos = (int)(Math.random()*10) +1;
        System.out.println("JUEGO DE LA PATATA con " + saltos + " saltos");
        System.out.print("Jugadores: ");
        for(int i = 0; i < jugadores.length; i++) {
            System.out.print(jugadores[i] + " ");
        }
        System.out.println();
        System.out.println("Gana el jugador " +
                jugar(jugadores, saltos));
    }

    /*
    // Prueba con ArrayDeque
    public static void main(String[] args) {
        String[] jugadores = new String[]{"Juan", "Ana", "Sof�a", "Carlos", "Antonio", "Sara", "Sonia", "Luis", "Bel�n"};
        int saltos = (int)(Math.random()*10);
        System.out.println("JUEGO DE LA PATATA con " + saltos + " saltos");
        System.out.print("Jugadores: ");
        for(int i = 0; i < jugadores.length; i++) {
            System.out.print(jugadores[i] + " ");
        }
        System.out.println();
        System.out.println("Gana el jugador " +
                jugar(jugadores, saltos));
    }
    */



}
