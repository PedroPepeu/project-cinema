package projCin;

import java.util.Scanner;

import javax.tools.ForwardingFileObject;

public class main {

    // public static void main(String[] args) {
    //     Scanner input = new Scanner(System.in);
        
    //     double nota;
    
    //     Buy compra = new Buy();

    //     Movie movie = new Movie();

    //     compra.menuGeral();

    //     Review review = new Review();

    //     do {

    //         nota = input.nextDouble();

    //         review.atribuirNota(nota, movie);

            
    //     } while(true);

        
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
        String email = sc.nextLine();
        
        System.out.println("Nome que consta no cartao de credito: ");
        String creditCardName = sc.nextLine();
        creditCardName.toUpperCase();
        
        System.out.println("Numero do cartao: ");
        String creditCardNum = sc.nextLine();
        
        System.out.println("CCV do cartao: ");
        int creditCardVerify = sc.nextInt();
        
        
        int decision = sc.nextInt();
        
        switch(decision) {
            case 1:
            // usuario normal
                User user = new User(username, cpf, password, age, gender, email, creditCardName, creditCardNum, creditCardVerify);
                break;
                case 2:
            // usuario estudante
                Student student = new Student(username, cpf, password, age, gender, email, creditCardName, creditCardNum, creditCardVerify, true);
                break;
                case 3:
            // usuario critico
                String origin = sc.nextLine();
                Critical critical = new Critical(username, cpf, password, age, gender, email, creditCardName, creditCardNum, creditCardVerify, origin);
                break;    
        }

        menuCompras.menuOptions();
        decision = sc.nextInt();

        switch(decision) {
            case 1:
            // decidiu comprar ingressos
                menuSalas.amostraDeFilmes();
                menuSalas.movieChoice();
                decision = sc.nextInt();
                if(decision == 0){
                    main(args);
                } else {
                    menuSalas.movieSelection(decision);
                    menuSalas.ticketsQuantity();
                    int numOfPeople = sc.nextInt();
                    movie.choosenMovie(decision);

                    System.out.println("Total: R$ " + (movie.getPrice() * numOfPeople));
                    
                    menuCompras.setTotal(menuCompras.getTotal() + (movie.getPrice() * numOfPeople));
                    //screen movie time
                    int avaliableChairs = mt.showChairs(movie.movieName(decision));
                    if(avaliableChairs / numOfPeople > 1){
                        boolean avaliable = mt.showChairsOptions(numOfPeople);
                        if(avaliable) {
                            System.out.println("Coluna: ");
                            int column = sc.nextInt();
                            System.out.println("Linha: ");
                            int line = sc.nextInt();
                            boolean[][] isOcupied = mt.getIsOcupied();
                            boolean done = false;
                            while(done) {
                                if(!isOcupied[line -1][column - 1]) {
                                    isOcupied[line -1][column - 1] = true;
                                    done = false;
                                    mt.setIsOcupied(isOcupied);
                                }
                            }
                        }
                        else System.out.println("Nao disponivel para este numero de tickets");
                    } else System.out.println("Lotado");
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

        menuCompras.menuChoice(decision);

        sc.close();
    }
    
    
}
