package br.com.dio.collection.map;

import java.util.Iterator;
import java.util.TreeSet;

public class ExemploCapitais {
    public static void main(String[] args) {
    TreeSet<String> minhasCapitais = new TreeSet<>();
    minhasCapitais.add("Recife");
    minhasCapitais.add("Fortaleza");
    minhasCapitais.add("Aracaju");
    minhasCapitais.add("Natal");
    minhasCapitais.add("Maceió");
    minhasCapitais.add("João Pessoa");

        System.out.println(minhasCapitais);

        System.out.println("\n-> retorna a primeira capital no final da árvore.\n");
        System.out.println(minhasCapitais.first());

        System.out.println("-> retorna a última capital no final da árvore.\n");
        System.out.println(minhasCapitais.last());

        System.out.println("-> retorna a primeira capital abaixo na árvore da capital parametrizada.\n");
        System.out.println(minhasCapitais.lower("Recife"));

        System.out.println("-> retorna a primeira capital acima na árvore da capital parametrizada.\n");
        System.out.println(minhasCapitais.higher("Recife"));

        System.out.println("-> retorna a primeira capital no topo da árvore, removendo do set.\n");
        System.out.println(minhasCapitais.pollFirst());
        System.out.println(minhasCapitais);

        System.out.println("-> retorna a primeira capital no final da árvore, removendo do set.\n");
        System.out.println(minhasCapitais.pollLast());
        System.out.println(minhasCapitais);

        System.out.println("-> navega em todos os itens do iterator.\n");
        Iterator<String> iterator = minhasCapitais.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
