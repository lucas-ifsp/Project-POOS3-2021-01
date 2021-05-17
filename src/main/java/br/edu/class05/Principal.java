package br.edu.class05;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        Time time = new Time("Flamengo", "Rio");
        Time time2 = new Time("São Paulo", "SP");

        List<Time> times = List.of(time, time2, time2, time2);

        Comparator<Time> byNome = Comparator.comparing(t -> t.getNome());

        Collections.sort(times, byNome);
        times.forEach(System.out::println);

    }
}
