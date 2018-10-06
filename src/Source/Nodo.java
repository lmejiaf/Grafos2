/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author lmejiaf
 */
public class Nodo {

    ArrayList<Arista> aristas = new ArrayList();
    String nombre;
    DefaultComboBoxModel<Nodo> adyacentes= new DefaultComboBoxModel();
    
    
    Graphics g;

    static final int DIAMETRO = 50, RADIO = DIAMETRO / 2;
    int posX, posY;

    public void conectar(Nodo llegada, double valor) {
        Arista a = new Arista(valor, this, llegada);
        aristas.add(a);
        adyacentes.addElement(llegada);
        
    }

    public void dibujar() {
        g.setColor(Color.red);
        g.fillOval(posX, posY, DIAMETRO, DIAMETRO);
    }

    public Nodo seleccionar() {
        g.setColor(Color.BLUE);
        g.fillOval(posX, posY, DIAMETRO, DIAMETRO);
        return this;
    }

    public void marcar() {
        g.setColor(Color.YELLOW);
        g.fillOval(posX, posY, DIAMETRO, DIAMETRO);
    }

    public Nodo(int posX, int posY) {
        this.posX = posX - RADIO;
        this.posY = posY - RADIO;
        g = Lienzo.lienzo.getGraphics();
        this.nombre = "";
        dibujar();
    }
    

}
