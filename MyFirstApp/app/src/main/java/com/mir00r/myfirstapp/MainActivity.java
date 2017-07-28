package com.mir00r.myfirstapp;

//import android.app.ActionBar;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AnalogClock;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DigitalClock;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    //private EditText pass_word;
    //private Button sbm_button;

    //private CheckBox check_dog, check_cat, check_cow;
    //private Button select_button;

//    private static Button sbm_ratings;
//    private static TextView tv;
//    private static RatingBar rb;

    //private static Button sbm_alert;
    //private static Button sbm_sec_activity;

//    private static Button sbm_swap_clock;
//    private static DigitalClock digitalClock;
//    private static AnalogClock analogClock;

    //private static ImageView imgView;
    //private static Button imgButton;

    //private int currentImgIndex;
    //int[] images = {R.drawable.ic_dashboard_black_24dp, R.drawable.ic_home_black_24dp, R.drawable.ic_notifications_black_24dp};

    //private static ListView listView;
    //private static String[] Names = new String[] {"Tom", "Mark", "Jhon", "Jack", "Patrick", "Peter"};

    //private static SeekBar seek_bar;
    //private static TextView text_view;

//    private static Button button_sbm_url;
//    private static EditText url_text;
//    private static WebView browser;
//
//    private static AutoCompleteTextView acTextView;
//    String[] countries = {
//            "Afghanistan",
//            "Albania",
//            "Algeria",
//            "Andorra",
//            "Angola",
//            "Anguilla",
//            "Antigua & Barbuda",
//            "Argentina",
//            "Armenia",
//            "Australia",
//            "Austria",
//            "Azerbaijan",
//    };


    //private static Button button_shw_td;
    //private static TimePicker time_picker;

//    private static Button button_shw_tpd;
//    static final int DIALOG_ID = 0;
//    int hour_x;
//    int minute_x;


    //private static Button button_shw_notify;

//    DatabaseHelper databaseHelper;
//    EditText editName, editSurName, editMarks, editId;
//
//    Button btnViewData;
//    Button btnAddData;
//    Button btnUpdateData;
//    Button btnDeleteData;

//    BoundServiceCheck boundServiceCheck;
//    boolean isBound = false;

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //addListnerOnButton();
        //addListenerToCheckbox();
        //listnerRatingBar();
        //onDialogButtonClickListener();
        //OnClickButtonSecondAcitivityListener();
        //OnCickButtonSwapClock();
        //ImageButtonClick();

        //listViewDisplay();
        //seekBarProgressDisplay();
        //openUrlInWebView();
        //AutoCompleteTextViewSample();
        //ShowTimeListener();
        //showTimePickerDialog();
        //showNotification();

