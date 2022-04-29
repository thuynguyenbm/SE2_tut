package to_do.bridge;

//import tuts.tut9.complete.bridge.devices.Device;
//import tuts.tut9.complete.bridge.devices.Radio;
//import tuts.tut9.complete.bridge.devices.Tv;
//import tuts.tut9.complete.bridge.remotes.AdvancedRemote;
//import tuts.tut9.complete.bridge.remotes.BasicRemote;

import to_do.bridge.devices.Device;
import to_do.bridge.devices.Radio;
import to_do.bridge.devices.Tv;
import to_do.bridge.remotes.AdvancedRemote;
import to_do.bridge.remotes.BasicRemote;
import to_do.bridge.remotes.Remote;

public class Demo {
	public static void main(String[] args) {
		testDevice(new Tv());
		testDevice(new Radio());
	}

	//TO-DO: Implement the method testDevice()
	public static void testDevice(Device device) {
		System.out.println("Tests with basic remote.");
		//Create the new BasicRemote instance
		BasicRemote basicRemote = new BasicRemote(device);
		//Power on the device
		 basicRemote.power();
		//Display the status of device
		 device.printStatus();
		System.out.println("Tests with advanced remote.");
		//Create the new AdvancedRemote instance
		AdvancedRemote advancedRemote= new AdvancedRemote(device);
		//Power on the device
		advancedRemote.power();
		//Mute the device
		 advancedRemote.mute();
		//Display the status of device
		device.printStatus();
	}
}
