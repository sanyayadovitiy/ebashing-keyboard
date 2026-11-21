package com.pos.ebashingbynecrosia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(48, 48, 48, 48);

        TextView title = new TextView(this);
        title.setText("ebashing by necrosia");
        title.setTextSize(22f);

        Button enableBtn = new Button(this);
        enableBtn.setText("Включить клавиатуру");
        enableBtn.setOnClickListener(v ->
                startActivity(new Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)));

        Button pickBtn = new Button(this);
        pickBtn.setText("Выбрать клавиатуру");
        pickBtn.setOnClickListener(v -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.showInputMethodPicker();
            }
        });

        layout.addView(title);
        layout.addView(enableBtn);
        layout.addView(pickBtn);
        setContentView(layout);
    }
}
