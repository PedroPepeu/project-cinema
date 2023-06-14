package projCin.ContasSudo;

import java.util.Scanner;

import projCin.CircularList.MoviesNodesTestando.*;


public class saladonha {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ADM adm = new ADM(null, 0);
        Funcionario func = new Funcionario(0);
        
        MovieCLLTeste listaTeste = new MovieCLLTeste();
        
        int control;

        do {
            System.out.println("Digite o que quer: ");
            control = input.nextInt();

        switch (control) {
             
            case 1: listaTeste.inserir(func.incluirFilme());
                    break;
            case 2: listaTeste.remover(adm.excluirFilme());
                    break;
            case 3: listaTeste.editar(func.alterarFilme());
                    break;
            case 4: listaTeste.mostrarUpdatesParaUser();        
                    break;
            case 5: listaTeste.exibir();
                    break;
            case 0: System.out.println("saindo...");
                    break;
            default: System.out.println("Opção invalida");
                
        }

    } while (control != 0);
   
}

}
