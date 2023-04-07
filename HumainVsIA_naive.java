
import java.util.Scanner;
public class HumainVsIA_naive
{
    /**Methode pour Jouer contre une IA Naive**/
    public static void Joue(){
       System.out.println("Voulez avez choisis de jouez contre une IA naive ");
        System.out.println("Voulez allez joue sur une Grille classique de 6 lignes et 7 Colonnes");
        System.out.println("");
        Grille g = new Grille();
        Grille g1= new Grille();
        Grille.initialise (g);
        Grille.initialise (g1);
        Joueurs J1;
        Joueurs J2 ;
        Joueurs J;
        J1= new Joueurs();   
        J2= new Joueurs();   
        J= new Joueurs();   
        Joueurs.DonneeJoueurs_IA(J1,J2);
        J=J1;
        System.out.println("Voici la Grille ou vous allez vous affrontez !!!");
        System.out.println("");
        Grille.Affiche(g);
        System.out.println("");
        boolean gagne;
        boolean remplie ;
        do{
            if(J==J1){
            Grille.JouevsIA(g,J);
        }else{
            Grille.Copie(g,g1);
            ArbreDesPossibilitees(g1,J);
            Grille.Joue_IA_Naive(g,J);
            }
            Grille.Affiche(g);
            remplie =Grille.GrillePleine(g);
            gagne = Grille.Victoire(g,J.getChoix());
            System.out.println("");
            if(J == J1){
                J=J2;
            }else {
                J=J1;  
            }

        }while(gagne == false && remplie==false);
        if(gagne == true ){
            if(J==J1){
                System.out.println("Le Gagnant est L'IA");   
            }else{
                System.out.println("Le Gagnant est "+J1.getNom());   
            }
        }
        if(remplie == true ){
            System.out.println("Match Nul");
        }

    }
    private static void ArbreDesPossibilitees(Grille g,Joueurs j){
    Arbre a = new Arbre();
    a=Arbre.Arbre_Parfais(1,g,j.getChoix());
    System.out.println("Voici tout les coup possible de L'IA à partir de la Grille déja présente");
    Grille.Affichetest(a.getRacine(),1);
    System.out.println("");
    System.out.println(""); 
    System.out.println("Voici ce que l'IA a joue");
    System.out.println(""); 
    }

}