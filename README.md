# Projet Mr. Matt

  ## Ce que j'ai réalisé 
  
  bla bla bla.

  ## Réponses aux questions
  
  **Classe ObjetPlateau**
   - Question : pourquoi cette classe est-elle abstraite ?
   - Réponse : Cette classe est asbtraite car elle sert de mère à tous les objets du plateau du niveau. Ainsi tous les objets du plateau vont l'étendre en modifier le comportement des méthodes abstracts.

  **Classe Niveau - Première passe**
   - Question : pourquoi cette méthode est-elle privée ?
   - Réponse : Cette méthode est privée puisqu'on ne souhaite pas que l'utilisateur puisse changer la position du joueur et d'un mur par exemple

  **Classe Niveau - Déplacement trivial**
   - Question : pourquoi ces deux méthodes sont-elles privées ?
   - Réponse : Les deux méthodes sont privées puisque l'on souhaite que le joueur ne se déplace seulement grâce aux touches authorisées (ex: 8 pour déplacement vers le haut).

  **Calcul de l'état suivant -  Petit problème**
   - Question : quel est le problème d'une telle implémentation, d'après le cours ?
   - Réponse : Puisque l'utilisation de instanceOf pose problème. En effet puisque que dans un design qui utilise l'héritage, si on rajoute une classe, on doit changer des choses dans les autres classes qui héritent de la même classe.

  **Question finale**
   - Question : pourquoi la méthode etatSuivant() est-elle publique ?
   - Réponse : La méthode etatSuivant() est publique puisque dans la classe Pomme, nous l'utilisons.

  
  ## Retour personnel sur les points paru difficiles
  
  Ce qui m'a semblé difficile a été ...
  
  ## Autre commentaire