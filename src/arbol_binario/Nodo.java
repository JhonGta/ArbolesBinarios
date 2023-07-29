package arbol_binario;

public class Nodo {
    public int puntaje;
    public String nombre;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.izquierdo = null;
        this.derecho = null;
    }

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Nodo getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(Nodo izquierdo) {
		this.izquierdo = izquierdo;
	}

	public Nodo getDerecho() {
		return derecho;
	}

	public void setDerecho(Nodo derecho) {
		this.derecho = derecho;
	}
    
}