package id.juliannr.newnextlaundry.presenter;

/**
 * Created by root on 08/12/17.
 */

public interface LoginPresenter {
    void validateCredentials(String username, String pass);
    void onDestroy();
}
