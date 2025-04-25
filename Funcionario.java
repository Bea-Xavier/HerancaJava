import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {

    // Atributos da subclasse Funcionário
    public String nome;
    public double salario;
    public String departamento;

    // Métodos construtores

    //Com todos os parâmetros
    public Funcionario(String nome, double salario, String departamento, String cpf, String dataDeNascimento) {
        super(cpf, dataDeNascimento); // Chama o construtor da superclasse Pessoa
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
    }

    //Com apenas nome, cpf e data de nascimento
    public Funcionario(String nome, String cpf, String dataDeNascimento) {
        super(cpf, dataDeNascimento);
        this.nome = nome;
    }

    public Funcionario() {
    }

    // Método GET

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    // Método SET

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    // Método Mostrar Dados de Funcionário

    public ArrayList<Object> mostrarDados(String nome, String cpf, String dataDeNascimento) {

        ArrayList<Object> dados = new ArrayList<>();
        dados.add("\nNome: " + nome);
        dados.add("CPF: " + cpf);
        dados.add("Data de Nascimento: " + dataDeNascimento);

        for (Object dado : dados) {
            System.out.println(dado);
        }

        return dados;
    }

    // Método de Bater Ponto

    public void baterPonto() {
        LocalDateTime pontoBatido = LocalDateTime.now();
        DateTimeFormatter formatado = DateTimeFormatter.ofPattern("HH:mm"); // Formato de hora e minutos
        String horaFormatada = pontoBatido.format(formatado);
        System.out.println("\nO(A) funcionário(a) " + nome + " bateu o ponto às: " + horaFormatada + "h");
    }

}