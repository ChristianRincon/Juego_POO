package juego;

import java.awt.Graphics;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;


public class Obstacle{
    
    public static int xRoca1 = 600, yRoca1 = 700;
    public static int xRoca2 = 700, yRoca2 = 100;
    public static int xRoca3 = -20, yRoca3 = 600;
    public static int xRoca4 = 300, yRoca4 = -20;
    public static int xRoca5 = 400, yRoca5 = 500;
    public static int xRoca6 = -30, yRoca6 = 400;

    public static int puntos = 0;
    public static int vida = 3;
    public static int nivel = 1;
    int incremento = 2;
    public Game jugar;
    Sound sonido = new Sound();

    Area r1, r2, r3, r4, r5, r6, rocaArea;

    int inicioX = 0;
    int inicioY = 0;  
    int finX = 700;
    int finY = 700;
    
    public Obstacle(Game _jugar){  
        this.jugar = _jugar;
    }

    public void paint(Graphics g){
        ImageIcon asteroide = new ImageIcon(getClass().getResource("../images/asteroide.png"));
        ImageIcon fuego = new ImageIcon(getClass().getResource("../images/fuego.png"));
        ImageIcon triangulo = new ImageIcon(getClass().getResource("../images/triangulo.png"));
        ImageIcon triangulo1 = new ImageIcon(getClass().getResource("../images/triangulo1.png"));
        ImageIcon triangulo2 = new ImageIcon(getClass().getResource("../images/triangulo2.png"));
        ImageIcon fantasma = new ImageIcon(getClass().getResource("../images/fantasma.png"));
        ImageIcon fuegoVolcan = new ImageIcon(getClass().getResource("../images/fuegoVolcan.png"));
        ImageIcon portero = new ImageIcon(getClass().getResource("../images/portero.png"));

        
        if (nivel == 1){
            g.drawImage(asteroide.getImage(), xRoca1, yRoca1, 48, 48, null);
        }
        if (nivel == 2){
            g.drawImage(fuego.getImage(), xRoca1, yRoca1, 48, 48, null);
            g.drawImage(fuego.getImage(), xRoca2, yRoca2, 48, 48, null);
        }
        if (nivel == 3){
            g.drawImage(triangulo.getImage(), xRoca1, yRoca1, 48, 48, null);
            g.drawImage(triangulo1.getImage(), xRoca2, yRoca2, 48, 48, null);
            g.drawImage(triangulo2.getImage(), xRoca3, yRoca3, 48, 48, null);          
        }
        if (nivel == 4){
            g.drawImage(fantasma.getImage(), xRoca1, yRoca1, 48, 48, null);
            g.drawImage(fantasma.getImage(), xRoca2, yRoca2, 48, 48, null);
            g.drawImage(fantasma.getImage(), xRoca3, yRoca3, 48, 48, null); 
            g.drawImage(fantasma.getImage(), xRoca4, yRoca4, 48, 48, null);
        }
        if (nivel == 5){
            g.drawImage(fuegoVolcan.getImage(), xRoca1, yRoca1, 48, 48, null);
            g.drawImage(fuegoVolcan.getImage(), xRoca2, yRoca2, 48, 48, null);
            g.drawImage(fuegoVolcan.getImage(), xRoca3, yRoca3, 48, 48, null); 
            g.drawImage(fuegoVolcan.getImage(), xRoca4, yRoca4, 48, 48, null);
            g.drawImage(fuegoVolcan.getImage(), xRoca5, yRoca5, 48, 48, null);
        }
        if (nivel == 6){
            g.drawImage(portero.getImage(), xRoca1, yRoca1, 48, 48, null);
            g.drawImage(portero.getImage(), xRoca2, yRoca2, 48, 48, null);
            g.drawImage(portero.getImage(), xRoca3, yRoca3, 48, 48, null); 
            g.drawImage(portero.getImage(), xRoca4, yRoca4, 48, 48, null);
            g.drawImage(portero.getImage(), xRoca5, yRoca5, 48, 48, null);
            g.drawImage(portero.getImage(), xRoca6, yRoca6, 48, 48, null);
        }
    }
         
    public boolean choque(){
        if(Sujeto.x == 10 & Sujeto.y == 10){
            return false; //Evitamos colisión con enemigo cuando nuestro personaje vuelve a la posición inicial
        }
        Area areaPersonaje = new Area(jugar.personaje.getAreaPersonaje());
        areaPersonaje.intersect(getAreaEnemy());    
        return !areaPersonaje.isEmpty();  
    }
    
