package com.example.quiz_del_poder;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PartageActivity extends AppCompatActivity {

    /**Bouton d'envoie d'un SMS*/
    Button envoyer;
    Button retour;
    /**le numero de telephone entrée*/
    private EditText phone;
    /**le message entrée*/
    private EditText message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.partage_layout);

        phone =(EditText) findViewById(R.id.txtPhone);
        message=(EditText) findViewById(R.id.txtMessage);
        envoyer=(Button) findViewById(R.id.envoyer);
        retour=(Button)findViewById(R.id.retour);

        //envoyer un message quand on cliquer sur envoyer
        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verifie si on a les persmissions
                if(ContextCompat.checkSelfPermission(PartageActivity.this, Manifest.permission.SEND_SMS)==PackageManager.PERMISSION_GRANTED){
                    //quand c'est bon
                    sendMess();
                }else{
                    ActivityCompat.requestPermissions(PartageActivity.this,new String[]{Manifest.permission.SEND_SMS},100);
                }
            }
        });


        //retour sur la page de resultats
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PartageActivity.this.finish();
            }
        });
    }
    /**clique sur bouton envoie : envoie de sms*/
    private void sendMess(){
        //tranforme le num en string
        String num=phone.getText().toString().trim();
        //transforme le message en String
        String mess=message.getText().toString().trim();
        if(!num.equals("")){
            ResultatActivity rs =new ResultatActivity();
            int getMauvaiseRep = ResultatActivity.getMauvaiseRep;
            int getBonneRep = ResultatActivity.getBonneRep;
            String phrase=" Merci d'avoir joué à ElQuizDelPoder";
            String bonneRep="\nVous avez obtenu "+getBonneRep+" bonnes réponses";
            String mauvaisRep=" et "+getMauvaiseRep+" mauvaises réponses.";
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(num,null,mess+phrase+bonneRep+mauvaisRep,null,null);
            Toast.makeText(getApplicationContext(),"SMS Envoyé",Toast.LENGTH_LONG).show();
            //supprime les infos rentrées apres l'envoie du mess
            message.setText("");
            phone.setText("");
        }else{
            Toast.makeText(getApplicationContext(),"Merci d'entrer un numéro et message",Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100&&grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
            sendMess();
        }else{
            Toast.makeText(getApplicationContext(),"Permissions non accordées",Toast.LENGTH_SHORT).show();
        }
    }


}
