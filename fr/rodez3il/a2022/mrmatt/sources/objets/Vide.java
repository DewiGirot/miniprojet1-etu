package fr.rodez3il.a2022.mrmatt.sources.objets;

public class Vide implements ObjetPlateau {

  public Vide() {
  }

  public char afficher() {
    return ' ';
  }

  public boolean estVide() {
    return true;
  }

  public boolean estMarchable() {
    return true;
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