package edu.temple.signupform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText[] arEdtText = new EditText[4];
    Button txtSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Init all EditText
        txtSignup=findViewById(R.id.btnSignUp);
        arEdtText[0]=findViewById(R.id.txtUserName);
        arEdtText[1]=findViewById(R.id.txtEmail);
        arEdtText[2]=findViewById(R.id.txtPassword);
        arEdtText[3]=findViewById(R.id.txtConfirmPassword);

        txtSignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //make sure all fields filled up
                for (EditText editText : arEdtText) {
                    if (editText.getText().toString().length() == 0) {
                        Toast.makeText(getApplicationContext(),
                                "Please " + editText.getHint().toString().toLowerCase(),
                                Toast.LENGTH_LONG).show();
                        return;
                    }
                }

                //make sure the password match
                if (!(arEdtText[2].getText().toString().equals(arEdtText[3].getText().toString()))){
                    Toast.makeText(getApplicationContext(),"Error! Password is not match. Enter again!",
                            Toast.LENGTH_LONG).show();
                    arEdtText[2].setText("");
                    arEdtText[3].setText("");
                    return ;
                }

                Toast.makeText(getApplicationContext(),"Welcome "+
                                arEdtText[0].getText().toString()+"! You are in the SignUpForm App. "
                        , Toast.LENGTH_LONG).show();
            }
        });


    }
}