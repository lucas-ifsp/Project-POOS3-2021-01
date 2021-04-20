package br.edu.class03.EA01;

public class Personagem {
    String nome;   int idade;
    Dublador dublador;

    public Personagem(String nome, int idade) {
        this.nome = nome; this.idade = idade;
    }

    public Dublador getDublador() {
        return dublador;
    }

    public void setDublador(Dublador dublador) {
        this.dublador = dublador;
    }
}
