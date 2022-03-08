package javatpjeu2;
import net.slashie.libjcsi.ConsoleSystemInterface;
/**
* La class Mur, est un Sprite particulier prédéfini, et qui sera
solide (non traversable)
* @author coupr
*/
public class Mur2 extends Sprite {
    public Mur2(int px, int py) {
        super(px,py,'▦',ConsoleSystemInterface.PURPLE);
    }
    public boolean estSolide() {
        return true;
    }
}
