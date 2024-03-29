
package expressao_Regular;

import java.util.ArrayList;

import tolkens.TolkensSemantico;



public class AnaliseSemantica {
    
    public static void semantico(ArrayList<String> listaVariaveis, ArrayList<String> listaDivisor, ArrayList<String>  listaTolkensIdVar, ArrayList<String> arg, boolean  argu){
        ArrayList<String> novaListVar = new ArrayList<>();
        ArrayList<String> novaListVar2 = new ArrayList<>();
        ArrayList<TolkensSemantico> filaVariaveis = new ArrayList<>();
      
         boolean var = false;
        if (listaVariaveis.size()> 0){
            var = true;
            for (int i = 0; i < listaVariaveis.size(); i++ ){
                
                if(listaVariaveis.get(i).contains("TK_INTEIRO")){
                    filaVariaveis.add(new TolkensSemantico("foi declarado a variavel :", listaVariaveis.get(i+1)));
                    novaListVar.add(listaVariaveis.get(i+1));
           
                }
            }
            
            for (int i = 0; i< novaListVar.size(); i++){
                
               if (novaListVar2.contains(novaListVar.get(i))){
                        System.out.println(" ERRO  Semantico A  variavel: "+ novaListVar.get(i)+ " foi declarada mais de uma vez \n");
                        return;
                    }else{
                        novaListVar2.add(novaListVar.get(i)); 
                    }
            }    
        
        } 
        
       // System.out.println("-------Variaveis declaradas--------");
        //System.out.println(novaListVar);
        
        for (int i = 0; i < listaDivisor.size(); i++){
          
            if(listaDivisor.get(i).equals("/")){
                
                if(listaDivisor.get(i+1).equals("0")){
                    System.out.println(" ERRO Semântico divisão por zero \n");
                    return;
                }else if(listaTolkensIdVar.size()>0){
                    
                        for(int l = 0; l < listaTolkensIdVar.size();l++){
                             
                                if(listaTolkensIdVar.get(l).contains("TK_Var") && listaTolkensIdVar.get(l+1).contains("TK_Atribuir")){
                                    
                                    if(listaDivisor.get(l+2).equals("0")){
                                                                            
                                        if(listaDivisor.get(l).equals(listaDivisor.get(i+1))){
                                            System.out.println(" ERRO Semântico divisão por zero \n "); 
                                            return;
                                            
                                        }
                                    }
                                }
                        }
                    }
                
            }
        }
        
        if (argu == true && arg.contains("-lse") | arg.contains("-tudo")){
            for(TolkensSemantico l : filaVariaveis){
                                     System.out.println(l.getTolkensVariaveis()+" -- "+l.getTkVar());
                    }
            
        }
   }
    
}
