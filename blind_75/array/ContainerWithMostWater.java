package blind_75.array;

///[Container with most water](https://leetcode.com/problems/container-with-most-water/description/)
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0, left = 0, right = height.length - 1;

        ///Using Two Pointer Technique
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

}
