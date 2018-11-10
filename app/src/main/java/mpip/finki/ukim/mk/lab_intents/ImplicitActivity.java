package mpip.finki.ukim.mk.lab_intents;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class ImplicitActivity extends AppCompatActivity {
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_activity);
        initUI();
        getLaunchersAndMainActivities();
    }
    public void initUI(){
        txtView=(TextView)findViewById(R.id.txtView);
    }
    public void getLaunchersAndMainActivities(){
        StringBuilder s=new StringBuilder();

        PackageManager pm = getPackageManager();
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        List<ResolveInfo> lst = pm.queryIntentActivities(i, 0);
         for (ResolveInfo resolveInfo : lst) {
            s.append("New Launcher Found: " + resolveInfo.activityInfo.packageName+"\n");
        }
        txtView.setText(s.toString());
    }
}
