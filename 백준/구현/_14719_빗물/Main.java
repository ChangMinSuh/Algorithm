package 백준.구현._14719_빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
구현

- 아래서부터 위로 층별로 물이 얼마나 쌓일 수 있는지 검사한다.
    - 현재 층 : nowH
- 물이 쌓이려면 두개의 벽이 필요하다.
    - 따라서 초반에는 벽이 나올때까지 인덱스를 넘긴다.
- 블록의 높이가 현재 층(nowH)보다 작다면 add + 1 해준다.
- 블록의 높이가 현재 층(nowH)보다 크거나 같다면 그동안 모았던 add를 result에 더해준다.
    - 오른쪽 벽을 찾았으므로, 그 층의 빗물은 고일 수 밖에 없다.
    - 오른쪽 벽이 없다면, add 값은 버려진다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // init
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < W; i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        int result = 0;

        // 층별로 누적 가능한 비량을 계산.
        for(int nowH = 1; nowH <= H; nowH++){
            int add = 0;
            int nowW = 0; // 가로로 시작하는 index

            // 초반이기 때문에 왼쪽 벽을 찾아야 한다.
            // 현재 높이보다 블록의 높이가 낮다면 한칸 뒤로 넘김.
            while(nowW < W && arr[nowW] < nowH){
                nowW++;
            }

            for(; nowW < W; nowW++){
                // 블록 높이가 nowH보다 같거나 크다면 쌓아놓은 add를 더해줌.
                if(nowH <= arr[nowW] ) {
                    result += add;
                    add = 0;
                    continue;
                }
                // 블록 높이가 nowH보다 작다면 물이 찰 수 있으므로 add + 1 해줌.
                add++;
            }
        }
        System.out.println(result);
    }
}
