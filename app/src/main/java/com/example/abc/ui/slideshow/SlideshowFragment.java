package com.example.abc.ui.slideshow;

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
import com.example.abc.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {
    Activity Table;
    int index=0;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Table=getActivity();
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        return root;
    }
    public void onStart()
    {
        super.onStart();
        TextView Xx =(TextView) Table.findViewById(R.id.XX);
        TextView Yy =(TextView) Table.findViewById(R.id.YY);
        ImageView backk =(ImageView) Table.findViewById(R.id.prevv);
        ImageView nextt =(ImageView) Table.findViewById(R.id.nextt);
        TextView  dis =(TextView) Table.findViewById(R.id.disp);
        TextView  dis2 =(TextView) Table.findViewById(R.id.disp2);
        String []  arrstr=getResources().getStringArray(R.array.duaa);
        String []  arrstr2=getResources().getStringArray(R.array.trans);
        Yy.setText(String.valueOf(arrstr.length));
        Xx.setText(String.valueOf(index+1)+"/");
        dis.setText(arrstr[index]);
        dis2.setText(arrstr2[index]);

        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index==0) {
                    Toast.makeText(getActivity().getApplicationContext(),"Cannot go Back",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    index--;
                    dis.setText(arrstr[index]);
                    dis2.setText(arrstr2[index]);
                    Xx.setText(String.valueOf(index + 1) + "/");
                }

            }

        });

        nextt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(index== arrstr.length-1) {
                    Toast.makeText(getActivity().getApplicationContext(),"The End",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    index++;
                    dis.setText(arrstr[index]);
                    dis2.setText(arrstr2[index]);
                    Xx.setText(String.valueOf(index + 1) + "/");
                }
            }
        });

    };

}