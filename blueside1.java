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

    }
}
