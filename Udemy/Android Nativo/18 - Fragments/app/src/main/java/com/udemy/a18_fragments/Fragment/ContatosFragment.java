package com.udemy.a18_fragments.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.udemy.a18_fragments.R;

public class ContatosFragment extends Fragment {   //fragmento tb tem ciclo de vida loko!!!!


    private TextView textContato;

    public ContatosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contatos, container, false);


        textContato = view.findViewById(R.id.tvContato);   //acesso é diferente viu!?
        textContato.setText("Contatos alterado");

        return view;

    }

}
