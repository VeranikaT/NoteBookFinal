package by.epam.ld.nb.repository;

import by.epam.ld.nb.entity.NoteBook;

import java.util.ArrayList;
import java.util.List;

public class NoteBookProvider {

    public final static NoteBookProvider instance = new NoteBookProvider();

    List<NoteBook> notebookList = new ArrayList<NoteBook>();

    public NoteBookProvider() {

    }

    public void addNoteBook(NoteBook noteBook) {
        notebookList.add(noteBook);
    }

    public int addNoteBookGetIndex() {
        NoteBook noteBook = new NoteBook();
        notebookList.add(noteBook);
        int result = notebookList.size()-1;
         return result;
    }

    public NoteBook getNoteBook(int index){
        if(index >= notebookList.size()) {
            throw new RuntimeException("There is no notebook with such an index");
        }
        return notebookList.get(index);
    }

    public static NoteBookProvider getInstance() {
        return instance;
    }

}
