package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColoresActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colores);

        final ArrayList<words> word= new ArrayList <words>();
        words w = new words("Red","Rot",R.drawable.color_red,R.raw.red);
        word.add(w);
        word.add( new words("Yellow", "Gelb",R.drawable.color_mustard_yellow,R.raw.yellow));
        word.add( new words("Orange", "Orange",R.drawable.color_dusty_yellow,R.raw.orange));
        word.add(new words("Green", "Grün",R.drawable.color_green,R.raw.green));
        word.add( new words("White", "Weiß",R.drawable.color_white,R.raw.white));
        word.add( new words("Brown", "Braun",R.drawable.color_brown,R.raw.brown));
        word.add( new words("Gray", "Grau",R.drawable.color_gray,R.raw.gray));
        word.add( new words("Black", "Schwarz",R.drawable.color_black,R.raw.black));






        word_adapter adapter = new word_adapter(this, word,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                words Words =word.get(position);
                releaseMediaPlayer();
                 mMediaPlayer= MediaPlayer.create(ColoresActivity.this, Words.getmAudioResourceId() );
                mMediaPlayer.start();

                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mMediaPlayer) {
                        releaseMediaPlayer();
                    }

                });
            }
        });
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