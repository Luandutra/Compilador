
package expressao_Regular;

import java.util.ArrayList;
import tolkens.TolkensGramatica;


public class AnaliseSemantica {
    
    public static void semantico(ArrayList<TolkensGramatica> TolkensPalavras,ArrayList<String> listaVariaveis ){
        ArrayList<String> novaListVar = new ArrayList<>();
        
        if (listaVariaveis.size()> 0){
            
            for (int i = 0; i < listaVariaveis.size(); i++ ){
                
                if(listaVariaveis.get(i).contains("TK_INTEIRO")){
                
                novaListVar.add(listaVariaveis.get(i+1));
                }
            }
        }
        
        System.out.println("-------Variaveis declaradas--------");
        System.out.println(novaListVar);
        
   }
    
}
