package main.viikko9;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddUserActivity extends AppCompatActivity {

    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private RadioGroup studyProgram;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        firstName = findViewById(R.id.editFirstName);
        lastName = findViewById(R.id.editLastName);
        email = findViewById(R.id.editEmail);
        studyProgram = findViewById(R.id.radioDegreeProgram);

    }

    public void addUser(View view) {
        String program;

        String first_Name = firstName.getText().toString();
        String last_Name = lastName.getText().toString();
        String e_mail= email.getText().toString();

        int id = studyProgram.getCheckedRadioButtonId();
        if (id == R.id.seRadioButton) {
            program = "Software engineering";
        }
        else if (id == R.id.imRadioButton) {
            program = "Industrial engineering";
        }
        else if (id == R.id.ceRadioButton) {
            program = "Computational engineering";
        }
        else if (id == R.id.eeRadioButton) {
            program = "Electrical engineering";
        }
        else {
            program = "";
        }

        UserStorage.getInstance().addUser(new User(first_Name,last_Name,e_mail,program));
    }
}