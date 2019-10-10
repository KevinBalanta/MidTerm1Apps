package com.example.challenge1.activities.model.entity;

import java.io.Serializable;

public class Score implements Serializable {

    private long id;
    private int score;

    public Score() {
    }

    public Score(long id, int score) {
        this.id = id;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
