package com.shanto.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by The Dark Knight on 4/10/2017.
 */

public class Player extends GameObject {
    private Bitmap spritesheet;
    private int score;
    private double dya;
    private boolean up;
    private boolean playing;
    private Animation animation = new Animation();
    private long startTime;
    public int p = 80;
    private boolean grounded;

    public Player(Bitmap res, int w, int h, int numFrames) {

        x = 80;
        y = 160;
        dy = 0;
        dx = 0;
        score = 0;
        height = h;
        width = w;

        Bitmap[] image = new Bitmap[numFrames];
        spritesheet = res;

        for (int i = 0; i < image.length; i++) {
            image[i] = Bitmap.createBitmap(spritesheet, i * width, 0, width, height);
        }

        animation.setFrames(image);
        animation.setDelay(p);
        startTime = System.nanoTime();
    }

    public void setUp(boolean b) {
        up = b;
    }

    public void update() {
        long elapsed = (System.nanoTime() - startTime) / 1000000;
        if (elapsed > 100) {
            score++;
            startTime = System.nanoTime();
        }
        animation.update();

        if (up) {
            if (y <= 80) {
                dy = 0;
                up = false;
            } else {
                dy = -4;
            }
        } else {
            if (y >= 160) {
                dy = 0;
                grounded = true;
            } else {
                dy = 3;
                grounded = false;
            }
        }

        if (dy > 5) dy = 5;
        if (dy < -5) dy = -5;

        y += dy * 2;
        dy = 0;
        dx = 0;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(animation.getImage(), x, y, null);
    }

    public int getScore() {
        return score;
    }

    public boolean getPlaying() {
        return playing;
    }

    public void setPlaying(boolean b) {
        playing = b;
    }

    public void resetDYA() {
        dya = 0;
    }

    public void resetScore() {
        score = 0;
    }

    public boolean getPosition() {
        return grounded;
    }
}
