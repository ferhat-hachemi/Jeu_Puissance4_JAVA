
public class Arbre
{
 private Noeud racine ;
public Arbre(){

}

public Arbre(Noeud racine){
this.racine = racine ; 
}
/**Permet de creer L'arbre des Possibilitee de Jeux a une profondeur donnee**/
public static Arbre Arbre_Parfais(int n,Grille g,Case b){
        Arbre a = new Arbre();
        a.racine = new Noeud();
        a.racine = Arbre_Parfais_aux(n,g,b);
        return a; 
    }
    
    public Noeud getRacine(){
       return racine; 
    }
   
    private static int Max(int max1,int max2,int max3,int max4,int max5,int max6,int max7)
    {
      
      if(max1>=max2 && max1>=max3 && max1>=max4 && max1>=max5 && max1>=max6 && max1>=max7){
            return 0;
        }else if(max2>=max1 && max2>=max3 && max2>=max4 && max2>=max5 && max2>=max6 && max2>=max7){
            return 1;
        }else if(max3>=max4 && max3>=max1 && max3>=max2 && max3>=max5 && max3>=max6 && max3>=max7){
           return 2; 
        }else if(max4>=max1 && max4>=max2 && max4>=max3 && max4>=max5 && max4>=max6 && max4>=max7 ){
         return 3;
        }else if(max5>=max1 && max5>=max2 && max5>=max3 && max5>=max4 && max5>=max6 && max5>=max7 ){
         return 4;
        }else if(max6>=max1 && max6>=max2 && max6>=max3 && max6>=max4 && max6>=max5 && max6>=max7 ){
         return 5;
        }else if(max7>=max1 && max7>=max2 && max7>=max3 && max7>=max4 && max7>=max6 && max7>=max5 ){
         return 6;
        }
        return 0;
    }
    private static int Maxb(int max1,int max2,int max3,int max4,int max5,int max6,int max7,Grille g,Case b){
      Case c;
        if(b==Case.X){
          c=Case.O;
        }else{
          c=Case.X;  
        }
        if(g.getTab()[0][0]==c)max1=-1;
        if(g.getTab()[0][1]==c)max2=-1;
        if(g.getTab()[0][2]==c)max3=-1;
        if(g.getTab()[0][3]==c)max4=-1;
        if(g.getTab()[0][4]==c)max5=-1;
        if(g.getTab()[0][5]==c)max6=-1;
        if(g.getTab()[0][6]==c)max7=-1;
        if(max1>=max2 && max1>=max3 && max1>=max4 && max1>=max5 && max1>=max6 && max1>=max7){
            return max1;
        }else if(max2>=max1 && max2>=max3 && max2>=max4 && max2>=max5 && max2>=max6 && max2>=max7){
            return max2;
        }else if(max3>=max4 && max3>=max1 && max3>=max2 && max3>=max5 && max3>=max6 && max3>=max7){
           return max3; 
        }else if(max4>=max1 && max4>=max2 && max4>=max3 && max4>=max5 && max4>=max6 && max4>=max7 ){
         return max4;
        }else if(max5>=max1 && max5>=max2 && max5>=max3 && max5>=max4 && max5>=max6 && max5>=max7 ){
         return max5;
        }else if(max6>=max1 && max6>=max2 && max6>=max3 && max6>=max4 && max6>=max5 && max6>=max7 ){
         return max6;
        }else if(max7>=max1 && max7>=max2 && max7>=max3 && max7>=max4 && max7>=max6 && max7>=max5 ){
         return max7;
        }
        return 0;
    }
     /**Renvoie le numeros de  la colonne ou il y'a le plus de point **/
    public static int MeilleurScore1(Grille g,Case b){
 Noeud a=Arbre_Parfais_aux(4,g,b);   
 int w=Max(Max.Max1(a.getUn().getG(),b),Max.Max1(a.getDeux().getG(),b),Max.Max1(a.getTrois().getG(),b)
 ,Max.Max1(a.getQuatre().getG(),b),Max.Max1(a.getCinq().getG(),b),Max.Max1(a.getSix().getG(),b),Max.Max1(a.getSept().getG(),b));
 return w ;
  }
/**Renvoie le meilleur score pour chaque Grille**/
    public static int MeilleurScore(Grille g,Case b){
  Noeud a=Arbre_Parfais_aux(4,g,b);   
  int w=Maxb(Max.Max1(a.getUn().getG(),b),Max.Max1(a.getDeux().getG(),b),Max.Max1(a.getTrois().getG(),b)
 ,Max.Max1(a.getQuatre().getG(),b),Max.Max1(a.getCinq().getG(),b),Max.Max1(a.getSix().getG(),b),Max.Max1(a.getSept().getG(),b),g,b);
 return w ;
       }
       private static Noeud Arbre_Parfais_aux(int n,Grille g,Case b){
        Noeud a = new Noeud(g);
        Case c =b ;
        if(c==Case.X){
          c=Case.O;
        }else{
          c=Case.X;  
        }
        
       
        if(n>=1){
           a.setUn((Arbre_Parfais_aux(n-1,Grille.CopieP(g,b,0),c)));
           a.setDeux((Arbre_Parfais_aux(n-1,Grille.CopieP(g,b,1),c)));
           a.setTrois((Arbre_Parfais_aux(n-1,Grille.CopieP(g,b,2),c)));
           a.setQuatre((Arbre_Parfais_aux(n-1,Grille.CopieP(g,b,3),c)));
           a.setCinq((Arbre_Parfais_aux(n-1,Grille.CopieP(g,b,4),c)));
           a.setSix((Arbre_Parfais_aux(n-1,Grille.CopieP(g,b,5),c)));
           a.setSept((Arbre_Parfais_aux(n-1,Grille.CopieP(g,b,6),c)));
            }
        
        return a ;
    }



}