package staj;

import staj.models.*;
import staj.services.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserService userService = UserService.getInstance();
        MembershipService membershipService = MembershipService.getInstance();
        TrainerService trainerService = TrainerService.getInstance();
        WorkoutService workoutService = WorkoutService.getInstance();
        ReservationService reservationService = ReservationService.getInstance();

        // ... (тук ползваш User.Builder както ти пратих)
        // Пример:
        System.out.println("Въведи потребител (User) данни:");
        System.out.print("ID: ");
        int userId = Integer.parseInt(scanner.nextLine());
        System.out.print("Име: ");
        String userName = scanner.nextLine();
        System.out.print("Email: ");
        String userEmail = scanner.nextLine();
        System.out.print("Парола: ");
        String userPassword = scanner.nextLine();
        System.out.print("Роля (client/trainer/admin): ");
        String userRole = scanner.nextLine();

           ;

        // ... продължава както ти писах преди

        scanner.close();
    }
}