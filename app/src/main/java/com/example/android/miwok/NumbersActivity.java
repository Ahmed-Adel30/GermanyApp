package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.UserDictionary;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList <words> word= new ArrayList <words>();
        words w = new words("One","Eins", R.drawable.number_one, R.raw.one);
        word.add(w);
        word.add(new words("Two", "Zwei",R.drawable.number_two ,R.raw.two));
        word.add( new words("Three", "Drei",R.drawable.number_three,R.raw.three));
        word.add( new words("Four", "Vier",R.drawable.number_four,R.raw.four));
        word.add( new words("Five", "Funf",R.drawable.number_five,R.raw.five));
        word.add( new words("Six", "Sechs",R.drawable.number_six,R.raw.six));
        word.add( new words("Seven", "Sieben",R.drawable.number_seven,R.raw.seven));
        word.add( new words("Eight", "Acht",R.drawable.number_eight,R.raw.eight));
        word.add( new words("Nine", "Neun",R.drawable.number_nine,R.raw.nine));
        word.add( new words("Ten", "Zehn",R.drawable.number_ten,R.raw.ten));



        word_adapter adapter = new word_adapter(this, word,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                words Words = word.get(position);
                releaseMediaPlayer();
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, Words.getmAudioResourceId());
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

    /**
     * Clean up the media player by releasing its resources.
     */
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