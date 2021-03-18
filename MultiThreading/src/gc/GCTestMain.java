package gc;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class GCTestMain {
    private static void init(){
        MBeanServer mbs = null ;
        mbs= ManagementFactory.getPlatformMBeanServer();
        GCTestAgent agent = new GCTestAgent();
        ObjectName agentName;
        try {
            agentName = new ObjectName("TESTBEANSERVER:name=GCTESTAGENT");
            mbs.registerMBean(agent,agentName);

        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        init();
        for (;;) {
            Thread.sleep(1000);
        }
    }
}
