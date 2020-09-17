package book.presentation.note;

import book.application.service.note.ReadedNoteRegisterService;
import book.domain.model.note.note.NoteRequest;
import book.domain.model.note.note.ReadingNote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 読書メモの登録画面
 */
@Controller
@RequestMapping("note/register")
public class ReadedNoteRegisterController {
    ReadedNoteRegisterService service;

    public ReadedNoteRegisterController(ReadedNoteRegisterService service) {
        this.service = service;
    }

    @GetMapping
    private String init(Model model) {
        model.addAttribute("noteRequest", NoteRequest.empty());
        return "note/register/form";
    }

    @GetMapping("show")
    private String showAll(Model model) {
        List<ReadingNote> list = service.showAll();

        System.out.println(list);

        model.addAttribute("notes", list);
        return "note/register/form";
    }

    @PostMapping
    private String wrote(@Validated @ModelAttribute("noteRequest") NoteRequest noteRequest,
                         BindingResult bindingResult,
                         RedirectAttributes attributes) {

        if (bindingResult.hasErrors()) return "note/register/form";

        service.wrote(noteRequest);

        return "note/register/form";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields(
                "note.value",
                "bookTitle.value"
        );
    }

}
