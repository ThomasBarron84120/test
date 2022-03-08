package javatpjeu2;
import java.util.Random;
/**
* Classe de représentation du niveau 1, la fonction de
generationAuto est surchargé pour générer un level spécifique
* Avec un nombre de pommes déterminé
* @author coupr
*/
public class tire2 extends Niveau {
public tire2() {
super();
setNumNiveau(3);
}
public void trire() {

//Génération des Pommes
int x=new Random().nextInt(JavaTpJeu.maxX);
int y=new Random().nextInt(JavaTpJeu.maxY);
tire t= new tire(x,y);
addEntity(t);

}
}

   
