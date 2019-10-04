/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisadorSintatico;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 *
 * @author luand
 */
public class testePilha {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Queue<String> filaTolkens = new PriorityQueue<String>();
        
        filaTolkens.add("luan");
        filaTolkens.add("Dutra");
        filaTolkens.add("da");
        filaTolkens.add("Silva");
        
        System.out.println("\n"+ filaTolkens);
    }
    
}
