package org.juventus.business.task;

import org.juventus.business.record.TimeRecord;
import org.juventus.business.user.User;

public class Task {

    private int id;
    private String name;
    private String description;
    private User[] users;
    private TimeRecord[] timeRecords;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

}
