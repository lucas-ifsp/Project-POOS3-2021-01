package br.edu.class04.ea01;

public class Cachorro extends Mamifero{
    private String raca; // Variável adicionada pelo subtipo

    public Cachorro() {
        this("Sem nome", "SND");
    }

    public Cachorro(String nome, String raca){
        super(nome, "Canídeo");
        this.raca = raca;
    }


    @Override
    public void emitirSom() {
        System.out.println("Au Au Au!");
    }

    public void emitirSom(int i){
        for (int j = 0; j < i; j++) {
            emitirSom();
        }
    }

    @Override
    public void brincar() {
        System.out.println("Está brincando com o gato...");
        super.brincar();
    }
}