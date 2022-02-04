package br.com.dio.collection.comparator;

import java.util.Comparator;

public class Estudante implements Comparable<Estudante> {

    private final String nome;
    private final Integer idade;

    public Estudante(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() { return  nome; }
    public Integer getIdade() { return idade; }

    @Override
    public String toString() { return nome + " - " + idade; }

    @Override
    public int compareTo(Estudante o) { //compareTo retorna um inteiro
        return this.getIdade() - o.getIdade(); //dessa forma eu consigo ordenar a lista pela idade
    } //subtraindo o valor atual do valor de comparação
}

class EstudanteOrdemIdadeReversaComparator implements Comparator<Estudante> {
    @Override
    public int compare(Estudante o1, Estudante o2) {
        return o2.getIdade() - o1.getIdade();
    }
}