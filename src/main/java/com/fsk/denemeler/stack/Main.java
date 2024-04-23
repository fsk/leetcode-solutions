package com.fsk.denemeler.stack;

public class Main {
    public static void main(String[] args) {
        MyStackClass<Integer> stack = new MyStackClass<>();

        // Elemanları stack'e ekleyelim
        stack.push(10);
        stack.push(20);
        System.out.println("Peek after 2 pushes: " + stack.peek()); // Son eklenen elemanı gösterir

        stack.push(30);
        stack.push(40);
        stack.push(50); // Bu noktada, stack otomatik olarak yeniden boyutlandırılacak

        System.out.println("Peek after more pushes: " + stack.peek()); // Son eklenen eleman

        // Stack'ten birkaç eleman çıkaralım
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        // Stack'in mevcut durumunu kontrol edelim
        System.out.println("Peek after pops: " + stack.peek());

        // Ekstra: Stack'i tamamen boşaltalım ve her adımda elemanları görelim
        while (!stack.isEmpty()) {
            System.out.println("Popping: " + stack.pop());
        }

        // Stack boş olduğunda bir eleman çıkarmayı deneyelim
        System.out.println("Trying to pop from empty stack: ");
        stack.pop(); // Bu, "Stack is empty, cannot pop" mesajını gösterecek
    }
}

