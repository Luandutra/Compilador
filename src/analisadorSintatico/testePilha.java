/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorSintatico;
import java.util.Stack;
/**
 *
 * @author luand
 */
public class testePilha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Stack pilha = new Stack();
        pilha.push("luan");
        pilha.push(3);
        
        
        System.out.println(" pilha " + pilha );
        System.out.println(" pilha " + pilha.pop() );
        System.out.println("  teste " + pilha );
        
    }
    
}
