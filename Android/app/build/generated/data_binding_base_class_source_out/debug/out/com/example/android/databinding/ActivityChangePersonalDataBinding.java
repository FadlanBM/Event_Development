// Generated by view binder compiler. Do not edit!
package com.example.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
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

public final class ActivityChangePersonalDataBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ImageView btnBackSettings;

  @NonNull
  public final MaterialButton btnSubmit;

  @NonNull
  public final RadioButton rdFemale;

  @NonNull
  public final RadioButton rdMale;

  @NonNull
  public final TextInputEditText tbAddress;

  @NonNull
  public final TextInputEditText tbBirth;

  @NonNull
  public final TextInputEditText tbFullname;

  @NonNull
  public final TextInputEditText tbPhone;

  private ActivityChangePersonalDataBinding(@NonNull RelativeLayout rootView,
      @NonNull ImageView btnBackSettings, @NonNull MaterialButton btnSubmit,
      @NonNull RadioButton rdFemale, @NonNull RadioButton rdMale,
      @NonNull TextInputEditText tbAddress, @NonNull TextInputEditText tbBirth,
      @NonNull TextInputEditText tbFullname, @NonNull TextInputEditText tbPhone) {
    this.rootView = rootView;
    this.btnBackSettings = btnBackSettings;
    this.btnSubmit = btnSubmit;
    this.rdFemale = rdFemale;
    this.rdMale = rdMale;
    this.tbAddress = tbAddress;
    this.tbBirth = tbBirth;
    this.tbFullname = tbFullname;
    this.tbPhone = tbPhone;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityChangePersonalDataBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityChangePersonalDataBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_change_personal_data, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityChangePersonalDataBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_back_settings;
      ImageView btnBackSettings = ViewBindings.findChildViewById(rootView, id);
      if (btnBackSettings == null) {
        break missingId;
      }

      id = R.id.btn_submit;
      MaterialButton btnSubmit = ViewBindings.findChildViewById(rootView, id);
      if (btnSubmit == null) {
        break missingId;
      }

      id = R.id.rd_female;
      RadioButton rdFemale = ViewBindings.findChildViewById(rootView, id);
      if (rdFemale == null) {
        break missingId;
      }

      id = R.id.rd_male;
      RadioButton rdMale = ViewBindings.findChildViewById(rootView, id);
      if (rdMale == null) {
        break missingId;
      }

      id = R.id.tb_address;
      TextInputEditText tbAddress = ViewBindings.findChildViewById(rootView, id);
      if (tbAddress == null) {
        break missingId;
      }

      id = R.id.tb_birth;
      TextInputEditText tbBirth = ViewBindings.findChildViewById(rootView, id);
      if (tbBirth == null) {
        break missingId;
      }

      id = R.id.tb_fullname;
      TextInputEditText tbFullname = ViewBindings.findChildViewById(rootView, id);
      if (tbFullname == null) {
        break missingId;
      }

      id = R.id.tb_phone;
      TextInputEditText tbPhone = ViewBindings.findChildViewById(rootView, id);
      if (tbPhone == null) {
        break missingId;
      }

      return new ActivityChangePersonalDataBinding((RelativeLayout) rootView, btnBackSettings,
          btnSubmit, rdFemale, rdMale, tbAddress, tbBirth, tbFullname, tbPhone);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
