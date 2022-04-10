package com.awardega.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_insert;
    CheckBox chb_onePerson;
    EditText et_name;
    EditText et_surname;
    EditText et_country;
    ToggleButton tb_sex;
    EditText et_phoneNumber;
    RadioButton rb_viewAll;
    RadioButton rb_viewFemale;
    RadioButton rb_viewMale;
    ListView lv_customerView;
    String tx_sex;
    ArrayAdapter customerArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_insert = (Button) findViewById(R.id.btn_insert);
        chb_onePerson = (CheckBox) findViewById(R.id.chb_onePerson);
        et_name = (EditText) findViewById(R.id.et_name);
        et_surname = (EditText) findViewById(R.id.et_surname);
        et_country = (EditText) findViewById(R.id.et_country);
        tb_sex = (ToggleButton) findViewById(R.id.tb_sex);
        et_phoneNumber = (EditText) findViewById(R.id.et_phoneNumber);
        rb_viewAll = (RadioButton) findViewById(R.id.rb_viewAll);
        rb_viewFemale = (RadioButton) findViewById(R.id.rb_viewFemale);
        rb_viewMale = (RadioButton) findViewById(R.id.rb_viewMale);
        lv_customerView = (ListView) findViewById(R.id.lv_customerView);

        tb_sex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tx_sex = "Female";
                } else {
                    tx_sex = "Male";
                }
            }
        });

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomerModel customerModel;
                try {
                    customerModel = new CustomerModel(-1, et_name.getText().toString(), et_surname.getText().toString(), et_country.getText().toString(), tx_sex, Integer.parseInt(et_phoneNumber.getText().toString()));
                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    customerModel = new CustomerModel(-1, "Joe", "Doe", "Earth", "Male", Integer.parseInt("123456789"));
                    Toast.makeText(MainActivity.this, customerModel.toString(), Toast.LENGTH_SHORT).show();
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

                boolean success = dataBaseHelper.addOne(customerModel);

                Toast.makeText(MainActivity.this, "Success = " + success, Toast.LENGTH_SHORT).show();
            }
        });

        rb_viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                List<CustomerModel> everyone = dataBaseHelper.getEveryOne();

                customerArrayAdapter = new ArrayAdapter<CustomerModel>(MainActivity.this, android.R.layout.simple_list_item_1, everyone);
                lv_customerView.setAdapter(customerArrayAdapter);
            }
        });

        rb_viewFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "View female customer", Toast.LENGTH_SHORT).show();
            }
        });

        rb_viewMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "View male customer", Toast.LENGTH_SHORT).show();
            }
        });
    }
}