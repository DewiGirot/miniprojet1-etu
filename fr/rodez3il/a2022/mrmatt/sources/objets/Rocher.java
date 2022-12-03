package fr.rodez3il.a2022.mrmatt.sources.objets;

import fr.rodez3il.a2022.mrmatt.sources.objets.ObjetPlateau;
import fr.rodez3il.a2022.mrmatt.sources.Niveau;

public class Rocher extends ObjetPlateau {

  public Rocher() {
  }

  public char afficher() {
    return '*';
  }

  public boolean estPoussable() {
    return true;
  }

  public boolean estGlissant() {
    return true;
  }

  public void visiterPlateauCalculEtatSuivant(Niveau niveau, int x, int y) {
  }

}