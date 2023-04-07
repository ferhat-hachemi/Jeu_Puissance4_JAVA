
    public class Min
    {
        private static int Max(int max1,int max2,int max3,int max4){
            if(max1>=max4 && max1>=max2 && max1>=max3){
                return max1;
            }else if(max2>=max4 && max2>=max1 && max2>=max3){
                return max2;
            }else if(max3>=max4 && max3>=max1 && max3>=max2){
                return max3; 
            }else if(max4>=max1 && max4>=max2 && max4>=max3 ){
                return max4;
            }else{
                return 0 ;
            }
    
        }
    
        private static int MaxVerticale(Grille g,Case a){
            int max4=0;
            int max1=0;
            int max2=0;
            int max3=0;
           for(int i=g.getTab().length-1;i>g.getTab().length-4;i--){
                for(int j=0;j<g.getTab()[i].length;j++){
                    if(g.getTab()[i][j]== a && g.getTab()[i-1][j]==Case.VIDE  && g.getTab()[i-2][j]==Case.VIDE && g.getTab()[i-3][j]==Case.VIDE) max1=1;
                    if(g.getTab()[i][j]== a && g.getTab()[i-1][j]==a  && g.getTab()[i-2][j]==Case.VIDE && g.getTab()[i-3][j]==Case.VIDE ) max2=2  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i-1][j]==a  && g.getTab()[i-2][j]==a && g.getTab()[i-3][j] ==Case.VIDE ) max3=2000  ;
    
                }
            }
            return Max(max1,max2,max3,max4);
        }
    
        private static int MaxHorizontale(Grille g,Case a){
            int max4=0;
            int max1=0;
            int max2=0;
            int max3=0;
              for(int i=0;i<g.getTab().length;i++){
                for(int j=0;j<g.getTab()[i].length-3;j++){
                    if(g.getTab()[i][j]== a && g.getTab()[i][j+1]==Case.VIDE  && g.getTab()[i][j+2]==Case.VIDE && g.getTab()[i][j+3]==Case.VIDE )max1=1;
                    if(g.getTab()[i][j]== a && g.getTab()[i][j+1]==a  && g.getTab()[i][j+2]==Case.VIDE && g.getTab()[i][j+3] ==Case.VIDE ) max2=2  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i][j+1]==a  && g.getTab()[i][j+2]== a && g.getTab()[i][j+3]==Case.VIDE )  max3=2000  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i][j+1]==Case.VIDE && g.getTab()[i][j+2]== a && g.getTab()[i][j+3] == a) max4=2000  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i][j+1]== a && g.getTab()[i][j+2]==Case.VIDE && g.getTab()[i][j+3] == a) max4=2000  ; 
                }
            }
            for(int i=0;i<g.getTab().length;i++){
                for(int j=g.getTab()[i].length-1;j>g.getTab()[i].length-3;j--){
                    if(g.getTab()[i][j]== a && g.getTab()[i][j-1]==Case.VIDE  && g.getTab()[i][j-2]==Case.VIDE && g.getTab()[i][j-3]==Case.VIDE ) max1=1;
                    if(g.getTab()[i][j]== a && g.getTab()[i][j-1]==a  && g.getTab()[i][j-2]==Case.VIDE && g.getTab()[i][j-3] ==Case.VIDE ) max2=2  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i][j-1]==a  && g.getTab()[i][j-2]== a && g.getTab()[i][j-3]==Case.VIDE )  max3=2000  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i][j-1]==Case.VIDE && g.getTab()[i][j-2]== a && g.getTab()[i][j-3] == a) max4=2000;
                    if(g.getTab()[i][j]== a && g.getTab()[i][j-1]== a && g.getTab()[i][j-2]==Case.VIDE && g.getTab()[i][j-3] == a) max4=2000  ;
                }
            }
    
            return Max(max1,max2,max3,max4);
        }
    
        private static int MaxDiagonaleAv(Grille g,Case a){
            int max4=0;
            int max1=0;
            int max2=0;
            int max3=0;
            for(int i=g.getTab().length-1;i>g.getTab().length-4;i--){
                for(int j=0;j<g.getTab()[i].length-3;j++){
                    if(g.getTab()[i][j]== a && g.getTab()[i-1][j+1]==Case.VIDE  && g.getTab()[i-2][j+2]==Case.VIDE && g.getTab()[i-3][j+3]==Case.VIDE ) max1=1  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i-1][j+1]==a  && g.getTab()[i-2][j+2]==Case.VIDE && g.getTab()[i-3][j+3]==Case.VIDE ) max2=2  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i-1][j+1]==a  && g.getTab()[i-2][j+2]==a && g.getTab()[i-3][j+3]==Case.VIDE )  max3=2000  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i-1][j+1]== Case.VIDE && g.getTab()[i-2][j+2]== a && g.getTab()[i-3][j+3]== a ) max4=2000  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i-1][j+1]== a && g.getTab()[i-2][j+2]==Case.VIDE && g.getTab()[i-3][j+3]== a ) max4=2000  ;
                }
            }
    
            for(int i=0;i<g.getTab().length-3;i++){
                for(int j=g.getTab().length-1;j>g.getTab()[i].length-5;j--){
                    if(g.getTab()[i][j]== a && g.getTab()[i+1][j-1]==Case.VIDE  && g.getTab()[i+2][j-2]==Case.VIDE && g.getTab()[i+3][j-3]==Case.VIDE ) max1=1  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i+1][j-1]==a  && g.getTab()[i+2][j-2]==Case.VIDE && g.getTab()[i+3][j-3]==Case.VIDE ) max2=2  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i+1][j-1]==a  && g.getTab()[i+2][j-2]==a && g.getTab()[i+3][j-3]==Case.VIDE )  max3=2000  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i+1][j-1]== Case.VIDE && g.getTab()[i+2][j-2]== a && g.getTab()[i+3][j-3]== a ) max4=2000  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i+1][j-1]== a && g.getTab()[i+2][j-2]==Case.VIDE && g.getTab()[i+3][j-3]== a ) max4=2000  ;
                }
            }
            return Max(max1,max2,max3,max4);
    
        }
    
        private static int MaxDiagonaleArr(Grille g,Case a){
            int max4=0;
            int max1=0;
            int max2=0;
            int max3=0;
            for(int i=0;i<g.getTab().length-3;i++){
                for(int j=0;j<g.getTab()[i].length-3;j++){
                    if(g.getTab()[i][j]== a && g.getTab()[i+1][j+1]==Case.VIDE  && g.getTab()[i+2][j+2]==Case.VIDE && g.getTab()[i+3][j+3]==Case.VIDE )  max1=1  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i+1][j+1]==a  && g.getTab()[i+2][j+2]==Case.VIDE && g.getTab()[i+3][j+3]==Case.VIDE )  max2=2  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i+1][j+1]==a  && g.getTab()[i+2][j+2]==a && g.getTab()[i+3][j+3]==Case.VIDE )  max3=2000  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i+1][j+1]==Case.VIDE && g.getTab()[i+2][j+2]== a && g.getTab()[i+3][j+3]== a ) max4=2000  ;
                    if(g.getTab()[i][j]== a && g.getTab()[i+1][j+1]==a && g.getTab()[i+2][j+2]==Case.VIDE && g.getTab()[i+3][j+3]== a ) max4=2000  ;
                }
            }
            for(int i=g.getTab().length-1;i>g.getTab().length-4;i--){
                for(int j=g.getTab()[i].length-1;j>g.getTab()[i].length-5;j--){
                if(g.getTab()[i][j]== a && g.getTab()[i-1][j-1]==Case.VIDE  && g.getTab()[i-2][j-2]==Case.VIDE && g.getTab()[i-3][j-3]==Case.VIDE )  max1=1  ;
                if(g.getTab()[i][j]== a && g.getTab()[i-1][j-1]==a  && g.getTab()[i-2][j-2]==Case.VIDE && g.getTab()[i-3][j-3]==Case.VIDE )  max2=2  ;
                if(g.getTab()[i][j]== a && g.getTab()[i-1][j-1]==a  && g.getTab()[i-2][j-2]==a && g.getTab()[i-3][j-3]==Case.VIDE )  max3=2000  ;
                if(g.getTab()[i][j]== a && g.getTab()[i-1][j-1]==Case.VIDE && g.getTab()[i-2][j-2]== a && g.getTab()[i-3][j-3]== a ) max4=2000  ;
                if(g.getTab()[i][j]== a && g.getTab()[i-1][j-1]==a && g.getTab()[i-2][j-2]==Case.VIDE && g.getTab()[i-3][j-3]== a ) max4=2000  ;
            }
        }

          return Max(max1,max2,max3,max4);
    }

    /**Methode qui permet d'evaluer le score de chaque Joueurs apres chaque coup**/
    public static int Max2(Grille g,Case a){
        int max4=MaxVerticale(g,a);
        int max1=MaxHorizontale(g,a);
        int max2=MaxDiagonaleAv(g,a);
        int max3=MaxDiagonaleArr(g,a);
        int max =max1+max2+max3+max4;
        return max;

    }
}