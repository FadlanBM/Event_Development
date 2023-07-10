// Generated by view binder compiler. Do not edit!
package com.example.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.android.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProfileBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final MaterialButton btnUpdate;

  @NonNull
  public final TextInputEditText tbEmail;

  @NonNull
  public final TextInputEditText tbName;

  @NonNull
  public final Toolbar toolbar;

  private ActivityProfileBinding(@NonNull LinearLayout rootView, @NonNull MaterialButton btnUpdate,
      @NonNull TextInputEditText tbEmail, @NonNull TextInputEditText tbName,
      @NonNull Toolbar toolbar) {
    this.rootView = rootView;
    this.btnUpdate = btnUpdate;
    this.tbEmail = tbEmail;
    this.tbName = tbName;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_update;
      MaterialButton btnUpdate = ViewBindings.findChildViewById(rootView, id);
      if (btnUpdate == null) {
        break missingId;
      }

      id = R.id.tb_email;
      TextInputEditText tbEmail = ViewBindings.findChildViewById(rootView, id);
      if (tbEmail == null) {
        break missingId;
      }

      id = R.id.tb_name;
      TextInputEditText tbName = ViewBindings.findChildViewById(rootView, id);
      if (tbName == null) {
        break missingId;
      }

      id = R.id.toolbar;
      Toolbar toolbar = ViewBindings.findChildViewById(rootView, id);
      if (toolbar == null) {
        break missingId;
      }

      return new ActivityProfileBinding((LinearLayout) rootView, btnUpdate, tbEmail, tbName,
          toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
