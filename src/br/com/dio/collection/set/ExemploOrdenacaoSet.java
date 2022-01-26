package br.com.dio.collection.set;

import java.util.*;

/*dadas as seguintes informações sobre minhas séries favoritas,
    * crie um conjunto e ordene este conjunto exibindo:
    * (nome -> gênero -> tempo do episódio
    */

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("=========EXERCÍCIO==========");
        Set<Serie> minhasSeries = new HashSet<>() {{
            add(new Serie("GOT", "fantasia", 60));
            add(new Serie("Dark", "drama", 60));
            add(new Serie("That '70s show", "comédia", 25));
        }};
        System.out.println("-> exiba em ordem aleatória: ");
        for (Serie serie : minhasSeries) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }
        System.out.println("=============================");
        System.out.println("-> exiba na ordem de inserção: ");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>() {{
            add(new Serie("GOT", "fantasia", 60));
            add(new Serie("Dark", "drama", 60));
            add(new Serie("That '70s show", "comédia", 25));
        }};
        ;
        for (Serie serie : minhasSeries1) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }
        System.out.println("=============================");
        System.out.println("-> exiba na ordem natural (tempo de episódio): ");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries);
        for (Serie serie : minhasSeries2) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }
        System.out.println("=============================");
        System.out.println("-> exiba na ordem nome/gênero/tempo: ");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempo());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie : minhasSeries3) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }


        System.out.println("========TAREFA DE CASA =========");
        System.out.println("-> ordene por gênero: ");

        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorGenero());
        minhasSeries4.addAll(minhasSeries);
        for (Serie serie: minhasSeries4) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("=============================");
        System.out.println("-> ordene por tempo de episódio: ");
        Set<Serie> minhasSeries5 = new TreeSet<>(new ComparatorTempoEpisodio());
        minhasSeries5.addAll(minhasSeries);
        for (Serie serie: minhasSeries5) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
        }

        System.out.println("===========FIM==============");
    }
}

class ComparatorNomeGeneroTempo implements Comparator<Serie>{
    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}

class ComparatorGenero implements Comparator<Serie> {
    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getGenero().compareToIgnoreCase(s2.getGenero());
    }
}

class ComparatorTempoEpisodio implements Comparator<Serie> {
    @Override
    public int compare(Serie s1, Serie s2) {
        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}