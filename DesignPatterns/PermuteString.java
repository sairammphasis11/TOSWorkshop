package com.company.Workshop;

import com.sun.xml.internal.fastinfoset.util.StringIntMap;

public class PermuteString {

    // Function to print all the permutations of str
    static void printPermutn(String str, String ans,int len)
    {


       String s= stringMan(str,"",len);

    }

    // Driver code
    public static void main(String[] args)
    {
        String s = "aatnacdaa";
        printPermutn(s,"",s.length());

    }
    public static String stringMan(String str, String ans, int len){
        int mismatch=0;// If string is empty


        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);

            // Recurvise call
            if (ros.length() == 0) {
                printPermutn(ros, ans + ch,len);
               /* StringBuilder sb = new StringBuilder(ans);
                String rev= sb.reverse().toString();
                char[] origialStr = ans.toLowerCase().toCharArray();
                char[] revStr = rev.toLowerCase().toCharArray();
                int counter = 0;
                for(int i = 0; i < origialStr.length; i++)
                {
                    if (origialStr[i] != revStr[i])
                    {
                        counter++;
                    }
                }
                // stringMan(ans);
                if(counter>mismatch){
                    mismatch= counter;

                }*/
                System.out.print(ans + " " +mismatch);
           //     return ans;
            }

        }
        if(str.length()==len){

            System.out.println("end  " +str +"   "+mismatch);

        }
        return ""+str.length();
    }