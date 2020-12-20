package com.example.recyclerviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

//Предоставя view-елементи на RecyclerView с данни от mDataSet.
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private String[] mDataSet;

    //Рефериране към типа на данните (custom ViewHolder)
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View v) {
            super(v);
            // Дефиниране на click listener за елементите на ViewHolder
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Елемент " + getAdapterPosition() + " е кликнат.",
                            Toast.LENGTH_SHORT).show();
                }
            });
            textView = (TextView) v.findViewById(R.id.textView);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    /**
     * Инициализизация набора от данни на адаптера.
     *
     * @param dataSet String[] съдържа данните за попълване на view-елементи,
     *                които да се използват от RecyclerView.
     */
    public CustomAdapter(String[] dataSet) {
        mDataSet = dataSet;
    }

    // Създаване на views (извикани от layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(v);
    }

    // Заменяне на сдържанието на view-елементите (извикани от layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.getTextView().setText(mDataSet[position]);
    }

    // Връща размера на данните
    //RecyclerView използва това, за да определи кога елементите, които могат да бъдат показани
    // са свършили
    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}