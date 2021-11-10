package com.example.android.miwok;

public class words {
    private String defultlanguage;
    private String transelatedlanguage;
    private int imageID= noImage;
    private static final int noImage=-1;
    private int mAudioResourceId;


    public words(String defult, String transelated, int AudioResourceId ){
        this.defultlanguage= defult;
        this.transelatedlanguage= transelated;
        this.mAudioResourceId= AudioResourceId;
    }

    public words(String defult, String transelated, int wordImage, int AudioResourceId ){
        this.defultlanguage= defult;
        this.transelatedlanguage= transelated;
        this.imageID=wordImage;
        this.mAudioResourceId= AudioResourceId;
    }

    public String getDefultlanguage() {
        return defultlanguage;
    }

    public String getTranselatedlanguage() {
        return transelatedlanguage;
    }

    public int getImageID() {
        return imageID;
    }
    public boolean hasimage(){
         return imageID != noImage;
    }


    public void setmAudioResourceId(int mAudioResourceId) {
        this.mAudioResourceId = mAudioResourceId;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}
