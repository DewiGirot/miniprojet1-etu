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

  /*
   * Les objets sur le plateau du niveau
   * 
   * @Author DewiGirot
   */
  private ObjetPlateau[][] plateau;
  // Position du joueur
  private int joueurX;
  private int joueurY;
  private int nbPommes;
  private boolean intermediaire;
  private int deplacement;

  /**
   * Constructeur public : crée un niveau depuis un fichier.
   * 
   * @Author DewiGirot
   */
  public Niveau(String chemin) {
    String res = Utils.lireFichier(chemin);
    String[] splited = res.split("\n");
    int taille_horizontale = Integer.parseInt(splited[0]);
    int taille_verticale = Integer.parseInt(splited[1]);
    this.plateau = new ObjetPlateau[taille_horizontale][taille_verticale];

    this.nbPommes = 0;
    this.intermediaire = false;
    this.deplacement = 0;
    int abscisse = 0;
    int ordonnee = 0;

    for (int i = 2; i < splited.length; i++) {
      for (int y = 0; y < splited[i].length(); y++) {
        char tmp = splited[i].charAt(y);
        ObjetPlateau o = ObjetPlateau.depuisCaractere(tmp);
        System.out.print(o.afficher());
        if (tmp == 'H') {
          this.joueurX = abscisse;
          this.joueurY = ordonnee;
        }
        if (tmp == '+') {
          this.nbPommes++;
        }
        this.plateau[ordonnee][abscisse] = o;
        ordonnee++;
      }
      System.out.println();
      ordonnee = 0;
      abscisse++;
    }
  }

  /**
   * Permet de permuter deux objets du plateau
   * 
   * @Author DewiGirot
   */
  private void echanger(int sourceX, int sourceY, int destinationX, int destinationY) {
    ObjetPlateau tmp = this.plateau[sourceY][sourceX];
    this.plateau[sourceY][sourceX] = this.plateau[destinationY][destinationX];
    this.plateau[destinationY][destinationX] = tmp;
  }

  /**
   * Produit une sortie du niveau sur la sortie standard.
   * 
   * @Author DewiGirot
   */
  public void afficher() {
    this.nbPommes = 0;
    for (int i = 0; i < this.plateau[0].length; i++) {
      for (int y = 0; y < this.plateau.length; y++) {
        System.out.print(this.plateau[y][i].afficher());
        if (this.plateau[y][i].afficher() == '+') {
          this.nbPommes++;
        }
      }
      System.out.println();
    }

    System.out.println("Pommes restantes : " + this.nbPommes);
    System.out.println("Déplacements : " + this.deplacement);
  }

  /*
   * Patron visiteur du Rocher.
   * 
   * @Author DewiGirot
   */
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
    if (r.getEtat() == EtatRocher.CHUTE) {
      this.intermediaire = true;
    } else {
      this.intermediaire = false;
    }
  }

  /**
   * Calcule l'état suivant du niveau.
   * 
   * @author DewiGirot
   */
  public void etatSuivant() {
    this.intermediaire = false;
    for (int x = plateau.length - 1; x >= 0; x--) {
      for (int y = plateau[x].length - 1; y >= 0; y--) {
        plateau[x][y].visiterPlateauCalculEtatSuivant(this, x, y);
      }
    }
  }

  /*
   * Permet de savoir si la partie est en cours ou si elle est finie
   * 
   * @Author DewiGirot
   * 
   * @return retourne vrai si le nombre de pommes est égal à 0
   */
  public boolean enCours() {
    if (this.nbPommes != 0)
      return true;
    else
      return false;
  }

  /*
   * Joue la commande C passée en paramètres, le but de cet fonction est
   * d'utiliser la fonction "déplacer".
   * 
   * @Author DewiGirot
   * 
   * @return retourne vrai dans tous les cas
   */
  public boolean jouer(Commande c) {
    switch (c) {
      case HAUT:
        deplacer(-1, 0);
        break;
      case GAUCHE:
        deplacer(0, -1);
        break;
      case BAS:
        deplacer(1, 0);
        break;
      case DROITE:
        deplacer(0, 1);
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
   * 
   * @Author DewiGirot
   * @return retourne vrai si le déplacement demandé est possible sinon retourne
   *         faux.
   */
  private boolean deplacementPossible(int dx, int dy) {
    int futurX = this.joueurX + dx;
    int futurY = this.joueurY + dy;

    if ((dx != 0 || dy != 0) && (futurX >= 0 && futurY >= 0) && futurX < plateau[0].length && futurY < plateau.length) {

      System.out.println("DeplacementPossible : x :" + futurX + " y :" + futurY);
      System.out.println("Joueur : x :" + this.joueurX + " y :" + this.joueurY);
      if (this.plateau[futurY][futurX].estMarchable()) {
        return true;
      }
    }
    return false;
  }

  /**
   * Deplacement effectif du joueur
   * 
   * @Author DewiGirot
   */
  private void deplacer(int deltaX, int deltaY) {
    if (deplacementPossible(deltaX, deltaY) == true) {
      int futurX = this.joueurX + deltaX;
      int futurY = this.joueurY + deltaY;
      this.deplacement++;
      if (this.plateau[futurY][futurX].afficher() == '-' || this.plateau[futurY][futurX].afficher() == '+') {
        this.plateau[futurY][futurX] = new Vide();
      }
      echanger(this.joueurX, this.joueurY, futurX, futurY);
      this.joueurX = futurX;
      this.joueurY = futurY;
    }
    // else if estPoussable
  }

  /**
   * Affiche l'état final (gagné ou perdu) une fois le jeu terminé.
   * 
   * @Author DewiGirot
   * @return retourne "gagné" si la partie n'est plus en cours sinon retourne
   *         "perdu"
   */
  public void afficherEtatFinal() {
    if (this.enCours() == false)
      System.out.println("Bravo, vous avez gagné !");
    else
      System.out.println("Vous avez perdu :(");
  }

  /**
   * Fonction qui sert à savoir si le jeu est en état intermediaire, c'est à dire
   * s'il reste des rochers en état de chute.
   * 
   * @Author DewiGirot
   * @return retourne vrai si la partie est encore en cours et s'il
   *         reste des objets en état de chute
   */
  public boolean estIntermediaire() {
    return this.enCours() && this.intermediaire;
  }
}