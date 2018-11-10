package mpip.finki.ukim.mk.lab_intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class ExplicitActivity extends AppCompatActivity {

    EditText txtEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explicit_activity);
        initUI();
    }
    private void initUI(){
        txtEdit=(EditText)findViewById(R.id.txtEdit);
    }
    public void voRed(View view){
        Intent returnIntent = new Intent();
        returnIntent.putExtra(Intent.EXTRA_TEXT,txtEdit.getText().toString());
        setResult(RESULT_OK, returnIntent);
        finish();
    }
    public void otkaziReturn(View view){
        Intent returnIntent = new Intent();
        setResult(RESULT_CANCELED, returnIntent);
        finish();
    }
}
