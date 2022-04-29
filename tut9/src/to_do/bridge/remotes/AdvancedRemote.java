package to_do.bridge.remotes;

//import tuts.tut9.complete.bridge.devices.Device;

import to_do.bridge.devices.Device;

public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    //TO-DO: Implement the mute() method
    public void mute() {
    	//Display the current volume status is 'mute'
        System.out.println("Current volume status: mute");
        //Set the volume to 0
        device.setVolume(0);
    }
}
