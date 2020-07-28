package com.crisspian.monstercreator_mvvm.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.crisspian.monstercreator_mvvm.databinding.MonsterItemListBinding;
import com.crisspian.monstercreator_mvvm.model.Monster;

import java.util.List;

public class MonsterAdapter extends RecyclerView.Adapter<MonsterAdapter.MonsterViewHolder> {

    private List<Monster> monsterList;

    @NonNull
    @Override
    public MonsterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MonsterItemListBinding binding = MonsterItemListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MonsterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MonsterViewHolder holder, int position) {
        Monster monster = monsterList.get(position);
        Glide.with(holder.imageViewMonster.getContext()).load(monster.getDrawable()).into(holder.imageViewMonster);
        holder.monsterPoint.setText(monster.getMonsterPoint());
        holder.name.setText(monster.getName());
    }

    @Override
    public int getItemCount() {
        if (monsterList != null) {
            return monsterList.size();
        } else {
            return 0;
        }
    }


    public class MonsterViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView monsterPoint;
        private ImageView imageViewMonster;

        public MonsterViewHolder(@NonNull MonsterItemListBinding itemView) {
            super(itemView.getRoot());
            name = itemView.nameTv;
            monsterPoint = itemView.monsterPointTv;
            imageViewMonster = itemView.monsterIv;
        }
    }
}
