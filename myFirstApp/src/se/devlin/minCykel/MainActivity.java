package se.devlin.minCykel;

import se.devlin.myfirstapp.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener{
	public static final String PREFS_NAME = "MyPrefs";
	private boolean isUppe=false;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
		boolean sharedUppe = settings.getBoolean("upFlag", false);
	    setUppe(sharedUppe); 
		ImageView iv = (ImageView) findViewById(R.id.where);
		iv.setOnClickListener(this);
	}
	
	private void setUppe(boolean sharedUppe) {
		ImageView iv = (ImageView) findViewById(R.id.where);
		iv.setImageResource(sharedUppe ? R.drawable.uppe_stor : R.drawable.nere_stor);
		
	}

	@Override
	public void onClick(View v){
		ImageView iv = (ImageView) findViewById(R.id.where);
		
		isUppe=!isUppe;
		iv.setImageResource(isUppe ? R.drawable.uppe_stor : R.drawable.nere_stor);
	}
	

    @Override
    protected void onStop(){
       super.onStop();

      // We need an Editor object to make preference changes.
      // All objects are from android.context.Context
      SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
      SharedPreferences.Editor editor = settings.edit();
      editor.putBoolean("upFlag", isUppe);

      // Commit the edits!
      editor.commit();
    }
}
