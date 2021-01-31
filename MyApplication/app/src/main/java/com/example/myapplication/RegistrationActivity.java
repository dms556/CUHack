/*package com.example.myapplication.;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText uName, uPass, uEmail;
    private Button regisButton;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        uName =  findViewById(R.id.name);
        uEmail = findViewById(R.id.email);
        uPass = findViewById(R.id.password);
        regisButton = findViewById(R.id.regButton);

        fAuth = FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        regisButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = uName.getText().toString().trim();
                String password = uPass.getText().toString().trim();
                String email = uEmail.getText().toString().trim();

                if (TextUtils.isEmpty(name)) {
                    uName.setError("Name is required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    uPass.setError("Password is required");
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    uEmail.setError("Email is required");
                    return;
                }

                if (password.length() < 0) {
                    uPass.setError("Password must be more than 4 characters");
                }

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(RegistrationActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else{
                            Toast.makeText(RegistrationActivity.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}
/
 */

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class RegistrationActivity extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_registration, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.regButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RegistrationActivity.this)
                        .navigate(R.id.action_RegistrationActivity_to_FirstFragment);
            }
        });
    }

}