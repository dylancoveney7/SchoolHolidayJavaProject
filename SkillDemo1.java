/* Name: Dylan Coveney 
 * Date: 24/01/2023
* This program reads in the number of students and teachers going on a trip and calculates how much the cost will be
* depending on various costs, discounts and surcharges.  */


import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Random;
import java.util.Date; 
import java.text.SimpleDateFormat;

public class SkillDemo1 {

		public static void main(String[] args) {
				DecimalFormat moneyFormat = new DecimalFormat( "€###,##0.00");
				DecimalFormat bedFormat = new DecimalFormat ("0");
				Scanner sc = new Scanner(System.in);
				
				//Declaring variables such as school name, address, invoice number and date. 
				
				String schoolName, addressLine1, addressLine2, addressLine3;
				byte students, teachers, nights, freeFlights; 
				int invoiceNo = new Random ().nextInt(999999);
				float studentAccom, teacherAccom, flightCost, subtotal, emptyTBeds, emptySBeds, total;
				SimpleDateFormat dateFormat = new SimpleDateFormat ("dd/MMM/yyyy");
				Date today = new Date ();
				
				/* Reads in the details from the person booking */
				System.out.println("Enter the name of the school");
				schoolName = sc.nextLine();
				System.out.println("Enter the first line of the schools address");
				addressLine1 = sc.nextLine();
				System.out.println("Enter the second line of the schools address");
				addressLine2 = sc.nextLine();
				System.out.println("Enter the third line of the schools address");
				addressLine3 = sc.nextLine();
				System.out.println("Enter the number of nights you will be staying");
				nights = sc.nextByte();
				System.out.println("Enter the number of students that will be going on this trip");
				students = sc.nextByte();
				System.out.println("Enter the number of teachers that will be going on this trip");
				teachers = sc.nextByte();
				
				/*Calculates cost of flights, teacher and student accommodation and the subtotal
				 * using previous variables that were declared and input by user. There is two
				 * separate 'flights' variables here, the second of which is used in the if statement
				 * to calculate if there are any free flights due. */
				
				byte flights = (byte)(teachers + students); 
				byte flights1 = (byte)(teachers + students);
				flightCost = (float)(flights*213.67); 
				studentAccom = (float)(students*37.5*nights);
				teacherAccom = (float)(teachers*58.5*nights);
				subtotal = flightCost + studentAccom + teacherAccom; 
				
				//Calculates if there is any free flights due based on the number of students in attendance
				
				if (students >= 100) 
					{flights1 = ((byte)(flights - 5));}
				else if (students >= 80)
					{flights1 = ((byte)(flights - 4));}
				else if (students >= 60)
					{flights1 = ((byte)(flights - 3));}
				else if (students >= 40)
					{flights1 = ((byte)(flights - 2));}
				else if (students >= 20)
					{flights1 = ((byte)(flights - 1));}
				
				//Calculates extra costs based on whether or not there is empty beds in both the teachers and students accommodation 
				
				if (teachers % 2 == 1)
					{emptyTBeds = 1;}
				else 
					{emptyTBeds = 0;}
				
				if (students % 4 == 3)
					{emptySBeds = 1;}
				else if (students % 4 == 2)
					{emptySBeds = 2;}
				else if (students % 4 == 1)
					{emptySBeds = 3;}
				else 
					{emptySBeds = 0;}
				
				//Calculates the number of free flights due and the total
				
				freeFlights = (byte)(flights - flights1); 
				total = subtotal + (float)(emptyTBeds*15.43) + (float)(emptySBeds*8.42) - (float)(freeFlights*213.67);
				
				/* Prints all previous data that was inputted.
				 * There is If statements used for the free
				 * flight and surcharge sections so they
				 * won't be printed if these values are 0
				 */
				
				System.out.println("\u250F\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2513");
				System.out.println("\u2503\t\t\t\t Rebel Tours LTD.");
				System.out.println("\u2503\t\t\t\t\tInvoice No: \t" + invoiceNo);
				System.out.println("\u2503\t\t\t\t\tDate: \t" + dateFormat.format(today));
				System.out.println("\u2503School Name: \t" + schoolName);
				System.out.println("\u2503Address:\t" + addressLine1);
				System.out.println("\u2503\t\t" + addressLine2);
				System.out.println("\u2503\t\t" + addressLine3);
				System.out.println("\u2503\n\u2503No. of Nights: " + nights);
				System.out.println("\u2503Flights: \t\t\t" + flights + "\t\t" + moneyFormat.format(flightCost));
				System.out.println("\u2503Student Accommodation: \t\t" + students + "\t\t" + moneyFormat.format(studentAccom));
				System.out.println("\u2503Teacher Accomodation: \t\t" + teachers + "\t\t" + moneyFormat.format(teacherAccom));
				System.out.println("\u2503\t\t\t\t\t\t\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
				System.out.println("\u2503Subtotal: \t\t\t\t\t" + moneyFormat.format(subtotal));
				if (emptySBeds + emptyTBeds > 0)
					{System.out.println("\u2503Surcharge:");
					System.out.println("\u2503Student Accommodation:\t\t" + bedFormat.format(emptySBeds) + "\t\t" + moneyFormat.format(emptySBeds*8.42));
					System.out.println("\u2503Teacher Accommodation:\t\t" + bedFormat.format(emptyTBeds) + "\t\t" + moneyFormat.format(emptyTBeds*15.43));}
				if (freeFlights > 0)
					{System.out.println("\u2503Discount:");
				System.out.println("\u2503Free teacher flights\t\t" + freeFlights + "\t\t" + moneyFormat.format(freeFlights*213.67));}
				System.out.println("\u2503\t\t\t\tTotal:\t\t" + moneyFormat.format(total));
				System.out.println("\u2517\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501\u2501");
				
				sc.close();
			}

		}
