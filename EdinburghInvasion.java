package edinburgh;
import robocode.*;
import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * EdinburghInvasion - a robot by (your name here)
 */
public class EdinburghInvasion extends Robot
{
	boolean isRed = false;
	boolean	isGunRotated = false;
	boolean isHunting = false;
	/**
	 * run: EdinburghInvasion's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		turnLeft(getHeading());

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		turnGunLeft(90);
		isGunRotated = true;
		// Robot main loop
		justWalkAround();
		
	}
	
	public void justWalkAround()
	{
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			ahead(2000);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		huntRobotDown (e);
		
		
	}
	
	public void huntRobotDown (ScannedRobotEvent e)
	{
		isHunting = true;
		flipColors ();
		turnLeft(getHeading() - e.getBearing());
		if (isGunRotated)
		{
			fire(1);
			ahead(100);
			turnGunRight(90);
			isGunRotated = false;
		}
		ahead(100);
		
	}
	
	public void flipColors ()
	{
		if (isRed)
		{
			setColors(Color.blue,Color.blue,Color.blue);
			isRed = false;
		}
		else
		{
			setColors(Color.red,Color.red,Color.red);
			isRed = true;
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		//back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
		turnRadarLeft(180);
		turnRadarRight(180);
		turnLeft(90);
		
	}	
}
