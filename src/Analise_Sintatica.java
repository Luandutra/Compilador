
package analisadorSintatico;



public class Analise_Sintatica {
    
    public int sintatico(String listaTolkens){
        
      if (listaTolkens == "$") return 0;	
      if (listaTolkens == "TK_INTEIRO") return 1;    
      if (listaTolkens == "TK_AbreCochete") return 2;
      if (listaTolkens == "TK_FechaCochete") return 3;	
      if (listaTolkens == "TK_AbreParentese") return 4;
      if (listaTolkens == "TK_FechaParentese") return 5;
      if (listaTolkens == "TK_Aspas") return 6;
      if (listaTolkens == "TK_FimLinha") return 7;
      if (listaTolkens == "TK_Palavra") return 8;
      if (listaTolkens == "TK_Largada") return 9;
      if (listaTolkens == "TK_Chegada") return 10;
      if (listaTolkens == "TK_AutoEntrada") return 11;
      if (listaTolkens == "TK_AutoSaida") return 12;
      if (listaTolkens == "TK_Quando") return 13;
      if (listaTolkens == "TK_Exceto") return 14;
      if (listaTolkens == "TK_Sempre") return 15;
      if (listaTolkens == "TK_FimSempre") return 16;
      if (listaTolkens == "TK_Incremento") return 17;
      if (listaTolkens == "TK_Decremento") return 18;
      if (listaTolkens == "TK_Adicao") return 19;
      if (listaTolkens == "TK_Subtracao") return 20;
      if (listaTolkens == "TK_Multiplicacao") return 21;
      if (listaTolkens == "TK_Divisao" ) return 22;
      if (listaTolkens == "TK_Atribuir") return 23;
      if (listaTolkens == "TK_Igual") return 24;
      if (listaTolkens == "TK_Diferente") return 25;
      if (listaTolkens == "TK_Maior") return 26;
      if (listaTolkens == "TK_Menor") return 27;
      if (listaTolkens == "TK_MaiorIgual") return 28;
      if (listaTolkens == "TK_MenorIgual") return 29;
      if (listaTolkens == "TK_Var") return 30;
      if (listaTolkens == "TK_Int") return 31;
      if (listaTolkens == "TK_IntNegativo") return 32;
      
      return sintatico(listaTolkens);
      
    }
    
    public int naoTerminal(String nTerminal) {
        if (nTerminal == "<CODIGO>") return 0;
        if (nTerminal == "<LISTA_CODIGO>") return 1;
        if (nTerminal == "<COMANDO>") return 2;
        if (nTerminal == "<VARIAVEIS>") return 3;
        if (nTerminal == "<ARGUMENTO>") return 4;
        if (nTerminal == "<ARGUMENTOAUX>") return 5;
        if (nTerminal == "<STRING>") return 6;
        if (nTerminal == "<NUMVAR>") return 7;
        if (nTerminal == "<NUMERO>") return 8;
        if (nTerminal == "<OPEVARINT>") return 9;
        if (nTerminal == "<ARGUMENTONOVO>") return 10;
        if (nTerminal == "<ADICIONAL>") return 11;
        if (nTerminal == "<EXETO>") return 12;
        if (nTerminal == "<ITERACAO>") return 13;
        if (nTerminal == "<VAR>") return 14;
        if (nTerminal == "<INT>") return 15;
        if (nTerminal == "<OPERADORESMAT>") return 16;
        if (nTerminal == "<OPERADORESLOG>") return 17;
        if (nTerminal == "<OPERACAOMAT>") return 18;
        if (nTerminal == "<EXPRESSAOMAT>") return 16;
        
        return naoTerminal(nTerminal);
                

    }
    
    
}
