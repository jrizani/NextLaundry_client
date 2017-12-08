package id.juliannr.newnextlaundry.view;

/**
 * Created by root on 08/12/17.
 */

public interface LoginView {
    void showProgress();
    void hideProgress();
    void setUsernameError(String message);
    void setPassError(String message);
    void navigateToHome();
}
