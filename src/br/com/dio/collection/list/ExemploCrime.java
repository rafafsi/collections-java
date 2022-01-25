package br.com.dio.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExemploCrime {
    /*CRIME
     *
     * 1 telefonou para a vítima
     * 2 esteve no local do crime?
     * 3 mora perto da vítima?
     * 4 devia para a vítima?
     * 5 já trabalhou com a vítima?
     *
     * 2 questões true -> "suspeita"
     * entre 3 e 4 -> "cúmplice"
     * 5 -> "assassina"
     *
     * */

    public static void main(String[] args) {
        List<String> interrogatorio = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.println("INTERROGATÓRIO DO CRIME: ");

        System.out.println("\n1. você telefonou para a vítima? ");
        String resp = scan.next();
        interrogatorio.add(resp.toLowerCase());
        System.out.println("\n2. você esteve no local do crime? ");
        resp = scan.next();
        interrogatorio.add(resp.toLowerCase());
        System.out.println("\n3. você morava perto da vítima? ");
        resp = scan.next();
        interrogatorio.add(resp.toLowerCase());
        System.out.println("\n4. você devia dinheiro para a vítima? ");
        resp = scan.next();
        interrogatorio.add(resp.toLowerCase());
        System.out.println("\n5. você já trabalhou com a vítima? ");
        resp = scan.next();
        interrogatorio.add(resp.toLowerCase());


        int count = 0;
        Iterator<String> contador = interrogatorio.iterator();
        while(contador.hasNext()) {
            String resposta = contador.next();
            if(resposta.contains("s")){
                count++;
            }
        }

        switch (count){
            case 2:
                System.out.println("você é suspeita desse crime!");
                break;
            case 3:
            case 4:
                System.out.println("você é cúmplice desse crime!");
                break;
            case 5:
                System.out.println("você é o assassino! teje preso!");
                break;
            default:
                System.out.println("você é inocente, está liberado!");
        }

        }
    }
