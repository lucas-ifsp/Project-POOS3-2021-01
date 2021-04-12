package br.edu.class02;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/*
* Faça um programa que leia dados inteiros da temperatura diária durante uma semana, armazenando em um vetor.
* Na sequência, escreva quantos dias dessa semana a temperatura esteve acima da média. As sete temperaturas
* devem ser lidas na mesma linha, separada por espaço.

Exemplos de entrada e saída esperada:

Exemplo 1: Entrada = 2 2 2 2 2 2 3 | Saída = 1
Exemplo 2: Entrada = 21 10 13 34 30 21 34 | Saída = 3
Exemplo 3: Entrada = 2 2 2 2 2 2 1| Saída = 6
Qualquer valor fora do domínio de entrada tem como saída esperada a String "Erro".

*/
public class EL01 {

    public static void main(String[] args) {
        int daysAboveAverage = getDaysAboveAverage(getTemperaturesFromConsole());
        //testApp();
        System.out.println(daysAboveAverage);
    }


    private static int getDaysAboveAverage(int[] temperatures) {
        int sumOfTemperatures = 0;

        for (int i = 0; i < temperatures.length; i++) {
            sumOfTemperatures += temperatures[i];
        }

        double averageTemperature = (double) sumOfTemperatures / 7;

        int daysAboveAverage = 0;
        for (int dayTemperature : temperatures) {
            if(dayTemperature > averageTemperature){
                daysAboveAverage ++;
            }
        }
        return daysAboveAverage;
    }

    private static int[] getTemperaturesFromConsole() {
        int [] temperatures = new int[7];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 7; i++) {
            temperatures[i] = scanner.nextInt();
        }
        return temperatures;
    }

     /*private static void testApp() {
        int[] test1 = {2, 2, 2, 2, 2, 2, 3};
        assert (getDaysAboveAverage(test1) == 1);

        int[] test2 = {21, 10, 13, 34, 30, 21, 34};
        assert (getDaysAboveAverage(test2) == 3);

        int[] test3 = {2, 2, 2, 2, 2, 2, 1};
        assert (getDaysAboveAverage(test3) == 6);
    }*/

}
