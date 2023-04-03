package projCin;

public class User {
    
    private String user;
    private int cpf;
    private String password;
    private int age;
    private char gender;
    private String email;
    private String creditCardName;
    private String creditCardNum;
    private int creditCardVerify;

    public User() {
        
    }
    
    public User(String user, int cpf, String password, int age, char gender, String email, String creditCardName,
                String creditCardNum, int creditCardVerify) {   //fazendo uma sobrecarga de construtures para ter uma com os parametros e outra sem nenhum parametro
        this.user = user;
        this.cpf = cpf;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.creditCardName = creditCardName;
        this.creditCardNum = creditCardNum;
        this.creditCardVerify = creditCardVerify;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public int getCreditCardVerify() {
        return creditCardVerify;
    }

    public void setCreditCardVerify(int creditCardVerify) {
        this.creditCardVerify = creditCardVerify;
    }

    public void payment(){

    }

}