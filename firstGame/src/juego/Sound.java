package juego;

import java.io.File;
import java.io.FileInputStream;
import javazoom.jl.player.advanced.AdvancedPlayer;

public class Sound{
    
     public void sound(String soundName){
        try{
            FileInputStream track = new FileInputStream(new File(soundName));
            AdvancedPlayer player = new AdvancedPlayer(track);
            player.play();
        } 
        catch (Exception ex){
            ex.printStackTrace();
        }          
    }
}
