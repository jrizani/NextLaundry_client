package id.juliannr.newnextlaundry.interactor;

import id.juliannr.newnextlaundry.network.model.UserResponse;

/**
 * Created by root on 08/12/17.
 */

public interface LoginInteractor {
    interface OnLoginFinishedListener{
        void onUsernameError(String message);
        void onPassError(String message);
        void onSuccess();
    }
    void login(String username, String pass, UserResponse user, OnLoginFinishedListener listener);
}
