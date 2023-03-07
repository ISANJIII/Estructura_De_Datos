package lineales.estaticas;

public class Pila {

    private int TAMANIO;
    private Object[] arreglo;
    private int tope;

    public Pila() {
        TAMANIO = 10;
        arreglo = new Object[TAMANIO];
        tope = -1;
    }

    public boolean apilar(Object nuevoElem) {
        boolean exito = false;
        // verificar si hay espacio
        if (tope + 1 < TAMANIO) {
            // HAY ESPACIO
            this.tope++;
            this.arreglo[tope] = nuevoElem;
            exito = true;
        }
        return exito;
    }

    public boolean desapilar() {
        boolean exito = false;

        if (!this.esVacia()) {
            // no esta vacia
            this.arreglo[tope] = null;
            tope--;
            exito = true;
        }

        return exito;
    }

    public Object obtenerTope() {
        Object elem = null;
        if (!this.esVacia()) {
            // verificar que no este vacia
            elem = this.arreglo[tope];
        }

        return elem;
    }

    public boolean esVacia() {
        return tope == -1;
    }

    public void vaciar() {

        while (this.tope != -1) {
            this.arreglo[tope] = null;
            tope--;
        }

    }

    public Pila clone() {
        Pila clon = new Pila();
        if (!esVacia()) {
            // no esta vacia
            int i = 0;
            while (i <= this.tope) {
                clon.arreglo[i] = this.arreglo[i];
                i++;
            }
        }
        return clon;
    }

    public String toString() {
        String texto;
        texto = "";
        if (this.esVacia()) {
            texto = "PILA VACIA";
        } else {
            texto = "{";
            int i = 0;
            while (i <= this.tope) {
                texto = texto + this.arreglo[i];
                if (i < this.tope) {
                    texto += ",";
                }
            }
            texto = texto + "}";
        }

        return texto;
    }

}