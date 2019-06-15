package sg.edu.rp.c346.avengerswar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity {

    RelativeLayout shopP1, shopP2, shopP3, shopP4, shopP5, shopP6;
    RelativeLayout unlock2, unlock3, unlock4, unlock5, unlock6;
ImageView imageView;
    ImageButton goHome;
    TextView tv_coins;

    boolean shop2, shop3, shop4, shop5, shop6;

    int coins, action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        shopP1 = (RelativeLayout) findViewById(R.id.shopP1);
        shopP2 = (RelativeLayout) findViewById(R.id.shopP2);
        shopP3 = (RelativeLayout) findViewById(R.id.shopP3);
        shopP4 = (RelativeLayout) findViewById(R.id.shopP4);
        shopP5 = (RelativeLayout) findViewById(R.id.shopP5);
        shopP6 = (RelativeLayout) findViewById(R.id.shopP6);

        unlock2 = (RelativeLayout) findViewById(R.id.unlock2);
        unlock3 = (RelativeLayout) findViewById(R.id.unlock3);
        unlock4 = (RelativeLayout) findViewById(R.id.unlock4);
        unlock5 = (RelativeLayout) findViewById(R.id.unlock5);
        unlock6 = (RelativeLayout) findViewById(R.id.unlock6);

        goHome = (ImageButton) findViewById(R.id.home);
        tv_coins = (TextView) findViewById(R.id.tv_coins);

        final SharedPreferences settings = getSharedPreferences("PREFS", Context.MODE_PRIVATE);
        coins = settings.getInt("COINS", 0);
        action = settings.getInt("ACTION", 1);
        shop2 = settings.getBoolean("SHOP2", false);
        shop3 = settings.getBoolean("SHOP3", false);
        shop4 = settings.getBoolean("SHOP4", false);
        shop5 = settings.getBoolean("SHOP5", false);
        shop6 = settings.getBoolean("SHOP6", false);

        tv_coins.setText(""+coins);

        if (shop2 == true){
            unlock2.setVisibility(View.GONE);
        }
        if (shop3 == true){
            unlock3.setVisibility(View.GONE);
        }
        if (shop4 == true){
            unlock4.setVisibility(View.GONE);
        }
        if (shop5 == true){
            unlock5.setVisibility(View.GONE);
        }
        if (shop6 == true){
            unlock6.setVisibility(View.GONE);
        }


        shopP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action = 1;
Toast myToast1 = myToast1("Captain America Selected!", R.drawable.cappy, Toast.LENGTH_LONG);
myToast1.show();
                SharedPreferences.Editor editor = settings.edit();
                editor.putInt("ACTION", action);
                editor.commit();
                startActivity(new Intent(ShopActivity.this, StartActivity.class));
            }
        });

        shopP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shop2 == true){
                    action = 2;

                    Toast myToast1 = myToast1("Black Widow Selected!", R.drawable.widow, Toast.LENGTH_LONG);
                    myToast1.show();

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else if (coins >= 30){

                    Toast myToast1 = myToast1("New Character Unlocked!", Toast.LENGTH_LONG);
                    myToast1.show();
                    shop2 = true;
                    action = 2;
                    coins = coins - 30;

                    tv_coins.setText(""+coins);
                    unlock2.setVisibility(View.GONE);

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.putInt("COINS", coins);
                    editor.putBoolean("SHOP2", shop2);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else {
                    Toast myToast = myToast("Insufficient Diamonds!", Toast.LENGTH_LONG);
                    myToast.show();
                }
            }
        });

        shopP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shop3 == true){
                    action = 3;

                    Toast myToast1 = myToast1("Hulk Selected!", R.drawable.hulk, Toast.LENGTH_LONG);
                    myToast1.show();

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else if (coins >= 50){

                    Toast myToast1 = myToast1("New Character Unlocked!", Toast.LENGTH_LONG);
                    myToast1.show();
                    shop3 = true;
                    action = 3;
                    coins = coins - 50;

                    tv_coins.setText(""+coins);
                    unlock3.setVisibility(View.GONE);

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.putInt("COINS", coins);
                    editor.putBoolean("SHOP3", shop3);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else {
                    Toast myToast = myToast("Insufficient Diamonds!", Toast.LENGTH_LONG);
                    myToast.show();
                }
            }
        });

        shopP4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shop4 == true){
                    action = 4;

                    Toast myToast1 = myToast1("Scarlet Witch Selected!", R.drawable.scarlet, Toast.LENGTH_LONG);
                    myToast1.show();

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else if (coins >= 80){

                    Toast myToast1 = myToast1("New Character Unlocked!", Toast.LENGTH_LONG);
                    myToast1.show();
                    shop4 = true;
                    action = 4;
                    coins = coins - 80;

                    tv_coins.setText(""+coins);
                    unlock4.setVisibility(View.GONE);

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.putInt("COINS", coins);
                    editor.putBoolean("SHOP4", shop4);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else {
                    Toast myToast = myToast("Insufficient Diamonds!", Toast.LENGTH_LONG);
                    myToast.show();
                }
            }
        });

        shopP5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shop5 == true){
                    action = 5;

                    Toast myToast1 = myToast1("Thor Selected!", R.drawable.thor, Toast.LENGTH_LONG);
                    myToast1.show();

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else if (coins >= 150){

                    Toast myToast1 = myToast1("New Character Unlocked!", Toast.LENGTH_LONG);
                    myToast1.show();
                    shop4 = true;
                    action = 5;
                    coins = coins - 150;

                    tv_coins.setText(""+coins);
                    unlock4.setVisibility(View.GONE);

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.putInt("COINS", coins);
                    editor.putBoolean("SHOP5", shop5);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else {
                    Toast myToast = myToast("Insufficient Diamonds!", Toast.LENGTH_LONG);
                    myToast.show();
                }
            }
        });

        shopP6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (shop6 == true){
                    action = 6;

                    Toast myToast1 = myToast1("Iron Man Selected!", R.drawable.iron, Toast.LENGTH_LONG);
                    myToast1.show();

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else if (coins >= 200){

                    Toast myToast1 = myToast1("New Character Unlocked!", Toast.LENGTH_LONG);
                    myToast1.show();

                    shop4 = true;
                    action = 6;
                    coins = coins - 200;

                    tv_coins.setText(""+coins);
                    unlock4.setVisibility(View.GONE);

                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("ACTION", action);
                    editor.putInt("COINS", coins);
                    editor.putBoolean("SHOP6", shop6);
                    editor.commit();
                    startActivity(new Intent(ShopActivity.this, StartActivity.class));

                } else {
                    Toast myToast = myToast("Insufficient Diamonds!", Toast.LENGTH_LONG);
                    myToast.show();
                }
            }
        });

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ShopActivity.this, StartActivity.class));
                finish();
            }
        });
    }

public Toast myToast(String text, int duration){
        View view = getLayoutInflater().inflate(R.layout.custom_toast, null);
        TextView textView = view.findViewById(R.id.text);
        imageView = view.findViewById(R.id.image);

        imageView.setImageResource(R.drawable.hulk);
        textView.setText(text);

        Toast toast = new Toast(this);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 30);
        toast.setDuration(duration);
        toast.setView(view);

        return toast;

}

    public Toast myToast1(String text, int duration){
        View view = getLayoutInflater().inflate(R.layout.custom_toast1, null);
        TextView textView = view.findViewById(R.id.text1);
        imageView = view.findViewById(R.id.image1);

        imageView.setImageResource(R.drawable.cappy);
        textView.setText(text);

        Toast toast = new Toast(this);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 30);
        toast.setDuration(duration);
        toast.setView(view);

        return toast;

    }

    public Toast myToast1(String text, int drawable, int duration){
        Toast toast = myToast1(text,duration);
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageResource(drawable);

        return toast;
    }


}
