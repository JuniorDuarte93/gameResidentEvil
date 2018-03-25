/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;

import java.awt.event.KeyEvent;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Sprite;
import jplay.Window;

/**
 *
 * @author mariajosineidedefrei
 */
public class Zumbi extends Sprite {
    
    private double ataque = 1;
    private double velocidade = 0.3;
    private int direcao = 3;
    private Keyboard teclado;
    private boolean movendo = false;
    public double energia = 1000;
    
    public Zumbi(int x, int y) {
        super(("src\\sprites\\zumbi.png"), 16);
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
        this.velocidade = 0.1;
    }
    
    
    public void morrer(){
        if(this.energia <= 0){
            this.velocidade = 0;
            this.ataque = 0;
            this.direcao = 0;
            this.movendo = false;
            this.x = 1000000000;
        }
    }
    
    public void atacar(Jogador jogador){
        if(this.collided(jogador)){
            Jogador.energia -= this.ataque;
        }
        
        if (Jogador.energia <= 0){
            System.exit(0);
        }
    }
    
   
    
    
    public void perseguir(double x, double y){
        if(this.x > x && this.y <= y + 50 && this.y >= y - 50){
            moveTo(x, y, velocidade);
            if(direcao != 1){
                setSequence(5, 8);
                direcao = 1;
            }  movendo = true;
        } else if(this.x < x &&  this.y <= y + 50 && this.y >= -50){
            moveTo(x, y, velocidade);
            if(direcao != 2){
                setSequence(9, 12);
                direcao = 2;
            }  movendo = true;
            
        } else if(this.y > y){
            moveTo(x, y, velocidade);
            if(direcao != 4){
                setSequence(13, 16);
                direcao = 4;
            }  movendo = true;
            
        }else if(this.y < y){
            moveTo(x, y, velocidade);
            if(direcao != 5){
                setSequence(1, 4);
                direcao = 5;
            }  movendo = true;
            
        } if (movendo){
            update();
            movendo = false;
        }
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
    
}
