package com.crisspian.monstercreator_mvvm.view;

import android.opengl.Visibility;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.crisspian.monstercreator_mvvm.R;
import com.crisspian.monstercreator_mvvm.databinding.FragmentSecondBinding;
import com.crisspian.monstercreator_mvvm.model.AttributeStore;
import com.crisspian.monstercreator_mvvm.model.AttributeValue;
import com.crisspian.monstercreator_mvvm.model.MonsterImage;
import com.crisspian.monstercreator_mvvm.view.adapter.MonsterImageAdapter;

public class SecondFragment extends Fragment implements MonsterImageAdapter.MonsterImageListener {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        configureSpinnersAdapter();

        binding.tapLabelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_monsterBottomDialogFragment);
            }
        });

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });


    }

    private void configureSpinnersAdapter() {
        binding.intelligenceSpn.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, AttributeStore.getIntelligenceAttributeValues()));
        binding.evilnessSpn.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, AttributeStore.getEvilnessValue()));
        binding.uglinessSpn.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, AttributeStore.getUglinessAttributeValues()));
    }


    @Override
    public void monsterClicked(MonsterImage monsterImage) {
        Toast.makeText(getContext(), monsterImage.getDrawable(), Toast.LENGTH_SHORT).show();
        binding.tapLabelTv.setVisibility(View.INVISIBLE);
    }
}