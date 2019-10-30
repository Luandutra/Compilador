
package expressao_Regular;




import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import tolkens.TolkensGramatica;
import tolkens.TolkensSintatico;



public class AnaliseSintatica {
    

    
    public static void sint( ArrayList<String>arquivo, boolean argu, ArrayList<String> arqSint, Queue<String> filaTolkens, ArrayList<String> arg){
        
        ArrayList<String[]> quebraLinhas = new ArrayList<>();
        ArrayList<TolkensGramatica> TolkensPalavras = new ArrayList<>();
        ArrayList<TolkensSintatico> exe = new ArrayList<>();
        Stack<String> pilha = new Stack<String>();
        
      
        for (int i = 0; i < arquivo.size()-1;i++){
            try{
            quebraLinhas.add(arquivo.get(i).split(" "));

            }catch(Exception e){
                System.out.println("erro " + e );
            }
        }
          
      
        boolean frases = false;
        String txt = "";
 
        
        
     
        
        ArrayList<String[]> quebLinhas = new ArrayList<>();
        ArrayList<TolkensSintatico> vet2 = new ArrayList<>();
        String vet[] = new String[34];
        
        int aux = -1,aux2 = 0, aux3 = 0;
        Boolean c = false;
        
        
        for (int i = 0; i < arqSint.size()-1;i++){
            try{
            quebLinhas.add(arqSint.get(i).split(";"));

            }catch(Exception e){
                System.out.println("erro " + e );
            }
        }
        
        
        
        
        pilha.push("$");
        pilha.push("<CODIGO>");
       
        
       vet[0]= "-1";
       vet[1]= "$";
       vet[2]= "TK_INTEIRO";
       vet[3]= "TK_AbreCochete";
       vet[4]= "TK_FechaCochete";
       vet[5]= "TK_AbreParentese";
       vet[6]= "TK_FechaParentese";
       vet[7]= "TK_Aspas";
       vet[8]= "TK_FimLinha";
       vet[9]= "TK_Palavra";
       vet[10]= "TK_Largada";
       vet[11]= "TK_Chegada";
       vet[12]= "TK_AutoEntrada";
       vet[13]= "TK_AutoSaida";
       vet[14]= "TK_Quando";
       vet[15]= "TK_Exceto";
       vet[16]= "TK_Sempre";
       vet[17]= "TK_FimSempre";
       vet[18]= "TK_Incremento";
       vet[19]= "TK_Decremento";
       vet[20]= "TK_Adicao";
       vet[21]= "TK_Subtracao";
       vet[22]= "TK_Multiplicacao";
       vet[23]= "TK_Divisao";
       vet[24]= "TK_Atribuir";
       vet[25]= "TK_Igual";
       vet[26]= "TK_Diferente";
       vet[27]= "TK_Maior";
       vet[28]= "TK_Menor";
       vet[29]= "TK_MaiorIgual";
       vet[30]= "TK_MenorIgual";
       vet[31]= "TK_Var";
       vet[32]= "TK_Int";
       vet[33]= "TK_IntNegativo"; 
       
   
        
        if(pilha.peek()== "<CODIGO>" && filaTolkens.peek()== "$"){
            System.out.println("Construido com sucesso");
          
        }else{
            for (int  i = 1; i < quebLinhas.size(); i++){
                c =  false ;
                String teste = pilha.peek();
                String teste2;
                String teste3;
                teste2 = quebLinhas.get(i)[0];
              
                
                if (pilha.peek()== "$" && filaTolkens.peek()=="$"){
                                                            
                    System.out.println("Sintatico Correto");
                    break;
                                                            
                } else if(teste.equals(teste2) ){
                 
                    for(int j = 1; j < quebLinhas.get(i).length; j++){
                        int t = 0;
                        
                        aux2= Integer.parseInt(quebLinhas.get(i)[j]);
                        
                            if(filaTolkens.peek() == vet[j]){
                                aux = Integer.parseInt(quebLinhas.get(i)[j]);
                                c = true;
                                
                               if (aux== -1){
                                        System.out.println("ERRO SINTATICO");
                                        System.out.println(quebraLinhas.get(i)[j]);
                               }
                            }
                            
                        
                    } 
                }else if (pilha.peek() == filaTolkens.peek()) {
                   
                    
                    exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                    pilha.pop();
                    exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                    filaTolkens.poll();
                    
                    
                    i= 0;
                }
                                while (c){
                                                        // se o topo da pilha for terminal
                                                   
                                                                        
                                            switch(aux){

                                                case 0:
                                                        
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Chegada");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        pilha.push("<LISTA_CODIGO>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        pilha.push("TK_Largada");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        c =false;
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){

                                                               exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                                pilha.pop();
                                                               
                                                                exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                                filaTolkens.poll();

                                                            }
                                                         i = 1;
                                                        break;
                                                        
                                                case 1:
                                                        exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                        pilha.pop();
                                                            
                                                        
                                                        pilha.push("<LISTA_CODIGO>");
                                                            exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<COMANDO>");
                                                            exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                         
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 2:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                         pilha.pop();

                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        i=1; 
                                                        c = false;
                                                        break;
                                                case 3:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        pilha.push("TK_FimLinha");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));                                                            
                                                        pilha.push("<ARGUMENTO>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));   
                                                        pilha.push("<VAR>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));    
                                                        pilha.push("<INT>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));    
                                                       
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        c =false;
                                                        i = 1;
                                                        break;
                                                case 4:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        pilha.push("<ARGUMENTOAUX>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        pilha.push("TK_Atribuir");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 5:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }

                                                        i = 1;
                                                        c = false;
                                                        break;
                                                
                                                case 6:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        pilha.push("<OPEVARINT>"); 
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 7:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        pilha.push("TK_FechaParentese");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        pilha.push("<STRING>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        pilha.push("TK_AbreParentese");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 8:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        pilha.push("<OPERACAOMAT>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        pilha.push("<NUMVAR>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                       
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                         
                                                        i = 1; 
                                                        c =false;
                                                        break;
                                                case 9:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        pilha.push("<NUMERO>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                                                                     
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 10:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        pilha.push("<VAR>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                                                         
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                         
                                                        i = 1;
                                                        c =false;
                                                        break; 
                                                case 11:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        pilha.push("TK_Int");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;         
                                                case 12:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        pilha.push("TK_IntNegativo");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                                                                     
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;  
                                                case 13:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        pilha.push("<OPEVARINT>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        pilha.push("<OPERADORESMAT>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        i = 1;
                                                        c =false;
                                                        break;  
                                                case 14:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                      
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                            
                                                case 15:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        pilha.push("TK_Palavra");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                      
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 16:
                                                     
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_INTEIRO");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                         
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        i = 1;                                                          
                                                        c = false;
                                                        break;        
                                                case 17:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        
                                                        pilha.push("TK_Var");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                            
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i= 1 ;
                                                        c =false;
                                                        break;
                                                        
                                                case 18:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                                                                      
                                                        pilha.push("TK_FimLinha");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<ARGUMENTONOVO>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_Var");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 19:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("<ITERACAO>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                            
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                case 20:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                            
                                                        pilha.push("<ARGUMENTOAUX>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                            
                                                        pilha.push("TK_Atribuir");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                            
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;         
                                                case 21:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Incremento");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                            
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;         
                                                case 22:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Decremento");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                            
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;                    
                                                case 23:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_FimLinha");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                            
                                                        pilha.push("TK_FechaParentese");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));   
                                                            
                                                        pilha.push("<VARIAVEIS>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                            
                                                        pilha.push("TK_AbreParentese");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                            
                                                        pilha.push("TK_AutoEntrada");
                                                         exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;           
                                                case 24:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_FimLinha");
                                                            exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                            
                                                        pilha.push("TK_FechaParentese");
                                                            exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<VARIAVEIS>");
                                                            exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_AbreParentese");
                                                            exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_AutoSaida");
                                                            exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                         
                                                        i = 1;
                                                        c =false;
                                                        break;    
                                                case 25:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("<INT>");
                                                           exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;          
                                                case 26:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("<VAR>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        i = 1;
                                                        c =false;
                                                        break;          
                                                case 27:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        pilha.push("TK_Palavra");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        i = 1;
                                                        c =false;
                                                        break;                    
                                                case 28:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("<EXETO>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_FechaCochete");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<LISTA_CODIGO>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_AbreCochete");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<ADICIONAL>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_Quando");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;     
                                                case 29:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_FechaParentese");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<EXPRESSAOMAT>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<OPERADORESLOG>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<EXPRESSAOMAT>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_AbreParentese");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                    
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;               
                                                case 30:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_FechaCochete");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<LISTA_CODIGO>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_AbreCochete");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_Exceto");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                      
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                    
                                                        i = 1;
                                                        c =false;
                                                        break; 
                                                case 31:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("<OPERACAOMAT>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<NUMVAR>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                      
                                                    
                                                        i = 1;
                                                        c =false;
                                                        break;         
                                                case 32:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("<OPERACAOMAT>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_FechaParentese");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<EXPRESSAOMAT>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_AbreParentese");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                      
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                    
                                                        i = 1;
                                                        c =false;
                                                        break;         
                                                case 33:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_FimSempre");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_FechaCochete");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<LISTA_CODIGO>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_AbreCochete");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<ADICIONAL>");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("TK_Sempre");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 34:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Adicao");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                case 35:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Subtracao");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                case 36:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Multiplicacao");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                case 37:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Divisao");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                       if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                case 38:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Igual");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;                                  
                                                case 39:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Diferente");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                       if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 40:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Maior");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 41:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Menor");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 42:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_MaiorIgual");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                case 43:
                                                        exe.add(new TolkensSintatico("Desempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_MenorIgual");
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                        
                                                        
                                                        
                                                        
                                                default:
                                                    System.out.println("Analise concluida");
                                            return;
                                        }
                                }   
                               
                        }
                        
                    }
               
               System.out.println("----------------------------------------");
               if(argu == true && arg.contains("-ls") || arg.contains("-tudo")){
                    for(TolkensSintatico l : exe){
                                     System.out.println(l.getTkSintatico()+" -- "+l.getTkPasso());
                    }
                 
               }
          
    } 
}


