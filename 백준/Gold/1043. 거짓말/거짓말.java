import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 진실을 아는 사람들과 그들과 같은 파티에 참석하는 사람들을 같은 집합으로 만든다.
        // 그리고 이 집합에 들어있지 않은 사람들로만 만들어져있는 파티가 과장된 이야기를 할 수 있는 파티이다.

        String[] words = br.readLine().split(" ");
        int N = Integer.parseInt(words[0]); // 사람의 수
        int M = Integer.parseInt(words[1]); // 파티의 수

        Set<Integer> peopleWhoKnowTruth = new HashSet<>();
        String[] temp = br.readLine().split(" ");
        if(temp.length == 1){
            // 0명이므로 그냥 참석하는 모든 파티의 수가 답이다.
            for(int i=0; i<M; i++){
                br.readLine();
            }
            System.out.println(M);
            return;
        }

        int n = Integer.parseInt(temp[0]); // 진실을 아는 사람들의 수
        for(int i=1; i<=n; i++){
            peopleWhoKnowTruth.add(Integer.parseInt(temp[i]));
        }

        List<List<Integer>> parties = new ArrayList<>();
        for(int i=0; i<M; i++){
            String[] temp2 = br.readLine().split(" ");
            int nn = Integer.parseInt(temp2[0]); // 해당 파티의 사람수
            parties.add(new ArrayList<>());
            List<Integer> party = parties.get(i);
            for(int j=1; j<=nn; j++){
                party.add(Integer.parseInt(temp2[j]));
            }
        } // party의 값들을 전부 넣었다.

        boolean[] check = new boolean[M];
        for(int i=0; i<M; i++){
            z : for(int j=0; j<M; j++){
                if(check[j]) continue;
                List<Integer> party = parties.get(j);
                for(Integer num : party){
                    if(peopleWhoKnowTruth.contains(num)){
                        peopleWhoKnowTruth.addAll(party);
                        check[j] = true;
                        break z;
                    }
                }

            }
        }

        int cnt = 0;
        for(int i=0; i<M; i++){
            if(!check[i]) cnt++;
        }

        System.out.println(cnt);


        // 그냥 m번 안에 m번 반복을 해야 하는 게 제일 나은 방법인듯



    }
}
