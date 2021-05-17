package br.edu.class05;

class Time {
     private String nome;
     private String cidade;

     public Time(String nome, String cidade) {
         this.nome = nome;
         this.cidade = cidade;
     }

     @Override
     public String toString() {
         return "Time{" +
                 "nome='" + nome + '\'' +
                 ", cidade='" + cidade + '\'' +
                 '}';
     }

     public String getNome() {
         return nome;
     }

     public void setNome(String nome) {
         this.nome = nome;
     }

     public String getCidade() {
         return cidade;
     }

     public void setCidade(String cidade) {
         this.cidade = cidade;
     }
 }