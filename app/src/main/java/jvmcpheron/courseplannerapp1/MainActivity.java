package jvmcpheron.courseplannerapp1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements MVP_CoursePlanner_Contract.View{
    private MVP_CoursePlanner_Contract.Presenter thePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        thePresenter = new GraphPresenter(this);
    }
    public void onClickSearch( View v )
    {
        EditText et = (EditText) findViewById(R.id.courseCodeInput);

        String fName = et.getText().toString();
        Log.d("Debug", "Edit Text: " + fName);

        thePresenter.searchGraph(fName);

    }

    /**
     * override for MVP_Contract view updatePreReStatus method
     * @param preReq LL of preReqs
     * sends data from LL to text on app screen
     */
    @Override
    public void updatePreReqStatus(LinkedList<Course> preReq) {
        TextView preReqList = (TextView) findViewById(R.id.preReqList);
        String listString = "";
        for(Course c : preReq){

            /** make the string of text */
            listString= listString.concat(c.getCourseCode());
            listString =  listString.concat("  -  ");
            listString= listString.concat(c.getCourseName());
            listString =  listString.concat("\n");
        }

        /** send it over to the UI*/
        preReqList.setText(listString);
    }
}