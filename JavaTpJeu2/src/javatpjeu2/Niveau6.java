package javatpjeu2;
import java.util.Random;
/**
* Classe de représentation du niveau 1, la fonction de
generationAuto est surchargé pour générer un level spécifique
* Avec un nombre de pommes déterminé
* @author coupr
*/
public class Niveau6 extends Niveau {
public Niveau6() {
super();
setNumNiveau(1);
}
@Override
public void generationAuto() {
System.out.println("Override");


//Génération des Pommes
// choisir la position initiale (x, y) à une position aléatoire sur le labyrinthe
		int x=new Random().nextInt(JavaTpJeu.maxX);
                int y=new Random().nextInt(JavaTpJeu.maxY);
                x=40;
                y=12;
                System.out.println(x+"x");
                System.out.println(y+"y");
                Tableaux_jeux cellules = new Tableaux_jeux(JavaTpJeu.maxX,JavaTpJeu.maxY);
                cellules.generationTableaux();
                for (int i = 0; i < cellules.matrice.length; i++) {
                 for (int j = 0; j < cellules.matrice[0].length; j++) {
                   System.out.print(cellules.matrice[i][j]);
                 }
                 System.out.println();
               }
                
		int cellsVisited =  1 ;
		int dx =  0 ;
		int dy =  0 ;
                int idd =  0 ;
		String direction = "z";
                double rd = Math.random()*10;
                if(rd<=2.5) direction ="q";
                else if(rd<=5) direction ="d";
                else if(rd<=7.5) direction ="s";
                else if(rd<=10) direction ="z";
                double rd2 = Math.random()*10;
                for (int i = 37 ;i<41;i++){
                    for (int j = 10 ;j<13;j++){
                        cellules.Tableauxvisiter(i,j);
                    }
                }
		
		while (cellsVisited < (JavaTpJeu.maxX * JavaTpJeu.maxY)&&idd<10000) {
			idd++;
                        System.out.println(x+"x|y"+y+"|T"+idd);
                        
                        if (direction ==  "z" && y-2 >2) { // monter
				dx =  0 ;
				dy =  - 2 ;

				System.out.println(x+"x|y"+y+"|y-2 z|"+rd);
				// entrez dans la cellule aléatoire, si nous l'avons déjà visité, continuez le processus
				// si nous ne l'avons pas encore entré, supprimez le mur entre
                                
				if (cellules.matrice[x][y-2]==0) {
					cellules.Tableauxvisiter(x,y-2);
                                        Sprite c = this.getCase(x, y-2);
                                        Sprite p = this.getCase(x, y-1);
                                        if(c == null ) {
                                            addCase(new Mur2(x,y-2));
                                            if(p == null)addCase(new Mur2(x,y-1));
                                        }
                                        cellsVisited +=2 ;
					// supprime le mur entre les deux, définit la cellule comme visitée et incrémente les cellules visitées
					
				
                                }
			}
			else  if (direction ==  "d" && x+2 <JavaTpJeu.maxX-2) { // déplacer à droite
				dx =  2 ;
				dy =  0 ;
				
				// entrez dans la cellule aléatoire, si nous l'avons déjà visité, continuez le processus
				// si nous ne l'avons pas encore entré, supprimez le mur entre
                                System.out.println(x+"x|y"+y+"|x+2 q|"+rd);
                                
				if (cellules.matrice[x+2][y]==0) {
					
					// supprime le mur entre les deux, définit la cellule comme visitée et incrémente les cellules visitées
					
                                        cellules.Tableauxvisiter(x+2,y);
                                        Sprite c = this.getCase(x+2, y);
                                        Sprite p = this.getCase(x+1, y);
                                        if(c == null ) {
                                            addCase(new Mur2(x+2,y));
                                            if(p == null)addCase(new Mur2(x+1,y));
                                        }
                                        cellsVisited +=2;
                                    
                                }
			}
			else  if (direction ==  "s" && y+1 <JavaTpJeu.maxY-2) { // déplacer vers le bas
				dx =  0 ;
				dy =  2 ;
				System.out.println(x+"x|y"+y+"|y+2 s|"+rd);
				// entrez dans la cellule aléatoire, si nous l'avons déjà visité, continuez le processus
				// si nous ne l'avons pas encore entré, supprimez le mur entre
                                
				if (cellules.matrice[x][y+2]==0) {
					
					// supprime le mur entre les deux, définit la cellule comme visitée et incrémente les cellules visitées
					
                                        cellules.Tableauxvisiter(x,y+2);
                                        Sprite c = this.getCase(x, y+2);
                                        Sprite p = this.getCase(x, y+1);
                                        if(c == null ) {
                                            addCase(new Mur2(x,y+2));
                                            if(p == null)addCase(new Mur2(x,y+1));
                                        }
                                        cellsVisited +=2 ;
                                
                                }
			}
			else  if (direction ==  "q" && x-2 >2) { // déplacer vers la gauche
				dx =  - 2 ;
				dy =  0 ;
				System.out.println(x+"x|y"+y+"|x-2 d|"+rd);
                                
				// entrez dans la cellule aléatoire, si nous l'avons déjà visité, continuez le processus
				// si nous ne l'avons pas encore entré, supprimez le mur entre
				if (cellules.matrice[x-2][y]==0) {
					
                                    // supprime le mur entre les deux, définit la cellule comme visitée et incrémente les cellules visitées
                                   
                                    cellules.Tableauxvisiter(x-2,y);
                                    Sprite c = this.getCase(x-2, y);
                                    Sprite p = this.getCase(x-1, y);
                                    if(c == null ) {
                                        addCase(new Mur2(x-2,y));
                                        if(p == null)addCase(new Mur2(x-1,y));
                                    }
                                    cellsVisited +=2 ;
                                
                                }
			}
			
			direction = "z";
                        rd = Math.random()*10;
                        if(rd<2.5) direction ="d";
                        else if(rd<5) direction ="s";
                        else if(rd<7.5) direction ="q";
			
			// Définit la cellule actuelle sur la cellule adjacente vers laquelle nous nous sommes déplacés.
			if (x + dx>0 && x + dx<JavaTpJeu.maxX && y + dy>0 && y + dy<JavaTpJeu.maxY) {
                            x += dx;
                            y += dy;
			}
		
		}
                for (int i = 0; i < cellules.matrice.length; i++) {
                 for (int j = 0; j < cellules.matrice[0].length; j++) {
                   System.out.print(cellules.matrice[i][j] );
                 }
                 System.out.println();
               }
               for (int i = 0 ;i<JavaTpJeu.maxX;i++){
                    for (int j = 0 ;j<JavaTpJeu.maxY;j++){
                        Sprite a = this.getCase(i-1, j);
                        Sprite b = this.getCase(i+1, j);
                        Sprite c = this.getCase(i, j-1);
                        Sprite d = this.getCase(i, j+1);
                        if(a!= null&& b!= null&&c!= null&&d != null )addCase(new Mur2(i,j));
                    }
                }
               int nbPommes=10;
while(nbPommes > 0) {
    x=new Random().nextInt(JavaTpJeu.maxX);
    y=new Random().nextInt(JavaTpJeu.maxY);
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
int nbmonstre=50;
while(nbmonstre > 0) {
    x=new Random().nextInt(JavaTpJeu.maxX);
    y=new Random().nextInt(JavaTpJeu.maxY);
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
    x=new Random().nextInt(JavaTpJeu.maxX);
    y=new Random().nextInt(JavaTpJeu.maxY);
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
    x=new Random().nextInt(JavaTpJeu.maxX);
    y=new Random().nextInt(JavaTpJeu.maxY);
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
