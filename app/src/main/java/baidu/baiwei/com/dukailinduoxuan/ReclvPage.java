package baidu.baiwei.com.dukailinduoxuan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import baidu.baiwei.com.dukailinduoxuan.Bean.bean;

/**
 * Created by Administrator on 2017/5/12 0012.
 */
public class ReclvPage extends RecyclerView.Adapter<ReclvPage.ViewHolder>{
   private Context context;
    private List<bean> list=new ArrayList<>();

    public Zongjia gouwu;
    public ReclvPage(Context context){
        this.context=context;

    }
    public interface Zongjia {
   void ischend(boolean chend);
    }
 public void setZhonghe(Zongjia gouwu){
     this.gouwu=gouwu;
 }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.item, null);
        ViewHolder he=new ViewHolder(inflate);
        return he;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvname.setText(list.get(position).getName());
        holder.ckb.setChecked(list.get(position).getIschend());
       holder. ckb.setFocusable(false);

         holder.ckb.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 boolean checked = holder.ckb.isChecked();
                  gouwu.ischend(checked);
             }
         });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<bean> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvname;
        private final CheckBox ckb;

        public ViewHolder(View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.tvname);
            ckb = (CheckBox) itemView.findViewById(R.id.ckb);
        }
    }
}
