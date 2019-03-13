import java.util.*;

public class CheeseShop {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		double hF, rH, tE;
		double total = 0.0;

		System.out.println("We sell 3 kinds of cheese:");
		System.out.println("Humboldt Fog: $25.00 per pound");
		System.out.println("Red Hawk: $40.50 per pound");
		System.out.println("Teleme: $17.25 per pound");

		System.out.print("\nEnter the amount of Humboldt Fog in lbs: ");
		while (true) {
			hF = s.nextDouble();
			if (check(hF)) break;
		}

		System.out.print("Enter the amount of Red Hawk in lbs: ");
		while (true) {
			rH = s.nextDouble();
			if (check(rH)) break;
		}

		System.out.print("Enter the amount of Teleme in lbs: ");
		while (true) {
			tE = s.nextDouble();
			if (check(tE)) break;
		}

		System.out.print("\nDisplay the itemized list? (1 for yes) ");
		if (s.nextInt() == 1) {
			if (hF > 0) System.out.println(hF * 2 + " of Humboldt Fog @ $25.00 per lb = $" + hF * 2 * 25.00);
			if (rH > 0) System.out.println(round(rH * 4/3) + " of Red Hawk @ $40.50 per lb = $" + rH * 40.50);
			if (tE > 0) System.out.println(tE + " of Teleme @ $17.25 per lb = $" + tE * 17.25);
		}

		total = ((hF * 2) * 25.00) + ((round(rH * 4/3)) * 40.50) + (tE * 17.25);

		System.out.println("\nSubtotal: 					 $" + total);
		System.out.println("Discounts...");

		if (hF < 0.5 && rH < 1.0) System.out.println("None 						-$0");
		else {
			if (hF >= 0.5) System.out.println("Humboldt Fog (Buy 1 Get 1 Free): 		-$" + hF * 25.00);
			total -= hF * 25;
			if (rH >= 1.0) System.out.println("Red Hawk (Buy 2 Get 1 Free):	        	-$" + (round(rH * 4/3) - rH) * 40.50);
			total -= (round(rH * 4/3) - rH) * 40.50;
		}

		System.out.println("Total:  					 $" + total);
		s.close();

	}

	public static boolean check (double uIn) {
		if (uIn < 0) {
			System.out.print("Invalid Input. Enter a value >= 0:");
			return false;
		} else if (uIn % 0.5 != 0) {
			System.out.print("Invalid input. Enter a value that's multiple of 0.5:");
			return false;
		} else return true;
	}

	public static double round(double d) {
		return Math.round(d * 2) / 2.0;
	}

}