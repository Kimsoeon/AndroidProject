package soeonkim.kr.hs.emirim.androidproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import static android.R.id.list;

public class MainActivity extends AppCompatActivity {
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;
    ListView listview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myHelper = new MyDBHelper(this);
        sqlDB = myHelper.getWritableDatabase();
        listview = (ListView)findViewById(R.id.listview);
       // selectTable();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,NewWrite.class);
                startActivity(intent);
            }
        });


    }

    public void selectTable(){
        sqlDB = myHelper.getReadableDatabase();
        String sql = "select * from noteTable";
        Cursor cursor = sqlDB.rawQuery(sql, null);
        String title = "제목" + "\r\n";
        String contents = "내용" + "\r\n";
        String date = "날짜" + "\r\n";
        while(cursor.moveToNext()){ //커서는 행이동
            title += cursor.getString(0)+ "\r\n"; //행의 열 index 0(names)
            contents += cursor.getString(1)+ "\r\n"; //행의 열 index 1(counts)
            date += cursor.getString(2)+ "\r\n";
        }
//        title_1.setText(title + "\r\n");
//        date_1.setText(date + "\r\n");
//        contents_1.setText(contents + "\r\n");

        cursor.close();
        sqlDB.close();
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
