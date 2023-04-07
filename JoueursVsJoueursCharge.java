

import java.util.Scanner ;
import java.io.*;
public class JoueursVsJoueursCharge
{
        /**Methode pour lancer une partie charger**/
        public static void Joue(){
        boolean k = true;
        int m =0;
        Grille g = new Grille(); 
        String a ="";
        System.out.println("Qu'elle est le nom du fichier a charger ?");
        System.out.println("");
        do{
            try{
                Scanner i = new Scanner(System.in);
                a = i.nextLine();
                File f = new File(a);
                g= Sauv_Char.Charger(a) ;
                if(f.exists()==true){
                    k=true;
                
                }
            }catch(IOException e ){
                System.out.println("Le document n'existe pas recommancer s'il vous plait");
                System.out.println("");
                k=false;
            }
        }while(k ==false);
        System.out.println("Voici la Grille charger,nous allons reprendre la partie!");
        System.out.println("");
        System.out.println("");
        Grille.Affiche(g);
        System.out.println("");
        System.out.println("");
        int j1=(g.getTab().length*g.getTab()[0].length/2)-Grille.Compte(g,Case.X);
        int j2=(g.getTab().length*g.getTab()[0].length/2)-Grille.Compte(g,Case.O);
        Joueurs J1 = new Joueurs("J1",j1,Case.X);   
        Joueurs J2 = new Joueurs("J2",j2,Case.O); 
        Joueurs J = new Joueurs();
        if(Grille.Compte(g,Case.X)>Grille.Compte(g,Case.O)){
        J=J2;
    }else{
       J=J1; 
    }
       System.out.println("");
        boolean gagne;
        boolean remplie ;
        boolean sauvegarde ;
        do{
     System.out.println("Si vous voulez sauvegarder cette partie et la reprendre plus tard tapper 123");
            sauvegarde=Grille.Joue(g,J);
            if(sauvegarde==false){
            Grille.Affiche(g);
        }
            remplie =Grille.GrillePleine(g);
            gagne = Grille.Victoire(g,J.getChoix());
            System.out.println("");
            if(J == J1){
                J=J2;
            }else {
                J=J1;  
            }

        }while(gagne == false && remplie==false && sauvegarde==false);
        if(gagne == true ){
            if(J==J1){
                System.out.println("Le Gagnant est le Joueurs 2");   
            }else{
                System.out.println("Le Gagnant est le Joueurs 1");   
            }
        }
        if(remplie == true ){
            System.out.println("Match Nul");
        }
        if(sauvegarde == true ){
            System.out.println("La Partie à bien été sauvegarde,à plus tard");
        }
    }

    }
    
    
    
    
    
