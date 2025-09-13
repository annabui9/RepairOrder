package com.example.repairorder;

//import static android.os.Build.VERSION_CODES_FULL.R;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.LinkedList;
import java.util.Random;

public class RepairOrderActivity extends AppCompatActivity { // parent class for android activities

    double numbers = 0.0;

    double salesTax = .0975;

    TextView subtotalValue;
    TextView taxValue;
    TextView totalValue;
    Button submitB; // 1. create button
    //EditText orderTypeET;
    EditText inspectionET;
    EditText paintET;
    EditText partsET;
    EditText laborET;
    //spinner attempt
    // Spinner orderTypes = (Spinner) findViewById(R.id.spinner_orderType);




    //spinnerattempt
//    private void useStringResource(){
//       String [] content = getResources().getStringArray(R.array.orderTypes);
//       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,content);
//       orderTypes.setAdapter(adapter);
//
//
//   }

//   private void useStringArray(){
//       LinkedList<> orderTypesList = new LinkedList<>();
//       orderTypesList.add("Car Repair");
//       orderTypesList.add("Truck Repair");
//       orderTypesList.add("Tire Repair");
//       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,content);
//       orderTypes.setAdapter(adapter);
//   }

    View.OnClickListener buttonListener = new View.OnClickListener() { // 3. create listener
        @Override
        public void onClick(View v) { //5.
//            Random gen = new Random();
//            double number = gen.nextDouble();
//            String n = "$" + number;
//            subtotalValue.setText(n); //assigning number to subtotal

            //String orderTypeValue = orderTypeET.getText().toString();
            //Double orderTypeNum;
            //if (orderTypeValue.isEmpty()) {
            //    orderTypeNum = 0.0;
            //} else {
             //   orderTypeNum = Double.parseDouble(orderTypeValue);
            //}

            String inspectionValue = inspectionET.getText().toString();
            Double inspectionNum;
            if (inspectionValue.isEmpty()) {
                inspectionNum = 0.0;
            } else {
                inspectionNum = Double.parseDouble(inspectionValue);
            }

            String paintValue = paintET.getText().toString();
            Double paintNum;
            if (paintValue.isEmpty()) {
                paintNum = 0.0;
            } else {
                paintNum = Double.parseDouble(paintValue);
            }

            String partsValue = partsET.getText().toString();
            Double partsNum;
            if (partsValue.isEmpty()) {
                partsNum = 0.0;
            } else {
                partsNum = Double.parseDouble(partsValue);
            }

            String laborValue = laborET.getText().toString();
            Double laborNum;
            if (laborValue.isEmpty()) {
                laborNum = 0.0;
            } else {
                laborNum = Double.parseDouble(laborValue);
            }

            Double subtotalNum = inspectionNum + paintNum + partsNum + laborNum;
            String subtotalString = subtotalNum.toString();
            subtotalValue.setText(subtotalString);

            Double taxNum = subtotalNum * salesTax;
            String taxString = taxNum.toString();
            taxValue.setText(taxString);

            Double totalNum = subtotalNum + taxNum;
            String totalString = totalNum.toString();
            totalValue.setText(totalString);




        }
    };

//spinner attempt
    //    AdapterView.OnItemSelectedListener spinnerListener = new AdapterView.OnItemSelectedListener(){
//
//        @Override
//        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//        }
//
//        @Override
//        public void onNothingSelected(AdapterView<?> parent) {
//
//        }
//    };


    @Override
    protected void onCreate(Bundle savedInstanceState) { // this is what is created when launched

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_repair_order); //UI laid out by this line
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> { //make sure ran properly
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        subtotalValue = findViewById(R.id.subtotalValue); //locate any thing in UI
        taxValue = findViewById(R.id.taxValue);
        totalValue = findViewById(R.id.totalValue);
        submitB = findViewById(R.id.submitButton); // 2.
        submitB.setOnClickListener(buttonListener); // 4. registering the listener to the button
        //orderTypeET = findViewById(R.id.editOrderType);
        inspectionET = findViewById(R.id.editInspection);
        paintET = findViewById(R.id.editPaint);
        partsET = findViewById(R.id.editParts);
        laborET = findViewById(R.id.editLabor);

        //spinner attempt
        //Spinner orderTypes = (Spinner) findViewById(R.id.spinner_orderType);
        //String[] types = new String[]{ "Car Repair", "Truck Repair", "Oil Change", "Tire Change" };
        //ArrayAdapter<String> adapter =
                //new ArrayAdapter<String>(this,
                        //android.R.layout.simple_spinner_item, types);
        //orderTypes.setAdapter(adapter);

//        Random gen = new Random();
//        double number = gen.nextDouble();
//        String n = "$" + number;
//        subtotalPrice.setText(n); //UI
//        String value = subtotalPrice.getText().toString(); //What's in the UI into the code
//        Log.i("TEST", value);

    }
}