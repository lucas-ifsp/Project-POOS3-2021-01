package br.edu.pratico02;

import java.util.*;

public class FuncionarioFakeDAO implements DAO<Funcionario, String> {
    private static Map<String, Funcionario> bd = new LinkedHashMap<>();

    public FuncionarioFakeDAO() {
    }

    public boolean insert(Funcionario funcionario){
        if(funcionario == null)
            throw new IllegalArgumentException("Funcionario não pode ser nulo!");
        if(bd.containsKey(funcionario.getCpf()))
            throw new CpfAlreadyExistsException("CPF já cadastrado");

        bd.put(funcionario.getCpf(), funcionario);
        return true;
    }

    public Optional<Funcionario> readOne(String cpf){
        return Optional.ofNullable(bd.get(cpf));
    }

    public List<Funcionario> readAll(){
        return new ArrayList<>(bd.values());
    }

    public boolean update(Funcionario funcionario){
        if (funcionario != null) {
            return bd.replace(funcionario.getCpf(), funcionario) != null;
        }
        return false;
    }

    public boolean remove(Funcionario funcionario){
        if (funcionario != null) {
            return removeByKey(funcionario.getCpf());
        }
        return false;
    }

    public boolean removeByKey(String cpf){
        if (cpf != null) {
            return bd.remove(cpf) != null;
        }
        return false;
    }
}
