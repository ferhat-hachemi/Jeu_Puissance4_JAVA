

public class Noeud
{
private Grille g ;
private Noeud  un ;
private Noeud deux;
private Noeud trois ;
private Noeud quatre;
private Noeud cinq ;
private Noeud six;
private Noeud sept;

public Noeud(Grille g){
this.g=g;
}

public Noeud(){
    this.g = new Grille();
    Grille.initialise(g);
 }

public Grille getG(){
    return g;
}

public Noeud getUn(){
    return un;
}
public Noeud getDeux(){
    return deux;
}
public Noeud getTrois(){
    return trois;
}
public Noeud getQuatre(){
    return quatre;
}
public Noeud getCinq(){
    return cinq;
}
public Noeud getSix(){
    return six;
}
public Noeud getSept(){
    return sept;
}

public void setUn(Noeud un){
    this.un=un;
}
public void setDeux(Noeud deux){
    this.deux=deux;
}
public void setTrois(Noeud trois){
    this.trois=trois;
}
public void setQuatre(Noeud quatre){
    this.quatre=quatre;
}
public void setCinq(Noeud cinq){
    this.cinq=cinq;
}
public void setSix(Noeud six){
    this.six=six;
}
public void setSept(Noeud sept){
    this.sept=sept;
}

 
}