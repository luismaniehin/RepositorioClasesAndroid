package com.example.nh.lab010;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Button btnStart1, btnReset;
    private TextView txcTexto, txcTexto2, txcTexto3;
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    private boolean plXWin = false;    // X
    private boolean plOWin = false;    // O
    private String pcFlag = "";

    private String paValores[] = {"", "", "", "", "", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mxInicializarControles();

        btnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txcTexto.setText("Bienvenido START 1");
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plXWin = false;
                plOWin = false;
                pcFlag = "";

                btn1.setText("1");
                btn2.setText("2");
                btn3.setText("3");
                btn4.setText("4");
                btn5.setText("5");
                btn6.setText("6");
                btn7.setText("7");
                btn8.setText("8");
                btn9.setText("9");

                mxHabilitarBotones(true);
            }
        });
    }

    private void mxInicializarControles()
    {
        btnStart1 = (Button) findViewById(R.id.btnStart1);
        btnReset = (Button) findViewById(R.id.btnReset);

        txcTexto = (TextView) findViewById(R.id.txcTexto);
        txcTexto2 = (TextView) findViewById(R.id.txcTexto2);
        txcTexto3 = (TextView) findViewById(R.id.txcTexto3);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
    }

    public void mxIniciarStart2(View v)
    {
        txcTexto.setText("Bienvenido START 2");
    }

    public void mxRealizarJugada(View v)
    {
        Button btnBoton = (Button) v;
        String lcValor = "";

        if(!btnBoton.getText().equals("O") && !btnBoton.getText().equals("X")) {
            lcValor = btnBoton.getText().toString();

            if (pcFlag.equals("") || pcFlag.equals("O")) {
                btnBoton.setText("X");
                pcFlag = "X";
            } else {
                btnBoton.setText("O");
                pcFlag = "O";
            }

            paValores[Integer.parseInt(lcValor) - 1] = pcFlag;
        }

        if(this.mxVerificarGanador()){
            //this.mxHabilitarBotones(false);
        }
    }

    private boolean mxVerificarGanador(){
        boolean llRespuesta = false;

        for(int i=0; i<9;i+=3) {
            if (paValores[i].equals(paValores[i+1]) && paValores[i+1].equals(paValores[i+2])) {
                txcTexto3.setText("Ganaste : " + paValores[i]);
                llRespuesta = true;
            }
        }

        for(int i=0; i<3;i++) {
            if (paValores[i].equals(paValores[i+3]) && paValores[i+3].equals(paValores[i+6])) {
                txcTexto3.setText("Ganaste : " + paValores[i]);
                llRespuesta = true;
            }
        }

        if(paValores[0].equals(paValores[4]) && paValores[4].equals(paValores[8])){
            txcTexto3.setText("Ganaste : " + paValores[0]);
            llRespuesta = true;
        }

        if(paValores[2].equals(paValores[4]) && paValores[4].equals(paValores[6])){
            txcTexto3.setText("Ganaste : " + paValores[2]);
            llRespuesta = true;
        }

        return llRespuesta;
    }

    private void mxHabilitarBotones(boolean llValor){
        btn1.setEnabled(llValor);
        btn2.setEnabled(llValor);
        btn3.setEnabled(llValor);
        btn4.setEnabled(llValor);
        btn5.setEnabled(llValor);
        btn6.setEnabled(llValor);
        btn7.setEnabled(llValor);
        btn8.setEnabled(llValor);
        btn9.setEnabled(llValor);
    }
}
