package id.juliannr.newnextlaundry.presenter;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;

import id.juliannr.newnextlaundry.interactor.LoginInteractor;
import id.juliannr.newnextlaundry.interactor.LoginInteractorImpl;
import id.juliannr.newnextlaundry.network.model.ApiServerService;
import id.juliannr.newnextlaundry.network.model.UserResponse;
import id.juliannr.newnextlaundry.view.LoginView;
import id.juliannr.newnextlaundry.widget.SimpleSnackbar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 08/12/17.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private LoginView view;
    private LoginInteractor interactor;
    UserResponse user;

    public LoginPresenterImpl(LoginView view) {
        this.view = view;
        this.interactor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String pass) {
        if(view != null){
            view.showProgress();
        }
        ApiServerService.getInstance().getUserApiService().login(username).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, @NonNull Response<UserResponse> response) {
                new Handler(Looper.getMainLooper()).post(() -> {
                    if(response.isSuccessful()){
                        if(response.body() != null){
                            Log.e("Errorku", "onResponse: " + response.body().getNama());
                            user = response.body();
                        }
                        else {
                            user = new UserResponse();
                            user.setUsername("");
                        }
                    }
                });

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
        interactor.login(username, pass, user, this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void onUsernameError(String message) {
        if(view != null){
            view.setUsernameError(message);
            view.hideProgress();
        }
    }

    @Override
    public void onPassError(String message) {
        if(view != null){
            view.setPassError(message);
            view.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if(view != null){
            view.navigateToHome();
        }
    }
}
