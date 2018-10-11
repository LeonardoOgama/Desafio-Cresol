package br.com.cresol.desafio;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Emprestimo {

    private String destinoEmprestimo;
    private File emprestimo;

    public Emprestimo() {
    }

    public Emprestimo(String destinoEmprestimo) {
        this.destinoEmprestimo = destinoEmprestimo;
    }

    public void criarEmprestimo(String destinoEmprestimo) throws Exception {
        this.emprestimo = new File(destinoEmprestimo);
    }

    public InputStream verificarEmprestimo() throws FileNotFoundException, Exception {
        InputStream in = new FileInputStream(this.destinoEmprestimo);
        return in;
    }
    

    public void lerEmprestimo(BufferedReader buffer) throws Exception {
        String s = buffer.readLine();

        while (s != null) {
            System.out.println(s);
            s = buffer.readLine();
        }

    }


    public OutputStream editarEmprestimo() throws FileNotFoundException, Exception {
        OutputStream out = new FileOutputStream(this.destinoEmprestimo, true);
        return out;
    }
    

    public void escreverEmprestimo(BufferedWriter bufferEscrita, String conteudo) throws Exception {
        bufferEscrita.newLine();
        bufferEscrita.append(conteudo);
    }


    public int getNumLinhas() throws Exception {
        InputStream is = new BufferedInputStream(this.verificarEmprestimo());
        
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }

}
