import java.util.InputMismatchException;
import java.util.Scanner;
public class Numbers {

	public static void main(String[] args) {
		
		int[] arrayToCheck = createArray(); //Creating an array
		
		try {
			int inconsistentElement = checkArray(arrayToCheck); //Checking the array and return an inconsistent element in the array
		}catch(NullPointerException e) {
			System.out.println("Ни один элемент не нарушает последовательность массива");
		}
		
		for(int i = 0; i < arrayToCheck.length ; i++) {
			
			//Output the array to the console
			
			System.out.print(arrayToCheck[i]+ " ");
		}
		
	}
	
	static int[] createArray() {
		
		//This method creates an array
		
		Scanner console = new Scanner(System.in);
		int number = 0;
		
		do {
			
		//The cycle fulfills the condition that the array must contain at least two elements
			int checkPoint;
			do {
				Scanner console1 = new Scanner(System.in);
				checkPoint = 1;
				try{
					System.out.println("Введите кол-во чисел в массиве(не меньше двух): ");
					number = console1.nextInt();
				}catch(InputMismatchException e) {
					System.out.println("Введите число, а не текст");
					checkPoint = 0;
				}
			}while(checkPoint == 0);
			
		} while(number < 2);
		
		System.out.println("Длинна массива: " + number);
		int[] arr = new int[number];
		
		for(int i = 0; i < arr.length ; i++) {
			
			int checkPoint;
			
			do {
				do {
					checkPoint = 1;
					Scanner console1 = new Scanner(System.in);
					try{
						System.out.println("Введите значение элемента №" + (i+1) + ": ");
						arr[i] = console1.nextInt();
					}catch(InputMismatchException e) {
						System.out.println("Введите число, а не текст");
						checkPoint = 0;
					}
				} while(checkPoint == 0);
				
				checkPoint = 1;
				
				for(int m = 0; m < i; m++) {
					
					//Checking the uniqueness of the element in the array
					
					if(arr[m] == arr[i] ) {
						System.out.println("Все элементы массива должны быть уникальны");
						checkPoint = 0;
						break;
					}
				}
			} while(checkPoint == 0);
		}
		
		return arr;
	}
	
	
	static int checkArray(int[] array) {
		
		//Method for checking an array
		
		int result = 0;
		int checkPoint = 0;
			
		for(int i = 1; i < array.length; i++) {
			
			if (array[i]<array[i-1]) {
				System.out.println("Элемент №" + (i+1) + " = " + array[i] + " первым нарушает последовательность массива");
				result = array[i];
				checkPoint = 1;
				break;
			}
			
		}
		if(checkPoint == 0)
			return (Integer)null;
		
		return result;
		
	}

}
