package tom.com.textbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity {

    private static final String TAG = "firebaseSignin ";
    private EditText mEmailEdit;
    private EditText mPasswordEdit;
    private EditText mConfirmPassword;
    private EditText mDisplayName;

    private Button mLogonButton;
    private TextView mRegisterText;

    boolean mLoginProgress = false;
    boolean mRegisterProgress = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Log.e(TAG,"starting sign in Activity");

        mEmailEdit = findViewById(R.id.emailEd);
        mPasswordEdit = findViewById(R.id.passwordEd);
        mConfirmPassword = findViewById(R.id.confirmPw);
        mDisplayName = findViewById(R.id.displayName);

        mLogonButton = findViewById(R.id.logon);
        mRegisterText = findViewById(R.id.register);

        mEmailEdit.setVisibility(View.GONE);
        mPasswordEdit.setVisibility(View.GONE);
        mConfirmPassword.setVisibility(View.GONE);
        mDisplayName.setVisibility(View.GONE);

        mLogonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRegisterProgress = false;
                if (! mLoginProgress){
                    mEmailEdit.setVisibility(View.VISIBLE);
                    mPasswordEdit.setVisibility(View.VISIBLE);
                    mConfirmPassword.setVisibility(View.GONE);
                    mDisplayName.setVisibility(View.GONE);
                    mLoginProgress = true;
                }else{
                    //login
                }


            }
        });

        mRegisterText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mLoginProgress = false;
                if (! mRegisterProgress){
                    mEmailEdit.setVisibility(View.VISIBLE);
                    mPasswordEdit.setVisibility(View.VISIBLE);
                    mConfirmPassword.setVisibility(View.VISIBLE);
                    mDisplayName.setVisibility(View.VISIBLE);
                    mRegisterProgress = true;
                }else{
                    //login
                }
            }
        });
    }
}
