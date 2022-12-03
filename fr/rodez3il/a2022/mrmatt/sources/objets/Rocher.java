package fr.rodez3il.a2022.mrmatt.sources.objets;

public class Rocher implements ObjetPlateau {

  public Rocher() {
  }

  public char afficher() {
    return '*';
  }

  public boolean estVide() {
    return false;
  }

  public boolean estMarchable() {
    return false;
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