package com.example.luisgfoliveira1.lojinhob;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.luisgfoliveira1.lojinhob.models.Produto;

public class Produtos extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.telaProdutos);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.perfil: {
                        Intent per = new Intent(Produtos.this, Perfil.class);
                        startActivity(per);
                        break;
                    }
                    case R.id.categorias:{
                        Intent cat = new Intent(Produtos.this,Categoria.class);
                        startActivity(cat);
                        break;
                    }

                    case R.id.regulamento: {
                        Intent reg = new Intent(Produtos.this, Regulamento.class);
                        startActivity(reg);
                        break;
                    }
                    case R.id.privacidade: {
                        Intent pol = new Intent(Produtos.this, PoliticaPrivacidade.class);
                        startActivity(pol);
                        break;
                    }
                    case R.id.carrinho: {
                        Intent car = new Intent(Produtos.this, MainActivity.class);
                        startActivity(car);
                        break;

                    }
                    case R.id.cadastro:{
                        Intent cad = new Intent(Produtos.this, CadastroCliente.class);
                        startActivity(cad);
                    }

                    break;
                    default:
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        btnVoltar = findViewById(R.id.btnVoltarProdutos);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Produtos.this, Categoria.class);
                startActivity(intent);
                finish();
            }
        });



    }
}
