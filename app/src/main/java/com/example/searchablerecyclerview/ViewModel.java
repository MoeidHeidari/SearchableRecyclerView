package com.example.searchablerecyclerview;

import com.example.searchablerecyclerview2.Annotations.Searchable;

public class ViewModel
{

    @Searchable
    String name;
    String family;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public ViewModel(String name, String family) {
        this.name = name;
        this.family = family;
    }
}
