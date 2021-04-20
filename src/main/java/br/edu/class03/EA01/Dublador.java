package br.edu.class03.EA01;

public class Dublador {
    String nome; int registroProfissional;
    Personagem personagem;

    public Dublador(String nome, int registroProfissional) {
        this.nome = nome; this.registroProfissional = registroProfissional;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public void falar(){
        System.out.println("Olá");
    }

    public void falar(String algo){
        System.out.println("Falando " + algo);
    }

}