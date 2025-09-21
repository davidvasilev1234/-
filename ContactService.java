package app.services;

import app.models.ContactMessage;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class ContactService {

    private final LinkedList<ContactMessage> inbox = new LinkedList<>();

    public void submit(ContactMessage msg) {
        // прост anti-spam: отрежи прекалено дълги
        if (msg.getMessage() != null && msg.getMessage().length() > 2000) {
            msg.setMessage(msg.getMessage().substring(0, 2000));
        }
        inbox.addFirst(msg); // най-новите най-отгоре
        if (inbox.size() > 1000) { inbox.removeLast(); } // ограничение
    }

    public List<ContactMessage> latest(int n) {
        return Collections.unmodifiableList(inbox.subList(0, Math.min(n, inbox.size())));
    }

    public int count() { return inbox.size(); }
}