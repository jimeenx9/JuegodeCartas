public class carta {
    private int valor;
    private int palo;
    private int tipo; // 1.poker 2.española 3.española extendida

    //Constructor
    public carta (int valor, int palo, int tipo) {
        setValor(valor);
        setPalo(palo);
        this.tipo = tipo;

    }

    //Getters

    public int getValor() {
        return valor;
    }

    public int getPalo() {
        return palo;
    }

    public int getTipo() {
        return tipo;
    }

    //Setters con validación

    public void setValor(int valor){
        if (valor > 0){
            this.valor = valor;
        } else {
            throw new IllegalArgumentException("Valor de carta inválido");
        }
    }
    public void setPalo(int palo) {
        if (palo >= 0) {
            this.palo = palo;
        } else {
            throw new IllegalArgumentException("Palo de carta inválido");
        }
    }

    @Override

        public String toString(){    //Este método convierte numeros (palo) en nombres como "Corazones"
            String paloNombre = "";
            String tipoNombre = "";
        

        switch (tipo) {
                case 1: //Póker
                tipoNombre = "Póker";
                switch (palo) {
                    case 0: paloNombre = "Corazones"; break;
                    case 1: paloNombre = "Diamantes"; break;
                    case 2: paloNombre = "Tréboles"; break;
                    case 3: paloNombre = "Picas"; break;

                    default: paloNombre = "Palo desconocido"; break;
                }
                break;
                case 2: // Española
                case 3: // Española Extendida
                    
                    if (tipo == 2){

                        tipoNombre = "Española";
                    } else{
                        tipoNombre = "Española extendida";
                    }
                    
                    switch (palo) {
                        case 0: paloNombre = "Oros"; break;
                        case 1: paloNombre = "Copas"; break;
                        case 2: paloNombre = "Espadas"; break;
                        case 3: paloNombre = "Bastos"; break;

                        default: paloNombre = "Palo desconocido"; break;
                    }
                    break;

                    case 4: // Alemana
                    tipoNombre = "Alemana";
                        switch (palo) {
                            case 0: paloNombre = "Campanas"; break;
                            case 1: paloNombre = "Pastos"; break;
                            case 2: paloNombre = "Corazones"; break;
                            case 3: paloNombre = "Bellotas"; break;

                        default: paloNombre = "Palo desconocido"; break;
                    }
                    break;
    
                default:
                    tipoNombre = "Tipo desconocido";
            }
    
            return String.format("Carta: Valor=%d, Palo=%s, Tipo=%s", valor, paloNombre, tipoNombre);
        }
            // Método equals() para comparar cartas
    public boolean equals(carta c) { //c = comparada = Nombre
        return this.valor == c.valor && this.palo == c.palo && this.tipo == c.tipo;
    }

    // Método clone() para clonar una carta
    public carta clone() {
        return new carta(this.valor, this.palo, this.tipo);
    }

    // Método para comparar el número de dos cartas
    public boolean compararNumero(carta c) {
        return this.valor == c.valor;
    }

    // Método para comparar el palo de dos cartas
    public boolean compararPalo(carta c) {
        return this.palo == c.palo;
    }

    // Método para determinar si una carta es mayor que otra
    public boolean mayorQue(carta c) {
        return this.valor > c.valor;
}
}
