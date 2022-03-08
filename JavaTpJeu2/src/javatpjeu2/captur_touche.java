/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatpjeu2;

import net.slashie.libjcsi.CharKey;

/**
 *
 * @author thoma
 */
public class captur_touche {
    private int touche ;
    public captur_touche(int input) {
        this.touche = input;
    }
    public String la_touche() {
        String var ="";
        switch(touche) {
                case CharKey.a: var ="a";  break;
                case CharKey.z: var ="z";  break;
                case CharKey.e: var ="e";  break;
                case CharKey.r: var ="r";  break;
                case CharKey.t: var ="t";  break;
                case CharKey.y: var ="y";  break;
                case CharKey.u: var ="u";  break;
                case CharKey.i: var ="i";  break;
                case CharKey.o: var ="o";  break;
                case CharKey.p: var ="p";  break;
                case CharKey.q: var ="q";  break;
                case CharKey.s: var ="s";  break;
                case CharKey.d: var ="d";  break;
                case CharKey.f: var ="f";  break;
                case CharKey.g: var ="g";  break;
                case CharKey.h: var ="h";  break;
                case CharKey.j: var ="j";  break;
                case CharKey.k: var ="k";  break;
                case CharKey.l: var ="l";  break;
                case CharKey.m: var ="m";  break;
                case CharKey.w: var ="w";  break;
                case CharKey.x: var ="x";  break;
                case CharKey.c: var ="c";  break;
                case CharKey.v: var ="v";  break;
                case CharKey.b: var ="b";  break;
                case CharKey.n: var ="n";  break;
                case CharKey.N1: var ="1";  break; 
                case CharKey.N2: var ="2";  break; 
                case CharKey.N3: var ="3";  break; 
                case CharKey.N4: var ="4";  break; 
                case CharKey.N5: var ="5";  break; 
                case CharKey.N6: var ="6";  break; 
                case CharKey.N7: var ="7";  break; 
                case CharKey.N8: var ="8";  break; 
                case CharKey.N9: var ="9";  break;
                
        }
        return var;
    }
    
}
