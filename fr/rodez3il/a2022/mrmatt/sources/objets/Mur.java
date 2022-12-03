package fr.rodez3il.a2022.mrmatt.sources.objets;

public class Mur implements ObjetPlateau {

  public Mur() {
  }

  public char afficher() {
    return '#';
  }

  public boolean estVide() {
    return false;
  }

  public boolean estMarchable() {
    return false;
  }

  public boolean estPoussable() {
    return false;
  }

  public boolean estGlissant() {
    return false;
  }

  public void visiterPlateauCalculEtatSuivant(Niveau niveau, int x, int y) {
  }

}