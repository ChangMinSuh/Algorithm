import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        while(T-- > 0){
            String cmd = br.readLine().trim();
            String[] cmdArr = cmd.split(" ");

            switch(cmdArr[0]){
                case "push":
                    stack.push(Integer.parseInt(cmdArr[1]));
                    break;
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case"size":
                    sb.append(stack.size()).append("\n");
                    break;
                case"empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case"top":
                    sb.append(stack.top()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}

class Stack {
    private ArrayList<Integer> data = new ArrayList<>();

    public void push(int inputN){
        data.add(inputN);
    }

    public int pop(){
        if(data.size() < 1) return -1;
        return data.remove(data.size() - 1);
    }

    public int size() {
        return data.size();
    }

    public int empty(){
        return data.size() < 1  ? 1 : 0;
    }

    public int top(){
        if(data.size() < 1) return -1;
        return data.get(data.size() - 1);
    }
}
