
package execucao;


import java.io.IOException;
import java.util.ArrayList;
import java.net.URL;




public class teste_03 {
    
    
     public static String arquivoAbrir;
     public static boolean argu = false ;
     public static String endereco;
     
     
    public URL getFile(){
        return getClass().getResource(arquivoAbrir);
    } 
     
    
    public static void main(String[] args) {
        
    ArrayList<String> arg  = new ArrayList<>();
    
    
       if (args.length > 0){
        
        for(int i = 0 ; i < args.length;i++){
            arg.add(args[i]);
            
        }
       
     
            
        if (arg.contains("-lt")) {
                argu = true ;       
        }   else {
                argu = false;
            } 
        
    }else{
        argu = false;
        System.out.println(" Construido com Sucesso ");
    }
       
    arquivoAbrir = arg.get(0);
    
    teste_03 f = new teste_03();
    endereco = f.getFile().toString();
    
    char[] localArquivo = endereco.toCharArray();
    endereco = "";
    for (int i = 5; i < localArquivo.length;i++){
        if (localArquivo[i] == '\\'){
            endereco += "/";
        }else {
            endereco += localArquivo[i];
        }
    }
        
   
          
    try{
       System.out.println("\n Endereco do Arquivo \n" + endereco);

        ArrayList<String> arquivo = new ArrayList<>();
       
        arquivo= leitura.Leitura_Arquivo.leitura(endereco);
           
        System.out.println(" \n Apresentacao de Tolkens, Lexema, Linha e Coluna \n " );
        expressao_Regular.Comparacao.procedimento(arquivo, argu);
      
           
    }catch (IOException e){
        System.out.println(" Erro " + e);

    }
    
    }

    
    
}   

