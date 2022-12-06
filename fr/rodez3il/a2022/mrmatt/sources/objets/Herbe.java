package fr.rodez3il.a2022.mrmatt.sources.objets;

import fr.rodez3il.a2022.mrmatt.sources.objets.ObjetPlateau;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;

public class Herbe extends ObjetPlateau {

  /*
   * Affiche le caractère ASCII de l'herbe
   * 
   * @Author DewiGirot
   * 
   * @return retourne le caractère "-" qui correspond à l'herbe
   */
  public char afficher() {
    return '-';
  }

  /*
   * Permet de savoir si l'herbe est marchable par le joueur
   * 
   * @Author DewiGirot
   * 
   * @return retourne vrai
   */
  public boolean estMarchable() {
    return true;
  }

}