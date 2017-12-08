package id.juliannr.newnextlaundry.interactor;



import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import id.juliannr.newnextlaundry.network.model.UserResponse;

/**
 * Created by root on 08/12/17.
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(String username, String pass, UserResponse user, OnLoginFinishedListener listener) {
       new Handler().postDelayed(() -> {
           if(TextUtils.isEmpty(username)){
               listener.onUsernameError("Username harus diisi");
               return;
           }
           else{
               if(user == null){
                   listener.onUsernameError("Username yang anda masukkan tidak terdaftar");
                   return;
               }
               else if(!username.equals(user.getUsername())){
                   listener.onUsernameError("Username yang anda masukkan salah");
                   return;
               }
           }
           if(TextUtils.isEmpty(pass)){
               listener.onPassError("Password harus diisi");
               return;
           }
           else {
               if(!pass.equals(user.getPass())){
                   listener.onPassError("Password yang anda masukkan salah");
                   return;
               }
           }
           listener.onSuccess();
       }, 5000);
    }
}
