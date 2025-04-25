import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    // Atributos da superclasse em relação a Funcionário
    public String cpf;
    public String dataDeNascimento;

    // Métodos construtores
    public Pessoa(String cpf, String dataDeNascimento) {
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
    }

    public Pessoa() {
    }

    // Método GET

    public String getCpf() {
        return cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    // Método SET

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    // Método de conversão da data

    public String dataBR(String dataDeNascimento) {

        // Criando um formatador para o padrão brasileiro
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Convertendo a string para LocalDate usando o formatador
       LocalDate data = LocalDate.parse(dataDeNascimento, formatador);

        return data.format(formatador);

    }

}
