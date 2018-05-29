package com.example.chenshuai20180514.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.chenshuai20180514.R;
import com.example.chenshuai20180514.bean.MyBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<MyBean.DataBean> list;
    private Context context;

    public ListAdapter(List<MyBean.DataBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate = View.inflate(context, R.layout.item_layout, null);

        return new ViewHodels(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHodels hs = (ViewHodels) holder;
        MyBean.DataBean bean = list.get(position);
        hs.name.setText(bean.getUser().getNickname());
        hs.timer.setText(bean.getCreateTime());
        hs.nr.setText(bean.getContent());
        if (bean.getImgUrls()==null){
//            hs.txnr.setVisibility(View.INVISIBLE);
        }else {
//            hs.txnr.setVisibility(View.GONE);
            String[] split = bean.getImgUrls().split("\\|");
            Uri parse = Uri.parse(split[0]);
            hs.txnr.setImageURI(parse);
            Log.e("jljs", "onBindViewHolder: "+parse );
        }

        if (bean.getUser().getIcon()==null){
//            hs.tx.setVisibility(View.INVISIBLE);
        }else{
//            hs.tx.setVisibility(View.GONE);
            String icon = bean.getUser().getIcon();
            Uri parse1 = Uri.parse(icon);
            hs.tx.setImageURI(parse1);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHodels extends RecyclerView.ViewHolder {

        private final SimpleDraweeView tx;
        private final SimpleDraweeView txnr;
        private final TextView name;
        private final TextView timer;
        private final TextView nr;

        public ViewHodels(View itemView) {
            super(itemView);
            tx = itemView.findViewById(R.id.tx);
            txnr = itemView.findViewById(R.id.tpnr);
            name = itemView.findViewById(R.id.name);
            timer = itemView.findViewById(R.id.timer);
            nr = itemView.findViewById(R.id.nr);
        }
    }

}
