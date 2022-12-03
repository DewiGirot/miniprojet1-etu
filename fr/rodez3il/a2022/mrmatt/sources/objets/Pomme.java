package fr.rodez3il.a2022.mrmatt.sources.objets;

import fr.rodez3il.a2022.mrmatt.sources.objets.ObjetPlateau;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;

public class Pomme extends ObjetPlateau {

  public Pomme() {
  }

  public char afficher() {
    return '+';
  }
  
  public boolean estMarchable() {
    return true;
  }

  public void visiterPlateauCalculEtatSuivant(Niveau niveau, int x, int y) {
  }

}