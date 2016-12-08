package com.playground.dilip.androidplayground.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.playground.dilip.androidplayground.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Dilip on 12/8/2016.
 */

public class RssFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rss, container, false);

        Button buttonRss = (Button) view.findViewById(R.id.button_rss);
        buttonRss.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_rss:
                break;
        }
    }

    class RssFeed extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... params) {

            String urlString = params[0];
            HttpURLConnection httpURLConnection = null;
            InputStream inputStream = null;
            try {
                URL url = new URL(urlString);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                inputStream = httpURLConnection.getInputStream();
                xmlParser(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }

                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


            return null;
        }

        protected void xmlParser(InputStream inputStream) {

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            try {
                DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
                Document document = documentBuilder.parse(inputStream);
                Element rootElement = document.getDocumentElement();
                NodeList node = rootElement.getElementsByTagName("item");
                NodeList childrenItems = null;
                Node parentNode = null;
                Node childNode = null;

                for (int i = 0; i < node.getLength(); i++) {
                    parentNode = node.item(i);
                    childrenItems = parentNode.getChildNodes();

                    for (int j = 0; j < childrenItems.getLength(); j++) {
                        childNode = childrenItems.item(j);
                        Log.d("Something", " " + childNode.getTextContent());

                        if (childNode.getNodeName().equalsIgnoreCase("name")) {
                            Log.d("name", "" + childNode.getAttributes().item(0).getTextContent());
                        }
                    }
                }
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
