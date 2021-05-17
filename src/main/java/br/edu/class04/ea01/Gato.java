package br.edu.class04.ea01;

public class Gato extends Mamifero{ // Gato herda Mamífero, logo Gato É UM Mamífero.
    private boolean unhaAfiada; // Variável adicionada pelo subtipo

    public Gato(String nome, boolean unha){
        unhaAfiada = unha;
        setNome(nome); // Gato possui o método, pois o herda de Mamífero
        setFamilia("Felino"); // idem
    }


    @Override
    public void emitirSom() {
        System.out.println("Miau Miau!");
    }

    public String toString(){
        return  "Nome: " + getNome() + " | Família: " + getFamilia() + " | Unha afiada: " + (unhaAfiada? "Sim": "Não");
    }
}