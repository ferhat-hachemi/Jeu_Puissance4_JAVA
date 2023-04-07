
import java.util.Scanner;
public class JoueurVsJoueur_Menue{
    /**Methode pour selectionner une nouvelle partie ou la charger**/
     public static void Joue(){
         int a=0;
         boolean k;
        System.out.println("Voulez vous chargez une partie ou en commencer une nouvelle ?");
        System.out.println("Taper 1 pour une nouvelle partie ou 2 pour une charger une partie");
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
                    JoueurVsJoueur_Menue.Joue();
                }
            }catch(java.util.InputMismatchException e){
                System.out.println("Entrer uniquement un nombre.");
                System.out.println("");
                k=false;
            }
        }while(k ==false);
        if(a==1){
           JoueurVsJoueur.Joue(); 
        }else{
        JoueursVsJoueursCharge.Joue();
        }    
            
    }
}