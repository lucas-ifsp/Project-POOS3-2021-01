package br.edu.pratico02;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.inserirDadosTeste();

        principal.adicionaFuncionario();
        principal.removeFuncionario();
        principal.atualizaFuncionario();
        principal.consultaFuncionario();
        principal.printAll();
    }

    private void inserirDadosTeste() {
        Consultor huffman = new Consultor("David A. Huffman", "12312312312", 74, false, 7000.00, null);
        Consultor ada = new Consultor("Augusta Ada Byron", "32132132131", 36, true, 3000.00, huffman);
        Consultor dijkstra = new Consultor("Edsger Dijkstra", "21321321313", 72, false, 1520.00, huffman);
        Consultor turing = new Consultor("Alan Mathison Turing", "45645645646", 41, false, 780.00, ada);
        Revendedor neumann = new Revendedor("John von Neumann", "65465465464", 53, false, 300.00, turing);
        Revendedor knuth = new Revendedor("Donald Ervin Knuth", "90219021902", 80, false, 432.00, turing);
        Revendedor hopper = new Revendedor("Grace Murray Hopper", "54654654654", 85, true, 432.00, dijkstra);

        huffman.addSubordinado(ada);
        huffman.addSubordinado(dijkstra);
        ada.addSubordinado(turing);
        dijkstra.addSubordinado(hopper);
        turing.addSubordinado(neumann);
        turing.addSubordinado(knuth);

        FuncionarioFakeDAO dao = new FuncionarioFakeDAO();
        dao.insert(huffman);
        dao.insert(ada);
        dao.insert(dijkstra);
        dao.insert(turing);
        dao.insert(neumann);
        dao.insert(knuth);
        dao.insert(hopper);
    }

    private void adicionaFuncionario() {
        String cpf = readPK("CPF: ");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        System.out.print("Sexo: ");
        boolean sexo = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Valor Vendido: ");
        double valorVendido = Double.parseDouble(scanner.nextLine());

        String cpfResponsavel = readPK("CPF do Responsável: ");

        DAO dao = new FuncionarioFakeDAO();

        dao.readOne(cpfResponsavel).ifPresent(result -> {
            if (result instanceof Revendedor revendedor)
                result = promoveRevendedor(revendedor);

            Consultor responsavel = (Consultor) result;

            Revendedor novoRevendedor = new Revendedor(nome, cpf, idade, sexo, valorVendido, responsavel);
            responsavel.addSubordinado(novoRevendedor);

            dao.insert(novoRevendedor);
            dao.update(result);
        });
    }

    private String readPK(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(message);
        String result = scanner.nextLine();
        scanner.close();
        return result;
    }

    private void consultaFuncionario() {
        String cpf = readPK("CPF: ");
        consultaFuncionarioNoBanco(cpf).ifPresentOrElse(System.out::println, () -> System.out.println("Funcionario não encontrado!"));
    }

    private void atualizaFuncionario() {
        String cpf = readPK("CPF: ");
        consultaFuncionarioNoBanco(cpf).ifPresentOrElse(f -> consultaEAtualiza(f), () -> System.out.println("Funcionario não encontrado!"));
    }

    private void consultaEAtualiza(Funcionario funcionarioConsulta) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        funcionarioConsulta.setNome(scanner.nextLine());
        System.out.print("Idade: ");
        funcionarioConsulta.setIdade(Integer.parseInt(scanner.nextLine()));
        System.out.print("Sexo: ");
        funcionarioConsulta.setSexo(Boolean.parseBoolean(scanner.nextLine()));
        System.out.print("Valor Vendido: ");
        funcionarioConsulta.setValorVendido(Double.parseDouble(scanner.nextLine()));

        String cpfResponsavel = readPK("CPF do Responsável: ");

        if (!cpfResponsavel.equals(funcionarioConsulta.getResponsavel().getCpf())) {

            DAO<Funcionario, String> dao = new FuncionarioFakeDAO();

            dao.readOne(cpfResponsavel).ifPresent(responsavel -> {
                if (responsavel instanceof Revendedor r) {
                    responsavel = new Consultor(r);
                }
                ((Consultor) responsavel).addSubordinado(funcionarioConsulta);
                dao.update(responsavel);

                dao.update(funcionarioConsulta);
            });

            scanner.close();
        }
    }


    private void removeFuncionario() {
        String cpf = readPK("CPF: ");

        consultaFuncionarioNoBanco(cpf).ifPresent(funcionarioARemover -> {
            Consultor responsavel = funcionarioARemover.getResponsavel();
            responsavel.rmSubordinado(funcionarioARemover);

            DAO dao = new FuncionarioFakeDAO();
            dao.remove(funcionarioARemover);
            dao.update(responsavel);
        });
    }

    private Optional<Funcionario> consultaFuncionarioNoBanco(String cpf) {
        FuncionarioFakeDAO dao = new FuncionarioFakeDAO();
        return dao.readOne(cpf);
    }

    private Consultor promoveRevendedor(Revendedor revendedor) {
        Consultor consultor = new Consultor(revendedor);
        FuncionarioFakeDAO dao = new FuncionarioFakeDAO();
        dao.update(consultor);
        return consultor;
    }

    public void printAll() {
        FuncionarioFakeDAO dao = new FuncionarioFakeDAO();
        List<Funcionario> todosFuncionarios = dao.readAll();

        for (Funcionario funcionario : todosFuncionarios) {
            System.out.println(funcionario);
        }
    }


}
