package org.juventus.persistence;

import org.juventus.domain.Persistable;
import org.juventus.exceptions.NotFoundException;

import java.util.ArrayList;

public class InMemoryDB<T extends Persistable> {

    private ArrayList<T> database = new ArrayList<>();

    public void add(T item)
    {
        int index = this.database.size() == 0 ? this.database.size() : this.database.size() + 1;
        item.setId(index);
        this.database.add(index, item);
    }

    public T getById(int id) throws NotFoundException
    {
        for (T persistable : this.database) {
            if (persistable.getId() == id) {
                return persistable;
            }
        }
        throw new NotFoundException("Es wurde kein Element mit der ID " + id + " gefunden.");
    }

}
