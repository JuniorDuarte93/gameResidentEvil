package jogo;

import java.awt.Image;
import jplay.Window;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.Sound;

public class Jogo {

    public static void main(String[] args) {

        Window janela = new Window(800, 600);
        GameImage plano = new GameImage("src//sprites//menu_1.png");
        Keyboard teclado = janela.getKeyboard();
        new Sound("src//audio//menu.wav").play();

        while (true) {
            janela.setTitle("Resident Evil - Menu");
            plano.draw();
            janela.update();

            if (teclado.keyDown(Keyboard.ENTER_KEY)) {
                new Sound("src//audio//risada.wav").play();
                new Cenario1(janela);
            }

        }

    }

}
