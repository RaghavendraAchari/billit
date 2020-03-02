package com.example.billit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.billit.models.BillItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView ;
    RecyclerView.LayoutManager mLayoutManager;
    ArrayList<BillItem> mBillList ;

    //Request Code
    static final int NEW_BILL_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createItemList();

        setRecyclerView();

    }

    private void createItemList() {
        mBillList = new ArrayList<>();
        for(int i=0; i<50 ;i++){
            mBillList.add(new BillItem(i, "Title " + i, "Subtitle " + i));
        }
    }

    private void setRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.list_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(new Adapter(mBillList));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_menu:
                Log.i("Main Activity", "addMenu clicked");
                startActivityForResult(AddBillActivity.NewInstance(this),NEW_BILL_REQUEST);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == NEW_BILL_REQUEST){
            if(resultCode == RESULT_OK){
                BillItem newBill = (BillItem) data.getExtras().getSerializable(AddBillActivity.TAG);
                mBillList.add(newBill);

            }
        }
    }
}
