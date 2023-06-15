package projCin.CircularList.MoviesNodesTestando;

import projCin.PadraoDeProjeto.Observer;

import java.util.Scanner;

public class MovieCLLTeste implements Observer {
    private MovieNodeTeste primeiro;
    private MovieNodeTeste ultimo;
    private int controleDasAtualizacoes = 0;
    private int maximoParaAdicionar;
    private String vetDeAtualizacoes[] = new String[100]; // maximo de notificações == 100

    public MovieNodeTeste getPrimeiro() {
        return primeiro;
    }

    public MovieNodeTeste getUltimo() {
        return ultimo;
    }

    public int getControleDasAtualizacoes() {
        return controleDasAtualizacoes;
    }

    @Override
    public void update(MovieObjTeste filme, String acao) {

        for (int i = 0; i < vetDeAtualizacoes.length; i++) {

            vetDeAtualizacoes[controleDasAtualizacoes] = " O filme " + filme.getName() + " foi " + acao + "\n";

            if (vetDeAtualizacoes[i] == null) {
                vetDeAtualizacoes[i] = "";
            }
        }

    }

    public void mostrarUpdatesParaUser() {
        for (int i = 0; i < vetDeAtualizacoes.length; i++) {
            if (vetDeAtualizacoes[i] != null) {
                System.out.print(" " + vetDeAtualizacoes[i]);
            } else {
                System.out.print(vetDeAtualizacoes[i]);
            }
        }

        controleDasAtualizacoes = 0;

        for (int i = 0; i < vetDeAtualizacoes.length; i++) {
            vetDeAtualizacoes[i] = null; // resetando as atualizações
        }
    }

    public boolean isEmpty() {
        return this.primeiro == null && this.ultimo == null;
    }

    public void inserir(MovieObjTeste movie) {
        MovieNodeTeste node, aux, anterior;
        if (isEmpty()) {
            if (maximoParaAdicionar == 7) {
                System.out.println("Limite de filmes atingido!");
                return;
            }
            node = new MovieNodeTeste(movie);
            this.primeiro = node;
            this.ultimo = node;

            this.primeiro.setAnt(ultimo);
            this.ultimo.setProx(primeiro);

            update(movie, "adicionado");
            controleDasAtualizacoes++;
            maximoParaAdicionar++;

        } else {
            aux = this.primeiro;

            do {
                if (movie.compareTo(aux.getInfo()) == 0) {
                    System.out.println("Filme repetido!");
                    return;
                }
                aux = aux.getProx();
            } while (aux != this.primeiro);

            if (movie.compareTo(this.primeiro.getInfo()) < 0) {
                if (maximoParaAdicionar == 7) {
                    System.out.println("Limite de filmes atingido!");
                    return;
                }
                node = new MovieNodeTeste(movie);

                node.setProx(this.primeiro);
                node.setAnt(this.ultimo);

                this.primeiro.setAnt(node);
                this.ultimo.setProx(node);
                this.primeiro = node;

                update(movie, "adicionado");
                controleDasAtualizacoes++;
                maximoParaAdicionar++;

            } else if (movie.compareTo(this.ultimo.getInfo()) > 0) {
                if (maximoParaAdicionar == 7) {
                    System.out.println("Limite de filmes atingido!");
                    return;
                }
                node = new MovieNodeTeste(movie);

                node.setProx(this.primeiro);
                node.setAnt(this.ultimo);

                this.ultimo.setProx(node);
                this.primeiro.setAnt(node);
                this.ultimo = node;

                update(movie, "adicionado");
                controleDasAtualizacoes++;
                maximoParaAdicionar++;

            } else {
                do {
                    if (aux.getInfo().compareTo(movie) > 0) {
                        if (maximoParaAdicionar == 7) {
                            System.out.println("Limite de filmes atingido!");
                            return;
                        }
                        node = new MovieNodeTeste(movie);

                        anterior = aux.getAnt();
                        anterior.setProx(node);
                        node.setAnt(anterior);
                        node.setProx(aux);
                        aux.setAnt(node);

                        update(movie, "adicionado");
                        controleDasAtualizacoes++;
                        maximoParaAdicionar++;

                        return;
                    } else {
                        aux = aux.getProx();
                    }
                } while (aux != this.primeiro);
            }

        }

    }

    public void remover(MovieObjTeste movie) {
        if (isEmpty()) {
            System.out.println("SEM FILMES PARA REMOVER");
        } else {
            if (busca(movie) != null) {

                MovieNodeTeste nodeRemove = busca(movie);

                if (this.primeiro.equals(this.ultimo)) {

                    this.primeiro = null;
                    this.ultimo = null;

                    update(movie, "removido");
                    controleDasAtualizacoes++;
                    maximoParaAdicionar--;

                } else if (this.primeiro.getInfo() == nodeRemove.getInfo()) {

                    this.primeiro = this.primeiro.getProx();
                    this.ultimo.setProx(this.primeiro);
                    this.primeiro.setAnt(this.ultimo);

                    update(movie, "removido");
                    controleDasAtualizacoes++;
                    maximoParaAdicionar--;

                } else if (this.ultimo.getInfo() == nodeRemove.getInfo()) {

                    this.ultimo = this.ultimo.getAnt();
                    this.primeiro.setAnt(this.ultimo);
                    this.ultimo.setProx(this.primeiro);

                    update(movie, "removido");
                    controleDasAtualizacoes++;
                    maximoParaAdicionar--;

                } else {

                    MovieNodeTeste anterior = nodeRemove.getAnt();
                    MovieNodeTeste prox = nodeRemove.getProx();

                    anterior.setProx(prox);
                    prox.setAnt(anterior);

                    update(movie, "removido");
                    controleDasAtualizacoes++;
                    maximoParaAdicionar--;

                }

            } else {
                System.out.println("Filme não encontrado!");
            }
        }
    }

    public MovieNodeTeste busca(MovieObjTeste movie) {
        MovieNodeTeste node = new MovieNodeTeste(movie);
        MovieNodeTeste aux;

        aux = this.primeiro;

        do {
            if (aux.getInfo().compareTo(node.getInfo()) == 0) {
                return aux;
            }
            aux = aux.getProx();
        } while (aux != this.primeiro);

        return null;
    }

    public void exibir() {
        MovieNodeTeste aux;

        if (isEmpty()) {
            System.out.println("SEM FILMES NO CARTAZ");
        } else {
            aux = this.primeiro;

            do {

                System.out.println(aux.getInfo());

                aux = aux.getProx();
            } while (aux != this.primeiro);
        }
    }

    public void editar(MovieObjTeste movie) {
        Scanner input = new Scanner(System.in);

        String name;
        int duration;
        String summary;
        if (isEmpty()) {
            System.out.println("SEM FILMES PARA EDITAR");
        } else {
            if (busca(movie) != null) {
                MovieNodeTeste nodeEdit = busca(movie);

                System.out.println("Digite o novo nome do filme: ");
                name = input.next();
                System.out.println("Digite a nova duracao do filme: ");
                duration = input.nextInt();
                System.out.println("Digite o novo resumo do filme: ");
                summary = input.next();

                update(movie, " editado! veja as alterações no cartaz! ");
                controleDasAtualizacoes++;

                nodeEdit.getInfo().setName(name);
                nodeEdit.getInfo().setDuration(duration);
                nodeEdit.getInfo().setSummary(summary);
            } else {
                System.out.println("Filme não encontrado!");
            }
        }
    }
}
