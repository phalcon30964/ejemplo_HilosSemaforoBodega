/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class Programa {

    public static void main(String main[]) {

        Bodega bodega = new Bodega();

        Descargador pEmpacador = new Descargador(bodega);
        Empacador pMensajero = new Empacador(bodega);


        pEmpacador.start();
        pMensajero.start();
       
    }
}
