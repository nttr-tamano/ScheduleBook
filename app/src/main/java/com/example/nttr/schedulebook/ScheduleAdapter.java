package com.example.nttr.schedulebook;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;

/**
 * Created by nttr on 2018/02/26.
 */

public class ScheduleAdapter extends RealmBaseAdapter {
    public ScheduleAdapter(@Nullable OrderedRealmCollection data) {
        super(data);
    }

    private static class ViewHolder {
        TextView date;
        TextView title;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // ListViewがセルのViewを表示する時呼ばれるっぽい

        ViewHolder viewHolder;

        // ListViewがセル(リストの要素のView)を使い回していない場合はnullである
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_2, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.date = (TextView) convertView.findViewById(android.R.id.text1);
            viewHolder.title = (TextView) convertView.findViewById(android.R.id.text2);
            // ViewHolderをタグに保存
            convertView.setTag(viewHolder);

        } else {
            // タグからViewHolderを取得
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (adapterData != null) {
            Schedule schedule = (Schedule) adapterData.get(position);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            String formatDate = sdf.format(schedule.date);
            viewHolder.date.setText(formatDate);
            viewHolder.title.setText(schedule.title);
        }
        return convertView;
    }
}
