package projCin.ContasSudo;

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
    public void incluirFilme() {
    }

    @Override
    public void excluirFilme() {
    }

    @Override
    public void alterarFilme() {

    }

    
}
