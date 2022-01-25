package br.com.dio.collection.list;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
*   dados as informações sobre os gatos, crie uma lista e ordene a lista exibindo:
* nome, idade e cor
*
* Gato 1 = nome: Jan, idade: 18, cor: preto
* Gato 2 = nome: Simba, idade: 6, cor: tigrado
* Gato 3 = nome: Jon, idade: 12, cor: amarelo
* */
public class ExemploOrdenacaoList {
    public static void main(String[] args) {

        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Jon", 18, "preto"));
            add(new Gato("Simba",6, "tigrado"));
            add(new Gato("Jon", 12, "amarelo"));
        }};

        System.out.println(meusGatos);

        System.out.println("EXERCISE");
        System.out.println("--------------------------------------------------");

        System.out.println("mostre a lista na ordem de inserção: ");
        System.out.println(meusGatos);

        System.out.println("==================================================");

        System.out.println("mostre em ordem aleatória: ");
        Collections.shuffle(meusGatos); //não é um método especialmente pra misturar, mas serve. (embaralhar)
        System.out.println(meusGatos);

        System.out.println("==================================================");

        System.out.println("mostre na ordem natural: ");
//        meusGatos.sort(); faz comparação, mas precisa de um COMPARATOR
        Collections.sort(meusGatos); //tem a interface comparable
        System.out.println(meusGatos);

        System.out.println("==================================================");

        System.out.println("ordene pela idade: ");
        meusGatos.sort((new ComparatorIdade())); //precisa de comparator
//       Collections.sort(meusGatos, new ComparatorIdade());
        System.out.println(meusGatos);

        System.out.println("==================================================");

        System.out.println("ordene pela cor: "); //tbm vou fazer por comparator pq o comparable já está com o nome
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("==================================================");

        System.out.println("ordene pelo nome/cor/idade: ");
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);

    }
}


class Gato implements Comparable<Gato> { //comparable pra conseguir ordenar pelo nome dos gatos
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    } //constructor

    public String getNome() {
        return nome;
    } //getter

    public void setNome(String nome) {
        this.nome = nome;
    } //setter

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    } //toString() pra que imprima o dado inserido e não o endereço de memória (br.com.dio.collection.list.Gato@....)

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
        /*aqui eu usei o this pq estou dentro da classe Gato*/
        /*implemento a interface e retorno o critério que eu quero ordenar: pelo nome*/
        /*a interface comparable OBRIGA a subescrever a interface compareTo*/
    }
}

class ComparatorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());//comparação de inteiro
    }
}

class ComparatorCor implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}
//        outra possibilidade: return String.CASE_INSENSITIVE_ORDER.compare(g1.getCor(), g2.getCor());

        /*se as cores forem iguais, retorna 0
        * se for maior do que o gato 2, retorna 1
        * se for menor, retorna -1
        * */

class ComparatorNomeCorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome; //se os nomes forem diferentes, ordene por nome

        int cor = g2.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor;// se o nome for igual e a cor for diferente, ordene por cor

        return Integer.compare(g1.getIdade(),g2.getIdade()); //se o nome e a cor forem diferentes, ordene por idade

    }
}