package space.rake.firstapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class level1 extends AppCompatActivity {

    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        //создаем переменую text_levels
        TextView text_levels1=findViewById(R.id.text_levels);
        text_levels1.setText(R.string.level1);



        // код коорый скругляет углы для img lift
        ImageView img_left=(ImageView)findViewById(R.id.img_left);
        img_left.setClipToOutline(true);
        //end

        //experiment
         img_left.setImageDrawable(getResources().getDrawable(R.drawable.onelevel_eight));

        // код коорый скругляет углы для img right
        final ImageView img_right=(ImageView)findViewById(R.id.img_right);
        img_right.setClipToOutline(true);
        //end

        //развернуть игру на весь экран-начало
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS ,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //развернуть игру на весь экран-конец

        //вызов диологового окна в начале игры
        dialog=new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголвка
        dialog.setContentView(R.layout.previewdialog);//путь к диалогу
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный задний фон
        dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад

        //кнопка который закрываеть дтолог окно-начало
        TextView btnclose=(TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when presses button-начало
                try{
                     //Вернуться назад к выбронному уровня-начало
                    Intent intent=new Intent(level1.this, GameLevels.class);
                    startActivity(intent);finish();
                    //конец
                }
                catch (Exception e){
                    //no code here
                }
                dialog.dismiss();//закрываем диологовый окно
                // конец кнопка
            }
        });

        //конец
        //кнопка *Продолжить* -начало
        Button btncontinue1=(Button)dialog.findViewById(R.id.btncontinue);
        btncontinue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();//закрываем диологовый окно
            }
        });
        //кнопка *Продолжить* -конец
        dialog.show();//показываеть диолог

        //btn back
        Button btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent1 = new Intent(level1.this, GameLevels.class);
                    startActivity(intent1); finish();
                }
                catch (Exception e){

                }
            }
        });
    }
    // Системный кнопка "Назад" - начало
    @Override
    public void onBackPressed(){
        try {
            Intent intent2 = new Intent(level1.this, GameLevels.class);
            startActivity(intent2); finish();
        }
        catch (Exception e){

        }
    }
    // Системный кнопка "Назад" - конец

}
