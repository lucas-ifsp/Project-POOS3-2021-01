package br.edu.class01;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class EA01 {

    public static void main(String[] args) {
        int i = 10; // 32 bits
        long l = 10l; // 64 bits
        short s = 10; // 16 bits
        byte b = 10; // 8 bits
        float f = 10.1f; // 32 bits ponto flutuante
        double d = 10.7; // 64 bits ponto flutuante

        f = (float) d; // cast, conversão explícita do tipo maior para o menor
        l = (long) d; // Idem. Nesse caso, perde-se a parte decimal.

        char aChar = '\u2328'; // char é na verdade um número inteiro representando um caractere unicode. Use '' para atribuir

        String string = "10"; // para atribuir uma string, use aspas duplas "".

        System.out.println("f = " + f / 3); // float, veja que há menos casas após a vírgula
        System.out.println("d = " + d / 3); // double, veja que é mais preciso.
        System.out.println("l = " + l/3); // divisão entre inteiros retorna um inteiro
        System.out.println("aChar = " + aChar);

        final int CONST_I = 20; // o modificador final transforma a variável em constante

        LocalDate date = LocalDate.now();
        DayOfWeek dow = date.getDayOfWeek(); // enum para dias da semana

        if (dow == DayOfWeek.SATURDAY || dow == DayOfWeek.SUNDAY) // um enum só aceita o seu conjunto de valores pré-definidos
            System.out.println("Party time!!! \\o/");
        else
            System.out.println("Working time! =(");

        System.out.println(s++); // imprime s e depois incrementa
        System.out.println(s);

        System.out.println(--s < 11 ? "olá" : "tchau"); // if ternário (use com moderação). O valor de s é decrementado e depois avaliado.

        int val1 = 10;
        int val2 = 3;

        System.out.println((double) val1/val2); // uso de cast para promover um dos participantes da expressão, evitando um resultado inteiro

        byte s1 = 39;
        byte s2 = 4;

        int aVal = 10; // uma operação envolvendo apenas números menores que inteiros retorna, por segurança, um inteiro (exceção)

        //exemplo de AND bitwise (compara todas as partes da expressão lógica, mesmo que o resultado já seja determinado pela primeira parte)
        if(aVal != 10 & aVal++ > 10)
            System.out.println("olá 2");

        System.out.println(aVal);
    }
}
