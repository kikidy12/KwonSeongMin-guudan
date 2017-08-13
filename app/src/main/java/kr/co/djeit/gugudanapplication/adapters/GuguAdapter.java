package kr.co.djeit.gugudanapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import kr.co.djeit.gugudanapplication.R;
import kr.co.djeit.gugudanapplication.datas.GuguData;

/**
 * Created by one on 2017-08-13.
 */

public class GuguAdapter extends ArrayAdapter<GuguData> {

    Context mContext;
    List<GuguData> mList;
    LayoutInflater inf;

    public GuguAdapter(Context context, List<GuguData> list) {
        super(context, R.layout.gugu_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null) {
            row = inf.inflate(R.layout.gugu_list_item, null);
        }

        GuguData data = mList.get(position);

        TextView printTxt = (TextView) row.findViewById(R.id.printTxt);

        String str = String.format(Locale.KOREA, "%d X %d = %d", data.getDan(), data.getNumber(), data.getDan()*data.getNumber());
        printTxt.setText(str);

        return row;
    }
}
