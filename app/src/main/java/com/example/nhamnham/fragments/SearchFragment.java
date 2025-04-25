package com.example.nhamnham.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.nhamnham.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        // Set up click listeners for food items
        View itemPhala = view.findViewById(R.id.heart_icon);
        View itemPuuJoruk = view.findViewById(R.id.item_price);
        View itemPuuKtey = view.findViewById(R.id.search_icon);

        itemPhala.setOnClickListener(v -> navigateToOrderFragment("Phala"));
        itemPuuJoruk.setOnClickListener(v -> navigateToOrderFragment("Puu Joruk"));
        itemPuuKtey.setOnClickListener(v -> navigateToOrderFragment("Puu Ktey"));

        return view;
    }

    private void navigateToOrderFragment(String foodItem) {
        // Create a new instance of OrderFragment
        OrderFragment orderFragment = new OrderFragment();

        // Pass the selected food item to the OrderFragment
        Bundle bundle = new Bundle();
        bundle.putString("selected_food", foodItem);
        orderFragment.setArguments(bundle);

        // Navigate to OrderFragment
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, orderFragment)
                .addToBackStack(null) // Allow back navigation
                .commit();

        // Update the selected item in the BottomNavigationView
        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_order);
    }

}