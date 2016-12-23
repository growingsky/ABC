import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SingUpActivity extends AppCompatActivity implements View.OnClickListener {
    TextView singUp;
    EditText userNameForm;
    EditText singUpEmail;
    private EditText passwordEditText;
    private Button loginButton;
    private String userName;
    private String userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_up);
        userNameForm = (EditText) findViewById(R.id.singUpText);
        passwordEditText = (EditText) findViewById(R.id.singUpPassword);
        singUpEmail = (EditText) findViewById(R.id.singUpEmail);


    }

    public void onClick(View v) {
        userName = userNameForm.getText().toString();
        userPassword = passwordEditText.getText().toString();
        if (userName.isEmpty() || !Character.isUpperCase(userName.substring(0, 1).charAt(0))) {
            Toast.makeText(this, "Имя должно вначинатся с большой буквы", Toast.LENGTH_SHORT).show();
        } else if (userPassword.isEmpty() || userPassword.length() < 6) {
            Toast.makeText(this, "Длина пароля должна быть не менее 6\n" +
                    "символов", Toast.LENGTH_SHORT).show();
        }
        }

    }










