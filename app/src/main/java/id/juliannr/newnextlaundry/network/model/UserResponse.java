package id.juliannr.newnextlaundry.network.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by root on 08/12/17.
 */

public class UserResponse implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("username")
    private String username;
    @SerializedName("pass")
    private String pass;
    @SerializedName("nama")
    private String nama;
    @SerializedName("noHp")
    private String noHp;

    public UserResponse() {
    }

    public UserResponse(int id, String username, String pass, String nama, String noHp) {
        this.id = id;
        this.username = username;
        this.pass = pass;
        this.nama = nama;
        this.noHp = noHp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }
}
