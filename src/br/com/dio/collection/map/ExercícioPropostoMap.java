package br.com.dio.collection.map;

import java.util.*;

public class ExercícioPropostoMap {
    public static void main(String[] args) {
        Map<String,Double> meuNordeste = new HashMap<>(){{
            put("PE", 9.616621);
            put("AL", 3.335543);
            put("CE", 9.187103);
            put("RN", 3.534264);
        }};

        System.out.println("==============EXERCÍCIO===============");
        System.out.println("1. crie um dicionário com alguns estados do Nordeste.\n");
        for (Map.Entry<String, Double> meuNE : meuNordeste.entrySet()) {
            System.out.println("estado: " + meuNE.getKey() + " - pop: " + meuNE.getValue());
        }
        System.out.println("======================================");
        System.out.println("2. altere a população de RN para 3.534.165.\n");
        meuNordeste.put("RN", 3.534165);
        for (Map.Entry<String, Double> meuNE : meuNordeste.entrySet()) {
            System.out.println("estado: " + meuNE.getKey() + " - pop: " + meuNE.getValue());
        }
        System.out.println("======================================");
        System.out.println("3. adicione o estado da PB.\n");
        meuNordeste.put("PB", 4.039277);
        for (Map.Entry<String, Double> meuNE : meuNordeste.entrySet()) {
            System.out.println("estado: " + meuNE.getKey() + " - pop: " + meuNE.getValue());
        }
        System.out.println("======================================");
        System.out.println("3. exiba a população de Pernambuco.\n");
        System.out.println(meuNordeste.get("PE"));
        System.out.println("======================================");
        System.out.println("4. exiba os estados e suas populações na ordem em que foram inseridos.\n");
        Map<String, Double> meuNordeste2 = new LinkedHashMap<>(){{
                put("PE", 9.616621);
                put("AL", 3.335543);
                put("CE", 9.187103);
                put("RN", 3.534165);
                put("PB", 4.039277);
        }};
        System.out.println(meuNordeste2);
        System.out.println("======================================");
        System.out.println("4. exiba os estados e suas populações em ordem alfabética.\n");
        Map<String, Double> meuNordeste3 = new TreeMap<>(meuNordeste);
        for (Map.Entry<String, Double> meuNE: meuNordeste3.entrySet()){
            System.out.println("estado: " + meuNE.getKey() + " - pop: " + meuNE.getValue());
        }
        System.out.println("======================================");

        System.out.println("4. exiba o estado de menor população.\n");

        Double menorPop = Collections.min(meuNordeste.values());
        Set<Map.Entry<String, Double>> entries = meuNordeste.entrySet();
        String estadoMenorPop = "";

        for (Map.Entry<String, Double> entry: entries) {
            if(entry.getValue().equals(menorPop)){
                estadoMenorPop = entry.getKey();
                System.out.println(estadoMenorPop + " - população: " + menorPop);
            }
        }
        System.out.println("======================================");
        System.out.println("5. exiba o estado de maior população.\n");

        Double maiorPop = Collections.max(meuNordeste.values());
        String estadoMaiorPop = "";
        for (Map.Entry<String, Double> entry:entries) {
            if(entry.getValue().equals(maiorPop)){
                estadoMaiorPop = entry.getKey();
                System.out.println(estadoMaiorPop + " - população: " + maiorPop);
            }
        }
        System.out.println("======================================");
        System.out.println("6. exiba a soma das populações dos estados. \n");
        Iterator<Double> iterator = meuNordeste.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("soma = " + soma);
        System.out.println("======================================");
        System.out.println("7. exiba a média populacional desses estados.\n");
        System.out.println("média = " + (soma/meuNordeste.size()));
        System.out.println("======================================");
        System.out.println("8. remova os estados com população inferior a 4.000.000.\n");
        Iterator<Double> iterator2 = meuNordeste.values().iterator();
        while(iterator2.hasNext()){
            Double next = iterator2.next();
            if(next < 4.000000) {
                iterator2.remove();
            }
        }
        for (Map.Entry<String, Double> meuNE : meuNordeste.entrySet()) {
            System.out.println("estado: " + meuNE.getKey() + " - pop: " + meuNE.getValue());
        }
        System.out.println("======================================");
        System.out.println("9. apague a biblioteca.\n");
        meuNordeste.clear();
        System.out.println("meuNordeste = " + meuNordeste);
        System.out.println("======================================");
        System.out.println("10. a biblioteca está vazia? " + meuNordeste.isEmpty() + "\n");
        System.out.println("===================FIM================");
    }
}