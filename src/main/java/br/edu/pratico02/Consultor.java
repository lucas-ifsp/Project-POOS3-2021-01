package br.edu.pratico02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Consultor extends Funcionario{

    private List<Funcionario> subordinados = new ArrayList<>();

    public Consultor() {
    }

    public Consultor(Revendedor r) {
        this(r.getNome(), r.getCpf(), r.getIdade(), r.isSexo(), r.getValorVendido(), r.getResponsavel());
    }

    public Consultor(String nome, String cpf, int idade, boolean sexo, double valorVendido, Consultor resposavel) {
        super(nome, cpf, idade, sexo, valorVendido, resposavel);
    }

    @Override
    public double calculaComissao() {
        double soma = getValorVendido() * 0.15;
        for (Funcionario subordinado : subordinados) {
            soma += subordinado.calculaComissao() * 0.3;
        }
        return soma;
    }

    public void addSubordinado(Funcionario funcionario){
        subordinados.add(funcionario);
    }

    public void rmSubordinado(Funcionario funcionario){
        if (funcionario != null) {
            atualizaFilhos(funcionario);
            subordinados.remove(funcionario);
        }
    }

    private void atualizaFilhos(Funcionario funcionario) {
        if(funcionario instanceof Revendedor)
            return;

        Consultor consultor = (Consultor) funcionario;
        for (Funcionario sub : consultor.subordinados) {
            sub.setResponsavel(this);
            subordinados.add(sub);
        }
    }

    public int numSubordinados(){
        return subordinados.size();
    }

    @Override
    public String toString() {
        return super.toString() + numSubordinados() + " |";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Consultor consultor = (Consultor) o;
        return Objects.equals(subordinados, consultor.subordinados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), subordinados);
    }
}
