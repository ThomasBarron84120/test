package javatpjeu2;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import net.slashie.libjcsi.CharKey;
import net.slashie.libjcsi.ConsoleSystemInterface;
import net.slashie.libjcsi.wswing.WSwingConsoleInterface;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.util.Scanner; 
//Ceci importe toutes les classes du package java.util
import java.util.*;

/**
 * https://github.com/slashman/libjcsi librairie Pour la gestion
 * des entrées sorties de la console
 * @author coupr
 */
public class JavaTpJeu {
    
// Gestion de la fin du programme
    public static boolean fin_partie = false;
    public static boolean fin_level = false;
//La console gérer par la librairie
    public static ConsoleSystemInterface csi;
//Les dimension utiliser lié a la taille max de la console de80x25
    public static int minX=0,minY=2,maxX=80,maxY=25;
    public static String version = "1.2";
//Le score actuel de la partie
    public static int nombre_de_pommes = 0;
    public static int bonus_invincibilite = 0;
    public static int bonus_bombe = 0;
    public static int score = 0;
    public static int lifee = 10;
    public static int pommes_max_level = 0;
    public static void main(String... arg) throws IOException {
    int cont_invincibilite=0;
    int cont_bonus=600;
    String couleur_caracter_coeur = "red";
    String couleur_caracter_invincibilite = "red";
    String music_fons = "none";
    //music a = new music("...");
    //a.playmusic();
        
    while(!fin_level){
        //Definitions des propriétés de la console pour la font +taille par défaut a utiliser
        Properties parametres = new Properties();
        parametres.setProperty("fontSize","15");
        parametres.setProperty("font", "Courier");
        //Création et initialisation de la console
        csi = new WSwingConsoleInterface("MaFenetre", parametres);
        csi.cls();
        csi.print(0, 0, "〘 SPACEWAR 〙",ConsoleSystemInterface.MAGENTA);
        //Préparation du premier niveau et afficahge des sprites(murs)
        Niveau n;
        //System.out.println(JavaTpJeu.maxY+"x");
        //System.out.println(JavaTpJeu.maxX+"y");
        if(nombre_de_pommes >= 35) {
            n = new Niveau5();
            pommes_max_level =45;
        }else if(nombre_de_pommes >= 20) {
            n = new Niveau3();
            pommes_max_level=35;
        }else if(nombre_de_pommes >= 5) {
            n = new Niveau2();
            pommes_max_level=20;
        }else{
            n = new Niveau6();
            pommes_max_level=5;
        }

        n.display();
        //On save le buffer ca représente tout ce qui estactuellement affiché et devra toujours être réaffiché

        csi.saveBuffer();
        //On affiche les entités (n.displayEntites();
        //Création de l'entité Joueur et affectation du niveauactuel, on utilise pour l'instant l'entité "générique"

        Entityjoueur joueur = new Entityjoueur(40,12);
        joueur.setNiveau(n);
        tire t = null;
        
        //Tant que la partie n'est pas terminé
        String direction_tire ="none";
        String direction ="up";
        while(!fin_partie) {
            // On restore le buffer
            csi.restore();
            // On affiche les données dynamique
            String nblife;
            nblife="";
            String cont_invincibilite_caracter="";
            for (int i=0; i<cont_invincibilite;i++)cont_invincibilite_caracter+="■";
            for (int i=0; i<lifee;i++) nblife +="♥";
            csi.print(15,0, "SCORE = "+score ,ConsoleSystemInterface.CYAN);
            if (lifee>3)csi.print(30,0, nblife ,ConsoleSystemInterface.RED);
            else if  (lifee<=3){
                if(couleur_caracter_coeur == "red"){
                    csi.print(30,0, nblife ,ConsoleSystemInterface.YELLOW);
                    couleur_caracter_coeur = "yellow";
                }else{
                    csi.print(30,0, nblife ,ConsoleSystemInterface.RED);
                    couleur_caracter_coeur = "red";
                }
            }
            csi.print(42,0, "pommes ="+nombre_de_pommes,ConsoleSystemInterface.YELLOW);
            csi.print(52,0, "♥",ConsoleSystemInterface.RED);
            csi.print(55,0, "niveau suivant ="+pommes_max_level,ConsoleSystemInterface.YELLOW);
            csi.print(73,0, "♥",ConsoleSystemInterface.RED);
            if(cont_invincibilite!=0){
                if (cont_invincibilite>6)csi.print(15,1, "Invincibilité = "+cont_invincibilite_caracter,ConsoleSystemInterface.RED);
                    else {
                    if(couleur_caracter_invincibilite == "red"){
                        csi.print(15,1, "Invincibilité = "+cont_invincibilite_caracter,ConsoleSystemInterface.YELLOW);
                        couleur_caracter_invincibilite = "yellow";
                    }else{
                        csi.print(15,1, "Invincibilité = "+cont_invincibilite_caracter,ConsoleSystemInterface.RED);
                        couleur_caracter_invincibilite = "red";
                    }
                }
            }
            if(cont_bonus!=0)csi.print(1,1, "["+cont_bonus+" pt + ]",ConsoleSystemInterface.GREEN);
            joueur.display();
            if(t != null) t.display();
            n.displayEntites();
            //On refresh pour mettre a jour l'affiche de laconsole

            csi.refresh();
            //Capture touche pour gérer les commandes
            int key = csi.inkey().code;
            

            switch(key) {
                case CharKey.UARROW:
                    joueur.moveUp();
                    direction ="up";
                break;
                case CharKey.DARROW:
                    joueur.moveDown();
                    direction ="Down";
                break;
                case CharKey.LARROW:
                    joueur.moveLeft();
                    direction ="Left";
                break;
                case CharKey.RARROW:
                    joueur.moveRight();
                    direction ="Right";
                break;
                case CharKey.Q: case CharKey.q: case CharKey.ESC:
                    fin_partie = true;
                    fin_level = true;
                break;
                case CharKey.R: case CharKey.r:
                    fin_partie = true;
                break;

                case CharKey.SPACE :
                    if(t == null) {
                        direction_tire = direction;
                        t = new tire(joueur.getX(), joueur.getY());
                        t.setNiveau(n);
                        music tire_song = new music("lancer2");
                        tire_song.playmusic();
                    }


                break;
                case CharKey.m :
                    if(music_fons=="none"){
                        music music_seezy = new music("seezy");
                        music_seezy.playmusicboucle();
                        music_fons="yes";
                        
                    }
                break;
                case CharKey.l :
                    if(music_fons=="none"){
                        music music_seezy = new music("lol");
                        music_seezy.playmusicboucle();
                        music_fons="yes";
                    }
                break;
            }
            if(music_fons=="none"){
                music music_seezy = new music("fondmusic2");
                music_seezy.playmusicboucle();
                music_fons="yes";
            }
            if(nombre_de_pommes >= pommes_max_level ||lifee < 1) {
                fin_partie = true;
            }
            if(cont_invincibilite > 0) {
                cont_invincibilite--;
            }
            if(cont_bonus > 0) {
                cont_bonus--;
            }
            if(cont_invincibilite==1){
                music fin_invincibilite = new music("finimu");
                fin_invincibilite.playmusic();
                
            }
            String rdv = "son1";
            double rd = Math.random();
            if(rd<0.4) rdv ="son2";
            else if(rd<=0.8) rdv ="son6";
            System.out.println(rdv);
            //music b = new music(rdv);
            //b.playmusic();
               //sang2
            //Test après mouvement si collision avec une entité
            Entity e = n.getEntite(joueur.getX(), joueur.getY());
            //Si l'entité est scorable, on récupère du score !
            if(e != null && e instanceof bonus2) {
                bonus_invincibilite += ((bonus2)e).getbonus2();
                cont_invincibilite=30;
                
                music invincibilite = new music("fin-imu");
                invincibilite.playmusic();
         
                n.supprimerEntites(e);
            }
            if(e != null && e instanceof comptpomme) {
                nombre_de_pommes += ((comptpomme)e).getnbpo();
                
                music coeur = new music("coeur");
                coeur.playmusic();
                
            }
            if(e != null && e instanceof EntityJoueure) {
                if(cont_invincibilite != 0) {
                    int lifee2=lifee;
                    lifee += ((EntityJoueure)e).getlife();
                    if (lifee<lifee2)lifee=lifee2;
                }else{
                    lifee += ((EntityJoueure)e).getlife();
                }
            }
            if(e != null && e instanceof Scorable) {
                if(cont_invincibilite != 0) {
                    int score2=score;
                    score += ((Scorable)e).getScore();
                    if (score<score2)score=score2;
                }else{
                    score += ((Scorable)e).getScore();
                }
                if(((Scorable)e).getScore()<0){
                    music invincibilite = null;
                    if(cont_invincibilite != 0)invincibilite = new music("enemie-tuer");
                    else invincibilite = new music(rdv);
                    invincibilite.playmusic();
                }
                n.supprimerEntites(e);
            }
            if(e != null && e instanceof bonus) {
                music bonus_m = new music("bonus2");
                bonus_m.playmusic();
                bonus_bombe += ((bonus)e).getbonus();
                int x = joueur.getX();
                int y = joueur.getY();
                for (int i = x-5; i < x + 5 ; i++) {
                    for (int j = y-5; j < y + 5 ; j++) {
                        Entity l = n.getEntite(i, j);
                        if(l != null && l instanceof comptpomme) {
                            nombre_de_pommes += ((comptpomme)l).getnbpo();
                            music coeur = new music("coeur");
                            coeur.playmusic();
                        }
                        if(l != null && l instanceof EntityJoueure) {
                            int lifee2=lifee;
                            lifee += ((EntityJoueure)l).getlife();
                            if (lifee<lifee2)lifee=lifee2;
                        }
                        if(l != null && l instanceof Scorable) {
                            int score2=score;
                            score += ((Scorable)l).getScore();
                            if (score<score2)score=score2;
                            music invincibilite = new music("enemie-tuer");
                            invincibilite.playmusic();
                                
                            
                            n.supprimerEntites(l);
                        }
                    }
                }

                n.supprimerEntites(e);
            }

            if(t != null) {
                Entity v = n.getEntite(t.getX(), t.getY());
                if(v != null && v instanceof comptpomme) {
                    nombre_de_pommes += ((comptpomme)v).getnbpo();
                    music coeur = new music("coeur");
                    coeur.playmusic();
                }

                if(v != null && v instanceof EntityJoueure) {
                    int lifee2=lifee;
                    lifee += ((EntityJoueure)v).getlife();
                    if (lifee<lifee2)lifee=lifee2;
                }
                if(v != null && v instanceof Scorable) {
                    int score2=score;
                    score += ((Scorable)v).getScore();
                    if (score<score2)score=score2;
                    if(((Scorable)v).getScore()<0){
                        music invincibilite = new music("sang2");
                        invincibilite.playmusic();
                    }
                    n.supprimerEntites(v);
                    t = null;
                }
            }
            if(t != null) {
                
                if(direction_tire =="up"){
                    if(!t.moveUp()){
                        t = null;
                    }
                }
                if(direction_tire =="Down"){
                    if(!t.moveDown()){
                        t = null;
                    }
                }
                if(direction_tire =="Left"){
                    if(!t.moveLeft()){
                        t = null;
                    }
                }
                if(direction_tire =="Right"){
                    if(!t.moveRight()){
                        t = null;
                    }

                }
            }
            if(lifee > 10) {
                lifee = 10;
            }
        }
        //Si on est sortie du programme (ESC) on attend l'appuiesur espace pour fermer la fenêtre

        if(nombre_de_pommes >= 45) {
            if (cont_bonus!=0) score=score+cont_bonus;
            if(score >= 6500) {

                csi.print(34,12, "♆♆♆♆ BEST ♆♆♆♆",ConsoleSystemInterface.YELLOW);
                csi.print(34,13, "SCORE = "+score ,ConsoleSystemInterface.CYAN);
            }else{
                csi.print(34,12, "♆ FINI ♆",ConsoleSystemInterface.YELLOW);
                csi.print(34,13, "SCORE = "+score+" pt" ,ConsoleSystemInterface.CYAN);
            }
            //Scanner sc = new Scanner(System.in);
            //System.out.println("Veuillez saisir un NOM :");
            //String nom = sc.nextLine();
            //csi.input();
            int key2 =0;
            int id1=0;
            String vari="";
            csi.print(34,14, "NOM = " ,ConsoleSystemInterface.WHITE);
            //String nom ;
            //nom = csi.input(5);
            
            //String vari2=csi.input(10);
            //csi.print(34,14, "NOM = "+vari2 ,ConsoleSystemInterface.WHITE);
            int id;
            do {
                csi.refresh();
                id=csi.inkey().code;
                captur_touche touche = new captur_touche(id);
                String t1=touche.la_touche();
                vari=vari+t1;
                csi.print(34,14, "NOM = "+vari ,ConsoleSystemInterface.WHITE);
                if (t1!="")id1++;

            }while (id!=CharKey.ENTER && id1<10);
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\thoma\\OneDrive\\Bureau\\song\\thomas\\thomas.txt", true)));
            writer.println("version :"+ version +"||" +vari+" :"+score );
            writer.close();

            cont_bonus=600;
            nombre_de_pommes=0;
            score=0;
            music fini_m = new music("arri");
            fini_m.playmusic();
        }else if(nombre_de_pommes >= pommes_max_level) {
            if (cont_bonus!=0) score=score+cont_bonus;
            csi.print(34,12, "〖 GAGNER 〗",ConsoleSystemInterface.GREEN);
            csi.print(34,13, "SCORE = "+score+" pt" ,ConsoleSystemInterface.CYAN);
            cont_bonus=600;
            music gagner_m = new music("ga");
            gagner_m.playmusic();
        }else{
            csi.print(32,12, "〖 GAME OVER 〗",ConsoleSystemInterface.RED);
            csi.print(32,13, "SCORE = "+score+" pt" ,ConsoleSystemInterface.CYAN);
            score=0;
            music game_over_m = new music("arriver-jeux");
            game_over_m.playmusic();
           
        }

        csi.refresh();
        if(!fin_level)csi.waitKey(CharKey.SPACE);
        lifee=10;
        fin_partie = false;


        }
       System.exit(0);
        
    }
    
    
}
