package fr.rodez3il.a2022.mrmatt.sources.objets;

import fr.rodez3il.a2022.mrmatt.sources.objets.ObjetPlateau;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;

public class Vide extends ObjetPlateau {

  /*
   * Affiche le caractère ASCII du vide
   * 
   * @Author DewiGirot
   * 
   * @return retourne le caractère " " qui correspond au vide
   */
  public char afficher() {
    return ' ';
  }

  /*
   * Permet de savoir si le vide est (de type) vide
   * 
   * @Author DewiGirot
   * 
   * @return retourne vrai
   */
  public boolean estVide() {
    return true;
  }

  /*
   * Permet de savoir si le vide est marchable par le joueur
   * 
   * @Author DewiGirot
   * 
   * @return retourne vrai
   */
  public boolean estMarchable() {
    return true;
  }
}