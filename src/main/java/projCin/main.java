package projCin;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double nota;
    
        Buy compra = new Buy();

        Movie movie = new Movie();

        compra.menuGeral();

        Review review = new Review();

        do {

            nota = input.nextDouble();

            review.atribuirNota(nota, movie);

            
        } while(true);

        
    }

    public static String options() {
        return "Digite: 1 se Normal\n" +
               "Digite: 2 se Estudante\n" +
               "Digite: 3 se Critico\n";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Buy menuCompras = new Buy();
        Room menuSalas = new Room();

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
            case 2:
            // usuario estudante
                Student student = new Student(username, cpf, password, age, gender, email, creditCardName, creditCardNum, creditCardVerify, true);
            case 3:
            // usuario critico
                String origin = sc.nextLine();
                Critical critical = new Critical(username, cpf, password, age, gender, email, creditCardName, creditCardNum, creditCardVerify, origin);
        }

        menuCompras.menuOptions();
        decision = sc.nextInt();

        switch(decision) {
            case 1:
            // decidiu comprar ingressos
                menuSalas.amostraDeFilmes();
                
            case 2:
        }

        menuCompras.menuChoice(decision);

        sc.close();
    }
    
}
