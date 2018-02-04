package com.example.hmku.moodbible;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import com.example.hmku.data.Generator;

public class DisplayMoodActivity extends AppCompatActivity {

    private final int REFERENCE_INDEX = 0;
    private final int VERSE_INDEX = 1;
    private final int TITLE_INDEX = 2;
    private final int ARTIST_INDEX = 3;
    private final int SONG_LINK_INDEX = 4;

    private static String[] output;

    ImageView imageView;
    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_mood);

        // Get the Intent that started this activity and extract the name of the button pressed
        Intent intent = getIntent();
        String buttonName = intent.getStringExtra(MoodSelector.EXTRA_MESSAGE);

        // Based on the mood selected, create a Generator and get the information to output
        Generator g = new Generator();
        output = g.process(buttonName);

        // Set verse
        TextView verse = findViewById(R.id.verse);
        verse.setText("\"" + output[VERSE_INDEX] + "\"");
        TextView reference = findViewById(R.id.reference);
        reference.setText(output[REFERENCE_INDEX]);

        // Set song
        TextView song_text = findViewById(R.id.song_text);
        song_text.setText(output[ARTIST_INDEX] + " - " + output[TITLE_INDEX]);

        // Set animation
        imageView = (ImageView)findViewById(R.id.imageView);
        //if (imageView == null) throw new error AssertionError();
        imageView.setBackgroundResource(R.drawable.animation_gabe);

        anim = (AnimationDrawable)imageView.getBackground();
        anim.start();

    }

    /**
     * Called when user taps the song button.
     */
    public void song_button(View view) {
        Uri uri = Uri.parse(output[SONG_LINK_INDEX]);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
