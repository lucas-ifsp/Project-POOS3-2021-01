package br.edu.class05.ea01;

public class Principal {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Totó", "SRD");
        Gato gata = new Gato("Berenice", true);

        System.out.println(cachorro);
        System.out.println(gata);

        cachorro.brincar();
        cachorro.emitirSom(); //definido na superclasse, mas implementado concretamente na subclasse
    }
}
