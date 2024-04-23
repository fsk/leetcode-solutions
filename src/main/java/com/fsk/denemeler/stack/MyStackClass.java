package com.fsk.denemeler.stack;

public class MyStackClass<T> {
    private T[] stackArray;
    private int top;

    // Constructor to initialize the stack
    public MyStackClass() {
        stackArray = (T[]) new Object[2]; // Initial size of 2 for example, casting is necessary
        top = -1;
    }

    public boolean isFull() {
        return top == stackArray.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot peek");
            return null;
        }
        return stackArray[top];
    }

    public void push(T item) {
        if (isFull()) {
            resize(2 * stackArray.length); // Double the array size
        }
        /**
         * ++top: İlk olarak, top değişkenini artırır. top, stack'in en üstündeki elemanın indeksini tutar.
         * Stack boşken -1 değerindedir, çünkü dizi (array) indeksleri 0'dan başlar.
         * Bu yüzden, bir eleman eklenmeden
         * önce top'u artırarak, top'un stack'e eklenmek üzere olan yeni eleman için doğru indeksi
         * işaret etmesini sağlarız.
         *
         * stackArray[top] = item; Artırılmış top indeksindeki pozisyona, yani stack'in en
         * üstüne, yeni elemanı (item)
         * yerleştirir. Bu, stack'e bir elemanın eklenmesi işlemini tamamlar.
         */

        stackArray[++top] = item;
    }

    // Method to remove the top item from the stack
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, cannot pop");
            return null; // Changed to return null for an empty stack
        }
        T item = stackArray[top];
        stackArray[top] = null; // Help with garbage collection
        top--;

        /**
         * Stack'in kullanımının, altında yatan dizinin kapasitesinin çeyreğine düştüğünü kontrol eder.
         * Yani, dizinin %25'i kullanılıyor ve geri kalanı boş ise, dizinin boyutunu küçültmeyi düşünürüz.
         */
        if (top > 0 && top == stackArray.length / 4) {
            resize(stackArray.length / 2); // Shrink size if it's much too large
        }
        return item;
    }


    // Utility method to resize the stack's underlying array
    private void resize(int newSize) {
        T[] transferArray = (T[]) new Object[newSize];
        System.arraycopy(stackArray, 0, transferArray, 0, top + 1);
        stackArray = transferArray;
    }

    // Method to check if the stack is full
}
