package com.example.electricitybillpayment;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

import com.example.electricitybillpayment.controller.LoginController;
import com.example.electricitybillpayment.controller.RegistrationController;
import com.example.electricitybillpayment.dto.LoginDto;
import com.example.electricitybillpayment.dto.UserDto;

@SpringBootApplication
public class ElectricitybillpaymentApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ElectricitybillpaymentApplication.class, args);

        RegistrationController registrationController = applicationContext.getBean(RegistrationController.class);
        LoginController loginController = applicationContext.getBean(LoginController.class);

        Scanner scanner = new Scanner(System.in);

        System.out.println("1.Register");
        System.out.println("2.Login");
        System.out.println("choose an option:");
        int option = scanner.nextInt();
        scanner.nextLine();

        if (option == 1) {
            System.out.println("enter first name");
            String firstName = scanner.nextLine();

            System.out.println("enter last name");
            String lastName = scanner.nextLine();

            System.out.println("enter email");
            String email = scanner.nextLine();

            System.out.println("enter password");
            String password = scanner.nextLine();

            System.out.println("enter meter number");
            String meterNumber = scanner.nextLine();

            System.out.println("enter board state");
            String boardState = scanner.nextLine();

            System.out.println("enter city");
            String city = scanner.nextLine();

            UserDto userDto = new UserDto();
            userDto.setFirstName(firstName);
            userDto.setLastName(lastName);
            userDto.setEmail(email);
            userDto.setPassword(password);
            userDto.setMeterNumber(meterNumber);
            userDto.setBoardState(boardState);
            userDto.setCity(city);

            ResponseEntity<String> response = registrationController.registerUser(userDto);
            System.out.println("Response:" + response.getBody());
        } else if (option == 2) {
            System.out.println("enter email");
            String email = scanner.nextLine();

            System.out.println("enter password");
            String password = scanner.nextLine();

            LoginDto loginDto = new LoginDto();
            loginDto.setEmail(email);
            loginDto.setPassword(password);

            ResponseEntity<String> response = loginController.login(loginDto);
            System.out.println("Response:" + response.getBody());
        }
    }
}