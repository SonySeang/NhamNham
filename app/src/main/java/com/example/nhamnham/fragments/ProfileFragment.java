package com.example.nhamnham.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.nhamnham.R;

public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Back Arrow Click Listener
        ImageView backArrow = view.findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(v -> {
            getParentFragmentManager().popBackStack();
        });

        // Heart Icon Click Listener
        ImageView heartIcon = view.findViewById(R.id.heart_icon);
        heartIcon.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Heart icon clicked", Toast.LENGTH_SHORT).show();
        });

        // Search Icon Click Listener
        ImageView searchIcon = view.findViewById(R.id.search_icon);
        searchIcon.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Search icon clicked", Toast.LENGTH_SHORT).show();
        });

        // Favourite Button Click Listener
        LinearLayout favouriteButton = view.findViewById(R.id.favourite_button);
        favouriteButton.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Favourite clicked", Toast.LENGTH_SHORT).show();
        });

        // About Us Button Click Listener
        LinearLayout aboutUsButton = view.findViewById(R.id.about_us_button);
        aboutUsButton.setOnClickListener(v -> {
            Toast.makeText(getContext(), "About Us clicked", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}