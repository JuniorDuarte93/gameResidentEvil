
package jogo;

import java.util.LinkedList;
import jplay.Scene;
import jplay.Sound;

/**
 *
 * @author mariajosineidedefrei
 */
public class ControleTiros {
    
    LinkedList<Tiro> tiros = new LinkedList<>();
    
    public void adicionaTiro(double x, double y, int caminho, Scene cena) {
        Tiro tiro = new Tiro(x, y, caminho);
        tiros.addFirst(tiro);
        cena.addOverlay(tiro);
        somDisparo();
        
    }
    
    public void run(Zumbi zumbi) {
        for (int i = 0; i < tiros.size(); i++) {
            Tiro tiro = tiros.removeFirst();
            tiro.mover();
            tiros.addLast(tiro);
             if(tiro.collided(zumbi)){
                 tiro.x = 10000;
                 zumbi.energia -= 250;
             }
        }
        
    }
    
    public void somDisparo() {
        new Sound("src//audio//tiro.wav").play();
    }
}
