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
        ArrayList<String> arquivoSint = new ArrayList<>();
        Queue<String> filTolkens = new LinkedList<String>();
        
        filTolkens = expressao_Regular.Comparacao.procedimento(arquivo, argu, filaTolkens);
        arquivo= leitura.Leitura_Arquivo.leitura(endereco);
        arquivoSint = leitura.Leitura_Arquivo.contSint(endArqSint);   
        System.out.println(" \n Apresentacao de Tolkens, Lexema, Linha e Coluna \n " );
        expressao_Regular.Comparacao.procedimento(arquivo, argu);
        analiseSintatica.Sintatico.processoSintatico(arquivoSint, filTolkens);
           
    }catch (IOException e){
        System.out.println(" Erro " + e);

    }
    
    }

    
    
}  