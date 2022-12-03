package fr.rodez3il.a2022.mrmatt.sources;

import fr.rodez3il.a2022.mrmatt.sources.objets.ObjetPlateau;
import fr.rodez3il.a2022.mrmatt.sources.objets.Rocher;
import fr.rodez3il.a2022.mrmatt.sources.objets.Joueur;
import fr.rodez3il.a2022.mrmatt.sources.objets.Mur;
import fr.rodez3il.a2022.mrmatt.sources.objets.Pomme;
import fr.rodez3il.a2022.mrmatt.sources.objets.Herbe;
import fr.rodez3il.a2022.mrmatt.sources.objets.Vide;

public class Niveau {

  // Les objets sur le plateau du niveau
  private ObjetPlateau[][] plateau;
  // Position du joueur
  private int joueurX;
  private int joueurY;

  // Autres attributs que vous jugerez nécessaires...

  /**
   * Constructeur public : crée un niveau depuis un fichier.
   * 
   * @param chemin .....
   * @author DewiGirot
   */
  public Niveau(String chemin) {
    String res = Utils.lireFichier(chemin);
    String[] splited = res.split("\n");
    int taille_horizontale = Integer.parseInt(splited[0]);
    int taille_verticale = Integer.parseInt(splited[1]);
    this.plateau = new ObjetPlateau[taille_horizontale][taille_verticale];

    int abscisse = 0;
    int ordonee = 0;
    int nbPommes = 0;

    for (int i = 2; i < splited.length; i++) {
      System.out.println();
      for (int y = 0; y < splited[i].length(); y++) {
        ordonee = 0;
        char tmp = splited[i].charAt(y);
        ObjetPlateau o = ObjetPlateau.depuisCaractere(tmp);
        System.out.print(o.afficher());
        if(tmp == 'H'){
          this.joueurX = abscisse;
          this.joueurX = ordonee;
        }
        if(tmp == '+'){
          nbPommes++;
        }
        this.plateau[joueurX][joueurY] = o;
        ordonee++;
      }
      abscisse++;
    }
    // System.out.println("Nombre de pommes : " + nbPommes);
  }

  /**
   * Javadoc à réaliser...
   */
  private void echanger(int sourceX, int sourceY, int destinationX, int destinationY) {
    ObjetPlateau tmp = this.plateau[sourceX][sourceY];
    this.plateau[sourceX][sourceY] = this.plateau[destinationX][destinationY];
    this.plateau[destinationX][destinationY] = tmp;
  }

  /**
   * Produit une sortie du niveau sur la sortie standard.
   * ................
   */
  public void afficher() {
    // TODO
  }

  // TODO : patron visiteur du Rocher...
  public void etatSuivantVisiteur(Rocher r, int x, int y) {

  }

  /**
   * Calcule l'état suivant du niveau.
   * ........
   * 
   * @author
   */
  public void etatSuivant() {
    // TODO
  }

  // Illustrez les Javadocs manquantes lorsque vous coderez ces méthodes !

  public boolean enCours() {
    return false;
  }

  // Joue la commande C passée en paramètres
  public boolean jouer(Commande c) {
    return false;
  }

  /**
   * Regarde si le déplacement demandé est possible
   */
  public boolean deplacementPossible(int dx, int dy){
    int futurX = this.joueurX + dx;
    int futurY = this.joueurY + dy;

    if((dx!=0 || dy!=0) && (futurX>=0 && futurY>=0) && futurX < plateau.length && futurY < plateau[0].length()){
      if(this.plateau[futurX][futurY].estMarchable()){
        return true;
      }
    }
  }

  /**
   * Deplacement effectif du joueur
   */
  public void deplacer(int deltaX, int deltaY){
    
  }

  /**
   * Affiche l'état final (gagné ou perdu) une fois le jeu terminé.
   */
  public void afficherEtatFinal() {
  }

  /**
   */
  public boolean estIntermediaire() {
    return true;
  }

}
