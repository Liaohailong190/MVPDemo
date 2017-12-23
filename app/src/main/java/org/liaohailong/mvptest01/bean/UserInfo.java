package org.liaohailong.mvptest01.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 用户信息采集
 * Created by LHL on 2017/12/23.
 */

public class UserInfo implements Parcelable{

    public String name = "";
    public int age = 18;
    public boolean man = true;

    public UserInfo(){
        this("小明");
    }

    public UserInfo(String name) {
        this(name, 18);
    }

    public UserInfo(String name, int age) {
        this(name, age, true);
    }

    public UserInfo(String name, int age, boolean man) {
        this.name = name;
        this.age = age;
        this.man = man;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeByte(this.man ? (byte) 1 : (byte) 0);
    }

    protected UserInfo(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
        this.man = in.readByte() != 0;
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel source) {
            return new UserInfo(source);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };
}
