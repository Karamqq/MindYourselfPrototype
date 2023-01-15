package com.example.prototype2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import java.util.Random;
public class QuotesActivity extends AppCompatActivity {
    //initialising variables
    private Button button;
    private CardView quotecard;
    private CardView Backcard;
    private TextView quoteText;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotes);

        //linking variables to view
        button = (Button) findViewById(R.id.press);
        quoteText = (TextView) findViewById(R.id.text_quotes);

        quotecard = (CardView) findViewById(R.id.card_quote);
        Backcard = (CardView) findViewById(R.id.card_back);

        //accessing string resources and setting them to Strings
        String quote = getResources().getString(R.string.quote);
        String quote1 = getResources().getString(R.string.quote1);
        String quote2= getResources().getString(R.string.quote2);
        String quote3 = getResources().getString(R.string.quote3);
        String quote4 = getResources().getString(R.string.quote4);
        String quote5 = getResources().getString(R.string.quote5);
        String quote6 = getResources().getString(R.string.quote6);
        String quote7 = getResources().getString(R.string.quote7);
        String quote8 = getResources().getString(R.string.quote8);
        String quote9 = getResources().getString(R.string.quote9);
        String quote10 = getResources().getString(R.string.quote10);



        //sets the text view to the text view
        TextView textView = findViewById(R.id.text_quotes);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);
        String[] words = {quote, quote1,quote2,quote3,quote4,quote5,quote6,quote7,quote8,quote9,quote10};
        int[] colors = { R.color.purple_200,R.color.purple_500,R.color.purple_700};
        int[] bcolors = {R.color.gray, R.color.silver, R.color.LightSlateGray, R.color.DarkGray,R.color.LightGrey};


        //on click, sets random quote, colour from selection and runs animation
        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int index = random.nextInt(words.length);
                String randomWord = words[index];
                textView.startAnimation(animation);
                TextView textView = findViewById(R.id.text_quotes);
                textView.setText(randomWord);
                int cIndex = new Random().nextInt(colors.length);
                int color1 = colors[cIndex];
                int cIndex1 = new Random().nextInt(bcolors.length);
                int color2 = bcolors[cIndex1];


                quoteText.setTextColor(getResources().getColor(R.color.white));

                quotecard.startAnimation(animation);
                quotecard.setCardBackgroundColor(getResources().getColor(color1));

                Backcard.startAnimation(animation);
                Backcard.setCardBackgroundColor(getResources().getColor(color2));

            }
        });





        }

}
