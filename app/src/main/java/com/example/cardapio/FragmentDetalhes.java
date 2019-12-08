package com.example.cardapio;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */


public class FragmentDetalhes extends Fragment {

    private long produtoId;

    private EditText editTextQuantidade;
    private TextView textViewPreco;
    private TextView textViewTotal;
    private Button buttonCalcular;
    private Button buttonConfirmar;
    private ImageView imagemProduto;


    public FragmentDetalhes() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_detalhes, container, false);

    }


    public long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(long produtoId) {
        this.produtoId = produtoId;
    }

    public void onStart() {

        super.onStart();
        View view = getView();
        if(view != null){

            TextView titulo = view.findViewById(R.id.textViewTitulo);
            ImageView imagemProduto = view.findViewById(R.id.imageView);
            Produto produto = Produto.produtos[(int) produtoId];
            long i = produtoId;
            imagemProduto.setImageResource(produto.imagens[(int) i]);
            titulo.setText(produto.getNome());
            TextView descricao = view.findViewById(R.id.textViewDescricao);
            descricao.setText(produto.getDescricao());
            TextView preco = view.findViewById(R.id.textViewPreco);
            preco.setText(String.valueOf(produto.getPreco()));
        }

        buttonCalcular = view.findViewById(R.id.buttonCalcular);
        buttonConfirmar = view.findViewById(R.id.buttonConfirmar);
        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pedir();
            }
        });

        buttonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Pedido solicitado!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void Pedir(){

        editTextQuantidade = getView().findViewById(R.id.editTextQuantidade);
        buttonCalcular = getView().findViewById(R.id.buttonCalcular);
        textViewPreco = getView().findViewById(R.id.textViewPreco);
        textViewTotal = getView().findViewById(R.id.textViewTotal2);
        int quantidade = Integer.parseInt(String.valueOf(editTextQuantidade.getText()));
        Produto produto = Produto.produtos[(int) produtoId];
        double preco = produto.getPreco();

                textViewTotal.setText(String.valueOf(quantidade * preco));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putLong("produtoId",produtoId);
    }
}
