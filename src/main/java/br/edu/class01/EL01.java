package br.edu.class01;

import java.util.Scanner;

public class EL01 {

    //Exercício 1 do run.codes
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfBooks = scanner.nextInt();

        if (numberOfBooks <= 0) {
            System.out.println("Erro");
            return;
        }
        double criteriaA = 0.25 * numberOfBooks + 7.5;
        double criteriaB = 0.5 * numberOfBooks + 2.5;

        printBestCriteria(criteriaA, criteriaB);
    }

    private static void printBestCriteria(double criteriaA, double criteriaB) {
        if (criteriaA < criteriaB) {
            System.out.println("Criterio A");
        } else if (criteriaB < criteriaA) {
            System.out.println("Criterio B");
        } else {
            System.out.println("Indiferente");
        }
    }

}
