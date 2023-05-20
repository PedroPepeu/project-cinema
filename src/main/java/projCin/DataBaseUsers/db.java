import java.io.*; // the class that create the file java.io.file
import java.util.*;

public class db {

    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("name..");
        String name = sc.nextLine();

        System.out.println("password..");
        String pssw = sc.nextLine();

        System.out.println("email..");
        String email = sc.nextLine();

        try {
            File file = new File("Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            pw.append("{\n");
            pw.append("\t"+name+"\n"+"\t"+email+"\n"+"\t"+pssw+"\n");
            pw.append("}\n");
            pw.close();
        } catch (Exception e) {}

    }
}
