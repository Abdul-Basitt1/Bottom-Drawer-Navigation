package com.example.abc.ui.gallery;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.abc.R;
import com.example.abc.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {
    Activity table;
    int index=0;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
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
        TextView XX =(TextView) table.findViewById(R.id.xx);
        TextView YY =(TextView) table.findViewById(R.id.yy);
        ImageView prev =(ImageView) table.findViewById(R.id.prev);
        ImageView next =(ImageView) table.findViewById(R.id.next);
        TextView  display =(TextView) table.findViewById(R.id.display);
        String []  strarr=getResources().getStringArray(R.array.allahname);
        YY.setText(String.valueOf(strarr.length));
        XX.setText(String.valueOf(index+1)+"/");
        display.setText(strarr[index]);


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index==0) {
                    Toast.makeText(getActivity().getApplicationContext(),"Cannot go Back",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    index--;
                    display.setText(strarr[index]);
                    XX.setText(String.valueOf(index + 1) + "/");
                }

            }

        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index== strarr.length-1) {
                    Toast.makeText(getActivity().getApplicationContext(),"The End",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    index++;
                    display.setText(strarr[index]);
                    XX.setText(String.valueOf(index + 1) + "/");
                }
            }
        });

    };


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
