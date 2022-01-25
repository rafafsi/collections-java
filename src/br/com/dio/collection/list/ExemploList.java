package br.com.dio.collection.list;

import java.util.*;

public class ExemploList {

    public static void main(String[] args) {
        //dada uma lista com 7 notas do aluno, faça:
        System.out.println("COLLECTIONS EXERCISE");
        System.out.println("--------------------------------------------------");

        List<Double> notas = new ArrayList<>(); //lista que contém doubles. graças ao Diamond operator, n precisa repetir o double na new
        System.out.println("crie uma lista e adicione as sete notas: ");

        notas.add(7.0);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);

        System.out.println("notas = " + notas.toString());

        System.out.println("==================================================");
        System.out.println("exiba a posição da nota 5: " + notas.indexOf(5.0));

        System.out.println("==================================================");
        System.out.println("adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4,8d);
        System.out.println("notas = " + notas);

        System.out.println("==================================================");
        System.out.println("substitua a nota 5.0 pela nota 6.0: ");
        notas.set(notas.indexOf(5d),6.0);
        System.out.println("notas = " + notas);

        System.out.println("==================================================");

        System.out.println("confira se a nota 5.0 está na lista: " + notas.contains(5d));

        System.out.println("==================================================");

        System.out.println("exiba todas as notas na ordem em que foram informados: ");
        for (Double nota: notas) System.out.println(nota); //outra forma de imprimir os itens da lista

        System.out.println("==================================================");

        System.out.println("exiba a terceira nota adicionada: " + notas.get(2)); //pega um item pelo seu indice
        System.out.println("notas = " + notas);

        System.out.println("==================================================");

        System.out.println("exiba a menor nota: " + Collections.min(notas));//não existe método nativo, tem que usar o collections
        System.out.println("exiba a maior nota: " + Collections.max(notas));

        System.out.println("==================================================");

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()) { //iterator, tem próximo? true
            Double next = iterator.next(); //pega o primeiro valor
            soma += next; //e armazena/soma dentro de soma até que não tenha mais next
        }

        System.out.println("exiba a soma dos valores: " + soma);
        System.out.println("==================================================");
        System.out.println("exiba a média das notas: " + (soma/notas.size()));
        System.out.println("==================================================");
        System.out.println("remova a nota 0: ");
        notas.remove(0d);
        System.out.println("notas = " + notas);
        System.out.println("==================================================");
        System.out.println("remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println("notas = " + notas);

        System.out.println("==================================================");
        System.out.println("apague toda a lista");
        notas.clear();
        System.out.println("notas = " + notas);

        System.out.println("==================================================");
        System.out.println("confira se a lista está vazia: " + notas.isEmpty());


        System.out.println("--------------------------------------------------");

    }

}

