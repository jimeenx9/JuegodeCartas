import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        baraja miBaraja = null;
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Crear baraja");
            System.out.println("2. Mostrar baraja");
            System.out.println("3. Barajar la baraja");
            System.out.println("4. Sacar una carta");
            System.out.println("5. Jugar al Siete y Media");
            System.out.println("0. Salir del programa");
            System.out.print("Selecciona una opción (0-5): ");

            int opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    miBaraja = crearBaraja(sc);
                    break;

                case 2:
                    if (miBaraja != null) {
                        System.out.println("\nCartas en la baraja:");
                        System.out.println(miBaraja);
                    } else {
                        System.out.println("\nPrimero debes crear una baraja.");
                    }
                    break;

                case 3:
                    if (miBaraja != null) {
                        miBaraja.barajar();
                        System.out.println("\nLa baraja ha sido barajada.");
                    } else {
                        System.out.println("\nPrimero debes crear una baraja.");
                    }
                    break;

                case 4:
                    if (miBaraja != null) {
                        carta cartaSacada = miBaraja.siguiente();
                        if (cartaSacada != null) {
                            System.out.println("\nCarta sacada: " + cartaSacada);
                        } else {
                            System.out.println("\nNo quedan más cartas en la baraja.");
                        }
                    } else {
                        System.out.println("\nPrimero debes crear una baraja.");
                    }
                    break;

                case 5:
                    jugarSieteYMedia(sc);
                    break;

                case 0:
                    salir = true;
                    System.out.println("\n¡Saliendo del programa!");
                    break;

                default:
                    System.out.println("\nOpción no válida. Inténtalo de nuevo.");
            }
        }

        sc.close();
    }

    // Método para crear una baraja
    public static baraja crearBaraja(Scanner sc) {
        System.out.println("\nSelecciona el tipo de baraja:");
        System.out.println("1. Baraja de póker (52 cartas)");
        System.out.println("2. Baraja española (40 cartas)");
        System.out.println("3. Baraja española extendida (48 cartas)");
        System.out.println("4. Baraja alemana (36 cartas)");
        System.out.print("Opción: ");

        int tipo = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        if (tipo >= 1 && tipo <= 4) {
            System.out.println("\nBaraja creada exitosamente.");
            return new baraja(tipo);
        } else {
            System.out.println("\nTipo de baraja no válido. Se debe elegir un número entre 1 y 4.");
            return null;
        }
    }

    // Método para jugar al Siete y Media
    public static void jugarSieteYMedia(Scanner sc) {
        System.out.print("\nIntroduce el número de jugadores (mínimo 2): ");
        int numJugadores = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        if (numJugadores < 2) {
            System.out.println("\nDebe haber al menos 2 jugadores.");
            return;
        }

        System.out.println("\nSelecciona el tipo de baraja para jugar al Siete y Media:");
        System.out.println("2. Baraja española (40 cartas)");
        System.out.println("3. Baraja española extendida (48 cartas)");
        System.out.print("Opción: ");

        int tipoBaraja = sc.nextInt();
        sc.nextLine(); // Limpiar buffer

        if (tipoBaraja == 2 || tipoBaraja == 3) {
            sieteymedio juego = new sieteymedio(tipoBaraja, numJugadores);
            juego.jugar();
        } else {
            System.out.println("\nTipo de baraja no válido para Siete y Media. Elige 2 o 3.");
        }
    }
}
