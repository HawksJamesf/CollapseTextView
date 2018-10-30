package com.github.markzhai.recyclerview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.markzhai.recyclerview.Dummy;

public abstract class ItemSingleTypeBinding extends ViewDataBinding {
  @Bindable
  protected Dummy mPresenter;

  @Bindable
  protected Dummy mItem;

  protected ItemSingleTypeBinding(DataBindingComponent _bindingComponent, View _root,
      int _localFieldCount) {
    super(_bindingComponent, _root, _localFieldCount);
  }

  public abstract void setPresenter(@Nullable Dummy presenter);

  @Nullable
  public Dummy getPresenter() {
    return mPresenter;
  }

  public abstract void setItem(@Nullable Dummy item);

  @Nullable
  public Dummy getItem() {
    return mItem;
  }

  @NonNull
  public static ItemSingleTypeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemSingleTypeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemSingleTypeBinding>inflate(inflater, com.github.markzhai.recyclerview.R.layout.item_single_type, root, attachToRoot, component);
  }

  @NonNull
  public static ItemSingleTypeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  @NonNull
  public static ItemSingleTypeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable DataBindingComponent component) {
    return DataBindingUtil.<ItemSingleTypeBinding>inflate(inflater, com.github.markzhai.recyclerview.R.layout.item_single_type, null, false, component);
  }

  public static ItemSingleTypeBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  public static ItemSingleTypeBinding bind(@NonNull View view,
      @Nullable DataBindingComponent component) {
    return (ItemSingleTypeBinding)bind(component, view, com.github.markzhai.recyclerview.R.layout.item_single_type);
  }
}
