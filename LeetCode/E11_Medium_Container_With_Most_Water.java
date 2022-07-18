public class E11_Medium_Container_With_Most_Water {
    public int maxArea(int[] height) {

        int max = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {

            max = Math.max(max, (r - l) * Math.min(height[l], height[r]));

            if (height[l] > height[r]) {
                r--;
            }else{
                l++;
            }

        }

        return max;

    }
}
