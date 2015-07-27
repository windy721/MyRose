package rose.jim.com.myrose;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import rose.jim.com.myrose.activity.LongMessageActivity;
import rose.jim.com.myrose.fragment.AboutFragment;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolBar;
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        initView();
    }

    private void findViews() {
        mToolBar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.jim_main_drawer_layout);
    }

    private void initView() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.jim_main_navigation_view);
        if (null != navigationView) {
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    switch (menuItem.getItemId()) {

                        case R.id.navigation_item_book:
//                            switchToBook();
                            switchToLongMessage();
                            startActivity(new Intent(MainActivity.this, LongMessageActivity.class));
                            break;
//                        case R.id.navigation_item_example:
//                            switchToExample();
//                            break;
//                        case R.id.navigation_item_blog:
//                            switchToBlog();
//                            break;
                        case R.id.navigation_item_about:
                            switchToAbout();
                            break;
                    }

                    menuItem.setChecked(true);
                    mDrawerLayout.closeDrawers();
                    return false;
                }
            });
        }
        switchToAbout();
    }

    private void switchToLongMessage() {
//        getSupportFragmentManager().beginTransaction().replace(R.id.jim_main_frame_content, new LongMessageFragment()).commit();
        mToolBar.setTitle("Long message");
    }

    private void switchToAbout() {
        getSupportFragmentManager().beginTransaction().replace(R.id.jim_main_frame_content, new AboutFragment()).commit();
        mToolBar.setTitle(R.string.navigation_book);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
