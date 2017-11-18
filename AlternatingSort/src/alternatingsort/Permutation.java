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
public class Permutation {

    int alternatingCounter = 0;

    /**
     * Keeps track of the number of alternating sorts.
     *
     * @return return how many alternating sorts are there.
     */
    public int alternatingSortCounter() {
        return alternatingCounter++;
    }

    
    /**
     *Prints the array
     * @param array
     */
    public void printArray(int[] array) {
        System.out.print("These are the alternating sorts of {");
        for (int x = 0; x < array.length; x++) {
            System.out.print(array[x] + " ");
        }
        System.out.print("}");
        System.out.println();
    }

    /**
     *Prints the total number of sorts
     */
    public void printTotalSort() {
        System.out.println("There are " + alternatingSortCounter() + " alternating sorts. ");

        System.out.println();
    }

    /**
     * This method does a permutation recursion to find all the possible
     * solutions to arrange the integer in the array. it will then use
     * alternating sort to find the correct format where c1 < c2 > c3 < c4 >
     * c5...
     *
     * @param array The array
     * @param start The starting index
     * @param size the size of the array
     */
    public void singlePermutation(int[] array, int start, int size) {
        if (start == size) {
            //This for loop is testing only the even indexes, starting with index 0. 
            //It will transverse through the array, comparing the previous and after indexes
            //to the current index. 
            for (int currentIndex = 0; currentIndex < array.length; currentIndex += 2) {
                if (currentIndex > 0 && array[currentIndex] > array[currentIndex - 1]) {
                    return;
                }
                if (currentIndex < array.length - 1 && array[currentIndex] > array[currentIndex + 1]) {
                    return;
                }
            }//end of for loop

            //the for loop will printArray out the array along with the correct sign 
            for (int x = 0; x < array.length; x++) {
                System.out.print(array[x]);

                if (x % 2 == 0 && x < array.length - 1) { //if index is even, then "<" is output to console
                    System.out.print(" < ");
                } else if (x < array.length - 1) { //if x is odd, then ">" is output to console
                    System.out.print(" > ");
                }
            }
            System.out.println();
            alternatingSortCounter(); //keeps track how many alternating sort there is 
            return;
        }

        //this for loop will do a recusive to find all permutations for the array
        for (int x = start; x < array.length; x++) {
            int temp = array[start];
            array[start] = array[x];
            array[x] = temp;

            singlePermutation(array, start + 1, size);

            temp = array[start];
            array[start] = array[x];
            array[x] = temp;
        }

    }

}
