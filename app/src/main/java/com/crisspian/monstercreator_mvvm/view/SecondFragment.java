package com.crisspian.monstercreator_mvvm.view;

import android.opengl.Visibility;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;


import com.crisspian.monstercreator_mvvm.R;
import com.crisspian.monstercreator_mvvm.databinding.FragmentSecondBinding;
import com.crisspian.monstercreator_mvvm.model.AttributeStore;
import com.crisspian.monstercreator_mvvm.model.AttributeType;

import com.crisspian.monstercreator_mvvm.model.Monster;

import com.crisspian.monstercreator_mvvm.viewmodel.ViewModelCreateMonster;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private ViewModelCreateMonster viewModelCreateMonster;
    private String name;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModelCreateMonster = new ViewModelProvider(getActivity()).get(ViewModelCreateMonster.class);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false);
        binding.setViewmodel(viewModelCreateMonster);
        configureUI();
        configureSpinnersAdapter();
        configureSpinnerLister();
        viewModelCreateMonster.monsterLive().observe(getViewLifecycleOwner(), new Observer<Monster>() {
            @Override
            public void onChanged(Monster monster) {
                if (monster.getDrawable() != 0) {
                    binding.tapLabelTv.setVisibility(View.INVISIBLE);
                }
                binding.avatarIv.setImageResource(monster.getDrawable());
                binding.monsterPointTv.setText(String.valueOf(monster.getMonsterPoint()));
                binding.nameEditText.setText(monster.getName());
            }
        });
        viewModelCreateMonster.saveState().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Toast.makeText(getContext(), "Se guardo exitosamente", Toast.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(SecondFragment.this).popBackStack();
                } else {
                    Toast.makeText(getContext(), "Ocurrio un error al guardar", Toast.LENGTH_SHORT).show();
                }
            }
        });

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
    }

    private void configureSpinnersAdapter() {
        binding.intelligenceSpn.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, AttributeStore.getIntelligenceAttributeValues()));
        binding.evilnessSpn.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, AttributeStore.getEvilnessValue()));
        binding.uglinessSpn.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, AttributeStore.getUglinessAttributeValues()));
    }

    private void configureSpinnerLister() {
        binding.intelligenceSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModelCreateMonster.attributeSelected(AttributeType.INTELLIGENCE, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        binding.uglinessSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModelCreateMonster.attributeSelected(AttributeType.UGLINESS, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        binding.evilnessSpn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewModelCreateMonster.attributeSelected(AttributeType.EVILNESS, position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void configureUI() {
        viewModelCreateMonster.nameInsert("");
        viewModelCreateMonster.drawableSelect(0);
        viewModelCreateMonster.renewState();
    }

}