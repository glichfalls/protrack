package org.juventus.business.record;

import org.juventus.business.user.User;

public class TimeRecord {

    private int id;
    private String description;
    private User user;
    private int time;

    public TimeRecord(int id, String description, User user, int time)
    {
        this.id = id;
        this.description = description;
        this.user = user;
        this.time = time;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public User getUser()
    {
        return user;
    }

    public int getTime()
    {
        return time;
    }

}
