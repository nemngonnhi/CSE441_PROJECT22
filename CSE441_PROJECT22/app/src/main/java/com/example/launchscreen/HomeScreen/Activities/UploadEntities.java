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
import com.example.launchscreen.items.GenreModel;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.ByteArrayOutputStream;

public class UploadEntities extends AppCompatActivity {

    Button uploadArtist, uploadGenre;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_upload_entities);

        uploadArtist = findViewById(R.id.uploadArtist);
        uploadGenre = findViewById(R.id.upLoadGenre);

        uploadArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadArtistToFirebase();
            }
        });
        uploadGenre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadGenreToFirebase();
            }
        });


    }
    private void uploadArtistToFirebase() {
        // ID duy nhất cho artist
        String artistID = "chillies";

        // Lấy ảnh từ drawable và chuyển sang Bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.chillies_img); // "rhymastic_image" là tên ảnh trong drawable

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
                                "Chillies",
                                "Chillies là một ban nhạc Pop/Rock Việt Nam gồm 4 thành viên: Trần Duy Khang, Nhím Biển, Nguyễn Văn Phước, và Sĩ Phú. Nhóm được thành lập vào tháng 10 năm 2018 và được quản lý bởi hãng đĩa Warner Music Vietnam. Tại lễ trao giải Âm nhạc Cống hiến 2021, Chillies đã nhận được hai đề cử ở các hạng mục \"Video âm nhạc của năm\" (cho bài hát \"Cứ chill thôi\") và Nghệ sĩ mới của năm (cho Trần Duy Khang, ca sĩ kiêm sáng tác chính của nhóm).",
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
    private void uploadGenreToFirebase() {
        // ID duy nhất cho thể loại
        String genreID = "pop";

        // Lấy ảnh từ drawable và chuyển sang Bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pop_img); // "metal_image" là tên ảnh trong drawable

        // Chuyển Bitmap thành byte array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageData = baos.toByteArray();

        // Tạo StorageReference để lưu ảnh của genre
        StorageReference storageRef = FirebaseStorage.getInstance().getReference("genre_images/" + genreID + ".jpg");

        // Upload ảnh lên Firebase Storage
        storageRef.putBytes(imageData)
                .addOnSuccessListener(taskSnapshot -> {
                    // Lấy URL của ảnh đã upload
                    storageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                        // Tạo đối tượng Genre với thông tin
                        GenreModel genre = new GenreModel(
                                genreID,
                                "Pop",
                                "Nhạc pop (viết tắt của cụm từ tiếng Anh: popular music, tiếng Việt: nhạc đại chúng) là một thể loại của nhạc đương đại và rất phổ biến trong làng nhạc đại chúng. Nhạc pop khởi đầu từ thập niên 1950 và có nguồn gốc từ dòng nhạc rock and roll. Thuật ngữ này không cho biết một cách chính xác về thể loại nhạc hay âm thanh riêng nào mà nghĩa của nó lại rất khác nhau phụ thuộc vào từng khoảng thời gian trong lịch sử của nó và từng địa điểm khác nhau trên thế giới. Trong giới âm nhạc đại chúng thì nhạc pop thường được phân biệt với các thể loại khác nhờ một số đặc điểm về phong cách nghệ thuật, những giai điệu đơn giản dễ nghe, cùng với một số đoạn trong bài hát được lặp đi lặp lại. Ca từ của nhạc pop thường nói đến tình yêu, cảm xúc và một số chủ đề khác.",

                                uri.toString()
                        );

                        // Lưu đối tượng Genre vào Firebase Realtime Database
                        FirebaseDatabase.getInstance().getReference("genres")
                                .child(genreID)
                                .setValue(genre)
                                .addOnSuccessListener(aVoid -> {
                                    Log.d("Firebase", "Genre uploaded successfully!");
                                })
                                .addOnFailureListener(e -> {
                                    Log.e("Firebase", "Failed to upload genre", e);
                                });
                    });
                })
                .addOnFailureListener(e -> {
                    Log.e("Firebase", "Failed to upload image", e);
                });
    }

}