package fr.rodez3il.a2022.mrmatt.sources.objets;

import fr.rodez3il.a2022.mrmatt.sources.objets.ObjetPlateau;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;

public class Pomme extends ObjetPlateau {

  /*
   * Affiche le caractère ASCII de la pomme
   * 
   * @Author DewiGirot
   * 
   * @return retourne le caractère "+" qui correspond à la pomme
   */
  public char afficher() {
    return '+';
  }

  /*
   * Permet de savoir si la pomme est marchable par le joueur
   * 
   * @Author DewiGirot
   * 
   * @return retourne vrai
   */
  public boolean estMarchable() {
    return true;
  }

  /*
   * Permet d'utiliser le patron de conception Visiteur pour une pomme
   * 
   * @param niveau est le niveau actuel joué par le joueur, x et y sont les
   * coordonnées pour lesquelles on va vérifier l'état d'une pomme et appliquer
   * des traitements ou non dans la fonction etatSuivantVisiteur.
   * 
   * @Author DewiGirot
   */
  public void visiterPlateauCalculEtatSuivant(Niveau niveau, int x, int y) {
    niveau.etatSuivantVisiteur(this, x, y);
  }
}