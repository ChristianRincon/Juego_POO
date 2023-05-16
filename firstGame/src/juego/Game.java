package juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Game extends JPanel{
    public static boolean haChocado = false;
    Obstacle roca = new Obstacle(this);
    Sujeto personaje = new Sujeto();
    Time tiempo = new Time();
    
    // Interface para captura de teclas
    public Game(){
        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                personaje.keyPressed(e);              
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }           
        });
        setFocusable(true);
    }
    // Interface para figuras, fondos y textos
    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        if(Obstacle.nivel == 1){
            ImageIcon espacio = new ImageIcon(getClass().getResource("../images/espacio.jpg"));
            g.drawImage(espacio.getImage(), 0, 0, getWidth(), getHeight(), this);   
            Font score = new Font("Arial", Font.BOLD, 25);
            g.setFont(score);
            g.setColor(Color.yellow);
            g.drawString("Puntaje: " + roca.obtenerPuntos(), 540, 50);
            g.setColor(Color.yellow);
            g.drawString("Nivel: " + Obstacle.nivel, 540, 80);
            g.setColor(Color.red);
            g.drawString("Vidas: " + Obstacle.vida, 540, 110);  
            g.setColor(Color.red);
            g.drawString(tiempo.minutos() + " : " + tiempo.segundos(), 280, 50); 
        }
        if(Obstacle.nivel == 2){
            ImageIcon paisaje = new ImageIcon(getClass().getResource("../images/paisaje.png"));
            g.drawImage(paisaje.getImage(), 0, 0, getWidth(), getHeight(), this);
            Font score = new Font("Arial", Font.BOLD, 25);
            g.setFont(score);
            g.setColor(Color.yellow);
            g.drawString("Puntaje: " + roca.obtenerPuntos(), 540, 50);
            g.setColor(Color.red);
            g.drawString("Nivel: " + Obstacle.nivel, 540, 80);
            g.setColor(Color.red);
            g.drawString("Vidas: " + Obstacle.vida, 540, 110);          
        }
        if(Obstacle.nivel == 3){
            ImageIcon dark = new ImageIcon(getClass().getResource("../images/dark.png"));
            g.drawImage(dark.getImage(), 0, 0, getWidth(), getHeight(), this);
            Font score = new Font("Arial", Font.BOLD, 25);
            g.setFont(score);
            g.setColor(Color.yellow);
            g.drawString("Puntaje: " + roca.obtenerPuntos(), 540, 50);
            g.setColor(Color.yellow);
            g.drawString("Nivel: " + Obstacle.nivel, 540, 80);
            g.setColor(Color.red);
            g.drawString("Vidas: " + Obstacle.vida, 540, 110);    
        }
        if(Obstacle.nivel == 4){
            ImageIcon pacman = new ImageIcon(getClass().getResource("../images/pacman.png"));
            g.drawImage(pacman.getImage(), 0, 0, getWidth(), getHeight(), this);
            Font score = new Font("Arial", Font.BOLD, 25);
            g.setFont(score);
            g.setColor(Color.yellow);
            g.drawString("Puntaje: " + roca.obtenerPuntos(), 540, 50);
            g.setColor(Color.yellow);
            g.drawString("Nivel: " + Obstacle.nivel, 540, 80);
            g.setColor(Color.red);
            g.drawString("Vidas: " + Obstacle.vida, 540, 110);    
        }
        if(Obstacle.nivel == 5){
            ImageIcon volcan = new ImageIcon(getClass().getResource("../images/volcan.jpg"));
            g.drawImage(volcan.getImage(), 0, 0, getWidth(), getHeight(), this);
            Font score = new Font("Arial", Font.BOLD, 25);
            g.setFont(score);
            g.setColor(Color.yellow);
            g.drawString("Puntaje: " + roca.obtenerPuntos(), 540, 50);
            g.setColor(Color.yellow);
            g.drawString("Nivel: " + Obstacle.nivel, 540, 80);
            g.setColor(Color.red);
            g.drawString("Vidas: " + Obstacle.vida, 540, 110);    
        }
        if(Obstacle.nivel == 6){
            ImageIcon cancha = new ImageIcon(getClass().getResource("../images/cancha.jpg"));
            g.drawImage(cancha.getImage(), 0, 0, getWidth(), getHeight(), this);
            Font score = new Font("Arial", Font.BOLD, 25);
            g.setFont(score);
            g.setColor(Color.yellow);
            g.drawString("Puntaje: " + roca.obtenerPuntos(), 540, 50);
            g.setColor(Color.yellow);
            g.drawString("Nivel: " + Obstacle.nivel, 540, 80);
            g.setColor(Color.red);
            g.drawString("Vidas: " + Obstacle.vida, 540, 110);    
        }
               
        /*Font score = new Font("Arial", Font.BOLD, 25);
        g.setFont(score);
        g.setColor(Color.blue);
        g.drawString("Puntaje: " + roca.obtenerPuntos(), 540, 50);
        g.setColor(Color.blue);
        g.drawString("Nivel: " + Obstacle.nivel, 540, 80);
        g.setColor(Color.red);
        g.drawString("Vidas: " + Obstacle.vida, 540, 110);*/
        personaje.paint(g);
        roca.paint(g);
        roca.mover();
        g.dispose();
    }
   
    public static void main(String[]args){
        JFrame miVentana = new JFrame("Scape Game");
        Game game = new Game();
        Sound sonido = new Sound();
        miVentana.add(game);
        miVentana.setSize(700 , 700);
        miVentana.setVisible(true);
        miVentana.setResizable(false);
        miVentana.setLocationRelativeTo(null);        
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        while(true){
            if (haChocado | Obstacle.nivel > 6){
                // Si vida llega a cero
                if(haChocado){
                    sonido.sound("../sounds/gameOver.mp3");
                    JOptionPane.showMessageDialog(null, "Perdiste. Haz hecho " + Obstacle.puntos + " puntos");
                }
                // Si superamos nivel 5
                if(Obstacle.nivel > 5){
                    JOptionPane.showMessageDialog(null, "Felicitaciones, has hecho " + Obstacle.puntos + " puntos");
                }
                int reiniciaJuego = JOptionPane.showConfirmDialog(null, "¿Quieres reiniciar el juego?", null, JOptionPane.YES_NO_OPTION);
                // Opción de reinicio
                if(reiniciaJuego == 0){
                    reiniciaValores();
                // Opción de salida
                }else if(reiniciaJuego == 1){
                    System.exit(0);
                }
            }
           // Hilo de procesos
            try {
                Thread.sleep(8);
            }catch (InterruptedException ex){
                System.out.println(ex.toString());
            }
         
            game.repaint();
        }
    }
    // Reestablecemos valores
    public static void reiniciaValores() {
        Obstacle.xRoca1 = 600;
        Obstacle.yRoca1 = 700;
        Obstacle.xRoca2 = 700;
        Obstacle.yRoca2 = 100;
        Obstacle.xRoca3 = -20;
        Obstacle.yRoca3 = 600;
        Obstacle.xRoca4 = 300;
        Obstacle.yRoca4 = -20;
        Obstacle.xRoca5 = 400;
        Obstacle.yRoca5 = 500;
        Obstacle.xRoca6 = -30;
        Obstacle.yRoca6 = 400;
        Sujeto.x = 10;
        Sujeto.y = 10;
        Obstacle.nivel = 1;
        haChocado = false;
        Obstacle.puntos = 0;
        Obstacle.vida = 3;
        Time.segundos = 0;
        Time.minutos = 0; 
    }
}
