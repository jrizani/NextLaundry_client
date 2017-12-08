package id.juliannr.newnextlaundry.network;

import id.juliannr.newnextlaundry.network.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by root on 08/12/17.
 */

public interface UserApi {
    @GET("/user")
    Call<UserResponse> login(@Query("u") String username);
}
