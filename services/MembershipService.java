package staj.services;

import staj.models.Membership;

import java.util.HashMap;
import java.util.Map;

public class MembershipService {


    private static MembershipService instance;

    private Map<Integer, Membership> memberships = new HashMap<>();

    private MembershipService() {}
    public static MembershipService getInstance() {
        if (instance == null) {
            instance = new MembershipService();
        }
        return instance;
    }

    public void addOrUpdateMembership(Membership membership) {
        memberships.put(membership.getUserId(), membership);
    }

    public Membership getMembershipByUserId(int userId) {
        return memberships.get(userId);
    }

}
