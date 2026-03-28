public class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] arr = new char[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = (char)('a' - 1);
        }   
        char current = 'a';
        for(int i = 0; i < n; i ++) {
            if(arr[i] >= 'a') {
                continue;
            }
            if(current > 'z') {
                return "";
            }
            arr[i] = current;
            for(int j = i + 1; j < n; j ++) {
                int length = lcp[i][j];
                if(j + length > n) {
                    return "";
                }
                if(length > 0) {
                    arr[j] = current;
                }
                
            }
            current += 1;
        }
        for(int i = n - 1;i >= 0; i--)  {
            for(int j = n - 1; j >= 0; j --) {
                if(arr[i] != arr[j]) {
                    if(lcp[i][j] != 0) {
                        return "";
                    }
                } else if((j == n - 1 || i == n - 1) && lcp[i][j] != 1) {
                        return "";
                } else if(lcp[i][j] != lcp[i + 1][j + 1] + 1){
                    return "";
                }
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        int[][] lcp = new int[][]{
            // {1}
            // {4,0,2,0},{0,3,0,1},{2,0,2,0},{0,1,0,1}
            // {4,3,2,1},{3,3,2,1},{2,2,2,1},{1,1,1,3}
            // {4,3,2,1},{3,3,2,1},{2,2,2,1},{1,1,1,1}
            
        };
        Solution test =new Solution();
        String result = test.findTheString(lcp);
        System.out.println(result);
        System.out.println("finish");
    }
}
