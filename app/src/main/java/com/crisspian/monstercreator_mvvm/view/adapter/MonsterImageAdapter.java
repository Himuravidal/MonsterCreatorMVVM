package com.crisspian.monstercreator_mvvm.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crisspian.monstercreator_mvvm.databinding.ImageMonsterItemListBinding;
import com.crisspian.monstercreator_mvvm.model.MonsterImage;

import java.util.List;

public class MonsterImageAdapter extends
        RecyclerView.Adapter<MonsterImageAdapter.MonsterImageViewHolder> {

    private List<MonsterImage> monsterImageList;
    private MonsterImageListener listener;

    public MonsterImageAdapter(List<MonsterImage> monsterImageList, MonsterImageListener listener) {
        this.monsterImageList = monsterImageList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MonsterImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ImageMonsterItemListBinding binding = ImageMonsterItemListBinding.inflate(LayoutInflater
                .from(parent.getContext()), parent, false);
        return new MonsterImageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MonsterImageViewHolder holder, int position) {
        Glide.with(holder.imageView.getContext()).load(monsterImageList.get(position).getDrawable()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return monsterImageList.size();
    }


    public class MonsterImageViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        private ImageView imageView;
        private MonsterImage monsterImage;

        public MonsterImageViewHolder(@NonNull ImageMonsterItemListBinding itemView) {
            super(itemView.getRoot());
            imageView = itemView.monsterAvatar;

            itemView.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            monsterImage = monsterImageList.get(getAdapterPosition());
            listener.monsterClicked(monsterImage);
        }
    }


    public interface MonsterImageListener {
        void monsterClicked(MonsterImage monsterImage);
    }
}
