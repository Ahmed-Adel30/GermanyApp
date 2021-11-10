package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        final ArrayList<words> word= new ArrayList <words>();
        words w = new words("Father","Vater", R.drawable.family_father,R.raw.father);
        word.add(w);
        word.add(new words("Mother", "Mutter",R.drawable.family_mother,R.raw.mother));
        word.add( new words("Son", "Sohn",R.drawable.family_son,R.raw.son));
        word.add( new words("Daughter", "Tochter",R.drawable.family_daughter,R.raw.duaghter));
        word.add( new words("Older brother", "älterer Bruder",R.drawable.family_older_brother,R.raw.older_pro));
        word.add( new words("Younger brother", "jüngerer Bruder",R.drawable.family_younger_brother,R.raw.youngpro));
        word.add( new words("Older sister", "älterer Schwester",R.drawable.family_older_sister,R.raw.older_sis));
        word.add( new words("Younger sister", "jüngere Schwester",R.drawable.family_younger_sister,R.raw.young_sis));
        word.add( new words("Grandmother", "Großmutter",R.drawable.family_grandmother,R.raw.grandma));
        word.add( new words("Grandfather", "Großvater",R.drawable.family_grandfather,R.raw.grandpa));





        word_adapter adapter = new word_adapter(this, word,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                words Words =word.get(position);
                releaseMediaPlayer();
                 mMediaPlayer= MediaPlayer.create(FamilyActivity.this, Words.getmAudioResourceId() );
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