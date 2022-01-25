package br.com.dio.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExemploTemperatura {
    public static void main(String[] args) {
        /*
         * faça um programa que receba a temperatura média dos 6 primeiros meses do ano e armazene-as em uma lista.
         * após isto, calcule a média semestral das temperaturas e mostre todas as temperaturas acima desta média,
         *  e em que meses elas ocorreram (mostrar mês por extenso)
         *
         * */

        Scanner scan = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<>();


        // laço para novas temperaturas
        int count = 0;
        while (true) {
            if (count == 6) break;

            System.out.println("digite a temperatura: ");
            Double temp = scan.nextDouble();
            temperaturas.add(temp);
            count++;
        }

        System.out.println("---------------------");
        System.out.println("exibindo todas as temperaturas: ");
        temperaturas.forEach(t -> System.out.println(t + " "));
        System.out.println("---------------------");

        //calculando a média
        double media = temperaturas.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0d);
        System.out.printf("\nmédia das temperaturas: %.1f\n", media);
        System.out.println("---------------------");

        //exibindo as temperaturas acima da média
        System.out.println("temperaturas acima da média: ");
        temperaturas.stream()
                .filter(t -> t > media)
                .forEach((t -> System.out.printf("%.1f ", t)));


        System.out.println("---------------------");

        System.out.println("temperaturas acima da média por extenso: ");
        Iterator<Double> iterator = temperaturas.iterator();

        count = 0;
        while (iterator.hasNext()) {
            Double temp = iterator.next();
            if (temp > media) {
                switch (count) {
                    case (0):
                        System.out.printf("1 - janeiro: %.1f\n", temp);
                        break;
                    case (1):
                        System.out.printf("2 - fevereiro: %.1f\n", temp);
                        break;
                    case (2):
                        System.out.printf("3 - março: %.1f\n", temp);
                        break;
                    case (3):
                        System.out.printf("4 - abril: %.1f\n", temp);
                        break;
                    case (4):
                        System.out.printf("5 - maio: %.1f\n", temp);
                        break;
                    case (5):
                        System.out.printf("6 - junho: %.1f\n", temp);
                        break;
                    default:
                        System.out.println("não houve temperatura acima da média.");
                }
            }
            count++;
        }
    }
}