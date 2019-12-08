package com.example.cardapio;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentCardapio extends ListFragment {

    static interface ProdutosListener{
        void itemClicked(long id);
    };

    private ProdutosListener listener;

    public FragmentCardapio() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] nomes = new String[Produto.produtos.length];
        for(int i=0; i<nomes.length; i++){
            nomes[i] = Produto.produtos[i].getNome();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                inflater.getContext(), android.R.layout.simple_list_item_1, nomes
        );
        setListAdapter(adapter);
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        this.listener = (ProdutosListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int posicao, long id){
        if(listener != null){
            listener.itemClicked(id);
        }
    }
}
