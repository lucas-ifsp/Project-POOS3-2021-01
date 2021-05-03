package br.edu.class05.ea01;

public abstract  class Mamifero {
    private String nome;
    private String familia;

    public Mamifero(String nome, String familia) {
        this.nome = nome;
        this.familia = familia;
    }

    public Mamifero() {
    }

    public abstract void emitirSom();

    public void brincar(){System.out.println(nome + " está brincando…"); }

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getFamilia() {return familia;}
    public void setFamilia(String familia) {this.familia = familia;}
}
