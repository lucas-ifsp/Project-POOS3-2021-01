package br.edu.class01;

import java.util.Scanner;

public class EA02 {

    public static void main(String[] args) {
        //exemplo de leitura e escrita do console.
        Scanner scanner = new Scanner(System.in);
        double largura = scanner.nextDouble();
        double comprimento = scanner.nextDouble();
        System.out.println("Área: " + largura  * comprimento);

        //exemplo de switch expression (Java 13+)
        int v = 3;
        int i = switch (v) {
            case 2 -> {
                System.out.println("Olá");
                yield 2;
            }
            case 3 -> 3;
            default -> 0;
        };
    }

}