    public void mover(){
        
        if (choque()){          
            sonido.sound("../sounds/golpe.mp3");
            vida -= 1;
            Sujeto.x = 10;
            Sujeto.y = 10;
            if(vida == 0){
                Game.haChocado = true;
            }
        }
        if (nivel == 1 && jugar.personaje.llegaFinal()){
            nivel++;
            Sujeto.x = 10;
            Sujeto.y = 10;
            sonido.sound("../sounds/levelOne.mp3");
        }
        if ((nivel == 2 | nivel == 3 | nivel == 5) && jugar.personaje.llegaFinal()){
            nivel++;
            Sujeto.x = 10;
            Sujeto.y = 10;
            sonido.sound("../sounds/levels.mp3");
        }
        if (nivel == 4 && jugar.personaje.llegaFinal()){
            nivel++;
            Sujeto.x = 10;
            Sujeto.y = 10;
            sonido.sound("../sounds/final.mp3");
        }
        if (nivel == 6 && jugar.personaje.llegaFinal()){
            nivel++;
            Sujeto.x = 10;
            Sujeto.y = 10;
            sonido.sound("../sounds/futbol.mp3");
        }
               
        if (nivel >= 1){
            if (yRoca1 == -20){
                yRoca1 = 700;
                xRoca1 = (int) (Math.random() * (finX - inicioX) + inicioX);
                puntos++;
            }else{
                xRoca1 -= incremento + 1;
                yRoca1 -= incremento + 1;           
            }
        }
        if (nivel >= 2){
            if (xRoca2 == -20){
                xRoca2 = 700;
                yRoca2 = (int) (Math.random() * (finY - inicioY) + inicioY);
                puntos++;
            }else{
                xRoca2 -= incremento + 2;
            }
        }
        if (nivel >= 3){
            if (xRoca3 == 700){
                xRoca3 = -20;
                yRoca3 = (int) (Math.random() * (finY - inicioY) + inicioY);
                puntos++;
            }else{
                xRoca3 += incremento + 3;
            }
        }
        if (nivel >= 4){
            if (xRoca4 == 700){
                yRoca4 = -20;
                xRoca4 = (int) (Math.random() * (finX - inicioX) + inicioX);
                puntos++;
            }else{
                yRoca4 += incremento + 4;
            }
        }
        if (nivel >= 5){
            if (xRoca5 == -20){
                yRoca5 = 700;
                xRoca5 = (int) (Math.random() * (finX - inicioX) + inicioX);
                puntos++;
            }else{
                yRoca5 += incremento + 5;
            }
        }
        if (nivel >= 6){
            if (xRoca6 == -20){
                yRoca6 = 700;
                xRoca6 = (int) (Math.random() * (finX - inicioX) + inicioX);
                puntos++;
            }else{
                yRoca6 -= incremento + 6;
            }
        }
    }

    public int obtenerPuntos(){
        return puntos;
    }

    public Area getAreaEnemy(){

        Ellipse2D enemigo1, enemigo2, enemigo3, enemigo4, enemigo5, enemigo6;

        enemigo6 = new Ellipse2D.Double(xRoca6, yRoca6, 48, 48);
        r6 = new Area(enemigo6);
        rocaArea = r6;

        if (nivel >= 1){
            enemigo1 = new Ellipse2D.Double(xRoca1, yRoca1, 48, 48);
            r1 = new Area(enemigo1);
            rocaArea.add(r1);
        }
        if (nivel >= 2){
            enemigo2 = new Ellipse2D.Double(xRoca2, yRoca2, 48, 48);
            r2 = new Area(enemigo2);
            rocaArea.add(r2);
        }
        if (nivel >= 3){
            enemigo3 = new Ellipse2D.Double(xRoca3, yRoca3, 48, 48);
            r3 = new Area(enemigo3);
            rocaArea.add(r3);
        }
        if (nivel >= 4){
            enemigo4 = new Ellipse2D.Double(xRoca4, yRoca4, 48, 48);
            r4 = new Area(enemigo4);
            rocaArea.add(r4);
        }
        if (nivel >= 5){
            enemigo5 = new Ellipse2D.Double(xRoca5, yRoca5, 48, 48);
            r5 = new Area(enemigo5);
            rocaArea.add(r5);
        }
        if (nivel >= 6){
            enemigo6 = new Ellipse2D.Double(xRoca6, yRoca6, 48, 48);
            r6 = new Area(enemigo6);
            rocaArea.add(r6);
        }
        return rocaArea;
    }
}
