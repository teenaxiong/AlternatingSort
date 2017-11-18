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
public class AlternatingSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] firstArray = {1, 2, 3, 4};
        int size = firstArray.length;

        Permutation singleObject = new Permutation();
        singleObject.printArray(firstArray);
        singleObject.singlePermutation(firstArray, 0, size);
        singleObject.printTotalSort();
   
        DoublePermutation doubleObject = new DoublePermutation();
        doubleObject.printArray(firstArray);
        doubleObject.doublePermutation(firstArray, 0, size);
        doubleObject.printTotalSort();
        
        
        ///testing new set of array with more n values
        int [] secondArray = {1, 2, 3, 4, 5, 6, 7};
        size = secondArray.length; 
        
        singleObject.printArray(secondArray);
        singleObject.singlePermutation(secondArray, 0, size);
        singleObject.printTotalSort();
        
        doubleObject.printArray(secondArray);
        doubleObject.doublePermutation(secondArray, 0, size);
        doubleObject.printTotalSort();
    }

}
