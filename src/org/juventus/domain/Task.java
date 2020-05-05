package org.juventus.domain;

public class Task implements Persistable {

    private int id;
    private String name;
    private String description;
    private User[] users;
    private TimeRecord[] timeRecords;

    public int getId()
    {
        return id;
    }

}
