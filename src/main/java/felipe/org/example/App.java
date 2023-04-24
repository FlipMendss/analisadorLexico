package felipe.org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App
{
    public static void main(String[] args) {

        String nomeArquivo = "teste.pas";

        substTab(nomeArquivo);

        Lexico lexico = new Lexico(nomeArquivo);

        Token token;
        int linha = 1;
        int coluna = 1;

        do {
            token = lexico.getToken(linha, coluna);
            System.out.println(token);
            coluna = token.getColuna()+token.gettokenSize();
            linha = token.getLinha();
        } while (token.getClasse() != Classe.cEOF);

    }

    public static void substTab(String nomeArquivo) {
        Path caminhoArquivo = Paths.get(nomeArquivo);
        int numEspcTab = 4;
        StringBuilder unir = new StringBuilder();
        String espacos;

        for (int cont = 0; cont < numEspcTab; cont++) {
            unir.append(" ");
        }
        espacos = unir.toString();

        String conteudo;
        try {
            conteudo = new String(Files.readAllBytes(caminhoArquivo), StandardCharsets.UTF_8);
            conteudo = conteudo.replace("\t", espacos);
            Files.write(caminhoArquivo, conteudo.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

