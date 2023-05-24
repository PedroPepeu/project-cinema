package projCin.ContasSudo;

public class saladonha {
    
    public static void main(String[] args) {
        ADM adm = new ADM("00000844503", 30000);
        Funcionario funcionario = new Funcionario(3000);

        // adm.adicionarUser();

        adm.excluirUser();
    }
}
