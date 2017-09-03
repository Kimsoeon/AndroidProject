package soeonkim.kr.hs.emirim.androidproject;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HP on 2017-08-27.
 */

public class NewWrite extends AppCompatActivity {
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    Button save_but;
    EditText edit_text_title,edit_text_contents;
    String sql;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_write);

        myHelper = new MyDBHelper(this);

        save_but = (Button) findViewById(R.id.save_but);
        edit_text_title = (EditText) findViewById(R.id.edit_text_title);
        edit_text_contents = (EditText) findViewById(R.id.edit_text_contents);

        final String _id = getIntent().getStringExtra("_id");
        String title = getIntent().getStringExtra("title");
        edit_text_title.setText(title);
        String contents = getIntent().getStringExtra("contents");
        edit_text_contents.setText(contents);

        save_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                if(getIntent().getStringExtra("mode").equals("modify")){
                    sql = "update noteTable set title = " + edit_text_title.getText() + ", contents = " +  edit_text_contents.getText() +  "where _id = " + _id;
                }
               else{
                    sql = "insert into noteTable values(NULL, '" + edit_text_title.getText() + "', '" + edit_text_contents.getText() + "', datetime('now','localtime'))";
               }

                sqlDB.execSQL(sql);
                sqlDB.close();
                Toast.makeText(NewWrite.this, "저장됨", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}
