package projCin.ContasSudo;

import java.util.Scanner;

import projCin.CircularList.MoviesNodes.*;
import projCin.DataBaseUsers.db;

public class ADM extends Base implements Interface { //na minha visão, ele iria herdar a classe base, já que o prof pediu que a classe ADM tenha os metodos da classe base.
                                                    //yes
    private String ID;
    private double salario;

    public ADM(String ID, double salario) {
        this.ID = ID;
        this.salario = salario;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void excluirUser() {
        db DB = new db();
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the CPF of the user you want to delete:");
        String CPF = sc.nextLine();
        DB.deleteUser(CPF);
    }

    @Override
    public MovieObj incluirFilme() {
        Scanner input = new Scanner(System.in);

        String nomeFilme = input.nextLine();
        String sinopse = input.nextLine();
        int duration = input.nextInt();
        int ID = input.nextInt();

        MovieObj filme = new MovieObj(nomeFilme, sinopse, duration, ID);
        input.close();
        return filme; //vai retornar o filme e ele vai ser adicionado em uma lista criada na Main.

    }

    @Override
    public MovieObj excluirFilme() {
        Scanner input = new Scanner(System.in);

        String nomeFilme = input.nextLine();
        String sinopse = input.nextLine();
        int duration = input.nextInt();
        int ID = input.nextInt();

        MovieObj filme = new MovieObj(nomeFilme, sinopse, duration, ID);
        input.close();

        return filme; //vai retornar o filme e ele vai ser removido da lista criada na Main.

    }

    @Override
    public MovieObj alterarFilme() {
        MovieCircularLinkedList MCLL = new MovieCircularLinkedList();
        Scanner input = new Scanner(System.in);

        System.out.println("Write the ID of the movie that you want to change");
        int code = input.nextInt();

        MovieNode movien = MCLL.search(code);

        int willChange[] = new int[3];
        String whatChange[] = {"nome..", "sinopse..", "duration.."};

        for(int i = 0; i < 3; i++) {
            System.out.printf("Select what you want to change.\n1 to YES 0 to NO\n");
            System.out.println(whatChange[i]);
            willChange[i] = input.nextInt();
        }
    
        String jumpline = input.nextLine();

        String nomeFilme = null;
        String sinopse = null;
        int duration = 0;

        for(int i = 0; i < 3; i++) {
            
            if(willChange[i] == 1) {
                if(i == 0) {
                    nomeFilme = input.nextLine();
                } else if(i == 1) {
                    sinopse = input.nextLine();
                } else if(i == 2) {
                    duration = input.nextInt();
                }
            } else {
                System.out.println("Not selected as changable");
                if(i == 0) {
                    nomeFilme = movien.getMovie().getName(); 
                } else if(i == 1) {
                    sinopse = movien.getMovie().getSummary();
                } else if(i == 2) {
                    duration = movien.getMovie().getDuration();
                }
            }
        }

        MovieObj changedMovie = new MovieObj(nomeFilme, sinopse, duration, movien.getMovie().getID());
        MCLL.delete(movien);
        MCLL.addFirst(nomeFilme, sinopse, duration, movien.getMovie().getID());


        input.close();
        
        return changedMovie; //alterar o filme por completo, coisas do filme ou os dois?
    }

    @Override
    public void adicionarUser() {
        Scanner sc = new Scanner(System.in);
        db dataB = new db();

        System.out.println("1 - Common User\n2 - Student\n3 - Critical");
        int choice = sc.nextInt();
        String jumpline = sc.nextLine();
        switch (choice) {
            case 1:

                System.out.println("CPF..");
                String CPF = sc.nextLine();

                System.out.println("user..");
                String user = sc.nextLine();

                System.out.println("email..");
                String email = sc.nextLine();

                System.out.println("password..");
                String password = sc.nextLine();

                System.out.println("gender..\n(M for male, F  for female)");
                char gender = sc.nextLine().charAt(0);

                System.out.println("age..");
                int age = sc.nextInt();
                jumpline = sc.nextLine();

                System.out.println("credit card name..");
                String creditCardName = sc.nextLine();
                creditCardName.toUpperCase();

                System.out.println("credit card num..");
                String creditCardNum = sc.nextLine();

                System.out.println("card number verify..");
                int cardNumberVerify = sc.nextInt();

                dataB.insert(user, CPF, password, age, gender, email, creditCardName, creditCardNum, cardNumberVerify);
                break;

            case 2:
                System.out.println("CPF..");
                CPF = sc.nextLine();

                System.out.println("user..");
                user = sc.nextLine();

                System.out.println("email..");
                email = sc.nextLine();

                System.out.println("password..");
                password = sc.nextLine();

                System.out.println("gender..\n(M for male, F  for female)");
                gender = sc.nextLine().charAt(0);

                System.out.println("age..");
                age = sc.nextInt();
                jumpline = sc.nextLine();

                System.out.println("credit card name..");
                creditCardName = sc.nextLine();
                creditCardName.toUpperCase();

                System.out.println("credit card num..");
                creditCardNum = sc.nextLine();

                System.out.println("card number verify..");
                cardNumberVerify = sc.nextInt();

                dataB.insert(user, CPF, password, age, gender, email, creditCardName, creditCardNum, cardNumberVerify, true);
                break;

            case 3:
                System.out.println("CPF..");
                CPF = sc.nextLine();

                System.out.println("user..");
                user = sc.nextLine();

                System.out.println("email..");
                email = sc.nextLine();

                System.out.println("password..");
                password = sc.nextLine();

                System.out.println("gender..\n(M for male, F  for female)");
                gender = sc.nextLine().charAt(0);

                System.out.println("age..");
                age = sc.nextInt();
                jumpline = sc.nextLine();

                System.out.println("credit card name..");
                creditCardName = sc.nextLine();
                creditCardName.toUpperCase();

                System.out.println("credit card num..");
                creditCardNum = sc.nextLine();

                System.out.println("card number verify..");
                cardNumberVerify = sc.nextInt();
                jumpline = sc.nextLine();

                System.out.println("Origin..");
                String origin = sc.nextLine();

                dataB.insert(user, CPF, password, age, gender, email, creditCardName, creditCardNum, cardNumberVerify, origin);
                break;

            default:
                System.out.println("Since you write something wrong, the common addition is common user");
                System.out.println("CPF..");
                CPF = sc.nextLine();

                System.out.println("user..");
                user = sc.nextLine();

                System.out.println("email..");
                email = sc.nextLine();

                System.out.println("password..");
                password = sc.nextLine();

                System.out.println("gender..\n(M for male, F  for female)");
                gender = sc.nextLine().charAt(0);

                System.out.println("age..");
                age = sc.nextInt();
                jumpline = sc.nextLine();

                System.out.println("credit card name..");
                creditCardName = sc.nextLine();

                System.out.println("credit card num..");
                creditCardNum = sc.nextLine();

                System.out.println("card number verify..");
                cardNumberVerify = sc.nextInt();

                dataB.insert(user, CPF, password, age, gender, email, creditCardName, creditCardNum, cardNumberVerify);
                break;
        }
        sc.close();
        //metodo que vai ser aplicado depois, obrigatoriamnete
    }

    @Override
    public void alterarUser() {
        Scanner sc = new Scanner(System.in);
        db dataB  = new db();
        System.out.println("1 - Common user\n2 - Student\n3 - Critical");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                dataB.updateFileUser();
                break;
        
            case 2:
                dataB.updateFileStudent();
                break;
        
            case 3:
                dataB.updateFileCritical();
                break;
        
            default:
                break;
        }
        //metodo que vai ser aplicado depois, obrigatoriamnete
        sc.close();
    }

    
}
