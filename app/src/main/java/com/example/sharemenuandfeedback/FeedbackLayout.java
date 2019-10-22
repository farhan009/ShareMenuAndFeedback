package com.example.sharemenuandfeedback;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackLayout extends AppCompatActivity implements View.OnClickListener {

    private EditText fullName, email, feedback;
    private Button submitButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setTitle("");

        setContentView(R.layout.activity_feedback_layout);

        fullName = findViewById(R.id.fullname_id);
        email = findViewById(R.id.email_id);
        feedback = findViewById(R.id.feedback_id);
        submitButton = findViewById(R.id.submit_Button_id);
        clearButton = findViewById(R.id.clear_Button_id);

        submitButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        try {

            String fullName1 = fullName.getText().toString();
            String email1 = email.getText().toString();
            String feedback1 = feedback.getText().toString();

            if (v.getId() == R.id.submit_Button_id){

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"farhanislam910@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from App");
                intent.putExtra(Intent.EXTRA_TEXT, "Name : "+fullName1+ "\nEmail : "+email1+ "\nFeedback : "+feedback1);

                startActivity(intent.createChooser(intent, "Feedback with"));
            }

            if (v.getId() == R.id.clear_Button_id){
                fullName.setText("");
                email.setText("");
                feedback.setText("");
            }

        } catch (Exception e){
            Toast.makeText(FeedbackLayout.this, "Exception : "+e, Toast.LENGTH_SHORT).show();
        }


    }
}
