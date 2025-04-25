package com.example.nhamnham.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.nhamnham.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CheckoutFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkout, container, false);

        // Back Arrow
        ImageView backArrow = view.findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Returning to Order", Toast.LENGTH_SHORT).show();
            getParentFragmentManager().popBackStack();
        });

        // Order Details
        TextView itemName = view.findViewById(R.id.item_name);
        TextView itemQuantity = view.findViewById(R.id.item_quantity);
        TextView itemPrice = view.findViewById(R.id.item_price);
        TextView totalPriceText = view.findViewById(R.id.total_price);

        Bundle arguments = getArguments();
        if (arguments != null) {
            double totalPrice = arguments.getDouble("total_price", 0.0);
            int totalItems = arguments.getInt("total_items", 0);
            String selectedFood = arguments.getString("selected_food", "Phala");

            itemName.setText(selectedFood);
            itemQuantity.setText("x " + totalItems);
            itemPrice.setText(String.format("$ %.2f", totalPrice / totalItems));
            totalPriceText.setText(String.format("$ %.2f", totalPrice));
        }

        // Buttons
        Button cancelButton = view.findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Order cancelled", Toast.LENGTH_SHORT).show();
            getParentFragmentManager().popBackStack();
        });

        Button orderNowButton = view.findViewById(R.id.order_now_button);
        orderNowButton.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Order placed successfully!", Toast.LENGTH_SHORT).show();
            // Add a slight delay to show the toast before navigating
            new Handler(Looper.getMainLooper()).postDelayed(() -> {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new HomeFragment())
                        .commit();

                // Update bottom navigation to select Home tab
                BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
                bottomNavigationView.setSelectedItemId(R.id.nav_home);
            }, 500); // 500ms delay
        });

        return view;
    }
}
