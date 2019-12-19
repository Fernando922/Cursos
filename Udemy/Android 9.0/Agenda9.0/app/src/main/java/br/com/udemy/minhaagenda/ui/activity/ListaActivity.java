package br.com.udemy.minhaagenda.ui.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.udemy.minhaagenda.R;
import br.com.udemy.minhaagenda.data.dao.ContatoDao;
import br.com.udemy.minhaagenda.data.model.Contato;
import br.com.udemy.minhaagenda.ui.adapter.ListaAdapter;

public class ListaActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PERMISSOES =685;

    ListView listaContatosView;
    ArrayList<Contato> contatos;
    private String[] permissoes = new String[]{
            Manifest.permission.SEND_SMS
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        validaPermissoes(permissoes);

        listaContatosView = findViewById(R.id.lista_lista_contatos);
        listaContatosView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Contato contato = contatos.get(position);

                Intent intent = new Intent(ListaActivity.this, CadastraActivity.class);
                intent.putExtra(CadastraActivity.PARAMETRO_CONTATO, contato);  //uso de constantes evita erro de digitação
                startActivity(intent);
            }
        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaActivity.this, CadastraActivity.class);
                startActivity(intent);
            }
        });

        registerForContextMenu(listaContatosView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        criaAdapter();
    }

    private void criaAdapter() {
        //adapter é uma classe que faz intermedio entre o que ta no banco e suas views, serve para popular sua lista

        listaContatosView.setAdapter(new ListaAdapter(this, getContatos()));
    }

    private ArrayList<Contato> getContatos() {
        contatos = new ArrayList();

        ContatoDao contatoDao = new ContatoDao(this);
        contatos = contatoDao.buscaContatos();
        contatoDao.close();
        return contatos;
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        final Contato contato = (Contato) listaContatosView.getItemAtPosition(info.position);

        MenuItem sms = menu.add("Envia SMS");
        sms.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                LayoutInflater inflater = LayoutInflater.from(ListaActivity.this);
                View view = inflater.inflate(R.layout.dialog_envia_sms, null);

                TextView viewTelefone = view.findViewById(R.id.dialog_sms_telefone);
                final EditText viewMensagem = view.findViewById(R.id.dialog_sms_texto);

                String[] split = contato.getNome().split(" ");  //cada posição do array é um nome e sobrenome

                String tel = "Para: " + split[0] + " " + contato.getTelefone();
                viewTelefone.setText(tel);

                AlertDialog.Builder builder = new AlertDialog.Builder(ListaActivity.this);
                builder.setTitle(getString(R.string.app_name));
                builder.setView(view);

                builder.setPositiveButton("Enviar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String mensagem = viewMensagem.getText().toString();
                        if(mensagem.isEmpty()){
                            return;
                        }
                        enviarSMS(contato.getTelefone(), mensagem);


                    }
                });

                builder.setNegativeButton("Cancelar", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                return false;
            }
        });

        MenuItem del = menu.add("Apagar");
        del.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                ContatoDao dao = new ContatoDao(ListaActivity.this);
                dao.remove(contato);
                criaAdapter();
                dao.close();
                return false;
            }
        });

    }

    private void enviarSMS(String telefone, String mensagem) {
        try{
            String telefoneTratado = telefone.replace("(", "");
            telefoneTratado = telefone.replace(")", "");
            telefoneTratado = telefone.replace(" ", "");
            telefoneTratado = telefone.replace("-", "");

            telefoneTratado =  "+55" + telefoneTratado;

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(telefoneTratado, null, mensagem, null, null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    private void validaPermissoes(String[] permissoes){
        if(Build.VERSION.SDK_INT >=23){
            List<String> listaPermissoes = new ArrayList<>();


            for(String permissao: permissoes){
                Boolean validaPermissao = ContextCompat.checkSelfPermission(this, permissao) == PackageManager.PERMISSION_GRANTED;
                if(!validaPermissao){
                    listaPermissoes.add(permissao);
                }
            }
            if (!listaPermissoes.isEmpty()){
                String[] novasPermissoes = new String[listaPermissoes.size()];
                listaPermissoes.toArray(novasPermissoes);
                ActivityCompat.requestPermissions(ListaActivity.this, novasPermissoes, REQUEST_CODE_PERMISSOES);
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for(int resultado: grantResults){
            if(resultado == PackageManager.PERMISSION_DENIED){
                alertaValidaPermissao();
            }
        }
    }

    private void alertaValidaPermissao() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Permissões Negadas");
        builder.setMessage("Para utilizar esse App, é necessário aceitar todas as permissões");

        builder.setPositiveButton("Tentar Novamente", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int wich) {
                validaPermissoes(permissoes);
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int wich) {
                finish();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
