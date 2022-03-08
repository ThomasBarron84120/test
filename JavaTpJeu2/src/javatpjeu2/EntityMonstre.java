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
public class EntityMonstre extends Entity implements Scorable,EntityJoueure {
    public EntityMonstre(int px, int py) {
        super(px, py, '☫', ConsoleSystemInterface.DARK_BLUE);
    }
    public void moveRandom() {
        double r = Math.random();
        if(r<0.1) moveLeft();
        else if(r<=0.2) moveRight();
        else if(r<=0.3) moveUp();
        else if(r<=0.4) moveDown();
    }
    public void display() {
        moveRandom();
        super.display();
    }
    public boolean estMangeable() {
        return false;
    }
    public int getScore() {
        return -50;
    }
    public int getlife() {
        return -4;
    }

}