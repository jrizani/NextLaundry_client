package id.juliannr.newnextlaundry.network.model;

import android.annotation.SuppressLint;

import id.juliannr.newnextlaundry.network.UserApiService;

/**
 * Created by root on 08/12/17.
 */

public class ApiServerService {
    @SuppressLint("StaticFieldLeak")
    private static ApiServerService instance;

    public ApiServerService() {
    }

    public static synchronized ApiServerService getInstance(){
        if(instance == null){
            instance = new ApiServerService();
        }
        return instance;
    }

    public UserApiService getUserApiService(){
        return UserApiService.getInstance();
    }
}
