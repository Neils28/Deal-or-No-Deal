package deal.Game;

import java.util.Arrays;
import java.util.Random;

public class Case {
	protected int[] casesArray;
	protected double[] doubleValuesArray;

	public int[] getCasesArray() {
		return casesArray;
	}

	public void setCasesArray(int[] casesArray) {
		this.casesArray = casesArray;
	}

	public double[] getDoubleValuesArray() {
		return doubleValuesArray;
	}

	public void setDoubleValuesArray(double[] doubleValuesArray) {
		this.doubleValuesArray = doubleValuesArray;
	}

	public Case() {
		// Initialize the array of integers from 1 to 26
		casesArray = new int[26];
		for (int i = 0; i < 26; i++) {
			casesArray[i] = i + 1;
		}

		// Initialize the array of double values
		double[] doubleValues = { .1, 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000,
				50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000 };
		doubleValuesArray = Arrays.copyOf(doubleValues, doubleValues.length);
	}

	// Method to randomly choose and remove a value from the double values array
	public double chooseRandomValue() {
		if (doubleValuesArray.length == 0) {
			throw new IllegalStateException("Array is empty");
		}

		Random random = new Random();
		int index = random.nextInt(doubleValuesArray.length);
		double chosenValue = doubleValuesArray[index];

		// Remove the chosen value from the array
		doubleValuesArray = removeElement(doubleValuesArray, index);

		return chosenValue;
	}

	// Helper method to remove an element at a specific index from a double array
	private double[] removeElement(double[] array, int index) {
		double[] newArray = new double[array.length - 1];
		System.arraycopy(array, 0, newArray, 0, index);
		System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
		return newArray;
	}

//    public static void main(String[] args) {
//        Case myCase = new Case();
//
//        // Test the chooseRandomValue method
//        for (int i = 0; i < 10; i++) {
//            double chosenValue = myCase.chooseRandomValue();
//            System.out.println("Case Value " + chosenValue);
//        }
//    }
}