package com.example.android.system.runtimepermissions.calendar;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.android.system.runtimepermissions.R;

import java.util.GregorianCalendar;

/**
 * Created by xizhouli on 10/6/16.
 */
public class CalendarFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    public void createDefaultEvent(){
        Intent calIntent = new Intent(Intent.ACTION_INSERT);
        calIntent.setType("vnd.android.cursor.item/event");
        calIntent.putExtra(CalendarContract.Events.TITLE, "Google I/O kenote Press Meeting");
        calIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "San Antonia CA");
        calIntent.putExtra(CalendarContract.Events.DESCRIPTION, "Pixel is up!!");
        GregorianCalendar calDate = new GregorianCalendar(2016, 10, 4,10,20);
        GregorianCalendar calDate_end = new GregorianCalendar(2016, 10, 4,12,20);

        calIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                calDate.getTimeInMillis());
        calIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,
                calDate_end.getTimeInMillis());
        startActivity(calIntent);
    }

    /**
     * Creates a new instance of a ContactsFragment.
     */
    public static CalendarFragment newInstance() {
        return new CalendarFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calendar, container, false);

        // Register a listener to add a dummy contact when a button is clicked.
        Button button = (Button) rootView.findViewById(R.id.event_add);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDefaultEvent();
            }
        });

        return rootView;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
