package id.juliannr.newnextlaundry.network;



import id.juliannr.newnextlaundry.network.model.UserResponse;
import retrofit2.Call;

/**
 * Created by root on 08/12/17.
 */

public class UserApiService {
    private static UserApiService instance;

    public static UserApiService getInstance(){
        if(instance == null){
            instance = new UserApiService();
        }
        return instance;
    }

    public UserApiService() {
    }

    public Call<UserResponse> login(String username){
        return ApiServer.getUserApi().login(username);
    }
}
