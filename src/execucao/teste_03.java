package execucao;



import java.io.IOException;
import java.util.ArrayList;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;




public class teste_03 {
    
    
     public static String arquivoAbrir;
     public static boolean argu = false ;
     public static String endereco;
     
    public URL getFile(){
        return getClass().getResource(arquivoAbrir);
    } 
     
    
    public static void main(String[] args) {
        
    ArrayList<String> arg  = new ArrayList<>();
    String endArqSint = "C:\\Users\\luand\\OneDrive\\Documents\\compilador\\AnalisadorSintatico\\sintatico.txt";

    
       if (args.length > 0){
        
        for(int i = 0 ; i < args.length;i++){
            arg.add(args[i]);
            
        }
           
        if (arg.contains("-lt")| arg.contains("-ls")| arg.contains("-tudo")) {
                argu = true ;       
        }   else {
                argu = false;
            } 
        
    }else{
        argu = false;
        System.out.println(" Construido com Sucesso ");
    }
       
    arquivoAbrir = arg.get(0);
    
    
          
    try{
      
       
        ArrayList<String> arquivo = new ArrayList<>();
        ArrayList<String> arquivoSint = new ArrayList<>();
        Queue<String> filTolkens = new LinkedList<String>();
        
        
        arquivo= leitura.Leitura_Arquivo.leitura(arquivoAbrir);
        arquivoSint = leitura.Leitura_Arquivo.contSint(endArqSint);   
   
        expressao_Regular.ComparacaoAnaliseLexica.procedimento(arquivo, argu, arquivoSint, arg);
        analiseSintatica.Sintatico.processoSintatico(arquivoSint, filTolkens);
        
      
    }catch (IOException e){
        System.out.println(" Erro " + e);

    }
    
    }

    
    
}  