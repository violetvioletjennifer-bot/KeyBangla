package com.keybangla.keyboard;

import android.inputmethodservice.InputMethodService;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup;
import android.view.Gravity;
import android.view.inputmethod.InputConnection;

public class KeyBanglaIME extends InputMethodService {

    @Override
    public View onCreateInputView() {

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(0xFF222222);

        String[] keys = {
                "ক","খ","গ","ঘ","ঙ",
                "চ","ছ","জ","ঝ","ঞ",
                "ট","ঠ","ড","ঢ","ণ",
                "ত","থ","দ","ধ","ন",
                "প","ফ","ব","ভ","ম",
                "য","র","ল","শ","স",
                "হ","া","ি","ু","ে",
                "SPACE","⌫"
        };

        LinearLayout row = null;

        for (int i = 0; i < keys.length; i++) {

            if (i % 5 == 0) {
                row = new LinearLayout(this);
                row.setOrientation(LinearLayout.HORIZONTAL);
                row.setGravity(Gravity.CENTER);
                layout.addView(row);
            }

            Button button = new Button(this);
            button.setText(keys[i]);
            button.setTextSize(18);

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(
                            0,
                            ViewGroup.LayoutParams.WRAP_CONTENT,
                            1
                    );

            button.setLayoutParams(params);

            String key = keys[i];

            button.setOnClickListener(v -> {

                InputConnection ic = getCurrentInputConnection();

                if (ic == null) return;

                if (key.equals("SPACE")) {
                    ic.commitText(" ",1);
                }
                else if (key.equals("⌫")) {
                    ic.deleteSurroundingText(1,0);
                }
                else {
                    ic.commitText(key,1);
                }

            });

            row.addView(button);
        }

        return layout;
    }
}
