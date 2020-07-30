package com.crisspian.monstercreator_mvvm.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.crisspian.monstercreator_mvvm.R;
import com.crisspian.monstercreator_mvvm.databinding.FragmentFirstBinding;
import com.crisspian.monstercreator_mvvm.model.Monster;
import com.crisspian.monstercreator_mvvm.view.adapter.MonsterAdapter;
import com.crisspian.monstercreator_mvvm.viewmodel.AllMonsterViewModel;

import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private MonsterAdapter monsterAdapter;
    private AllMonsterViewModel viewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AllMonsterViewModel.class);
        monsterAdapter = new MonsterAdapter();
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        RecyclerView recyclerView = binding.rvMonsterList;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(monsterAdapter);

        viewModel.getListLiveData().observe(getViewLifecycleOwner(), new Observer<List<Monster>>() {
            @Override
            public void onChanged(List<Monster> monsters) {
                monsterAdapter.updateMosters(monsters);
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });



        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }
}