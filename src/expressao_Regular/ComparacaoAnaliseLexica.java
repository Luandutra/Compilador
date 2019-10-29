
package expressao_Regular;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tolkens.TolkensGramatica;



public class ComparacaoAnaliseLexica {
    
    public static String saida = "tokens.txt";
    public static FileWriter arq;
    public static PrintWriter gravarArquivoTolkens;
    public static boolean arg;
    
    public static void procedimento( ArrayList<String>arquivo, boolean argu, ArrayList<String> arqSint,ArrayList<String> arg ){
        
        ArrayList<String[]> quebraLinhas = new ArrayList<>();
        ArrayList<TolkensGramatica> TolkensPalavras = new ArrayList<>();
        ArrayList<TolkensGramatica> Erros = new ArrayList<>();
        Queue<String> filaTolkens = new LinkedList<String>();
        ArrayList<String> listaVariaveis = new ArrayList<>();
        ArrayList<String> listaDivisor = new ArrayList<>();
        ArrayList<String> listaTolkensIdVar = new ArrayList<>();
        ArrayList<String> listaLexema = new ArrayList<>();
                 
                 
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
 
        
        for (int  i = 0; i < quebraLinhas.size(); i++){
            for(int j = 0; j < quebraLinhas.get(i).length; j++){
                
                
                
                
                Pattern p = Pattern.compile("[\"]");
                Matcher m = p.matcher(quebraLinhas.get(i)[j]);
                if(m.find()){
                    
                    frases = true;
                    while (frases){
                        if (quebraLinhas.get(i)[j].endsWith("\"")){
                            txt += " " + quebraLinhas.get(i)[j];
                           
                        }else {
                            txt += " "+ quebraLinhas.get(i)[j];
                            frases = false;
                             System.out.println("tetststetete");
                        }
                        j++;
                    }
                    TolkensPalavras.add(new TolkensGramatica ( "TK_Palavra",txt,i, j));
                    txt= "";
                }
             
            /*   
                if(quebraLinhas.get(i)[j].contentEquals("\"")){                    
                    Frases = true;
                    
                    while(Frases){
                                                                             
                    if (quebraLinhas.get(i)[j].endsWith("\"")){ // Verifica quando é encontrado a ultima aspas
                            txt += " "  + quebraLinhas.get(i)[j];
                            
                        }else {
                                   txt += " " + quebraLinhas.get(i)[j];
                                   Frases = false;

                        }
                        j++;
                    }
                    
                   TolkensPalavras.add(new TolkensGramatica("TK_string", txt, i, j));
                   txt = " ";
                                
                    }
                */          
          
        if (quebraLinhas.get(i)[j].matches("Largada")){
            TolkensPalavras.add(new TolkensGramatica ( "TK_Largada",quebraLinhas.get(i)[j],i, j)); 
           
            filaTolkens.add("TK_Largada");
          
        }else if (quebraLinhas.get(i)[j].matches("Chegada")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Chegada: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_Chegada");
           
             
        }else if (quebraLinhas.get(i)[j].matches("AutoSaida")){
            TolkensPalavras.add(new TolkensGramatica ("TK_AutoSaida: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_AutoSaida");
           
        }else if (quebraLinhas.get(i)[j].matches("AutoEntrada")){
            TolkensPalavras.add(new TolkensGramatica ("TK_AutoEntrada: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_AutoEntrada");
            
        }else if (quebraLinhas.get(i)[j].matches("Int")){
            TolkensPalavras.add(new TolkensGramatica ("TK_INTEIRO: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_INTEIRO");
                listaVariaveis.add("TK_INTEIRO");
        }else if (quebraLinhas.get(i)[j].matches("Quando")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Quando: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_Quando");
            
        }else if (quebraLinhas.get(i)[j].matches("Exceto")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Exceto: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_Exceto");
           
        }else if (quebraLinhas.get(i)[j].matches("Sempre")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Sempre: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_Sempre");
            
        }else if (quebraLinhas.get(i)[j].matches("FimSempre")){
            TolkensPalavras.add(new TolkensGramatica ("TK_FimSempre: ", quebraLinhas.get(i)[j],i,j));
           
                filaTolkens.add("TK_FimSempre");
            
        }else if (quebraLinhas.get(i)[j].matches("\\.")){
            TolkensPalavras.add(new TolkensGramatica ("TK_FimLinha: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_FimLinha");
           
        }else if (quebraLinhas.get(i)[j].matches("\\(")){
            TolkensPalavras.add(new TolkensGramatica ("TK_AbreParentese: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_AbreParentese");
            
        }else if (quebraLinhas.get(i)[j].matches("\\)")){
            TolkensPalavras.add(new TolkensGramatica ("TK_FechaParentese: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_FechaParentese");
           
        }else if (quebraLinhas.get(i)[j].matches("\\[")){
            TolkensPalavras.add(new TolkensGramatica ("TK_AbreCochete: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_AbreCochete");
            
        }else if (quebraLinhas.get(i)[j].matches("\\]")){
            TolkensPalavras.add(new TolkensGramatica ("TK_FechaCochete: ", quebraLinhas.get(i)[j],i,j));
           
                filaTolkens.add("TK_FechaCochete");
          
        }else if (quebraLinhas.get(i)[j].matches("[0-9]*")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Int: ", quebraLinhas.get(i)[j],i,j));
             
                filaTolkens.add("TK_Int");
            
        }else if (quebraLinhas.get(i)[j].matches("-[0-9]+")){
            TolkensPalavras.add(new TolkensGramatica ("TK_IntNegativo: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_IntNegativo");
            
        }else if (quebraLinhas.get(i)[j].matches("\\:=")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Atribuir: ", quebraLinhas.get(i)[j],i,j));
             
                filaTolkens.add("TK_Atribuir");
            
        }else if (quebraLinhas.get(i)[j].matches("\\+")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Adicao: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_Adicao");
            
        }else if (quebraLinhas.get(i)[j].matches("\\-")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Subtracao: ", quebraLinhas.get(i)[j],i,j));
             
                filaTolkens.add("TK_Subtracao");
            
        }else if (quebraLinhas.get(i)[j].matches("\\*")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Multiplicacao: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_Multiplicacao");
            
        }else if (quebraLinhas.get(i)[j].matches("\\/")){
            TolkensPalavras.add(new TolkensGramatica ("Tk_Divisao: ", quebraLinhas.get(i)[j],i,j));
             
                filaTolkens.add("TK_Divisao");
            
        }else if (quebraLinhas.get(i)[j].matches("\\>")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Maior: ", quebraLinhas.get(i)[j],i,j));
             
                filaTolkens.add("TK_Maior");
           
        }else if (quebraLinhas.get(i)[j].matches("\\<")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Menor: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_Menor");
           
        }else if (quebraLinhas.get(i)[j].matches("\\=")){
            TolkensPalavras.add(new TolkensGramatica ("Tk_Igual: ", quebraLinhas.get(i)[j],i,j));
             
                filaTolkens.add("TK_Igual");
            
        }else if (quebraLinhas.get(i)[j].matches("\\<=")){
            TolkensPalavras.add(new TolkensGramatica ("TK_MaiorIgual", quebraLinhas.get(i)[j],i,j));
             
                filaTolkens.add("TK_MaiorIgual");
           
        }else if (quebraLinhas.get(i)[j].matches("\\>=")){
            TolkensPalavras.add(new TolkensGramatica ("TK_MenorIgual: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_MenorIgual");
            
        }else if (quebraLinhas.get(i)[j].matches("\\<>")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Diferente: ", quebraLinhas.get(i)[j],i,j));
             
                filaTolkens.add("TK_Diferente");
            
        }else if (quebraLinhas.get(i)[j].matches("\\++")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Inclemento: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_Inclemento");
            
        }else if (quebraLinhas.get(i)[j].matches("\\-\\-")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Declemento: ", quebraLinhas.get(i)[j],i,j));  
             
                filaTolkens.add("TK_Declemento");
            
        }else if (quebraLinhas.get(i)[j].matches("[a-zA-Z][a-zA-Z0-9]*") && !quebraLinhas.get(i)[j].contains("Largada|Chegada|AutoEntrada|AutoSaida|Sempre|Quando|Exceto| Int")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Var: ", quebraLinhas.get(i)[j],i,j));
            
                filaTolkens.add("TK_Var");
                listaVariaveis.add(quebraLinhas.get(i)[j]);
        }else if (quebraLinhas.get(i)[j].matches("\"([\\s+]|[a-zA-Z0-9])*\"")){
            TolkensPalavras.add(new TolkensGramatica ("Tolkens: String", quebraLinhas.get(i)[j],i,j));
           
                filaTolkens.add("TK_String");
            
            
        }else{ 
            Erros.add(new TolkensGramatica("Erro Lexico: ", quebraLinhas.get(i)[j],i,j));
        }
        }
        }
        if ( argu == true){
                if (Erros.size()!=0){
                        for(TolkensGramatica e : Erros){
                                System.out.println("Erro Lexico: " + e.getTkNome()+" -- "+"Lexema: "+ e.getTkLexema()+ " -- "+ "Linha: "+ e.getPosicaoLinha()+" -- "+"coluna: "+e.getPosicaoColuna());
                         }
                }
        }
        //Adiciona no ultimo valor da lista o sifrom
        filaTolkens.add("$");
        
        //Lista que adiciona os lexema para identificação do divisor
        for(TolkensGramatica e : TolkensPalavras){
                listaTolkensIdVar.add(e.getTkNome());
            
                             
        }
        
        //Lista que adiciona os tolkens para identificação do tolken tk_var
        for(TolkensGramatica e : TolkensPalavras){
                listaDivisor.add(e.getTkLexema());
                             
        }
         
        //Apresenta as listagens de tolkens
        if( argu == true && arg.contains("-lt") ){

            for(TolkensGramatica l : TolkensPalavras){
                        System.out.println("tolkens: " + l.getTkNome()+" -- "+"Lexema: "+ l.getTkLexema()+ " -- "+ "Linha: "+ l.getPosicaoLinha()+" -- "+"coluna: "+l.getPosicaoColuna());
                }
           
        }else {
            System.out.println("Analise Léxica Contruida com sucesso!!\n");
        }
        //Apresenta os loops de analise sintatica
        if(argu == true && arg.contains("-ls")){
             expressao_Regular.AnaliseSintatica.sint(arquivo, argu, arqSint,filaTolkens, arg);
        }else {
            System.out.println("Analise Sintatica construida com sucesso\n");
        }
        
        //Apresenta todas as opções posiveis exirgida pelo compilador 
        if(argu == true && arg.contains("-tudo")){
            
            for(TolkensGramatica l : TolkensPalavras){
                        System.out.println("tolkens: " + l.getTkNome()+" -- "+"Lexema: "+ l.getTkLexema()+ " -- "+ "Linha: "+ l.getPosicaoLinha()+" -- "+"coluna: "+l.getPosicaoColuna());
                }
            
            expressao_Regular.AnaliseSintatica.sint(arquivo, argu, arqSint,filaTolkens, arg);
        }
        // lista as variaveis 
        if(argu == true && arg.contains("-lv")| arg.contains("-tudo")){
            expressao_Regular.AnaliseSemantica.semantico(listaVariaveis, listaDivisor, listaTolkensIdVar);
            
        }
            
    }
    

}
