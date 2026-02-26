package com.keybangla.keyboard;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class KeyBanglaIME extends InputMethodService {

    @Override
    public View onCreateInputView() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);

        Button btn = new Button(this);
        btn.setText("বাংলা");

        btn.setOnClickListener(v -> {
            getCurrentInputConnection().commitText("বাংলা ", 1);
        });

        layout.addView(btn);

        return layout;
    }
}
