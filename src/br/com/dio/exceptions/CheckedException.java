package br.com.dio.exceptions;

import javax.swing.*;
import java.io.*;
import java.util.jar.JarOutputStream;

public class CheckedException {
    public static void main(String[] args) {
        String nomeDoArvquivo = "wereworld.txt";

        try {
            imprimirArquivoNoConsole(nomeDoArvquivo);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                    "Revise o nome do arquivo qu você deseja imprimir!" + e.getCause());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro inesperado! Entre em contato com o suporte!" + e.getCause());
            e.printStackTrace();
        } finally {
            System.out.println("Chegou no finally!");
        }

        System.out.println("Apesar da exception ou nao, o programa continua...");
    }

    private static void imprimirArquivoNoConsole(String nomeDoArvquivo) throws IOException {
        File file = new File(nomeDoArvquivo);
        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do{
            bw.write(line);
            bw.newLine();
            line=br.readLine();
        } while (line != null);
        bw.flush();
        br.close();
    }
}
