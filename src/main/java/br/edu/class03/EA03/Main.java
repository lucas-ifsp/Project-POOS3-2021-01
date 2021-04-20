package br.edu.class03.EA03;

public class Main {
    public static void main(String[] args) {
        ValueHolder v1 = new ValueHolder();
        ValueHolder v2 = new ValueHolder();

        v1.setValue(10);
        System.out.println(v1.getValue());

        v2.setValue(20);
        System.out.println(v2.getValue());
        System.out.println(v1.getValue());

        System.out.println(ValueHolder.value);

    }
}
