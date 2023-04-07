import java.util.Scanner ;
import java.util.Random;

public class Grille
{
    private int ligne ;
    private int colonne ;
    private Case tab[][] ;
    
    public Grille(int ligne,int colonne ){
        this.colonne=colonne;
        this.ligne=ligne;
        this.tab= new Case[ligne][colonne] ;
    }
    
    public Grille(){
        this.tab= new Case[6][7];

    }
    
    public Case[][] getTab(){
        return tab;
    }
    /**Permet de creer la Grille **/
    public static void initialise(Grille g){
        for(int i=0;i<g.tab.length;i++){
            for(int j=0;j<g.tab[i].length;j++){
                g.tab[i][j]=Case.VIDE;
            }
        }
    }
    /**Permet de compter le nombre de pion au choix dans la Grille utile pour charger une partie **/
    public static int Compte(Grille g,Case a){
        int n=0;
        for(int i=0;i<g.tab.length;i++){
            for(int j=0;j<g.tab[i].length;j++){
                if(g.tab[i][j]==a){
                  n++;  
                }
            }
        }
        return n;
    }
    /**Permet d'Afficher la Grille **/
    public static void Affiche(Grille g){
        for(int i=0;i<g.tab.length;i++){
           System.out.print(" |");
            for(int j=0;j<g.tab[i].length;j++){
                if(g.tab[i][j]==Case.X){
                    System.out.print("X");
                }else if(g.tab[i][j]==Case.O) { 
                    System.out.print("O");
                }else{
                    System.out.print(" ");
                }
                System.out.print("|");

            }
            System.out.println();
        }

    }
    
    private static void Affiche1(Grille g){
       for(int i=0;i<g.tab.length;i++){
            System.out.print("                                                      ");
            System.out.print(" |");
            for(int j=0;j<g.tab[i].length;j++){
                if(g.tab[i][j]==Case.X){
                    System.out.print("X");
                }else if(g.tab[i][j]==Case.O) { 
                    System.out.print("O");
                }else{
                    System.out.print(" ");
                }
                System.out.print("|");
                
            }
            System.out.println();
        }

    }
    
