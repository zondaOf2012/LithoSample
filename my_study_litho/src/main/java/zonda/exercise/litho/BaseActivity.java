package zonda.exercise.litho;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.webkit.WebView;

import static zonda.exercise.litho.data.PostListConstants.LOG_TAG;

public class BaseActivity extends AppCompatActivity{

    private Toolbar mToolbar;
    private View mContentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setupStatusBar();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "BaseActivity onStart is run");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG, "BaseActivity onStop is run");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        ViewGroup contentParent = (ViewGroup) findViewById(android.R.id.content);
        View layoutView = LayoutInflater.from(this).inflate(layoutResID, contentParent, false);
        setContentView(layoutView);
    }

    @Override
    public void setContentView(View view) {
        setContentView(view, view.getLayoutParams());
    }

    @Override
    public void setContentView(View view, @NonNull ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        mContentView = view;
        setupToolbar();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    /**
     * 是否支持基类工具栏
     *
     * @return 返回工具栏类型
     */
    protected boolean hasSupportBaseToolbar() {
        return true;
    }

    private void setupToolbar() {

        if (!hasSupportBaseToolbar()) {
            return;
        }

        final int toolbarHeight = getResources().getDimensionPixelSize(R.dimen.toolbar_height);
        LayoutParams layoutParams = mContentView.getLayoutParams();
        if (mContentView instanceof WebView
                && layoutParams instanceof MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin += toolbarHeight;
            mContentView.setLayoutParams(marginLayoutParams);
        } else {
            final int leftPadding = mContentView.getPaddingLeft();
            final int topPadding = mContentView.getPaddingLeft() + toolbarHeight;
            final int rightPadding = mContentView.getPaddingLeft();
            final int bottomPadding = mContentView.getPaddingLeft();
            mContentView.setPadding(leftPadding, topPadding, rightPadding, bottomPadding);
        }

        ContentFrameLayout contentParent = (ContentFrameLayout) findViewById(android.R.id.content);
        LayoutInflater.from(this).inflate(R.layout.layout_base_toolbar, contentParent, true);
        mToolbar = (Toolbar) findViewById(R.id.base_toolbar);
        setSupportActionBar(mToolbar);

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "mToolbar NavigationOnClickListener onClick is run!");
                finish();
            }
        });
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.i(LOG_TAG, "mToolbar OnMenuItemClickListener onMenuItemClick getItemId: "
                        + item.getItemId());
                return true;
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            onConfigActionBar(actionBar);
        }
    }

    protected void onConfigActionBar(@NonNull ActionBar actionBar) {
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setupStatusBar() {
        //final View contentView = findViewById(android.R.id.content);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            final View contentView = getWindow().getDecorView();
            contentView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

}
