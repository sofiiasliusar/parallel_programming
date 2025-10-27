package com.ukd.parallel;

public class CheatSheet {
//    private Lock bankLock = new ReentrantLock();
//    public void transfer(){
//        try {
//            bankLock.lock();
//            // критична секція коду
//        } finally {
//            // зняти блокування, навіть у випадку генерації винятку
//            bankLock.unlock();
//        }
//    }

//    public synchronized void transfer() {
//        // критична секція коду
//    }

//    synchronized(bank) {
//        // критична секція коду в якій використовується об’єкт bank
//    }

// Не можливо перервати потік чи вказати час очікування, намагаючись захопити блокування.
}
