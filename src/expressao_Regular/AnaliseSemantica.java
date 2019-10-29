
package expressao_Regular;

import java.util.ArrayList;
import tolkens.TolkensGramatica;


public class AnaliseSemantica {
    
    public static void semantico(ArrayList<String> listaVariaveis, ArrayList<String> listaDivisor, ArrayList<String>  listaTolkensIdVar, ArrayList<String> listaLexema){
        ArrayList<String> novaListVar = new ArrayList<>();
        ArrayList<String> novaListVar2 = new ArrayList<>();
      
         boolean var = false;
        if (listaVariaveis.size()> 0){
            var = true;
            for (int i = 0; i < listaVariaveis.size(); i++ ){
                
                if(listaVariaveis.get(i).contains("TK_INTEIRO")){
                    novaListVar.add(listaVariaveis.get(i+1));
                    
                }   
            }
            
            for (int i = 0; i< novaListVar.size(); i++){
                
               if (novaListVar2.contains(novaListVar.get(i))){
                        System.out.println(" ERRO  A  variavel: "+ novaListVar.get(i)+ " ja foi declarada ");
                        return;
                    }else{
                        novaListVar2.add(novaListVar.get(i)); 
                    }
            }    
        
        } 
        
        System.out.println("-------Variaveis declaradas--------");
        System.out.println(novaListVar);
        
        for (int i = 0; i < listaDivisor.size(); i++){
          
            if(listaDivisor.get(i).equals("/")){
                
                if(listaDivisor.get(i+1).equals("0")){
                    System.out.println(" Erro divisivel por zero ");
                    return;
                }else if(listaTolkensIdVar.size()>0){
                        for(int l = 0; l < listaTolkensIdVar.size();l++){
                              //  System.out.println("aquele teste basico");
                                if(listaTolkensIdVar.get(l).contains("TK_Var") && listaTolkensIdVar.get(l+1).contains("TK_Atribuir")){
                                    if(listaLexema.get(l+2).equals("0")){
                                        System.out.println(" Erro divisivel por zero "); 
                                        return;
                                    }
                                }
                        }
                    }
                
            }
        }
        
   }
    
}
