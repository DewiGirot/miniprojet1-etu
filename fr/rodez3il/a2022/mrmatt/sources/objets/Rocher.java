package fr.rodez3il.a2022.mrmatt.sources.objets;

import fr.rodez3il.a2022.mrmatt.sources.objets.ObjetPlateau;
import fr.rodez3il.a2022.mrmatt.sources.objets.EtatRocher;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;

public class Rocher extends ObjetPlateau {

  private EtatRocher etat;

  public Rocher() {
  }

  public EtatRocher getEtat() {
    return this.etat;
  }

  public void setEtat(EtatRocher e) {
    this.etat = e;
  }

  /*
   * Affiche le caractère ASCII du rocher
   * 
   * @Author DewiGirot
   * 
   * @return retourne le caractère "*" qui correspond au rocher
   */
  public char afficher() {
    return '*';
  }

  /*
   * Permet de savoir si un objet est poussable par le joueur. le rocher l'étant
   * on retourne vrai
   * 
   * @Author DewiGirot
   * 
   * @return retourne vrai
   */
  public boolean estPoussable() {
    return true;
  }

  /*
   * Permet de savoir si un objet est glissant, le rocher va pouvoir
   * tomber et glisser sur d'autres objets donc c'est vrai
   * 
   * @Author DewiGirot
   * 
   * @return retourne vrai
   */
  public boolean estGlissant() {
    return true;
  }

  /*
   * Permet d'utiliser le patron de conception Visiteur pour un rocher
   * 
   * @param niveau est le niveau actuel joué par le joueur, x et y sont les
   * coordonnées pour lesquelles on va vérifier l'état d'un rocher et appliquer
   * des traitements ou non dans la fonction etatSuivantVisiteur.
   * 
   * @Author DewiGirot
   */
  public void visiterPlateauCalculEtatSuivant(Niveau niveau, int x, int y) {
    niveau.etatSuivantVisiteur(this, x, y);
  }

}