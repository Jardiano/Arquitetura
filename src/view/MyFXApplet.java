/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;



/**
 *
 * @author Administrator
 */
public class MyFXApplet extends JAppletFX {
    // protected fields scene & root are available

    @Override
    public void initApplet() {
        // this method is called once applet has been loaded & JavaFX has been set-up
        TelaPrincipal tela = new TelaPrincipal();
        tela.setVisible(true);
    }

}
