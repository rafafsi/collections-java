package br.com.dio.collection.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ExemploLinkedList {
    public static void main(String[] args) {

        Queue<String> filaDeBanco = new LinkedList<>();

        filaDeBanco.add("jesus");
        filaDeBanco.add("maria");
        filaDeBanco.add("josé");
        filaDeBanco.add("joão");

        System.out.println(filaDeBanco);

        //mostra o primeiro e nao o remove -> em caso de vazia, retorna NULL
      /*  String primeiroElemento = filaDeBanco.peek();
        System.out.println(primeiroElemento);*/

        //mostra o resto e e remove o primeiro
        String mostrandoOResto = filaDeBanco.poll();
        System.out.println(mostrandoOResto);
        System.out.println(filaDeBanco);

        //mostra o primeiro e nao o remove -> em caso de vazia, retorna NoSuchElementException
        String primeiroClienteOuErro = filaDeBanco.element();
        System.out.println(primeiroClienteOuErro);
        System.out.println(filaDeBanco);

        for (String client : filaDeBanco) {
            System.out.println("--> " + client);
        }

        Iterator<String> iteratorFilaBanco = filaDeBanco.iterator();
        while (iteratorFilaBanco.hasNext()){
            System.out.println("-> "+iteratorFilaBanco.next());
        }

    }
}
