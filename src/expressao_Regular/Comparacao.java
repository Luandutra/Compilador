
package expressao_Regular;

import java.util.ArrayList;
import tolkens.TolkensGramatica;


public class Comparacao {
    public static void procedimento( ArrayList<String>arquivo, boolean argu){
        
         ArrayList<String[]> quebraLinhas = new ArrayList<>();
         ArrayList<TolkensGramatica> TolkensPalavras = new ArrayList<>();
         ArrayList<TolkensGramatica> Erros = new ArrayList<>();
          
      
        int cont = 0;
        for (int i = 0; i < arquivo.size()-1;i++){
            try{
            quebraLinhas.add(arquivo.get(i).split(" "));

            }catch(Exception e){
                System.out.println("erro " + e );
            }
        }
          
      
        boolean Frases = false;
        String txt = "";
 
        
        for (int  i = 0; i < quebraLinhas.size(); i++){
            for(int j = 0; j < quebraLinhas.get(i).length; j++){
             
                
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
                          
          
        if (quebraLinhas.get(i)[j].matches("Largada")){
            TolkensPalavras.add(new TolkensGramatica ( "TK_Largada",quebraLinhas.get(i)[j],i, j));   
        }else if (quebraLinhas.get(i)[j].matches("Chegada")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Chegada: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("AutoSaida")){
            TolkensPalavras.add(new TolkensGramatica ("TK_AutoSaida: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("AutoEntrada")){
            TolkensPalavras.add(new TolkensGramatica ("TK_AutoEntrada: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("Int")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Inteiro: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("Quando")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Quando: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("Exceto")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Exceto: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("Sempre")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Sempre: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("FimSempre")){
            TolkensPalavras.add(new TolkensGramatica ("TK_FimSempre: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\.")){
            TolkensPalavras.add(new TolkensGramatica ("TK_FimLinha: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\(")){
            TolkensPalavras.add(new TolkensGramatica ("TK_AbrePar: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\)")){
            TolkensPalavras.add(new TolkensGramatica ("TK_FechaPar: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\[")){
            TolkensPalavras.add(new TolkensGramatica ("TK_AbreCochete: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\]")){
            TolkensPalavras.add(new TolkensGramatica ("TK_FechaCochete: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("[0-9]*")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Numeros: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\:=")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Atribuicao: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\+")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Soma: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\-")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Subtracao: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\*")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Multiplicacao: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\/")){
            TolkensPalavras.add(new TolkensGramatica ("Tk_Divisao: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\>")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Maior: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\<")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Menor: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\=")){
            TolkensPalavras.add(new TolkensGramatica ("Tk_Igual: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\<=")){
            TolkensPalavras.add(new TolkensGramatica ("TK_MaiorIgual", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\>=")){
            TolkensPalavras.add(new TolkensGramatica ("TK_MenorIgual: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\<>")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Diferente: ", quebraLinhas.get(i)[j],i,j));
        }else if (quebraLinhas.get(i)[j].matches("\\++")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Inclemento: ", quebraLinhas.get(i)[j],i,j));    
        }else if (quebraLinhas.get(i)[j].matches("\\-\\-")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Declemento: ", quebraLinhas.get(i)[j],i,j));  
        }else if (quebraLinhas.get(i)[j].matches("[a-zA-Z][a-zA-Z0-9]*") && !quebraLinhas.get(i)[j].contains("Largada|Chegada|AutoEntrada|AutoSaida|Sempre|Quando|Exceto| Int")){
            TolkensPalavras.add(new TolkensGramatica ("TK_Variavel: ", quebraLinhas.get(i)[j],i,j));    
        }else if (quebraLinhas.get(i)[j].matches("\"([\\s+]|[a-zA-Z0-9])*\"")){
            TolkensPalavras.add(new TolkensGramatica ("Tolkens: frase ", quebraLinhas.get(i)[j],i,j));
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
        
       
        if( argu== true ){
                for(TolkensGramatica l : TolkensPalavras){
                        System.out.println("tolkens: " + l.getTkNome()+" -- "+"Lexema: "+ l.getTkLexema()+ " -- "+ "Linha: "+ l.getPosicaoLinha()+" -- "+"coluna: "+l.getPosicaoColuna());
                }
       }
       
    }

}
