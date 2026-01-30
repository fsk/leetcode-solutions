# ReentrantLock Dokümantasyonu

## Genel Bakış

ReentrantLock, Java'da thread senkronizasyonu için kullanılan bir mekanizmadır. `synchronized` anahtar kelimesine alternatif olarak sunulmuş, daha esnek ve güçlü özelliklere sahip bir lock implementasyonudur.

## Normal Lock (synchronized) Nedir?

Java'da en temel thread senkronizasyon mekanizması `synchronized` anahtar kelimesidir. Bu mekanizma:

- Metod veya kod bloğu seviyesinde çalışır
- Aynı thread'in aynı lock'u birden fazla kez almasına izin verir (reentrant)
- Otomatik olarak lock/unlock yönetimi yapar
- Basit ve kullanımı kolaydır
- Ancak esneklik açısından sınırlıdır

### synchronized Örneği

```java
public synchronized void method1() {
    method2(); // Aynı thread, aynı lock'u tekrar alabilir
}

public synchronized void method2() {
    // İşlemler
}
```

## ReentrantLock Nedir?

ReentrantLock, `java.util.concurrent.locks` paketinde bulunan bir lock implementasyonudur. İsmini "reentrant" (yeniden girebilir) özelliğinden alır. Bu özellik, bir thread'in aynı lock'u birden fazla kez alabilmesine izin verir.

### Temel Özellikler

1. **Reentrant (Yeniden Girebilir)**: Aynı thread, aynı lock'u birden fazla kez alabilir
2. **Manuel Kontrol**: Lock ve unlock işlemleri manuel olarak yönetilir
3. **Fairness (Adalet)**: Fair veya unfair lock modları desteklenir
4. **Condition Desteği**: Condition objeleri ile gelişmiş thread koordinasyonu
5. **Interruptible**: Lock alma işlemi interrupt edilebilir
6. **Timeout Desteği**: Belirli bir süre içinde lock almayı deneme özelliği

## ReentrantLock vs synchronized

### Benzerlikler

- Her ikisi de reentrant özelliğe sahiptir
- Her ikisi de thread-safe işlemler için kullanılır
- Her ikisi de mutual exclusion sağlar

### Farklar

| Özellik | synchronized | ReentrantLock |
|---------|--------------|---------------|
| **Kullanım** | Anahtar kelime (keyword) | Sınıf (class) |
| **Lock Yönetimi** | Otomatik | Manuel |
| **Try Lock** | Yok | Var (tryLock()) |
| **Timeout** | Yok | Var (tryLock(timeout)) |
| **Fairness** | Yok | Var (fair/unfair) |
| **Condition** | wait/notify | Condition objesi |
| **Interrupt** | Sınırlı | Tam destek |
| **Lock Sayısı** | Bilinmez | getHoldCount() |
| **Esneklik** | Düşük | Yüksek |
| **Performans** | Genelde daha hızlı | Biraz daha yavaş |

## Reentrant Özelliği ve Self-Deadlock Önleme

### Problem Senaryosu

Normal bir lock (reentrant olmayan) kullanıldığında, aynı thread'in aynı lock'u tekrar alması durumunda deadlock oluşur:

```java
// Reentrant olmayan bir lock (hipotetik)
public void method1() {
    lock.lock();
    method2(); // Burada deadlock olur!
    lock.unlock();
}

public void method2() {
    lock.lock(); // Aynı thread, aynı lock'u tekrar almayı deniyor
    // İşlemler
    lock.unlock();
}
```

### ReentrantLock Çözümü

ReentrantLock, aynı thread'in aynı lock'u birden fazla kez almasına izin verir:

```java
private final ReentrantLock lock = new ReentrantLock();

public void method1() {
    lock.lock(); // Lock count: 1
    try {
        method2(); // Lock count: 2
    } finally {
        lock.unlock(); // Lock count: 1
    }
}

public void method2() {
    lock.lock(); // Lock count: 2 (aynı thread, aynı lock)
    try {
        // İşlemler
    } finally {
        lock.unlock(); // Lock count: 1
    }
}
```

Her `lock()` çağrısı lock count'u artırır, her `unlock()` çağrısı azaltır. Lock count 0 olduğunda lock serbest bırakılır.

## Hangi Problemleri Çözer?

### 1. Self-Deadlock Önleme

Aynı thread'in nested metod çağrılarında aynı lock'u kullanması gerektiğinde deadlock'u önler.

### 2. Timeout ile Deadlock Önleme

`tryLock(timeout)` ile belirli bir süre içinde lock alınamazsa alternatif yollar denenebilir:

```java
if (lock.tryLock(2, TimeUnit.SECONDS)) {
    try {
        // İşlemler
    } finally {
        lock.unlock();
    }
} else {
    // Alternatif işlemler
}
```

### 3. Non-Blocking Lock Denemesi

