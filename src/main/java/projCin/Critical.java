package projCin;

public class Critical extends User {

    private String user;
    private int[] cpf;
    private int password;
    private int age;
    private char gender;
    private String email;
    private String creditCardName;
    private int[] creditCardNum;
    private int creditCardVerify;
    private String origin;

    public Critical(String user, int[] cpf, int password, int age, char gender, String email, String creditCardName,
    int[] creditCardNum, int creditCardVerify, String origin) {
        super(user, cpf, password, age, gender, email, creditCardName, creditCardNum, creditCardVerify);
        this.origin = origin;
    }
}