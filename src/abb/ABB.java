package abb;

import java.util.ArrayList;

public class ABB {

    private Nodo raiz;

    public ABB() {
        this.raiz = null;
    }

    // Pos: Inserta el dato pasado como parametro en el arbol manteniendolo ordenado.
    public void insertar(int dato) {
        if (this.raiz == null) {
            this.raiz = new Nodo(dato);
        } else {
            insertarRec(this.raiz, dato);
        }
    }

    private void insertarRec(Nodo nodo, int dato) {
        if (dato < nodo.getDato()) {
            if (nodo.getIzq() == null) {
                nodo.setIzq(new Nodo(dato));
            } else {
                insertarRec(nodo.getIzq(), dato);
            }
        } else if (dato > nodo.getDato()) {
            if (nodo.getDer() == null) {
                nodo.setDer(new Nodo(dato));
            } else {
                insertarRec(nodo.getDer(), dato);
            }
        }

    }

    //In Order
    public void listarAscendente() {
        listarAscendente(this.raiz);
    }

    private void listarAscendente(Nodo nodo) {
        if (nodo != null) {// se puede dejar vacio  si nodo ==null
            listarAscendente(nodo.getIzq());
            System.out.println(nodo.getDato());
            listarAscendente(nodo.getDer());
        }
    }

    public void listarDescendente() {
        listarDescendente(this.raiz);
    }

    private void listarDescendente(Nodo nodo) {
        if (nodo != null) {// se puede dejar vacio  si nodo ==null

            listarDescendente(nodo.getDer());
            System.out.println(nodo.getDato());
            listarDescendente(nodo.getIzq());
        }
    }

    //Post Orden
    public void listarPostOrden() {
        listarPostOrden(this.raiz);
    }

    private void listarPostOrden(Nodo nodo) {
        if (nodo != null) {// se puede dejar vacio  si nodo ==null

            listarPostOrden(nodo.getDer());
            System.out.println(nodo.getDato());
            listarPostOrden(nodo.getIzq());
        }
    }

    public boolean pertenece(int x) {
        return pertenece(x, raiz);
    }

    private boolean pertenece(int x, Nodo nodo) {
        if (nodo == null) {
            return false;
        } else if (x == nodo.getDato()) {
            return true;
        } else {
            if (x < nodo.getDato()) {
                return pertenece(x, nodo.getIzq());
            } else {
                return pertenece(x, nodo.getDer());
            }
        }
    }

    public int borrarMinimo() {
        return borrarMinimo(raiz, 0, null);
    }

    private int borrarMinimo(Nodo nodo, int minimo, Nodo ant) {
        if (nodo != null) {
            if (nodo.getIzq() != null) {
                ant = nodo;
                int min = nodo.getDato();
                minimo = min;
                int minIzq = borrarMinimo(nodo.getIzq(), min, ant);
                return minIzq;
            } else {
                if (ant.getDer() != null) {
                    ant.setIzq(nodo.getDer());
                    return nodo.getDato();
                } else {
                    ant.setIzq(null);
                    return nodo.getDato();
                }
            }
        } else {
            return -1;
        }
    }

    /* Ejercicio 6 */
    /*Desarrolle un algoritmo que, recibiendo un valor entero k, retorne la cantidad de elementos que son mayores a k.*/
    public int cantidadMayores(int k) {
        return cantidadMayores(k, raiz);
    }

    private int cantidadMayores(int k, Nodo nodo) {

        if (nodo != null) {
            if (k < nodo.getDato()) {
                int derCant = 1 + cantidadMayores(k, nodo.getDer());
                int izqCant = cantidadMayores(k, nodo.getIzq());
                return derCant + izqCant;
            } else {
                return cantidadMayores(k, nodo.getDer());
            }
        } else {
            return 0;
        }
    }

    /*Desarrolle un algoritmo que retorne una lista con sus elementos ordenados de forma ascendente.*/
    public Lista<Integer> elementosOrdenadosAsc() {
        Lista<Integer> lista = new Lista<>();
        elementosOrdenadosAsc(raiz, lista);
        return lista;
    }

    private void elementosOrdenadosAsc(Nodo nodo, Lista<Integer> lista) {

        if (nodo != null) {
            elementosOrdenadosAsc(nodo.getIzq(), lista);
            lista.agregarAlFinal(nodo.getDato());
            elementosOrdenadosAsc(nodo.getDer(), lista);
        }

    }

    /*Desarrolle un algoritmo que, recibiendo un valor entero k, retorne una lista con los elementos que son mayores a k.*/
    public Lista<Integer> mostrarMayores(int k) {
        Lista<Integer> lista = new Lista<>();
        mostrarMayores(k, raiz, lista);
        return lista;
    }

    private void mostrarMayores(int k, Nodo nodo, Lista<Integer> lista) {

        if (nodo != null) {
            if (k < nodo.getDato()) {
                mostrarMayores(k, nodo.getIzq(), lista);
                lista.agregarAlFinal(nodo.getDato());
                mostrarMayores(k, nodo.getDer(), lista);

            } else {
                mostrarMayores(k, nodo.getDer(), lista);
            }
        }
    }

    public int mostrarNivel(int k) {
        int nivel = 0;
        return mostrarNivel(k, raiz, nivel);
    }

    private int mostrarNivel(int k, Nodo nodo, int nivel) {
        if (nodo != null) {
            if (k == nodo.getDato()) {
                return nivel;
            } else {
                nivel++;
                if (k > nodo.getDato()) {
                    return mostrarNivel(k, nodo.getDer(), nivel);
                } else {
                    return mostrarNivel(k, nodo.getIzq(), nivel);
                }
            }
        } else {
            return -1;
        }
    }

    public int cantidad(int menor, int mayor) {
        return cantidad(raiz, menor, mayor);
    }

    public int cantidad(Nodo nodo, int menor, int mayor) {
        if (nodo == null) {
            return 0;
        } else {
            if (nodo.getDato() >= menor && nodo.getDato() <= mayor) {
                int izqNodoCant = 1 + cantidad(nodo.getIzq(), menor, mayor);
                int derNodoCant = cantidad(nodo.getDer(), menor, mayor);
                return izqNodoCant + derNodoCant;
            } else if (nodo.getDato() <menor) {
                return cantidad(nodo.getDer(), menor, mayor);
            } else {
                return cantidad(nodo.getIzq(), menor, mayor);
            }
        }
    }

    public int cantidadV2(int menor, int mayor) {
        return cantidad(raiz, menor, mayor, 0);
    }
    public int cantidad(Nodo nodo, int min, int max, int cant) {

        if (nodo != null) {

            int cantI = 0;
            int cantD = 0;

            if (nodo.getDato() > min) {
                cantI = cantidad(nodo.getIzq(), min, max, cant);
            }

            if(nodo.getDato() < max){
                cantD = cantidad(nodo.getDer(), min, max, cant);
            }

            cant = cantD + cantI;

            if (nodo.getDato() >= min && nodo.getDato() <= max) {
                cant++;
            }
            return cant;

        } else {
            return 0;
        }

    }



}
