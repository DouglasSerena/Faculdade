package com.ulbra.health.parcelables;

import android.os.Parcel;
import android.os.Parcelable;

public class HealthParcelable implements Parcelable {
//    0 - age;
//    1 - sex;
//    2 - weight;
//    3 - activity;
//    4 - smokes;
//    5 - pressure;
//    6 - illnessInFamily;
//    7 - cholesterol;
    int[] checked = new int[8];
    int scores = 0;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(this.checked);
        dest.writeInt(this.scores);
    }

    public void readFromParcel(Parcel source) {
        this.checked = source.createIntArray();
        this.scores = source.readInt();
    }

    public HealthParcelable() {
    }

    protected HealthParcelable(Parcel in) {
        this.checked = in.createIntArray();
        this.scores = in.readInt();
    }

    public static final Parcelable.Creator<HealthParcelable> CREATOR = new Parcelable.Creator<HealthParcelable>() {
        @Override
        public HealthParcelable createFromParcel(Parcel source) {
            return new HealthParcelable(source);
        }

        @Override
        public HealthParcelable[] newArray(int size) {
            return new HealthParcelable[size];
        }
    };
}
