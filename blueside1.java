package org.firstinspires.ftc.robotcontroller.external.samples;

        import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
        import com.qualcomm.robotcore.eventloop.opmode.Disabled;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.hardware.LightSensor;
        import com.qualcomm.robotcore.util.ElapsedTime;
        import com.qualcomm.robotcore.hardware.ColorSensor;
        import android.graphics.Color;
/**
 * Created by advaitmarathe on 1/29/17.
 */

public class blueside1 extends LinearOpMode {
    HardwareK9bot         robot   = new HardwareK9bot();   // Use a Pushbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();
    static final double     FORWARD_SPEED = 0.6;
    static final double     TURN_SPEED    = 0.5;
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        float hsvValues[] = {0F,0F,0F};
        final float values[] = hsvValues;
        robot.colorSensor.enableLed(false);
        Color.RGBToHSV(robot.colorSensor.red() * 8, robot.colorSensor.green() * 8, robot.colorSensor.blue() * 8 , hsvValues);
        robot.top.scaleRange(0,1);


        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();
        waitForStart();
        robot.leftbackMotor.setPower(-FORWARD_SPEED);
        robot.rightBackMotor.setPower(FORWARD_SPEED);
        robot.leftFrontMotor.setPower(-FORWARD_SPEED);
        robot.rightFrontMotor.setPower(FORWARD_SPEED);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        sleep(800);
        robot.leftbackMotor.setPower(0);
        robot.rightBackMotor.setPower(0);
        robot.rightFrontMotor.setPower(0);
        robot.leftFrontMotor.setPower(0);
        robot.capball.setPower(0);
        robot.collector.setPower(1);
        robot.shooterright.setPower(-1);
        robot.shooterleft.setPower(1);
        Thread.sleep(1500);
        robot.leftbackMotor.setPower(TURN_SPEED);
        robot.rightBackMotor.setPower(TURN_SPEED);
        robot.leftFrontMotor.setPower(TURN_SPEED);
        robot.rightFrontMotor.setPower(TURN_SPEED);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        sleep(2000);
        robot.leftbackMotor.setPower(FORWARD_SPEED);
        robot.rightBackMotor.setPower(-FORWARD_SPEED);
        robot.leftFrontMotor.setPower(FORWARD_SPEED);
        robot.rightFrontMotor.setPower(-FORWARD_SPEED);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        sleep(1500);
        robot.leftbackMotor.setPower(0);
        robot.rightBackMotor.setPower(-FORWARD_SPEED);
        robot.leftFrontMotor.setPower(0);
        robot.rightFrontMotor.setPower(-FORWARD_SPEED);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        sleep(1100);
        robot.leftbackMotor.setPower(FORWARD_SPEED);
        robot.rightBackMotor.setPower(-FORWARD_SPEED);
        robot.leftFrontMotor.setPower(FORWARD_SPEED);
        robot.rightFrontMotor.setPower(-FORWARD_SPEED);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        sleep(1400);










        /*if(robot.colorSensor.red()<=2)
        {
            robot.leftbackMotor.setPower(0);
            robot.rightBackMotor.setPower(0);
            robot.leftFrontMotor.setPower(0);
            robot.rightFrontMotor.setPower(0);
            robot.capball.setPower(0);
            robot.collector.setPower(0);
            robot.shooterright.setPower(0);
            robot.shooterleft.setPower(0);
            sleep(5000); ;
            robot.leftbackMotor.setPower(-FORWARD_SPEED);
            robot.rightBackMotor.setPower(FORWARD_SPEED);
            robot.leftFrontMotor.setPower(-FORWARD_SPEED);
            robot.rightFrontMotor.setPower(FORWARD_SPEED);
            sleep(300);

        }*/
    }
}
