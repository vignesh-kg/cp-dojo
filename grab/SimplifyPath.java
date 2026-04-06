import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
	public static void main(String[] args) {
		String path = "/home///user/Documents/.././Pictures/";
		System.out.println(new SimplifyPath().simplifyPath(path));

		path = "/home///user/Documents/.././Pictures";
		System.out.println(new SimplifyPath().simplifyPath(path));

		path = "/home///user/Documents/.././Pictures/..";
		System.out.println(new SimplifyPath().simplifyPath(path));
	}

	public String simplifyPath(String path) {
		Deque<String> stack = new ArrayDeque<>();
        for(String s : path.split("/")){
            if("".equals(s) || ".".equals(s)) continue;
            if ("..".equals(s)) {
                if(!stack.isEmpty()) stack.pollLast();
            } else stack.offerLast(s);
        }
        if(stack.isEmpty()) return "/";
        StringBuilder res = new StringBuilder();
        for(String dir : stack) res.append("/").append(dir);
        return res.toString();
	}
}