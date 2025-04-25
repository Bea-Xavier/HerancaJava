import java.util.ArrayList;

public class Gerente extends Funcionario {
    public Gerente() {
    }

    public void realizarReuniao() {
        System.out.println("\nO(A) gerente " + nome + " está realizando uma reunião no momento!");
    }

    @Override

    public ArrayList<Object> mostrarDados(String nome, String cpf, String dataDeNascimento) {

        ArrayList<Object> dados = new ArrayList<>();
        dados.add("\nNome: " + nome);
        dados.add("Salário: " + this.salario);
        dados.add("Departamento: " + this.departamento);
        dados.add("CPF: " + cpf);
        dados.add("Data de Nascimento: " + dataDeNascimento);

        for (Object dado : dados) {
            System.out.println(dado);
        }

        return dados;
    }
}
