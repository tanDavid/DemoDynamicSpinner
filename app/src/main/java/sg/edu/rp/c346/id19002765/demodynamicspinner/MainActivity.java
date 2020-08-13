package sg.edu.rp.c346.id19002765.demodynamicspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.button);

        //Initialise the ArrayList
        alNumbers = new ArrayList<>();

        //Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        //Add to array
        alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");

        //Bind the ArrayAdapter to the spinner
        spn2.setAdapter(aaNumbers);



         spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {


                 //Approach 1
                 switch(pos){
                     case 0:
                         String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                         alNumbers.addAll(Arrays.asList(strNumbers));
                         //set Default
                         spn2.setSelection(2);
                         break;

                     case 1:
                         strNumbers = getResources().getStringArray(R.array.odd_numbers);
                         alNumbers.addAll(Arrays.asList(strNumbers));
                         //set Default
                         spn2.setSelection(1);
                         break;
                 }



             }

             @Override
             public void onNothingSelected(AdapterView<?> parent) {

             }
         });

         btnUpdate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int pos = spn1.getSelectedItemPosition();
                 alNumbers.clear();

                 if(pos == 0){
                     String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                     alNumbers.addAll(Arrays.asList(strNumbers));
                 }
                 else{
                     String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                     alNumbers.addAll(Arrays.asList(strNumbers));
                 }

             }
         });

    }
}
