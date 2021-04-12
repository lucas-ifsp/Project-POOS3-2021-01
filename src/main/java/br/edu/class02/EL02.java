package br.edu.class02;

import java.util.Scanner;

public class EL02 {
    /*Faça um programa que construa dois vetores A e B de 5 posições, lendo e adicionando valores
    inteiros a esses vetores. Crie um terceiro vetor C, composto pela soma dos elementos de A e B. Por exemplo:
        C[0] = A[0] + B[0]
        C[1] = A[1] + B[1]
    Após isso, escreva o conteúdo do vetor C, separados por vírgula. Qualquer situação fora do
    domínio de entrada resulta em saída uma “Erro”.

    */

    public static void main(String[] args) {
        int[] firstArray = new int[5];
        int[] secondArray = new int[5];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
             firstArray[i] = scanner.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            secondArray[i] = scanner.nextInt();
        }

        int[] arrayOfSums = getArrayOfSums(firstArray, secondArray);
        if(arrayOfSums == null) {
            System.out.println("Erro");
            return;
        }

        System.out.printf("%d, %d, %d, %d, %d", arrayOfSums[0], arrayOfSums[1], arrayOfSums[2], arrayOfSums[3], arrayOfSums[4]);
        //testApp();
    }

    private static int[] getArrayOfSums(int[] firstArray, int[] secondArray) {
        int[] result = new int[5];
        for (int i = 0; i < result.length; i++) {
            if(isSumOutOfIntLimits(firstArray[i] , secondArray[i]))
                return null;
            result[i] = firstArray[i] + secondArray[i];
        }
        return result;
    }

    private static boolean isSumOutOfIntLimits(int a, int b) {
        if(a > 0 && b > 0 && Integer.MAX_VALUE - a < b) // testa limite superior
            return true;
        if(a < 0 && b < 0 && Integer.MIN_VALUE - a < -b) // testa limite inferior
            return true;
        return false;
    }

    /*private static void testApp() {
        int[] firstArray = {1,1,1,1,1};
        int[] secondArray = {2,2,2,2,2};
        int[] expectedResult = {3, 3, 3, 3, 3};
        int[] arrayOfSums = getArrayOfSums(firstArray, secondArray);
        assert (hasSameElements(expectedResult, arrayOfSums));

        int[] firstArray1 = {2, 5, 8, 34, 5 };
        int[] secondArray1 = {8, 51, 2, 16, 5};
        int[] expectedResult1 = {10, 56, 10, 50, 10};
        int[] arrayOfSums1 = getArrayOfSums(firstArray1, secondArray1);
        assert (hasSameElements(expectedResult1, arrayOfSums1));

        int[] firstArray2 = {-10, 0, 10, 20, 30};
        int[] secondArray2 = {100, 50, 0, -50, -100};
        int[] expectedResult2 = {90, 50, 10, -30, -70};
        int[] arrayOfSums2 = getArrayOfSums(firstArray2, secondArray2);
        assert (hasSameElements(expectedResult2, arrayOfSums2));

        int[] firstArray3 = {1, 0, 3, 4, -2147483640};
        int[] secondArray3 = {4, 3, 9, 0, -500};
        int[] expectedResult3 = {90, 50, 10, -30, -70};
        int[] arrayOfSums3 = getArrayOfSums(firstArray3, secondArray3);
        assert (hasSameElements(expectedResult3, arrayOfSums3));
    }

    private static boolean hasSameElements(int[] expected, int[] obtained) {
        if(obtained == null || expected.length != obtained.length)
            return false;

        for (int i = 0; i < expected.length; i++) {
           if(expected[i] != obtained[i])
               return false;
        }
        return true;
    }*/
}
