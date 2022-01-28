package br.com.dio.collection.map;

import java.util.*;

import static javax.swing.UIManager.put;

public class ExemploMap {
    public static void main(String[] args) {
        System.out.println("============EXERCÍCIO=========");
        System.out.println("1. crie um dicionário que relacione os modelos e seus respectivos valores.\n");

        Map<String, Double> carrosPopulares = new HashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};//nao existe o método add e não pode chave duplicada

        System.out.println("carrosPopulares = "+ carrosPopulares.toString());

        System.out.println("=================================");
        System.out.println("2. substitua o consumo do gol por 15,2 km/l\n");
        carrosPopulares.put("gol", 15.2); //como não pode haver repetição de chave, é só subescrever com a mesma chave
        System.out.println("carrosPopulares = "+ carrosPopulares.toString());
        System.out.println("=================================");
        System.out.println("3. confira se o modelo tucson está no dicionário.\n");
        System.out.println("está presente? " + carrosPopulares.containsKey("tucson"));
        System.out.println("=================================");
        System.out.println("4. exiba o consumo do uno\n");
        System.out.println("consumo do uno: " + carrosPopulares.get("uno"));
        System.out.println("=================================");
        System.out.println("5. exiba os modelos.\n");
        Set<String> modelosSet = carrosPopulares.keySet(); //o keySet exibe um set, então tem q por em variável pra exibir.
        System.out.println(modelosSet);
        System.out.println("=================================");
        System.out.println("6. e os consumos.\n");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);
        System.out.println("=================================");
        System.out.println("7. exiba o modelo mais econômico e seu consumo.\n");

        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        //esse método retorna um set e os elementos dentro do set tão do tipo entry: Map.Entry<String, Double>
        String modeloMaisEficiente = ""; //variável de controle

        for (Map.Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(consumoMaisEficiente))  {
                modeloMaisEficiente = entry.getKey();
                System.out.println("modelo mais eficiente: " + modeloMaisEficiente +  " - " + consumoMaisEficiente);
            }
        }
        System.out.println("=================================");
        System.out.println("8. exiba o modelo menos econômico e o seu consumo.\n");

        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
            if (entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("modelo menos eficiente: " + modeloMenosEficiente +  " - " + consumoMenosEficiente);
            }
        }

        System.out.println("=================================");
        Iterator<Double> iterator = carrosPopulares.values().iterator();//consigo fazer isso pq o retorno do values é uma collection

        Double soma = 0d;
        while (iterator.hasNext()) {
            soma += iterator.next();
        }
        System.out.println("9. exiba a soma dos consumos: " + soma + "\n");
        System.out.println("=================================");
        System.out.println("10. exiba a média dos consumos desse dicionário de carros: " + (soma/carrosPopulares.size()) + "\n");
        System.out.println("=================================");
        System.out.println("11. remova os modelos com o consumo igual a 15.6 km/l\n");
        System.out.println("antes: " + carrosPopulares);
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while (iterator1.hasNext()) {
            if (iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println("depois da remoção: " + carrosPopulares);

        System.out.println("=================================");
        System.out.println("12. exiba todos os carros na ordem em que foram informados.\n");
        Map<String, Double> carrosPopulares1 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares1.toString());
        System.out.println("=================================");
        System.out.println("13. exiba o dicionário ordenado pelo modelo.\n");
        Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
        System.out.println(carrosPopulares2);
        System.out.println("=================================");
        System.out.println("14. apague o conjunto de carros.\n");
        carrosPopulares.clear();
        System.out.println("carrosPopulares = " + carrosPopulares);
        System.out.println("=================================");
        System.out.println("15. verifique se a lista está vazia: " + carrosPopulares.isEmpty() + "\n");
        System.out.println("==============FIM================");


    }
}
