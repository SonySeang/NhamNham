package com.example.nhamnham.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.nhamnham.R;

public class OrderFragment extends Fragment {

    private TextView quantity1, quantity2, totalText, itemName1, itemName2;
    private int count1 = 1, count2 = 1;
    private double pricePerItem = 2.50;
    private double totalPrice;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        // Back Arrow
        ImageView backArrow = view.findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(v -> getParentFragmentManager().popBackStack());

        // Heart Icon (Optional functionality)
        ImageView heartIcon = view.findViewById(R.id.heart_icon);
        heartIcon.setOnClickListener(v -> {
            // Add functionality, e.g., toggle favorite
        });

        // Search Icon (Optional functionality)
        ImageView searchIcon = view.findViewById(R.id.search_icon);
        searchIcon.setOnClickListener(v -> {
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new SearchFragment())
                    .addToBackStack(null)
                    .commit();
        });

        // Set Item Names
        itemName1 = view.findViewById(R.id.item_name_1);
        itemName2 = view.findViewById(R.id.item_name_2);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String selectedFood = arguments.getString("selected_food", "Grill Walking Catfish");
            itemName1.setText(selectedFood);
            itemName2.setText(selectedFood);
        }

        // Quantity Controls for Item 1
        quantity1 = view.findViewById(R.id.quantity_1);
        ImageView decrease1 = view.findViewById(R.id.decrease_quantity_1);
        ImageView increase1 = view.findViewById(R.id.increase_quantity_1);

        decrease1.setOnClickListener(v -> {
            if (count1 > 1) {
                count1--;
                quantity1.setText(String.valueOf(count1));
                updateTotalPrice();
            }
        });

        increase1.setOnClickListener(v -> {
            count1++;
            quantity1.setText(String.valueOf(count1));
            updateTotalPrice();
        });

        // Quantity Controls for Item 2
        quantity2 = view.findViewById(R.id.quantity_2);
        ImageView decrease2 = view.findViewById(R.id.decrease_quantity_2);
        ImageView increase2 = view.findViewById(R.id.increase_quantity_2);

        decrease2.setOnClickListener(v -> {
            if (count2 > 1) {
                count2--;
                quantity2.setText(String.valueOf(count2));
                updateTotalPrice();
            }
        });

        increase2.setOnClickListener(v -> {
            count2++;
            quantity2.setText(String.valueOf(count2));
            updateTotalPrice();
        });

        // Total Price
        totalText = view.findViewById(R.id.total_text);
        updateTotalPrice();

        // Payment Button
        Button paymentButton = view.findViewById(R.id.payment_button);
        paymentButton.setOnClickListener(v -> {
            CheckoutFragment checkoutFragment = new CheckoutFragment();
            Bundle bundle = new Bundle();
            bundle.putDouble("total_price", totalPrice);
            bundle.putInt("total_items", count1 + count2);
            bundle.putString("selected_food", itemName1.getText().toString());
            checkoutFragment.setArguments(bundle);

            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, checkoutFragment)
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }

    private void updateTotalPrice() {
        totalPrice = (count1 + count2) * pricePerItem;
        totalText.setText(String.format("Total: $ %.2f", totalPrice));
    }
}