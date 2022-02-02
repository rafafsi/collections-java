package br.com.dio.collection.streamAPI;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1" ,"2", "3", "9", "9", "6", "5");

        System.out.println("----------------------------------");
        System.out.println("\n1. imprima todos os elementos dessa lista de String. ");
        //de forma simplificada, com lambda e reference method
        numerosAleatorios.forEach(System.out::println);
        //na forma completa, seria:
       /* numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });*/
        System.out.println("----------------------------------");
        System.out.println("\n2. pegue os 5 primeiros números e coloque-os dentro de um set.");

        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        //LIMIT a quantidade de números que vc quer pegar
        //pegue algo de um lugar e COLLECT para outro lugar
        //porém o set não aceita valores repetidos

        System.out.println("----------------------------------");
        System.out.println("\n3. transforme essa lista de String em uma lista de números inteiros. ");

        List<Integer> collectInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("----------------------------------");
        System.out.println("\n4. pegue os números pares e maiores que 2 e coloque-os em uma lista. ");

        List<Integer> ListParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2))
                .collect(Collectors.toList());
        System.out.println("pares e maiores que 2 = " + ListParesMaioresQue2);

        System.out.println("----------------------------------");
        System.out.println("\n5. mostre a média dos números. ");

        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(System.out::println);
        System.out.println("----------------------------------");
        System.out.println("\n6. remova os valores ímpares. ");

        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        /*numerosAleatoriosInteger.removeIf(i -> (i%2 != 0 ));
        System.out.println(numerosAleatoriosInteger);*/
        //o stream nao altera a lista, por isso nao usa nesse exemplo

        System.out.println("----------------------------------");
        System.out.println("\n7. ignore os 3 primeiros elementos da lista e imprima o restante. ");
        numerosAleatoriosInteger.stream()
                .skip(3)
                .forEach(System.out::println);

        System.out.println("----------------------------------");
        long countNumerosUnicos = numerosAleatorios.stream()
                .distinct()
                .count();
        System.out.println("\n8. tirando os números repetidos da lista, quantos restam? " + countNumerosUnicos);

        System.out.println("----------------------------------");
        System.out.println("\n9. mostre o menor valor da lista. ");

        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .min()
                .ifPresent(System.out::println);

        System.out.println("----------------------------------");
        System.out.println("\n10. mostre o maior valor da lista. ");
        numerosAleatoriosInteger.stream()
                .mapToInt(Integer::intValue)
                .max()
                .ifPresent(System.out::println);

        System.out.println("----------------------------------");

        int somaPares = numerosAleatoriosInteger.stream()
                .filter(i -> (i % 2 != 0))
                .mapToInt(Integer::intValue)
                        .sum();

        System.out.println("\n11. a soma dos números ímpares é: " + somaPares );

        System.out.println("----------------------------------");
        System.out.println("\n12. mostre a lista na ordem numérica. ");
        List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(numerosOrdemNatural);

        System.out.println("----------------------------------");
        System.out.println("\n13. agrupe os valores ímpares múltiplos de 3 ou de 5. ");
        Map<Boolean, List<Integer>> collectNumerosMultiplos3ou5 = numerosAleatoriosInteger.stream()
                .collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
        System.out.println(collectNumerosMultiplos3ou5);


        System.out.println("--------------FIM-----------------");
    }
}

