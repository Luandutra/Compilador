
package analiseSintatica;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;



public class Sintatico {
    
    public static void  processoSintatico(ArrayList<String> arqSint,   Queue<String> filaTolkens ){
        
        ArrayList<String[]> quebraLinhas = new ArrayList<>();
        Stack pilha = new Stack();
        
        pilha.push("$");
        pilha.push("<CODIGO>");
        
        for (int i = 0; i < arqSint.size()-1;i++){
            try{
            quebraLinhas.add(arqSint.get(i).split(";"));

            }catch(Exception e){
                System.out.println("erro " + e );
            }
        }
        
        System.out.println("teste pilha"+pilha);
        for (int  i = 0; i < quebraLinhas.size(); i++){
            for(int j = 0; j < quebraLinhas.get(i).length; j++){
            
                System.out.println(quebraLinhas.get(i)[j]);
            }
            
        } 
    }
}
