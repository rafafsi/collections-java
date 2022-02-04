package br.com.dio.collection.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExemploListArray {
    public static void main(String[] args) {

        List<String> nomes = new ArrayList<>();

        nomes.add("rafaela");
        nomes.add("alice");
        nomes.add("rafael");
        nomes.add("leticia");
        nomes.add("emylia");
        nomes.add("misso");


        nomes.set(2, "ygor"); //troca um nome dado o índice
        nomes.add("rafael");
        Collections.sort(nomes); //coloca em ordem alfabética
        System.out.println(nomes);

        String s = nomes.get(0);
        System.out.println(s);

        int sizeList = nomes.size();
        System.out.println(sizeList);

        boolean contemAlice = nomes.contains("alice");
        System.out.println(contemAlice);

        Iterator<String> iterator = nomes.iterator();
        while(iterator.hasNext()) { //retorna true sempre que existir um elememnto na lista
            System.out.println("--> " + iterator.next());
        }

    }
}
