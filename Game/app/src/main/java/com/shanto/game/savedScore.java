package com.shanto.game;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by The Dark Knight on 5/13/2017.
 */

public class savedScore extends Activity {

    private int bestScore ;

    public void saveScore(int bs) {
        SharedPreferences prefs = getSharedPreferences("bestScore", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("best", bs);
        editor.apply();
    }

    public int getBest()
    {
        SharedPreferences prefs = getSharedPreferences("bestScore", Context.MODE_PRIVATE);

        bestScore = prefs.getInt("best", 0);
        return bestScore;
    }

    //getting preferences
   // public void geSharedPreferences() {
     //   SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
    //    int bestScore = prefs.getInt(GamePanel.best, 0); //0 is the default value
 //   }
}
