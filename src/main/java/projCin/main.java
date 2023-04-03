package projCin;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Pedir Usuario
        String user = sc.nextLine();
        int cpf = sc.nextInt();
        String password = sc.nextLine();
        int age = sc.nextInt();
        char gender = sc.nextLine().charAt(0);
        String email = sc.nextLine();
        String creditCardName = sc.nextLine();
        String creditCardNum = sc.nextLine();
        int creditCardVerify = sc.nextInt();
        User usuario = new User(user, cpf, password, age, gender, email, creditCardName, creditCardNum, creditCardVerify);

        // dar bem vindo ao usuario

        Room room = new Room();
        room.sessions();

        // opcao de escolha usuario

        int choose = sc.nextInt();
        // usar choose para escolher a sessao
        int howManyTickets = sc.nextInt();
        // adicionar os valores para cada ticket comprado, o primeiro ticket usar as infos do usuario
        room.movietime.

        






        sc.close();
    }
    
}
