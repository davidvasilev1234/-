package staj.services;

import staj.models.Membership;

import java.util.HashMap;
import java.util.Map;

public class MembershipService {

    // ✅ Сингълтън инстанция
    private static MembershipService instance;

    // Хранилище за членства (по userId)
    private Map<Integer, Membership> memberships = new HashMap<>();

    // Приватен конструктор
    private MembershipService() {}

    // ✅ Метод за достъп до инстанцията
    public static MembershipService getInstance() {
        if (instance == null) {
            instance = new MembershipService();
        }
        return instance;
    }

    // Добавяне или актуализиране на членство
    public void addOrUpdateMembership(Membership membership) {
        memberships.put(membership.getUserId(), membership);
    }

    // Връщане на членство по userId
    public Membership getMembershipByUserId(int userId) {
        return memberships.get(userId);
    }
}