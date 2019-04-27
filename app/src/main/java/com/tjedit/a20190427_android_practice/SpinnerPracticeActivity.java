package com.tjedit.a20190427_android_practice;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.tjedit.a20190427_android_practice.adapters.PizzaStoreAdapter;
import com.tjedit.a20190427_android_practice.databinding.ActivitySpinnerPracticeBinding;
import com.tjedit.a20190427_android_practice.datas.PizzaStore;

import java.util.ArrayList;
import java.util.List;

public class SpinnerPracticeActivity extends AppCompatActivity {

    List<PizzaStore>pizzaStores = new ArrayList<>();
    ActivitySpinnerPracticeBinding act;
    PizzaStoreAdapter pizzaStoreAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = DataBindingUtil.setContentView(this,R.layout.activity_spinner_practice);

        fillPizzaStores();
        pizzaStoreAdapter = new PizzaStoreAdapter(SpinnerPracticeActivity.this, pizzaStores);
        act.pizzaStoreSpinner.setAdapter(pizzaStoreAdapter);

        act.pizzaStoreSpinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerPracticeActivity.this, String.format("%s 선택",pizzaStores.get(position)), Toast.LENGTH_SHORT).show();
            }
        });

        act.cofirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        int selectedPostion = act.pizzaStoreSpinner.getSelectedItemPosition();
        String selectedPizzaStorName = pizzaStores.get(selectedPostion).storeName;
                Toast.makeText(SpinnerPracticeActivity.this,String.format("현재 선택된 가게이름 : %s",selectedPizzaStorName), Toast.LENGTH_SHORT).show();

            }
        });


    }

    void fillPizzaStores(){
        pizzaStores.add(new PizzaStore("도미노피자","광진구","09:00~22:00", "http://cfs15.tistory.com/image/24/tistory/2008/11/05/18/00/491160cb593e2"));
        pizzaStores.add(new PizzaStore("미스터피자","관악구","10:00~21:00", "http://postfiles12.naver.net/20160530_171/ppanppane_14646177044221JRNd_PNG/%B9%CC%BD%BA%C5%CD%C7%C7%C0%DA_%B7%CE%B0%ED_%281%29.png?type=w966"));
        pizzaStores.add(new PizzaStore("피자헛피자","강동구","11:00~23:00", "https://mblogthumb-phinf.pstatic.net/20141124_182/howtomarry_1416806028308979cg_PNG/Pizza_Hut_logo.svg.png?type=w2"));
        pizzaStores.add(new PizzaStore("파파존스피자","성북구","17:00~익일 3:00", "http://postfiles2.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w966"));

    }
}
