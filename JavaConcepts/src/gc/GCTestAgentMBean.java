package gc;

//Mbean Interface
public interface GCTestAgentMBean {
    void newThread(String threadName);
    void newCollectableObject(int size);
    void newLeakedObject(int size);
    void clearLeaked();
    void cpuIntensiveOperation(int iterations);
}

