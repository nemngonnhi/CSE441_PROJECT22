package com.example.launchscreen.HomeScreen.ModelsandAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.launchscreen.R;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

    private ArrayList<SongModel> songList;
    private Context context;
    private OnSongClickListener onSongClickListener;

    public SongAdapter(ArrayList<SongModel> songList, Context context) {
        this.songList = songList;
        this.context = context;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_music, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        SongModel song = songList.get(position);
        holder.tvSongName.setText(song.getSongName());
        holder.tvSongArtist.setText(song.getSongArtist());
        holder.ivSongImage.setImageResource(song.getSongImg());

        holder.itemView.setOnClickListener(v -> {
            if (onSongClickListener != null) {
                onSongClickListener.onSongClick(song);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public void setOnSongClickListener(OnSongClickListener listener) {
        this.onSongClickListener = listener;
    }

    public interface OnSongClickListener {
        void onSongClick(SongModel songModel);
    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {
        TextView tvSongName, tvSongArtist;
        ImageView ivSongImage;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSongName = itemView.findViewById(R.id.item_song_name);
            tvSongArtist = itemView.findViewById(R.id.item_song_artist);
            ivSongImage = itemView.findViewById(R.id.song_img);
        }
    }
}
