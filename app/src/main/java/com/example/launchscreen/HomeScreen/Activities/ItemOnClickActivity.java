package com.example.launchscreen.HomeScreen.Activities;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.launchscreen.HomeScreen.ModelsandAdapter.SongAdapter;
import com.example.launchscreen.HomeScreen.ModelsandAdapter.SongModel;
import com.example.launchscreen.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class ItemOnClickActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvDescription;
    TextView tvTitle;
    ShapeableImageView imageView;

    RecyclerView rvSong;
    ArrayList<SongModel> songModelList;
    SongAdapter songAdapter;



    public void onSongClick(SongModel songModel){

//        if (mediaPlayer != null && mediaPlayer.isPlaying()){
//            mediaPlayer.stop();
//            mediaPlayer.release();
//            mediaPlayer = null;
//        }

        Intent intent = new Intent(ItemOnClickActivity.this, MusicPlayerActivity.class);
        intent.putExtra("songName", songModel.getSongName());
        intent.putExtra("songArtist", songModel.getSongArtist());
        intent.putExtra("songImage", songModel.getSongImg());
        songModel.setPlayCount(songModel.getPlayCount() + 1);
        intent.putExtra("playCount", songModel.getPlayCount());
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_item_on_click);

        tvTitle = findViewById(R.id.static_item_title);
        imageView = findViewById(R.id.item_onclick_img);
        tvName = findViewById(R.id.item_onclick_name);
        tvDescription = findViewById(R.id.item_onclick_description);

        rvSong = findViewById(R.id.item_onclick_rv);
        songModelList = new ArrayList<>();

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int img = intent.getIntExtra("image", -1);

        tvName.setText(title);
        if (img != -1){
            imageView.setImageResource(img);
        }

        switch (tvName.getText().toString()){
            case "Rhymastic":
                tvTitle.setText("Artist");
                tvDescription.setText("     Vũ Đức Thiện (sinh ngày 8 tháng 4 năm 1991), thường được biết đến với nghệ danh Rhymastic, là một nam rapper, ca sĩ, nhạc sĩ sáng tác ca khúc kiêm nhà sản xuất thu âm người Việt Nam. Anh được biết đến là thành viên của SpaceSpeakers.");
                songModelList.add(new SongModel("Nụ cười", "Rhymastic", 0, R.drawable.rhymasticnucuoi_img));
                songModelList.add(new SongModel("Nến và hoa", "Rhymastic", 0, R.drawable.rhymasticnenvahoa_img));

                break;
            case "Son Tung M-TP":
                tvTitle.setText("Artist");
                tvDescription.setText("     Nguyễn Thanh Tùng (sinh ngày 5 tháng 7 năm 1994), thường được biết đến với nghệ danh Sơn Tùng M-TP, là một nam ca sĩ kiêm sáng tác nhạc, nhà sản xuất thu âm, rapper và diễn viên người Việt Nam. Nổi tiếng vì tầm ảnh hưởng sâu rộng đối với âm nhạc Việt Nam, anh được mệnh danh là \"Hoàng tử V-pop\" bởi Giải thưởng Âm nhạc Thế giới và BroadwayWorld. Nhiều nhà báo âm nhạc, nhà lý luận phê bình và tác giả đánh giá Sơn Tùng M-TP là một trong những nghệ sĩ V-pop xuất sắc nhất trong thế hệ của mình.");
                songModelList.add(new SongModel("Có chắc yêu là đây", "Sơn Tùng M-TP", 0, R.drawable.sontung_img));
                songModelList.add(new SongModel("Lạc trôi", "Sơn Tùng M-TP", 0, R.drawable.sontunglactroi_img));
                break;
            case "Chillies":
                tvTitle.setText("Artist");
                tvDescription.setText("     Chillies là một ban nhạc Pop/Rock Việt Nam gồm 4 thành viên: Trần Duy Khang, Nhím Biển, Nguyễn Văn Phước, và Sĩ Phú. Nhóm được thành lập vào tháng 10 năm 2018 và được quản lý bởi hãng đĩa Warner Music Vietnam.[1][2] Tại lễ trao giải Âm nhạc Cống hiến 2021, Chillies đã nhận được hai đề cử ở các hạng mục \"Video âm nhạc của năm\" (cho bài hát \"Cứ chill thôi\") và Nghệ sĩ mới của năm (cho Trần Duy Khang, ca sĩ kiêm sáng tác chính của nhóm).");
                songModelList.add(new SongModel("Đại lộ mặt trời", "Chillies", 0, R.drawable.dailomattroichillies_img));
                songModelList.add(new SongModel("Vùng ký ức", "Chillies", 0, R.drawable.vungkyucchillies_img));
                break;
            case "Buc Tuong":
                tvTitle.setText("Artist");
                tvDescription.setText("     Bức Tường là một ban nhạc rock Việt Nam được thành lập vào năm 1995. Họ trải qua nhiều lần thay đổi nhân sự và từng có thời gian ngừng hoạt động, song với hai thành viên chủ chốt là Trần Tuấn Hùng (guitar) và Trần Lập (sáng tác, thủ lĩnh), ban nhạc vẫn kiên trì hoạt động. Tính đến nay, ban nhạc đã phát hành 7 album phòng thu bao gồm Tâm hồn của đá (2001), Vô hình (2003), Nam châm (2004), Ngày khác (2010), Đất Việt (2014), Con đường không tên (2020), Cân bằng (2023). Sau khi thủ lĩnh Trần Lập qua đời vì ung thư trực tràng, nhóm quyết định vẫn duy trì hoạt động nghệ thuật.");
                songModelList.add(new SongModel("Hoa ban trắng", "Ban nhạc Bức tường", 0, R.drawable.hoabantrangbuctuong));
                break;
            case "Taylor Swift":
                tvTitle.setText("Artist");
                tvDescription.setText("     Taylor Alison Swift (sinh ngày 13 tháng 12 năm 1989) là một nữ ca sĩ kiêm nhạc sĩ sáng tác bài hát người Mỹ. Nổi tiếng với phong cách sáng tác nhạc mang đậm chất tự sự, khả năng biến hóa không ngừng trong nghệ thuật và tầm ảnh hưởng văn hóa sâu rộng, Swift được đánh giá là một nhân vật tiêu biểu trong nền âm nhạc đại chúng và là tâm điểm thu hút mọi sự chú ý của công chúng.");
                songModelList.add(new SongModel("Blank space", "Taylor Swift", 0, R.drawable.blackspacetaylorswift_img));
                songModelList.add(new SongModel("Look what you make me do", "Taylor Swift", 0, R.drawable.lwymmdtaylorswift_img));
                break;
            case "Vu":
                tvTitle.setText("Artist");
                tvDescription.setText("     Hoàng Thái Vũ (sinh ngày 3 tháng 10 năm 1995 tại Hà Nội), thường được biết đến với nghệ danh Vũ (cách điệu là Vũ.), là một nam ca sĩ kiêm nhạc sĩ sáng tác nhạc người Việt Nam.\n" +
                        "\n" +
                        "Sinh ra trong gia đình có bố là quân nhân và mẹ là giáo viên, Vũ thường đăng tải các sáng tác của mình trên Soundcloud. Thể loại của anh theo đuổi là nhạc indie pop, acoustic, rock... Trước khi đi hát, Vũ từng gia nhập quân ngũ và làm giảng viên tiếng Anh tại một trường quân sự. Đây cũng chính là khoảng thời gian anh sáng tác.");
                break;
            case "Pop":
                tvTitle.setText("Genre");
                tvDescription.setText("     Nhạc pop (viết tắt của cụm từ tiếng Anh: popular music, tiếng Việt: nhạc đại chúng) là một thể loại của nhạc đương đại và rất phổ biến trong làng nhạc đại chúng. Nhạc pop khởi đầu từ thập niên 1950 và có nguồn gốc từ dòng nhạc rock and roll. Thuật ngữ này không cho biết một cách chính xác về thể loại nhạc hay âm thanh riêng nào mà nghĩa của nó lại rất khác nhau phụ thuộc vào từng khoảng thời gian trong lịch sử của nó và từng địa điểm khác nhau trên thế giới. Trong giới âm nhạc đại chúng thì nhạc pop thường được phân biệt với các thể loại khác nhờ một số đặc điểm về phong cách nghệ thuật, những giai điệu đơn giản dễ nghe, cùng với một số đoạn trong bài hát được lặp đi lặp lại. Ca từ của nhạc pop thường nói đến tình yêu, cảm xúc và một số chủ đề khác.");
                break;
            case "Rap":
                tvTitle.setText("Genre");
                tvDescription.setText("     Rap hay đọc rap là một hình thức nghệ thuật trong văn hóa hip hop xuất phát từ Âu Mỹ và được đặc trưng bằng việc trình diễn thông qua việc nói hoặc hô vang lời bài hát, ca từ một cách có vần điệu, kết hợp với động tác nhảy nhót, tạo hình.[2] Rap thường không có cao độ và trường độ mà người rap có thể nhanh hay chậm tùy ý. Có thể sáng tạo những flow cho riêng mình mà không cần theo quy tắc nào. Rap là thành phần chính của nhạc hip hop và được gắn liền với thể loại này đến nỗi nhạc hip hop đôi khi được gọi là \"nhạc rap\". Nghệ sĩ biểu diễn rap được gọi là rapper.");
                break;
            case "Podcast":
                tvTitle.setText("Genre");
                tvDescription.setText("     ");
                break;
            case "US-UK":
                tvTitle.setText("Genre");
                tvDescription.setText("     US-UK hay US&UK, USUK (còn gọi là nhạc Âu Mỹ) là một thuật ngữ phổ biến ở Việt Nam dùng để chỉ nền âm nhạc đại chúng của đa số các quốc gia nói tiếng Anh là Hoa Kỳ (Mỹ) và Vương quốc Liên hiệp Anh và Bắc Ai-len (Anh Quốc) cũng như một số quốc gia châu Âu và Mỹ La-tinh khác, thường bao gồm các thể loại nhạc như: pop, rock, R&B, hip hop, nhạc đồng quê, nhạc điện tử, nhạc dance,...");
                break;
            case "Rock":
                tvTitle.setText("Genre");
                tvDescription.setText("     Rock là một thể loại âm nhạc quần chúng được bắt nguồn từ cách gọi ngắn gọn của cụm từ \"rock and roll\" vào những năm 1950 ở Mỹ, rồi sau đó phát triển thành rất nhiều tiểu thể loại khác nhau từ những năm 60 của thế kỷ 20 và sau đó, đặc biệt ở Anh và Mỹ.[1][2][3] Rock bắt nguồn từ rock and roll của những năm 1940 và 1950, chịu ảnh hưởng mạnh mẽ từ nhạc R&B và nhạc đồng quê. Ngược lại, rock cũng tạo ảnh hưởng vô cùng rõ rệt tới nhiều thể loại nhạc như blues và folk, cùng với đó là những tương tác với jazz, nhạc cổ điển, và các thể loại khác.");
                break;
            case "Indie":
                tvTitle.setText("Genre");
                tvDescription.setText("     Nhạc indie (tiếng Anh: independent music; còn được gọi là nhạc độc lập hoặc đơn giản là indie) là nhạc được sản xuất độc lập mà không có sự can thiệp của các hãng đĩa thương mại hoặc các chi nhánh của họ; loại nhạc này có thể thực hiện bằng hình thức DIY để thu âm và xuất bản.");
                songModelList.add(new SongModel("Đại lộ mặt trời", "Chillies", 0, R.drawable.dailomattroichillies_img));
                songModelList.add(new SongModel("Vùng ký ức", "Chillies", 0, R.drawable.vungkyucchillies_img));

                break;
            case "1989":
                tvTitle.setText("Album");
                tvDescription.setText("     1989 là album phòng thu thứ năm của nữ ca sĩ kiêm nhạc sĩ sáng tác bài hát người Mỹ Taylor Swift, được hãng đĩa Big Machine Records phát hành vào ngày 27 tháng 10 năm 2014. Swift sáng tác album nhờ vào cảm hứng thể loại synth-pop bắt nguồn từ những năm thập niên 1980. Cô quyết định thực hiện bước chuyển đổi nghệ thuật sang nhạc pop hoàn toàn, sau khi bị giới chuyên môn bắt bẻ về hình tượng nhạc sĩ đồng quê. Nguyên nhân là do Swift đã từng phát hành và quảng bá Red (2012), một album vốn hòa trộn với nhiều thể loại âm nhạc khác nhau, lên đài phát thanh đồng quê. Nhằm phục hồi biểu tượng nghệ thuật trong âm nhạc của bản thân, Swift lấy tên album theo chính năm sinh của cô. Nữ ca sĩ mời lại nhạc sĩ kiêm nhà sản xuất âm nhạc Max Martin trước đó đã sáng tác các ca khúc thiên hướng nhạc điện tử trong Red, và đưa ông lên làm đồng giám đốc sản xuất cho album này.");
                songModelList.add(new SongModel("Blank space", "Taylor Swift", 0, R.drawable.blackspacetaylorswift_img));
                break;
        }

        songAdapter = new SongAdapter(songModelList, getApplicationContext());
        rvSong.setLayoutManager(new LinearLayoutManager(this));

        rvSong.setAdapter(songAdapter);

        songAdapter.setOnSongClickListener(songModel ->{
            onSongClick(songModel);
        });

    }



}