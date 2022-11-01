package juego;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;

public class Personaje {
    public static int x = 10, y = 10;

    public void paint(Graphics g) {
        
        /*if (Enemigo.nivel % 2 == 1){
            ImageIcon meta = new ImageIcon(getClass().getResource("../imagenes/aro.png"));
            g.drawImage(meta.getImage(), 500, 500, 150, 150, null);
        }    
        if (Enemigo.nivel % 2 == 0){
            ImageIcon meta = new ImageIcon(getClass().getResource("../imagenes/aro.png"));
            g.drawImage(meta.getImage(), 90, 500, 150, 150, null);
        }*/
        ImageIcon meta = new ImageIcon(getClass().getResource("../imagenes/aro.png"));
            g.drawImage(meta.getImage(), 500, 500, 150, 150, null);
            
        ImageIcon personaje = new ImageIcon(getClass().getResource("../imagenes/ball.png"));
        g.drawImage(personaje.getImage(), x, y, 100, 100, null);
    }

    public void keyPressed(KeyEvent e){       
        //Izquierda
        if (e.getKeyCode() == 37 | e.getKeyCode() == 65){
            if (x > 0){
                x -= 20;
            }
        }
        //Derecha
        if (e.getKeyCode() == 39 | e.getKeyCode() == 68){
            if (x <= 580){
                x += 20;
            }
        }
        //Arriba
        if (e.getKeyCode() == 38 | e.getKeyCode() == 87){
            if (y > 0){
                y -= 20;
            }
        }
        //Abajo
        if (e.getKeyCode() == 40 | e.getKeyCode() == 83){
            if (y < 580){
                y += 20;
            }
        }
    }

    public Ellipse2D getAreaPersonaje(){
        return new Ellipse2D.Double(x + 10, y + 30, 80, 50);
    }

    public boolean llegaFinal(){
        /*if (Enemigo.nivel % 2 == 0){
            Rectangle cuadrado = new Rectangle(110, 520, 110, 110);
            Area cuadradoArea = new Area(cuadrado);
            return cuadradoArea.contains(getBoundsPersonaje().getBounds());
        }*/
        Rectangle cuadrado = new Rectangle(520, 520, 110, 110);
        Area cuadradoArea = new Area(cuadrado);
        return cuadradoArea.contains(getAreaPersonaje().getBounds());
    }
}
