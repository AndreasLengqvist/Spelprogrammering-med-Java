package model;

public interface IRocketObserver {
	void doExplode(float centerX, float centerY);
	void doAlive(float centerX, float centerY);
	void doDestroyLeftWing();
	void doDestroyRightWing();
	void doSendOutRepairKit();
	void doRepairShip();
}
