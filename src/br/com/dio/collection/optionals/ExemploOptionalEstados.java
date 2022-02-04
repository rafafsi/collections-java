package br.com.dio.collection.optionals;

import java.util.Optional;

public class ExemploOptionalEstados {
    public static void main(String[] args) {
        Optional<String> optionalString = Optional.of("valor presente ");
        System.out.println("\n- valor opcional que está presente (of): ");
        optionalString.ifPresentOrElse(System.out::println, () -> System.out.println("não está presente."));
        //recebe duas expressões: a primeira retorna o valor que estiver dentro do option.

        //existem 3 formas de construir o null: ofNullLable, of e empty

        Optional<String> optionalNull = Optional.ofNullable(null);
        //constroi de acordo com o que passar pro argumento
        //se o ofNullLable não estiver presente, ele chama o método empty
        System.out.println("\n- valor opcional que não está presente (ofNullLable) : ");
        optionalNull.ifPresentOrElse((System.out::println), () -> System.out.println("null = não está presente. "));


        Optional<String> emptyOptional = Optional.empty();
        System.out.println("\n- valor opcional que não está presente (empty): ");
        emptyOptional.ifPresentOrElse(System.out::println, () -> System.out.println("empty = não está presente."));


        Optional<String> optionalNullErro = Optional.of(null);
        System.out.println("\n- valor opcional que lança erro NullPointerExceprion (of(null))");
        optionalNullErro.ifPresentOrElse(System.out::println, () -> System.out.println("erro = não está presente. "));
    }
}
