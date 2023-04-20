package projCin;

public class Critical extends User {

    private String origin;

    public Critical(String user, int[] cpf, int password, int age, char gender, String email, String creditCardName,
    int[] creditCardNum, int creditCardVerify, String origin) {
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

    //falta implementar algumas coisinhas

    
}