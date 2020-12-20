package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final int DATASET_COUNT = 60;
    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected String[] mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализиране на набор от данни, тези данни обикновено идват от SQLite база от данни
        // или отдалечен сървър.
        initDataset();
        // Инициализация на RecyclerView
        mRecyclerView = findViewById(R.id.recyclerView);
        // LinearLayoutManager е използван тук, това ще разположи елементите по подобен начин
        // към начина, по който ListView би разположил елементи. RecyclerView.LayoutManager определя
        // как елементите са представени на екрана на мобилното устройство.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Адаптер
        mAdapter = new CustomAdapter(mDataset);
        // Задаване на CustomAdapter като адаптер за RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Хоризонтална черта, разделяща елементите в списъка
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
    }

    // Генерира демо данни за адаптера на RecyclerView
    private void initDataset() {
        mDataset = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            mDataset[i] = "Това е елемент #" + i;
        }
    }
}