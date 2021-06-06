import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the mergeLists function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
     static SinglyLinkedListNode recursivemergeLists(SinglyLinkedListNode A, SinglyLinkedListNode B) {
        if(A == null) return B;
        if(B == null) return A;     
        if(A.data <= B.data) {
            A.next = mergeLists(A.next, B);
            return A;
        } else {
            B.next = mergeLists(A, B.next);
            return B;
        }
    }
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        //SinglyLinkedList merged = new SinglyLinkedList();
        SinglyLinkedListNode merged = new SinglyLinkedListNode(0);
        SinglyLinkedListNode tail = merged;
        while(head1!=null && head2!=null) {
            if(head1.data <= head2.data) {
                //merged.insertNode(head1.data);
                tail.next = head1;
                head1 = head1.next;
            } else if(head1.data > head2.data) {
                //merged.insertNode(head2.data);
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        while(head1!=null) {
            //merged.insertNode(head1.data);
            tail.next = head1;
            head1 = head1.next;
            tail = tail.next;
        }
        while(head2!=null) {
            //merged.insertNode(head2.data);
            tail.next = head2;
            head2 = head2.next;
            tail = tail.next;
        }
        //return merged.head;
        return merged.next;
    }

    private static final Scanner scanner = new Scanner(System.in);
