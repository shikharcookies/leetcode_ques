class Solution {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");

        Stack<String> st = new Stack<>();

        for(String dir : directories)
        {
            if(dir.isEmpty() || dir.equals(".")) continue;

            if(dir.equals(".."))
            {
                if(!st.isEmpty())
                {
                    st.pop();
                }
            }
            else
            {
                st.push(dir);
            }
        }
        StringBuilder sb = new StringBuilder();

        for(String res : st)
        {
            sb.append("/").append(res);
        }
        return sb.length()== 0 ? "/" : sb.toString();
    }
}