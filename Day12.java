import java.util.Stack;
import java.util.Scanner;

public class paranthesis {

    public static boolean check(String s)
    {
        Stack<Character> st= new Stack();

        for(char c: s.toCharArray())
        {
            if(c=='('||c=='['||c=='{')
            {
                st.push(c);
            }

            else{
                if(st.isEmpty()){return false;}

                char top=st.pop();

                if((c==')'&& top!='(') ||
                    (c==']'&& top!='[') ||
                    (c=='}' && top!='{'))
                    {
                        return false;
                    }
            }
        }

        return st.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the input String :");
        String s= sc.nextLine();
        System.out.println("Given String is: "+ check(s));
        
    }
}
 
