package com.ulbra.health.parcelables;

import android.os.Parcel;
import android.os.Parcelable;

public class Health implements Parcelable {
    int age;
    int sex;
    int weight;
    int activity;
    int smokes;
    int pressure;
    int illnessInFamily;
    int cholesterol;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.age);
        dest.writeInt(this.sex);
        dest.writeInt(this.weight);
        dest.writeInt(this.activity);
        dest.writeInt(this.smokes);
        dest.writeInt(this.pressure);
        dest.writeInt(this.illnessInFamily);
        dest.writeInt(this.cholesterol);
    }

    public void readFromParcel(Parcel source) {
        this.age = source.readInt();
        this.sex = source.readInt();
        this.weight = source.readInt();
        this.activity = source.readInt();
        this.smokes = source.readInt();
        this.pressure = source.readInt();
        this.illnessInFamily = source.readInt();
        this.cholesterol = source.readInt();
    }

    public Health() {
    }

    protected Health(Parcel in) {
        this.age = in.readInt();
        this.sex = in.readInt();
        this.weight = in.readInt();
        this.activity = in.readInt();
        this.smokes = in.readInt();
        this.pressure = in.readInt();
        this.illnessInFamily = in.readInt();
        this.cholesterol = in.readInt();
    }

    public static final Parcelable.Creator<Health> CREATOR = new Parcelable.Creator<Health>() {
        @Override
        public Health createFromParcel(Parcel source) {
            return new Health(source);
        }

        @Override
        public Health[] newArray(int size) {
            return new Health[size];
        }
    };
}
