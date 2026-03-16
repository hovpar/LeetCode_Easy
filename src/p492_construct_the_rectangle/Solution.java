package p492_construct_the_rectangle;

class Solution {

    public int[] constructRectangle(int area) {
        int width = (int) Math.sqrt(area);

        while (area % width != 0) {
            width--;
        }
        int[] arr = { area / width, width };
        return arr;

    }
}
