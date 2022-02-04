package br.com.dio.collection.map;

import java.util.HashMap;
import java.util.Map;

public class ExemploCopaDoMundo {
    public static void main(String[] args) {

        Map<String, Integer> campeoesMundiaisFifa = new HashMap<>();
        campeoesMundiaisFifa.put("Brasil", 5);
        campeoesMundiaisFifa.put("Alemanha", 4);
        campeoesMundiaisFifa.put("Itália", 4);
        campeoesMundiaisFifa.put("Uruguai", 2);
        campeoesMundiaisFifa.put("Argentina", 2);
        campeoesMundiaisFifa.put("França", 2);
        campeoesMundiaisFifa.put("Inglaterra", 1);
        campeoesMundiaisFifa.put("Espanha", 1);


        System.out.println("-------------EXERCÍCIO------------");
        System.out.println("\n1. crie um conjunto com os campeões mundiais.");
        System.out.println("campeões FIFA: " + campeoesMundiaisFifa);
        System.out.println("\n2. atualize o valor do Brasil pra 6."); //não refatoro, apenas subescrevo.
        campeoesMundiaisFifa.put("Brasil", 6);

        for (Map.Entry<String, Integer> listaCampeoes : campeoesMundiaisFifa.entrySet()) {
            System.out.println("seleção: " + listaCampeoes.getKey() + " ---- títulos mundiais: " + listaCampeoes.getValue());
        }
        System.out.println("\n3. quantos títulos tem a Argentina?");
        Integer titulosArgentina = campeoesMundiaisFifa.get("Argentina");
        System.out.println(titulosArgentina + " títulos mundiais.");


        System.out.println("\n4. a França já venceu algum mundial?");
        boolean franca = campeoesMundiaisFifa.containsKey("França");
        System.out.println(franca);

        System.out.println("\n5. remova a França.");
        campeoesMundiaisFifa.remove("França");
        for (Map.Entry<String, Integer> listaCampeoes : campeoesMundiaisFifa.entrySet()) {
            System.out.println("seleção: " + listaCampeoes.getKey() + " ---- títulos mundiais: " + listaCampeoes.getValue());
        }

        System.out.println("\n5. a França já venceu algum mundial?");
        boolean franca1 = campeoesMundiaisFifa.containsKey("França");
        System.out.println(franca1);

        System.out.println("\n6. existe alguma seleção hexa campeã?");
        System.out.println(campeoesMundiaisFifa.containsValue(6));

        System.out.println("\n7. navegue nos registros do mapa");
        for (String key: campeoesMundiaisFifa.keySet()) {
            System.out.println(key + " -- " + campeoesMundiaisFifa.get(key));
        }
    }
}
