import org.example.ServiceException;
import org.example.UserService;
import org.example.Utilisateur;
import org.example.UtilisateurApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

        @Mock
        private UtilisateurApi utilisateurApiMock;
        @Test
        public void testCreerUtilisateur() throws ServiceException {
            // Création d'un nouvel utilisateur
            Utilisateur utilisateur = new Utilisateur("Jean", "Dupont","jeandupont@email.com");
            // TODO : Configuration du comportement du mock, utiliser la
            //directive « when » avec sa méthode « thenReturn »
            doThrow(new ServiceException("Echec de la création de l'utilisateur")).when(utilisateurApiMock).creerUtilisateur(utilisateur);

            doNothing().when(utilisateurApiMock).creerUtilisateur(utilisateur);
            // TODO : Création du service avec le mock
            UtilisateurApi userService = new UserService(utilisateurApiMock);
            // TODO : Appel de la méthode à tester
            userService.creerUtilisateur(utilisateur);
            // TODO : Vérification de l'appel à l'API
            verify(utilisateurApiMock, times(1)).creerUtilisateur(utilisateur);
        }


    @Test
    public void testCreerUtilisateur_EchecCreation() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Configuration du mock pour lever une exception lors de la création de l'utilisateur
        doThrow(new ServiceException("Echec de la création de l'utilisateur")).when(utilisateurApiMock).creerUtilisateur(utilisateur);

        // Création du service avec le mock
        UserService userService = new UserService(utilisateurApiMock);

        // Throw Excptn
        assertThrows(ServiceException.class, () -> userService.creerUtilisateur(utilisateur));
    }


    @Test
    public void testCreerUtilisateur_ErreurValidation() throws ServiceException {
        // Création d'un nouvel utilisateur avec un email invalide
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "invalidemail");
        UserService userService = new UserService(utilisateurApiMock);
        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Vérification que la méthode de validation n'est jamais appelée
        verify(utilisateurApiMock, never()).creerUtilisateur(utilisateur);
    }

    @Test
    public void testCreerUtilisateur_AvecID() throws ServiceException {
        // Création d'un nouvel utilisateur
        Utilisateur utilisateur = new Utilisateur("Jean", "Dupont", "jeandupont@email.com");

        // Définition d'un ID fictif
        int idUtilisateur = 123;
        utilisateur.setId(idUtilisateur);
        // Configuration du mock pour renvoyer l'ID

        when(utilisateurApiMock.getIDUtilisateur(utilisateur)).thenReturn(idUtilisateur);

        UserService userService = new UserService(utilisateurApiMock);

        // Appel de la méthode à tester
        userService.creerUtilisateur(utilisateur);

        // Vérification de l'ID de l'utilisateur
        assertEquals(idUtilisateur, utilisateur.getId());
    }


}
