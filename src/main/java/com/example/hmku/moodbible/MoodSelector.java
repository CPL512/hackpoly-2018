package com.example.hmku.moodbible;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MoodSelector extends AppCompatActivity {

    ImageView imageView;
    AnimationDrawable anim;
    ImageView imageView1;
    AnimationDrawable anim1;

    public static final String EXTRA_MESSAGE = "com.example.moodbible.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_selector);

        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.animation_gabe);

        anim = (AnimationDrawable)imageView.getBackground();

        anim.start();
    }

    /** Called when user taps a mood button */
    public void happy(View view) {
        displayMood(view,"happy");
    }

    public void sad(View view) {
        displayMood(view,"sad");
    }

    public void angry(View view) {
        displayMood(view, "angry");
    }

    public void stressed(View view) {
        displayMood(view, "stressed");
    }

    public void burntout(View view) {
        displayMood(view, "burntout");
    }

    public void ashamed(View view) {
        displayMood(view, "ashamed");
    }

    public void jealous(View view) {
        displayMood(view, "jealous");
    }

    public void insecure(View view) {
        displayMood(view, "insecure");
    }

    /** Called for all moods */
    public void displayMood(View view, String buttonName) {
        Intent intent = new Intent(this, DisplayMoodActivity.class);
        intent.putExtra(EXTRA_MESSAGE, buttonName);
        startActivity(intent);
    }

}
