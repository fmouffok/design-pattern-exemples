package fr.km.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockService {

    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();
    // data base  cache exemple
    Map<String, Object> cache = new HashMap<>();

    // put() method only one thread put a new (key-value) in same time
    public void put (String key, Object value){
        try{
            writeLock.lock();
            cache.put(key, value);
        }
        finally {
            writeLock.unlock();
        }
    }

    //get() method is thread safe
    // many threads in same time can get a values from map
    public void get (String key){
        try{
            readLock.lock();
            cache.get(key);
        }
        finally {
            readLock.unlock();
        }
    }

}
