package com.mir00r.e_book_app_using_realm.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Mir00r on 06-Aug-17.
 */

public class RealmModelAdapters<T extends RealmObject> extends RealmBaseAdapter<T> {
    public RealmModelAdapters(Context context, RealmResults<T> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
