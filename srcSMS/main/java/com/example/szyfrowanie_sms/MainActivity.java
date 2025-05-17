package com.example.szyfrowanie_sms;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 100;
    Button przyciskWyslij;
    EditText trescSMS, numerTelefonu;
    Switch chceszZaszyfrowacSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        przyciskWyslij = findViewById(R.id.buttonSMS);
        trescSMS = findViewById(R.id.editTextTrescSMS);
        numerTelefonu = findViewById(R.id.editTextPhone);
        chceszZaszyfrowacSwitch = findViewById(R.id.switchSzyfr);

        /* ---------------------------------------- */

        przyciskWyslij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sms = trescSMS.getText().toString();
                String telefonN = numerTelefonu.getText().toString();

                if (chceszZaszyfrowacSwitch.isChecked()) {
                    sms = SzyfrujPrzestawieniowo.zaszyfrujTekst(sms);
                }

                // czy uprawnienia zostały przyznane?
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, PackageManager.PERMISSION_GRANTED);
                }
                else{
                    // wyślij wiadomość SMS
                    // jeśli urządzenie, na którym jest emulowany projekt ma kartę SIM (można tylko do samego siebie)
                    wyslijSMS(telefonN, sms);
                }
            }
        });
    }

    /* ---------------------------------------- */

    private void wyslijSMS(String numer, String wiadomosc) {
        try{
            // WAŻNE - KLUCZOWA KLASA do SMS-ów
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(numer, null,wiadomosc,null,null);
            Toast.makeText(getApplicationContext(), "Wysłano wiadomość SMS.",Toast.LENGTH_LONG).show();
        }
        catch(Exception error){
            Toast.makeText(getApplicationContext(), "Wysyłanie wiadomości nie powiodło się.", Toast.LENGTH_LONG).show();
        }
    }

    /* ---------------------------------------- */

    // reakcja na uprawnienia (wyświetlanie komunikatu)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode > 0 && grantResults[0] == MY_PERMISSIONS_REQUEST_SEND_SMS){
            Toast.makeText(this, "Uprawnienia zostały przyznane. Możesz wysyłać SMS.", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Błąd, uprawnienia nie zostały przyznane.", Toast.LENGTH_LONG).show();
        }
    }
}
