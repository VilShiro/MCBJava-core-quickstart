package org.fbs.mcb.core.data.client;

import java.util.ArrayList;

public class ClientThreads {

    private final long userId;
    private final ArrayList<ClientThread> threads = new ArrayList<>();

    public ClientThreads(long userId){
        this.userId = userId;
    }

    public void addClientThread(Runnable runnable){
        threads.add(new ClientThread(userId + ""){
            @Override
            public void run() {
                runnable.run();
            }
        });
    }

    public ClientThread get(int i){
        return threads.get(i);
    }

    public long getUserId() {
        return userId;
    }

    public void removeClientThread(ClientThread thread){
        thread.stop();
        threads.remove(thread);
    }

    public void removeClientThread(int i){
        threads.get(i).stop();
        threads.remove(i);
    }

    public void removeAllThreads(){
        for(ClientThread thread : threads){
            thread.stop();
        }
        threads.clear();
    }

    public int size(){
        return threads.size();
    }

}
