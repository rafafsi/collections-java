package br.com.dio.collection.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ComparatorsExempleList {
    public static void main(String[] args) {

        List<Estudante> estudantes = new ArrayList<>();
        estudantes.add((new Estudante("rafa", 26)));
        estudantes.add((new Estudante("alice", 27)));
        estudantes.add((new Estudante("rafael", 10)));
        estudantes.add((new Estudante("leticia", 32)));
        estudantes.add((new Estudante("emylia", 25)));

        System.out.println("\n---- ordem de inserção.");
        System.out.println(estudantes);
        estudantes.sort((first, second) -> first.getIdade() - second.getIdade() );


        System.out.println("\n---- ordem natural dos números - idade ----.");
        System.out.println(estudantes);
        estudantes.sort((first, second) -> second.getIdade() - first.getIdade());

        System.out.println("\n ---- ordem reversa dos números - idade (method reference) ");
        System.out.println(estudantes);
        estudantes.sort((Comparator.comparingInt(Estudante::getIdade).reversed()));

        System.out.println("\n ---- ordem reversa dos números - idade (Collections method) ");
        System.out.println(estudantes);
        Collections.sort(estudantes); //recebe uma lista de elementos T

        System.out.println("\n ---- ordem natural dos números - idade (interface Comparable) ");
        System.out.println(estudantes);
        Collections.sort(estudantes, new EstudanteOrdemIdadeReversaComparator());
        //nesse caso de duplo argumento, não é obrigatório ter os elementos declarados de tipo T


        System.out.println("\n ---- ordem reversa dos números - idade (interface Comparator) ");
        System.out.println(estudantes);
    }
}
