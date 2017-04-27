package zonda.exercise.litho;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by zhuqiuzhu on 17/4/25.
 */

public class MainActivity extends BaseActivity {

    private final String[][] DATA_TEST_LIST = {
            {"SimpleDemoActivity",
                    ".simplest.SimpleDemoActivity"},
//            {"SimpleRecyclerActivity",
//                    ".SimpleRecyclerActivity"},
//            {"PostListActivity",
//                    ".PostListActivity"}
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListFragment sampleListFragment = null;
        if (savedInstanceState == null) {
            sampleListFragment = new ListFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(android.R.id.content, sampleListFragment)
                    .commitNow();
        }


    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        ListFragment sampleListFragment = (ListFragment) getSupportFragmentManager()
                .findFragmentById(android.R.id.content);

        if (sampleListFragment != null) {

            ArrayList<TestData> listData = createListData();
            ArrayAdapter<TestData> arrayAdapter =
                    new ArrayAdapter<>(this,
                            android.R.layout.simple_list_item_1,
                            android.R.id.text1,
                            listData);
            sampleListFragment.setListAdapter(arrayAdapter);
            sampleListFragment.setListShown(true);
            sampleListFragment.getListView().setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TestData itemData = (TestData) parent.getItemAtPosition(position);
                    Intent targetIntent = itemData.mTargetIntent;
                    if (targetIntent != null) {
                        startActivity(targetIntent);
                    }
                }
            });
        } else {

            Log.i("TAG", "sampleListFragment is null!");
        }
    }

    private
    @NonNull
    ArrayList<TestData> createListData() {
        ArrayList<TestData> listData = new ArrayList<>();
        TestData itemData;
        Intent itemIntent = null;
        for (String[] dataArray : DATA_TEST_LIST) {
            try {
                itemIntent = new Intent();

                Log.i("TAG", "createListData getPackageName: " + getPackageName());

                Class targetClass = Class.forName(getPackageName() + dataArray[1]);
                itemIntent.setClass(this, targetClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            itemData = new TestData(dataArray[0], itemIntent);
            listData.add(itemData);
        }
        return listData;
    }

    private static final class TestData {

        final String mTitleText;

        final Intent mTargetIntent;

        TestData(String mTitleText, Intent mTargetIntent) {
            this.mTitleText = mTitleText;
            this.mTargetIntent = mTargetIntent;
        }

        @Override
        public String toString() {
            return "\n" + mTitleText + "\n";
        }
    }
}
