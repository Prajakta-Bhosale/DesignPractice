package com.example.designpractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Development development_frag;
    Design design_frag;
    Marking marking_frag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        development_frag=new Development();
        design_frag=new Design();
        marking_frag=new Marking();
        BottomNavigationView nav=findViewById(R.id.nav);
        final FrameLayout content=findViewById(R.id.content_layout);
        change_fragment(development_frag);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.development: {
                        change_fragment(development_frag);
                        Animation a = AnimationUtils.loadAnimation((MainActivity.this), R.anim.custom_animation);
                        content.startAnimation(a);
                        return true;
                    }
                    case R.id.design: {
                        change_fragment(design_frag);
                        Animation b = AnimationUtils.loadAnimation((MainActivity.this), R.anim.custom_animation);
                        content.startAnimation(b);
                        return true;
                    }
                    case R.id.marking: {
                        change_fragment(marking_frag);
                        Animation c = AnimationUtils.loadAnimation((MainActivity.this), R.anim.custom_animation);
                        content.startAnimation(c);
                        return true;
                    }
                    default:return false;
                }
            }
        });


    }
    private void change_fragment(Fragment Fragment){
        FragmentTransaction fragmentTransaction3=getSupportFragmentManager().beginTransaction();
        fragmentTransaction3.replace(R.id.content_layout,Fragment);
        fragmentTransaction3.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id)
        {
            case R.id.development:
                Toast.makeText(this, "Development", Toast.LENGTH_SHORT).show();
                break;

            case R.id.design:
                Toast.makeText(this, "Design", Toast.LENGTH_SHORT).show();
                break;
            case R.id.marking:
                Toast.makeText(this, "Marking", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
