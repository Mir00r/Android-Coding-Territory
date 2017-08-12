package com.mir00r.e_book_app_using_realm.adapters;

import android.support.v7.widget.RecyclerView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmObject;

/**
 * Created by Mir00r on 06-Aug-17.
 */

public abstract class RealmRecyclerViewAdapters<T extends RealmObject> extends RecyclerView.Adapter {
    private RealmBaseAdapter<T> realmBaseAdapter;

    public T getItem(int position) {
        return realmBaseAdapter.getItem(position);
    }

    public RealmBaseAdapter<T> getRealmBaseAdapter() {
        return realmBaseAdapter;
    }

    public void setRealmBaseAdapter(RealmBaseAdapter<T> realmBaseAdapter) {
        this.realmBaseAdapter = realmBaseAdapter;
    }
}
