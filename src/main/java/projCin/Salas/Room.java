package projCin.Salas;

import java.util.Scanner;

import projCin.CircularList.MoviesNodesTestando.MovieCLLTeste;
import projCin.CircularList.MoviesNodesTestando.MovieNodeTeste;
import projCin.ComidaCompras.Buy;
import projCin.ComidaCompras.Food;
import projCin.Contas.Critical;
import projCin.Contas.Student;
import projCin.Contas.User;
import projCin.Enum.EnumPromotionalCoupon;
import projCin.Exception.VendasException;

import java.time.LocalTime;

/*A classe de sala irá compor uma lista de sessões, a lista têm um tamanho fixo com
uma grade de horário, caso não exista uma sessão em algum horário, aquela sessão
será registrada como nula e não irá aparecer para o usuário;*/

//Para comprar os filmes    
public class Room {

    private MovieTime[] movietime;// Chairs at room
    // private Room [][] catalog;
    private Movie[] movie;
    private boolean disponibilidadeDoFilme;
    private int controleNaMain = 0;


    MovieTime horaDoFilme = new MovieTime();

    public Room() {
        this.movie = new Movie[7];
    }

    

    public MovieTime[] getMovietime() {
        return movietime;
    }

    public int getControleNaMain() {
        return controleNaMain;
    }

    public void setControleNaMain(int controleNaMain) {
        this.controleNaMain = controleNaMain;
    }

    public void setMovietime(MovieTime[] movietime) {
        this.movietime = movietime;
    }

    public Movie[] getMovie() {
        return movie;
    }

    public void setMovie(Movie[] movie) {
        this.movie = movie;
    }

    public MovieTime getHoraDoFilme() {
        return horaDoFilme;
    }

    public void setHoraDoFilme(MovieTime horaDoFilme) {
        this.horaDoFilme = horaDoFilme;
    }

    public boolean isDisponibilidadeDoFilme() {
        return disponibilidadeDoFilme;
    }

    public void setDisponibilidadeDoFilme(boolean disponibilidadeDoFilme) {
        this.disponibilidadeDoFilme = disponibilidadeDoFilme;
    }

    public void sessions(MovieCLLTeste filmes, Food menuComida, Movie moviee) {
        controleNaMain = 0;
        Scanner s = new Scanner(System.in);
        Buy buy = new Buy();
        Movie selectMovie = new Movie();

        if (filmes.isEmpty()) {
            System.out.println("SEM FILMES IMPLEMENTADOS");
            controleNaMain = 1;
            return;
        }

        int i = 0;
        int incrementoTempMin = 0;
        int incrementoTempMax = 0;
        MovieNodeTeste aux;
        aux = filmes.getPrimeiro();

        do {

            movie[i] = new Movie(8, 10, aux.getInfo().getName(), 20);

            movie[i].setTempMin(movie[i].getTempMin() + incrementoTempMin);

            movie[i].setTempMax(movie[i].getTempMax() + incrementoTempMax);

            aux = aux.getProx();
            i++;
            incrementoTempMin += 2;
            incrementoTempMax += 2;
        } while (aux != filmes.getPrimeiro());

        while (i != 7) {
            movie[i] = null;
            i++;
        }

        System.out.println("Catalogo do dia:\n");
        i = 0;
        aux = filmes.getPrimeiro();

        do {
            System.out.println(movie[i].toString(aux.getInfo()));
            aux = aux.getProx();
            i++;

        } while (aux != filmes.getPrimeiro());

        while (i != 7) {
            System.out.println("SEM FILME NO MOMENTO");
            i++;
        }
        System.out.println(
                "\nQual o numero do filme deseja comprar o ingresso(de 1 a 7) Digite 0 para voltar"); //************************* */
        int chose = s.nextInt();
         if (chose == 0 || chose < 0 || chose > 7) {
                controleNaMain = 1;
                return; //***************************** */
         }
    

        LocalTime horaAtual = LocalTime.now();
        LocalTime horarioDoFilmeMin = LocalTime.of(movie[chose - 1].getTempMin(), 00);
        LocalTime horarioDoFilmeMax = LocalTime.of(movie[chose - 1].getTempMax(), 00);

        try {
            if (horaAtual.isBefore(horarioDoFilmeMin) && horaAtual.isAfter(horarioDoFilmeMax)) { //MUDAR PARA OU DEPOIS
                throw new VendasException(horarioDoFilmeMin, horarioDoFilmeMax);
            }

            try {
               
                    // Se o filme não estiver disponivel, settar o boolean para false
                    setDisponibilidadeDoFilme(true);
                    if (disponibilidadeDoFilme == false) {
                        throw new VendasException(movie[chose - 1]);
                    }

                    System.out.println("Filme: " + movie[chose - 1].getName());

                    System.out.println("Quantidade de ingressos: ");

                    int quant = s.nextInt();
                    descontos(menuComida, moviee, quant);

                    selectMovie.details(chose, quant, filmes, menuComida);

            } catch (VendasException e) {
                System.out.println(e.getErroTres()); // erro de se o filme não estiver disponivel
            }

        } catch (VendasException e) {
            System.out.println(e.getErroUm()); // erro de se o horario não estiver disponivel
        }
    }
    

