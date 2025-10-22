import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        //Q1 all the longest word in a given array.
        System.out.println("Q1 all longest words");
        String[] words = { "cat", "dog", "red", "is", "am"};
        System.out.println("original array is: " + Arrays.toString(words));
        System.out.println("the longest words are: " + longestWords(words));
        System.out.println("\n========================================================================================\n");


        //Q2 number of occurrence of an element
        int[] nums = {1, 1, 1, 3, 3, 5};
        System.out.println("The array: " + Arrays.toString(nums));
        System.out.print("Enter a number to display it's occurrence: ");
        int targetNumber = in.nextInt();
        System.out.println(targetNumber + " occurs " + occurrenceOf(targetNumber,nums) + " times. ");
        System.out.println("\n========================================================================================\n");


        //Question3 ---------------------------------------------------------------------------
        ArrayList<Integer> originalNums = new ArrayList<>();
        originalNums.add(1);
        originalNums.add(4);
        originalNums.add(17);
        originalNums.add(7);
        originalNums.add(25);
        originalNums.add(3);
        originalNums.add(100);

        System.out.println("The array is: " + originalNums );
        System.out.print("Enter the number of largest that you want to show:");
        int kToShow = in.nextInt();
        ArrayList<Integer> largest = largest(originalNums, kToShow);
        System.out.println(largest != null ? ("These are the largest numbers: " + largest) : "invalid input");
        System.out.println("\n========================================================================================\n");


        //Question4 -----------------
        int[] numToReverse = {5, 4, 3, 2, 1};
        System.out.println("This is the reversed array:");
        printReverse(numToReverse);
        System.out.println("\n========================================================================================\n");


        //Question5 -----------------
        System.out.print("enter the size for the array: ");
        Integer[] numbers = new Integer[in.nextInt()];
        int pointer = 0;
        int choice = 0;
        while (choice != 5){
            System.out.print("1- add element to the array\n" +
                    "2- display elements of the array\n" +
                    "3- search an element within the array\n" +
                    "4- sort the array\n" +
                    "5- stop\n" +
                    "Choose from the above menu: ");

            choice = in.nextInt();
            if (choice >5 || choice < 1){
                System.out.println("invalid choice");
            }
            else {
                switch (choice){
                    case 1 -> {
                        if(pointer == numbers.length){
                            System.out.println("Sorry the array is full");
                        } else {
                            System.out.println("Enter the element to add: ");
                            numbers[pointer] = in.nextInt();
                            pointer ++;
                        }
                    }
                    case 2 -> {
                        for(int i = 0; i<pointer; i++){
                            System.out.print(numbers[i] + " ");
                        }
                        System.out.println();
                    }
                    case 3 -> {
                        System.out.println("Enter the element that you want to search about: ");
                        int result = searchOfElement(in.nextInt(), numbers);
                        if (result == -1){
                            System.out.println("not found element");
                        }
                        else {
                            System.out.println("the index of this element is: " + result);
                        }
                    }
                    case 4 -> {
                        System.out.println("sorted array is: " + largest(new ArrayList<>(Arrays.asList(numbers)),pointer));
                    }
                }
            }

        }
        System.out.println("\n========================================================================================\n");


        //Question6 --------------
        System.out.print("Enter the minimum value of the range of random: ");
        int minBoundary = in.nextInt();
        System.out.print("Enter the maximum value of the range:");
        int maxBoundary = in.nextInt();
        System.out.print("Enter the number of random number generated:");
        int noPrinting = in.nextInt();
        System.out.println("The generated numbers are: ");
        for(int i = 0; i<noPrinting; i++){
            System.out.print(random(minBoundary,maxBoundary) + " ");
        }
        System.out.println("\n========================================================================================\n");


        //Question7--------------------------------
        System.out.println("Enter a password to check it: ");
        in.nextLine();
        checkPassword(in.nextLine());
        System.out.println("\n========================================================================================\n");


        //Question8-------------------------------------------
        System.out.print("Enter the number of fibonacci terms to generate: ");
        fibonacci(in.nextInt());
        System.out.println("\n========================================================================================\n");

    }

    public static ArrayList<String> longestWords(String[] words){
        ArrayList<String> longestWords = new ArrayList<>();
        longestWords.add(words[0]);
        for(int i = 1; i<words.length; i++){
            int longestLength = longestWords.getFirst().length();
            if(words[i].length() > longestLength){
                longestWords = new ArrayList<>();
                longestWords.add(words[i]);
            } else if (words[i].length() == longestLength) {
                longestWords.add(words[i]);
            }
        }
        return longestWords;
    }

    public static int occurrenceOf(int target, int[] nums){
        int occurrence = 0;
        for(int num : nums){
            if (num == target){
                occurrence++;
            }
        }
        return occurrence;
    }

    public static ArrayList<Integer> largest(ArrayList<Integer> nums, int noNewElements){
        if(noNewElements <= nums.size() && noNewElements > 0) {
            ArrayList<Integer> copyOfNums = new ArrayList<>(nums);
            ArrayList<Integer> largest = new ArrayList<>();


            for (int i = 0; i < noNewElements; i++) {
                int max = copyOfNums.getFirst();
                int maxIndex = 0;
                for (int j = 1; j < copyOfNums.size(); j++) {
                    if (copyOfNums.get(j)!=null && copyOfNums.get(j) > max) {
                        max = copyOfNums.get(j);
                        maxIndex = j;
                    }
                }
                copyOfNums.remove(maxIndex);
                largest.add(max);
            }
            return largest;
        }
        else {
            return null;
        }
    }

    public static void printReverse(int[] nums){
        for(int i = nums.length-1; i>=0; i--){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static int searchOfElement(int target, Integer[] nums){
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == null)
                return -1;
            if(target == nums[i])
                return i;
        }
        return -1;
    }

    public static int random(int min, int max){
        Random rand = new Random();
        int n = rand.nextInt(max-min);
        return n;
    }

    public static void checkPassword(String password){
        int score = 0;

        if(password.length() > 5 && password.length() <= 7){
            score += 2;
        } else if(password.length() > 7){
            score += 3;
        }

        boolean hasSpecialChar = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        for (char c : password.toCharArray()){
            if(!Character.isLetterOrDigit(c))
                hasSpecialChar =  true;
            else if (Character.isUpperCase(c)){
                hasUpperCase = true;
            }
            else if (Character.isLowerCase(c)){
                hasLowerCase = true;
            }
        }

        if(hasSpecialChar)
            score += 2;
        if (hasLowerCase && hasUpperCase){
            score += 3;
        }

        System.out.print("Password is ");
        if(score > 7){
            System.out.println("strong.");
        } else if (score > 4) {
            System.out.println("moderately strong.");
        } else {
            System.out.println("week.");
        }
    }

    public static void fibonacci(int t){
        if(t < 1){
            System.out.println("invalid input");
        } else if (t == 1) {
            System.out.println("0, 1");
        } else {
            int[] fibonacci = new int[t];
            fibonacci[0] = 0;
            fibonacci[1] = 1;
            for (int i = 2; i < fibonacci.length; i++) {
                fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
            }

            System.out.println("fibonacci sequence with " + t + " terms :");
            for(int num : fibonacci){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
