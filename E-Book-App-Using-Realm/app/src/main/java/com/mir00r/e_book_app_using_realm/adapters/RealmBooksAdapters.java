package com.mir00r.e_book_app_using_realm.adapters;

import android.content.Context;

import com.mir00r.e_book_app_using_realm.model.Book;

import io.realm.RealmResults;

/**
 * Created by Mir00r on 06-Aug-17.
 */

public class RealmBooksAdapters extends RealmModelAdapters<Book> {
    public RealmBooksAdapters(Context context, RealmResults<Book> realmResults, boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }
}
