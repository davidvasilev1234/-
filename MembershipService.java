package app.services;

import app.models.Membership;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MembershipService {

    private List<Membership> memberships;

    public MembershipService() {
        memberships = new ArrayList<>();
        memberships.add(new Membership(1, "Basic Plan", "Monthly membership with limited access", 30.0));
        memberships.add(new Membership(2, "Premium Plan", "Monthly membership with full access", 50.0));
        memberships.add(new Membership(3, "Annual Plan", "Yearly membership with full access", 500.0));
    }

    public List<Membership> getAllMemberships() {
        return memberships;
    }
}