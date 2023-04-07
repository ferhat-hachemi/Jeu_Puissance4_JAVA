import java.util.Scanner;
public class JoueurVsJoueur
{
    /**Methode qui permet a 2 Joueurs de s'affronte**/
    public static void Joue(){
         
        boolean k ;
        int m =0;
        Grille g ;
        int a =0;
        System.out.println("Voulez vous choisir le nombre de Colonne et de Grille ?");
        System.out.println("");
        System.out.println("Taper 1 pour choisir votre Grille ou 2 pour une Grille classique(6 lignes,7 colonnes)");
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
        int l =0;
        int c =0;
        if(a==1){
            System.out.println("Pour avoir un nombre de Pions équitable vous devez prendre un nombre paire et impaire pour le nombre de Ligne et de Colonne");
            System.out.println("");
            do{
                try{
                    Scanner v = new Scanner(System.in);        
                    k=true;
                    System.out.println("Combien de Ligne voulez vous ?(Minimun 4)");
                    System.out.println("");
                    l = v.nextInt();
                    if(l<4){
                        System.out.println("Si vous n'entrez pas un numéros de Ligne au moins égale à 4 vous ne pouvais pas continuer !");
                        System.out.println("");
                        k=false;
                    }
                }catch(java.util.InputMismatchException e){
                    System.out.println("Entrer uniquement un nombre.");
                    System.out.println("");
                    k=false;
                }
            }while(k == false);

            do{        
                try{
                    if(l%2==0){
                        System.out.println("Vous devez obligatoirement choisir un nombre Impaire");  
                        System.out.println(""); 
                    }else{
                        System.out.println("Vous devez obligatoirement choisir un nombre Paire");
                        System.out.println("");
                    }
                    Scanner w = new Scanner(System.in);    
                    k=true ;            
                    System.out.println("Combien de Colonne voulez vous ?(Minimun 4)");
                    System.out.println("");
                    c = w.nextInt();
                    if(c<4){
                        System.out.println("Si vous n'entrez pas un numéros de Colonne au moins égale à 4 vous ne pouvais pas continuer !");
                        System.out.println("");
                        k=false;
                    }
                    if (l%2==0){
                        if(c%2==0){

                            System.out.println("");
                            k=false;
                        }
                    }
                    if (l%2!=0){
                        if(c%2!=0){

                            System.out.println("");
                            k=false;
                        }
                    }
                }catch(java.util.InputMismatchException e){
                    System.out.println("Entrer uniquement un nombre.");
                    System.out.println("");
                    k=false;   
                }
            }while(k==false); 
            g=new Grille(l,c);
            m=l*c/2 ;
        }else{
            g= new Grille(); 
        }
        Grille.initialise (g);
        Joueurs J1;
        Joueurs J2 ;
        Joueurs J;
        if(a==1){
         J1= new Joueurs(m);   
         J2= new Joueurs(m);   
          J= new Joueurs(m);   
        }else{
         J1= new Joueurs();   
         J2= new Joueurs();   
         J= new Joueurs();   
        }
        Joueurs.DonneeJoueurs(J1,J2);
        J=J1;
        System.out.println("Voici la Grille ou vous allez vous affrontez !!!");
        System.out.println("");
        Grille.Affiche(g);
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
                System.out.println("Le Gagnant est "+J2.getNom());   
            }else{
                System.out.println("Le Gagnant est "+J1.getNom());   
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

