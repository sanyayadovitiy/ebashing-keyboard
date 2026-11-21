package com.pos.ebashingbynecrosia;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;

public class AutoKeyboardService extends InputMethodService {

    @Override
    public View onCreateInputView() {
        LinearLayout bar = new LinearLayout(this);
        bar.setOrientation(LinearLayout.HORIZONTAL);
        bar.setPadding(16, 16, 16, 16);

        Button testBtn = new Button(this);
        testBtn.setText("ebashing");
        testBtn.setOnClickListener(v -> {
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) {
                ic.commitText("ebashing by necrosia ", 1);
            }
        });

        Button spaceBtn = new Button(this);
        spaceBtn.setText("SPACE");
        spaceBtn.setOnClickListener(v -> {
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) {
                ic.commitText(" ", 1);
            }
        });

        Button delBtn = new Button(this);
        delBtn.setText("DEL");
        delBtn.setOnClickListener(v -> {
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) {
                ic.deleteSurroundingText(1, 0);
            }
        });

        bar.addView(testBtn);
        bar.addView(spaceBtn);
        bar.addView(delBtn);
        return bar;
    }
}
