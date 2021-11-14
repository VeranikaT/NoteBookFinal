package by.epam.ld.nb.main;

import by.epam.ld.nb.entity.Note;
import by.epam.ld.nb.entity.NoteBook;
import by.epam.ld.nb.logic.NoteBookLogic;
import by.epam.ld.nb.print.PrintView;
import by.epam.ld.nb.repository.NoteBookProvider;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        NoteBook nb1 = new NoteBook();
        NoteBook nb2 = new NoteBook();

        LocalDate date = LocalDate.now();

        Note n1 = new Note("note1", date);
        Note n2 = new Note("note2", date);
        Note n3 = new Note("note3", date);
        Note n4 = new Note("note4", date);

        nb1.add(n1);
        nb1.add(n2);

        nb2.add(n3);
        nb2.add(n4);

        NoteBookProvider nbp = NoteBookProvider.getInstance();

        nbp.addNoteBook(nb1);
        nbp.addNoteBook(nb2);

        System.out.println("There are " + nbp.addNoteBookGetIndex() + " NoteBooks in NoteBookProvider.");
        System.out.println(nbp.getNoteBook(0));

        PrintView view = new PrintView();

        view.printNote(n1);
        view.printNoteBook(nb1);
        view.printList(nbp);

        NoteBookLogic nbl = new NoteBookLogic();

        Note n5 = new Note("note5", date);
        Note n6 = new Note("note6", date);
        Note n7 = new Note("note7", date);
        Note n8 = new Note("note8", date);

        nbl.addNote(n5);
        nbl.addNote(n6);
        nbl.addNote(n7);
        nbl.addNote(n8);

        nbl.editNote(n5, date.minusYears(1));

        System.out.println("Find by context:" + nbl.findByContext("note5"));
        System.out.println("Find by date" + nbl.findByDate(date));

    }
}
