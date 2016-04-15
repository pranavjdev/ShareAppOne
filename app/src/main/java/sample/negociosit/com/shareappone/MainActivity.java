package sample.negociosit.com.shareappone;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText editText = null;
    private TextView statusText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        statusText = (TextView) findViewById(R.id.statusView);
        Button saveFile = (Button) findViewById(R.id.button);

        saveFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               saveFile();
            }
        });
    }

    private void saveFile(){
        File file = null;
        FileOutputStream fileOutputStream = null;

        file = getFilesDir();
        try {
            fileOutputStream = openFileOutput("app1.txt", MODE_PRIVATE);
            fileOutputStream.write(editText.getText().toString().getBytes());
            statusText.setTextColor(Color.GREEN);
            statusText.setText("File write "+file.getAbsolutePath());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            statusText.setTextColor(Color.RED);
            statusText.setText("Error " + e.getMessage());
        } catch (IOException e) {
            statusText.setTextColor(Color.RED);
            statusText.setText("Error " + e.getMessage());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
