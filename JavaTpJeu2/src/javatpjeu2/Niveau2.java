package javatpjeu2;
import java.util.Random;
/**
* Classe de représentation du niveau 1, la fonction de
generationAuto est surchargé pour générer un level spécifique
* Avec un nombre de pommes déterminé
* @author coupr
*/
public class Niveau2 extends Niveau {
public Niveau2() {
super();
setNumNiveau(2);
}
@Override
public void generationAuto() {
System.out.println("Override");
for(int

i=JavaTpJeu.minX,j=JavaTpJeu.minY;i<JavaTpJeu.maxX;i++) {

if(i%11-1!=0) {
addCase(new Mur(i,j));
addCase(new Mur(JavaTpJeu.maxX-i-1,j));
}
if(++j >= JavaTpJeu.maxY) j=JavaTpJeu.minY;
}
//Génération des Pommes
int nbPommes=15;
while(nbPommes > 0) {
    int x=new Random().nextInt(JavaTpJeu.maxX);
    int y=new Random().nextInt(JavaTpJeu.maxY);
    if(x >= JavaTpJeu.minX && x < JavaTpJeu.maxX && y >=JavaTpJeu.minY && y < JavaTpJeu.maxY) {
        Sprite c = this.getCase(x, y);
        System.out.println(x+","+y);
        if(c == null || !c.estSolide()) {
            EntityPomme p= new EntityPomme(x,y);
            p.setNiveau(this);
            addEntity(p);
            nbPommes--;
        }
    }
}
int nbmonstre=70;
while(nbmonstre > 0) {
    int x=new Random().nextInt(JavaTpJeu.maxX);
    int y=new Random().nextInt(JavaTpJeu.maxY);
    if(x >= JavaTpJeu.minX && x < JavaTpJeu.maxX && y >=JavaTpJeu.minY && y < JavaTpJeu.maxY) {
        Sprite c = this.getCase(x, y);
        System.out.println(x+","+y);
        if(c == null || !c.estSolide()) {
            EntityMonstre p= new EntityMonstre(x,y);
            p.setNiveau(this);
            addEntity(p);
            nbmonstre--;
        }
    }
}
int nbEntityitem1=10;
while(nbEntityitem1 > 0) {
    int x=new Random().nextInt(JavaTpJeu.maxX);
    int y=new Random().nextInt(JavaTpJeu.maxY);
    if(x >= JavaTpJeu.minX && x < JavaTpJeu.maxX && y >=JavaTpJeu.minY && y < JavaTpJeu.maxY) {
        Entity h = getEntite(x, y);
        Sprite c = this.getCase(x, y);
        System.out.println(x+","+y);
        if(c == null || !c.estSolide() || h!=null) {
            Entityitem1 p= new Entityitem1(x,y);
            p.setNiveau(this);
            addEntity(p);
            nbEntityitem1--;
        }
    }
}
int nbEntityitem2=5;
while(nbEntityitem2 > 0) {
    int x=new Random().nextInt(JavaTpJeu.maxX);
    int y=new Random().nextInt(JavaTpJeu.maxY);
    if(x >= JavaTpJeu.minX && x < JavaTpJeu.maxX && y >=JavaTpJeu.minY && y < JavaTpJeu.maxY) {
        Entity h = getEntite(x, y);
        Sprite c = this.getCase(x, y);
        System.out.println(x+","+y);
        if(c == null || !c.estSolide() || h!=null) {
            Entityitem2 p= new Entityitem2(x,y);
            p.setNiveau(this);
            addEntity(p);
            nbEntityitem2--;
        }
    }
}
}
}
