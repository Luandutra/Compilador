
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
             
        FileReader local = new FileReader(arquivo);
        BufferedReader leituraArquivo = new BufferedReader(local);
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
                
        local.close();
        return Palavras;

    }catch (FileNotFoundException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n" + e);
        
    }
            return Palavras;
    }
    
    public static ArrayList<String> contSint (String endArqSint) throws IOException{
        
        ArrayList<String> arqSint = new ArrayList<>();
        
    try {
        FileReader localSint = new FileReader(endArqSint);
        BufferedReader leituraSint = new BufferedReader(localSint);
        String linha ="";
       try{
        while (linha != null) {
                
            linha = leituraSint.readLine(); // lê da segunda até a última linha
            arqSint.add(linha);
        }
       }catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
        e.getMessage());
       }
                
        localSint.close();
        return arqSint;

    }catch (FileNotFoundException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n" + e);
        
    }
    
    
    return arqSint;

    }


}
  
 
