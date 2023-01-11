import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Store{
        int r;
        int c;

        public Store(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() { return r; }
        public void setR(int r) { this.r = r; }
        public int getC() { return c; }
        public void setC(int c) { this.c = c; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            int n = Integer.parseInt(br.readLine()); // 편의점 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int homeR = Integer.parseInt(st.nextToken()) + 32768; // 상근이네 집
            int homeC = Integer.parseInt(st.nextToken()) + 32768;
            Store[] stores = new Store[n];
            for (int i = 0; i < n; i++) { // 편의점
                st = new StringTokenizer(br.readLine());
                stores[i] = new Store(Integer.parseInt(st.nextToken()) + 32768, Integer.parseInt(st.nextToken()) + 32768);
            }
            st = new StringTokenizer(br.readLine());
            int festivalR = Integer.parseInt(st.nextToken()) + 32768; // 목적지
            int festivalC = Integer.parseInt(st.nextToken()) + 32768; // 목적지

            // 집에서 페스티벌로 바로 가능한지 체크
            int dist = (Math.abs(festivalR-homeR)) + (Math.abs(festivalC-homeC));
            if(dist <= 50*20){
                sb.append("happy").append("\n");
                continue;
            }

            // 집에서 편의점들을 들리는 경우
            boolean isSuccess = dfs(stores, new boolean[n], homeR, homeC, festivalR, festivalC);
            if(isSuccess){
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }
            isSuccess = false;

        }

        System.out.println(sb);
    }

    public static boolean dfs(Store[] stores, boolean[] check, int nowR, int nowC, int festivalR, int festivalC){
        // 기저 조건 : 목적지에 다다르면 true를 리턴
        if((Math.abs(festivalR-nowR) + Math.abs(festivalC-nowC)) <= 50*20 ){
            return true;
        }

        for(int i=0; i<stores.length; i++){
            if(check[i]) continue;
            if((Math.abs(stores[i].getR()-nowR)+Math.abs(stores[i].getC()-nowC)) <= 20*50){
                check[i] = true;
                if(dfs(stores, check, stores[i].getR(), stores[i].getC(), festivalR, festivalC)){return true;}
  
            }
        }
        
        return false;

    }
}
