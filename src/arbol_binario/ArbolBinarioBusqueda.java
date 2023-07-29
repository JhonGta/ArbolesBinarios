package arbol_binario;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda {
    public Nodo raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    // Método para insertar un nodo en el árbol
    public void insertar(String nombre, int puntaje) {
        raiz = insertarRecursivo(raiz, nombre, puntaje);//inserta nuevo nodo con el nombre y el puntaje en el arbol 
    }

    // Método recursivo para insertar un nodo en el árbol
    private Nodo insertarRecursivo(Nodo nodo, String nombre, int puntaje) {
        if (nodo == null) {
            return new Nodo(nombre, puntaje);
        }

        if (puntaje < nodo.puntaje) {//si nuevo nodo es menor al puntaje del nodo actual
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, nombre, puntaje);//inserta en subarbol izquierdo
        } else if (puntaje > nodo.puntaje) {
            nodo.derecho = insertarRecursivo(nodo.derecho, nombre, puntaje);
        }

        return nodo;
    }

    // Método para obtener el puntaje de un jugador específico
    public int obtenerPuntaje(String nombre) {
        return obtenerPuntajeRecursivo(raiz, nombre);
    }

    // Método recursivo para obtener el puntaje de un jugador específico
    private int obtenerPuntajeRecursivo(Nodo nodo, String nombre) {
        if (nodo == null) {
            return -1; // Valor para indicar que el jugador no está en el árbol
        }

        if (nombre.equals(nodo.nombre)) {
            return nodo.puntaje;
        } else if (nombre.compareTo(nodo.nombre) < 0) {
            return obtenerPuntajeRecursivo(nodo.izquierdo, nombre);
        } else {
            return obtenerPuntajeRecursivo(nodo.derecho, nombre);
        }
    }

    // Método para recorrer el árbol en orden y obtener una lista ordenada de jugadores y puntajes
    public List<String> obtenerJugadoresOrdenados() {
        List<String> resultado = new ArrayList<>(); //declaracion de tipo generica-Crea lista vacia-resultado
        obtenerJugadoresOrdenadosRecursivo(raiz, resultado);
        return resultado;
    }

    // Método recursivo para recorrer el árbol en orden   (Utilizamos la jerarquia de inorden)
    private void obtenerJugadoresOrdenadosRecursivo(Nodo nodo, List<String> resultado) {
        if (nodo != null) {
            obtenerJugadoresOrdenadosRecursivo(nodo.izquierdo, resultado);
            resultado.add(nodo.nombre + " - Puntaje: " + nodo.puntaje);
            obtenerJugadoresOrdenadosRecursivo(nodo.derecho, resultado);
            //ordenamiento inorden
        }
    }
    public String recorridoPreorden() {
        StringBuilder sb = new StringBuilder();
        recorridoPreorden(raiz, sb);
        return sb.toString();
    }

    private void recorridoPreorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            sb.append(nodo.puntaje).append(" ");//raiz
            recorridoPreorden(nodo.izquierdo, sb);
            recorridoPreorden(nodo.derecho, sb);
        }
    }

    public String recorridoInorden() {
        StringBuilder sb = new StringBuilder();
        recorridoInorden(raiz, sb);
        return sb.toString();
    }

    private void recorridoInorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            recorridoInorden(nodo.izquierdo, sb);
            sb.append(nodo.puntaje).append(" ");//raiz
            recorridoInorden(nodo.derecho, sb);
        }
    }

    public String recorridoPosorden() {
        StringBuilder sb = new StringBuilder();
        recorridoPosorden(raiz, sb);
        return sb.toString();
    }

    private void recorridoPosorden(Nodo nodo, StringBuilder sb) {
        if (nodo != null) {
            recorridoPosorden(nodo.izquierdo, sb);
            recorridoPosorden(nodo.derecho, sb);
            sb.append(nodo.puntaje).append(" ");//raiz
        }
    }
 // Método para eliminar un nodo con el nombre de un jugador específico
    public void eliminar(String nombre) {
        raiz = eliminarRecursivo(raiz, nombre);
    }
    
    
    

    // Método recursivo para eliminar un nodo con el nombre de un jugador específico
    private Nodo eliminarRecursivo(Nodo nodo, String nombre) {
        if (nodo == null) {
            return null;
        }

        if (nombre.equals(nodo.nombre)) {
            // Caso 1: Nodo sin hijos o con un solo hijo
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            // Caso 2: Nodo con dos hijos
            Nodo sucesor = encontrarSucesor(nodo.derecho);
            nodo.nombre = sucesor.nombre;//actualiza el nombre del nodo actual con el nodo sucesor encontrado
            nodo.puntaje = sucesor.puntaje;//           puntaje     //            
            nodo.derecho = eliminarRecursivo(nodo.derecho, sucesor.nombre);// elimina el sucesor del subárbol derecho del nodo actual
        } else if (nombre.compareTo(nodo.nombre) < 0) {//nombre buscando- menor -nombre nodo actual :Continua busqueda subarbolIzdo
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, nombre);
        } else {
            nodo.derecho = eliminarRecursivo(nodo.derecho, nombre);// caso contrario se busca en el derecho
        }

        return nodo;
    }
    // Método para encontrar el sucesor en un subárbol
    private Nodo encontrarSucesor(Nodo nodo) { //este metodo nos ayuda a eliminar correctamente
        Nodo actual = nodo;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual;
    }
}

