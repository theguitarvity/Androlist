package br.com.bytegod.android.androlist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.*;
import android.content.*;
public class ActMain extends AppCompatActivity implements View.OnClickListener{

    //atributos
    private EditText txtLembrete;
    private Spinner spnTipo;
    private Button btnAdd;
    private Button btnDel;
    private ListView lstDados;
    private ArrayAdapter<String>adpTipo;
    private ArrayAdapter<String>adpDados;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //criando referencias do layout a classe atual

        txtLembrete = (EditText)findViewById(R.id.txtLembrete);
        spnTipo = (Spinner)findViewById(R.id.spnTipo);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnDel = (Button)findViewById(R.id.btnDel);
        lstDados=(ListView)findViewById(R.id.lstDados);
        btnAdd.setOnClickListener(this);
        btnDel.setOnClickListener(this);

        //tratando as listas


        adpTipo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnTipo.setAdapter(adpTipo);

        adpTipo.add("Faculdade");
        adpTipo.add("Amigos");
        adpTipo.add("ByteGod");
        adpTipo.add("Social");
        adpDados = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        lstDados.setAdapter(adpDados);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act_main, menu);
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

    //criando ação para os botoes de adicionar e excluir

    @Override
    public void onClick(View view) {
        if(view==btnAdd){
            String item = txtLembrete.getText().toString();
            item+=" - "+spnTipo.getSelectedItem();
            adpDados.add(item);
        }
        else{
            if(view==btnDel){
                String item = adpDados.getItem(0);
                adpDados.remove(item);
            }
        }
    }
}
