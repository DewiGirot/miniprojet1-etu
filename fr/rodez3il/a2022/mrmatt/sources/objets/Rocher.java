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
    niveau.etatSuivantVisiteur(this, x, y);
  }

}