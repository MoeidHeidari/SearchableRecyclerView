package com.example.searchablerecyclerview2;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Adapter;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.searchablerecyclerview2.Annotations.Searchable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by applemacbookair on 2/13/19.
 */

public class SearchableRecyclerView extends RecyclerView
{
    RecyclerSearchListener searchListener;
    List<?> allModels;

    public List<?> getAllModels() {
        return allModels;
    }

    public void setAllModels(List<?> allModels) {
        this.allModels = allModels;
    }

    boolean searchPerformed=false;

    public RecyclerSearchListener getSearchListener() {
        return searchListener;
    }

    public void setSearchListener(RecyclerSearchListener searchListener) {
        this.searchListener = searchListener;
    }

    public Field getSearchableField() {
        return searchableField;
    }

    public void setSearchableField(Field searchableField) {
        this.searchableField = searchableField;
    }

    Field searchableField=null;
    public SearchableRecyclerView(Context context) {
        super(context);
    }

    public SearchableRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SearchableRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public Adapter getAdapter()
    {

        return super.getAdapter();
    }
    public void performSearch(final List<?> models, final EditText searchBar, Class type)
    {



        allModels=models;
        final List<Object> searchModels=new ArrayList<>();

        String searchableFieldName;

            for (Field f : type.getDeclaredFields())
            {

                if(f.isAnnotationPresent(Searchable.class))
                {
                    searchableField=f;
                }

        }

        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int b, int i1, int i2)
            {
                Log.e("performSearch",String.valueOf(allModels.size()));
                searchModels.clear();
                for (int i = 0; i < allModels.size(); i++)
                {
                    searchableField.setAccessible(true);
                    String value = null;
                    try {
                        value = (String) searchableField.get(allModels.get(i));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if(value.contains(searchBar.getText().toString()))
                    {
                        searchModels.add(allModels.get(i));
                    }
                }

                searchListener.foundedItems(searchModels);

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
            }
        });


    }
    public interface RecyclerSearchListener
    {
        public void foundedItems(List<?> foundeds);
    }

}
