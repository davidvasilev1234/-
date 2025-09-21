package app.controllers;

import app.models.ContactMessage;
import app.repositories.ContactMessageRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    private final ContactMessageRepository contactRepo;

    public ContactController(ContactMessageRepository contactRepo) {
        this.contactRepo = contactRepo;
    }

    @GetMapping("/contact")
    public String contactPage(Model model) {
        model.addAttribute("recent", contactRepo.findTop5ByOrderByIdDesc());
        model.addAttribute("recentCount", contactRepo.count());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String subject,
                                @RequestParam String message,
                                Model model) {
        ContactMessage msg = new ContactMessage(name, email, subject, message);
        contactRepo.save(msg);

        model.addAttribute("sent", true);
        model.addAttribute("recent", contactRepo.findTop5ByOrderByIdDesc());
        model.addAttribute("recentCount", contactRepo.count());
        return "contact";
    }
}