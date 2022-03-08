/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatpjeu2;

import net.slashie.libjcsi.ConsoleSystemInterface;

/**
 *
 * @author thoma
 */
public class Entityitem_portail extends Sprite {
    public Entityitem_portail(int px, int py ) {
        super(px,py,'▒',ConsoleSystemInterface.LEMON);
    }
    public boolean estSolide() {
        return true;
    }
}