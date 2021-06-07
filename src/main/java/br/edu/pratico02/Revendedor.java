package br.edu.pratico02;

public class Revendedor extends Funcionario{

    public Revendedor() {
    }

    public Revendedor(String nome, String cpf, int idade, boolean sexo, double valorVendido, Consultor responsavel) {
        super(nome, cpf, idade, sexo, valorVendido, responsavel);
    }

    @Override
    public double calculaComissao() {
        return getValorVendido() * 0.15;
    }
}
