import java.util.Scanner;
public class Jouer
{
    /**Methode pour commencer a Jouer**/
    public static void main(){
     System.out.println("Voulez vous faire un Joueur contre Joueur ou Joueur contre L'IA");
     System.out.println("Taper 1 pour choisir Joueur contre Joueur ou 2 pour Joueur contre L'IA");
     int a =0;
     int b=0;
     boolean k;
     do{
            try{
                Scanner i = new Scanner(System.in);
                a = i.nextInt();
                if(a ==1 || a==2){
                    k=true;
                }else{
                    k=false;
                    System.out.println("Si vous n'entrez pas un numéros valide vous ne pouvais pas continuer ! Taper 1 ou 2.");
                    System.out.println("");
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Entrer uniquement un nombre.");
                System.out.println("");
                k=false;
            }
        }while(k ==false);
        if(a==1){
     JoueurVsJoueur_Menue.Joue();
    }else{
        System.out.println("Voulez vous jouer contre L'IA Naive(Mode Facile) ou L'IA MiniMax(Mode Difficile)");
        System.out.println("Taper 1 pour choisir L'IA Naive ou 2 pour Joueur contre L'IA MiniMax");
        do{
            try{
                Scanner i = new Scanner(System.in);
                b = i.nextInt();
                if(b ==1 || b==2){
                    k=true;
                }else{
                    k=false;
                    System.out.println("Si vous n'entrez pas un numéros valide vous ne pouvais pas continuer ! Taper 1 ou 2.");
                    System.out.println("");
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Entrer uniquement un nombre.");
                System.out.println("");
                k=false;
            }
        }while(k ==false);
        if(b==1){
         HumainVsIA_naive.Joue();   
        }else
     HumainVsIA_MiniMax.Joue();
    }
    }
        }
    