//        databaseHelper = new DatabaseHelper(this);
//
//        viewInit();
//        addData();
//        viewAllData();
//        updateData();
//        deleteData();

        //addActionBarImage();
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        //intentInitializer();
        viewInitializer();
    }


    public void viewInitializer () {
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
    }

    public void read (View view ) {
        try {
            FileInputStream fileInputStream = openFileInput("myText.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();

            String lines;
            while ( ( lines = bufferedReader.readLine() ) != null ) {
                stringBuffer.append(lines+"\n");
            }
            textView.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void write (View view) {
        String myTextMessage = editText.getText().toString();


        try {
            FileOutputStream fileOutputStream = openFileOutput("myText.txt", MODE_PRIVATE);
            fileOutputStream.write(myTextMessage.getBytes());
            fileOutputStream.close();

            Toast.makeText(getApplicationContext(), "Text Saved", Toast.LENGTH_LONG).show();
            editText.setText("");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


//    public void intentInitializer () {
//        Intent intent = new Intent(this, BoundServiceCheck.class);
//        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
//    }
//
//    public void getRandomNumber (View view) {
//        TextView textView = (TextView) findViewById(R.id.textView_random_number);
//        textView.setText( Integer.toString ( boundServiceCheck.getRandomNum() ) );
//    }
//
//    private ServiceConnection serviceConnection = new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder service) {
//            BoundServiceCheck.LocalBinder binder = (BoundServiceCheck.LocalBinder) service;
//            boundServiceCheck = binder.getService();
//            isBound = true;
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//            isBound = false;
//        }
//    };


//    public void startService (View view ) {
//        //Intent intent = new Intent(this, ServiceCheck.class);
//        Intent intent = new Intent(this, MyService.class);
//        startService(intent);
//    }
//
//    public void stopService (View view ) {
//        //Intent intent = new Intent(this, ServiceCheck.class);
//        Intent intent = new Intent(this, MyService.class);
//        stopService(intent);
//    }



//    public void addActionBarImage () {
//        ActionBar actionBar = getSupportActionBar();
//
//        actionBar.setLogo(R.drawable.ic_dashboard_black_24dp);
//        actionBar.setDisplayUseLogoEnabled(true);
//        actionBar.setDisplayShowHomeEnabled(true);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        inflater.inflate(R.menu.main_activity_menu, menu);
        //return true;
        return super.onCreateOptionsMenu(menu);
    }
//

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.info_id:
                Toast.makeText(getApplicationContext(), "Info Icon is Selected", Toast.LENGTH_LONG).show();
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Settings Icon is Selected", Toast.LENGTH_LONG).show();
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

//    public void openA ( View view) {
//        startActivity(new Intent(this, SecondActivity.class));
//    }





//    public void viewInit () {
//        editName = (EditText) findViewById(R.id.fullName);
//        editSurName = (EditText) findViewById(R.id.surName);
//        editMarks = (EditText) findViewById(R.id.marks);
//        editId = (EditText) findViewById(R.id.id);
//
//        btnAddData = (Button) findViewById(R.id.button_add_data);
//        btnViewData = (Button) findViewById(R.id.button_view_data);
//        btnUpdateData = (Button) findViewById(R.id.button_update_data);
//        btnDeleteData = (Button) findViewById(R.id.button_delete_data);
//    }
//
//    public void deleteData () {
//        btnDeleteData.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        Integer deletedRows = databaseHelper.deleteData(editId.getText().toString());
//
//                        if (deletedRows > 0) {
//                            Toast.makeText(MainActivity.this, "Data Deleted", Toast.LENGTH_LONG).show();
//                        }else {
//                            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }
//        );
//    }
//
//    public void updateData() {
//        btnUpdateData.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        boolean isUpdate = databaseHelper.updateData(editId.getText().toString(),
//                                editName.getText().toString(),
//                                editSurName.getText().toString(),
//                                editMarks.getText().toString());
//
//                        if (isUpdate == true) {
//                            Toast.makeText(MainActivity.this, "Data Updated", Toast.LENGTH_LONG).show();
//                        }else {
//                            Toast.makeText(MainActivity.this, "Data not Deleted", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }
//        );
//    }
//
//    public void addData () {
//        btnAddData.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        boolean isInserted = databaseHelper.insertData(editName.getText().toString(),
//                                editSurName.getText().toString(),
//                                editMarks.getText().toString());
//
//                        if (isInserted == true) {
//                            Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
//                        }else {
//                            Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();
//                        }
//                    }
//                }
//        );
//    }
//
//    public void viewAllData() {
//        btnViewData.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        Cursor res = databaseHelper.getAllData();
//
//                        if (res.getCount() == 0 ) {
//                            showMessage("Error", "Nothing found");
//                            return;
//                        }
//
//                        StringBuffer buffer = new StringBuffer();
//                        while (res.moveToNext()) {
//                            buffer.append("Id :" +res.getString(0)+ "\n");
//                            buffer.append("Name :"+ res.getString(1)+"\n");
//                            buffer.append("Surname :"+ res.getString(2)+"\n");
//                            buffer.append("Marks :"+ res.getString(3)+"\n\n");
//                        }
//
//                        // Show all data
//                        showMessage("Data",buffer.toString());
//                    }
//                }
//        );
//    }
//
//    public void showMessage(String title, String message) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//
//        builder.setCancelable(true);
//        builder.setTitle(title);
//        builder.setMessage(message);
//        builder.show();
//    }


//    public void showNotification() {
//        button_shw_notify = (Button) findViewById(R.id.button_show_notify_me);
//
//        button_shw_notify.setOnClickListener(
//                new View.OnClickListener() {
//                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent();
//                        PendingIntent pInent = PendingIntent.getActivities(MainActivity.this, 0, new Intent[]{intent}, 0);
//                        Notification noti = new Notification.Builder(MainActivity.this)
//                                .setTicker("Ticker Title")
//                                .setContentTitle("Demo Content Title")
//                                .setContentText("This is sample content tex to show you some messages !!! ")
//                                .setSmallIcon(R.drawable.ic_home_black_24dp)
//                                .addAction(R.drawable.ic_home_black_24dp, "Action 1", pInent)
//                                .addAction(R.drawable.ic_dashboard_black_24dp, "Action 2", pInent)
//                                .setContentIntent(pInent).getNotification();
//
//                        noti.flags = Notification.FLAG_AUTO_CANCEL;
//                        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//                        nm.notify(0, noti);
//                    }
//                }
//        );
//    }


//    public void showTimePickerDialog () {
//        button_shw_tpd = (Button) findViewById(R.id.button_show_time_picker);
//        button_shw_tpd.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        showDialog(DIALOG_ID);
//                    }
//                }
//        );
//    }
//
//    @Override
//    protected Dialog onCreateDialog( int id ) {
//        if ( id == DIALOG_ID )
//            return new TimePickerDialog(MainActivity.this, kTimePickerListener, hour_x, minute_x, false);
//        return null;
//    }
//
//    protected TimePickerDialog.OnTimeSetListener kTimePickerListener =
//            new TimePickerDialog.OnTimeSetListener() {
//
//                @Override
//                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                    hour_x = hourOfDay;
//                    minute_x = minute;
//
//                    Toast.makeText(getBaseContext(), hour_x + " : " +minute_x, Toast.LENGTH_SHORT).show();
//                }
//            };

//    public void ShowTimeListener() {
//        button_shw_td = (Button) findViewById(R.id.button_show_time);
//        time_picker = (TimePicker) findViewById(R.id.timePicker);
//
//        button_shw_td.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(getBaseContext(), time_picker.getCurrentHour() + " : " +time_picker.getCurrentMinute(), Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
//    }

//    public void AutoCompleteTextViewSample () {
//        acTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, countries);
//
//        acTextView.setThreshold(1);
//        acTextView.setAdapter(adapter);
//    }


//    public void openUrlInWebView () {
//        button_sbm_url = (Button) findViewById(R.id.button_url);
//        url_text = (EditText) findViewById(R.id.editText);
//        browser = (WebView) findViewById(R.id.webView);
//
//        button_sbm_url.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        String url = url_text.getText().toString();
//
//                        browser.getSettings().setLoadsImagesAutomatically(true);
//                        browser.getSettings().setJavaScriptEnabled(true);
//                        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//                        browser.loadUrl(url);
//                    }
//                }
//        );
//    }


//    public void seekBarProgressDisplay () {
//        seek_bar = (SeekBar) findViewById(R.id.seekBar);
//        text_view = (TextView) findViewById(R.id.textView);
//
//        text_view.setText("Covered : " +seek_bar.getProgress() + " / " +seek_bar.getMax() );
//
//        seek_bar.setOnSeekBarChangeListener(
//                new SeekBar.OnSeekBarChangeListener() {
//
//                    int progressValue;
//
//                    @Override
//                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                        progressValue = progress;
//                        text_view.setText("Covered : " + progress + " / " +seek_bar.getMax() );
//                        Toast.makeText(MainActivity.this, "SeekBar in Progress", Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onStartTrackingTouch(SeekBar seekBar) {
//                        Toast.makeText(MainActivity.this, "SeekBar in Start Tracking", Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onStopTrackingTouch(SeekBar seekBar) {
//                        text_view.setText("Covered : " + progressValue + " / " +seek_bar.getMax() );
//                        Toast.makeText(MainActivity.this, "SeekBar in Stop Tracking", Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
//    }


//    public void listViewDisplay () {
//        listView = (ListView) findViewById(R.id.list_view);
//        ArrayAdapter < String > adapter = new ArrayAdapter<String>(this, R.layout.name_list, Names);
//
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(
//                new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        String value = (String)listView.getItemAtPosition(position);
//                        Toast.makeText(MainActivity.this, "Position : " +position + " Value : " +value, Toast.LENGTH_LONG).show();
//                    }
//                }
//        );
//    }


//    public void ImageButtonClick () {
//        imgView = (ImageView) findViewById(R.id.imageView);
//        imgButton = (Button) findViewById(R.id.button_img);
//
//        imgButton.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        currentImgIndex++;
//                        currentImgIndex = currentImgIndex % images.length;
//                        imgView.setImageResource( images[ currentImgIndex ] );
//                    }
//                }
//        );
//    }

//    public void OnCickButtonSwapClock () {
//        sbm_swap_clock = (Button) findViewById(R.id.button_swap_clock);
//        digitalClock = (DigitalClock) findViewById(R.id.digitalClock);
//        analogClock = (AnalogClock) findViewById(R.id.analogClock);
//
//        sbm_swap_clock.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        if ( digitalClock.getVisibility() == DigitalClock.GONE ) {
//                            digitalClock.setVisibility(DigitalClock.VISIBLE);
//                            analogClock.setVisibility(AnalogClock.GONE);
//                        }
//                        else {
//                            digitalClock.setVisibility(DigitalClock.GONE);
//                            analogClock.setVisibility(AnalogClock.VISIBLE);
//                        }
//                    }
//                }
//        );
//    }


//    public void OnClickButtonSecondAcitivityListener() {
//        sbm_sec_activity = (Button) findViewById(R.id.button_second_activity);
//
//        sbm_sec_activity.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent("com.mir00r.myfirstapp.SecondActivity");
//                        startActivity(intent);
//                    }
//                }
//        );
//    }


//    public void onDialogButtonClickListener() {
//        sbm_alert = (Button) findViewById(R.id.button_alart);
//
//        sbm_alert.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        AlertDialog.Builder aBuilder = new AlertDialog.Builder(MainActivity.this);
//                        aBuilder.setMessage("Do you want to close this App !!!!")
//                                .setCancelable(false)
//                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        finish();
//                                    }
//                                })
//                                .setNegativeButton("No", new DialogInterface.OnClickListener() {
//
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        dialog.cancel();
//                                    }
//                                });
//                        AlertDialog alert = aBuilder.create();
//                        alert.setTitle("App close Alert !!!! ");
//                        alert.show();
//                    }
//                }
//        );
//    }


//    public void listnerRatingBar() {
//        rb = (RatingBar) findViewById(R.id.ratingBar);
//        tv = (TextView) findViewById(R.id.textView);
//
//        rb.setOnRatingBarChangeListener(
//                new RatingBar.OnRatingBarChangeListener() {
//
//                    @Override
//                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                        tv.setText(String.valueOf(rating));
//                    }
//                }
//        );
//
//    }


//    public void onButtonClick(View v) {
//        EditText e1 = (EditText) findViewById(R.id.editText);
//        EditText e2 = (EditText) findViewById(R.id.editText2);
//
//        TextView tv = (TextView) findViewById(R.id.textView);
//
//        int num1 = Integer.parseInt(e1.getText().toString());
//        int num2 = Integer.parseInt(e2.getText().toString());
//
//        int sum = num1 + num2;
//
//        tv.setText(Integer.toString(sum));
//    }


//    public void addListnerOnButton() {
//        pass_word = (EditText)findViewById(R.id.editText3);
//        sbm_button = (Button)findViewById(R.id.button2);
//
//        sbm_button.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        Toast.makeText(
//                                MainActivity.this, pass_word.getText(), Toast.LENGTH_SHORT
//                        ).show();
//                    }
//                }
//        );
//    }

//    public void addListenerToCheckbox() {
//        check_dog = (CheckBox)findViewById(R.id.checkBox_dog);
//
//        check_dog.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//                        if ( ( ( CheckBox ) v).isChecked() ) {
//                            Toast.makeText(
//                                    MainActivity.this, "Dog Is Selected", Toast.LENGTH_LONG
//                            ).show();
//                        }else {
//                            Toast.makeText(
//                                    MainActivity.this, "Dog Is Unselected", Toast.LENGTH_LONG
//                            ).show();
//                        }
//                    }
//                }
//        );
//    }
//
//    public void addListnerOnButton() {
//        check_dog = (CheckBox)findViewById(R.id.checkBox_dog);
//        check_cat = (CheckBox)findViewById(R.id.checkBox_cat);
//        check_cow = (CheckBox)findViewById(R.id.checkBox_cow);
//
//        select_button = (Button)findViewById(R.id.button_select);
//
//        select_button.setOnClickListener(
//                new View.OnClickListener() {
//
//                    @Override
//                    public void onClick(View v) {
//
//                        StringBuffer res = new StringBuffer();
//
//                        res.append("Dog : ").append(check_dog.isChecked());
//                        res.append("\nCat : ").append(check_cat.isChecked());
//                        res.append("\nCow : ").append(check_cow.isChecked());
//
//                        Toast.makeText(
//                                MainActivity.this, res.toString(), Toast.LENGTH_LONG
//                        ).show();
//                    }
//                }
//        );
//    }



}
