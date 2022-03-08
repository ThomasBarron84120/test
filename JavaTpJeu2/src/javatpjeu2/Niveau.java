package javatpjeu2;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Le niveau représente la carte d'un level du jeux. Elle contient
 * des cases qui sont les sprites de type mur par exemple
 * Et listeENtite qui sont les objets / créatures qui se trouvent
 * dans le niveau
 * @author coupr
 */
public class Niveau {
    private ArrayList cases;
    private ArrayList listeEntite;
    private int numNiveau;
    public Niveau() {
        cases = new ArrayList();
        listeEntite = new ArrayList();
        generationAuto();
    }
//Pour ajouter un sprite dans le tableau des cases
    public void addCase(Sprite s) {
        cases.add(s);
    }
//Pour ajotuer une entité dans le tableau des entités
    public void addEntity(Entity e) {
        listeEntite.add(e);
    }
//Génération automatique d'un level avec des murs et des pommes aléatoire
    public void generationAuto() {
//Mur de contour et sol de base
for(int i=JavaTpJeu.minX;i<JavaTpJeu.maxX;i++) {
    cases.add(new Mur(i,JavaTpJeu.minY));
    cases.add(new Mur(i,JavaTpJeu.maxY-1));
}
for(int j=JavaTpJeu.minY+1;j<JavaTpJeu.maxY-1;j++) {
    cases.add(new Mur(JavaTpJeu.minX,j));
    cases.add(new Mur(JavaTpJeu.maxX-1,j));
}
for(int i=JavaTpJeu.minX+1;i<JavaTpJeu.maxX-1;i++) {
    for(int j=JavaTpJeu.minY+1;j<JavaTpJeu.maxY-1;j++) {
        double r = Math.random();
        if(r <= 0.05)
            cases.add(new Mur(i,j));
        else if(r <= 0.1) {
            EntityPomme p= new EntityPomme(i,j);
            p.setNiveau(this);
            listeEntite.add(p);
        }
    }
}
    }
//lance l'affichage des Sprites
    public void display() {
        for(Iterator<Sprite> it = cases.iterator();it.hasNext();)
            
        {
            
            Sprite s = it.next();
            s.display();
        }
    }
    //Lance l'affichage des entités
    public void displayEntites() {
        for(Iterator<Sprite> it =
                listeEntite.iterator();it.hasNext();) {
            Sprite s = it.next();
            s.display();
        }
    }
    //Permet de récupérer le sprite présent sur une case donnée
    public Sprite getCase(int x, int y) {
        for(Iterator<Sprite> it = cases.iterator();it.hasNext();)
            
        {
            
            Sprite s = it.next();
            if(s.getX()==x && s.getY()==y) return s;
        }
        return null;
    }
    //permet de récupérer l'entité présente sur une case donnée
    public Entity getEntite(int x, int y) {
        for(Iterator<Sprite> it =
                listeEntite.iterator();it.hasNext();) {
            Sprite s = it.next();
            if(s.getX()==x && s.getY()==y) return (Entity)s;
        }
        return null;
    }
    //Supprimer une entité de la liste
    public void supprimerEntites(int x, int y) {
        Entity e = getEntite(x, y);
        if(e != null) listeEntite.remove(e);
    }
    //Polymorphisme paramétrique pour supprimer l'entité quand on la connait
    public void supprimerEntites(Entity e) {
        listeEntite.remove(e);
    }
    public int getNumNiveau() {
        return numNiveau;
    }
    public void setNumNiveau(int numNiveau) {
        this.numNiveau = numNiveau;
    }
}
