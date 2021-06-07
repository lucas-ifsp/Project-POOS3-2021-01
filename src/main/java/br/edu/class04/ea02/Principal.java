package br.edu.class04.ea02;

public class Principal {


    public static void main(String[] args) {
        Circulo c1 = new Circulo(1,2, 1);

        Figura r1 = new Retangulo(10, 10, 5, 2);
        Triangulo t1 = new Triangulo(0,0, 3, 4, 5);

        System.out.println(c1);
        System.out.println(r1.getArea());
        System.out.println(t1.getArea());




    }
}
