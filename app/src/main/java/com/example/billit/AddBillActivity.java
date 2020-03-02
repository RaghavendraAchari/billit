package com.example.billit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.TextKeyListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.billit.models.BillItem;

import java.io.Serializable;

public class AddBillActivity extends AppCompatActivity {
    BillItem newBill ;

    public static final String TAG = "AddBillActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bill);

        EditText mBillTitleText = (EditText) findViewById(R.id.inputBillTitle);
        EditText mBillDescText = (EditText)findViewById(R.id.inputBillDesc);
        ImageButton mCameraButton = (ImageButton) findViewById(R.id.cameraButton);
        Button mAddButton = (Button) findViewById(R.id.addBillButton);
        Button mCancelButton = (Button) findViewById(R.id.cancelButton);

        newBill = new BillItem();

        setListeners(mBillTitleText, mBillDescText, mCameraButton, mAddButton, mCancelButton);
        newBill.setId(0);

    }

    private void setListeners(EditText mBillTitleText, EditText mBillDescText,
                              ImageButton mCameraButton, Button mAddButton, Button mCancelButton) {
        mBillTitleText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "Before Text Changed()");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG , s.toString());
                newBill.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "After Text Changed()");
            }
        });
        mBillDescText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d(TAG, "Before Text Changed()");
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG , s.toString());
                newBill.setSubTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d(TAG, "After Text Changed()");
            }
        });
        mCameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Camera Button Clicked");
                //open camera and get the picture and copy the path set the path in newBill Instance
            }
        });
        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Add Bill Button Clicked");
                //return an intent with newBill instance
                int resultCode = RESULT_OK;
                Intent intent = new Intent();
                intent.putExtra(TAG, (Serializable) newBill);
                setResult(resultCode, intent);
                finish();
            }
        });
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Cancel Button Clicked");
                finish();
            }
        });
    }

    public static Intent NewInstance(Context context){
        Intent intent = new Intent(context, AddBillActivity.class);
        return intent;
    }
}
