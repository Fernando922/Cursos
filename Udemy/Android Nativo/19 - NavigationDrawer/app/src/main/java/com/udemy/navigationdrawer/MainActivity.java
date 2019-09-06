package com.udemy.navigationdrawer;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.udemy.navigationdrawer.fragment.CameraFragment;
import com.udemy.navigationdrawer.fragment.EmpresaFragment;
import com.udemy.navigationdrawer.fragment.GalleryFragment;
import com.udemy.navigationdrawer.fragment.SendFragment;
import com.udemy.navigationdrawer.fragment.ShareFragment;
import com.udemy.navigationdrawer.fragment.SlideShowFragment;
import com.udemy.navigationdrawer.fragment.ToolsFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameContainer);  //nem precisou


        Toolbar toolbar = findViewById(R.id.toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        setSupportActionBar(toolbar);  /// para funcionar em versoes anteriores do android


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(  //É O BOTAO QUE ABRE O MENU
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        //OS TEXTOS PASSADOS COMO PARAMETROS SAO PARA LEITORES DE ACESSIBILIDADE ( MUDE PARA PORTUGUES )
        drawer.addDrawerListener(toggle);  //adiciona o evento de toogle
        toggle.syncState();  //sincroniza ??? TODO perguntar depois



        NavigationView navigationView = findViewById(R.id.nav_view);  //esse é o menu mesmo
        navigationView.setNavigationItemSelectedListener(this);  //evento de selecionar item

        //pagina carregada por padrao ao abrir o app
        EmpresaFragment empresaFragment = new EmpresaFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer, empresaFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {  //ve se ta aberto e fecha, senao fecha o app
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            CameraFragment cameraFragment = new CameraFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, cameraFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_empresa) {
            EmpresaFragment empresaFragment = new EmpresaFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, empresaFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_gallery) {
            GalleryFragment galleryFragment = new GalleryFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, galleryFragment);
            fragmentTransaction.commit();


        } else if (id == R.id.nav_slideshow) {
            SlideShowFragment slideshowFragment = new SlideShowFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, slideshowFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_tools) {
            ToolsFragment toolsFragment = new ToolsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, toolsFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_share) {
            ShareFragment shareFragment = new ShareFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, shareFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_send) {
            SendFragment sendFragment = new SendFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, sendFragment);
            fragmentTransaction.commit();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);   //fecha o drawer apos a seleção
        return true;   //tipo boolean (metodo) entao tenho que retornar true
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {  //objeto selecionado pelo usuario
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
