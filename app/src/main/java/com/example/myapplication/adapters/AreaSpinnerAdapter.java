package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.apiResponse.models.AreaOfCities;
import com.example.myapplication.customViews.BodyText;

import java.util.List;

public class AreaSpinnerAdapter  extends BaseAdapter {

    private Context context;
    private List<AreaOfCities> areaList;

    public AreaSpinnerAdapter(Context context, List<AreaOfCities> areaList) {
        this.context = context;
        this.areaList = areaList;
    }

    @Override
    public int getCount() {
        return areaList.size();
    }

    @Override
    public Object getItem(int position) {
        return areaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    private View getCustomView(int position, View convertView, ViewGroup parent) {
        AreaSpinnerAdapter.ViewHolder holder = null;
        if (convertView == null) {
            holder = new AreaSpinnerAdapter.ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.spinner_row_filters, parent, false);
            holder.name = convertView.findViewById(R.id.value_text_view);
            holder.line = convertView.findViewById(R.id.line_view);
            convertView.setTag(holder);
        } else {
            holder = (AreaSpinnerAdapter.ViewHolder) convertView.getTag();
        }

        if (this.areaList != null && this.areaList.size() > 0) {
            String option = this.areaList.get(position).getName();
            if (option != null) {
                holder.name.setText(option);
            }
        }

        if (position == 0) {
            holder.name.setVisibility(View.GONE);
            holder.line.setVisibility(View.GONE);
        } else {
            holder.name.setVisibility(View.VISIBLE);
            holder.line.setVisibility(View.VISIBLE);
        }

        return convertView;
    }

    private class ViewHolder {
        BodyText name;
        ImageView line;
    }
}
