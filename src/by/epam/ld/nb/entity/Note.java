package by.epam.ld.nb.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Note implements Serializable {

    private String note;
    private LocalDate date;

    public Note() {
        this.note = null;
        this.date = null;
    }

    public Note(String note) {
        this.note = note;
        this.date = null;
    }

    public Note(String note, LocalDate date) {
        this.note = note;
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime + result + (((date == null)) ? 0 : date.hashCode());
        result = prime + result + (((note == null)) ? 0 : note.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Note other = (Note) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(!date.equals(other.date)))
            return false;
        if (note == null) {
            return false;
        } else if (!note.equals(other.note))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Note=" + note + ", date=" + date + ";";
    }
}
