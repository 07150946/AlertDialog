package com.example.yusiqing;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

y

public class myapplication1 extends AppCompatActivity {

    private TextView tv1;
    private AlertDialog.Builder builder;
    private AlertDialog ad;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(myapplication1.R.layout.ad);
        tv1 = (TextView) findViewById(myapplication1.R.id.textView1);

        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        Button b4 = (Button) findViewById(R.id.button4);
        Button b5 = (Button) findViewById(R.id.button5);
        Button b6 = (Button) findViewById(R.id.button6);
        Button b7 = (Button) findViewById(R.id.button7);

        switch (v.getId()) {
            case R.id.button1:
                dialog1();
                break;
            case R.id.button2:
                dialog2();
                break;
            case R.id.button3:
                dialog3();
                break;
            case R.id.button4:


                View.OnClickListener listener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog4();
                        break;
                        case R.id.button5:
                        dialog5();
                        break;
                        case R.id.button6:
                        dialog6();
                        break;
                        case R.id.button7:
                        dialog7();
                        break;
                    }

                }

        } ;

        b1.setOnClickListener(listener);
        b2.setOnClickListener(listener);
        b3.setOnClickListener(listener);
        b4.setOnClickListener(listener);
        b5.setOnClickListener(listener);
        b6.setOnClickListener(listener);
        b7.setOnClickListener(listener);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    private void dialog1() {

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("提示");
        ad.setMessage("确定退出吗？");
        ad.setIcon(android.R.drawable.ic_dialog_alert);

        DialogInterface.OnClickListener lis1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    ad.dismiss();
                    MainActivity1.this.finish();
                } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    ad.dismiss();
                }
            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE, "退出", lis1);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", lis1);
        ad.show();

    }

    private void dialog2() {
        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("调查");
        ad.setMessage("你忙吗？");
        ad.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener lis2 = new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        str = "我很忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str = "我很闲";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str = "我无所谓在";
                        break;
                }
                tv1.setText(str);

            }
        };
        ad.setButton(DialogInterface.BUTTON_POSITIVE, "很忙", lis2);
        ad.setButton(DialogInterface.BUTTON_NEGATIVE, "很闲", lis2);
        ad.setButton(DialogInterface.BUTTON_NEUTRAL, "一般", lis2);
        ad.show();

    }

    private void dialog3() {

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("输入的感言");
        ad.setMessage("请输入获奖感言");
        ad.setIcon(android.R.drawable.ic_dialog_dialer);

        final EditText et1 = new EditText(this);
        ad.setView(et1);

        DialogInterface.OnClickListener lis3 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("你的感言：" + et1.getText().toString());
            }
        };
        ad.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", lis3);
        ad.show();
    }

    private void dialog4() {
        final String item[] = new String[]{"广州", "深圳", "汕尾"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener lis4 = new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which] = isChecked;
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item, bSelect, lis4);
        ad = builder.create();
        ad.setTitle("多选框");
        DialogInterface.OnClickListener lis41 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你已经选择了";
                for (int i = 0; i < bSelect.length; i++) {
                    if (bSelect[i]) {
                        str += "\n" + item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(DialogInterface.BUTTON_NEGATIVE, "确定", lis41);
        ad.show();
    }

    private void dialog5() {
        final String item[] = new String[]{"广州", "深圳", "汕尾"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener lis5 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                for (int i = 0; i < bSelect.length; i++) {
                    if (i != which) {
                        bSelect[i] = false;
                    } else {
                        bSelect[i] = true;
                    }
                }
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item, -1, lis5);
        ad = builder.create();
        ad.setTitle("单选");
        DialogInterface.OnClickListener lis51 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你已经选择了";
                for (int i = 0; i < bSelect.length; i++) {
                    if (bSelect[i]) {
                        str += "\n" + item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        ad.setButton(AlertDialog.BUTTON_POSITIVE, "确定", lis51);
        ad.show();

    }

    private void dialog6() {

        final String item[] = new String[]{"广州", "深圳", "汕尾"};
        final boolean bSelect[] = new boolean[item.length];
        DialogInterface.OnClickListener lis6 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "你已经选择了：" + item[which];
                tv1.setText(str);
            }
        };
        builder = new AlertDialog.Builder(this);
        builder.setItems(item, lis6);
        ad = builder.create();
        ad.setTitle("列表");

        DialogInterface.OnClickListener lis61 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ad.dismiss();
            }
        };
        ad.setButton(AlertDialog.BUTTON_POSITIVE, "确定", lis61);
        ad.show();

    }

    private void dialog7() {
        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.ad, null);
        final EditText et1 = (EditText) layout.findViewById(R.id.et);

        ad = new AlertDialog.Builder(this).create();
        ad.setTitle("自定义布局");
        ad.setView(layout);


        DialogInterface.OnClickListener lis7 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("输入的是：" + et1.getText().toString());
            }
        };
        ad.setButton(AlertDialog.BUTTON_POSITIVE, "确定", lis7);
        ad.setButton(AlertDialog.BUTTON_NEGATIVE, "取消", lis7);
        ad.show();
    }


    }
}
