package DesignPatterns.BehavioralPatterns.StrategyPattern;

interface callStrategy {
    void makeCall();
}

class callService {
    private callStrategy callStrategy;

    public void setCallStrategy(callStrategy callStrategy) {
        this.callStrategy = callStrategy;
    }

    public void makeCall() {
        callStrategy.makeCall();
    }
}

class VoiceCall implements callStrategy {
    @Override
    public void makeCall() {
        System.out.println("Making a standard Voice Call...");
    }
}

class VideoCall implements callStrategy {
    @Override
    public void makeCall() {
        System.out.println("Making a Video Call...");
    }
}

class WifiCall implements callStrategy {
    @Override
    public void makeCall() {
        System.out.println("Making a Call over Wi-Fi...");
    }

}

public class StrategyPatternExampleTwo {
    public static void main(String[] args) {
        callService callService = new callService();

        callService.setCallStrategy(new VoiceCall());
        callService.makeCall();

        callService.setCallStrategy(new VideoCall());
        callService.makeCall();

        callService.setCallStrategy(new WifiCall());
        callService.makeCall();
    }
}
