
package execucao;


import java.util.ArrayList;




public class teste_03 {
    
    public static void main(String[] args) {
        
    ArrayList<String> arg  = new ArrayList<>();
    String endereco = "C:\\Users\\luand\\OneDrive\\Documents\\compilador\\fatorial.txt";
    boolean argu = false ;
    boolean teste;
   
   
    
    if (args.length > 0){
        
        for(int i = 0 ; i < args.length;i++){
            arg.add(args[i]);
            
        }
       
        for (int j = 0; j<args.length; j++){
            
            int m = 1;
                   

            if (arg.get(j).matches("fatorial.txt")){
                System.out.println(arg.get(j));
                if (arg.get(m).matches("-lt")) {
                            argu = true ;
                            
                    }   else {
                                System.out.println(" recebido ");
                        } 
            }
        }
 
    }else{
        argu = false;
        System.out.println(" Construido com Sucesso ");
    }
          
        
    try{
        
        ArrayList<String> arquivo = new ArrayList<>();
        
        arquivo= leitura.Leitura_Arquivo.leitura(endereco);
           
       
        expressao_Regular.Comparacao.procedimento(arquivo, argu);
       
           
    }catch (Exception e){
        System.out.println(" Erro " + e);

    }
    
    
   

    }

    
    
}   

