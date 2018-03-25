
package jogo;

import jplay.Sound;

/**
 *
 * @author mariajosineidedefrei
 */
public class Som {
    
    private static Sound musica;
    
    public static  void  play(String audio){
        stop();
        musica = new Sound ("src//audio//sound.mid");
        Som.musica.play();
        Som.musica.setRepeat(true);
    }
    
    
    public static void stop(){
        if (Som.musica != null){
            musica.stop();
        }
    }
    
    
}
