package br.com.dio.collection.map;

import java.util.*;
import java.util.function.Function;

public class ExercicioProposto3Map {
    public static void main(String[] args) {
        Map<Integer, Contato> agenda = new HashMap<>();
        agenda.put(1, new Contato("Simba", 555555));
        agenda.put(4, new Contato("Cami", 111111));
        agenda.put(3, new Contato("Jon", 222222));

        System.out.println("\n-----------------------EXERCÍCIO-----------------------\n");
        System.out.println("1. apresente a agenda em ordem aleatória:\n");

        for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("----------------------------------------------------");
        System.out.println("2. apresente a agenda em ordem de inserção:\n");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>();
        agenda1.put(1, new Contato("Simba", 555555));
        agenda1.put(4, new Contato("Cami", 111111));
        agenda1.put(3, new Contato("Jon", 222222));
        for (Map.Entry<Integer, Contato> entry : agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }
        System.out.println("----------------------------------------------------");
        System.out.println("3. apresente a agenda por ID:\n");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        for (Map.Entry<Integer, Contato> entry : agenda2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }
        System.out.println("----------------------------------------------------");
        System.out.println("4. apresente a agenda por ordem do número do telefone:\n");

        //refatorando o comparator para usar classe anônima (new Comparator<Entry>..)

       /* Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
                return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
            }
        });*/

        //agora utilizando o método compare
       /* Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override //o Comparator tem um método comparing que me permite fazer comparações passando uma interface funcional
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getNumero();
                    }
                }));*/

        //agora utilizando Lambda
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(Comparator.comparing(cont -> cont.getValue().getNumero()));
        set.addAll(agenda.entrySet());

        for (Map.Entry<Integer, Contato> entry : set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }
        System.out.println("----------------------------------------------------");
        System.out.println("5. apresente a agenda por ordem do nome do contato:\n");

        //resolvendo o Comparator com Lambda
        Set<Map.Entry<Integer,Contato>> set1 = new TreeSet<>(Comparator.comparing(cont1 -> cont1.getValue().getNome()));
        set1.addAll(agenda.entrySet());

        for (Map.Entry<Integer, Contato> entry : set1) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }
    }
}

/*class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
        return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
    }
}

class ComparatorNomeContato implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getNome().compareToIgnoreCase(c2.getValue().getNome());
    }
}*/