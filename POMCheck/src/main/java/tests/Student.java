package tests;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    private String fullname;
    private String mobile;
    private double mark;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap fullname: ");
        this.fullname = sc.nextLine();
        System.out.print("Nhap mobile: ");
        this.mobile = sc.nextLine();
        System.out.print("Nhap makr: ");
        this.mark = sc.nextDouble();
    }
    public void display(){
        System.out.print(this.fullname +"_"
                +this.mobile+"_"
                +this.mark);
    }
}
