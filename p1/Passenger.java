package p1;


import java.util.*;

public class Passenger extends User {
    private String firstName;
    private String lastName;
    private char gender;
    private String phoneNo;
    static public int numOfpassengers;
    private Ticket reservedTicket;

    Scanner input = new Scanner(System.in);

    public Passenger() {

    }

    public void setTicket(Ticket t) {

        reservedTicket = t;
    }

    public Ticket getTicket() {

        return reservedTicket;
    }

    public void cancel(List<Passenger> personArray) {
        Passenger toRemove = null;
        String firstN, lastN;
        System.out.println("Please Enter Your First Name:");
        firstN = input.next();
        System.out.println("Please Enter Your Last Name:");
        lastN = input.next();
        for (Passenger p : personArray) {
            if (p.firstName.equalsIgnoreCase(firstN) && p.lastName.equalsIgnoreCase(lastN)) {

                System.out.println(p);
                System.out.println("**** Are you Sure you Want to Delete? 1- yes 2-no ****");
                int ch = input.nextInt();
                if (ch == 1)
                    toRemove = p;

                else
                    return;

            }
        }
        if (toRemove != null)
            personArray.remove(toRemove);

    }

    public Passenger(String firstName, String lastName, char gender, String phoneNo, Ticket reservedTicket) {
        super(firstName + lastName, phoneNo);
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.phoneNo = phoneNo;
        this.reservedTicket = reservedTicket;
        numOfpassengers++;

    }

    public void creatPassenger(List<Passenger> personArray, List<Flight> flightsArray) {

        System.out.println("Please Enter the Following Information");
        System.out.println("First Name : ");
        firstName = input.next();
        System.out.println("Last Name : ");
        lastName = input.next();
        System.out.println("Phone Number : ");
        phoneNo = input.next();

        do {
            System.out.println(" Gender F for Female , M for Male: ");
            gender = input.next().toUpperCase().charAt(0);

            if ((gender != 'f') && (gender != 'm') && (gender != 'F') && (gender != 'M')) {
                System.out.println("WRONG ENTRY");
            }
        } while ((gender != 'f') && (gender != 'm') && (gender != 'F') && (gender != 'M'));

        Ticket ticket = new Ticket();
        int flightType;
        System.out.println("Please Enter the Following Information");
        System.out.println("What Class Would you Like  ? ");
        System.out.println("Enter \n 1- First Class \n 2- Economy Class ");
        do {

            flightType = input.nextInt();
            if(flightType!=1&&flightType!=2){
                System.out.println("Wrong Entry!!\n Please Enter \n 1- First Class \n 2- Economy Class  ");}
        }while (flightType!=1&&flightType!=2);
        if (flightType == 1) {
            if (FirstClass.noOfSeatsFirstClass <= 0) {
                System.out.println("Fully booked");
                return;
            }
        }
        if (flightType == 2) {
            if (Economy.noOfSeatsEco <= 0) {
                System.out.println("Fully booked");
                return;

            }
        }

        ticket.setPricefprFlightType(flightsArray, flightType);



        reservedTicket = ticket;

        Passenger person = new Passenger(firstName, lastName, gender, phoneNo, reservedTicket);
        personArray.add(person);

        System.out.println("Your Information is Saved Successfully ");
    }

    public String getPhoneNo() {
        return phoneNo;

    }

    public String getFirstName() {
        return firstName;

    }

    public String getLastName() {
        return lastName;

    }

    public char getGender() {
        return gender;

    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }

    public void setGender(char gender) {
        this.gender = gender;

    }
    @Override
    public String toString() {
        String n1="----------------------\nName of the passenger: " + firstName + " " + lastName + "\nGender: " + gender + "\nPhone number: "
                + phoneNo + "\n----------------------\n\n";
        String n2=reservedTicket.toString();
        return n1+n2;


    }


}

