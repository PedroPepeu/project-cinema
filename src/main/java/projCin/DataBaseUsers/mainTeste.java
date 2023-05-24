package projCin.DataBaseUsers;

import java.util.Scanner;

public class mainTeste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o CPF e o nome do usuário que deseja adicionar: ");
        String cpf = scanner.nextLine();
        String nome = scanner.nextLine();
        int queroRemover;
        db database = new db();

        database.insert(nome, cpf);
        System.out.println("quer remover? 0 p sim");
        queroRemover = scanner.nextInt();
        if (queroRemover == 0) {
            cpf = scanner.next();
            database.removeUserByCPF(cpf);
        }



        scanner.close();
    }
}