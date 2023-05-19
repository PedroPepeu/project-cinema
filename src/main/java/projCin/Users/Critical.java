package projCin.Users;
public class Critical extends User {

    private String origin;

    public Critical(String user, String cpf, int password, int age, char gender, String email, String creditCardName,
    String creditCardNum, int creditCardVerify, String origin) {
        super(user, cpf, password, age, gender, email, creditCardName, creditCardNum, creditCardVerify);
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
        setMultiplicadorCompraDebilhetes(0);
        total = total * getMultiplicadorCompraDebilhetes();
        return total;
    }
    
}