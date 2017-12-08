package id.juliannr.newnextlaundry.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.anthonycr.grant.PermissionsManager;
import com.anthonycr.grant.PermissionsResultAction;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import id.juliannr.newnextlaundry.R;
import id.juliannr.newnextlaundry.presenter.LoginPresenter;
import id.juliannr.newnextlaundry.presenter.LoginPresenterImpl;
import id.juliannr.newnextlaundry.view.LoginView;
import id.juliannr.newnextlaundry.widget.SimpleSnackbar;

public class LoginActivity extends AppCompatActivity implements LoginView{

    @BindView(R.id.userName)
    EditText userName;
    @BindView(R.id.progress)
    ProgressBar progressBar;
    @BindView(R.id.pass)
    EditText pass;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        PermissionsManager.getInstance().requestAllManifestPermissionsIfNecessary(this, new PermissionsResultAction() {
            @Override
            public void onGranted() {
                ButterKnife.bind(LoginActivity.this);
                presenter = new LoginPresenterImpl(LoginActivity.this);
            }

            @Override
            public void onDenied(String permission) {
                SimpleSnackbar.showError(findViewById(R.id.root), "Izin ditolak, tidak bisa membuka aplikasi");
            }
        });

    }

    @OnClick({R.id.btnLogin})
    public void onViewClick(View view){
        switch (view.getId()){
            case R.id.btnLogin:
                presenter.validateCredentials(userName.getText().toString(), pass.getText().toString());
                break;
        }
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void setUsernameError(String message) {
        userName.setError(message);
        userName.requestFocus();
    }

    @Override
    public void setPassError(String message) {
        pass.setError(message);
        pass.requestFocus();
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        //finish();
    }
}
