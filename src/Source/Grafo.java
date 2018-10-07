/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Source;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author lmejiaf
 */
public class Grafo {

    ArrayList<Nodo> nodos = new ArrayList();
    private final DefaultComboBoxModel<Nodo> modeloNodos = new DefaultComboBoxModel<>();

    public void add(String nombre, int px, int py) {
        boolean add = true;
        for (Nodo nodo : nodos) {
            if ((px > nodo.posX - Nodo.DIAMETRO && px < nodo.posX + 2 * Nodo.DIAMETRO && py > nodo.posY - Nodo.DIAMETRO && py < nodo.posY + 2 * Nodo.DIAMETRO)) {
//                || px + Nodo.RADIO > Lienzo.lienzo.getWidth() || py + Nodo.RADIO > Lienzo.lienzo.getHeight() || py < 0
                add = false;
            }
        }
        if (add == true && Lienzo.conectando == false) {
//estado de adicion
            Nodo n = new Nodo("Luis", px, py);
            nodos.add(n);
            modeloNodos.addElement(n);
        }
//        } else if (seleccionar(px, py)) {
////estado de conexion
//            Lienzo.conectando = true;
//        } else {
//            Lienzo.conectando = false;
//            redibujar();
//        }

    }

    public DefaultComboBoxModel<Nodo> getModeloNodos() {
        return modeloNodos;
    }

    public void redibujar() {

        Lienzo.lienzo.getGraphics().clearRect(0, 0, Lienzo.lienzo.getWidth(), Lienzo.lienzo.getHeight());

        nodos.forEach((nodo) -> {
            nodo.dibujar();
        });
    }

    public void seleccionar(int px, int py) {
        Nodo a = null;
        for (Nodo nodo : nodos) {
            if ((px > nodo.posX && px < nodo.posX + Nodo.DIAMETRO && py > nodo.posY && py < nodo.posY + Nodo.DIAMETRO)) {
                a = nodo.seleccionar();
                Lienzo.nombreNodo.setText(a.nombre);
                Lienzo.listaAdyacentes.setModel(a.adyacentes);
            }
        }
        if (a != null) {
            for (Nodo nodo : nodos) {
                if (a != nodo) {
                    nodo.marcar();

                }
            }
        }
//       
    }

    public Nodo buscar(int px, int py) {

        for (Nodo nodo : nodos) {
            if ((px > nodo.posX && px < nodo.posX + Nodo.DIAMETRO && py > nodo.posY && py < nodo.posY + Nodo.DIAMETRO)) {
                return nodo;
            }
        }

        return null;
    }

}
