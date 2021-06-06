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
    
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        /*SinglyLinkedListNode p = head1;
        SinglyLinkedListNode q = head2;
        int data;
        while(p != null) {
            while(q != null) {
                if(q == p){
                    break;
                }
                q = q.next;
            }
            if(q == p)
                break;
            p = p.next;
            q = head2;
        }
        return p.data;*/
        
        SinglyLinkedListNode p = head1;
        SinglyLinkedListNode q = head2;
        
        while(p != q) {        
        if(p.next == null) {
            p = head2;
        } else {
            p = p.next;
        }
           
        if(q.next == null) {
            q = head1;
        } else {
            q = q.next;
        }
    }
    return p.data;
    }

    private static final Scanner scanner = new Scanner(System.in);
