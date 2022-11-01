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
    Enemigo roca = new Enemigo(this);
    Personaje personaje = new Personaje();
    
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

    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        ImageIcon fondo1 = new ImageIcon(getClass().getResource("../imagenes/fondo.png"));
        g.drawImage(fondo1.getImage(), 0, 0, getWidth(), getHeight(), this);
        
        Font score = new Font("Arial", Font.BOLD, 25);
        g.setFont(score);
        g.setColor(Color.blue);
        g.drawString("Puntaje: " + roca.obtenerPuntos(), 540, 50);
        g.drawString("Nivel: " + Enemigo.nivel, 540, 80);
        personaje.paint(g);
        roca.paint(g);
        roca.mover();
        g.dispose();
    }

    public static void main(String[]args){
        JFrame miVentana = new JFrame("Ball Game");
        Game game = new Game();
        miVentana.add(game);
        miVentana.setSize(700 , 700);
        miVentana.setVisible(true);
        miVentana.setResizable(false);
        miVentana.setLocationRelativeTo(null);
        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while(true){
            if (Enemigo.nivel > 5){
                if(Enemigo.nivel > 5){
                    JOptionPane.showMessageDialog(null, "Felicitaciones, has hecho " + Enemigo.puntos + " puntos");
                }
                int reiniciaJuego = JOptionPane.showConfirmDialog(null, "¿Quieres reiniciar el juego?", null, JOptionPane.YES_NO_OPTION);
                if(reiniciaJuego == 0){
                    reiniciaValores();
                }else if(reiniciaJuego == 1){
                    System.exit(0);
                }
            }
            try {
                //Hilo de 10ms que repinta nuestra aplcación.
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
            game.repaint();
        }
    }

    public static void reiniciaValores() {
        Enemigo.xRoca1 = 600;
        Enemigo.yRoca1 = 700;
        
        Enemigo.xRoca2 = 700;
        Enemigo.yRoca2 = 100;
        
        Enemigo.xRoca3 = -20;
        Enemigo.yRoca3 = 600;
        
        Enemigo.xRoca4 = 300;
        Enemigo.yRoca4 = -20;
        
        Enemigo.xRoca5 = 400;
        Enemigo.yRoca5 = 500;
        
        Enemigo.xRoca6 = -30;
        Enemigo.yRoca6 = 400;
        
        Personaje.x = 10;
        Personaje.y = 10;
        
        Enemigo.puntos = 0;
        Enemigo.nivel = 0;
        haChocado = false;
    }
}