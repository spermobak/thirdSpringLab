package com.bismus.thirdLab.appMenu;

import com.bismus.thirdLab.service.LanguageService;
import com.bismus.thirdLab.service.MessageService;
import com.bismus.thirdLab.service.PersonService;
import com.bismus.thirdLab.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.ResourceBundle;


@ShellComponent
@RequiredArgsConstructor
public class AppMenu {
    private final PersonService personService;
    private final LanguageService languageService;
    private final MessageService messageService;

    private final ReaderService readerService;

    private ResourceBundle message = languageService.setDefaultInterfaceLanguage();


    @ShellMethod("Find all persons")
    public void findAll() {
        if (personService.findAll().isEmpty()) {
            messageService.printInterfaceMessage(message, "notFoundPersons");
        }
        messageService.printInterfaceMessage(message, "successAllPerson");
        messageService.printResultRequestMessage(personService.findAll());
    }

    @ShellMethod("Find person by id")
    public void findById() {
        messageService.printInterfaceMessage(message, "findById");
        int id = readerService.readID();

        if (personService.findById(id) == null) {
            messageService.printInterfaceMessage(message, "notFoundPerson");
        } else {
            messageService.printInterfaceMessage(message, "successPersonById");
            messageService.printResultRequestMessage(personService.findById(id));
        }
    }

    @ShellMethod("Find person by name")
    public void findByName() {
        messageService.printInterfaceMessage(message, "findByName");
        var name = readerService.readWord();

        if (personService.findByName(name) == null) {
            messageService.printInterfaceMessage(message, "notFoundPerson");
        } else {
            messageService.printInterfaceMessage(message, "successPersonByName");
            messageService.printResultRequestMessage(personService.findByName(name));
        }
    }

    @ShellMethod("Change language")
    public void changeLanguage() {
        messageService.printInterfaceMessage(message, "changeLanguage");
        languageService.printLanguageKey();
        var lang = readerService.readWord();
        message = languageService.setInterfaceLanguage(lang, message);
    }

}
