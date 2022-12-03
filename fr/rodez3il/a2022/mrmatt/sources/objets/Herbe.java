package fr.rodez3il.a2022.mrmatt.sources.objets;

import fr.rodez3il.a2022.mrmatt.sources.objets.ObjetPlateau;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;

public class Herbe extends ObjetPlateau {

  public char afficher() {
    return '-';
  }

  public boolean estMarchable() {
    return true;
  }

}