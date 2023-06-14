package projCin.Main;

import java.util.Scanner;

import projCin.CircularList.MoviesNodesTestando.MovieCLLTeste;
import projCin.ContasSudo.ADM;
import projCin.ContasSudo.Funcionario;

public class TheTrueSaladao {
    public static void main(String[] args) {
        MovieCLLTeste filmes = new MovieCLLTeste();

        areaInicial(filmes);

    }
    //uma main p conseguir olhar a anterior e fazer a adaptação, sem apagar :)

    public static void areaInicial(MovieCLLTeste filmes) {
        Scanner input = new Scanner(System.in);

       
        int opcoes;
        String nome;
        int idade;
        String email;
        String ID;

            System.out.println("\nBem vindo(a) ao teste do nosso sistema de cinema!\n");
        do {
            System.out.println("1- Área dos Administradores");
            System.out.println("2- Área dos funcionarios");
            System.out.println("3- Usuário padrão");
            System.out.println("0- Finalizar programa");
            opcoes = input.nextInt();
            
            switch (opcoes) {
                case 1: 
                        System.out.println("Digite seu nome: ");
                        nome = input.next();
                        System.out.println("Digite sua idade: ");
                        idade = input.nextInt();
                        System.out.println("Digite seu email: ");
                        email = input.next();
                        System.out.println("Digite sua ID: ");
                        ID = input.next();

                        executeADM(filmes, nome, idade, email, ID);
                        break;

                case 2: System.out.println("Digite seu nome: ");
                        nome = input.next();
                        System.out.println("Digite sua idade: ");
                        idade = input.nextInt();
                        System.out.println("Digite seu email: ");
                        email = input.next();
            
                        executeFuncionario(filmes, nome, idade, email);
                        break;

                case 3: 
                        executeUser(filmes);
                        break;

                case 0: System.out.println("Programa finalizando...");
                        System.exit(0);
                        break;

                default: System.out.println("Opção inválida");        
            }

        } while (opcoes < 1 || opcoes > 3);

    }

    public static void executeADM(MovieCLLTeste filmes, String nome, int idade, String email, String ID) {
        Scanner input = new Scanner(System.in);

        int opcoes;

        if (ID.equals("rianAcumuladorDeLinhas") || ID.equals("naromeContraTerrorista") || ID.equals("pepeuZonas")) {

             ADM admin = new ADM(nome, idade, email, ID, 5000);

             System.out.println("Bem vindo, administrador! Selecione o que deseja fazer!\n ");
             
             do {   
                    System.out.println("1- Adicionar um filme no cartaz");
                    System.out.println("2- Retirar um filme do cartaz");
                    System.out.println("3- Alterar um filme do cartaz");
                    System.out.println("4- Adicionar um usuário");
                    System.out.println("5- Alterar algo do usuário");
                    System.out.println("6- Excluir um usuário");
                    System.out.println("0- Voltar para o menu principal");
                    opcoes = input.nextInt();

                switch (opcoes) {
                    case 1: 
                            filmes.inserir(admin.incluirFilme());
                            break;

                    case 2:
                            filmes.remover(admin.excluirFilme());
                            break;

                    case 3:
                            filmes.editar(admin.alterarFilme());
                            break;

                    case 4: //IMPLEMENTAR ADICIONAR USER

                            break;

                    case 5: //IMPLEMENTAR ALTERAR USER

                            break;

                    case 6: //IMPLEMENTAR EXCLUIR USER

                            break;

                    case 0: areaInicial(filmes);
                            break;

                    default: System.out.println("Opção Inválida");
                }
                
             } while (opcoes != 0);
             

        } else {
            System.out.println("ID NÃO RECONHECIDA, VOLTANDO PARA O MENU...");
            areaInicial(filmes);
        }

    }   

    public static void executeFuncionario(MovieCLLTeste filmes, String nome, int idade, String email) {
        Scanner input = new Scanner(System.in);

        int opcoes;

            Funcionario funcionario = new Funcionario(nome, idade, email, 5000);

            System.out.println("\nBem vindo, funcionário! Selecione o que deseja fazer: \n");

        do {
                System.out.println("1- Adicionar um filme no cartaz");
                System.out.println("2- Retirar um filme do cartaz");
                System.out.println("3- Alterar um filme do cartaz");
                System.out.println("4- Adicionar um usuário");
                System.out.println("5- Alterar algo do usuário");
                System.out.println("0- Voltar para o menu principal");
                opcoes = input.nextInt();

                switch (opcoes) {
                    case 1: filmes.inserir(funcionario.incluirFilme());
                            break;

                    case 2: filmes.remover(funcionario.excluirFilme());
                            break;

                    case 3: filmes.editar(funcionario.alterarFilme());
                            break;

                    case 4: //IMPLEMENTAR ADICIONAR USER
                            break;

                    case 5: //IMPLEMENTAR ALTERAR USER
                            break;

                    case 0: areaInicial(filmes);        
                            break;

                    default: System.out.println("Opção inválida!");         
                }

        } while (opcoes != 0);

    }

    public static void executeUser(MovieCLLTeste filmes) {

        if (filmes.getControleDasAtualizacoes() != 0) {
            System.out.println("\n\nNovas notificações!-->");
            filmes.mostrarUpdatesParaUser();
        }  

        //IMPLEMENTAR O RESTANTE DO USER
            System.out.println("\n\nCOISAS DO USER!");
            
        
    }
}
