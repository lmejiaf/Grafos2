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
    DefaultComboBoxModel<Nodo> adyacentes = new DefaultComboBoxModel();
    boolean seleccionado = false, marcado = false, marcadoParaConectar = false;
    Graphics g;

    static final int DIAMETRO = 50, RADIO = DIAMETRO / 2;
    int posX, posY;
    int centro[] = {posX + RADIO, posY + RADIO};

    public void conectar(Nodo llegada, double valor) {
        Arista a = new Arista(valor, this, llegada);
        aristas.add(a);
        adyacentes.addElement(llegada);

    }

    public void dibujar() {

        aristas.forEach((arista) -> {
            arista.dibujar();
        });

        g.setColor(Color.red);
        g.fillOval(posX, posY, DIAMETRO, DIAMETRO);
        g.setColor(Color.WHITE);
        g.drawString(nombre, posX + RADIO, posY + RADIO);

    }

    public Nodo seleccionar() {
        seleccionado = true;
        g.setColor(Color.BLUE);
        g.drawOval(posX, posY, DIAMETRO, DIAMETRO);
        Lienzo.conectando = true;
        return this;
    }

    public void quitarSeleccion() {
        seleccionado = false;
        g.setColor(Color.red);
        g.fillOval(posX, posY, DIAMETRO, DIAMETRO);
        g.drawString(nombre, posX + RADIO, posY + RADIO);

    }

    public void marcar() {
        marcado = true;
        g.setColor(Color.YELLOW);
        g.drawOval(posX, posY, DIAMETRO, DIAMETRO);
    }

    public void quitarMarca() {
        marcado = false;
        g.setColor(Color.red);
        g.fillOval(posX, posY, DIAMETRO, DIAMETRO);
        g.drawString(nombre, posX + RADIO, posY + RADIO);
    }

    public void marcarParaConectar() {
        marcadoParaConectar = true;
        g.setColor(Color.GREEN);
        g.drawOval(posX, posY, DIAMETRO, DIAMETRO);
    }

    public void quitarMarcaParaConectar() {
        marcadoParaConectar = false;
        g.setColor(Color.red);
        g.fillOval(posX, posY, DIAMETRO, DIAMETRO);
        g.drawString(nombre, posX + RADIO, posY + RADIO);
    }

    public Nodo(String nombre, int posX, int posY) {
        this.posX = posX - RADIO;
        this.posY = posY - RADIO;
        g = Lienzo.lienzo.getGraphics();
        this.nombre = nombre;
        dibujar();
    }

}
