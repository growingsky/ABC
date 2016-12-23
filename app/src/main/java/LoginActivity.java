import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    TextView singUp;
    private EditText loginEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private String userName;
    private String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEditText = (EditText) findViewById(R.id.loginText);
        passwordEditText = (EditText) findViewById(R.id.passwordText);
        loginButton = (Button) findViewById(R.id.login_button);
        userPassword = passwordEditText.getText().toString();
        singUp = (TextView) findViewById(R.id.singUpText);
        Log.i("", "");


    }


    public void clickFunction(View v) {
        Intent intent = new Intent(this, SingUpActivity.class);
        startActivity(intent);
    }


    public void onClick(View view) {
        userName = loginEditText.getText().toString();
        userPassword = passwordEditText.getText().toString();
        if (userName.isEmpty() || userPassword.isEmpty()) {
            Toast toast = Toast.makeText(this, getResources().getString(R.string.toast_inputAllFields),
                    Toast.LENGTH_SHORT);
            toast.show();
        } else if (userPassword.length() < 6) {
            Toast toast = Toast.makeText(this, "Длина пароля должна быть не менее 6\n" +
                    "символов", Toast.LENGTH_SHORT);
            toast.show();
        }else {
            Intent inten = new Intent(this, UserList.class);
            startActivity(inten);
        }

    }

}






