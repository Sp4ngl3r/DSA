package array;

///https://leetcode.com/problems/remove-element/description/
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int updatedArrayLength = 0;

        ///Updating the array in-line, by overriding the non-required element.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[updatedArrayLength] = nums[i];
                updatedArrayLength++;
            }
        }

        return updatedArrayLength;
    }
}
