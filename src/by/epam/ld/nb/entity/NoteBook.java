package by.epam.ld.nb.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NoteBook {

    private List<Note> noteBook;
    private Note note;

    public NoteBook(){
        noteBook = new ArrayList<Note>();
    }

    public void add(Note note) {
        this.note = note;
        noteBook.add(note);
    }

    public void add(String context) {
        noteBook.add(new Note(context));
    }

    public void addFew(Note ... notes) {
        for(int i = 0; i < notes.length; i++) {
            Note note = notes[i];
            noteBook.add(note);
        }
    }

    public List<Note> getNotes() {
        return noteBook;
    }

    public int size() {
        return noteBook.size();
    }

    @Override
    public String toString() {
        return noteBook.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        NoteBook noteBook = (NoteBook) obj;
        return this.note == noteBook.note;
    }

    @Override
    public int hashCode() {
        return noteBook.hashCode();
    }

}
