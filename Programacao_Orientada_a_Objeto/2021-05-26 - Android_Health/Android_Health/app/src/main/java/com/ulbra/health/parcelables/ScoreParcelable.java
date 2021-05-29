package com.ulbra.health.parcelables;

import android.os.Parcel;
import android.os.Parcelable;

import com.ulbra.health.types.Score;

public class ScoreParcelable implements Parcelable {
//    0 - age;
//    1 - sex;
//    2 - weight;
//    3 - activity;
//    4 - smokes;
//    5 - pressure;
//    6 - illnessInFamily;
//    7 - cholesterol;
    int[] checked = new int[8];
    int scoreTotal = 0;



    public void setChecked(int index, int value) {
        checked[index] = value;
        calcScore();
    }

    public int[] getChecked() {
        return checked;
    }

    public int getScoreTotal() {
        if(scoreTotal == 0) {
            calcScore();
        }
        return scoreTotal;
    }


    private void calcScore() {
        scoreTotal = 0;
        for(int index =0; index < checked.length;index++) {
            if(checked[index] > -1) {
                scoreTotal += Score.getScore(index, checked[index]);
            }
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(this.checked);
        dest.writeInt(this.scoreTotal);
    }

    public void readFromParcel(Parcel source) {
        this.checked = source.createIntArray();
        this.scoreTotal = source.readInt();
    }

    public ScoreParcelable() {
        for(int index = 0; index < checked.length;index++) {
            checked[index] = -1;
        }
    }

    protected ScoreParcelable(Parcel in) {
        this.checked = in.createIntArray();
        this.scoreTotal = in.readInt();
    }

    public static final Parcelable.Creator<ScoreParcelable> CREATOR = new Parcelable.Creator<ScoreParcelable>() {
        @Override
        public ScoreParcelable createFromParcel(Parcel source) {
            return new ScoreParcelable(source);
        }

        @Override
        public ScoreParcelable[] newArray(int size) {
            return new ScoreParcelable[size];
        }
    };
}
