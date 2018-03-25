/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogo;


import jplay.Sprite;


/**
 *
 * @author mariajosineidedefrei
 */
public class Tiro extends Sprite {
    
    public static final int LEFT = 1, RIGHT = 2, STOP = 3, UP = 4, DOWN = 5;
    
    protected static final int VELOCIDADE_TIRO = 5;
    protected int  caminho = STOP;
    protected boolean movendo = false;
    protected int direcao = 3;
    
    public Tiro(double x, double y, int caminho) {
            super(("src\\sprites\\flecha.png"), 12);
            this.caminho = caminho;
            this.x = x;
            this.y = y;
    }
    
    
     public void mover(){
        if (caminho == LEFT){
           this.x -= VELOCIDADE_TIRO;
           
           if (direcao !=1){
               setSequence(3, 6);
           } movendo = true;
        }
        
        if (caminho == RIGHT){
           this.x += VELOCIDADE_TIRO;
           
           if (direcao != 2){
               setSequence(6, 9);
           } movendo = true;
        }
        
        if (caminho == UP){
           this.y -= VELOCIDADE_TIRO;
           
           if (direcao != 4){
               setSequence(9, 12);
           } movendo = true;
        }
        
        
        if (caminho == DOWN  || caminho == STOP){
           this.y += VELOCIDADE_TIRO;
           
           if (direcao != 5){
               setSequence(0, 3);
           } movendo = true;
        }
        
        if(movendo){
            update();
            movendo = false;
        }
        
     }
        
    
    
    
}
