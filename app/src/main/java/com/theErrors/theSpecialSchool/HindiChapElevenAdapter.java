package com.theErrors.theSpecialSchool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class HindiChapElevenAdapter extends BaseAdapter {
    Context context;
    int[] arr;
    LayoutInflater inflater;
    public HindiChapElevenAdapter(Context context, int[] arr)
    {
        this.context = context;
        this.arr = arr;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return arr.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.ui_one,null);
        ImageView img = view.findViewById(R.id.image);
        img.setImageResource(arr[i]);
        return view;
    }
}