    private static void Affichel(int i,Grille g){
       for(int j=0;j<g.tab[0].length;j++){
                if(g.tab[i][j]==Case.X){
                    System.out.print("X");
                }else if(g.tab[i][j]==Case.O) { 
                    System.out.print("O");
                }else{
                    System.out.print(" ");
                }
                System.out.print("|");
                
            }
            }
     /**Affiche une grille Suivie de 7 autres representant les cas possibles pour chaque colonne**/     
 public static void Affichetest(Noeud a,int n){
    System.out.println("");
    Grille.Affiche1(a.getG());
    System.out.println("              ........................................................................................................");
    System.out.println("              |              |                    |               |              |                   |               |");
    System.out.println("              |              |                    |               |              |                   |               |");
    System.out.println("");
        for(int i=0;i<a.getG().tab.length;i++){
        if(a.getG().tab[0][0]== Case.VIDE ){
        System.out.print("   |");
        Affichel(i,a.getUn().getG());
        }else{
           System.out.print("Colonne Remplie    ");
           }
            if(a.getG().tab[0][1]== Case.VIDE ){
            System.out.print("   |");
            Affichel(i,a.getDeux().getG());
                }else{
         System.out.print("  Colonne Remplie    ");   
        }
        if(a.getG().tab[0][2]== Case.VIDE ){
            System.out.print("   |");
            Affichel(i,a.getTrois().getG());
        }else{
          System.out.print("  Colonne Remplie    ");  
        }
        if(a.getG().tab[0][3]== Case.VIDE ){
            System.out.print("   |");
            Affichel(i,a.getQuatre().getG());
        }else{
           System.out.print("  Colonne Remplie    ");  
        }
        if(a.getG().tab[0][4]== Case.VIDE ){
            System.out.print("   |");
            Affichel(i,a.getCinq().getG());
        }else{
        System.out.print("  Colonne Remplie    ");     
        }
        if(a.getG().tab[0][5]== Case.VIDE ){
            System.out.print("   |");
           Affichel(i,a.getSix().getG());
        }else{
          System.out.print("  Colonne Remplie    ");    
        }
        if(a.getG().tab[0][6]== Case.VIDE ){
            System.out.print("   |");
            Affichel(i,a.getSept().getG());
        }else{
         System.out.print("  Colonne Remplie    "); 
        }
            
            System.out.println();
        }
        if (n>1){
         Affichetest(a.getUn(),n-1);
         Affichetest(a.getDeux(),n-1);
         Affichetest(a.getTrois(),n-1);
         Affichetest(a.getQuatre(),n-1);
         Affichetest(a.getCinq(),n-1);
         Affichetest(a.getSix(),n-1);
         Affichetest(a.getSept(),n-1);
         
        }
    }
 /**Renvoie Vrai si la grille est pleine**/  
    public static boolean GrillePleine(Grille g ){
        for(int i=0 ;i<g.tab[0].length;i++){
            if (g.tab[0][i]== Case.VIDE){
                return false;
            }
        }
        return true ;
    }
/**Methode qui permet au Joueur de placer son Pion avec l'arret possible du jeu par la sauvegarde**/ 
    public static boolean Joue(Grille g,Joueurs j){
        boolean verification ;
        boolean nombre ;
        boolean k;
        System.out.println(j.getNom() + " avec le Pions " + j.getChoix());
        System.out.println("Choissisez une colonne valide !");
        System.out.println(j.getNom() +" il vous reste "+j.getNbr_de_pions()+" Pions");
        do {
            int colonne = 0;
            do {try {
                    Scanner clavier =new Scanner(System.in); 
                    colonne = clavier.nextInt();
                    if(colonne==123){
                     Sauv_Char.Sauvegarder(g);
                     return true;
                     }
                    nombre = true;
                }catch(java.util.InputMismatchException e){
                    System.out.println("Choississez uniquement un numéros de colonne.");
                    nombre = false;
                }
            }while(nombre == false);
            System.out.println("");
            colonne --;
            verification = PlacerUnPion(g,colonne,j.getChoix(),j);
            if(verification == false){
                System.out.println("Coup invalide recommencer s'il vous plait.");
                System.out.println("");
            }
        }while(verification == false);
        return false;
    }
    
    /**Methode qui permet au Joueur de placer son Pion **/ 
    public static void JouevsIA(Grille g,Joueurs j){
        boolean verification ;
        boolean nombre ;
        boolean k;
        System.out.println(j.getNom() + " avec le Pions " + j.getChoix());
        System.out.println("Choissisez une colonne valide !");
        System.out.println(j.getNom() +" il vous reste "+j.getNbr_de_pions()+" Pions");
        do {
            int colonne = 0;
            do {try {
                    Scanner clavier =new Scanner(System.in); 
                    colonne = clavier.nextInt();
                    
                     
                    nombre = true;
                }catch(java.util.InputMismatchException e){
                    System.out.println("Choississez uniquement un numéros de colonne.");
                    nombre = false;
                }
            }while(nombre == false);
            System.out.println("");
            colonne --;
            verification = PlacerUnPion(g,colonne,j.getChoix(),j);
            if(verification == false){
                System.out.println("Coup invalide recommencer s'il vous plait.");
                System.out.println("");
            }
        }while(verification == false);
        
    }
/**Methode qui permet a L'IA de comparer ses points avec celui du Joueur pour jouer en fonction  **/
   public static void Joue_IA(Grille g,Joueurs j){
        int colonne;
        Case b=j.getChoix();
        Case c;
        if(b==Case.X){
          c=Case.O;
        }else{
          c=Case.X;  
        }
        int w =Arbre.MeilleurScore(g,b);
        int p=Min.Max2(g,c);
        int v=Arbre.MeilleurScore1(g,c);
       if(w>p){
        System.out.println ("l'IA a un meilleur score que le Joueur");   
        colonne = Arbre.MeilleurScore1(g,b);
        PlacerUnPion(g,colonne,b,j);
    }else{
        System.out.println ("Le Joueur a un meilleur score que le L'IA"); 
        PlacerUnPion(g,v,b,j);
       }
        
        }
/**Methode qui permet a L'IA de jouer Aleatoirement **/        
        public static void Joue_IA_Naive(Grille g,Joueurs j){
        int colonne= 0+(int)(Math.random() * (7));
        PlacerUnPion(g,colonne,j.getChoix(),j);
   
        }
   
    
    private static boolean PlacerUnPion_Possibilitee(Grille g,int colonne ,Case a){
        if(colonne >= g.tab[0].length || g.tab[0][colonne]!=Case.VIDE){
            return false;  
        }
        int Case_disponible=g.tab.length-1;
        while(g.tab[Case_disponible][colonne]!=Case.VIDE){
            Case_disponible --;
        }
        g.tab[Case_disponible][colonne]=a ;
        return true ;
    }

