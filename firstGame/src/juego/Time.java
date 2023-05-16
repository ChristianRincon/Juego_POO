// Código en mantenimiento 

package juego;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Time{
    
    public static int segundos = 0;
    public static int minutos = 0;
        
    public void Time(){       
        for(minutos = 0; minutos < 60; minutos++){          
            for(segundos = 0; segundos < 60; segundos++){              
                  count();
            }
        }
    }
    
    public int minutos(){ 
        return minutos++;
    }
    
    public int segundos(){
        return segundos++;
    }
    
    private static void count(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
