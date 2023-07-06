// Generated by view binder compiler. Do not edit!
package com.example.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.android.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView btnBackLogin;

  @NonNull
  public final MaterialButton btnLogin;

  @NonNull
  public final TextInputEditText tbEmail;

  @NonNull
  public final TextInputEditText tbPassword;

  @NonNull
  public final TextView txtSignUp;

  private ActivityLoginBinding(@NonNull RelativeLayout rootView, @NonNull ImageView btnBackLogin,
      @NonNull MaterialButton btnLogin, @NonNull TextInputEditText tbEmail,
      @NonNull TextInputEditText tbPassword, @NonNull TextView txtSignUp) {
    this.rootView = rootView;
    this.btnBackLogin = btnBackLogin;
    this.btnLogin = btnLogin;
    this.tbEmail = tbEmail;
    this.tbPassword = tbPassword;
    this.txtSignUp = txtSignUp;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_back_login;
      ImageView btnBackLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnBackLogin == null) {
        break missingId;
      }

      id = R.id.btn_login;
      MaterialButton btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.tb_email;
      TextInputEditText tbEmail = ViewBindings.findChildViewById(rootView, id);
      if (tbEmail == null) {
        break missingId;
      }

      id = R.id.tb_password;
      TextInputEditText tbPassword = ViewBindings.findChildViewById(rootView, id);
      if (tbPassword == null) {
        break missingId;
      }

      id = R.id.txt_sign_up;
      TextView txtSignUp = ViewBindings.findChildViewById(rootView, id);
      if (txtSignUp == null) {
        break missingId;
      }

      return new ActivityLoginBinding((RelativeLayout) rootView, btnBackLogin, btnLogin, tbEmail,
          tbPassword, txtSignUp);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
