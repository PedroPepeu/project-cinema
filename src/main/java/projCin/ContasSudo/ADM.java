package projCin.ContasSudo;

import java.io.*;
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

    public void adicionarUser() {
        db dataB = new db();
        Scanner sc = new Scanner(System.in);

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

        dataB.insert(username, cpf, password, age,
        gender, email, creditCardName, creditCardNum, creditCardVerify);

        sc.close();
        //metodo que vai ser aplicado depois, obrigatoriamnete
    }

    @Override
    public void alterarUser() {

        int numOfValues = 8;

        Scanner sc = new Scanner(System.in);

        System.out.printf("Write the ID that you whant to change..\n");
        int idToChange = sc.nextInt();

        String changingArr[] = {"Name..", "email..", "password.."};

        int willChange[] = new int[numOfValues];
        String willUpdate[] = new String[numOfValues];

        System.out.printf("Select the column that you want to update:\n(0 to NO, 1 to YES)\n");
        for(int i = 0; i < numOfValues; i++) {
            System.out.printf("%s", changingArr[i]);
            int option = sc.nextInt();
            willChange[i] = option;
        }

        Scanner sc1 = new Scanner(System.in);

        System.out.printf("\n\n\nAdd new values to the columns\n");
        for(int i = 0; i < numOfValues; i++) {
            System.out.printf("%s\n", changingArr[i]);
            if(willChange[i] == 1) {
                String strToUpdate = sc1.nextLine();
                willUpdate[i] = strToUpdate;
            } else {
                System.out.printf("Not selected as changable\n");
            }
        }

        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/main/java/projCin/DataBaseUsers/Database.txt"));
            String s = "";
            while((s = br.readLine()) != null) {
                String data[] = new String[numOfValues + 1];
                data = s.split(",");
                if(idToChange == Integer.parseInt(data[0])) {
                    String row = data[0] + ",";
                    for(int i = 0; i < numOfValues; i++) {
                        if(willChange[i] == 1) {
                            row = row + willUpdate[i]+",";
                        } else {
                            row = row + data[i + 1]+",";
                        }
                    }
                    sb.append(row);
                    sb.append("\n");
                } else {
                    sb.append(s);
                    sb.append("\n");
                }
            }
            // System.out.printf("%s\n", sb.toString());

            File file = new File("./src/main/java/projCin/DataBaseUsers/Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, false));
            pw.print(sb.toString());
            pw.close();
        
        } catch (Exception e) {}
        
        sc1.close();
        sc.close();
    }

    
}
