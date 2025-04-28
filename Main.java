//Trabalho biblioteca Henrique Gunther e Vitor Hugo Milani
//RA: 1135955 e 1136221


import java.util.List;
import java.util.Scanner;

public class Main {
    static Biblioteca biblio = new Biblioteca();
    static Scanner input = new Scanner(System.in);

    private static int inputNumerico(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.println(mensagem);
        do {
            String valorStr = input.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Erro. Favor informar um número inteiro.");
            }
        } while (!entradaValida);
        return valor;
    }

    private static void limparTela() {
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    }

    private static void adicionar() {
        Livro novoLivro = new Livro();
        System.out.println("--------- ADICIONANDO NOVO LIVRO ---------");
        System.out.print("Informe o título do livro: ");
        String titulo = input.nextLine();
        novoLivro.setTitulo(titulo);

        System.out.print("Informe o nome do autor: ");
        String autor = input.nextLine();
        novoLivro.setAutor(autor);

        System.out.print("Informe o ano de publicação: ");
        int ano = input.nextInt();
        novoLivro.setAnoPublicacao(ano);
        input.nextLine();

        System.out.print("Informe o número de páginas: ");
        int numPaginas = input.nextInt();
        novoLivro.setNumPaginas(numPaginas);
        input.nextLine();

        try {
            biblio.adicionar(novoLivro);
            System.out.println("Livro adicionado a biblioteca!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }

    private static void pesquisar() {
        System.out.print("Informe o título do livro que você deseja pesquisar: ");
        String titulo = input.nextLine().trim();
        List<Livro> livrosEncontrados = biblio.pesquisarPorTitulo(titulo);

        if (livrosEncontrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado com esse título.");
        } else {
            System.out.println("--------- LIVROS ENCONTRADOS ----------");
            for (Livro livro : livrosEncontrados) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Ano: " + livro.getAnoPublicacao());
                System.out.println("N. Páginas: " + livro.getNumPaginas());
                System.out.println("-----------------------------");
            }
        }
        System.out.println("Pressione Enter para continuar...");
        input.nextLine();
    }

    private static void remover() {
        System.out.print("Informe o título do livro que você deseja remover: ");
        String titulo = input.nextLine();
        try {
            biblio.removerPorTitulo(titulo);
            System.out.println("Livro foi pro saco!");
        } catch (Exception e) {
            System.out.println("Erro ao queimar livro: " + e.getMessage());
        }
    }

    private static void pesquisarPorAutor() {
        System.out.print("Informe o autor que você deseja pesquisar: ");
        String autor = input.nextLine().trim();
        List<Livro> livrosEncontrados = biblio.pesquisarPorAutor(autor);

        if (livrosEncontrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado. Escreve certo amigão!");
        } else {
            System.out.println("---------- LIVROS ENCONTRADOS ----------");
            for (Livro livro : livrosEncontrados) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Ano: " + livro.getAnoPublicacao());
                System.out.println("N. Páginas: " + livro.getNumPaginas());
                System.out.println("-----------------------------");
            }
        }
        System.out.println("Pressione Enter para continuar...");
        input.nextLine();
    }

    private static void listarPorAno() {
        int ano = inputNumerico("Informe o ano de publicação para listar os livros:");
        List<Livro> livrosEncontrados = biblio.pesquisarPorAno(ano);

        if (livrosEncontrados.isEmpty()) {
            System.out.println("Nenhum livro encontrado para o ano " + ano + ".");
        } else {
            System.out.println("---------- LIVROS ENCONTRADOS PARA O ANO " + ano + " ----------");
            for (Livro livro : livrosEncontrados) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Ano: " + livro.getAnoPublicacao());
                System.out.println("N. Páginas: " + livro.getNumPaginas());
                System.out.println("-----------------------------");
            }
        }
    }

    public static void main(String[] args) { 
        String menu = """
                SISTEMA DE GERENCIAMENTO DA BIBLIOTECA
                Escolha uma das opções:
                1 - Adicionar novo livro;
                2 - Pesquisar livro por título;
                3 - Pesquisar livro por autor;
                4 - Remover livro;
                5 - Listar livros por ano de publicação;
                0 - Sair;
                """;
        int opcao;
        do {
            limparTela();
            opcao = inputNumerico(menu);
            switch (opcao) {
                case 0:
                    System.out.println("Sessão encerrada.");
                    break;
                case 1:
                    adicionar();
                    break;
                case 2:
                    pesquisar();
                    break;
                case 3:
                    pesquisarPorAutor();
                    break;
                case 4:
                    remover();
                    break;
                case 5:
                    listarPorAno();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}


