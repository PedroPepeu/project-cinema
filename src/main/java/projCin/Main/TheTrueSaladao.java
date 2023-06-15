package projCin.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import projCin.CircularList.MoviesNodesTestando.MovieCLLTeste;
import projCin.ComidaCompras.Buy;
import projCin.ComidaCompras.Food;
import projCin.ContasSudo.ADM;
import projCin.ContasSudo.Funcionario;
import projCin.Salas.Movie;
import projCin.Salas.Room;


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

                    case 4: admin.adicionarUser();;

                            break;

                    case 5: admin.alterarUser(); //nao esta funcionando muito bem, ver depois

                            break;

                    case 6: admin.excluirUser();

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

                    case 4: funcionario.adicionarUser();
                            break;

                    case 5: funcionario.alterarUser(); //nao esta funcionando muito bem, ver depois
                            break;

                    case 0: areaInicial(filmes);        
                            break;

                    default: System.out.println("Opção inválida!");         
                }

        } while (opcoes != 0);

    }

    public static void executeUser(MovieCLLTeste filmes) {
        Scanner input = new Scanner(System.in);

        Buy menuCompras = new Buy();
        Room menuSalas = new Room();
        Movie movie = new Movie();
        Food menuComida = new Food();

        String CPF;
        int decisao;

        System.out.println("Digite seu CPF: ");
        CPF = input.next();

        if (verificarUsuario(CPF)) {

                if (filmes.getControleDasAtualizacoes() != 0) {
            System.out.println("\nNovas notificações!-->");
            filmes.mostrarUpdatesParaUser();
        }  
               

                menuCompras.menuOptions();
                decisao = input.nextInt();

                comprar(decisao, filmes, menuCompras, movie, menuComida, menuSalas);
                //UserPath.userAcess();
                
        } else {
                System.out.println("cpf inválido, tente novamente");
                areaInicial(filmes);
        }
        
    }

    public static void comprar(int decisao, MovieCLLTeste filmes, Buy menuCompras, Movie movie, Food menuComida, Room menuSalas) {
        Scanner input = new Scanner(System.in);

        int decisaoDois;
        
        int escolhaComida;

    
            do {
                switch (decisao) {

                    case 1: 
                    //decidiu comprar ingressos
                    menuSalas.sessions(filmes, menuComida, movie);

                    if(menuSalas.getControleNaMain() == 1) {
                        menuCompras.menuOptions();
                        decisao = input.nextInt();

                    }
                    
                       break;
                    case 2:
                    //decidiu comprar comida
                    menuComida.menuPresentation();
                    escolhaComida = input.nextInt();
                    menuComida.compra(escolhaComida);
 
                    menuCompras.menuOptions();
                    decisaoDois = input.nextInt();
                    comprar(decisaoDois, filmes, menuCompras, movie, menuComida, menuSalas);
                    
                    break;

                    case 3: System.out.println("Voltando para o menu...");
                            areaInicial(filmes);
                            break;
        
                    default: System.out.println("Opção inválida!");
                    
                }
            } while (menuSalas.getControleNaMain() == 1);

            
    }

    public static boolean verificarUsuario(String cpf) {
        String nomeArquivo = "./src/main/java/projCin/DataBaseUsers/Database.txt";

        // Ler os dados do arquivo para uma lista
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha; 
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Verificar se o CPF está presente nos dados
        for (String linha : linhas) {
            String[] dados = linha.split(",");
            if (dados.length > 0 && dados[0].trim().equals(cpf)) {
                return true;
            }
        }

        return false;
    }
}
