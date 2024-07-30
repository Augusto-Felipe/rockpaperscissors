package devandroid.felipe.pedrapapeltesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView computerChoiceImage;
    private TextView resultTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selectRock(View view) {
        verifyWinner("Rock");
    }

    public void selectPaper(View view) {
        verifyWinner("Paper");
    }

    public void selectScissors(View view) {
        verifyWinner("Scissors");
    }

    private String generateComputerChoice() {
        computerChoiceImage = findViewById(R.id.computerChoiceImage);
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        String[] options = {"Rock", "Paper", "Scissors"};

        String computerChoice = options[randomNumber];

        switch (computerChoice) {
            case "Rock":
                computerChoiceImage.setImageResource(R.drawable.pedra);
                break;
            case "Paper":
                computerChoiceImage.setImageResource(R.drawable.papel);
                break;
            case "Scissors":
                computerChoiceImage.setImageResource(R.drawable.tesoura);
                break;
        }

        return options[randomNumber];
    };

    public void verifyWinner(String playerChoice) {

        String computerChoice = generateComputerChoice();
        resultTxt = findViewById(R.id.txtResult);

        if (
                (playerChoice == "Rock" && computerChoice == "Scissors") ||
                (playerChoice == "Paper" && computerChoice == "Rock") ||
                (playerChoice == "Scissors" && computerChoice == "Paper")
        ) {
            resultTxt.setText("Você ganhou!!!");
        } else if (
                (computerChoice == "Rock" && playerChoice == "Scissors") ||
                (computerChoice == "Paper" && playerChoice == "Rock") ||
                (computerChoice == "Scissors" && playerChoice == "Paper")
        ) {
            resultTxt.setText("Você perdeu!!!");
        } else {
            resultTxt.setText("Empate!!!");
        }
    }
}