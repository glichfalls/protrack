package org.juventus.business.project;

import org.juventus.business.task.Task;
import org.juventus.business.user.User;

import java.security.InvalidParameterException;

public class Project {

    private static final String STATUS_OPEN = "OPEN";
    private static final String STATUS_FINISHED = "FINISHED";

    private String name;
    private String description;
    private String status;
    private User[] users;
    private Task[] tasks;

    public Project(String name, String description) {
        this.setName(name);
        this.setDescription(description);
        this.setStatus(Project.STATUS_OPEN);
    }

    public Project(String name, String description, User[] users, Task[] tasks)
    {
        this.setName(name);
        this.setDescription(description);
        this.setUsers(users);
        this.setTasks(tasks);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        if(!status.equals(Project.STATUS_OPEN) && !status.equals(Project.STATUS_FINISHED)) {
            throw new InvalidParameterException("The status " + status + " is invalid.");
        }
        this.status = status;
    }

    public User[] getUsers()
    {
        return users;
    }

    public void setUsers(User[] users)
    {
        this.users = users;
    }

    public Task[] getTasks()
    {
        return tasks;
    }

    public void setTasks(Task[] tasks)
    {
        this.tasks = tasks;
    }
}
