package projCin.Contas;

public class Student extends User{
    
    private boolean isStudent;

    public Student(String user, String cpf, int password, int age, char gender, String email, String creditCardName,
    String creditCardNum, int creditCardVerify, boolean isStudent){
        super(user, cpf, password, age, gender, email, creditCardName, creditCardNum, creditCardVerify);
        this.isStudent = isStudent;
    }

    public boolean getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(boolean isStudet) {
        this.isStudent = isStudet;
    }

    @Override
    public double totalParaPagar(double total) {
        setMultiplicadorCompraDebilhetes(0.5);
        total = total * getMultiplicadorCompraDebilhetes();
        return total;
    }
    
}