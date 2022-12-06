package fr.rodez3il.a2022.mrmatt.sources.objets;

import fr.rodez3il.a2022.mrmatt.sources.Niveau;

public abstract class ObjetPlateau {
  /**
   * Fabrique des objets
   * 
   * @param chr le symbole à produire
   * @return la classe ObjetPlateau correspondante
   */
  public static ObjetPlateau depuisCaractere(char chr) {
    ObjetPlateau nouveau = null;
    switch (chr) {
      case '-':
        nouveau = new Herbe();
        break;
      case '+':
        nouveau = new Pomme();
        break;
      case '*':
        nouveau = new Rocher();
        break;
      case ' ':
        nouveau = new Vide();
        break;
      case '#':
        nouveau = new Mur();
        break;
      case 'H':
        nouveau = new Joueur();
        break;
    }
    return nouveau;
  }

  /*
   * Affiche le caractère ASCII de l'objet
   * 
   * @Author DewiGirot
   * 
   * @return retourne le caractère ASCII de l'objet
   */
  public abstract char afficher();

  /*
   * Permet de savoir si un objet est (de type) vide
   * 
   * @Author DewiGirot
   * 
   * @return retourne faux par défault
   */
  public boolean estVide() {
    return false;
  }

  /*
   * Permet de savoir si un objet est marchable par le joueur
   * 
   * @Author DewiGirot
   * 
   * @return retourne faux par défault
   */
  public boolean estMarchable() {
    return false;
  }

  /*
   * Permet de savoir si un objet est poussable par le joueur
   * 
   * @Author DewiGirot
   * 
   * @return retourne faux par défault
   */
  public boolean estPoussable() {
    return false;
  }

  /*
   * Permet de savoir si un objet est glissant, c'est à dire si il va pouvoir
   * tomber et glisser sur d'autres objets
   * 
   * @Author DewiGirot
   * 
   * @return retourne faux par défault
   */
  public boolean estGlissant() {
    return false;
  }

  /*
   * Permet d'utiliser le patron visiteur qui sera utilisé en fonction de la
   * redéfinition de cette fonction
   * 
   * @param niveau est le niveau actuel joué par le joueur, x et y sont les
   * coordonnées pour lesquelles il faut utiliser ce patron visiteur
   * 
   * @Author DewiGirot
   */
  public void visiterPlateauCalculEtatSuivant(Niveau niveau, int x, int y) {
  }

}
