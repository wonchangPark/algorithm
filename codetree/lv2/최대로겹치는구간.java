package lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 최대로겹치는구간 {
    static class Panel {
        int start;
        int end;

        public Panel(int start, int end) {
            this.start = OFFSET + start;
            this.end = OFFSET + end;
        }
    }

    static final int MAX = 200;
    static final int OFFSET = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Panel> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Panel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] checked = new int[MAX];
        int ans = 0;
        for(int i=0; i<list.size(); i++) {
            Panel panel = list.get(i);
            for(int j=panel.start; j<panel.end; j++) {
                checked[j]++;
                ans = Math.max(ans, checked[j]);
            }
        }
        System.out.println(ans);
    }
}
