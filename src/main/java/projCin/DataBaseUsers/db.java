package projCin.DataBaseUsers;

import java.io.*; // the class that create the file java.io.file
import java.util.*;

public class db {

    public void insert(String user, String cpf, int password, int age, char gender, String email, String creditCardName,
    String creditCardNum, int creditCardVerify) {

        try {
            File file = new File("./src/main/java/projCin/DataBaseUsers/Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            String wrt = String.format("%s, %s, %s, %s, %s, %d, %s, %s, %d,\n", cpf, user, email, password, gender, age, creditCardName, creditCardNum, creditCardVerify);
            pw.append(wrt);
            pw.close();
        } catch (Exception e) {}

    }

}
