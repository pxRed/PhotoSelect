package px.com.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import px.com.photoselectorlibrary.ImageSelectorListActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button bt1,bt2;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1= (Button) findViewById(R.id.bt1);
        bt2= (Button) findViewById(R.id.bt2);
        tv1= (TextView) findViewById(R.id.tv_mes);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {   //单选
            case R.id.bt1:
                Intent it = new Intent(MainActivity.this, ImageSelectorListActivity.class);
                it.putExtra("type", 1);
                startActivityForResult(it, ImageSelectorListActivity.RESULT_OK);

                break;
            //多选
            case R.id.bt2:
                Intent it1 = new Intent(MainActivity.this, ImageSelectorListActivity.class);
                it1.putExtra("type", 2);
                startActivityForResult(it1, ImageSelectorListActivity.RESULT_OK);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //接收返回的图片路径
        if (requestCode == 10001) {
            if (data == null) return;
            ArrayList<String> filePath = data.getStringArrayListExtra("filePath");
            String str1 = "";
            for (String str : filePath) {
                str1 = str1 + str + "/n";
            }
           tv1.setText(str1+"0");
        }
    }
}
