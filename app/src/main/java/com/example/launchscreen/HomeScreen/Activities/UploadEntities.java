package com.example.launchscreen.HomeScreen.Activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.launchscreen.R;
import com.example.launchscreen.items.ArtistModel;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.ByteArrayOutputStream;

public class UploadEntities extends AppCompatActivity {

    Button uploadArtist;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_upload_entities);

        uploadArtist = findViewById(R.id.uploadArtist);


        uploadArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadArtistToFirebase();
            }
        });


    }
    private void uploadArtistToFirebase() {
        // ID duy nhất cho artist
        String artistID = "rhymastic";

        // Lấy ảnh từ drawable và chuyển sang Bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rhymastic_img); // "rhymastic_image" là tên ảnh trong drawable

        // Chuyển Bitmap thành byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageData = baos.toByteArray();

        // Tạo StorageReference để lưu ảnh của artist
        StorageReference storageRef = FirebaseStorage.getInstance().getReference("artist_images/" + artistID + ".jpg");

        // Upload ảnh lên Firebase Storage
        storageRef.putBytes(imageData)
                .addOnSuccessListener(taskSnapshot -> {
                    // Lấy URL của ảnh đã upload
                    storageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                        // Tạo đối tượng Artist với thông tin
                        ArtistModel artist = new ArtistModel(
                                artistID,
                                "Rhymastic",
                                "Vũ Đức Thiện (sinh ngày 8 tháng 4 năm 1991), thường được biết đến với nghệ danh Rhymastic, là một nam rapper, ca sĩ, nhạc sĩ sáng tác ca khúc kiêm nhà sản xuất thu âm người Việt Nam. Anh được biết đến là thành viên của SpaceSpeakers.",
                                uri.toString()
                        );

                        // Lưu đối tượng Artist vào Firebase Realtime Database
                        FirebaseDatabase.getInstance().getReference("artists")
                                .child(artistID)
                                .setValue(artist)
                                .addOnSuccessListener(aVoid -> {
                                    Log.d("Firebase", "Artist uploaded successfully!");
                                })
                                .addOnFailureListener(e -> {
                                    Log.e("Firebase", "Failed to upload artist", e);
                                });
                    });
                })
                .addOnFailureListener(e -> {
                    Log.e("Firebase", "Failed to upload image", e);
                });
    }
}