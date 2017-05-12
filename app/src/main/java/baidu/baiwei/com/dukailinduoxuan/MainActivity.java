package baidu.baiwei.com.dukailinduoxuan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import baidu.baiwei.com.dukailinduoxuan.Bean.bean;

public class MainActivity extends AppCompatActivity {

    private RecyclerView reclv;
    private TextView fan;
    private TextView quan;
   private List<bean> list=new ArrayList<>();
    private ReclvPage page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reclv = (RecyclerView) findViewById(R.id.reclv);
        quan = (TextView) findViewById(R.id.quan);
        fan = (TextView) findViewById(R.id.fan);
        LinearLayoutManager manager=new LinearLayoutManager(this);

        reclv.setLayoutManager(manager);
//如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        reclv.setHasFixedSize(true);
        for (int i=0;i<20;i++){
            bean bean=new bean("条目"+i,false);
            list.add(bean);
        }
        page = new ReclvPage(this);
        page.setList(list);
        reclv.setAdapter(page);

        quan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<list.size();i++){
                    list.get(i).setIschend(true);
                }
                page.notifyDataSetChanged();

            }
        });
        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    page.setZhonghe(new ReclvPage.Zongjia() {
                        @Override
                        public void ischend(boolean chend) {
                           for (int i=0;i<list.size();i++) {

                                if(list.get(i).getIschend()==true){
                                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                                    startActivity(intent);
                               }


                            }
                        }
                    });



            }
        });


    }


}
