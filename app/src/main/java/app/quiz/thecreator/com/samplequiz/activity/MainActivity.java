package app.quiz.thecreator.com.samplequiz.activity;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import app.quiz.thecreator.com.samplequiz.R;
import app.quiz.thecreator.com.samplequiz.fragment.SelfCareFragment;
import app.quiz.thecreator.com.samplequiz.helper.DataHelper;

public class MainActivity extends AppCompatActivity {
    private DataHelper dh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root_layout, SelfCareFragment.newInstance(), "SelfCare")
                    .commit();
        }
        dh = new DataHelper(getApplicationContext());
        dh.insertUserMaster("1", "100");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        exportDB();
        //finish();ytguy
    }

    public void exportDB() {
        String SAMPLE_DB_NAME = dh.getDatabaseName();
        File sd = Environment.getExternalStorageDirectory();
        File data = Environment.getDataDirectory();
        FileChannel source = null;
        FileChannel destination = null;
        String currentDBPath = "/data/" + getApplicationContext().getPackageName() + "/databases/" + SAMPLE_DB_NAME;
        String backupDBPath = SAMPLE_DB_NAME;
        File currentDB = new File(data, currentDBPath);
        File backupDB = new File(sd, backupDBPath);
        try {
            source = new FileInputStream(currentDB).getChannel();
            destination = new FileOutputStream(backupDB).getChannel();
            destination.transferFrom(source, 0, source.size());
            source.close();
            destination.close();
        } catch (IOException e) {
            Toast.makeText(getApplication(), e.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
