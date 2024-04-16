package org.example;

public class UserService implements UtilisateurApi {

    private final UtilisateurApi utilisateurApi;
    public UserService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }
    public void creerUtilisateur(Utilisateur utilisateur) throws ServiceException {
        utilisateurApi.creerUtilisateur(utilisateur);
    }



    @Override
    public int getIDUtilisateur(Utilisateur utilisateur) {
        return utilisateur.getId();
    }


}
