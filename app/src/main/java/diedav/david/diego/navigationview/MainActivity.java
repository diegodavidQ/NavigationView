package diedav.david.diego.navigationview;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Toolbar mtoolbar;
    private DrawerLayout mdrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbarMenu(); //show Toolbar
        setupNavigationDrawerMenu();
    }


    private void setupToolbarMenu() {
        mtoolbar=(Toolbar)findViewById(R.id.toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mtoolbar.setTitle("Navigation View");
        }
    }

    private void setupNavigationDrawerMenu() {
        NavigationView navigationView = (NavigationView)findViewById(R.id.navigationView);
        mdrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                mdrawerLayout,
                mtoolbar,
                R.string.drawer_open,
                R.string.drawer_close);

        mdrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    //events click on Item
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        String itemName = (String)menuItem.getTitle();

        Toast.makeText(MainActivity.this,itemName + "Clicked",Toast.LENGTH_SHORT).show();

        closeDrawer();

        switch (menuItem.getItemId()){

            case R.id.item_facebook:
                //Put your Item specific Code here
                break;

            case R.id.item_bag:
                //Put your Item specific Code here
                break;

        }

        return true;
    }

    //Close Drawer
    private void closeDrawer() {
        mdrawerLayout.closeDrawer(GravityCompat.START);
    }

    //Open Drawer
    private void showDrawer(){
        mdrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (mdrawerLayout.isDrawerOpen(GravityCompat.START))
            closeDrawer();
        else
            super.onBackPressed();
    }
}
