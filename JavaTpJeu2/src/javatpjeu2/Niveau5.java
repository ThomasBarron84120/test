package javatpjeu2;
import java.util.Random;
/**
* Classe de représentation du niveau 1, la fonction de
generationAuto est surchargé pour générer un level spécifique
* Avec un nombre de pommes déterminé
* @author coupr
*/
public class Niveau5 extends Niveau {
public Niveau5() {
super();
setNumNiveau(4);
}
@Override
public void generationAuto() {
System.out.println("Override");
for(int i=0;i<150;i++) {
    int x=new Random().nextInt(JavaTpJeu.maxX);
    int y=new Random().nextInt(JavaTpJeu.maxY);
    if(x >= JavaTpJeu.minX && x < JavaTpJeu.maxX && y >=JavaTpJeu.minY && y < JavaTpJeu.maxY) {
        Sprite c = this.getCase(x, y);
        if(c == null || !c.estSolide()) {
            addCase(new Mur2(x,y));
        }
    }
}
//Génération des Pommes
int nbPommes=10;
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
int nbmonstre2=20;
while(nbmonstre2 > 0) {
    int x=new Random().nextInt(JavaTpJeu.maxX);
    int y=new Random().nextInt(JavaTpJeu.maxY);
    if(x >= JavaTpJeu.minX && x < JavaTpJeu.maxX && y >=JavaTpJeu.minY && y < JavaTpJeu.maxY) {
        Sprite c = this.getCase(x, y);
        System.out.println(x+","+y);
        if(c == null || !c.estSolide()) {
            Monstre2 p= new Monstre2(x,y);
            p.setNiveau(this);
            addEntity(p);
            nbmonstre2--;
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


