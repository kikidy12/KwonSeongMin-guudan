package kr.co.djeit.gugudanapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import kr.co.djeit.gugudanapplication.adapters.GuguAdapter;
import kr.co.djeit.gugudanapplication.datas.GuguData;

public class MainActivity extends AppCompatActivity {

    private android.widget.Button twoBtn;
    private android.widget.Button threeBtn;
    private android.widget.Button fourBtn;
    private android.widget.Button fiveBtn;
    private android.widget.Button sixBtn;
    private android.widget.Button sevenBtn;
    private android.widget.Button eightBtn;
    private android.widget.Button nineBtn;
    private android.widget.Button allBtn;
    private android.widget.CheckBox duplCheckBox;
    private android.widget.ListView resultListView;
    private android.widget.Button resetBtn;

    private View[] guguBtn = {twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn};

    private GuguAdapter mAdapter;
    private List<GuguData> guguDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindVIews();
        setValues();
        setUpEvents();

    }

    private void setUpEvents() {
        duplCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                guguDatas.clear();
                mAdapter.notifyDataSetInvalidated();
            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guguDatas.clear();
                mAdapter.notifyDataSetInvalidated();
            }
        });

        twoBtn.setOnClickListener(guguSingleListen);
        threeBtn.setOnClickListener(guguSingleListen);
        fourBtn.setOnClickListener(guguSingleListen);
        fiveBtn.setOnClickListener(guguSingleListen);
        sixBtn.setOnClickListener(guguSingleListen);
        sevenBtn.setOnClickListener(guguSingleListen);
        eightBtn.setOnClickListener(guguSingleListen);
        nineBtn.setOnClickListener(guguSingleListen);
        allBtn.setOnClickListener(guguSingleListen);
    }

    private void setValues() {
        mAdapter = new GuguAdapter(MainActivity.this, guguDatas);
        resultListView.setAdapter(mAdapter);
    }

    View.OnClickListener guguSingleListen = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (duplCheckBox.isChecked() == false) {
                guguDatas.clear();
                if (v == allBtn) {
                    allGugu(v);
                } else {
                    guguDan(v);
                }
            }
            else {
                if (v == allBtn) {
                    guguDatas.clear();
                    allGugu(v);
                } else {
                    guguDan(v);
                }
            }
            mAdapter.notifyDataSetChanged();
        }
    };

    private void guguDan(View v) {
        int dan = Integer.parseInt(v.getTag().toString());
        boolean isdupl = false;
        for(GuguData gugu : guguDatas) {
            if(gugu.getDan() == dan) {
                isdupl = true;
                break;
            }
        }
        if(isdupl == false) {
            for (int j = 1; j <= 9; j++) {
                guguDatas.add(new GuguData(dan, j));
            }
        }

    }
    private void allGugu(View v) {
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                guguDatas.add(new GuguData(i, j));
            }
        }
    }

    private void bindVIews() {
        this.resetBtn = (Button) findViewById(R.id.resetBtn);
        this.resultListView = (ListView) findViewById(R.id.resultListView);
        this.duplCheckBox = (CheckBox) findViewById(R.id.duplCheckBox);
        this.allBtn = (Button) findViewById(R.id.allBtn);
        this.nineBtn = (Button) findViewById(R.id.nineBtn);
        this.eightBtn = (Button) findViewById(R.id.eightBtn);
        this.sevenBtn = (Button) findViewById(R.id.sevenBtn);
        this.sixBtn = (Button) findViewById(R.id.sixBtn);
        this.fiveBtn = (Button) findViewById(R.id.fiveBtn);
        this.fourBtn = (Button) findViewById(R.id.fourBtn);
        this.threeBtn = (Button) findViewById(R.id.threeBtn);
        this.twoBtn = (Button) findViewById(R.id.twoBtn);
    }
}
