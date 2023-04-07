import java.util.Scanner ;
public class Joueurs
{   
    private static final int n = 21;
    private String nom ;
    private int nbr_de_pions  ;
    private Case choix_du_pions ;
    
    public Joueurs(){
       this.nbr_de_pions= n; 
    }
    
    public Joueurs(String nom ,Case choix_du_pions){
       this.nom=nom;
       this.choix_du_pions=choix_du_pions; 
    }
    
    public Joueurs(int v){
       this.nbr_de_pions= v; 
    }
    
    public Joueurs(String nom,int nbr_de_pions,Case choix_du_pions){
        this.nom=nom;
        this.choix_du_pions=choix_du_pions;
        this.nbr_de_pions=nbr_de_pions;
        }
    
    public String getNom(){
        return nom;
        
    }
   
     public void setNom(String nom){
        this.nom=nom;
        
    }
    
    public int getNbr_de_pions(){
        return nbr_de_pions;
        
    }
    
     public void setNbr_de_pions(int nbr_de_pions){
         this.nbr_de_pions=nbr_de_pions;
        
    }
  
    public Case getChoix(){
        return choix_du_pions;
        
    }
    
    public void setChoix(Case choix_du_pions){
        this.choix_du_pions=choix_du_pions;
        
    }
    /** Methode permettant de receuillir le differentes donnees du Joueur qui va affronter L'IA **/
    public static void DonneeJoueurs_IA(Joueurs J1,Joueurs J2){
        System.out.println("Qu'elle est le nom du Joueur ?");
        Scanner clavier = new Scanner(System.in);
        String nom1 = clavier.nextLine(); 
        J1.nom = nom1 ;
        String J1Pions = "." ;
        System.out.println("Choississez un Pion valide "+nom1+"!Vous pouvez choisir X en tappant 1 ou O en tappant 2." );
        int Choix_Pions_1 ;
        boolean ok;
        do{
            try {
                ok = false;
            Scanner num = new Scanner(System.in);
            Choix_Pions_1 =num.nextInt();
            if (Choix_Pions_1== 1 || Choix_Pions_1 == 2){
                ok = true;
                if (Choix_Pions_1 ==1 ){
            J1.choix_du_pions = Case.X;
            J1Pions = "X";
        }
        if(Choix_Pions_1 ==2 ){
            J1.choix_du_pions = Case.O;
            J1Pions = "O";
        }
            }
        }catch(java.util.InputMismatchException e){
         System.out.println("");
         ok = false ;
        }
        if(ok==false) System.out.println("Si vous n'entrez pas un nombre valide vous ne pouvais pas continuer,Choississez uniquement le nombre 1 ou 2 !"); 
        }while(ok== false);
        System.out.println(nom1 +" Vous avez le pion "+J1Pions);
        System.out.println("");
        String J2Pions = "." ;
        if (J1.choix_du_pions == Case.X){
            J2.choix_du_pions = Case.O ;
            J2Pions = "O";
        }
        if (J1.choix_du_pions == Case.O){
            J2.choix_du_pions = Case.X ;
            J2Pions = "X";
        }

        System.out.println("L'IA a le pion "+J2Pions);
        System.out.println("");

    }
    /** Methode permettant de receuillir le differentes donnees des 2 Joueurs**/
    public static void DonneeJoueurs(Joueurs J1,Joueurs J2){
        System.out.println("Qu'elle est le nom du premier Joueurs ?");
        Scanner clavier = new Scanner(System.in);
        String nom1 = clavier.nextLine(); 
        J1.nom = nom1 ;
        String J1Pions = "." ;
        System.out.println("Choississez un Pion valide "+nom1+"!Vous pouvez choisir X en tappant 1 ou O en tappant 2." );
        int Choix_Pions_1 ;
        boolean ok;
        do{
            try {
                ok = false;
            Scanner num = new Scanner(System.in);
            Choix_Pions_1 =num.nextInt();
            if (Choix_Pions_1== 1 || Choix_Pions_1 == 2){
                ok = true;
                if (Choix_Pions_1 ==1 ){
            J1.choix_du_pions = Case.X;
            J1Pions = "X";
        }
        if(Choix_Pions_1 ==2 ){
            J1.choix_du_pions = Case.O;
            J1Pions = "O";
        }
            }
        }catch(java.util.InputMismatchException e){
         System.out.println("");
         ok = false ;
        }
        if(ok==false) System.out.println("Si vous n'entrez pas un nombre valide vous ne pouvais pas continuer,Choississez uniquement le nombre 1 ou 2 !"); 
        }while(ok== false);
        System.out.println(nom1 +" Vous avez le pion "+J1Pions);
        System.out.println("");
        System.out.println("Qu'elle est le nom du Second Joueurs ?");
        Scanner clavier2 = new Scanner(System.in);
        String nom2 = clavier2.nextLine(); 
        J2.nom = nom2;
        String J2Pions = "" ;
        if (J1.choix_du_pions == Case.X){
            J2.choix_du_pions = Case.O ;
            J2Pions = "O";
        }
        if (J1.choix_du_pions == Case.O){
            J2.choix_du_pions = Case.X ;
            J2Pions = "X";
        }

        System.out.println(nom2+" Vous avez le pion "+J2Pions);
        System.out.println("");

    }
    
        
      
        }
    

