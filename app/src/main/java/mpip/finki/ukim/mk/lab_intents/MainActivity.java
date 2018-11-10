package mpip.finki.ukim.mk.lab_intents;

import android.content.Intent;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }
    public void initUI(){
        txtView=(TextView)findViewById(R.id.txtView);
    }
    public void ImplicitCall(View view){
        Intent intent=new Intent();
        intent.setAction("mk.ukim.finki.mpip.IMPLICIT_ACTION");
        startActivity(intent);
    }
    public void shareMessage(View view){
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT," MPiP Send Title ");
        intent.putExtra(Intent.EXTRA_TITLE," MPiP Send Title ");
        intent.putExtra(Intent.EXTRA_TEXT," Content send from MainActivity");
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent,"Share your message"));
    }
    public void ExplicitCall(View view){
        Intent intent = new Intent(this, ExplicitActivity.class);
        startActivityForResult(intent, 100);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){

            if(requestCode==100){

                Bundle b=data.getExtras();
                String s=b.getString(Intent.EXTRA_TEXT);
                txtView.setText(s);
            }
            if(requestCode==101){
//                Intent intent=new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//
//                intent.putExtras(data);
//
//                startActivity(intent);
//                intent.setType("image/*");

                data.setAction(Intent.ACTION_VIEW);

                startActivity(Intent.createChooser(data,"Select an app to view the selected image"));
            }
        }

    }





    public void selectImage(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 101);
    }
}
