package ca.ualberta.cs.chenrui_travelexpensetracker;

import java.text.SimpleDateFormat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ShowExpenseListActivity extends ShowClaimListActivity {
	private Claim OpenedClaim;
	private int OpenedClaimPosition;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_expense_list);
		
		// put data into local
		this.OpenedClaim = ShowClaimListActivity.OpenedClaim;
		this.OpenedClaimPosition = ShowClaimListActivity.OpenedClaimPosition;
		// set title
		setTitle(OpenedClaim.toString()+" ("+OpenedClaim.getStatus()+")");
		
		// create temple view
		TextView showExpenseStartDateTtextView = (TextView) findViewById(R.id.showExpenseStartDateTtextView);
		TextView showExpenseEndDateTextView = (TextView) findViewById(R.id.showExpenseEndDateTextView);
		TextView showExpenseDecriptionTextView = (TextView) findViewById(R.id.showExpenseDecriptionTextView);
		TextView showExpensTotalTextView = (TextView) findViewById(R.id.showExpensTotalTextView);
		
		Button showExpenseAddExpenseButton = (Button) findViewById(R.id.showExpenseAddExpenseButton);
		Button showExpenseEditClaimButton = (Button) findViewById(R.id.showExpenseEditClaimButton);
		Button showExpenseEmailButton = (Button) findViewById(R.id.showExpenseEmailButton);
		
		ListView showExpenseListView = (ListView) findViewById(R.id.showExpenseListView);
		
		// put data into test view
		showExpenseStartDateTtextView.setText((new SimpleDateFormat ("yyyy.MM.dd")).format(OpenedClaim.getStartDate()));
		showExpenseEndDateTextView.setText((new SimpleDateFormat ("yyyy.MM.dd")).format(OpenedClaim.getEndDate()));
		showExpenseDecriptionTextView.setText(OpenedClaim.getDescription());
		showExpensTotalTextView.setText(OpenedClaim.TotalCurrencyListToString());
		
		// set up button listener
		showExpenseAddExpenseButton.setOnClickListener(new ButtonListener());
		showExpenseEditClaimButton.setOnClickListener(new ButtonListener());
		showExpenseEmailButton.setOnClickListener(new ButtonListener());
	}
	
	// reaction of Button
	class ButtonListener implements View.OnClickListener {
		@Override
		public void onClick(View view) {
			if (view.getId() == R.id.showExpenseAddExpenseButton){
				Intent intent = new Intent(ShowExpenseListActivity.this,
						AddExpenseActivity.class);
				startActivity(intent);
			} else if (view.getId() == R.id.showExpenseEditClaimButton) {
				Intent intent = new Intent(ShowExpenseListActivity.this,
						AddClaimActivity.class);
				startActivity(intent);
			} else if (view.getId() == R.id.showExpenseEmailButton){
				//Email things
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_expense_list, menu);
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.showExpenseToTextView) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
