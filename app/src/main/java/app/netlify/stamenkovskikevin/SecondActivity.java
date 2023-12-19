package app.netlify.stamenkovskikevin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int position;
    private String price;
    private String time;
    private EditText editTextMovieTitle;
    private EditText editTextYear;
    private RadioButton radioButtonGenre1;
    private RadioButton radioButtonGenre2;
    private RadioButton radioButtonGenre3;
    private RadioButton radioButtonGenre4;
    private Button buttonSubmit;
    ArrayList movies = getMovies();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.rent_time, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        editTextMovieTitle = findViewById(R.id.editTextMovieTitle);
        editTextYear = findViewById(R.id.editTextYear);
        radioButtonGenre1 = findViewById(R.id.radioButtonGenre1Second);
        radioButtonGenre2 = findViewById(R.id.radioButtonGenre2Second);
        radioButtonGenre3 = findViewById(R.id.radioButtonGenre3Second);
        radioButtonGenre4 = findViewById(R.id.radioButtonGenre4Second);

        buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitMovieDetails();
            }
        });
        Button buttonLogout = findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void submitMovieDetails() {
        switch(position){
            case 0:
                price = "3";
                time = "5 Days";
                break;
            case 1:
                price = "5";
                time = "1 Week";
                break;
            case 2:
                price = "9";
                time = "2 Weeks";
                break;
            case 3:
                price = "13";
                time = "3 Weeks";
                break;
            case 4:
                price = "17";
                time = "1 Month";
                break;
            default:
                Toast.makeText(this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                return;
        }
        String movieTitle = editTextMovieTitle.getText().toString().trim();
        String year = editTextYear.getText().toString().trim();

        String selectedGenre = "";

        if (radioButtonGenre1.isChecked()) {
            selectedGenre = radioButtonGenre1.getText().toString();
        } else if (radioButtonGenre2.isChecked()) {
            selectedGenre = radioButtonGenre2.getText().toString();
        } else if (radioButtonGenre3.isChecked()) {
            selectedGenre = radioButtonGenre3.getText().toString();
        }else if (radioButtonGenre4.isChecked()) {
            selectedGenre = radioButtonGenre4.getText().toString();
        }

        if (movieTitle.isEmpty() || year.isEmpty() || selectedGenre.isEmpty()) {
            Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show();
        } else {
            String message = "Title: " + movieTitle + "\nYear: " + year + "\nGenre: " + selectedGenre;
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            intent.putExtra("movieName", editTextMovieTitle.getText().toString());
            intent.putExtra("releaseDate", editTextYear.getText().toString());
            intent.putExtra("selectedGenre", selectedGenre);
            intent.putExtra("price", price);
            intent.putExtra("time", time);
            startActivity(intent);
        }



    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String timeSelected = parent.getItemAtPosition(position).toString();
        this.position = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public ArrayList<Movies> getMovies(){
        ArrayList<Movies> movies = new ArrayList<>();
        movies.add(new Movies("The Shawshank Redemption", 1994, "Drama"));
        movies.add(new Movies("The Godfather", 1972, "Crime"));
        movies.add(new Movies("The Dark Knight", 2008, "Action"));
        movies.add(new Movies("Pulp Fiction", 1994, "Crime"));
        movies.add(new Movies("Forrest Gump", 1994, "Drama"));
        return movies;
    }
}