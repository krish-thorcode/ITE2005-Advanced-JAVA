class Generalized {
	public static void main(String args[])
	{
		if(args.length == 4 ) {
			String fname = args[0];
			String lname = args[1];
			double weight = Double.parseDouble(args[2]);
			double height = Double.parseDouble(args[3]);

			double bmi = weight/(height*height);

			System.out.println("Your name: " + fname + " " + lname);
			System.out.print("Your Category: ");
			if(bmi < 18.5)
				System.out.println("Underweight");
			else if(bmi >= 18.5 && bmi < 25)
				System.out.println("Normal(healthy weight)");
			else if(bmi >= 25 && bmi < 30)
				System.out.println("Overweight");
			else
				System.out.println("Obese class");
		}
		else {
			int n = args.length;
			int num_of_persons = Integer.parseInt(args[0]);
			int offset = 4; // one person's details will occupy 4 places in args
			for(int i = 0; i < num_of_persons; i++) {
				String fname = args[i*offset + 1];
				String lname = args[i*offset + 2];
				double weight = Double.parseDouble(args[i*offset + 3]);
				double height = Double.parseDouble(args[i*offset + 4]);

				double bmi = weight/(height*height);

				System.out.println("Your name: " + fname + " " + lname);
				System.out.print("Your Category: ");
				if(bmi < 18.5)
					System.out.println("Underweight");
				else if(bmi >= 18.5 && bmi < 25)
					System.out.println("Normal(healthy weight)");
				else if(bmi >= 25 && bmi < 30)
					System.out.println("Overweight");
				else
					System.out.println("Obese class");
			}
		}
	}
}
