import java.util.ArrayList;
import java.util.Collections;

public class baraja {
    // Atributos
    private int tipo; // 1 = póker, 2 = española, 3 = española extendida, 4 = alemana
    private ArrayList<carta> mazo; // Lista que contiene las cartas de la baraja

    // Constructor
    public baraja(int tipo) {
        this.tipo = tipo; // Asigna el tipo de baraja
        this.mazo = new ArrayList<>(); // Inicializa el mazo como un ArrayList vacío
        inicializarBaraja(); // Llena el mazo con las cartas correspondientes
    }

    // Inicializa la baraja según el tipo
    private void inicializarBaraja() {
        mazo.clear(); // Limpia el mazo antes de llenarlo

        switch (tipo) {
            case 1: // Baraja de póker (52 cartas, 1 a 13 en 4 palos)
                for (int palo = 0; palo < 4; palo++) {
                    for (int valor = 1; valor <= 13; valor++) {
                        mazo.add(new carta(valor, palo, tipo));
                    }
                }
                break;

            case 2: // Baraja española (40 cartas, 1 a 7 y 10 a 12 en 4 palos)
                for (int palo = 0; palo < 4; palo++) {
                    for (int valor = 1; valor <= 12; valor++) {
                        if (valor != 8 && valor != 9) { // Evita los valores 8 y 9
                            mazo.add(new carta(valor, palo, tipo));
                        }
                    }
                }
                break;

            case 3: // Baraja española extendida (48 cartas, 1 a 12 en 4 palos)
                for (int palo = 0; palo < 4; palo++) {
                    for (int valor = 1; valor <= 12; valor++) {
                        mazo.add(new carta(valor, palo, tipo));
                    }
                }
                break;

            case 4: // Baraja alemana (36 cartas, 1 a 9 en 4 palos)
                for (int palo = 0; palo < 4; palo++) {
                    for (int valor = 1; valor <= 9; valor++) {
                        mazo.add(new carta(valor, palo, tipo));
                    }
                }
                break;

            default:
                System.out.println("Tipo de baraja no válido.");
        }
    }

    // Método para barajar las cartas
    public void barajar() {
        Collections.shuffle(mazo); // Mezcla las cartas del mazo de forma aleatoria
    }

    // Método para sacar la siguiente carta
    public carta siguiente() {
        if (mazo.isEmpty()) { // Comprueba si el mazo está vacío
            return null; // Devuelve null si no quedan cartas
        }
        return mazo.remove(0); // Elimina y devuelve la primera carta del mazo
    }

    // Método para reiniciar la baraja
    public void reiniciar() {
        inicializarBaraja(); // Reinicia el mazo llamando a inicializarBaraja()
    }

    // Devuelve el número de cartas restantes
    public int numCartas() {
        return mazo.size(); // Devuelve el tamaño actual del mazo (número de cartas restantes)
    }

    // Devuelve un array con todas las cartas restantes
    public carta[] getBaraja() {
        return mazo.toArray(new carta[0]); // Convierte el ArrayList en un array y lo devuelve
    }

    // Devuelve un array con las n siguientes cartas
    public carta[] getBaraja(int n) {
        int cantidad = Math.min(n, mazo.size()); // Calcula cuántas cartas se pueden devolver
        carta[] cartas = new carta[cantidad]; // Crea un array para almacenar las cartas
        for (int i = 0; i < cantidad; i++) {
            cartas[i] = mazo.get(i); // Copia las cartas del mazo al array
        }
        return cartas; // Devuelve el array de cartas
    }

    // Método toString para mostrar las cartas en el mazo
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Crea un StringBuilder para construir la cadena
        for (carta c : mazo) {
            sb.append(c.toString()).append(", "); // Añade cada carta y una coma
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : ""; // Elimina la última coma y espacio
    }
}
