import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8");

        System.out.println("\nSeja bem-vindo(a) ao sistema de cadastro de funcionários!");

        ArrayList<Funcionario> funcionarios = new ArrayList<>();
        ArrayList<Gerente> gerentes = new ArrayList<>();
        ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<>();
        ArrayList<Estagiario> estagiarios = new ArrayList<>();
        int op;
        boolean cadastroFeitoFunc = false; // Variável para verificar se o cadastro foi feito antes de exibir os dados e
                                           // executar tarefas
        boolean cadastroFeitoGer = false;
        boolean cadastroFeitoDev = false;
        boolean cadastroFeitoEst = false;

        do {
            System.out.println("\n1- Cadastrar Novos Funcionários");
            System.out.println("2- Exibir Dados Cadastrados");
            System.out.println("3- Executar Tarefas dos Funcionários");
            System.out.println("0- Sair do Sistema");
            System.out.println("\nEscolha uma opção de execução do sistema: ");

            op = scanner.nextInt();

            switch (op) {
                // Cadastrar novos funcionários
                case 1:
                    scanner.nextLine(); // Consumir a quebra de linha

                    System.out.println("Digite o nome do(a) funcionário(a): ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite o CPF do(a) funcionário(a): ");
                    String cpf = scanner.nextLine();

                    System.out.println("Digite a data de nascimento (Dia/Mês/Ano) do(a) funcionário(a): ");
                    String dataDeNascimento = scanner.nextLine();

                    // Cria a instância do Objeto Funcionario
                    Funcionario funcionario = new Funcionario(nome, cpf, dataDeNascimento);

                    dataDeNascimento = funcionario.dataBR(dataDeNascimento); // Chama o método dataBR para formatar a
                                                                             // data

                    funcionario.setDataDeNascimento(dataDeNascimento); // Atualiza a data de nascimento formatada no
                                                                       // objeto funcionário

                    // Adiciona o funcionário à lista de funcionários
                    funcionarios.add(funcionario);

                    cadastroFeitoFunc = true; // Define que o cadastro foi feito com sucesso2

                    // Pergunta se o usuário quer adicionar um tipo específico de funcionário
                    System.out
                            .println("\nDeseja adicionar um departamento para o(a) funcionário(a)? (1- Sim / 2- Não)");

                    op = scanner.nextInt();

                    if (op == 1) {
                        scanner.nextLine();
                        System.out.println("\nDigite o departamento do(a) funcionário(a): ");
                        System.out.println("1- Gerente");
                        System.out.println("2- Desenvolvedor");
                        System.out.println("3- Estagiário\n");

                        op = scanner.nextInt();

                        double salario;

                        switch (op) {
                            case 1:
                                System.out.println("\nDigite o salário do(a) gerente: ");
                                salario = scanner.nextDouble();

                                scanner.nextLine();

                                // Cria a instância do Objeto Gerente
                                Gerente gerente = new Gerente();

                                // Método SET
                                gerente.setNome(funcionario.getNome());
                                gerente.setCpf(funcionario.getCpf());
                                gerente.setDataDeNascimento(funcionario.getDataDeNascimento());
                                gerente.setSalario(salario);
                                gerente.setDepartamento("   Gerente");

                                // Adiciona o gerente à lista de gerentes
                                gerentes.add(gerente);

                                cadastroFeitoGer = true;

                                System.out.println("\nCadastro de gerente realizado com sucesso!\n");

                                break;

                            case 2:
                                System.out.println("\nDigite o salário do(a) desenvolvedor(a): ");
                                salario = scanner.nextDouble();

                                scanner.nextLine();

                                // Cria a instância do Objeto Desenvolvedor
                                Desenvolvedor desenvolvedor = new Desenvolvedor();

                                // Método SET
                                desenvolvedor.setNome(funcionario.getNome());
                                desenvolvedor.setCpf(funcionario.getCpf());
                                desenvolvedor.setDataDeNascimento(funcionario.getDataDeNascimento());
                                desenvolvedor.setSalario(salario);
                                desenvolvedor.setDepartamento("Desenvolvedor");

                                // Adiciona o desenvolvedor à lista de desenvolvedores
                                desenvolvedores.add(desenvolvedor);

                                cadastroFeitoDev = true;

                                System.out.println("\nCadastro de desenvolvedor realizado com sucesso!\n");

                                break;

                            case 3:
                                System.out.println("\nDigite o salário do(a) estagiário(a): ");
                                salario = scanner.nextDouble();

                                scanner.nextLine();

                                // Cria a instância do Objeto Estagiario
                                Estagiario estagiario = new Estagiario();

                                // Método SET
                                estagiario.setNome(funcionario.getNome());
                                estagiario.setCpf(funcionario.getCpf());
                                estagiario.setDataDeNascimento(funcionario.getDataDeNascimento());
                                estagiario.setSalario(salario);
                                estagiario.setDepartamento("Estagiário");

                                // Adiciona o estagiario à lista de estagiarios
                                estagiarios.add(estagiario);

                                cadastroFeitoEst = true;

                                System.out.println("\nCadastro de Estagiário realizado com sucesso!\n");
                                break;

                            default:
                                System.out.println("Opção inválida! Tente novamente.");
                                op = scanner.nextInt();
                        }
                    } else if (op != 2) {
                        System.out.println("Opção inválida! Tente novamente.");
                        op = scanner.nextInt();

                    }

                    System.out.println("\nCadastro de Funcionário realizado com sucesso!\n");

                    break;

                // Exibir dados cadastrados
                case 2:
                    System.out.println("\nQuais dados você deseja exibir? ");
                    System.out.println("1- Funcionários");
                    System.out.println("2- Gerentes");
                    System.out.println("3- Desenvolvedores");
                    System.out.println("4- Estagiários\n");

                    op = scanner.nextInt();

                    switch (op) {
                        case 1:
                            if (cadastroFeitoFunc == true) {
                                System.out.println("\nDados dos Funcionários: ");
                                for (Funcionario f : funcionarios) {
                                    f.mostrarDados(f.getNome(), f.getCpf(), f.getDataDeNascimento());
                                }
                            } else {
                                System.out.println("Nenhum funcionário cadastrado ainda!");

                            }
                            break;

                        case 2:
                            if (cadastroFeitoGer == true) {
                                System.out.println("\nDados dos Gerentes: ");
                                for (Gerente g : gerentes) {
                                    g.mostrarDados(g.getNome(), g.getCpf(), g.getDataDeNascimento());
                                }
                            } else {
                                System.out.println("Nenhum gerente cadastrado ainda!");

                            }
                            break;

                        case 3:
                            if (cadastroFeitoDev == true) {
                                System.out.println("\nDados dos Desenvolvedores: ");
                                for (Desenvolvedor d : desenvolvedores) {
                                    d.mostrarDados(d.getNome(), d.getCpf(), d.getDataDeNascimento());
                                }
                            } else {
                                System.out.println("Nenhum desenvolvedor cadastrado ainda!");

                            }
                            break;

                        case 4:
                            if (cadastroFeitoEst == true) {
                                System.out.println("\nDados dos Estagiários: ");
                                for (Estagiario e : estagiarios) {
                                    e.mostrarDados(e.getNome(), e.getCpf(), e.getDataDeNascimento());
                                }
                            } else {
                                System.out.println("Nenhum estagiário cadastrado ainda!");

                            }
                            break;

                        default:
                            if (op < 1 || op > 4) {
                                System.out.println("Opção inválida, tente novamente...");
                                op = scanner.nextInt();
                            }
                            break;
                    }

                    break;

                // Executar tarefas dos funcionários
                case 3:
                    System.out.println("\nDe qual departamento você deseja executar a tarefa?");
                    System.out.println("1- Funcionário");
                    System.out.println("2- Gerente");
                    System.out.println("3- Desenvolvedor");
                    System.out.println("4- Estagiário\n");

                    op = scanner.nextInt();

                    switch (op) {
                        case 1:
                            scanner.nextLine();

                            if (cadastroFeitoFunc == true) {
                                System.out
                                        .println("\nInsira o nome do(a) funcionário(a) que deseja executar a tarefa: ");
                                String n = scanner.nextLine();

                                boolean encontrado = false; // Variável para verificar se o funcionário foi encontrado

                                for (Funcionario f : funcionarios) {
                                    if (f.getNome().equalsIgnoreCase(n)) {
                                        f.baterPonto();
                                        encontrado = true;
                                        break;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("Funcionário não encontrado!");
                                }
                            } else {
                                System.out.println("Nenhum funcionário cadastrado ainda!");

                            }
                            break;

                        case 2:
                            scanner.nextLine();
                            if (cadastroFeitoGer == true) {
                                System.out.println("\nInsira o nome do(a) gerente que deseja executar a tarefa: ");
                                String n = scanner.nextLine();

                                boolean encontrado = false;

                                for (Gerente g : gerentes) {
                                    if (g.getNome().equalsIgnoreCase(n)) {
                                        g.realizarReuniao();
                                        encontrado = true;
                                        break;
                                    }

                                }
                                if (!encontrado) {
                                    System.out.println("Gerente não encontrado!");
                                }
                            } else {
                                System.out.println("Nenhum gerente cadastrado ainda!");

                            }
                            break;

                        case 3:
                            scanner.nextLine();
                            if (cadastroFeitoDev == true) {
                                System.out.println(
                                        "\nInsira o nome do(a) desenvolvedor(a) que deseja executar a tarefa: ");
                                String n = scanner.nextLine();

                                boolean encontrado = false;

                                for (Desenvolvedor d : desenvolvedores) {
                                    if (d.getNome().equalsIgnoreCase(n)) {
                                        d.programar();
                                        encontrado = true;
                                        break;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("Desenvolvedor não encontrado!");
                                }
                            } else {
                                System.out.println("Nenhum desenvolvedor cadastrado ainda!");

                            }
                            break;

                        case 4:
                            scanner.nextLine();
                            if (cadastroFeitoEst == true) {
                                System.out
                                        .println("\nInsira o nome do(a) estagiário(a) que deseja executar a tarefa: ");
                                String n = scanner.nextLine();

                                boolean encontrado = false;

                                for (Estagiario e : estagiarios) {
                                    if (e.getNome().equalsIgnoreCase(n)) {
                                        e.fazerTarefa();
                                        encontrado = true;
                                        break;
                                    }
                                }
                                if (!encontrado) {
                                    System.out.println("Estagiário não encontrado!");
                                }
                            } else {
                                System.out.println("Nenhum estagiário cadastrado ainda!");

                            }
                            break;

                        default:
                            if (op < 1 || op > 4) {
                                System.out.println("Opção inválida, tente novamente...");
                                op = scanner.nextInt();
                            }
                            break;
                    }

                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                // Default case para o sistema principal
                default:
                    if (op < 0 || op > 4) {
                        System.out.println("Erro! Opção inválida, tente novamente...");
                        op = scanner.nextInt();
                    }
                    break;
            }

        } while (op != 0);

        scanner.close();
    }
}