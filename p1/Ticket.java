package p1;

import java.util.List;
import java.util.Scanner;

public class Ticket {
    private String ticketNO;
    private int adults;
    private int children;

    private double adultsPrice;
    private double adultsPricewithVAT;

    private double childrenPrice;
    private double childrenPricewithVAT;

    private static final double VAT = 1.15;

    Scanner input = new Scanner(System.in);
    Flight flight = new Flight();

    public Ticket() {
    }

    public String getTicketNO() {
        return ticketNO;
    }

    public void setTicketNO(String ticketNO) {
        this.ticketNO = ticketNO;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setPricefprFlightType(List<Flight> flights, int flightType) {
        for (int i=0;i<flights.size();i++){
            System.out.println(flights.get(i).toString());}
        System.out.println();
        flight = flight.selectFlights(flights);

        if (flightType == 1) {
            if (FirstClass.noOfSeatsFirstClass > 0) {
                System.out.println("Welcome to First Class   ");

                System.out.println("Please Enter the Following Information   ");
                System.out.println("How Many Adults ? ");
                adults = input.nextInt();
                FirstClass.noOfSeatsFirstClass = FirstClass.noOfSeatsFirstClass - adults;
                System.out.println("How Many Children ? ");
                children = input.nextInt();
                FirstClass.noOfSeatsFirstClass = FirstClass.noOfSeatsFirstClass - children;
                System.out.println("Your Booking Will be for " + adults + "  Adults and " + children + " Children");
                adultsPrice = adults * FirstClass.ADULTPRICEFRISTCLASS;
                childrenPrice = children * FirstClass.CHILDPRICEFRISTCLASS;
                ticketNO = ("F" + ((int) (Math.random() * 2000) + 1000));
                payment();
            }
        }

        if (flightType == 2) {
            if (Economy.noOfSeatsEco > 0) {
                System.out.println("Welcome to Economy Class   ");
                System.out.println("Please Enter the Following Information   ");
                System.out.println("How Many Adults ? ");
                adults = input.nextInt();
                Economy.noOfSeatsEco = Economy.noOfSeatsEco - adults;
                System.out.println("How Many Children ? ");
                children = input.nextInt();
                Economy.noOfSeatsEco = Economy.noOfSeatsEco - children;
                System.out.println("Your Booking Will be for " + adults + "  Adults and " + children + " Children");
                adultsPrice = adults * Economy.ADULTPRICEECO;
                childrenPrice = children * Economy.CHILDPRICEECO;
                ticketNO = ("E" + ((int) (Math.random() * 2000) + 1000));
                payment();
            } else
                System.out.println("Sorry the Flight is Fully Booked");
        }
    }

    public void payment() {
        adultsPricewithVAT = adultsPrice * VAT;
        if (children != 0) {
            childrenPricewithVAT = childrenPrice * VAT;
            System.out.println("Your Payemnet Details\n ");
        }
        System.out.println(toString());
    }
    @Override
    public String toString() {
        if (children > 0) {
            return "Ticket No  " + ticketNO +"\nFlight No: "+flight.getFlightNO() +"\n\n----------------------\n \uD83D\uDEEB FROM: "+flight.getDestCity()+"\n \uD83D\uDEECTO: "+flight.getArrivalCity()+
                    "\n \uD83D\uDDD3Your Flight Day:  "+flight.getDayOfFlight()+
                    "\n----------------------\n\uD83D\uDCB5Payment Details : \n\n|Adults|   " + adults+"\t\t\t\t\t\t\t\t\t\t\t\t\t |Children|  " + children
                    + " \n|Adults Price Before VAT|  " + adultsPrice + " \t\t\t\t\t\t\t\t\t|Children Price Before VAT|  "  + childrenPrice
                    + " \n|Adults Price After VAT|  " + (int)adultsPricewithVAT +"\t\t\t\t\t\t\t\t\t\t|Children Price After VAT|  "+(int)childrenPricewithVAT + "\n";




        }
        return "Ticket No  " + ticketNO +"\nFlight No: "+flight.getFlightNO() +"\n\n----------------------\n \uD83D\uDEEB FROM: "+flight.getDestCity()+"\n \uD83D\uDEECTO: "+flight.getArrivalCity()+
                "\n \uD83D\uDDD3Your Flight Day:  "+flight.getDayOfFlight()+
                "\n----------------------\n\uD83D\uDCB5Payment Details : \n\n|Adults|   "+adults
                + " \n|Adults Price Before VAT|  " + adultsPrice
                + " \n|Adults Price After VAT|  " + (int)adultsPricewithVAT +"\n";

    }

}
