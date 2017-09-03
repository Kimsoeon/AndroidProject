package soeonkim.kr.hs.emirim.androidproject;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by HP on 2017-08-31.
 */

public class DBAdapter extends CursorAdapter{
    public DBAdapter(Context context, Cursor c){
        super(context,c);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.list_item, parent, false);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final TextView title = (TextView)view.findViewById(R.id.title);
        final TextView created_date = (TextView)view.findViewById(R.id.created_date);
        final TextView contents = (TextView)view.findViewById(R.id.contents);

       // String id = cursor.getString((cursor.getColumnIndex("_id")));

        if(cursor.getString((cursor.getColumnIndex("title"))).equals("")){
            title.setText("제목없음");
        }
        else{
            title.setText(cursor.getString((cursor.getColumnIndex("title"))));

        }
        if(cursor.getString((cursor.getColumnIndex("contents"))).equals("")){
            contents.setText("내용없음");
        }
        else{
            contents.setText(cursor.getString((cursor.getColumnIndex("contents"))));
        }
        created_date.setText(cursor.getString((cursor.getColumnIndex("create_date"))));


    }

}
