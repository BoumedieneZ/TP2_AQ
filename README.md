# Tests Unitaires TP2 Mockups
Ce travail pratique (TP) a pour objectif est de familiariser avec l'utilisation de Mockito pour les tests unitaires en Java. Mockito est un framework de test Java qui permet de simuler des objets et
de définir leur comportement pour faciliter les tests unitaires.
# Exercice 01 : 
## Explications pour chaque TODO dans CalculatriceTest.java
### TODO : Appel de la méthode à tester
Nous appelons la méthode `additionner(2, 3)` de l'objet calculatrice pour vérifier son comportement et obtenir le résultat de l'addition.
### TODO : Vérification du résultat
Nous vérifions que le résultat de l'addition (2 + 3) est égal à 4 (Juste pour le teste, malgré elle le résultat est fausse) en utilisant l'assertion `assertEquals(4, result)` fournie par JUnit.
### TODO : Vérification que la méthode "additionner" a été appelée
Nous utilisons la directive `verify(calculatrice).additionner(2,3)` pour vérifier que la méthode additionner a bien été appelée.
### TODO : Vérification qu'aucune autre méthode n'a été appelée sur l'objet
Nous utilisons la méthode `verifyNoMoreInteractions(calculatrice)` pour nous assurer qu'aucune autre méthode n'a été appelée sur l'objet calculatrice après l'appel de la méthode `additionner`.
### TODO : Vérification de l'état de l'objet après l'appel de la méthode "additionner"
Nous utilisons la méthode `getState()` de l'objet calculatrice pour obtenir l'état de l'objet après l'appel de la méthode `additionner`. Ensuite, nous vérifions que la méthode `getState()` a bien été appelée sur l'objet `calculatrice`.

# Exercice 02 : 
## Explication des `TODO` dans `UserServiceTest`
### TODO : Configuration du comportement du mock
Dans cette partie, nous configurons le comportement du mock `utilisateurApiMock` pour la méthode `creerUtilisateur`. Comme cette méthode est de type `void` et ne retourne rien, nous utilisons `doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);` pour indiquer à `Mockito` de ne rien faire lors de l'appel à cette méthode sur le mock.
### TODO : Création du service avec le mock
Nous créons une instance du service `UserService` en utilisant le mock `utilisateurApiMock` que nous avons configuré précédemment.
### TODO : Appel de la méthode à tester
Nous appelons la méthode `creerUtilisateur` sur notre instance du service `UserService` en passant un objet `Utilisateur` en paramètre.
## TODO : Vérification de l'appel à l'API
Nous utilisons `verify(utilisateurApiMock, times(1)).creerUtilisateur(utilisateur);` pour vérifier que la méthode `creerUtilisateur` de l'API des utilisateurs a bien été appelée.


# Exercice 3 : Mocker un service externe avec différents scénarios
