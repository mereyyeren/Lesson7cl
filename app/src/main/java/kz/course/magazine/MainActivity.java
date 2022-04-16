package kz.course.magazine;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView androidPhone, iOsPhone;
    RadioButton bankRadio,aqshaRadio;
    CheckBox siyliqCheckBox,mekenCheckBox;
    Button jiberuBtn;

    String tolemTuri, jetkizuText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        androidPhone = findViewById(R.id.androidPhone);
        iOsPhone = findViewById(R.id.iOsPhone);
        bankRadio = findViewById(R.id.bankRadio);
        aqshaRadio = findViewById(R.id.aqshaRadio);

        siyliqCheckBox = findViewById(R.id.siyliqCheckBox);
        mekenCheckBox = findViewById(R.id.mekenCheckBox);

        jiberuBtn = findViewById(R.id.jiberuBtn);


        registerForContextMenu(androidPhone);
        registerForContextMenu(iOsPhone);

        jiberuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(bankRadio.isChecked()){
                    tolemTuri = "Банк карточкасы арқылы";
                }else if(aqshaRadio.isChecked()){
                    tolemTuri = "Қолма қол арқылы";
                }

                if(siyliqCheckBox.isChecked()){
                    jetkizuText = "Сыйлық ретінде";
                }

                if(mekenCheckBox.isChecked()){
                    jetkizuText = "Мекенжайға жеткізу";
                }


                String result = "Android: "+androidPhone.getText()+"\n"+
                        "iOs: "+iOsPhone.getText()+"\n"+
                        "Төлем түрі:"+tolemTuri+"\n"+
                        "Жеткізу түрі:"+jetkizuText;

                Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();




            }
        });


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        if(v == androidPhone) {
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.android_menu, menu);
        }


        if(v ==iOsPhone){
            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.ios_menu, menu);
        }


        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.samsungPhone:
                androidPhone.setText("Samsung");

                break;
            case R.id.lgPhone:
                androidPhone.setText("LG");
                break;
            case R.id.huaweiPhone:
                androidPhone.setText("Huawei");
                break;
            case R.id.xiaomiPhone:
                androidPhone.setText("Xiaomi");
                break;


            case R.id.iPhone9:
                iOsPhone.setText("iPhone9");
                break;
            case R.id.iPhone10:
                iOsPhone.setText("iPhone10");
                break;
            case R.id.iPhone13:
                iOsPhone.setText("iPhone13");
                break;
            case R.id.iPhone12:
                iOsPhone.setText("iPhone12");
                break;
            case R.id.iPhone13Pro:
                iOsPhone.setText("iPhone13 Pro");
                break;


        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_setting:
                Toast.makeText(this, "Setting menu basildi", Toast.LENGTH_LONG).show();
                break;


            case R.id.menu_exit:
                Toast.makeText(this, "Exit menu basildi", Toast.LENGTH_LONG).show();
                break;


            case R.id.menu_save:
                Toast.makeText(this, "Save menu basildi", Toast.LENGTH_LONG).show();
                break;


            case R.id.menu_cut:
                Toast.makeText(this, "Cut menu basildi", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}