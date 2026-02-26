package com.keybangla.keyboard;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class KeyBanglaIME extends InputMethodService {

    @Override
    public View onCreateInputView() {

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        Button button = new Button(this);
        button.setText("KeyBangla Keyboard Ready");

        layout.addView(button);

        return layout;
    }
}
