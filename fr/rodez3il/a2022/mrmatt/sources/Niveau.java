package fr.rodez3il.a2022.mrmatt.sources;

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
    this();
    chargerNiveau(chemin);
  }

  public void chargerNiveau(String chemin){
    String res = Utils.lireFichier(chemin);
    String[] splited = res.split("\n");
    int horizontal = splited[0];
    int vertical = splited[1];
    this.plateau = new ObjetPlateau[horizontal][vertical];

    for(int i=0; i<spliter.length; i++){
      for(int y=0; y<spliter[i].length; y++){
        char tmp = spliter[i].charAt(y);
        this.plateau[i][y] = ObjetPlateau.depuisCaractere(tmp);
      }
    }
  }

  /**
   * Javadoc à réaliser...
   */
  private void echanger(int sourceX, int sourceY, int destinationX, int destinationY) {
    ObjectPlateau tmp = this.plateau[sourceX][sourceY];
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
  }

  // Joue la commande C passée en paramètres
  public boolean jouer(Commande c) {
  }

  /**
   * Affiche l'état final (gagné ou perdu) une fois le jeu terminé.
   */
  public void afficherEtatFinal() {
  }

  /**
   */
  public boolean estIntermediaire() {
  }

}
