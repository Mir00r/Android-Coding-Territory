package com.mir00r.e_book_app_using_realm.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mir00r.e_book_app_using_realm.R;
import com.mir00r.e_book_app_using_realm.adapters.BooksAdapters;
import com.mir00r.e_book_app_using_realm.adapters.RealmBooksAdapters;
import com.mir00r.e_book_app_using_realm.app.Prefs;
import com.mir00r.e_book_app_using_realm.model.Book;
import com.mir00r.e_book_app_using_realm.realm.RealmController;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Mir00r on 06-Aug-17.
 */

public class MainActivity extends AppCompatActivity {

    private BooksAdapters adapter;
    private Realm realm;
    private LayoutInflater inflater;
    private FloatingActionButton fab;
    private RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        recycler = (RecyclerView) findViewById(R.id.recycler);

        // get Realm instance
        this.realm = RealmController.with(this).getRealm();

        // set Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setUpRecycler();

        if (!Prefs.with(this).getPreLoad()) {
            setRealmData();
        }

        // refresh the realm instance
        RealmController.with(this).refresh();

        /**
         * get all persisted objects
         * create the helper adapter and notify data set changes
         * changes will be reflected automatically
         */

        setRealmAdapter(RealmController.with(this).getBooks());
        Toast.makeText(this, "Press card item for edit, long press to remove item", Toast.LENGTH_LONG).show();

        // Add new Item action
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflater = MainActivity.this.getLayoutInflater();
                View content = inflater.inflate(R.layout.edit_item, null);
                final EditText editTitle = (EditText) content.findViewById(R.id.title);
                final EditText editAuthor = (EditText) content.findViewById(R.id.author);
                final EditText editThumbnail = (EditText) content.findViewById(R.id.thumbnail);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(content)
                        .setTitle("Add New Book")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Book book = new Book();
                                //book.setId(RealmController.getInstance().getBooks().size() + 1);
                                book.setId((int) (RealmController.getInstance().getBooks().size() + System.currentTimeMillis()));
                                book.setTitle(editTitle.getText().toString());
                                book.setAuthor(editAuthor.getText().toString());
                                book.setImageUrl(editThumbnail.getText().toString());

                                if (editTitle.getText() == null || editTitle.getText().toString().equals("") || editTitle.getText().toString().equals(" ")) {
                                    Toast.makeText(MainActivity.this, "Entry not saved, missing title", Toast.LENGTH_SHORT).show();
                                } else {
                                    // Persist your data easily
                                    realm.beginTransaction();
                                    realm.copyToRealm(book);
                                    realm.commitTransaction();

                                    adapter.notifyDataSetChanged();

                                    // scroll the recycler view to bottom
                                    recycler.scrollToPosition(RealmController.getInstance().getBooks().size() - 1);
                                }
                            }
                        })
                        .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }


    private void setRealmAdapter(RealmResults<Book> books) {
        RealmBooksAdapters realmBooksAdapters = new RealmBooksAdapters(this.getApplicationContext(), books, true);

        // Set the date and tell the Recycler view draw
        adapter.setRealmBaseAdapter(realmBooksAdapters);
        adapter.notifyDataSetChanged();
    }

    private void setUpRecycler() {
        /**
         * use this setting to improve performance if you know that changes
         * in content do not change the layout size of the RecyclerView
         */
        recycler.setHasFixedSize(true);

        /**
         * use a linear layout manager since the cards are vertically scrollable
         */
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(layoutManager);

        // create an empty adapter and add it to the recycler view
        adapter = new BooksAdapters(this);
        recycler.setAdapter(adapter);
    }

    private void setRealmData() {
        ArrayList<Book> books = new ArrayList<>();

        Book book = new Book();
        book.setId((int) (1 + System.currentTimeMillis()));
        book.setAuthor("Reto Meier");
        book.setTitle("Android 4 Application Development");
        book.setImageUrl("https://api.androidhive.info/images/realm/1.png");
        books.add(book);

        book = new Book();
        book.setId((int) (2 + System.currentTimeMillis()));
        book.setAuthor("Itzik Ben-Gan");
        book.setTitle("Microsoft SQL Server 2012 T-SQL Fundamentals");
        book.setImageUrl("https://api.androidhive.info/images/realm/2.png");
        books.add(book);

        book = new Book();
        book.setId((int) (3 + System.currentTimeMillis()));
        book.setAuthor("Magnus Lie Hetland");
        book.setTitle("Beginning Python: From Novice To Professional Paperback");
        book.setImageUrl("https://api.androidhive.info/images/realm/3.png");
        books.add(book);

        book = new Book();
        book.setId((int) (4 + System.currentTimeMillis()));
        book.setAuthor("Chad Fowler");
        book.setTitle("The Passionate Programmer: Creating a Remarkable Career in Software Development");
        book.setImageUrl("https://api.androidhive.info/images/realm/4.png");
        books.add(book);

        book = new Book();
        book.setId((int) (5 + System.currentTimeMillis()));
        book.setAuthor("Yashavant Kanetkar");
        book.setTitle("Written Test Questions In C Programming");
        book.setImageUrl("https://api.androidhive.info/images/realm/5.png");
        books.add(book);

        book = new Book();
        book.setId((int) (6 + System.currentTimeMillis()));
        book.setAuthor("Kenneth H. Rosen");
        book.setTitle("Written for building logical foundation");
        book.setImageUrl("https://images-na.ssl-images-amazon.com/images/I/5102AwbnX7L._AC_UL320_SR240,320_.jpg");
        books.add(book);

        for (Book b : books) {
            // Persist your data easily
            realm.beginTransaction();
            realm.copyToRealm(b);
            realm.commitTransaction();
        }

        Prefs.with(this).setPreLoad(true);
    }
}
