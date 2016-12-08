package com.playground.dilip.androidplayground;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OthersActivity extends AppCompatActivity implements View.OnClickListener {

    Handler handler;

    ProgressBar progressBar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_others);

        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        Button buttonCall = (Button) findViewById(R.id.button_call_number);
        buttonCall.setOnClickListener(this);

        Button buttonViewLink = (Button) findViewById(R.id.button_view_link);
        buttonViewLink.setOnClickListener(this);

        Button buttonShare = (Button) findViewById(R.id.button_share);
        buttonShare.setOnClickListener(this);

        Button buttonThread = (Button) findViewById(R.id.button_thread);
        buttonThread.setOnClickListener(this);

        Button buttonHandler = (Button) findViewById(R.id.button_handler);
        buttonHandler.setOnClickListener(this);

        Button buttonAsync = (Button) findViewById(R.id.button_async);
        buttonAsync.setOnClickListener(this);

        Button buttonFragments = (Button) findViewById(R.id.button_fragments);
        buttonFragments.setOnClickListener(this);

        //Handlers are used to communicate from the background thread to the UI thread
        //Handlers are used to send messages between threads
        //An activity will have only one handler

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                progressBar.setProgress(msg.arg1);
            }
        };
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_call_number:
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+123"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
                break;
            case R.id.button_view_link:
                Intent viewIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(viewIntent);
                break;
            case R.id.button_share:
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Something to share");
                startActivity(Intent.createChooser(shareIntent, "Share using"));
                break;
            case R.id.button_thread:
                Thread downloadThread = new Thread(new DownloadThread("http://www.chalkhillcommunications.com/museum/Images/PAL.png"));
                downloadThread.start();
                break;
            case R.id.button_handler:
                Thread hThread = new Thread(new HandlerThread());
                hThread.start();
                break;
            case R.id.button_async:
                AsyncTaskTest test = new AsyncTaskTest();
                String url = "https://cdn1.iconfinder.com/data/icons/ios-7-style-metro-ui-icons/512/MetroUI_OS_Android.png";
                test.execute(url);
                break;
            case R.id.button_fragments:
                break;
        }
    }

    public void downloadImageUsingThread(String url) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        File file = null;
        try {
            URL downloadURL = new URL(url);
            connection = (HttpURLConnection) downloadURL.openConnection();
            inputStream = connection.getInputStream();

            file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/test.png");
            outputStream = new FileOutputStream(file);

            //Reading from the input stream
            int read = -1;
            byte[] buffer = new byte[1024];
            while ((read = inputStream.read(buffer)) != -1) {
                Log.d("Reading input", "" + read);
                outputStream.write(buffer, 0, read);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Others Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    class DownloadThread implements Runnable {

        String url = "";

        public DownloadThread(String u) {
            url = u;
        }

        @Override
        public void run() {
            downloadImageUsingThread(url);
        }
    }


    class HandlerThread implements Runnable {

        @Override
        public void run() {
            Message message = Message.obtain();
            message.arg1 = 50;
            handler.sendMessage(message);
        }
    }

    public class AsyncTaskTest extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (OthersActivity.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                OthersActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            } else {
                OthersActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        }

        @Override
        protected Void doInBackground(String... params) {
            HttpURLConnection connection = null;
            InputStream inputStream = null;
            FileOutputStream outputStream = null;
            File file = null;
            try {
                URL downloadURL = new URL(params[0]);
                connection = (HttpURLConnection) downloadURL.openConnection();
                inputStream = connection.getInputStream();

                file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/android.png");
                outputStream = new FileOutputStream(file);

                //Reading from the input stream
                int read = -1;
                byte[] buffer = new byte[1024];
                while ((read = inputStream.read(buffer)) != -1) {
                    Log.d("Reading input", "" + read);
                    outputStream.write(buffer, 0, read);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }

                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Toast.makeText(getApplicationContext(), "Downloaded image successfully", Toast.LENGTH_SHORT).show();
            OthersActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        }
    }
}
