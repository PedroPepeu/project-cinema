package projCin.ContasSudo;

import java.util.Scanner;

import projCin.CircularList.MoviesNodes.*;

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
        //metodo que vai ser aplicado depois, obrigatoriamnete
    }

    @Override
    public void alterarUser() {
        //metodo que vai ser aplicado depois, obrigatoriamnete
    }

}
