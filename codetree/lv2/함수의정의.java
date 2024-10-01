package lv2;

public class 함수의정의 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        printStars(sb, 10, 5);
        System.out.println(sb);
    }

    public static void printStars(StringBuilder sb, int width, int height) {
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
    }
}
