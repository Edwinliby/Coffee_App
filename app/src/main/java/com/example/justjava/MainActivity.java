package com.example.justjava;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        String check1,check2;
        int price = (quantity*10);
        CheckBox whippedCream = (CheckBox) findViewById(R.id.whippedCream);
        boolean haswhippedCream = whippedCream.isChecked();
        if(haswhippedCream == true)
        {
            check1 = "Yes";
            price += 2;
        }
        else
        {
            check1 = "No";
        }

        CheckBox chocolateTopping = (CheckBox) findViewById(R.id.chocolate);
        boolean Chocolate = chocolateTopping.isChecked();
        if(Chocolate == true)
        {
            check2 = "Yes";
            price += 5;
        }
        else
        {
            check2 = "No";
        }
        EditText text = (EditText) findViewById(R.id.album_description_view);
        String name = text.getText().toString();

        String priceMessage ="Customer name: "+ name;
        priceMessage +="\nQuantity: "+quantity;
        priceMessage +="\nAdd whipped cream: "+check1;
        priceMessage +="\nAdd Chocolate: "+check2;
        priceMessage +="\nPrice: $"+price;
        displayMessage(priceMessage);
    }
    public void increment(View view){
        if(quantity == 100){
            return;
        }
        quantity += 1;
        display(quantity);
    }
    public void decrement(View view){
        if(quantity == 1){
            return;
        }
        quantity -= 1;
        display(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" "+number);
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummary = (TextView) findViewById(R.id.price_text_view);
        orderSummary.setText(message);
    }
}