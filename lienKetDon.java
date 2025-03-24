/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mangLienKetDon;

import java.util.Scanner;

/**
 *
 * @author hieuvannguyen
 */
//hieu dep trai

class Node {

    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }

    Node(int x, Node t) {
        data = x;
        next = t;
    }

    public String toString() {
        String t = " " + data + "->";
        return t;
    }
}

class Ham {

    Node head;

    public static Scanner sc = new Scanner(System.in);

    public void inp() {
        head = null;
        int x;
        Node cuoi = null;
        while (true) {
            System.out.print("Nhap phan tu (nhap 0 de dung lai): ");
            x = sc.nextInt();
            if (x == 0) {
                break;
            }
            Node t = new Node(x);
            if (head == null) {
                head = cuoi = t;
            } else {
                cuoi.next = t;
                cuoi = t;
            }
        }
    }

    public void outp() {
        Node p = head;
        System.out.println("Noi dung danh sach:");
        while (p != null) {
            System.out.print(p);
            p = p.next;
        }
        System.out.println(" null");
    }

    public void daoDS() {
        Node p = head;
        Node temp = null;
        while (p != null) {
            Node save = p.next;
            p.next = temp;
            temp = p;
            p = save;
        }
        head = temp;
        //    1 2 3 4 
    }

    public void kTraTangDan() {
        Node p = head;
        boolean check = true;
        if (head == null || head.next == null) {
            System.out.println("Mang khong tanng dan !");
            return;
        }
        while (p.next != null) {
            if (p.data > p.next.data) {
                check = false;
                break;
            }
            p = p.next;
        }
        if (check) {
            System.out.println("Mang tang dan");
        } else {
            System.out.println("Mang khong tanng dan !");
        }
    }

    public void xoaPhanTuLe() {
        while (head != null && head.data % 2 != 0) {
            head = head.next;
        }
        if (head == null) {
            return;
        }
        Node p = head;
        while (p.next != null) {
            if (p.next.data % 2 != 0) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
    }

    public void sapXepTangDan() {
        if (head == null) {
            return;
        }
        Node p = head;
        while (p != null) {
            Node q = p.next;
            while (q != null) {
                if (p.data > q.data) {
                    int temp = p.data;
                    p.data = q.data;
                    q.data = temp;
                }

                q = q.next;
            }
            p = p.next;

        }
    }

    public void sapXepGiamDan() {
        if (head == null || head.next == null) {
            System.err.println("Khong the sap xep !");
            return;
        }
        Node p = head;
        while (p != null) {
            Node t = p.next;
            while (t != null) {
                if (p.data < t.data) {
                    int temp = p.data;
                    p.data = t.data;
                    t.data = temp;
                }
                t = t.next;
            }
            p = p.next;
        }
    }

    public void inGiuaDS() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            System.out.println("Vi tri giua danh sach: " + head.next.data);
            return;
        }
        Node slow = head;
        Node fast = head;
        // 1 2 3 4 5 
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Phan tu giua danh sach: " + slow.data);
    }
    
    
}

public class lienKetDon {

    public static void main(String[] args) {
        Ham h = new Ham();
        h.inp();
//        h.daoDS();
//        h.kTraTangDan();
//        h.xoaPhanTuLe();
//        h.sapXepTangDan();
//        h.sapXepGiamDan();
        h.inGiuaDS();
        h.outp();
    }
}
