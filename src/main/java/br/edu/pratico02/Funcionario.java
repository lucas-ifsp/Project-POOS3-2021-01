package br.edu.pratico02;

import java.util.Objects;

public abstract class Funcionario {
    private String nome;
    private String cpf;
    private int idade;
    private boolean sexo;
    private double valorVendido;
    private Consultor responsavel;

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, int idade, boolean sexo, double valorVendido, Consultor responsavel) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.sexo = sexo;
        this.valorVendido = valorVendido;
        this.responsavel = responsavel;
    }

    public abstract double calculaComissao();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public double getValorVendido() {
        return valorVendido;
    }

    public void setValorVendido(double valorVendido) {
        this.valorVendido = valorVendido;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Consultor getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Consultor responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "| "+ nome  +
                " | " + cpf +
                " | " + idade +
                " | " + (sexo ? "F" : "M ") +
                " | " + valorVendido +
                " | " + calculaComissao() +
                " | ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return idade == that.idade && sexo == that.sexo && Double.compare(that.valorVendido, valorVendido) == 0 && Objects.equals(nome, that.nome) && cpf.equals(that.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cpf, idade, sexo, valorVendido);
    }
}
