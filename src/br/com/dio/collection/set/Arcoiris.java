package br.com.dio.collection.set;

import java.util.*;

public class Arcoiris {
    public static void main(String[] args) {

        System.out.println("=============EXERCÍCIO================\n");
        System.out.println("1. crie um conjunto com as cores do arco-íris.\n");
        Set<String> rainbow = new HashSet<>();
        rainbow.add("vermelha");
        rainbow.add("laranja");
        rainbow.add("amarela");
        rainbow.add("verde");
        rainbow.add("azul");
        rainbow.add("anil");
        rainbow.add("violeta");
        System.out.println("arcoíris = " + rainbow);
        System.out.println("=======================================");
        System.out.println("2. exiba todas as cores uma abaixo da outra.\n");
                for (String cor: rainbow) {
            System.out.println(cor);
        }
        System.out.println("=======================================");
        System.out.println("2. exiba a quantidade de cores que o arcoiris tem\n");
        System.out.println("o arco-íris tem " + rainbow.size() + " cores.");
        System.out.println("=======================================");
        System.out.println("3. exiba as cores em ordem alfabética.\n");
        Set<String> rainbow1 = new TreeSet<>(rainbow);
        System.out.println(rainbow1);
        System.out.println("=======================================");
        System.out.println("4. exiba as cores na ordem inversa da que foi informada\n");
        Set<String> rainbow2 = new LinkedHashSet<>( //tem q ser o Linked pq ele mantém a ordem de inserção dos elementos
                Arrays.asList("violeta", "anil", "azul", "verde", "amarelo", "laranja", "vermelha"));
        System.out.println("ordem inicial = " + rainbow2);
        List<String> rainbowList = new ArrayList<>(rainbow2); //teve q colocar em ArrayList pq o reverse só recebe List
        Collections.reverse(rainbowList);
        System.out.println("ordem inversa = " +rainbowList);
        System.out.println("=======================================");
        System.out.println("5. exiba todas as cores que começam com a letra 'V'\n");
        for (String cor: rainbowList) {
            if (cor.startsWith("v")) System.out.println(cor);
        };
        System.out.println("=======================================");
        System.out.println("6. remova todas as cores que não começam com a letra 'V'\n");
        rainbowList.removeIf(s -> !s.startsWith("v"));
        System.out.println("cores restantes = " + rainbowList);
        System.out.println("=======================================");
        System.out.println("7. limpe o conjunto\n");
        rainbowList.clear();
        System.out.println("conjunto arco-íris = " + rainbowList);
        System.out.println("=======================================");
        System.out.println("8. confira se o conjunto está vazio\n");
        System.out.println("o arco-íris está vazio? " + rainbowList.isEmpty());
        System.out.println("==============FIM======================");




    }
}

/*linguagem favorita
*
* crie ma classe LinguagemFavorita com nome, anoDeCriacao, IDE
* crie um conjunto com essas 3 linguagens
* faça um programa que ordene esse conjunto por:
* 1. ordem de insercao
* 2. ordem natural(nome)
* 3. IDE
* 4. ano de criacao e nome
* 5. nome, ano de criacao e IDE
* */