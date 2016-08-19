package br.com.daniel.oliveira.projetocadastroitembd.util;

import android.graphics.Color;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import br.com.daniel.oliveira.projetocadastroitembd.constant.Constant;

public abstract class Util {

    private Util() {

    }

    public static Boolean isNotNull(EditText ed) {
        Boolean flagRetorno = Boolean.FALSE;

        if (ed.getText().toString().trim() != null && ed.getText().toString().trim().length() > 0) {
            return Boolean.TRUE;
        } else {
            ed.setError(Constant.REQUIRED);
        }

        return flagRetorno;
    }

    public static Boolean isNotNull(Spinner combo) {
        Boolean flagRetorno = Boolean.FALSE;

        if (combo.getSelectedItem() != null && combo.getSelectedItem().toString() != null && !combo.getSelectedItem().toString().equalsIgnoreCase(Constant.SELECIONE)) {
            return Boolean.TRUE;
        } else {
            TextView errorText = (TextView) combo.getSelectedView();
            errorText.setError(Constant.REQUIRED);
            errorText.setTextColor(Color.RED);
        }

        return flagRetorno;
    }

}
