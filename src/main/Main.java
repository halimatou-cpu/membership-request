package main;

import main.domain.*;
import main.infrastructure.InMemoryUserRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //System.out.println("hello world");
        String firstname, lastname, email;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Firstname: ");
        firstname = scanner.nextLine();
        System.out.println("Lastname: ");
        lastname = scanner.nextLine();
        System.out.println("Email adress: ");
        email = scanner.next();
        UserEmail userEmail = new UserEmail(email);

        if(userEmail.isValidEmailAddress() == false){
            System.out.println("Email not valid format, your account won't be created");
            return;
        }else{
            UserRepository userRepository = new InMemoryUserRepository();
            UserApplicationService userApplicationService = new UserApplicationService(userRepository);

            CreateUser createdUser = new CreateUser(lastname, firstname, userEmail);
            final UserId userId = userApplicationService.handle(createdUser);

            final User storedUser = userRepository.findById(userId);

            System.out.println("Saisissez vos coordonnées de paiements: ");
            String payment = scanner.nextLine();
            System.out.println("Paiement OK!");

        }
    }
}
