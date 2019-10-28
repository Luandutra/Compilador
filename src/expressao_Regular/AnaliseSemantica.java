
package expressao_Regular;

import java.util.ArrayList;
import tolkens.TolkensGramatica;


public class AnaliseSemantica {
    
    public static void semantico(ArrayList<TolkensGramatica> TolkensPalavras,ArrayList<String> listaVariaveis ){
        
        if (listaVariaveis.size()> 0){
            
            for (int i = 0; i < listaVariaveis.size(); i++ ){
                System.out.println("-------Variaveis declaradas--------");
                System.out.println(listaVariaveis);
            }
        }
     
        
        
   }
    
}
