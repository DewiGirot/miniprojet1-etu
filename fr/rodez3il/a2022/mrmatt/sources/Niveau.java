package fr.rodez3il.a2022.mrmatt.sources;

import fr.rodez3il.a2022.mrmatt.sources.objets.ObjetPlateau;
import fr.rodez3il.a2022.mrmatt.sources.objets.EtatRocher;
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
        if (tmp == 'H') {
          this.joueurX = abscisse;
          this.joueurX = ordonee;
        }
        if (tmp == '+') {
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

  // TODO : patron visiteur du Rocher
  public void etatSuivantVisiteur(Rocher r, int x, int y) {
    if (r.getEtat() == EtatRocher.FIXE) {
      if (this.plateau[x][y + 1].estVide()) {
        r.setEtat(EtatRocher.CHUTE);
      }
    }
    if (r.getEtat() == EtatRocher.CHUTE) {
      if (this.plateau[x][y + 1].afficher() == '#') {
        r.setEtat(EtatRocher.FIXE);
      } else if (this.plateau[x][y + 1].afficher() == ' ') {
        echanger(x, y, x, y + 1);
      } else if (this.plateau[x][y + 1].afficher() == 'H') {
        // Erreur
      } else if (this.plateau[x][y + 1].estGlissant()) {
        if (this.plateau[x - 1][y + 1].estVide()) {
          echanger(x, y, x - 1, y + 1);
        } else if (this.plateau[x + 1][y + 1].estVide()) {
          echanger(x, y, x + 1, y + 1);
        } else {
          r.setEtat(EtatRocher.FIXE);
        }
      }
    }
  }

  /**
   * Calcule l'état suivant du niveau.
   * ........
   * 
   * @author DewiGirot
   */
  public void etatSuivant() {
    for (int x = plateau.length - 1; x >= 0; x--) {
      for (int y = plateau[x].length - 1; y >= 0; y--) {
        plateau[x][y].visiterPlateauCalculEtatSuivant(this, x, y);
      }
    }
  }

  // Illustrez les Javadocs manquantes lorsque vous coderez ces méthodes !

  public boolean enCours() {
    return true;
  }

  // Joue la commande C passée en paramètres
  public boolean jouer(Commande c) {
    switch (c) {
      case HAUT:
        deplacer(0, -1);
        break;
      case GAUCHE:
        deplacer(-1, 0);
        break;
      case BAS:
        deplacer(0, 1);
        break;
      case DROITE:
        deplacer(1, 0);
        break;
      case ANNULER:
        break;
      case QUITTER:
        break;
      case ERREUR:
        break;
    }
    return true;
  }

  /**
   * Regarde si le déplacement demandé est possible
   */
  private boolean deplacementPossible(int dx, int dy) {
    int futurX = this.joueurX + dx;
    int futurY = this.joueurY + dy;

    if ((dx != 0 || dy != 0) && (futurX >= 0 && futurY >= 0) && futurX < plateau.length && futurY < plateau[0].length) {
      if (this.plateau[futurX][futurY].estMarchable()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Deplacement effectif du joueur
   */
  private void deplacer(int deltaX, int deltaY) {
    if (deplacementPossible(deltaX, deltaY) == true) {
      int futurX = this.joueurX + deltaX;
      int futurY = this.joueurY + deltaY;
      // increment deplacementJoueur
      if (this.plateau[futurX][futurY].afficher() == '+') {
        // To Do with apple to increment counter
      }
      echanger(this.joueurX, this.joueurY, futurX, futurY);
      this.plateau[futurX][futurY] = new Vide();
    }
    // else if estPoussable
  }

  /**
   * Affiche l'état final (gagné ou perdu) une fois le jeu terminé.
   */
  public void afficherEtatFinal() {
    System.out.println("Bravo vous avez gagner");
  }

  /**
   */
  public boolean estIntermediaire() {
    return true;
  }

}
