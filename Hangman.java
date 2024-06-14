import java.util.*;
public class hangman{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the string you want player to find : ");
        String givenString=sc.next();
        System.out.println();
        int n=givenString.length();
        char given[]=givenString.toCharArray();
        char[] tofind= new char[n];
        
        for(int i=0;i<n;i++){
            tofind[i]='*';
        }
        int attempt=0;
        int flag=-1;
        while(flag!=1){
            flag=-1;
            int check=0;
            int wordcount=0;
            System.out.print("Enter your guessed character : ");
            char x=sc.next().charAt(0);
            for(int i=0;i<n;i++){
                if(given[i]==x && tofind[i]=='*'){
                    
                    tofind[i]=x;
                    wordcount++;
                }
                else if(tofind[i]!='*' && tofind[i]==x){
                    check=1;
                    break;
                }
            }
            if(wordcount>=1){
                attempt++;
                System.out.println("The total number of "+x+" in the word to be guessed is "+wordcount+".");
                System.out.print("The word you have guessed until now is: ");
                for(int i=0;i<n;i++){
                    System.out.print(tofind[i]);
                }
                System.out.println();
            }
            else if(check==0){
                attempt++;
                System.out.println("No such letter is there in the word.");
            }
            else if(check==1){
                System.out.println("You have guessed this letter already.");
            }
            for(int i=0;i<n;i++){
                if(given[i]!=tofind[i]){
                    flag=0;
                    break;
                }
            }
            if(flag==-1){
                flag=1;
            }
        }
        System.out.println(attempt);
    }
}