    private static boolean PlacerUnPion(Grille g,int colonne ,Case a,Joueurs j){
        if(colonne >= g.tab[0].length || g.tab[0][colonne]!=Case.VIDE){
            return false;  
        }
        int Case_disponible=g.tab.length-1;
        while(g.tab[Case_disponible][colonne]!=Case.VIDE){
            Case_disponible --;
        }
        g.tab[Case_disponible][colonne]=a ;
        j.setNbr_de_pions(j.getNbr_de_pions()-1);
        return true ;
    }

    private static boolean Victoire_Horizontale(Grille g ,Case a){
        for(int i=0;i<g.tab.length;i++){
            for(int j=0;j<g.tab[i].length-3;j++){
                if(g.tab[i][j]== a && g.tab[i][j+1]== a && g.tab[i][j+2]== a && g.tab[i][j+3] == a) return true ; 
            }

        }
        return false ;
    }

    private static boolean Victoire_Vertical(Grille g ,Case a){
        for(int i=0;i<g.tab.length-3;i++){
            for(int j=0;j<g.tab[i].length;j++){
                if(g.tab[i][j]== a && g.tab[i+1][j]== a && g.tab[i+2][j]== a && g.tab[i+3][j] == a) return true ; 
            }

        }
        return false ;
    }

    private static boolean Victoire_DiagonaleAvant(Grille g ,Case a){
        for(int i=g.tab.length-1;i>g.tab.length-4;i--){
            for(int j=0;j<g.tab[i].length-3;j++){
                if(g.tab[i][j]== a && g.tab[i-1][j+1]== a && g.tab[i-2][j+2]== a && g.tab[i-3][j+3] == a ) return true ; 
            }

        }
        return false ;
    }

    private static boolean Victoire_DiagonaleArriere(Grille g ,Case a){
        for(int i=0;i<g.tab.length-3;i++){
            for(int j=0;j<g.tab[i].length-3;j++){
                if(g.tab[i][j]== a && g.tab[i+1][j+1]== a && g.tab[i+2][j+2]== a && g.tab[i+3][j+3] == a) return true ; 
            }
        }

        return false ;
    }
    /**Methode qui verifie si un Joueur a reussi a Alligner 4 pions**/
    public static boolean Victoire(Grille g ,Case a){
        if(Victoire_Horizontale(g,a) == true ) return true;
        if(Victoire_Vertical(g,a) == true ) return true;
        if(Victoire_DiagonaleAvant(g,a) == true ) return true;
        if(Victoire_DiagonaleArriere(g,a) == true ) return true;
        return false ;
    }
    /**Methode qui permet de creer une copie d'un Tableau**/
    public static Grille Copie(Grille g,Grille g1){
        for(int i=0;i<g1.tab.length;i++){
            for(int j=0;j<g1.tab[i].length;j++){
                g1.tab[i][j]=g.tab[i][j];
            }
        }
        return g1;
    }
   /**Methode qui permet de creer une copie d'un Tableau et d'y placer un Pion**/
    public static Grille CopieP(Grille g,Case a,int colonne){
        Grille g1= new Grille();
        initialise(g1);
        for(int i=0;i<g1.tab.length;i++){
            for(int j=0;j<g1.tab[i].length;j++){
                g1.tab[i][j]=g.tab[i][j];
            }
        }
        PlacerUnPion_Possibilitee(g1,colonne,a);
        
        return g1;
    }
    
    

}