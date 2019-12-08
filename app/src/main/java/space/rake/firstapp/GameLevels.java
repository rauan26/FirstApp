package space.rake.firstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              try {
                  Intent intent = new Intent(GameLevels.this, MainActivity.class);
                  startActivity(intent); finish();
              }
              catch (Exception e){

              }
            }
        });
        // кнопка для перехода на 1 уревень -начало
        TextView textView1=(TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                   Intent intent= new Intent(GameLevels.this, level1.class);
                   startActivity(intent);finish();
                }catch (Exception e){
                    //empty
                }
            }
        });

        //кнопка для перехода на уревень - конец
        // кнопка для перехода на 1 уревень -начало
        TextView textView2=(TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent= new Intent(GameLevels.this, level2.class);
                    startActivity(intent);finish();
                }catch (Exception e){
                    //empty
                }
            }
        });

        //кнопка для перехода на уревень - конец
    }
    // Системный кнопка "Назад" - начало
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(GameLevels.this, MainActivity.class);
            startActivity(intent); finish();
        }
        catch (Exception e){

        }
    }
    // Системный кнопка "Назад" - конец
}
