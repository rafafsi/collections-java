package br.com.dio.collection.streamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ExemploStreamAPI {
    public static void main(String[] args) {

        List<String> estudantes = new ArrayList<>();

        estudantes.add("pedro");
        estudantes.add("thayse");
        estudantes.add("marcelo");
        estudantes.add("carla");
        estudantes.add("juliana");
        estudantes.add("thiago");
        estudantes.add("rafael");

        //retorna a contagem dos elementos do stream
        System.out.println("\n 1. contagem: " + estudantes.stream().count());

        //retorna o elemento com maior número de letras
        System.out.println("\n 2. maior número de letras: " + estudantes.stream().max(Comparator.comparingInt(String::length)));

        //retorna o elemento com menor número de letras
        System.out.println("\n 3. menor número de letras: " + estudantes.stream().min(Comparator.comparingInt(String::length)));

        //retorna os elementos que contem a letra R no nome
        System.out.println("\n 4. contém a letra R: " + estudantes.stream()
                .filter((estudante) -> estudante
                        .toLowerCase()
                        .contains("r")).toList());

        //retorna uma nova coleção com os nomes concatenados à quantidade de letra de cada nome.
        System.out.println("\n 5. nomes + quantidade de letras: " +
                estudantes.stream().map(estudante -> estudante
                        .concat(" - ")
                        .concat(String.valueOf(estudante.length())))
                        .toList());

        //retorna somente os três primeiros elementos da coleção
        System.out.println("\n 6. os 3 primeiros elementos: " +
                estudantes.stream()
                        .limit(3)
                        .toList());

        //exibe cada elemento no console e depois retorna a mesma coleção
        System.out.println("\n 7. todos os elementos + coleção completa: ");
        System.out.println(estudantes.stream()
                .peek(el -> System.out.println("   - " + el))
                .toList());

        //exibe cada elemento no console sem retornar outra coleção
        System.out.println("\n 8. todos os elementos: ");
        estudantes.stream().forEach(el -> System.out.println("   - " + el));

        //retorna true se todos os elementos possuírem a letra W no nome.
        System.out.println("\n 9. todos os elementos têm 'W'x no nome? " +
                estudantes.stream().allMatch((el) -> el.contains("w")));

        //retorna true se algum dos elementos possuem a letra a minúscula no nome.
        System.out.println("\n 10. tem algum elemento com a letra a minúscula no nome? " +
                estudantes.stream().anyMatch(el -> el.contains("a")));

        //retorna true se nenhum elemento possui a letra a minúscula no nome
        System.out.println("\n 11. não tem nenhum elemento com a letra a minúscula no nome: " +
                estudantes.stream().noneMatch(el -> el.contains("a")));

        //retorna o primeiro elemento da coleção. se existir, exiba no console
        System.out.println("\n 12. primeiro elemento da coleção: ");
        estudantes.stream().findFirst().ifPresent(el -> System.out.println("   " + el));

        //exemplo de operação encadeada.
        System.out.println("\n 13. operação encadeada: ");
        System.out.println(estudantes.stream()
                .peek(System.out::println)
                .map(est -> est.concat(" - ")
                        .concat(String.valueOf(est.length())))
                .peek(System.out::println)
//                .filter(est -> est.toLowerCase().contains("r"))
//                      .collect(Collectors.toList()));
//                      .collect(Collectors.joining(" / ")));
//                      .collect(Collectors.toSet()));
                        .collect(Collectors.groupingBy(el -> el.substring(el.indexOf(" - ") + 1))));
        //peek-map-peek nesse caso estão assíncronos/concorrentes, estão agindo de forma paralela. diferente se usássemos o laço forEach
    }
}
