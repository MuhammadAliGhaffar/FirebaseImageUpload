package com.example.firebaseimageupload;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

import static android.app.Activity.RESULT_OK;


public class UploadImageFragment extends Fragment {

    private static final int PICK_IMAGE_REQUEST = 1;//Any postive no

    private Button btn_choose_image, btn_upload;
    private EditText edt_filename;
    private ImageView imageView;
    private ProgressBar progressBar;
    private TextView txt_showUploads;

    private Uri mImageUri;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upload_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }

    public void init(View view) {
        btn_choose_image = view.findViewById(R.id.btn_choose_image);
        btn_upload = view.findViewById(R.id.btn_upload);
        edt_filename = view.findViewById(R.id.edt_filename);
        imageView = view.findViewById(R.id.imageView);
        progressBar = view.findViewById(R.id.progressBar);
        txt_showUploads = view.findViewById(R.id.txt_showUploads);

        btn_choose_image.setOnClickListener(v -> {
            openFileChooser();
        });

        btn_upload.setOnClickListener(v -> {

        });

        txt_showUploads.setOnClickListener(v -> {

        });

    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();
            Glide.with(this).load(mImageUri).into(imageView);
        }
    }
}