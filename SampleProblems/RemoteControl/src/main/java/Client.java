import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Controller controller = new Controller();
        TV tv = new TV();

        int[] channelList = new int[3];

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < channelList.length; i++) {
                channelList[i] = scanner.nextInt();
            }
        }

        Command turnOnTV = new TurnOnCommand(tv);
        controller.setCommand(turnOnTV);
        controller.executeCommand();

        Command changeChannel;

        for (int j : channelList) {
            Channel channel = new Channel(tv, j);
            changeChannel = new ChangeChannelCommand(channel);
            controller.setCommand(changeChannel);
            controller.executeCommand();
        }

        Command turnOffTV = new TurnOffCommand(tv);
        controller.setCommand(turnOffTV);
        controller.executeCommand();
    }
}

class TV {
    Channel channel;

    void turnOn() {
        System.out.println("Turning on the TV");
        setChannel(new Channel(this, 0));
    }

    void turnOff() {
        System.out.println("Turning off the TV");
    }

    void setChannel(Channel channel) {
        this.channel = channel;
    }

}

class Channel {
    private final TV tv;
    private final int channelNumber;
    Channel(TV tv, int channelNumber) {
        this.tv = tv;
        this.channelNumber = channelNumber;
    }

    void changeChannel() {
        tv.setChannel(this);
        System.out.println("Channel was changed to " + channelNumber);
    }

}

interface Command {
    public void execute();
}

class TurnOnCommand implements Command {
    private final TV tv;

    TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }
}

class TurnOffCommand implements Command {
    private final TV tv;

    TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }
}

class ChangeChannelCommand implements Command {
    private Channel channel;

    public ChangeChannelCommand(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void execute() {
        channel.changeChannel();
    }
}

class Controller {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void executeCommand() {
        command.execute();
    }
}
