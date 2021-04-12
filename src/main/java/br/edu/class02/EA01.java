package br.edu.class02;

import java.util.Scanner;

public class EA01 {
    public static void main(String[] args) {
        double[] notas = new double[26]; // array com 26 posições para armazenar double

        for (int i = 0; i < notas.length; i++) {
            double nota = notas[i]; // acessa a posição i do array
            System.out.println("nota = " + nota);
        }

        int[][] idadesCachorros = {{2, 4}, {3, 4, 1}, {3, 4, 5, 2}}; // array bidimensional (array de arrays)
        int[][] twoDimensionalInts = new int[20][20]; // array bidimensional com subarrays de mesmo tamanho

        //iterando arrays bidimensional com for convencional
        for (int i = 0; i < idadesCachorros.length; i++) {
            for (int j = 0; j < idadesCachorros[i].length; j++) {
                System.out.print(idadesCachorros[i][j] + " ");
            }
        }

        System.out.println("\n");

        //iterando arrays bidimensional com for de conjuntos (foreach)
        for (int[] cachorrosDeUmaPessoa : idadesCachorros) {
            for (int idadeCachorro : cachorrosDeUmaPessoa) {
                System.out.print(idadeCachorro + " ");
            }
        }

        int[][] values = {{1, 3, 5}, {20, 23, 54, 94}, {45, 98, 102}};
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        //exemplo de break rotulado, use com cuidado, pois atrapalha legibilidade
        outerBreak:
        for (int[] i : values){ // a matriz funciona como um vetor de vetores
            for (int j : i) {
                if (j == num) {
                    System.out.println("Valor encontrado.");
                    break outerBreak; // interrompe todos os laços aninhados sob o "rotulo"
                }
            }
        }
    }
}
