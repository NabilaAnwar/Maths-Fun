<?xml version="1.0" encoding="utf-8"?>
<!--
  ~ Copyright (C) 2015 The Android Open Source Project
  ~
  ~ Licensed under the Apache License, Version 2.0 (the "License");
  ~ you may not use this file except in compliance with the License.
  ~ You may obtain a copy of the License at
  ~
  ~      http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing, software
  ~ distributed under the License is distributed on an "AS IS" BASIS,
  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  ~ See the License for the specific language governing permissions and
  ~ limitations under the License
  -->

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    android:paddingRight="8dp"
    android:paddingEnd="8dp"
    android:paddingTop="2dp"
    android:paddingBottom="2dp"
    >
    <LinearLayout
        android:id="@+id/line1"
        android:layout_width="fill_parent"
        android:layout_height="wrap_content"
        android:paddingTop="6dp"
        android:layout_marginLeft="@dimen/notification_content_margin_start"
        android:layout_marginStart="@dimen/notification_content_margin_start"
        android:orientation="horizontal"
        >
        <TextView android:id="@+id/title"
            android:textAppearance="@style/TextAppearance.AppCompat.Notification.Title.Media"
            android:layout_width="fill_parent"
            android:layout_height="wrap_content"
            android:singleLine="true"
            android:ellipsize="marquee"
            android:fadingEdge="horizontal"
            android:layout_weight="1"
            />
        <DateTimeView android:id="@+id/time"
            android:textAppearance="@style/TextAppearance.AppCompat.Notification.Time.Media"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:singleLine="true"
            android:layout_gravity="center"
            android:layout_weight="0"
            android:visibility="gone"
            android:paddingLeft="8dp"
            android:paddingStart="8dp"
        />
   