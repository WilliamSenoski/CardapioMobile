package com.example.cardapio;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FragmentCardapio.ProdutosListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void itemClicked(long id){
        View fragmentContainer = findViewById(R.id.fragment_container);
        if(fragmentContainer != null) {
            FragmentDetalhes detalhes = new FragmentDetalhes();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            detalhes.setProdutoId(id);
            ft.replace(R.id.fragment_container, detalhes);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        } else {
            Intent intent = new Intent(this,DetalhesActivity.class);
            intent.putExtra(DetalhesActivity.EXTRA_PRODUTO_ID, (int) id);
            startActivity(intent);

        }

    }
}
