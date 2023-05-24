package projCin.ContasSudo;

import java.util.Scanner;

import projCin.CircularList.MoviesNodes.*;
import projCin.DataBaseUsers.db;

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
        db dataB = new db();
        dataB.insert();
        //metodo que vai ser aplicado depois, obrigatoriamnete
    }

    @Override
    public void alterarUser() {
        db dataB  = new db();
        dataB.updateFile();     
        //metodo que vai ser aplicado depois, obrigatoriamnete
    }

}
