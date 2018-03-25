/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sprite;
import jplay.Window;

/**
 *
 * @author mariajosineidedefrei
 */
public class Jogador extends Sprite {
    private double velocidade = 0.7;
    private int direcao = 3;
    private Keyboard teclado;
    private boolean movendo = false;
    static double energia = 2000;
    static int Mortes = 0;
    
    public Jogador(int x, int y) {
        super(("src\\sprites\\jogador.png"), 20);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
    }
    
    ControleTiros tiros = new ControleTiros();
    public void atirar(Window janela, Scene cena, Keyboard teclado, Zumbi zumbi){
        if(teclado.keyDown(KeyEvent.VK_A)){
            tiros.adicionaTiro(x + 5, y + 11, direcao, cena);
        }
        tiros.run(zumbi);
    }
    
    public void mover(Window janela){
        if (teclado == null){
            teclado = janela.getKeyboard();
        }
        
        if(teclado.keyDown(Keyboard.LEFT_KEY)){
            if (this.x > 0){
                this.x -= velocidade ;
            }
            
            if(direcao != 1){
                setSequence(4, 8);
                direcao =1;
                
            }movendo = true;
            
        }else if(teclado.keyDown(Keyboard.RIGHT_KEY)){
             if (this.x < janela.getWidth() - 60){
                this.x += velocidade ;
            }
            
            if(direcao != 2){
                setSequence(8, 12);
                direcao =2;
                
            }movendo = true;
        }else if(teclado.keyDown(Keyboard.UP_KEY)){
             if (this.y >0){
                this.y -= velocidade ;
            }
            
            if(direcao != 4){
                setSequence(12, 16);
                direcao =4;
                
            }movendo = true;
        }else if(teclado.keyDown(Keyboard.DOWN_KEY)){
             if (this.y < janela.getHeight() - 60){
                this.y += velocidade ;
            }
            
            if(direcao != 5){
                setSequence(0, 4);
                direcao = 5;
                
            }movendo = true;
        }
    
    }
    
    Font f = new Font ("arial", Font.BOLD, 30);
        public void energia (Window janela){
            janela.drawText("Energia: " + Jogador.energia, 30, 30, Color.GREEN, f);
        }
    
}
