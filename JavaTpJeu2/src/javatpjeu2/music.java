/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatpjeu2;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author thoma
 */
public class music {
    private String  musiclink;
    public music(String url) {
        this.musiclink = url;
    }
    public void playmusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("song\\"+musiclink+".wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound"+musiclink);
            ex.printStackTrace();
        }
    }
    public void playmusicboucle() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("song\\"+musiclink+".wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch(Exception ex) {
            System.out.println("Error with playing sound(B)"+musiclink);
            ex.printStackTrace();
        }
    }
    
}
