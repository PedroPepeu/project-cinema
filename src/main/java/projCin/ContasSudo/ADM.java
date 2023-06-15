package projCin.ContasSudo;

import java.util.Scanner;

import projCin.CircularList.MoviesNodesTestando.MovieObjTeste;
import projCin.DataBaseUsers.db;


public class ADM extends Base implements Interface { //na minha visão, ele iria herdar a classe base, já que o prof pediu que a classe ADM tenha os metodos da classe base.
                                                    
    private String ID;
    private double salario;

    public ADM(String nome, int idade, String email, String ID, double salario) {
        super(nome, idade, email);
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

   @Override
    public MovieObjTeste incluirFilme() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do filme: ");
        String nomeFilme = input.nextLine();
        System.out.println("Digite a sinopse do filme: ");
        String sinopse = input.nextLine();
        System.out.println("Digite a duracao do filme: ");
        int duration = input.nextInt();
        System.out.println("Digite o ID do filme");
        String ID = input.next();

        MovieObjTeste filme = new MovieObjTeste(nomeFilme, sinopse, duration, ID);

        return filme; //vai retornar o filme e ele vai ser adicionado em uma lista criada na Main.

    }


    @Override
    public MovieObjTeste excluirFilme() {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome e ID do filme que vai ser removido");
        String nome = input.next();
        String ID = input.next();
        
        MovieObjTeste filme = new MovieObjTeste(nome, ID);

        return filme; //vai retornar o filme e ele vai ser removido da lista criada na Main.

    }

    @Override
    public MovieObjTeste alterarFilme() {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o nome e ID do filme que vai ser editado: ");
        String nome = input.next();
        String ID = input.next();

        MovieObjTeste filmeParaEditar = new MovieObjTeste(nome, ID);

        return filmeParaEditar; //vai retornar o filme e ele vai ser alterado da lista criada na Main
    }

    @Override
    public void adicionarUser() {
        Scanner sc = new Scanner(System.in);
        db dataB = new db();

        System.out.println("1 - Common User\n2 - Student\n3 - Critical");
        int choice = sc.nextInt();
        sc.nextLine();
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
                sc.nextLine();

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
                sc.nextLine();

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
                sc.nextLine();

                System.out.println("credit card name..");
                creditCardName = sc.nextLine();
                creditCardName.toUpperCase();

                System.out.println("credit card num..");
                creditCardNum = sc.nextLine();

                System.out.println("card number verify..");
                cardNumberVerify = sc.nextInt();
                sc.nextLine();

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
                sc.nextLine();

                System.out.println("credit card name..");
                creditCardName = sc.nextLine();

                System.out.println("credit card num..");
                creditCardNum = sc.nextLine();

                System.out.println("card number verify..");
                cardNumberVerify = sc.nextInt();

                dataB.insert(user, CPF, password, age, gender, email, creditCardName, creditCardNum, cardNumberVerify);
                break;
        }
      
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

     
    }

    public void excluirUser() {
        db DB = new db();
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the CPF of the user you want to delete:");
        String CPF = sc.nextLine();
        DB.removeUserByCPF(CPF);
   
    }
    
}
