package ce0942a.SNaPP.gogetme;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GoGetMeMain extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_go_get_me_home);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.go_get_me_main, menu);
		return true;
	}

}
