package jogo;

import java.awt.Color;
import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;
import jplay.Sound;
import java.awt.Font;
import java.util.Random;

public class Cenario1 {

    private Window janela;
    private Scene cena;
    private Jogador jogador;
    private Keyboard teclado;
    private Zumbi zumbi[];
    int numAleatorio;
    
    public Cenario1(Window window) {
        janela = window;
        cena = new Scene();
        cena.loadFromFile("src\\scn\\cenario1.scn");
        jogador = new Jogador(300, 300);
        teclado = janela.getKeyboard();
        zumbi = new Zumbi[35];
        janela.drawText("Energia: " + Jogador.energia, 30, 30, Color.GREEN);
        Som.play("src//audio//sound.mid");
        run();
    }

    private void run() {
        for (int i = 0; i < zumbi.length; i++){
           Random gerador = new Random();
           numAleatorio = gerador.nextInt(30);
           
            zumbi[i] = new Zumbi(250 *  numAleatorio, 200 *  numAleatorio);
        }
        
       
            
        
        while (true) {
            
            janela.setTitle("Resident Evil");
            janela.drawText("Energia: " + Jogador.energia, 0, 30, Color.GREEN);
            janela.update();
            jogador.mover(janela);
            jogador.energia(janela);
            cena.draw();
            jogador.draw();
            
            
            for (int i = 0; i < zumbi.length; i++){
            zumbi[i].perseguir(jogador.x, jogador.y);
            zumbi[i].mover(janela);
            zumbi[i].atacar(jogador);
            zumbi[i].draw();
            jogador.atirar(janela, cena, teclado, zumbi[i]);
            zumbi[i].morrer();
            }
            
        }

    }

}
