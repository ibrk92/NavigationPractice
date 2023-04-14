package com.ibrahimkiceci.navigationpractice;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FirstFragment extends Fragment {


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Simdi burada setOnClickListener yazdik cunku fragmentlerde ve navigationlarda, goToSecond olarak olusturdugumuz sinifi gormeyebiliyor.
        // Bunu engellemek icin setOnClickListener diye gorunumlerimizi tanimlayabiliecegimiz OnViewCreated icerisine yazdik.
        // Istersen hepsini setOnClickListener icerisine yaz ya da goToSecond fonksyonunu senOncLickListener icerisinde cagir nasil istersen
        // SecondFragment'de de aynisi yapildi.

        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecond(view);
            }
        });
    }

    public void goToSecond(View view){

        //NavDirections action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(); // Veri gondermeyeceksen bu sekilde yazabilirsin.
        FirstFragmentDirections.ActionFirstFragmentToSecondFragment action = FirstFragmentDirections.actionFirstFragmentToSecondFragment();
        action.setAge(50);
        Navigation.findNavController(view).navigate(action);

    }
}

