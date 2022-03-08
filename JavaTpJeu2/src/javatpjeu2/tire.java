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
public class tire extends Entity  {
    public tire(int px, int py) {
        super(px, py, '✵', ConsoleSystemInterface.RED);
    }
    
    

    public boolean estMangeable() {
        return false;
    }
    
}