package com.trnd.trnd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mTextMessage;

    private DataService dataService;
    private ArrayList<Data> arrayList;
    public static MyAppAdapter myAppAdapter;
    public static ViewHolder viewHolder;
    private AdapterLinearLayout view;
    private Integer displayItem = 0;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataService = new DataService();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        view = (AdapterLinearLayout) findViewById(R.id.frame);

        arrayList = new ArrayList<>();
        arrayList.add(dataService.getNextItem(displayItem));
        myAppAdapter = new MyAppAdapter(arrayList, MainActivity.this);
        view.setAdapter(myAppAdapter);
        final MainActivity activity = this;
        view.setOnTouchListener(new SwipeFlingListener(MainActivity.this) {
            public void onSwipeTop() {
                activity.displayNextItem();
            }
            public void onSwipeRight() {
                activity.displayPreviousItem();
            }

            public void onSwipeLeft() {
                activity.displayNextItem();
            }
            public void onSwipeBottom() {
                activity.displayPreviousItem();
            }
        });
    }

    public void displayNextItem() {
        if(dataService.getDataSize() > displayItem) {
            displayItem++;
            arrayList.clear();
            Data data = dataService.getNextItem(displayItem);
            if(data != null) {
                arrayList.add(data);
                myAppAdapter.notifyDataSetChanged();
            }
        }
    }

    public void displayPreviousItem() {
        if(displayItem > 0) {
            displayItem--;
            arrayList.clear();
            Data data = dataService.getNextItem(displayItem);
            if(data != null) {
                arrayList.add(data);
                myAppAdapter.notifyDataSetChanged();
            }
        }
    }


    public static class ViewHolder {
        public static FrameLayout background;
        public TextView dataText;
        public ImageView cardImage;
    }

    public class MyAppAdapter extends BaseAdapter {
        public List<Data> parkingList;
        public Context context;

        private MyAppAdapter(List<Data> apps, Context context) {
            this.parkingList = apps;
            this.context = context;
        }

        @Override
        public int getCount() {
            return parkingList.size();
        }

        @Override
        public Object getItem(int position) {
            return parkingList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            Data item = (Data) getItem(position);

            if (view == null) {
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.item, parent, false);
                // configure view holder
                viewHolder = new ViewHolder();
                viewHolder.dataText = (TextView) view.findViewById(R.id.bookText);
                viewHolder.background = (FrameLayout) view.findViewById(R.id.background);
                viewHolder.cardImage = (ImageView) view.findViewById(R.id.cardImage);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            try {
                viewHolder.dataText.setText(item.getDescription());
                Glide.with(MainActivity.this).load(item.getImagePath()).into(viewHolder.cardImage);
                //URL url = new URL(item.getImagePath());
                //Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                //viewHolder.cardImage.setImageBitmap(bmp);

            } catch(Exception e) {
                e.printStackTrace();
            }

            return view;
        }
    }
}
