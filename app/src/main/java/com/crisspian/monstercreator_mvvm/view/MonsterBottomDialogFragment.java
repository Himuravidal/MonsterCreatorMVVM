package com.crisspian.monstercreator_mvvm.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crisspian.monstercreator_mvvm.R;
import com.crisspian.monstercreator_mvvm.databinding.LayoutMonsterBottomFragmentBinding;
import com.crisspian.monstercreator_mvvm.model.MonsterImage;
import com.crisspian.monstercreator_mvvm.view.adapter.MonsterImageAdapter;
import com.crisspian.monstercreator_mvvm.viewmodel.ViewModelCreateMonster;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

public class MonsterBottomDialogFragment extends BottomSheetDialogFragment implements
        MonsterImageAdapter.MonsterImageListener {

    private LayoutMonsterBottomFragmentBinding binding;
    private MonsterImageAdapter adapter;
    private List<MonsterImage> monsterImageList = new ArrayList<>();
    private ViewModelCreateMonster viewModelCreateMonster;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        a Share View Model must share and activity so, if you put "this" only work on activities
        no fragments. is getActivity instead.
        */
        viewModelCreateMonster = new ViewModelProvider(getActivity()).get(ViewModelCreateMonster.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = LayoutMonsterBottomFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new MonsterImageAdapter(monsterStore(), this);
        RecyclerView recyclerView = binding.avatarRv;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3 ));
        recyclerView.setAdapter(adapter);
    }


    private List<MonsterImage> monsterStore() {
        monsterImageList.add(new MonsterImage(R.drawable.asset01));
        monsterImageList.add(new MonsterImage(R.drawable.asset02));
        monsterImageList.add(new MonsterImage(R.drawable.asset03));
        monsterImageList.add(new MonsterImage(R.drawable.asset04));
        monsterImageList.add(new MonsterImage(R.drawable.asset05));
        monsterImageList.add(new MonsterImage(R.drawable.asset06));
        return monsterImageList;
    }

    @Override
    public void monsterClicked(MonsterImage monsterImage) {
        viewModelCreateMonster.drawableSelect(monsterImage.getDrawable());
     //   NavHostFragment.findNavController(getParentFragment()).popBackStack();
    }
}
