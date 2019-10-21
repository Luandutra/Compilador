
package expressao_Regular;




import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import tolkens.TolkensGramatica;
import tolkens.TolkensSintatico;



public class FilaDeTolkens {
    

    
    public static void sint( ArrayList<String>arquivo, boolean argu, ArrayList<String> arqSint, Queue<String> filaTolkens){
        
        ArrayList<String[]> quebraLinhas = new ArrayList<>();
        ArrayList<TolkensGramatica> TolkensPalavras = new ArrayList<>();
        ArrayList<TolkensGramatica> Erros = new ArrayList<>();
        ArrayList<TolkensSintatico> exe = new ArrayList<>();
        Stack<String> pilha = new Stack<String>();
        
        int valorJ = 0;
                 
                 
        int cont = 0;
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
        //pilha.push("TK_Largada");
        //pilha.push("<LISTA_CODIGO>");
        System.out.println("teste de fila"+ filaTolkens);
        System.out.println("----------------------------------------");
        System.out.println("teste de fila"+ pilha);
        
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
       
      //for(int i =0; i<vet.length;i++){
       //    System.out.println(vet[i]);
      // }
        
        if(pilha.peek()== "<CODIGO>" && filaTolkens.peek()== "$"){
            System.out.println("Construido com sucesso");
            System.out.println("teste de pilha " + pilha);   
        }else{
            for (int  i = 1; i < quebLinhas.size(); i++){
                c =  false ;
                String teste = pilha.peek();
                String teste2;
                String teste3;
                teste2 = quebLinhas.get(i)[0];
                //System.out.println("valor de nao terminao " + teste2);
                
                if (pilha.peek()== "$" && filaTolkens.peek()=="$"){
                                                            
                    System.out.println("Sintatico Correto");
                    break;
                                                            
                } else if(teste.equals(teste2) ){
                   // System.out.println("fudeu fudeu");
                    for(int j = 1; j < quebLinhas.get(i).length; j++){
                        int t = 0;
                        
                     
                        
                        aux2= Integer.parseInt(quebLinhas.get(i)[j]);
                        
                        
                            if(filaTolkens.peek() == vet[j]){
                                aux = Integer.parseInt(quebLinhas.get(i)[j]);
                                c = true;
                                System.out.println("Valor obtido da Tabela Sintatica "+aux);
                                System.out.println("valor da posicao j "+ j);
                                valorJ= j;
                                System.out.println("teste luan dutra");
                            } 
                        
                      
                    } 
                }else if (pilha.peek() == filaTolkens.peek()) {
                   
                    
                    System.out.println("Desenpilho da pilha "+ pilha.peek());
                    pilha.pop();
                    System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                    filaTolkens.poll();
                    
                    
                    i= 0;
                }
                                while (c){
                                                        // se o topo da pilha for terminal
                                                   
                                                                        
                                            switch(aux){

                                                case 0:
                                                        System.out.println("Desempilhou "+pilha.peek());
                                                        exe.add(new TolkensSintatico("Dsempilha", pilha.peek() ));
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Chegada");
                                                        System.out.println("Empilhou " + pilha.peek());
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        pilha.push("<LISTA_CODIGO>");
                                                        System.out.println("Empilhou " + pilha.peek());
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        pilha.push("TK_Largada");
                                                        System.out.println("Empilhou " + pilha.peek());
                                                        exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        c =false;
                                                        
                                                        if (pilha.peek()== "$" && filaTolkens.peek()=="$"){
                                                            
                                                            System.out.println("Sintatico Correto");
                                                            
                                                        }else if(pilha.peek() == filaTolkens.peek()){

                                                                System.out.println("Desempilhou "+ pilha.peek());
                                                                pilha.pop();
                                                                System.out.println("Retirou da fila "+ filaTolkens.peek());
                                                                filaTolkens.poll();

                                                            }else {
                                                                    System.out.println("Valor de nao terminal e tolkens diferentes");
                                                            }
                                                             System.out.println("valor da pilha "+pilha); 
                                                             System.out.println("valor da fila "+filaTolkens);
                                                         i = 1;
                                                        break;
                                                        
                                                case 1:
                                                           System.out.println("Desempilhou "+pilha.peek());
                                                           exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                        pilha.pop();
                                                            
                                                        
                                                        pilha.push("<LISTA_CODIGO>");
                                                            System.out.println("Empilhou " + pilha.peek());
                                                            exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        
                                                        pilha.push("<COMANDO>");
                                                            System.out.println("Empilhou " + pilha.peek());
                                                            exe.add(new TolkensSintatico("Empilhou", pilha.peek()));
                                                        if (pilha.peek()== "$" && filaTolkens.peek()=="$"){
                                                            
                                                            System.out.println("Sintatico Correto");
                                                            
                                                        }else if(pilha.peek() == filaTolkens.peek()){
                                                            
                                                           
                                                            System.out.println("Desempilhou "+ pilha.peek());
                                                            exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                            pilha.pop();
                                                            System.out.println("Retirou da fila "+ filaTolkens.peek());
                                                            exe.add(new TolkensSintatico("Retirou da fila", pilha.peek()));
                                                            filaTolkens.poll();
                                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                         
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 2:
                                                        System.out.println("Desempilhou  "+ pilha.peek());
                                                        exe.add(new TolkensSintatico("Desempilhou", pilha.peek()));
                                                        pilha.pop();

                                                        if (pilha.peek()== "$" && filaTolkens.peek()=="$"){
                                                            
                                                            System.out.println("Sintatico Correto");
                                                            //valorJ = 20;
                                                        }else if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desempilhou "+ pilha.peek());
                                                            exe.add(new TolkensSintatico("Desempilhou: ", pilha.peek()));
                                                            pilha.pop();
                                                            System.out.println("Retirou da fila "+ filaTolkens.peek());
                                                            exe.add(new TolkensSintatico("Retirou da fila: ", pilha.peek()));
                                                            filaTolkens.poll();
                                                        
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        i=1; 
                                                        c = false;
                                                        break;
                                                case 3:
                                                            System.out.println("Desempilhou "+pilha.peek());
                                                        pilha.pop();
                                                        pilha.push("TK_FimLinha");
                                                            System.out.println("Empilhou " + pilha.peek());
                                                        
                                                        pilha.push("<ARGUMENTO>");
                                                            System.out.println("Empilhou " + pilha.peek());
                                                            
                                                        pilha.push("<VAR>");
                                                            System.out.println("Empilhou " + pilha.peek());
                                                        pilha.push("<INT>");
                                                            System.out.println("Empilhou " + pilha.peek());
                                                           
                                                        if (pilha.peek()== "$" && filaTolkens.peek()=="$"){
                                                            
                                                            System.out.println("Sintatico Correto");
                                                            
                                                        }else if (pilha.peek()== "$" && filaTolkens.peek()=="$"){
                                                            
                                                            System.out.println("Sintatico Correto");
                                                            
                                                        }else if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desempilhou:"+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desempilhou: "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                                        
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        c =false;
                                                        i = 1;
                                                        break;
                                                case 4:
                                                        pilha.pop();
                                                        pilha.push("<ARGUMENTOAUX>");
                                                        pilha.push("TK_Atribuir");
                                                        
                                                        if (pilha.peek()== "$" && filaTolkens.peek()=="$"){
                                                            
                                                            System.out.println("Sintatico Correto");
                                                            
                                                        }else if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 5:
                                                        pilha.pop();
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 

                                                        i = 1;
                                                        c = false;
                                                        break;
                                                
                                                case 6:
                                                        pilha.pop();
                                                        pilha.push("<OPEVARINT>"); 
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 7:
                                                        pilha.remove(pilha.size()-1);
                                                        pilha.push("TK_FechaParentese");
                                                        pilha.push("<STRING>");
                                                        pilha.push("TK_AbreParentese");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                                        i=1;
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 8:
                                                        pilha.pop();
                                                        pilha.push("<OPERACAOMAT>");
                                                        pilha.push("<NUMVAR>");
                                                       
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                         
                                                        i = 1; 
                                                        c =false;
                                                        break;
                                                case 9:
                                                        pilha.pop();
                                                        pilha.push("<NUMERO>");
                                                                                                     
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 10:
                                                        pilha.pop();
                                                        pilha.push("<VAR>");
                                                                                                     
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                         
                                                        i = 1;
                                                        c =false;
                                                        break; 
                                                case 11:
                                                        pilha.pop();
                                                        pilha.push("TK_Int");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;         
                                                case 12:
                                                        pilha.pop();
                                                        pilha.push("TK_IntNegativo");
                                                                                                     
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;  
                                                case 13:
                                                        pilha.pop();
                                                        pilha.push("<OPEVARINT>");
                                                        pilha.push("<OPERADORESMAT>");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;  
                                                case 14:
                                                        pilha.pop();
                                                      
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desempilhou: "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Retirou da fila: "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                            
                                                case 15:
                                                        pilha.pop();
                                                        pilha.push("TK_Palavra");
                                                      
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desempilhou: "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println(" Retirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                        
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 16:
                                                     
                                                            System.out.println("Desempilho "+pilha.peek());
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_INTEIRO");
                                                            System.out.println("Empilho "+pilha.peek());
                                                         
                                                        if(pilha.peek() == filaTolkens.peek()){
                                                            System.out.println("valor de "+ pilha.peek());

                                                            System.out.println("Retiro da Pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desempilho "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                                        
                                                        
                                                            System.out.println("valor de linha : "+ i);
                                                            System.out.println("valor do vetor"+ vet[valorJ]);
                                                            i=1;
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens);     
                                                            
                                                        i = 1;                                                          
                                                        c = false;
                                                        break;        
                                                case 17:
                                                    System.out.println("luan dutra"+pilha.peek());
                                                            System.out.println("Desempilho "+pilha.peek());
                                                        pilha.pop();
                                                        
                                                        
                                                        pilha.push("TK_Var");
                                                            System.out.println("Empilho "+pilha.peek());
                                                            
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i= 1 ;
                                                        c =false;
                                                        break;
                                                        
                                                case 18:
                                                             System.out.println("Desempilho "+pilha.peek());
                                                        pilha.pop();
                                                                                                      
                                                        pilha.push("TK_FimLinha");
                                                            System.out.println("Empilho "+pilha.peek());
                                                        
                                                        pilha.push("<ARGUMENTONOVO>");
                                                            System.out.println("Empilho "+pilha.peek());
                                                        pilha.push("TK_Var");
                                                            System.out.println("Empilho "+pilha.peek());
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 19:
                                                               System.out.println("Desempilho "+pilha.peek());
                                                        pilha.pop();
                                                        
                                                        pilha.push("<ITERACAO>");
                                                            System.out.println("Empilho "+pilha.peek());
                                                            
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                case 20:
                                                            System.out.println("Desempilho "+pilha.peek());
                                                        pilha.pop();
                                                            
                                                        pilha.push("<ARGUMENTOAUX>");
                                                            System.out.println("Empilho "+pilha.peek());
                                                            
                                                        pilha.push("TK_Atribuir");
                                                            System.out.println("Empilho "+pilha.peek());
                                                            
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;         
                                                case 21:
                                                            System.out.println("Desempilho "+pilha.peek());
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Incremento");
                                                            System.out.println("Empilho "+pilha.peek());
                                                            
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;         
                                                case 22:
                                                            System.out.println("Desempilho "+pilha.peek());
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_Decremento");
                                                            System.out.println("Empilho "+pilha.peek());
                                                            
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;                    
                                                case 23:
                                                            System.out.println("Desempilho "+pilha.peek());
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_FimLinha");
                                                            System.out.println("Empilho "+pilha.peek());
                                                            
                                                        pilha.push("TK_FechaParentese");
                                                            System.out.println("Empilho "+pilha.peek());
                                                            
                                                        pilha.push("<VARIAVEIS>");
                                                            System.out.println("Empilho "+pilha.peek());
                                                            
                                                        pilha.push("TK_AbreParentese");
                                                            System.out.println("Empilho "+pilha.peek());
                                                            
                                                        pilha.push("TK_AutoEntrada");
                                                            System.out.println("Empilho "+pilha.peek());
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;           
                                                case 24:
                                                            System.out.println("Desempilho "+pilha.peek());
                                                        pilha.pop();
                                                        
                                                        pilha.push("TK_FimLinha");
                                                            System.out.println("Empilho "+pilha.peek());
                                                            
                                                        pilha.push("TK_FechaParentese");
                                                            System.out.println("Empilho "+pilha.peek());
                                                        
                                                        pilha.push("<VARIAVEIS>");
                                                            System.out.println("Empilho "+pilha.peek());
                                                        
                                                        pilha.push("TK_AbreParentese");
                                                            System.out.println("Empilho "+pilha.peek());
                                                        
                                                        pilha.push("TK_AutoSaida");
                                                            System.out.println("Empilho "+pilha.peek());
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                         
                                                        i = 1;
                                                        c =false;
                                                        break;    
                                                case 25:
                                                            System.out.println("Desempilho "+pilha.peek());
                                                        pilha.pop();
                                                        
                                                        pilha.push("<INT>");
                                                            System.out.println("Empilho "+pilha.peek());
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;          
                                                case 26:
                                                            System.out.println("Desempilho "+pilha.peek());
                                                        pilha.pop();
                                                        
                                                        pilha.push("<VAR>");
                                                            System.out.println("Empilho "+pilha.peek());
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;          
                                                case 27:
                                                        pilha.pop();
                                                        pilha.push("TK_Palavra");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;                    
                                                case 28:
                                                        pilha.pop();
                                                        pilha.push("<EXETO>");
                                                        pilha.push("TK_FechaCochete");
                                                        pilha.push("<LISTA_CODIGO>");
                                                        pilha.push("TK_AbreCochete");
                                                        pilha.push("<ADICIONAL>");
                                                        pilha.push("TK_Quando");
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;     
                                                case 29:
                                                        pilha.pop();
                                                        pilha.push("TK_FechaParentese");
                                                        pilha.push("<EXPRESSAOMAT>");
                                                        pilha.push("<OPERADORESLOG>");
                                                        pilha.push("<EXPRESSAOMAT>");
                                                        pilha.push("TK_AbreParentese");
                                                    
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;               
                                                case 30:
                                                        pilha.pop();
                                                        pilha.push("TK_FechaCochete");
                                                        pilha.push("<LISTA_CODIGO>");
                                                        pilha.push("TK_AbreCochete");
                                                        pilha.push("TK_Exceto");
                                                      
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                    
                                                        i = 1;
                                                        c =false;
                                                        break; 
                                                case 31:
                                                        pilha.pop();
                                                        pilha.push("<OPERACAOMAT>");
                                                        pilha.push(" <NUMVAR> ");
                                                     
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                      
                                                    
                                                        i = 1;
                                                        c =false;
                                                        break;         
                                                case 32:
                                                        pilha.pop();
                                                        pilha.push("<OPERACAOMAT>");
                                                        pilha.push("TK_FechaParentese");
                                                        pilha.push("<EXPRESSAOMAT>");
                                                        pilha.push("TK_AbreParentese");
                                                      
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                    
                                                        i = 1;
                                                        c =false;
                                                        break;         
                                                case 33:
                                                        pilha.pop();
                                                        pilha.push("TK_FimSempre");
                                                        pilha.push("TK_FechaCochete");
                                                        pilha.push("<LISTA_CODIGO>");
                                                        pilha.push("TK_AbreCochete");
                                                        pilha.push("ADICIONAL>");
                                                        pilha.push("TK_Sempre");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 34:
                                                        pilha.pop();
                                                        pilha.push("TK_Adicao");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                case 35:
                                                        pilha.pop();
                                                        pilha.push("TK_Subtracao");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                case 36:
                                                        pilha.pop();
                                                        pilha.push("TK_Multiplicacao");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                case 37:
                                                        pilha.pop();
                                                        pilha.push("TK_Divisao");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                case 38:
                                                        pilha.pop();
                                                        pilha.push("TK_Igual");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;                                  
                                                case 39:
                                                        pilha.pop();
                                                        pilha.push("TK_Diferente");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 40:
                                                        pilha.pop();
                                                        pilha.push("TK_Maior");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 41:
                                                        pilha.pop();
                                                        pilha.push("TK_Menor");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;
                                                case 42:
                                                        pilha.pop();
                                                        pilha.push("TK_MaiorIgual");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                case 43:
                                                        pilha.pop();
                                                        pilha.push("TK_MenorIgual");
                                                        
                                                        if(pilha.peek() == filaTolkens.peek()){
                                            
                                                            System.out.println("Desenpilho da pilha "+ pilha.peek());
                                                            pilha.pop();
                                                            System.out.println("Desenfileirou da fila "+ filaTolkens.peek());
                                                            filaTolkens.poll();
                                            
                                                        }else {
                                                                System.out.println("Valor de nao terminal e tolkens diferentes");
                                                        }
                                                         System.out.println("valor da pilha "+pilha); 
                                                         System.out.println("valor da fila "+filaTolkens); 
                                                        
                                                        i = 1;
                                                        c =false;
                                                        break;        
                                                        
                                                        
                                                        
                                                        
                                                default:
                                                    System.out.println("testando"+pilha);
                                            return;
                                        }
                                }   
                               
                               
                        
                        }
                        /*
                        for(TolkensSintatico l : exe){
                                System.out.println("vida loka porra");
                                System.out.println( l.getTkSintatico()+" -- "+l.getTkPasso());
                        
                        }
                        */
                    }
               
               System.out.println("----------------------------------------");
               for(TolkensSintatico l : exe){
                                System.out.println( l.getTkSintatico()+" -- "+l.getTkPasso());
               }
               
             // System.out.println(""+ pilha);
        
        
        
        /*
        System.out.println(" teste da pilha" + pilha);
        for (int  i = 0; i < quebLinhas.size(); i++){
            for(int j = 0; j < quebLinhas.get(i).length; j++){
          */  
                //System.out.println(quebLinhas.get(i)[j]);
         //   }
            
       // } 
            
    } 
}


