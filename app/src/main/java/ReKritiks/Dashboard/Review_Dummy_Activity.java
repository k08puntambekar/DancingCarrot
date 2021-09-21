package ReKritiks.Dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Review_Dummy_Activity extends AppCompatActivity {
    ImageView review_appIcon;
    TextView review_appName,review_appVersion;
    Bundle review_Bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_dummy);

        review_appIcon = findViewById(R.id.review_appIcon);
        review_appName = findViewById(R.id.review_appName);
        review_appVersion = findViewById(R.id.review_appVersion);
        review_Bundle = getIntent().getExtras();
        if(review_Bundle.containsKey("app_name")){
            ResolveInfo applicationsnfo = review_Bundle.getParcelable("app_name");
            review_appIcon.setImageDrawable(applicationsnfo.activityInfo.loadIcon(getPackageManager()));
            review_appName.setText(applicationsnfo.activityInfo.loadLabel(getPackageManager()));
            review_appName.setText(applicationsnfo.activityInfo.loadLabel(getPackageManager()));

        }

    }
}