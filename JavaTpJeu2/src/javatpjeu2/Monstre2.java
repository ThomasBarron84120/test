package javatpjeu2;
import net.slashie.libjcsi.ConsoleSystemInterface;
/**
* Il s'agit d'une entité particuliere qui est scorable donc qui
donne des points au joueur si il marche dessus.
* On la fait bouger, c'est principalement pour montrer le
fonctionnement que pourrait avoir le déplacement d'une entité.
* Chaque type d'entité pourrait avoir sa propre logique de
mouvement
* @author coupr
*/
public class Monstre2 extends Entity implements Scorable,EntityJoueure {
public Monstre2(int px, int py) {
super(px, py, 'ж', ConsoleSystemInterface.CYAN);
}
public void moveRandom() {
double r = Math.random();
if(r<0.1) {
    moveLeft();
    moveLeft();
}
else if(r<=0.2) {
    moveRight();
    moveRight();
}
else if(r<=0.3){
    moveUp();
    moveUp();
}
else if(r<=0.4){
    moveDown();
    moveDown();
}
}
public void display() {
moveRandom();
super.display();
}
public boolean estMangeable() {
return false;
}
public int getScore() {
return -100;
}
public int getlife() {
return -6;
}

}