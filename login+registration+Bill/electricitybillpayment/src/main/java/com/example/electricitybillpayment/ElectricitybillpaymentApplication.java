package com.example.electricitybillpayment;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;

import com.example.electricitybillpayment.controller.BillController;
import com.example.electricitybillpayment.controller.LoginController;
import com.example.electricitybillpayment.controller.RegistrationController;
import com.example.electricitybillpayment.dto.BillDto;
import com.example.electricitybillpayment.dto.LoginDto;
import com.example.electricitybillpayment.dto.UserDto;

@SpringBootApplication
public class ElectricitybillpaymentApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(ElectricitybillpaymentApplication.class, args);
		
		RegistrationController registrationController=applicationContext.getBean(RegistrationController.class);
		LoginController loginController=applicationContext.getBean(LoginController.class);
		BillController billController=applicationContext.getBean(BillController.class);
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("1.Register");
		System.out.println("2.Login");
		System.out.println("3.billing");
		System.out.println("choose an option:");
		int option=scanner.nextInt();
		scanner.nextLine();
		
		if(option==1) {
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
		}
		else if(option==2) {
			System.out.println("enter email");
			String email=scanner.nextLine();
			
			System.out.println("enter password");
			String password=scanner.nextLine();
			
			LoginDto loginDto=new LoginDto();
			loginDto.setEmail(email);
	        loginDto.setPassword(password);
			
			ResponseEntity<String> response=loginController.login(loginDto);
			System.out.println("Response:"+response.getBody());
		}
		else if(option==3) {
			System.out.println("Enter Id");
			Long id=scanner.nextLong();
			
			System.out.println("enter Bill Number");
			String billNumber=scanner.next();
			
			System.out.println("enter Amount");
			Long amount=scanner.nextLong();
			
			System.out.println("enter Billing Date");
			String billingDate=scanner.next();
			
			System.out.println("enter Due Date of bill");
			String dueDate=scanner.next();

			System.out.println("enter Your Status");
			String status=scanner.next();
			
			System.out.println("enter Your Board State");
			String boardState=scanner.next();
						
			System.out.println("enter Your City");
			String city=scanner.next();
			
			System.out.println("enter unit consumed");
			Long units=scanner.nextLong();
			
			
			BillDto billDto=new BillDto();
			
			billDto.setId(id);
			billDto.setBillNumber(billNumber);
			billDto.setAmount(amount);
			billDto.setBillingDate(billingDate);
			billDto.setDueDate(dueDate);
			billDto.setStatus(status);
			billDto.setCity(city);
			billDto.setBoardState(boardState);
			billDto.setUnits(units);
			
			
			
			
			ResponseEntity<String> response=billController.addBill(billDto);
			
	        System.out.println("Response:"+response.getBody());
			
			
			
		}
	}

}
