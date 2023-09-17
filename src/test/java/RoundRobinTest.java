import org.dj.Process;
import org.dj.RoundRobin;
import org.junit.jupiter.api.Test;

public class RoundRobinTest {

    int minPrio = 0;
    int maxPrio = 8;

    int minQuantum = 1;
    int maxQuantum = 100;


    @Test
    public void testOrderProcessByPriorityAndDate() {

        Process[] processes = new Process[50];

        for (int i = 0; i < processes.length; i++) {

            processes[i] = new Process(
                    "Process_" + i+".exe",
                    (int) (Math.random() * (maxQuantum - minQuantum + 1) + minQuantum),
                    (int) (Math.random() * (maxPrio - minPrio + 1) + minPrio), i
            );

        }

        RoundRobin roundRobin = new RoundRobin(processes);

        roundRobin.orderProcessByPriorityAndDate();

        Process[] ordererProcess = roundRobin.getProcesses();

        for (int i = 0; i < ordererProcess.length - 1; i++) {
            if (ordererProcess[i].getPriority() > ordererProcess[i + 1].getPriority()) {
                assert false;
            } else assert ordererProcess[i].getPriority() != ordererProcess[i + 1].getPriority() ||
                    !ordererProcess[i].getUpdatedAt().after(ordererProcess[i + 1].getUpdatedAt());
        }


    }

    @Test
    public void testCheckCurrentRemProcesses(){

        Process[] processes = new Process[50];

        for (int i = 0; i < processes.length; i++) {

            processes[i] = new Process(
                    "Process_" + i+".exe",
                    (int) (Math.random() * (maxQuantum - minQuantum + 1) + minQuantum),
                    (int) (Math.random() * (maxPrio - minPrio + 1) + minPrio), i
            );

        }

        RoundRobin roundRobin = new RoundRobin(processes);

        roundRobin.orderProcessByPriorityAndDate();

        int remProcess = roundRobin.checkCurrentRemProcesses();

        Process[] orderProcess = roundRobin.getProcesses();

        int countRemProcess = 0;

        int currentPriority = processes[0].getPriority();

        for (int i = 0; i < processes.length; i++) {

            if (processes[i].getPriority() == currentPriority) {
                countRemProcess++;
            } else {
                i = processes.length+10;
            }

        }


        assert remProcess == countRemProcess;




    }

    @Test void  testRun() {

        Process[] processes = new Process[50];

        for (int i = 0; i < processes.length; i++) {

            processes[i] = new Process(
                    "Process_" + i + ".exe",
                    (int) (Math.random() * (maxQuantum - minQuantum + 1) + minQuantum),
                    (int) (Math.random() * (maxPrio - minPrio + 1) + minPrio), i
            );

        }

        RoundRobin roundRobin = new RoundRobin(processes);

        roundRobin.run();

        Process[] allProcess = roundRobin.getProcesses();

        for (Process process:
             allProcess) {

            assert process.getQuantum() <= 0;
        }

    }



}
