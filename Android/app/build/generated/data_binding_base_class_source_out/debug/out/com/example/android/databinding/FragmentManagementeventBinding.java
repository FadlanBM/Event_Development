// Generated by view binder compiler. Do not edit!
package com.example.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
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

public final class FragmentManagementeventBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final MaterialButton btnSubmitEvent;

  @NonNull
  public final LinearLayout formEvent;

  @NonNull
  public final LinearLayout linerButton;

  @NonNull
  public final ProgressBar progressBarrEvent;

  @NonNull
  public final TextInputEditText tbName;

  @NonNull
  public final TextView tbShowEvent;

  @NonNull
  public final MaterialButton tbTambah;

  @NonNull
  public final TextInputEditText tbTanggal;

  @NonNull
  public final TextInputEditText tbTujuan;

  @NonNull
  public final TextInputEditText tbUraian;

  @NonNull
  public final TextInputEditText tbWaktu;

  @NonNull
  public final MaterialButton tbnCancelEvent;

  @NonNull
  public final TextView txtTambahEvent;

  private FragmentManagementeventBinding(@NonNull RelativeLayout rootView,
      @NonNull MaterialButton btnSubmitEvent, @NonNull LinearLayout formEvent,
      @NonNull LinearLayout linerButton, @NonNull ProgressBar progressBarrEvent,
      @NonNull TextInputEditText tbName, @NonNull TextView tbShowEvent,
      @NonNull MaterialButton tbTambah, @NonNull TextInputEditText tbTanggal,
      @NonNull TextInputEditText tbTujuan, @NonNull TextInputEditText tbUraian,
      @NonNull TextInputEditText tbWaktu, @NonNull MaterialButton tbnCancelEvent,
      @NonNull TextView txtTambahEvent) {
    this.rootView = rootView;
    this.btnSubmitEvent = btnSubmitEvent;
    this.formEvent = formEvent;
    this.linerButton = linerButton;
    this.progressBarrEvent = progressBarrEvent;
    this.tbName = tbName;
    this.tbShowEvent = tbShowEvent;
    this.tbTambah = tbTambah;
    this.tbTanggal = tbTanggal;
    this.tbTujuan = tbTujuan;
    this.tbUraian = tbUraian;
    this.tbWaktu = tbWaktu;
    this.tbnCancelEvent = tbnCancelEvent;
    this.txtTambahEvent = txtTambahEvent;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentManagementeventBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentManagementeventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_managementevent, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentManagementeventBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_submit_event;
      MaterialButton btnSubmitEvent = ViewBindings.findChildViewById(rootView, id);
      if (btnSubmitEvent == null) {
        break missingId;
      }

      id = R.id.form_event;
      LinearLayout formEvent = ViewBindings.findChildViewById(rootView, id);
      if (formEvent == null) {
        break missingId;
      }

      id = R.id.liner_button;
      LinearLayout linerButton = ViewBindings.findChildViewById(rootView, id);
      if (linerButton == null) {
        break missingId;
      }

      id = R.id.progress_barr_event;
      ProgressBar progressBarrEvent = ViewBindings.findChildViewById(rootView, id);
      if (progressBarrEvent == null) {
        break missingId;
      }

      id = R.id.tb_name;
      TextInputEditText tbName = ViewBindings.findChildViewById(rootView, id);
      if (tbName == null) {
        break missingId;
      }

      id = R.id.tb_showEvent;
      TextView tbShowEvent = ViewBindings.findChildViewById(rootView, id);
      if (tbShowEvent == null) {
        break missingId;
      }

      id = R.id.tb_tambah;
      MaterialButton tbTambah = ViewBindings.findChildViewById(rootView, id);
      if (tbTambah == null) {
        break missingId;
      }

      id = R.id.tb_tanggal;
      TextInputEditText tbTanggal = ViewBindings.findChildViewById(rootView, id);
      if (tbTanggal == null) {
        break missingId;
      }

      id = R.id.tb_tujuan;
      TextInputEditText tbTujuan = ViewBindings.findChildViewById(rootView, id);
      if (tbTujuan == null) {
        break missingId;
      }

      id = R.id.tb_uraian;
      TextInputEditText tbUraian = ViewBindings.findChildViewById(rootView, id);
      if (tbUraian == null) {
        break missingId;
      }

      id = R.id.tb_waktu;
      TextInputEditText tbWaktu = ViewBindings.findChildViewById(rootView, id);
      if (tbWaktu == null) {
        break missingId;
      }

      id = R.id.tbn_cancel_event;
      MaterialButton tbnCancelEvent = ViewBindings.findChildViewById(rootView, id);
      if (tbnCancelEvent == null) {
        break missingId;
      }

      id = R.id.txt_tambahEvent;
      TextView txtTambahEvent = ViewBindings.findChildViewById(rootView, id);
      if (txtTambahEvent == null) {
        break missingId;
      }

      return new FragmentManagementeventBinding((RelativeLayout) rootView, btnSubmitEvent,
          formEvent, linerButton, progressBarrEvent, tbName, tbShowEvent, tbTambah, tbTanggal,
          tbTujuan, tbUraian, tbWaktu, tbnCancelEvent, txtTambahEvent);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
