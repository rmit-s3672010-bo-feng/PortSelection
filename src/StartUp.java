import java.util.InputMismatchException;
import java.util.Scanner;

public class StartUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SelectionSystem SS = new SelectionSystem();
		SS.readFromFile();
		while (true) {
			Scanner input = new Scanner(System.in);
			System.out.println("-----------Port Number Selection System-----------");
			System.out.println("1. Port Number Selection System");
			System.out.println("2. Display All Information");
			System.out.println("3. Quit The System");
			String option = input.nextLine();
			if (option.equals("1")) {
				try {
					System.out.println("Please enter the student number:");
					String studentNumber = input.nextLine();
					System.out.println("Please enter the first port number range from 61000 to 61999");
					int portNumber1 = input.nextInt();
					System.out.println("Please enter the second port number range from 61000 to 61999");
					int portNumber2 = input.nextInt();
					SS.add(studentNumber, portNumber1, portNumber2);
					MailController.sendMail("{"+studentNumber + "," + portNumber1 + "," + portNumber2+"}");
					SS.writeToFile();
					System.out.println(studentNumber + " has selected the port number " + portNumber1 + " and "
							+ portNumber2 + " successfully");
					System.out.println("The student number and two port numbers has sent to teacher successfully.");
				} catch (InputMismatchException e1) {
					System.out.println("Plese enter the rignt format of the port number.");
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			} else if (option.equals("2")) {
				SS.displayAllInformation();
			} else if (option.equals("3")) {
				System.out.println("Thanks for using.");
				break;
			} else {
				System.out.println("Please enter the right number.");
			}
		}

	}

}
