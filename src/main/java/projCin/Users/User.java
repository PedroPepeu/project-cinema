//apos decidir filme e comida, mas ainda pode cancelar um dos dois
package projCin.Users;

public class User {
    
    private String user;
    private String cpf;
    private int password;
    private int age;
    private char gender;
    private String email;
    private String creditCardName;
    private String creditCardNum;
    private int creditCardVerify;
    private double multiplicadorCompraDebilhetes;
    //Buy spend = new Buy();

    public User() {
        
    }
    
    public User(String user, String cpf, int password, int age, char gender, String email, String creditCardName,
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public double getMultiplicadorCompraDebilhetes() {
        return multiplicadorCompraDebilhetes;
    }

    public void setMultiplicadorCompraDebilhetes(double multiplicadorCompraDebilhetes) {
        this.multiplicadorCompraDebilhetes = multiplicadorCompraDebilhetes;
    }

    public double totalParaPagar(double total) {
        setMultiplicadorCompraDebilhetes(1);
        total = total * getMultiplicadorCompraDebilhetes();
        return total;
    }


}