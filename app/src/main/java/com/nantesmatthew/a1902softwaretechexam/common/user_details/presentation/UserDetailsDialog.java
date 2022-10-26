package com.nantesmatthew.a1902softwaretechexam.common.user_details.presentation;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.nantesmatthew.a1902softwaretechexam.databinding.DialogUserDetailsBinding;

public class UserDetailsDialog extends DialogFragment {
    private DialogUserDetailsBinding binder;
    private TextView tvFullName;
    private TextView tvDetails;
    private TextView tvOk;


    private static final String TAG = "UserDetailsDialog";
     static final String FULL_NAME = "FullName";
     static final String DETAILS = "Details";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binder = DialogUserDetailsBinding.inflate(inflater, container, false);
        return binder.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvFullName = binder.tvFullName;
        tvDetails = binder.tvDetails;
        tvOk = binder.tvOk;


        String fullName = getArguments().getString(FULL_NAME,"Null Full Name");
        String details = getArguments().getString(DETAILS,"Null Info");

        tvFullName.setText(fullName);
        tvDetails.setText(details);



        tvOk.setOnClickListener(view1 -> {
            dismiss();
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();

        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

}
