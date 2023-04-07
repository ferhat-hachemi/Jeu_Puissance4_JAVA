
import java.util.Scanner;
public class HumainVsIA_MiniMax
{
    /**Methode pour Jouer contre une IA MinMax**/
    public static void Joue(){
       System.out.println("Voulez avez choisis de jouez contre une IA MinMax ");
        System.out.println("Voulez allez joue sur une Grille classique de 6 lignes et 7 Colonnes");
        System.out.println("");
        int u=0;
    boolean k;
    System.out.println("Qu'elle profondeur de possibilté voulez vous voir ?");
    System.out.println("Sachant qu'importe la profondeur choisis Le MiniMax s'éxécute uniquement à la profondeur 1");
    System.out.println("La profondeur Minimum est 1 et la Maximum 4, au dela le temps de Chargement commence à etre un peu Long");
        do{
            try{
                Scanner i = new Scanner(System.in);
                u = i.nextInt();
                if(u >=1 && u<=4){
                    k=true;
                }else{
                    k=false;
        System.out.println("Si vous n'entrez pas un numéros valide vous ne pouvais pas continuer ! choisissez un nombre entre 1 et 4.");
                    System.out.println("");
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Entrer uniquement un nombre.");
                System.out.println("");
                k=false;
            }
        }while(k ==false);
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
            ArbreDesPossibilitees(g1,J,u);
            Grille.Joue_IA(g,J);
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
    private static void ArbreDesPossibilitees(Grille g,Joueurs j,int u){
    Arbre a = new Arbre();
    a=Arbre.Arbre_Parfais(u,g,j.getChoix());
    int w= Arbre.MeilleurScore1(g,j.getChoix());
    System.out.println("Voici tout les coup possible de L'IA à partir de la Grille déja présente");
    Grille.Affichetest(a.getRacine(),u);
    System.out.println("");
    System.out.println(""); 
    System.out.println("Voici ce que l'IA a joue");
    System.out.println(""); 
    }

}