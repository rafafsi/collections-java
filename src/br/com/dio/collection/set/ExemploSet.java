package br.com.dio.collection.set;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println("======EXERCÍCIO=======");
        System.out.println("notas = " + notas.toString());
        //os elementos ficaram em ordem aleatória e o número que se repete fica apenas uma vez.

        System.out.println("======================");
//        System.out.println("exiba a posição da nota 5: "); //não consigo pq não tem indice
//        System.out.println("adicione na lista a nota 8.0 na posição 4: "); //não consigo pq não tem indice
//        System.out.println("substitua a nota 5.0 pela note 6.0: "); //não tem o método 7

        System.out.println("confira se a nota 5.0 está no conjunto: " + notas.contains(5d));
        System.out.println("======================");
//        System.out.println("exiba a terceira nota adicionada"); //não consigo pq o set não mantém a ordem de inserção
        System.out.println("exiba a menor nota: " + Collections.min(notas));
        System.out.println("exiba a maior nota: "+ Collections.max(notas));
        System.out.println("======================");

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }

        System.out.println("exiba a soma dos valores: " + soma);
        System.out.println("======================");
        System.out.println("exiba a média das notas: " + (soma/notas.size()));
        System.out.println("======================");
        System.out.println("remova a nota zero:");
        notas.remove(0d);
        System.out.println("notas = " + notas.toString());
        System.out.println("======================");

//        System.out.println("remova a nota na posição 0");//não consigo pois não tem índice

        System.out.println("remova as notas menores que 7 e exiba a lista");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println("notas = " + notas.toString());
        System.out.println("======================");

        System.out.println("exiba todas as notas na ordem que foram informadas:");
        //pra essa implementação devemos usar o Linked pois ele mantém a ordem de inserção dos elementos
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d); //duplicate set element
        notas2.add(0d);
        notas2.add(3.6);

        System.out.println("notas = " + notas2); //imprime na ordem que foi inserido, mas não repete os elementos
        System.out.println("======================");
        System.out.println("exiba todas as notas na ordem crescente: ");
        //para essa implementação devemos usar o treeset, pois ele ordena naturalmente os objetos
        Set<Double> notas3 = new TreeSet<>(notas2);
        //esse argumento notas2 só funciona pq ele tem o método comparable inserido nele
        System.out.println("notas = " + notas3); //imprime na ordem crescente naturalmente
        System.out.println("======================");
        System.out.println("apague todo o conjunto: ");
        notas.clear();
        System.out.println("notas = " + notas);
        System.out.println("======================");
        System.out.println("confira se o conjunto 1 está vazio: " + notas.isEmpty());
        System.out.println("confira se o conjunto 2 está vazio: " + notas2.isEmpty());
        System.out.println("confira se o conjunto 3 está vazio: " + notas3.isEmpty());
        System.out.println("========FIM===========");


    }
}
