/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatpjeu2;

/**
 *
 * @author thoma
 */
public class Tableaux_jeux {
    
   
    private int  x_Tableaux;
    private int  y_Tableaux;
    public int[][] matrice=new int[JavaTpJeu.maxX][JavaTpJeu.maxY];
    public Tableaux_jeux(int xt,int yt) {
        this.x_Tableaux = xt;
        this.y_Tableaux = yt;
    }
    
    public int[][] generationTableaux() {
        //for(int i=0; i < x_Tableaux ;i++) {
        //    int ligne[] =new int[y_Tableaux];
        //    for(int j=0; j < y_Tableaux ;j++) {
        //        ligne[j]=0;
        //    }
        //    matrice[i]=ligne;
        //
        //}
        System.out.println(JavaTpJeu.maxX+"x");
        System.out.println(JavaTpJeu.maxY+"y");
        System.out.println(x_Tableaux+"x");
        System.out.println(y_Tableaux+"y");
        for (int i = 0; i < x_Tableaux; i++) {
          for (int j = 0; j < y_Tableaux; j++) {
            matrice[i][j]=0;
          }
        }
            
// tableau [1] de int
        return matrice;
    }
    public void Tableauxvisiter(int x,int y) {
        matrice[x][y]=1;
    }
    public void Tableauxmur(int x,int y) {
        matrice[x][y]=2;
    }
}
