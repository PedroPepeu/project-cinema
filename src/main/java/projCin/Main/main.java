package projCin.Main;

import java.util.Scanner;
import projCin.ComidaCompras.Buy;
import projCin.ComidaCompras.Food;
import projCin.Contas.Student;
import projCin.Contas.User;
import projCin.Enum.EnumPromotionalCoupon;
import projCin.Salas.Movie;
import projCin.Salas.MovieTime;
import projCin.Salas.Room;
import projCin.Contas.Critical;

public class main {

    // public static void main(String[] args) {
    // Scanner input = new Scanner(System.in);

    // double nota;

    // Buy compra = new Buy();

    // Movie movie = new Movie();

    // compra.menuGeral();

    // Review review = new Review();

    // do {

    // nota = input.nextDouble();

    // review.atribuirNota(nota, movie);

    // } while(true);

    // }

    public static String options() {
        return "Digite: 1 se Normal\n" +
                "Digite: 2 se Estudante\n" +
                "Digite: 3 se Critico\n";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Buy menuCompras = new Buy();
        Room menuSalas = new Room();
        Movie movie = new Movie();
        MovieTime mt = new MovieTime();
        Food menuComida = new Food();

        options();

        System.out.println("Por favor faça o cadastro:");

        System.out.println("Nome: ");
        String username = sc.nextLine();

        System.out.println("CPF: ");
        String cpf = sc.nextLine();

        System.out.println("Senha(numeros): ");
        int password = sc.nextInt();

        System.out.println("Idade: ");
        int age = sc.nextInt();

        System.out.println("Genero:\nm para masculino\nf para feminino");
        char gender = sc.next().charAt(0);

        System.out.println("E-mail: ");
        String email = sc.next();

        System.out.println("Nome que consta no cartao de credito: ");
        String creditCardName = sc.next();
        creditCardName.toUpperCase();

        System.out.println("Numero do cartao: ");
        String creditCardNum = sc.next();

        System.out.println("CCV do cartao: ");
        int creditCardVerify = sc.nextInt();

        menuCompras.menuOptions();
        int decision2 = sc.nextInt();

        switch (decision2) {
            case 1:
                // decidiu comprar ingressos
                menuSalas.amostraDeFilmes();
                menuSalas.movieChoice();
                decision2 = sc.nextInt();
                if (decision2 == 0) {
                    main(args);
                } else {
                    menuSalas.movieSelection(decision2);
                    menuSalas.ticketsQuantity();
                    int numOfPeople = sc.nextInt();
                    movie.choosenMovie(decision2);

                    System.out.println("Possui cupom promocional?\nnao (0)\nsim (1)");
                    int cup = sc.nextInt();

                    int cupomRaro = 12345;
                    int cupomEpico = 1234567;
                    int cupomLendario = 123456789;

                    double cupEfect = 1;
                    int cupcup = 1;

                    while (cup == 1 && cupcup != 0) {
                        System.out.println("Digite o codigo do cupom ou 0(zero) para cancelar cupom ");
                        cupcup = sc.nextInt();

                        if (cupcup == cupomRaro) {
                            cupEfect = EnumPromotionalCoupon.CUPOM_UM.getDesconto();
                            System.out.println("Cupom raro aprovado!");
                            break;

                        } else if (cupcup == cupomEpico) {
                            cupEfect = EnumPromotionalCoupon.CUPOM_DOIS.getDesconto();
                            System.out.println("Cupom epico aprovado!");
                            break;

                        } else if (cupcup == cupomLendario) {
                            cupEfect = EnumPromotionalCoupon.CUPOM_TRES.getDesconto();
                            System.out.println("Cupom lendario aprovado!");
                            break;

                        } else if (cupcup == 0) {
                            cupEfect = 1;
                        } else {
                            System.out.println("Cupom inexistente");

                        }
                    }

                    System.out.println("Tipo de ingresso: \n1- Inteira\n2- Estudante\n3- Critico");
                    int decision1;
                    double total;

                    do {
                        decision1 = sc.nextInt();
                        switch (decision1) {
                            case 1:
                                // usuario normal
                                User user = new User(username, cpf, password, age, gender, email, creditCardName,
                                        creditCardNum, creditCardVerify);

                                total = (1 - cupEfect) * (menuCompras.getTotal() + (movie.getPrice() * numOfPeople)); 
                                menuCompras.setTotal(user.totalParaPagar(total));

                                System.out.println("Total: R$ " + (menuCompras.getTotal()));
                                break;
                            case 2:
                                // usuario estudante
                                Student student = new Student(username, cpf, password, age, gender, email,
                                        creditCardName, creditCardNum, creditCardVerify, true);

                                total = (1 - cupEfect) * (menuCompras.getTotal() + (movie.getPrice() * numOfPeople));
                                menuCompras.setTotal(student.totalParaPagar(total));

                                System.out.println("Total: R$ " + (menuCompras.getTotal()));
                                break;
                            case 3:
                                // usuario critico
                                String origin = sc.next();
                                System.out.println("Digite em qual orgão você pertence: ");
                                Critical critical = new Critical(username, cpf, password, age, gender, email,
                                        creditCardName, creditCardNum, creditCardVerify, origin);

                                total = (1 - cupEfect) * (menuCompras.getTotal() + (movie.getPrice() * numOfPeople));
                                menuCompras.setTotal(critical.totalParaPagar(total));

                                System.out.println("Total: R$ " + (menuCompras.getTotal()));
                                break;
                            default:
                                System.out.println("Opção invalida, tente novamente!");
                        }
                    } while (decision1 < 1 || decision1 > 3);

                    // screen movie time
    
                    int avaliableChairs = mt.showChairs(movie.movieName(decision2));
                    if (avaliableChairs / numOfPeople > 1) {
                        boolean avaliable = mt.showChairsOptions(numOfPeople);
                        if (avaliable) {
                            System.out.println("Coluna: ");
                            int column = sc.nextInt();
                            System.out.println("Linha: ");
                            int line = sc.nextInt();
                            boolean[][] isOcupied = mt.getIsOcupied();
                            boolean done = false;
                            while (done) {
                                if (!isOcupied[line - 1][column - 1]) {
                                    isOcupied[line - 1][column - 1] = true;
                                    done = false;
                                    mt.setIsOcupied(isOcupied);
                                }
                            }
                        } else
                            System.out.println("Nao disponivel para este numero de tickets");
                    } else
                        System.out.println("Lotado");
                    // terminou de comprar a cadeira
                }
                break;
            case 2:
                // decidiu comprar comida
                menuComida.menuPresentation();
                int foodChoice = sc.nextInt();
                menuComida.compra(foodChoice);
                break;
        }

        menuCompras.menuChoice(decision2);

        sc.close();
    }

}
