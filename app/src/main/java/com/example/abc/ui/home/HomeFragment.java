package com.example.abc.ui.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.abc.R;
import com.example.abc.RecyclerContactAdapter;
import com.example.abc.constructorr;
import com.example.abc.databinding.FragmentHomeBinding;


import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView rv;
    Activity table;
    ArrayList<constructorr> contact_array = new ArrayList<>();
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;


    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        table= getActivity();

    }

    @Override
    public void onStart() {
        super.onStart();
        rv = (RecyclerView) table.findViewById(R.id.recycle);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        contact_array.add(new constructorr("April 3,2022","Ramadan 1,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 4,2022","Ramadan 2,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 5,2022","Ramadan 3,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 6,2022","Ramadan 4,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 7,2022","Ramadan 5,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 8,2022","Ramadan 6,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 9,2022","Ramadan 7,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 10,2022","Ramadan 8,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 11,2022","Ramadan 10,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 12,2022","Ramadan 11,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 13,2022","Ramadan 12,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 14,2022","Ramadan 13,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 15,2022","Ramadan 14,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 16,2022","Ramadan 15,1438","       3:52","    6:50"));
        contact_array.add(new constructorr("April 17,2022","Ramadan 16,1438","       3:52","    6:50"));



        RecyclerContactAdapter adapter = new RecyclerContactAdapter(getContext(), contact_array);
        rv.setAdapter(adapter);

    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}