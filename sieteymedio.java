import java.util.Scanner;

public class sieteymedio {
    private baraja barajaJuego;
    private double[] puntuaciones;
    private int numJugadores;

    // Constructor
    public sieteymedio(int tipoBaraja, int numJugadores) {
        this.barajaJuego = new baraja(tipoBaraja);
        this.numJugadores = numJugadores;
        this.puntuaciones = new double[numJugadores];
        barajaJuego.barajar();
    }

    // Método para jugar al Siete y Media
    public void jugar() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n¡Comienza el juego de Siete y Media!");
        boolean[] jugadoresEnJuego = new boolean[numJugadores];
        for (int i = 0; i < numJugadores; i++) {
            jugadoresEnJuego[i] = true;
        }

        for (int i = 0; i < numJugadores; i++) {
            System.out.println("\nTurno del Jugador " + (i + 1));
            while (jugadoresEnJuego[i]) {
                System.out.println("Puntuación actual: " + puntuaciones[i]);
                System.out.print("¿Quieres sacar una carta? (s/n): ");
                String respuesta = sc.nextLine().toLowerCase();

                if (respuesta.equals("s")) {
                    carta cartaSacada = barajaJuego.siguiente();
                    if (cartaSacada != null) {
                        System.out.println("Has sacado: " + cartaSacada);
                        double valorCarta = obtenerValorCarta(cartaSacada);
                        puntuaciones[i] += valorCarta;

                        System.out.println("Valor de la carta: " + valorCarta);
                        System.out.println("Nueva puntuación: " + puntuaciones[i]);

                        if (puntuaciones[i] > 7.5) {
                            System.out.println("¡Te has pasado de 7.5! Turno terminado.");
                            jugadoresEnJuego[i] = false;
                        }
                    } else {
                        System.out.println("No quedan más cartas en la baraja.");
                        jugadoresEnJuego[i] = false;
                    }
                } else if (respuesta.equals("n")) {
                    System.out.println("Te has plantado con una puntuación de: " + puntuaciones[i]);
                    jugadoresEnJuego[i] = false;
                } else {
                    System.out.println("Respuesta no válida. Por favor, introduce 's' para sí o 'n' para no.");
                }
            }
        }

        // Mostrar puntuaciones finales
        System.out.println("\nPuntuaciones finales:");
        for (int i = 0; i < numJugadores; i++) {
            System.out.println("Jugador " + (i + 1) + ": " + puntuaciones[i]);
        }

    }

    // Método para obtener el valor de una carta
    private double obtenerValorCarta(carta c) {
        int valor = c.getValor();
        if (valor >= 10) {
            return 0.5; // Las figuras valen 0.5 puntos
        } else {
            return (double) valor;
        }
    }
}
