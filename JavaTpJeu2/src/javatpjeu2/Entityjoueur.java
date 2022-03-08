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
public class Entityjoueur extends Entity {
    private int score;
    private char direction;
    
    public Entityjoueur(int px, int py) {
        super(px, py, 'J',ConsoleSystemInterface.YELLOW);
        //direction = 'u';
    }

    public void display() {
        //▲ ► ▼ ◄
        char symbole = '░';
        
        switch(direction) {
            case 'l':symbole = '◄';break;
            case 'r':symbole = '►';break;
            case 'u':symbole = '▲';break;
            case 'd':symbole = '▼';break;
        }
        getCsi().print(getX(), getY(), symbole, getCouleur());
    }
    public boolean estMangeable() {
        return false;
    }
    public int getScore() {
        return -25;
    }
    public int getlife() {
        return -4;
    }
    
    
     public boolean moveLeft() {
        direction='l';
        return super.moveLeft();        
    }
    public boolean moveRight() {
        direction='r';
        return super.moveRight();        
    }
    public boolean moveUp() {
        direction='u';
        return super.moveUp();       
    }
    public boolean moveDown() {
        direction='d';
        return super.moveDown();       
    }
    

}