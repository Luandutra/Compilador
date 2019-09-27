
package leitura;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Leitura_Arquivo {
    
    public static ArrayList<String> leitura (String arquivo) throws IOException{
       
    ArrayList<String> Palavras = new ArrayList<>();
  
    
 
    try {
        // Leitura do aquivo
        FileReader endereco = new FileReader(arquivo);
        BufferedReader leituraArquivo = new BufferedReader(endereco);
        String linha ="";
       try{
        while (linha != null) {
                
            linha = leituraArquivo.readLine(); // lê da segunda até a última linha
            Palavras.add(linha);
        }
       }catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
        e.getMessage());
       }
                
        endereco.close();
        return Palavras;

    }catch (FileNotFoundException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n" + e);
        
    }
    
    return Palavras;

    }
    

}
  
 
