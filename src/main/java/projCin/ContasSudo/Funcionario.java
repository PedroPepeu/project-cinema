package projCin.ContasSudo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import projCin.CircularList.MoviesNodes.*;
import projCin.Contas.User;

public class Funcionario extends Base implements Interface { //na minha visão, ele iria herdar a classe base, já que o prof pediu que a classe funcionario tenha os metodos da classe base
    private double salario;

    public Funcionario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public MovieObj incluirFilme() {
        Scanner input = new Scanner(System.in);

        String nomeFilme = input.nextLine();
        String sinopse = input.nextLine();
        int duration = input.nextInt();

        MovieObj filme = new MovieObj(nomeFilme, sinopse, duration);
        input.close();
        return filme; //vai retornar o filme e ele vai ser adicionado em uma lista criada na Main.

    }

    @Override
    public MovieObj excluirFilme() {
        Scanner input = new Scanner(System.in);

        String nomeFilme = input.nextLine();
        String sinopse = input.nextLine();
        int duration = input.nextInt();

        MovieObj filme = new MovieObj(nomeFilme, sinopse, duration);
        input.close();

        return filme; //vai retornar o filme e ele vai ser removido da lista criada na Main.

    }

    @Override
    public MovieObj alterarFilme() {

        return null; // alterar o filme por completo, coisas do filme ou os dois?
    }

    @Override
    public void adicionarUser() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("name..");
        String name = sc.nextLine();

        System.out.println("cpf..");
        String cpf = sc.nextLine();

        System.out.println("Password..");
        int pssw = sc.nextInt();
        
        System.out.println("age..");
        int age = sc.nextInt();

        System.out.println("gender..");
        char gender = sc.next().charAt(0);

        System.out.println("email..");
        String email = sc.nextLine();

        System.out.println("Credit card name..");
        String crdtCrdName = sc.nextLine();

        System.out.println("Credit card num..");
        String crdtCrdNum = sc.nextLine();

        System.out.println("Credit card Verify..");
        int crdtCrdVerify = sc.nextInt();

        sc.close();

        User person = new User(name, cpf, pssw, age, gender, email, crdtCrdName, crdtCrdNum, crdtCrdVerify);

        try {
            File file = new File("Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            pw.append("{\n");
            pw.append("\t" + person.getUser() + "\n" + "\t" + person.getCpf() + "\n"
            +"\t"+person.getPassword()+"\n" + "\t" + person.getAge() + "\n" +"\t" + person.getGender()
            + "\n" +"\t" + person.getEmail() + "\n" +"\t" + person.getCreditCardName() 
            + "\n" +"\t" + person.getCreditCardNum() + "\n" +"\t" + person.getCreditCardVerify());
            pw.append("}\n");
            pw.close();
        } catch (Exception e) {}
    }

    @Override
    public void alterarUser(User userAserAlterado) {
        //metodo que vai ser aplicado depois, obrigatoriamnete
    }

}
