package javatpjeu2;
import net.slashie.libjcsi.ConsoleSystemInterface;
/**
* La class Mur, est un Sprite particulier prédéfini, et qui sera
solide (non traversable)
* @author coupr
*/
public class Mur extends Sprite {
    public Mur(int px, int py) {
        super(px,py,'▒',ConsoleSystemInterface.GRAY);
    }
    public boolean estSolide() {
        return true;
    }
}
