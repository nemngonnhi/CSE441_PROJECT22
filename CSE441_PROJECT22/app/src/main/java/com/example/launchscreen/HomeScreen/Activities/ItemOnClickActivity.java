package com.example.launchscreen.HomeScreen.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.launchscreen.R;
import com.google.android.material.imageview.ShapeableImageView;

public class ItemOnClickActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvDescription;
    TextView tvTitle;
    ShapeableImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_on_click);

        tvTitle = findViewById(R.id.static_item_title);
        imageView = findViewById(R.id.item_onclick_img);
        tvName = findViewById(R.id.item_onclick_name);
        tvDescription = findViewById(R.id.item_onclick_description);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int img = intent.getIntExtra("image", -1);

        tvName.setText(title);
        if (img != -1){
            imageView.setImageResource(img);
        }

//        if (tvName.getText().equals("Rhymastic")){
//            tvTitle.setText("Artist");
//            tvDescription.setText("     Vũ Đức Thiện (sinh ngày 8 tháng 4 năm 1991), thường được biết đến với nghệ danh Rhymastic, là một nam rapper, ca sĩ, nhạc sĩ sáng tác ca khúc kiêm nhà sản xuất thu âm người Việt Nam. Anh được biết đến là thành viên của SpaceSpeakers.");
//        }
        switch (tvName.getText().toString()){
            case "Rhymastic":
                tvTitle.setText("Artist");
                tvDescription.setText("     Vũ Đức Thiện (sinh ngày 8 tháng 4 năm 1991), thường được biết đến với nghệ danh Rhymastic, là một nam rapper, ca sĩ, nhạc sĩ sáng tác ca khúc kiêm nhà sản xuất thu âm người Việt Nam. Anh được biết đến là thành viên của SpaceSpeakers.");
                break;
            case "Son Tung M-TP":
                tvTitle.setText("Artist");
                tvDescription.setText("     Nguyễn Thanh Tùng (sinh ngày 5 tháng 7 năm 1994), thường được biết đến với nghệ danh Sơn Tùng M-TP, là một nam ca sĩ kiêm sáng tác nhạc, nhà sản xuất thu âm, rapper và diễn viên người Việt Nam. Nổi tiếng vì tầm ảnh hưởng sâu rộng đối với âm nhạc Việt Nam, anh được mệnh danh là \"Hoàng tử V-pop\" bởi Giải thưởng Âm nhạc Thế giới và BroadwayWorld. Nhiều nhà báo âm nhạc, nhà lý luận phê bình và tác giả đánh giá Sơn Tùng M-TP là một trong những nghệ sĩ V-pop xuất sắc nhất trong thế hệ của mình.");
                break;
            case "Chillies":
                tvTitle.setText("Artist");
                tvDescription.setText("     Chillies là một ban nhạc Pop/Rock Việt Nam gồm 4 thành viên: Trần Duy Khang, Nhím Biển, Nguyễn Văn Phước, và Sĩ Phú. Nhóm được thành lập vào tháng 10 năm 2018 và được quản lý bởi hãng đĩa Warner Music Vietnam.[1][2] Tại lễ trao giải Âm nhạc Cống hiến 2021, Chillies đã nhận được hai đề cử ở các hạng mục \"Video âm nhạc của năm\" (cho bài hát \"Cứ chill thôi\") và Nghệ sĩ mới của năm (cho Trần Duy Khang, ca sĩ kiêm sáng tác chính của nhóm).");
                break;
        }
    }
}