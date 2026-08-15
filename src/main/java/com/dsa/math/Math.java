package com.dsa.math;

public class Math {
    public static boolean isPrime(int num){
        if(num<=1) return false;
        for(int i=2;i<num;i++){
            if(num%i==0) return false;
        }
        return true;
    }

    public static boolean isPrimeNumber(int num){
        if(num<=1) return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }

    public static boolean isEven(int num){
        return num%2 == 0;
    }

    public static int sumOfDigit(int num){
        int sum = 0;
        while(num>0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }

    public static int reverseNumber(int num){
        int reverseNum = 0;
        while(num>0){
            int lastDigit = num%10;
            reverseNum = reverseNum*10 + lastDigit;
            num /= 10;
        }
        return reverseNum;
    }

    public static boolean isPalindrome(int num){
        int actualNum = num;
        int reverseNum = 0;
        while(num>0){
            int lastDigit = num%10;
            reverseNum = reverseNum*10 + lastDigit;
            num /= 10;
        }
        return actualNum == reverseNum;
    }

    public static int factorial(int num){
        int factorial = 1;
        for(int i=num;i>=1;i--){
            factorial *= i;
        }
        return factorial;
    }

    //GCD of two numbers is the largest number that divides both.
    //GCD(a, b) = GCD(b, a % b)
    public static int gcd(int a,int b){
        while(b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //LCM × GCD = a × b
    //It is the smallest number divisible by both numbers.
    public static int lcm(int a,int b){
        return (a*b)/gcd(a,b);
    }

    static void main(String[] args) {
        System.out.println(isPalindrome(1221));
        System.out.println(factorial(5));
        System.out.println(gcd(12,18));
        System.out.println(lcm(12,18));
    }
}