`tryLock()` ile lock alınamazsa beklemeden devam edilebilir:

```java
if (lock.tryLock()) {
    try {
        // İşlemler
    } finally {
        lock.unlock();
    }
} else {
    // Lock alınamadı, başka işler yap
}
```

### 4. Fair Lock ile Adil Dağıtım

Fair lock, lock'u bekleyen thread'lere sırayla (FIFO) verir:

```java
ReentrantLock fairLock = new ReentrantLock(true); // Fair lock
```

### 5. Condition ile Gelişmiş Koordinasyon

Condition objeleri ile `wait/notify` mekanizmasından daha esnek thread koordinasyonu:

```java
Condition condition = lock.newCondition();

// Thread 1
lock.lock();
try {
    while (!ready) {
        condition.await();
    }
} finally {
    lock.unlock();
}

// Thread 2
lock.lock();
try {
    ready = true;
    condition.signal();
} finally {
    lock.unlock();
}
```

### 6. Lock Durumu İzleme

Lock'un durumunu izleyebilme:

```java
lock.getHoldCount(); // Lock'un kaç kez alındığı
lock.isLocked(); // Lock şu anda alınmış mı?
lock.isHeldByCurrentThread(); // Mevcut thread lock'a sahip mi?
lock.getQueueLength(); // Lock'u bekleyen thread sayısı
```

## Kullanım Senaryoları

### Ne Zaman ReentrantLock Kullanılmalı?

1. **Timeout gerektiğinde**: Lock almayı belirli bir süre içinde denemek gerektiğinde
2. **Non-blocking işlemler**: Lock alınamazsa beklemeden devam etmek gerektiğinde
3. **Fairness gerektiğinde**: Lock'ların adil dağıtılması gerektiğinde
4. **Condition gerektiğinde**: Birden fazla condition ile gelişmiş koordinasyon gerektiğinde
5. **Lock durumu izleme**: Lock'un durumunu izlemek gerektiğinde
6. **Interrupt handling**: Lock alma işlemini interrupt etmek gerektiğinde

### Ne Zaman synchronized Kullanılmalı?

1. **Basit senkronizasyon**: Basit thread-safe işlemler için
2. **Performans kritik**: Maksimum performans gerektiğinde
3. **Kod basitliği**: Daha basit ve okunabilir kod gerektiğinde
4. **Otomatik yönetim**: Lock/unlock yönetiminin otomatik olması gerektiğinde

## Önemli Notlar

### 1. Mutlaka finally Bloğu Kullanın

Lock'un her durumda serbest bırakılması için `finally` bloğu kullanılmalıdır:

```java
lock.lock();
try {
    // İşlemler
} finally {
    lock.unlock(); // Her durumda unlock yapılır
}
```

### 2. Lock Count Dengesi

Her `lock()` çağrısı için mutlaka bir `unlock()` çağrısı yapılmalıdır. Aksi halde lock serbest bırakılmaz ve diğer thread'ler sonsuza kadar bekler.

### 3. Fair Lock Performansı

Fair lock, unfair lock'a göre daha yavaştır çünkü thread'leri sıraya koyar. Gereksiz yere fair lock kullanmayın.

### 4. Condition Kullanımı

Condition'lar mutlaka lock alındıktan sonra kullanılmalıdır. `await()` çağrısı lock'u otomatik olarak serbest bırakır ve uyandığında tekrar alır.

## Örnek Kullanımlar

Bu klasörde ReentrantLock'un farklı kullanım senaryolarını gösteren 10 örnek bulunmaktadır:

1. **ReentrantLockExample1**: Temel lock/unlock kullanımı
2. **ReentrantLockExample2**: Birden fazla metodda lock kullanımı
3. **ReentrantLockExample3**: tryLock() kullanımı
4. **ReentrantLockExample4**: Reentrant özelliği gösterimi
5. **ReentrantLockExample5**: Fair lock kullanımı
6. **ReentrantLockExample6**: Condition ile kullanım
7. **ReentrantLockExample7**: tryLock(timeout) ile timeout
8. **ReentrantLockExample8**: Nested lock ve getHoldCount()
9. **ReentrantLockExample9**: Producer-Consumer pattern
10. **ReentrantLockExample10**: Gelişmiş thread-safe counter

## Sonuç

ReentrantLock, `synchronized`'a göre daha esnek ve güçlü bir thread senkronizasyon mekanizmasıdır. Özellikle timeout, non-blocking işlemler, fairness ve Condition gerektiren durumlarda tercih edilmelidir. Ancak basit senkronizasyon ihtiyaçları için `synchronized` daha basit ve genelde daha hızlıdır.

Her iki mekanizma da reentrant özelliğe sahiptir ve self-deadlock problemini çözer. Seçim, projenin gereksinimlerine ve kullanım senaryosuna bağlıdır.
