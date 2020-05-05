package org.juventus.domain;

public class Project {

    private int id;
    private String name;
    private String description;
    private User[] users;
    private Task[] tasks;

    public Project(int id, String name, String description, User[] users, Task[] tasks)
    {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setUsers(users);
        this.setTasks(tasks);
    }

    public int getId()
    {
        return id;
    }

    private void setId(int id)
    {
        this.id = id;
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
