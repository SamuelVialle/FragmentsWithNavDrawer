package com.example.fragmentcallbackwithanavdrawer;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fragmentcallbackwithanavdrawer.utils.Gol;

import org.jetbrains.annotations.NotNull;

public class Fragment_01 extends Fragment {

    // Variable emplacement
    private static final String emplacement
            = Fragment_01.class.getSimpleName();

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        Gol.addLog(emplacement, "onAttach");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Gol.addLog(emplacement, "onCreateView");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_01, container, false);
    }

    @Override
    public void onStart() {
        Gol.addLog(emplacement, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Gol.addLog(emplacement, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Gol.addLog(emplacement, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Gol.addLog(emplacement, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Gol.addLog(emplacement, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Gol.addLog(emplacement, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Gol.addLog(emplacement, "onDetach");
        super.onDetach();
    }
}