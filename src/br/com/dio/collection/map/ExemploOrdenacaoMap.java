package br.com.dio.collection.map;

import java.util.*;

public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        Map<String, Livro> meusLivros = new HashMap<>(){{
            put("Hawking, Stephen", new Livro("uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("o poder do hábito", 408));
            put("Haraci, Yuval Noah", new Livro("21 lições para o século 21", 432));
        }} ;

        System.out.println("==============EXERCÍCIO==================");
        System.out.println("1. crie um conjunto de livros.\n");
        System.out.println("meusLivros = " + meusLivros);
        System.out.println("=========================================");
        System.out.println("2. apresente-os em ordem aleatória.\n");

        for (Map.Entry<String, Livro> livro : meusLivros.entrySet()) {
            System.out.println("autor: " + livro.getKey() + " - livro: " + livro.getValue().getNome());
        }

        System.out.println("=========================================");
        System.out.println("3. apresente-os em ordem de inserção.\n");
        Map<String, Livro> meusLivros1 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("o poder do hábito", 408));
            put("Haraci, Yuval Noah", new Livro("21 lições para o século 21", 432));
        }} ;
        for (Map.Entry<String, Livro> livro : meusLivros1.entrySet()) {
            System.out.println("autor: " + livro.getKey() + " - livro: " + livro.getValue().getNome());
        }
        System.out.println("=========================================");
        System.out.println("4. apresente-os em ordem alfabética pelo nome dos autores.\n");
        Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros);
        for (Map.Entry<String, Livro> livro: meusLivros2.entrySet()) {
            System.out.println("autor: " + livro.getKey() + " - livro: " + livro.getValue().getNome());
        }
        System.out.println("=========================================");
        System.out.println("4. apresente-os em ordem alfabética pelo nome do livro.\n");

        Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
        meusLivros3.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro: meusLivros3) {
            System.out.println("livro: " + livro.getValue().getNome() + " - autor: " + livro.getKey());
        }
        System.out.println("=========================================");
        System.out.println("5. apresente-os em ordem pelo número de páginas.\n");
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPagina());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro: meusLivros4) {
            System.out.println("págs: " + livro.getValue().getPáginas() + " - livro: " + livro.getValue().getNome() + " - autor: " + livro.getKey());
        }
        System.out.println("=================FIM=====================");

    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorPagina implements Comparator<Map.Entry<String, Livro>>{
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPáginas().compareTo(l2.getValue().getPáginas());
    }
}