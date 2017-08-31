package soeonkim.kr.hs.emirim.androidproject;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by HP on 2017-08-27.
 */

public class NewWrite extends AppCompatActivity {
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    Button save_but;
    EditText edit_text_title,edit_text_contents;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_write);

        myHelper = new MyDBHelper(this);

        save_but = (Button) findViewById(R.id.save_but);
        edit_text_title = (EditText) findViewById(R.id.edit_text_title);
        edit_text_contents = (EditText) findViewById(R.id.edit_text_contents);

        save_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                String sql = "insert into noteTable values(NULL, '" + edit_text_title.getText() + "', '" + edit_text_contents.getText() + "', datetime('now','localtime'))";
                sqlDB.execSQL(sql);
                sqlDB.close();
                Toast.makeText(NewWrite.this, "저장됨", Toast.LENGTH_LONG).show();

                finish();
            }
        });

    }
}
