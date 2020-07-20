package com.example.keyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.util.ArrayList;

import java.util.Calendar;

//implement on interface View.OnClickListener
//implement an interface(Adapter.onItemSelctedListener)

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

//declare editText variable that  is the focus of the calender dialogue
    private EditText birthday;
    //declare the variables to hold the selected date
            private int mYear;
            private int mMonth;
            private int mDay;
    //declare a variable for holding the item selected on the spinner
    private String mSpinnerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //connect the edit text variable created with the one specified in the layout for receiving the date value
        birthday = findViewById(R.id.birthday);
        //connect the EditText variable with an OnClick Listener
        birthday.setOnClickListener(this);
        //declare a spinner variable and connect it with the spinner view in the layout

        Spinner phoneSpinner = findViewById(R.id.phone_spinner);
        //set an onItemListener on the spinner object/variable you have created
        if(phoneSpinner!=null){
            phoneSpinner.setOnItemSelectedListener(this);
        }
        //create an array adapter using the array amd default spinner layout

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_label, android.R.layout.simple_spinner_item);
   //specify the layout for dropdown menu
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //attach the spinner to the adapter
        if(phoneSpinner!=null) {
            phoneSpinner.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View v) {
//allow to get the instance of the current date
        //ensure the focus is on the edit text variable birthday
        if (v==birthday){
            //declare a calender to get current selected date
            final Calendar c = Calendar.getInstance();

            mYear =c.get(Calendar.YEAR);
            mMonth =c.get(Calendar.MONTH);
            mDay =c.get(Calendar.DAY_OF_MONTH);
            //declare a date picker dialog to pick selected date
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//set the date on the editText variable
                    birthday.setText(dayOfMonth +"-"+(month+1)+"-"+year);
                }
            },mYear,mMonth,mDay);
            //show datePicker dialogue
            datePickerDialog.show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        //declare a variable for holding the item selected on the spinner
//use the method getItemPosition to get the label selected
        mSpinnerLabel = adapterView.getItemAtPosition(position).toString();
        //something to do view item selected
        Toast myToast = Toast.makeText(this,"Selected phone as:"+mSpinnerLabel,Toast.LENGTH_SHORT);
        myToast.show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //something to do
        Toast toast = Toast.makeText(this,"nothing selected",Toast.LENGTH_SHORT);
        toast.show();

    }

    public void showToast(View view) {
        Toast check = Toast.makeText(this,"Please Accept Terms and Conditions",Toast.LENGTH_SHORT);
        check.show();
    }

    public void createAccount(View view) {
        //compare passwords through error exemptions
        //get the data entered on edit text and save it on database
        //add an intent and open main activity/login
        //throw a toast
        Toast toastSubmit = Toast.makeText(this, "Account Creation Successful",Toast.LENGTH_SHORT);
        toastSubmit.show();

    }
}
