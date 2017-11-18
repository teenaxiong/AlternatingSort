/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alternatingsort;

/**
 *
 * @author teena
 */
public class DoublePermutation extends Permutation{
    
      /**
     *Prints the array
     * @param array
     */
    @Override
    public void printArray(int[] array) {
        System.out.print("These are the double alternating sorts of {");
        for (int x = 0; x < array.length; x++) {
            System.out.print(array[x] + " ");
        }
        System.out.print("}");
        System.out.println();
    } 

    /**
     * This method does a permutation recursion to find all the possible solutions to arrange the integer in the array. 
     * it will then use alternating sort to find the correct format where c1 < c2 < c3 > c4 > c5 < c6 < c7 > ...cn
     * @param array The array
     * @param start The starting index 
     * @param size the size of the array
     */
    public void doublePermutation(int[] array, int start, int size) {
        boolean pointTrue = true;
        int firstCounter = 2;
        int secondCounter = 0;
            
        if (start == size) {
            
            //This for loop is testing only the even indexes, starting with index 0. 
            //It will transverse through the array, comparing the previous and after indexes
            //to the current index. 
            for (int currentIndex = 0; currentIndex < array.length; currentIndex += 2) {
                
                if (pointTrue) { //this if statement will start with index 0, and every 4th index after it
                    if (currentIndex > 0 && array[currentIndex] > array[currentIndex - 1]) { 
                        return;
                    }
                    if (currentIndex < array.length - 1 && array[currentIndex] > array[currentIndex + 1]) {
                        return;
                    }
                }//end of if statement

                if (pointTrue == false) { //this if statemen will start with index 2, and even 4th index after it
                    if (currentIndex > 0 && array[currentIndex] < array[currentIndex - 1]) {
                        return;
                    }
                    if (currentIndex < array.length - 1 && array[currentIndex] < array[currentIndex + 1]) {
                        return;
                    }
                }//end of if statement
                pointTrue = !pointTrue; //changing boolean value to the next true/false value
            }//end of for loop
          
            //the for loop will printArray out the array elements along with the correct sign
            for (int x = 0; x < array.length; x++) {
                System.out.print(array[x]);

                //the "<" is printed as long as the firstCounter is greater than 0
                if (firstCounter > 0 && x < array.length - 1) {
                    System.out.print(" < ");
                    firstCounter--; 
                    
                } else if (x < array.length - 1) { //if firstCounter is < 0, then we start printing the "<" for next elements
                    System.out.print(" > ");
                    secondCounter++; 
                    
                    //resetting the firstCounter back to 2 if secondCounter is equal to 2. 
                    if (secondCounter == 2) {
                        firstCounter = 2;
                    }//end of if
                }//end of else if
            }//end of for loop
            System.out.println();
            alternatingSortCounter(); //this counter keeps track of how many total number of alternating sort
            return;

        }

        //this for loop will do a recusive to find all permutations for the array
        for (int x = start; x < array.length; x++) {
            int temp = array[start];
            array[start] = array[x];
            array[x] = temp;

            doublePermutation(array, start + 1, size);

            temp = array[start];
            array[start] = array[x];
            array[x] = temp;
        }

    }

}
