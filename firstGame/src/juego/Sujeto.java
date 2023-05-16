package juego;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Sujeto{
    // Coordenadas posicionales
    public static int x = 10, y = 10; 
    
    // Dibujamos las figuras
    public void paint(Graphics g) {
        // Parámetros: drawImage(Img, x, y, width, height, observer);
        if(Obstacle.nivel == 1){
            ImageIcon meta = new ImageIcon(getClass().getResource("../images/planeta.png"));
            g.drawImage(meta.getImage(), 500, 500, 150, 150, null);

            ImageIcon personaje = new ImageIcon(getClass().getResource("../images/nave.png"));
            g.drawImage(personaje.getImage(), x, y, 100, 100, null);
        }
        if(Obstacle.nivel == 2){
            ImageIcon meta = new ImageIcon(getClass().getResource("../images/portal.png"));
            g.drawImage(meta.getImage(), 500, 500, 150, 150, null);

            ImageIcon personaje = new ImageIcon(getClass().getResource("../images/among.png"));
            g.drawImage(personaje.getImage(), x, y, 100, 100, null);
        }
        if(Obstacle.nivel == 3){
            ImageIcon meta = new ImageIcon(getClass().getResource("../images/blackhole.png"));
            g.drawImage(meta.getImage(), 500, 500, 150, 150, null);

            ImageIcon personaje = new ImageIcon(getClass().getResource("../images/alien.png"));
            g.drawImage(personaje.getImage(), x, y, 100, 100, null);
        }
        if(Obstacle.nivel == 4){
            ImageIcon meta = new ImageIcon(getClass().getResource("../images/manzana.png"));
            g.drawImage(meta.getImage(), 500, 500, 150, 150, null);

            ImageIcon personaje = new ImageIcon(getClass().getResource("../images/pacmanIcon.png"));
            g.drawImage(personaje.getImage(), x, y, 100, 100, null);
        }
        if(Obstacle.nivel == 5){
            ImageIcon meta = new ImageIcon(getClass().getResource("../images/botiquin.png"));
            g.drawImage(meta.getImage(), 500, 500, 150, 150, null);

            ImageIcon personaje = new ImageIcon(getClass().getResource("../images/dino.png"));
            g.drawImage(personaje.getImage(), x, y, 100, 100, null);
        }
        if(Obstacle.nivel == 6){
            ImageIcon meta = new ImageIcon(getClass().getResource("../images/arco.png"));
            g.drawImage(meta.getImage(), 500, 500, 150, 150, null);

            ImageIcon personaje = new ImageIcon(getClass().getResource("../images/pelota.png"));
            g.drawImage(personaje.getImage(), x, y, 100, 100, null);
        }
    }

    public void keyPressed(KeyEvent e){
        //Izquierda
        if (e.getKeyCode() == 37 | e.getKeyCode() == 65){
            if (x > 0){
                x -= 30;
            }
        }
        //Derecha
        if (e.getKeyCode() == 39 | e.getKeyCode() == 68){
            if (x < 580){
                x += 30;
            }
        }
        //Arriba
        if (e.getKeyCode() == 38 | e.getKeyCode() == 87){
            if (y > 0){
                y -= 30;
            }
        }
        //Abajo
        if (e.getKeyCode() == 40 | e.getKeyCode() == 83){
            if (y < 580){
                y += 30; 
            }
        }
        //Reinicio R
        if (e.getKeyCode() == 82){
            Game.reiniciaValores();          
        }
        //Salir ESC
        if (e.getKeyCode() == 27){          
            int exit = JOptionPane.showConfirmDialog(null, "¿Desea salir del juego?", null, JOptionPane.YES_NO_OPTION);
            if(exit == 0){
                System.exit(0);
            }                     
        }
        // Barra espaciadora - Aumento de vida con penalización de puntos
        if (e.getKeyCode() == 32){
            Obstacle.puntos += 4;
            Obstacle.vida += 1;   
        }
    }
   
    
    public Ellipse2D getAreaPersonaje(){
        // Parámetros: Double(x, y, width, height);
        return new Ellipse2D.Double(x + 10, y + 30, 80, 50);
    }

    public boolean llegaFinal(){
        Rectangle cuadrado = new Rectangle(520, 520, 110, 110);
        Area cuadradoArea = new Area(cuadrado);
        return cuadradoArea.contains(getAreaPersonaje().getBounds());
    }
}
