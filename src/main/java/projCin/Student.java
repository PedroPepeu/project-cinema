package projCin;

public class Student extends User{
    private boolean isStudent;

    public Student(String user, String cpf, int password, int age, char gender, String email, String creditCardName,
    String creditCardNum, int creditCardVerify, boolean isIstudent){
        super(user, cpf, password, age, gender, email, creditCardName, creditCardNum, creditCardVerify);
        this.isStudent = isIstudent;
    }

    public boolean getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(boolean isStudet) {
        this.isStudent = isStudet;
    }

    //falta implementar algumas coisinhas.


}