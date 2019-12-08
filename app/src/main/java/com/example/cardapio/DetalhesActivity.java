package com.example.cardapio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetalhesActivity extends AppCompatActivity {

    public static final String EXTRA_PRODUTO_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhes_frag);
        FragmentDetalhes fragmentDetalhes = (FragmentDetalhes) getSupportFragmentManager().findFragmentById(R.id.detalhes_frag);
        int produtoId = (int) getIntent().getExtras().get(EXTRA_PRODUTO_ID);
        fragmentDetalhes.setProdutoId(produtoId);
    }
}
