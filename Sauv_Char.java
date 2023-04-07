
import java.io.*;
import java.util.Scanner;
public class Sauv_Char
{
/**Methode pour sauvegarder votre partie **/    
public static void Sauvegarder(Grille g) {
    int largeur=g.getTab()[0].length;
    int hauteur=g.getTab().length;
    StringBuilder sb = new StringBuilder();
    boolean k= true;
    System.out.println("A qu'elle endroit voulez vous sauvegarer votre partie ?");
    System.out.println("Si vous ne savez pas tapper C://Users/Votre_Nom_D'Utilisateur/Desktop/Nom_Souhaitez.txt");
    
    do{
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
    try{
    File f = new File(a);
    FileWriter w =new FileWriter(f);
     BufferedWriter bw = new BufferedWriter(w);
    //ajout de la largeur
    sb.append(largeur);
    
    //ajout de l'espace
    sb.append(' ');
    
    //ajout de la hauteur
    sb.append(hauteur);
    
    //ajout de l'espace
    sb.append(' ');
    
    //boucle for    
    
    for(int i=g.getTab().length-1;i>=0;i--){
         for(int j=0;j<g.getTab()[i].length;j++){
              if(g.getTab()[i][j]==Case.X){
                  sb.append('X');
                }else if(g.getTab()[i][j]==Case.O){
                   sb.append('O'); 
                }else{
                  sb.append(' ');   
                }
            
            }
        }
    
    String str = sb.toString();
    
  
    bw.write(str);
    bw.close();
    w.close();
}catch(IOException e){
    k=false;
    System.out.println("Le chemin demander pour creer le dossier n'existe pas recommencer S'il vous plait");
System.out.println("Si vous ne savez pas tapper C://Users/Votre_Nom_D'Utilisateur/Desktop/Nom_Souhaitez.txt  il sera enregistre sur votre bureau");
}
}while(k==false);

}


/**Methode pour charger votre partie **/
public static Grille Charger(String a)throws IOException
   {
     Grille g1= new Grille();
     boolean k= true;
     
     try{
      // Le fichier d'entrée
      File file = new File(a);
      // Créer l'objet File Reader
      FileReader fr = new FileReader(file);
      // Créer l'objet BufferedReader  
      BufferedReader br = new BufferedReader(fr);  
      int c = 0; 
      int hauteur=-1 ;
      int largeur=-1 ;
      
      
      //lecture de la hauteur
     
      c = br.read();
      if(c!= -1){
            // convertir l'entier en char
            char ch = (char) c;         
            // Afficher le caractère      
            largeur = Character.getNumericValue(ch); 
      }
      
      //System.out.println("hauteur : "+hauteur);
      
      //lecture de l'espace 
      c = br.read();
      //Lecture de la largeur
      c = br.read();
      
      if(c!= -1){
            // convertir l'entier en char
            char ch = (char) c;         
            // Afficher le caractère      
            hauteur = Character.getNumericValue(ch); 
      }
      
      //System.out.println("largeur : "+largeur);
      
      /*if(hauteur == -1 && largeur == -1){
        System.out.println("largeur && hauteur egal -1 ");
        System.out.println("echec du chargement du fichier ");
       }*/
       
      //initialisation de la grille
      Grille g = new Grille(hauteur,largeur);
      Grille.initialise(g);
      
      //lecture de l'espace 
      c = br.read();
      for(int i=g.getTab().length-1;i>=0;i--){
         for(int j=0;j<g.getTab()[i].length;j++){
              c = br.read();
              if(c != -1)
              {
                    // convertir l'entier en char
                    char ch = (char) c;         
                    // Afficher le caractère      
                    //System.out.println(ch);  
                    
                    //enregistrement du caractere dans la grille
                    if( ch == 'X'){
                    g.getTab()[i][j]=Case.X ;
                    }
                    if( ch == 'O'){
                    g.getTab()[i][j]=Case.O ;
                    }
              }
              else{
                System.out.println("echec lecture caractere"); 
              }
             
            
            }
        }
         
        
        return g;
    }catch(java.lang.NegativeArraySizeException e){
       System.out.println("Ce fichier ne peut pas etre charger ou à été corompue recommencer S'il vous plait ");
       JoueursVsJoueursCharge.Joue();
       System.exit(0);
       
    }

    return g1;
   }

}


