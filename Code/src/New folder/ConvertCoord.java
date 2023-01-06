package tools;

public class ConvertCoord {
    public static int convert(int x, int y){
        return (x+1) + y*4;
    }

    public static int[] convert(int i){
        int x, y; 
        y = (i%4)-1;
        y = (y == -1) ? 4 : y;
        i -= y;
        x = i /4;
        return new int[] {x, y};
    }
}
