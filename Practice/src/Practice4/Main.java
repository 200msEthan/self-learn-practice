package Practice4;

public class Main {
    public static void main(String[] args) {

        //initialize the frames
        ChooseFrame chooseFrame = new ChooseFrame();
        GameFrame gameFrame = null;
        CPUFrame cpuFrame = null;

        //wait for an option, then dispose of the frame, adding a sleep to fix race condition
        while (chooseFrame.getOutput() == 0) {
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        chooseFrame.dispose();

        //initialize the correct frame depending on which button the player clicks
        if (chooseFrame.getOutput() == 1) {
            gameFrame = new GameFrame();
        } else if (chooseFrame.getOutput() == 2) {
            cpuFrame = new CPUFrame();
        }

        //dispose the frame after the game is closed, adding sleep to fix race condition
        while(true){
            if (gameFrame != null && gameFrame.isGameClosed()) {
                gameFrame.dispose();
                break;
            } else if (cpuFrame != null && cpuFrame.isCpuClosed()) {
                cpuFrame.dispose();
                break;
            }
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