    public void descontos(Food menuCompras, Movie movie, int quant) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Possui cupom promocional?\nnao (0)\nsim (1)");
        int cup = sc.nextInt();


        int cupomRaro = 12345;
        int cupomEpico = 1234567;
        int cupomLendario = 123456789;

        double cupEfect = 1;
        int cupcup = 1;

        while (cup == 1 && cupcup != 0) {
            System.out.println("Digite o codigo do cupom ou 0(zero) para cancelar cupom ");
            cupcup = sc.nextInt();

            if (cupcup == cupomRaro) {
                cupEfect = EnumPromotionalCoupon.CUPOM_UM.getDesconto();
                System.out.println("Cupom raro aprovado!");
                break;

            } else if (cupcup == cupomEpico) {
                cupEfect = EnumPromotionalCoupon.CUPOM_DOIS.getDesconto();
                System.out.println("Cupom epico aprovado!");
                break;

            } else if (cupcup == cupomLendario) {
                cupEfect = EnumPromotionalCoupon.CUPOM_TRES.getDesconto();
                System.out.println("Cupom lendario aprovado!");
                break;

            } else if (cupcup == 0) {
                cupEfect = 1;
            } else {
                System.out.println("Cupom inexistente");

            }
        }

        System.out.println("Tipo de ingresso: \n1- Inteira\n2- Estudante\n3- Critico");
        int decision1;
        double total;

        do {
            decision1 = sc.nextInt();
            switch (decision1) {
                case 1:
                    // usuario normal
                    User user = new User();
                    total = (cupEfect) * (menuCompras.getTotal() + (movie.getPrice() * quant));

                    menuCompras.setTotal(user.totalParaPagar(total));

                    System.out.println("Total: R$ " + (menuCompras.getTotal()));
                    break;
                case 2:
                    // usuario estudante
                    Student student = new Student();

                    total = (cupEfect) * (menuCompras.getTotal() + (movie.getPrice() * quant));

                    menuCompras.setTotal(student.totalParaPagar(total));

                    System.out.println("Total: R$ " + (menuCompras.getTotal()));
                    break;
                case 3:
                    // usuario critico

                    System.out.println("Digite em qual orgão você pertence: ");
                    String origin = sc.next();
                    Critical critical = new Critical();

                    total = (cupEfect) * (menuCompras.getTotal() + (movie.getPrice() * quant));
                    menuCompras.setTotal(critical.totalParaPagar(total));

                    System.out.println("Total: R$ " + (menuCompras.getTotal()));
                    break;
                default:
                    System.out.println("Opção invalida, tente novamente!");
            }
        } while (decision1 < 1 || decision1 > 3);
    }

    public void amostraDeFilmes(MovieCLLTeste filmes) {

        if (filmes.isEmpty()) {
            System.out.println("SEM FILMES IMPLEMENTADOS");
            return;
        }

        int i = 0;
        int incrementoTempMin = 0;
        int incrementoTempMax = 0;
        MovieNodeTeste aux;
        aux = filmes.getPrimeiro();

        do {

            movie[i] = new Movie(8, 10, aux.getInfo().getName(), 20);

            movie[i].setTempMin(movie[i].getTempMin() + incrementoTempMin);

            movie[i].setTempMax(movie[i].getTempMax() + incrementoTempMax);

            aux = aux.getProx();
            i++;
            incrementoTempMin += 2;
            incrementoTempMax += 2;
        } while (aux != filmes.getPrimeiro());

        while (i != 7) {
            movie[i] = null;
            i++;
        }

        System.out.println("Catalogo do dia:\n");
        i = 0;
        aux = filmes.getPrimeiro();

        do {
            System.out.println(movie[i].toString(aux.getInfo()));
            aux = aux.getProx();
            i++;

        } while (aux != filmes.getPrimeiro());

        while (i != 7) {
            System.out.println("SEM FILME NO MOMENTO");
            i++;
        }

    }

    public void movieChoice() {
        System.out.println(
                "\nQual o numero do filme deseja comprar o ingresso(de 1 a 7) \n(Para voltar ao menu digite: 0)");
    }

    public void movieSelection(int choice) {
        System.out.println("Filme: " + movie[choice - 1].getName());
    }

    public void ticketsQuantity() {
        System.out.println("Quantidade de ingressos: ");
    }
}