package com.example.firebaseimageupload.Model;

public class Upload {
    private String mName;
    private String mImageUrl;

    public Upload() {
        //Empty Constructor needed
    }

    public Upload(String name, String imageUrl) {
        if (name.trim().equals("")) {
            name = "No name";
        }
        mName = name;
        mImageUrl = imageUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        if (name.trim().equals("")) {
            name = "No name";
        }
        mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
}
