/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatpjeu2;

import java.util.Random;

/**
 *
 * @author thoma
 */
public class Niveau7 extends Niveau {
public Niveau7() {
super();
setNumNiveau(2);
}
@Override
public void generationAuto() {
System.out.println("Override");
for(int i=0;i<JavaTpJeu.maxX;i++) {
    for(int j=2;j<JavaTpJeu.maxY;j++) {
        addCase(new Mur(i,j));
    }
}
Sprite c = this.getCase(5, 5);
c = null;

//Génération des Pommes

}
}
