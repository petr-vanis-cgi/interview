package com.cgi.boat.interview;

public class ResultItem {
    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public ResultItem(String name, int count) {
        this.name = name;
        this.count = count;
    }


    private String name = "";
    private int count = 0;

    @Override
    public String toString() {
        return name + " : " + count;
    }
}
