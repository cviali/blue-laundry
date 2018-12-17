package binus.viali.bluelaundry;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity{

    private EditText etUsername, etPass;
    private TextView tvError;
    private Button btnLogin;
    public static final String EXTRA_USERNAME = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.input_username);
        etPass = findViewById(R.id.input_password);
        btnLogin = findViewById(R.id.button_login);
        tvError = findViewById(R.id.text_error);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPass.getText().toString();

                if(username.trim().isEmpty()){
                    //tvError.setText("Username must be filled!");
                    etUsername.setError("Username must be filled!"); //munculin error di EditText
                } else if(username.trim().length() < 5){
                    //tvError.setText("Username must be greater than 5!");
                    etUsername.setError("Username must be greater than 5!"); //munculin error di EditText
                } else if(password.trim().isEmpty()){
                    //tvError.setText("Password must be filled!");
                    etPass.setError("Password must be filled!");
                } else{
                    Intent i = new Intent(Login.this, Home.class);
                    i.putExtra(EXTRA_USERNAME, username); //passing string ke halaman intent
                    startActivity(i);
                }
            }
        });
    }
}
