package by.epam.ld.nb.logic;

import by.epam.ld.nb.entity.Note;
import by.epam.ld.nb.entity.NoteBook;
import by.epam.ld.nb.repository.NoteBookProvider;

import java.time.LocalDate;
import java.util.List;

public class NoteBookLogic {

    public static final NoteBookProvider provider = NoteBookProvider.getInstance();

    private NoteBook noteBook;
    private Note note;

    public NoteBookLogic(){
        this.noteBook = new NoteBook();
        provider.addNoteBook(noteBook);
    }

    public NoteBookLogic(int index){
        this.noteBook = provider.getNoteBook(index);
    }

    public void addNote(Note note) {
        noteBook.add(note);
    }

    public void setNoteBook(int index){
        this.noteBook = provider.getNoteBook(index);
    }

    public String findByContext(String n) {
        StringBuffer buffer = new StringBuffer("");
        List<Note> notes = noteBook.getNotes();
        notes.forEach(note -> {
            if (note.getNote().equals(n))
                buffer.append(note.toString());
        });
        return buffer.toString();
    }

    public String findByDate(LocalDate date) {
        StringBuffer buffer = new StringBuffer("");
        List<Note> notes = noteBook.getNotes();
        notes.forEach(note -> {
            if (note.getDate().equals(date)) {
                buffer.append(note.toString());
            }
        });
        return buffer.toString();
    }

    public void editNote(Note note, LocalDate date) {
        Note n = findNote(note);

        if (n == null) {
            return;
        }

        n.setDate(date);
    }

    private Note findNote(Note note) {
        List<Note> notes = noteBook.getNotes();
        if (!notes.contains(note)) {
            return null;
        }

        for (Note n : notes) {
            if (n.equals(note)) {
                return n;
            }
        }

        return null;
    }
}
