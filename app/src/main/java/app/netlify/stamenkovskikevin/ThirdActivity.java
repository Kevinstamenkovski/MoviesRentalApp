package app.netlify.stamenkovskikevin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        TextView textViewConfirmation = findViewById(R.id.textViewConfirmation);
        Button buttonYes = findViewById(R.id.buttonYes);
        Button buttonNo = findViewById(R.id.buttonNo);

        Intent intent = getIntent();
        if (intent != null) {
            String movieName = intent.getStringExtra("movieName");
            String releaseDate = intent.getStringExtra("releaseDate");
            String selectedGenre = intent.getStringExtra("selectedGenre");
            String timeRent = intent.getStringExtra("time");
            String priceRent = intent.getStringExtra("price");

            String confirmationText = "Do you want to rental: " + movieName + " \nof: " + releaseDate + ", \ngenre: " + selectedGenre + ", for " + timeRent + "?";
            textViewConfirmation.setText(confirmationText);
            buttonYes.setText(priceRent + "$");
        }

        buttonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ThirdActivity.this, "Book rented", Toast.LENGTH_SHORT).show();
            }
        });

        buttonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}