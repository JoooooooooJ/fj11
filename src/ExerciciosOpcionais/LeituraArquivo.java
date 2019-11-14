package ExerciciosOpcionais;

import java.io.*;


public class LeituraArquivo {
	
	public static void main(String[] args) throws IOException {
        OutputStream os = new FileOutputStream("saida.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("caelum");

        bw.close();
    }
}
