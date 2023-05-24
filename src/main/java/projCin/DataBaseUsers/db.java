package projCin.DataBaseUsers;

import java.io.*; // the class that create the file java.io.file
import java.util.*;

public class db {

    public void insert(String user, String cpf) {

        try {
            File file = new File("./src/main/java/projCin/DataBaseUsers/Database.txt");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            String wrt = String.format("%s, %s\n", cpf, user);
            pw.append(wrt);
            pw.close();
            System.out.println("Inserção realizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inserir os dados");
        }

    }

    public void testRead() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/main/java/projCin/DataBaseUsers/Database.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler o arquivo.");
        }
    }
    

    public void updateFile() {

        int numOfValues = 8;

        Scanner sc = new Scanner(System.in);

        System.out.printf("Write the ID that you whant to change..\n");
        int idToChange = sc.nextInt();

        String changingArr[] = {"Name..", "email..", "password.."};

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



    public void removeUserByCPF(String cpf) {
        String nomeArquivo = "./src/main/java/projCin/DataBaseUsers/Database.txt";
    
        // Ler os dados do arquivo para uma lista
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
    
        // Remover a linha com o CPF fornecido
        boolean cpfEncontrado = false;
        Iterator<String> iterator = linhas.iterator();
        while (iterator.hasNext()) {
            String linha = iterator.next();
            String[] dados = linha.split(",");
            if (dados.length > 0 && dados[0].trim().equals(cpf)) {
                iterator.remove();
                cpfEncontrado = true;
                break;
            }
        }
    
        if (!cpfEncontrado) {
            System.out.println("CPF não encontrado.");
            return;
        }
    
        System.out.println("Usuário removido com sucesso.");
    }

    
}
