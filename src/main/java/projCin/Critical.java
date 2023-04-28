package main.java.projCin;

public class Critical extends User {

    private String origin;

    public Critical(String user, String cpf, int password, int age, char gender, String email, String creditCardName,
    String creditCardNum, int creditCardVerify, String origin, double multiplicadorCompraDebilhetes) {
        super(user, cpf, password, age, gender, email, creditCardName, creditCardNum, creditCardVerify, multiplicadorCompraDebilhetes);
        this.origin = origin;
    }
    
    public Critical() {

    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public double totalParaPagar(double total) {
        total = total * getMultiplicadorCompraDebilhetes();
        return total;
    }
    
}