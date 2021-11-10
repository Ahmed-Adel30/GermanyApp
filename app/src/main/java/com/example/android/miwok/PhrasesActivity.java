package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<words> word= new ArrayList <words>();
        words w = new words("Good morning","Guten Tag ", R.raw.good_morning);
        word.add(w);
        word.add( new words("Good evening", "Guten Abend", R.raw.good_evening));
        word.add( new words("Good night", "Gute Nacht",R.raw.good_night ));
        word.add(new words("My name is …", "Ich heiße …",R.raw.my_name));
        word.add( new words("What’s your name?", "Wie heißt du?",R.raw.what_is_your_name));
        word.add( new words("How are you?", "Wie geht es dir?",R.raw.how_are_you));
        word.add( new words("Where are you from?", "Woher kommen Sie?",R.raw.whrer_are_you_from));
        word.add( new words(" Fine, thank you", "Gut, danke",R.raw.ok_thx));
        word.add( new words("Nice to meet you ", "Freut mich ",R.raw.nice_to_meet_you));
        word.add( new words("Thank you very much", "Vielen Dank ",R.raw.thx_very_much));
        word.add( new words("Goodbye ", " Auf Wiedersehen",R.raw.good_bye));
        word.add( new words("I love you", "Ich liebe dich ",R.raw.i_love_you));



        word_adapter adapter = new word_adapter(this, word,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                words Words =word.get(position);
                releaseMediaPlayer();

                mMediaPlayer= MediaPlayer.create(PhrasesActivity.this, Words.getmAudioResourceId() );
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mMediaPlayer) {
                        releaseMediaPlayer();
                    }

                });
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }


    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}