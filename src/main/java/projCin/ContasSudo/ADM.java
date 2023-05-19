package projCin.ContasSudo;

public class ADM extends Base implements Interface { //na minha visão, ele iria herdar a classe base, já que o prof pediu que a classe ADM tenha os metodos da classe base
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
    public void incluirFilme() {
    }

    @Override
    public void excluirFilme() {
    }

    @Override
    public void alterarFilme() {

    }

    
}
