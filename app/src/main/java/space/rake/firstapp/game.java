package space.rake.firstapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class game extends AppCompatActivity {

    ImageView iv_dice_p1, iv_dice_p2, iv_lives_p1, iv_lives_p2;
    TextView tv_player1, tv_player2;

    Random r;

    Animation animation;
    int livesP1, livesP2;
    int rolledP1, rolledP2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blankaempty);

        r=new Random();

        animation=new AnimationUtils().loadAnimation(this, R.anim.rotate);

        iv_dice_p1=findViewById(R.id.iv_dice_p1);
        iv_dice_p2=findViewById(R.id.iv_dice_p2);

        iv_lives_p1=findViewById(R.id.iv_lives_p1);
        iv_lives_p2=findViewById(R.id.iv_lives_p2);

        tv_player1=findViewById(R.id.tv_player1);
        tv_player2=findViewById(R.id.tv_player2);

        tv_player1.setText("PLAYER 1 ROLL!");
        tv_player2.setText("PLAYER 2 ROLL!");

        livesP1=6;
        livesP2=6;
        setDiceImage(livesP1, iv_lives_p1);
        setDiceImage(livesP2, iv_lives_p2);

        iv_dice_p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             rolledP1=r.nextInt(6)+1;
             setDiceImage(rolledP1, iv_dice_p1);

             if(rolledP2!=0){
                 tv_player1.setText("PLAYER 1 ROLL!");
                 tv_player2.setText("PLAYER 2 ROLL!");

                 if(rolledP1>rolledP2){
                     livesP2--;
                     setDiceImage(livesP2, iv_lives_p2);
                 }if (rolledP2>rolledP1){
                     livesP1--;
                     setDiceImage(livesP1, iv_lives_p1);
                 }

                 rolledP1=0;
                 rolledP2=0;
                 checkEndGame();
                 iv_dice_p1.setEnabled(true);
                 iv_dice_p2.setEnabled(true);
             }
             else{
                 tv_player1.setText("PLAYER 1 ROLLED");
                 iv_dice_p1.setEnabled(false);
             }
            }
        });

        iv_dice_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rolledP2=r.nextInt(6)+1;
                setDiceImage(rolledP2, iv_dice_p2);

                if(rolledP1!=0){
                    tv_player1.setText("PLAYER 1 ROLL!");
                    tv_player2.setText("PLAYER 2 ROLL!");
                    if(rolledP1>rolledP2){
                        livesP2--;
                        setDiceImage(livesP2, iv_lives_p2);
                    }if (rolledP2>rolledP1){
                        livesP1--;
                        setDiceImage(livesP1, iv_lives_p1);
                    }

                    rolledP1=0;
                    rolledP2=0;
                    checkEndGame();
                    iv_dice_p1.setEnabled(true);
                    iv_dice_p2.setEnabled(true);
                }
                else{
                    tv_player2.setText("PLAYER 2 ROLLED");
                    iv_dice_p2.setEnabled(false);
                }
            }
        });
    }
    private void setDiceImage(int dice, ImageView image){
          switch (dice){
              case 1:
                  image.setImageResource(R.drawable.dice1);
                  image.startAnimation(animation);
                  break;
              case 2:
                  image.setImageResource(R.drawable.dice2);
                  image.startAnimation(animation);
                  break;
              case 3:
                  image.setImageResource(R.drawable.dice3);
                  image.startAnimation(animation);
                  break;
              case 4:
                  image.setImageResource(R.drawable.dice4);
                  image.startAnimation(animation);
                  break;
              case 5:
                  image.setImageResource(R.drawable.dice5);
                  image.startAnimation(animation);
                  break;
              case 6:
                  image.setImageResource(R.drawable.dice6);
                  image.startAnimation(animation);
                  break;

                  default:
                      image.setImageResource(R.drawable.dice0);
                      image.startAnimation(animation);
          }
    }
    private void checkEndGame() {
        if(livesP1==0||livesP2==0){
            String text = "";
            if(livesP1!=0){
                text="Game Over! Winner Player 1!";
            }
            if(livesP2!=0){
                text="Game Over! Winner Player 2!";
            }
            AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(this);
            alertDialogBuilder.setCancelable(false);
            alertDialogBuilder.setMessage(text);
            alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            AlertDialog alertDialog= alertDialogBuilder.create();
            alertDialog.show();
        }
    }
}
