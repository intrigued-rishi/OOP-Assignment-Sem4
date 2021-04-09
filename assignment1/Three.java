package assignment1;

import java.util.*;
import java.lang.*;

/*

    Write a program Parentheses.java that reads in a text stream from standard input and uses a stack to determine
    whether or not its parentheses are properly balanced. For example, your program should print true for
    [()]{}{[()()]()} and false for [(]). You need to implement the stack class by yourself.

*/ 



class Stack{
    private char arr[]=new char[100];   //character array to store the values in the stack
    private int size;
    public Stack(){      //constructor
        size=0;
    }
    public void push(char x){     //function for pushing into the stack
        if(size==100){
            System.out.println("Stack Overflow");
            return;
        }
        arr[size]=x;
        size++;
    }
    public void pop(){   //function for popping last entered element
        if(size==0){
            System.out.println("Stack Underflow");
            return;
        }
        size--;
    }
    public char top(){     //returning last entered element
        if(size==0){
            System.out.println("Stack Underflow");
            return '\0';
        }
        return arr[size-1];
    }
    public int size(){   //returns size
        return size;
    }
}

class Three{
    public static void main(String args[]){
        Scanner myObj = new Scanner(System.in);
        int x;
        String s;
        do{
            System.out.println("Enter parenthesis:");
            s = myObj.nextLine();   //reading parenthesis
            Stack st = new Stack();
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(st.size()==0){    //if stack is empty pushing the element
                    st.push(c);
                }else{                   //if last pushed element is equal to this element of the string then the last one is popped as both combine as a pair
                    char c_t=st.top();
                    if(c_t=='{'&&c=='}'){
                        st.pop();
                    }else if(c_t=='('&&c==')'){
                        st.pop();
                    }else if(c_t=='['&&c==']'){
                        st.pop();
                    }
                    else{
                        st.push(c);          //if not equal it is simply pushed into the stack
                    }
                }
            }
            if(st.size()==0){
                System.out.println("Parenthesis is Valid!");
            }else{
                System.out.println("Parenthesis is InValid!");   
            }
            System.out.println("Do you want to test again?1-->YES, 0-->NO");
            x=myObj.nextInt();
            myObj.nextLine();
        }while(x>0);
    }
}