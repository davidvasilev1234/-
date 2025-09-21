package app.controllers;

import app.repositories.ContactMessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/messages")
public class ContactAdminController {

    private final ContactMessageRepository contactRepo;

    public ContactAdminController(ContactMessageRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    // списък с всички съобщения (най-новите отгоре)
    @GetMapping
    public String list(Model model) {
        model.addAttribute("messages", contactRepo.findAll()
                .stream()
                .sorted((a,b) -> Long.compare(b.getId(), a.getId()))
                .toList());
        model.addAttribute("count", contactRepo.count());
        return "admin-messages";
    }

    // изтриване по id
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        contactRepo.deleteById(id);
        return "redirect:/admin/messages";
    }

    // изтриване на всички
    @PostMapping("/delete-all")
    public String deleteAll() {
        contactRepo.deleteAll();
        return "redirect:/admin/messages";
    }
}