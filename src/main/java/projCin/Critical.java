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
    
    public Critical() {

    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int[] getCpf() {
        return cpf;
    }

    public void setCpf(int[] cpf) {
        this.cpf = cpf;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public int[] getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(int[] creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public int getCreditCardVerify() {
        return creditCardVerify;
    }

    public void setCreditCardVerify(int creditCardVerify) {
        this.creditCardVerify = creditCardVerify;
    }

    //falta implementar algumas coisinhas

    
}