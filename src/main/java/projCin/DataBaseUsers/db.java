package projCin.DataBaseUsers;

import java.io.*; // the class that create the file java.io.file
import java.util.*;

public class db {

    public void insert(String user, String cpf, String password, int age, char gender, String email, String creditCardName,
    String creditCardNum, int creditCardVerify) {

        try {
            File file = new File("./src/main/java/projCin/DataBaseUsers/Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            String wrt = String.format("%s, %s, %s, %s, %s, %d, %s, %s, %d, Common user,\n", cpf, user, email, password, gender, age, creditCardName, creditCardNum, creditCardVerify);
            pw.append(wrt);
            pw.close();
            System.out.println("Inserção realizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir os dados");
        }

    }

    public void insert(String user, String cpf, String password, int age, char gender, String email, String creditCardName,
    String creditCardNum, int creditCardVerify, boolean isStudent) {

        try {
            File file = new File("./src/main/java/projCin/DataBaseUsers/Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            String wrt = String.format("%s, %s, %s, %s, %s, %d, %s, %s, %d, %b, Student user,\n", cpf, user, email, password, gender, age, creditCardName, creditCardNum, creditCardVerify, isStudent);
            pw.append(wrt);
            pw.close();
        } catch (Exception e) {}

    }

    public void insert(String user, String cpf, String password, int age, char gender, String email, String creditCardName,
    String creditCardNum, int creditCardVerify, String origin) {

        try {
            File file = new File("./src/main/java/projCin/DataBaseUsers/Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            String wrt = String.format("%s, %s, %s, %s, %s, %d, %s, %s, %d, %s, Critial user,\n", cpf, user, email, password, gender, age, creditCardName, creditCardNum, creditCardVerify, origin);
            pw.append(wrt);
            pw.close();
        } catch (Exception e) {}

    }

    public void updateFileUser() {

        int numOfValues = 8;

        Scanner sc = new Scanner(System.in);

        System.out.printf("Write the ID that you whant to change..\n");
        int idToChange = sc.nextInt();

        String changingArr[] = {"Name..", "email..", "password..", "gender..", "age..", "creditCardName..", "creditCardNum..", "creditCardVerify.."};

        int willChange[] = new int[numOfValues];
        String willUpdate[] = new String[numOfValues];

        System.out.printf("Select the column that you want to update:\n(0 to NO, 1 to YES)\n");
        for(int i = 0; i < numOfValues; i++) {
            System.out.printf("%s", changingArr[i]);
            int option = sc.nextInt();
            willChange[i] = option;
        }

        Scanner sc1 = new Scanner(System.in);

        System.out.printf("\n\n\nAdd new values to the columns\n");
        for(int i = 0; i < numOfValues; i++) {
            System.out.printf("%s\n", changingArr[i]);
            if(willChange[i] == 1) {
                String strToUpdate = sc1.nextLine();
                willUpdate[i] = strToUpdate;
            } else {
                System.out.printf("Not selected as changable\n");
            }
        }

        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/main/java/projCin/DataBaseUsers/Database.txt"));
            String s = "";
            while((s = br.readLine()) != null) {
                String data[] = new String[numOfValues + 1];
                data = s.split(",");
                if(idToChange == Integer.parseInt(data[0])) {
                    String row = data[0] + ",";
                    for(int i = 0; i < numOfValues; i++) {
                        if(willChange[i] == 1) {
                            row = row + willUpdate[i]+",";
                        } else {
                            row = row + data[i + 1]+",";
                        }
                    }
                    sb.append(row);
                    sb.append("\n");
                } else {
                    sb.append(s);
                    sb.append("\n");
                }
            }
            // System.out.printf("%s\n", sb.toString());

            File file = new File("./src/main/java/projCin/DataBaseUsers/Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, false));
            pw.print(sb.toString());
            pw.close();
        
        } catch (Exception e) {}
        
        sc1.close();
        sc.close();
    }

    public void updateFileStudent() {

        int numOfValues = 8;

        Scanner sc = new Scanner(System.in);

        System.out.printf("Write the ID that you whant to change..\n");
        int idToChange = sc.nextInt();

        String changingArr[] = {"Name..", "email..", "password..", "gender..", "age..", "creditCardName..", "creditCardNum..", "creditCardVerify..", "isStudent.."};

        int willChange[] = new int[numOfValues];
        String willUpdate[] = new String[numOfValues];

        System.out.printf("Select the column that you want to update:\n(0 to NO, 1 to YES)\n");
        for(int i = 0; i < numOfValues; i++) {
            System.out.printf("%s", changingArr[i]);
            int option = sc.nextInt();
            willChange[i] = option;
        }

        Scanner sc1 = new Scanner(System.in);

        System.out.printf("\n\n\nAdd new values to the columns\n");
        for(int i = 0; i < numOfValues; i++) {
            System.out.printf("%s\n", changingArr[i]);
            if(willChange[i] == 1) {
                String strToUpdate = sc1.nextLine();
                willUpdate[i] = strToUpdate;
            } else {
                System.out.printf("Not selected as changable\n");
            }
        }

        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/main/java/projCin/DataBaseUsers/Database.txt"));
            String s = "";
            while((s = br.readLine()) != null) {
                String data[] = new String[numOfValues + 1];
                data = s.split(",");
                if(idToChange == Integer.parseInt(data[0])) {
                    String row = data[0] + ",";
                    for(int i = 0; i < numOfValues; i++) {
                        if(willChange[i] == 1) {
                            row = row + willUpdate[i]+",";
                        } else {
                            row = row + data[i + 1]+",";
                        }
                    }
                    sb.append(row);
                    sb.append("\n");
                } else {
                    sb.append(s);
                    sb.append("\n");
                }
            }
            // System.out.printf("%s\n", sb.toString());

            File file = new File("./src/main/java/projCin/DataBaseUsers/Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, false));
            pw.print(sb.toString());
            pw.close();
        
        } catch (Exception e) {}
        
        sc1.close();
        sc.close();
    }


    public void updateFileCritical() {

        int numOfValues = 8;

        Scanner sc = new Scanner(System.in);

        System.out.printf("Write the ID that you whant to change..\n");
        String idToChange = sc.nextLine();

        String changingArr[] = {"Name..", "email..", "password..", "gender..", "age..", "creditCardName..", "creditCardNum..", "creditCardVerify..", "origin.."};

        int willChange[] = new int[numOfValues];
        String willUpdate[] = new String[numOfValues];

        System.out.printf("Select the column that you want to update:\n(0 to NO, 1 to YES)\n");
        for(int i = 0; i < numOfValues; i++) {
            System.out.printf("%s", changingArr[i]);
            int option = sc.nextInt();
            willChange[i] = option;
        }

        Scanner sc1 = new Scanner(System.in);

        System.out.printf("\n\n\nAdd new values to the columns\n");
        for(int i = 0; i < numOfValues; i++) {
            System.out.printf("%s\n", changingArr[i]);
            if(willChange[i] == 1) {
                String strToUpdate = sc1.nextLine();
                willUpdate[i] = strToUpdate;
            } else {
                System.out.printf("Not selected as changable\n");
            }
        }

        StringBuffer sb = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/main/java/projCin/DataBaseUsers/Database.txt"));
            String s = "";
            while((s = br.readLine()) != null) {
                String data[] = new String[numOfValues + 1];
                data = s.split(",");
                if(idToChange.equals(data[0])) {
                    String row = data[0] + ",";
                    for(int i = 0; i < numOfValues; i++) {
                        if(willChange[i] == 1) {
                            row = row + willUpdate[i]+",";
                        } else {
                            row = row + data[i + 1]+",";
                        }
                    }
                    sb.append(row);
                    sb.append("\n");
                } else {
                    sb.append(s);
                    sb.append("\n");
                }
            }
            // System.out.printf("%s\n", sb.toString());

            File file = new File("./src/main/java/projCin/DataBaseUsers/Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, false));
            pw.print(sb.toString());
            pw.close();

        } catch (Exception e) {}
        
        sc1.close();
        sc.close();
    }

    public void deleteUser(String CPF) {

        int numOfValues = 8;

        try {
            StringBuffer sb = new StringBuffer();
            BufferedReader br = new BufferedReader(new FileReader("./src/main/java/projCin/DataBaseUsers/Database.txt"));
            String s = "";
            while((s = br.readLine()) != null) {
                String data[] = new String[numOfValues + 1];
                data = s.split(",");
                if(CPF.equals(data[0])) {
                    sb.append("");
                }
            }

            File file = new File("./src/main/java/projCin/DataBaseUsers/Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, false));
            pw.print(sb.toString());
            pw.close();
        } catch (Exception e) {}
        
    }
}
