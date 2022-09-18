package inicio;

import abb.ABB;

public class Main {
    public static void main(String[] args) {

        ABB abb = new ABB();

        abb.insertar(4);
        abb.insertar(2);
        abb.insertar(6);
        abb.insertar(1);
        abb.insertar(3);
        abb.insertar(5);
        abb.insertar(7);

        System.out.println("---Ejercicio 5--- ");
        abb.listarAscendente();
        abb.listarDescendente();
        System.out.println("Pertenece 8 false: "+abb.pertenece(8));
        System.out.println("Pertenece 10 false: "+abb.pertenece(10));
        System.out.println("Pertenece 3 true: "+abb.pertenece(3));
        //System.out.println("Valor Eliminado 1 devuelve 1: "+abb.borrarMinimo());
        //System.out.println("Pertenece 1 true: "+abb.pertenece(1));
        System.out.println("Valor Eliminado 2 devuelve 2: "+abb.borrarMinimo());
        System.out.println("Pertenece 2 true: "+abb.pertenece(2));
        System.out.println("---Ejercicio 6--- ");
        System.out.println("Cantidad de Mayores que 4 son 3: "+abb.cantidadMayores(4));
        System.out.println("Cantidad de Mayores que 3 son 4: "+abb.cantidadMayores(3));
        System.out.println("Cantidad de Mayores que 7 son 0: "+abb.cantidadMayores(7));
        System.out.println("Lista ascendente : "+abb.elementosOrdenadosAsc());
        System.out.println("Valores que son mayores q 3 : "+abb.mostrarMayores(3));
        System.out.println("Valores que son mayores q 6 : "+abb.mostrarMayores(6));
        System.out.println("Buscar el nivel del 3 seria el 2: "+ abb.mostrarNivel(3));
        System.out.println("Buscar el nivel del 5 seria el 2: "+ abb.mostrarNivel(5));
        System.out.println("Buscar el nivel del 2 seria el 1: "+ abb.mostrarNivel(2));
        System.out.println("Buscar el nivel del 12 seria el -1: "+ abb.mostrarNivel(12));
    }

}
