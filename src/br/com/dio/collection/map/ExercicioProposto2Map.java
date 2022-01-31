package br.com.dio.collection.map;

import java.util.*;

public class ExercicioProposto2Map {
    public static void main(String[] args) {
        int quantidadeLancamento = 100;

        List<Integer> valores = new ArrayList<>();
        Random numeroAleatorio = new Random();
        for (int i = 0; i < quantidadeLancamento; i++) {
            int number = numeroAleatorio.nextInt(6) + 1;
            valores.add(number);
        }

        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : valores) {
            if(lancamentos.containsKey(resultado))
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            else lancamentos.put(resultado, 1);
        }

        System.out.println("\n valor  -  " + "quant. de vezes");
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("%3d %10d\n", entry.getKey(), entry.getValue());
        }
    }
}
