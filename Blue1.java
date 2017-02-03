package org.firstinspires.ftc.robotcontroller.external.samples;
import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
/**
 * Created by advaitmarathe on 1/31/17.
 */

public class Blue1 extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareK9bot        robot   = new HardwareK9bot();   // Use a Pushbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();

    static final double     COUNTS_PER_MOTOR_REV    = 1680 ;    // eg: TETRIX Motor Encoder
    static final double     DRIVE_GEAR_REDUCTION    = 1.0 ;     // This is < 1.0 if geared UP
    static final double     WHEEL_DIAMETER_INCHES   = 4.0 ;     // For figuring circumference
    static final double     COUNTS_PER_INCH         = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double     DRIVE_SPEED             = 0.6;
    static final double     TURN_SPEED              = 0.5;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);
        float hsvValues[] = {0F,0F,0F};
        final float values[] = hsvValues;
        robot.colorSensor.enableLed(false);
        Color.RGBToHSV(robot.colorSensor.red() * 8, robot.colorSensor.green() * 8, robot.colorSensor.blue() * 8 , hsvValues);
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();

        robot.leftbackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightBackMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.rightFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftFrontMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();

        robot.leftbackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Path0",  "Starting at %7d :%7d: %7d: %7d",
                robot.leftbackMotor.getCurrentPosition(),
                robot.leftFrontMotor.getCurrentPosition(),
                robot.rightBackMotor.getCurrentPosition(),
                robot.rightFrontMotor.getCurrentPosition());
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path,
        // Note: Reverse movement is obtained by setting a negative distance (not speed)
        //left is going straight
        //right is reversed
        encoderDrive(DRIVE_SPEED,  -7,  7, 10.0);
        robot.leftbackMotor.setPower(0);
        robot.rightBackMotor.setPower(0);
        robot.rightFrontMotor.setPower(0);
        robot.leftFrontMotor.setPower(0);
        robot.capball.setPower(0);
        robot.collector.setPower(0.5);
        robot.shooterright.setPower(-0.5);
        robot.shooterleft.setPower(1);
        sleep(2000);
        robot.leftbackMotor.setPower(0);
        robot.rightBackMotor.setPower(0);
        robot.rightFrontMotor.setPower(0);
        robot.leftFrontMotor.setPower(0);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        sleep(100);
        encoderDrive(DRIVE_SPEED, -20, 20 , 10.0);
        encoderDrive(TURN_SPEED,28,28,10.0 );
        //        encoderDrive(TURN_SPEED,21,21,10.0 ); is a perfect 90 :)
        encoderDrive(DRIVE_SPEED,44,-44, 10.0);
        // S1: Forward 47 Inches with 5 Sec timeout
       // encoderDrive(TURN_SPEED,   12, -12, 4.0);  // S2: Turn Right 12 Inches with 4 Sec timeout
       // encoderDrive(DRIVE_SPEED, -24, -24, 4.0);  // S3: Reverse 24 Inches with 4 Sec timeout
        encoderDrive(TURN_SPEED,-8.75,-8.75,10.0 );
        encoderDrive(DRIVE_SPEED,13.2,-13.2, 10.0);
        encoderDrive(0.3,-1,1,10.0);
        robot.leftbackMotor.setPower(0);
        robot.rightBackMotor.setPower(0);
        robot.rightFrontMotor.setPower(0);
        robot.leftFrontMotor.setPower(0);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0.3);
        robot.shooterleft.setPower(0);
        sleep(2000);
        if(robot.colorSensor.red()>=2)
        {
            encoderDrive(DRIVE_SPEED,-12,12,10.0);
            robot.leftbackMotor.setPower(0);
            robot.rightBackMotor.setPower(0);
            robot.leftFrontMotor.setPower(0);
            robot.rightFrontMotor.setPower(0);
            robot.capball.setPower(0);
            robot.collector.setPower(0);
            robot.shooterright.setPower(0);
            robot.shooterleft.setPower(0);
            sleep(4300); ;
            encoderDrive(DRIVE_SPEED,13,-13,10.0);

            encoderDrive(DRIVE_SPEED,-12,12,10.0);

        }
        else
        {
            encoderDrive(DRIVE_SPEED,-12,12,10.0);
        }
        encoderDrive(DRIVE_SPEED,-13,13,10.0);
        encoderDrive(TURN_SPEED,-18,-18,10.0);
        robot.leftbackMotor.setPower(0);
        robot.rightBackMotor.setPower(1);
        robot.leftFrontMotor.setPower(0);
        robot.rightFrontMotor.setPower(1);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        sleep(2500); ;


        telemetry.addData("Path", "Complete");
        telemetry.update();
    }

    /*
     *  Method to perfmorm a relative move, based on encoder counts.
     *  Encoders are not reset as the move is based on the current position.
     *  Move will stop if any of three conditions occur:
     *  1) Move gets to the desired position
     *  2) Move runs out of time
     *  3) Driver stops the opmode running.
     */
    public void encoderDrive(double speed,
                             double leftInches, double rightInches,
                             double timeoutS) {
        int newLeftbackTarget;
        int newRightbackTarget;
        int leftFrontTarget;
        int rightFrontTarget;
        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftbackTarget = robot.leftbackMotor.getCurrentPosition() + (int)(leftInches * COUNTS_PER_INCH);
            newRightbackTarget = robot.rightBackMotor.getCurrentPosition() + (int)(rightInches * COUNTS_PER_INCH);
            leftFrontTarget = robot.leftFrontMotor.getCurrentPosition()+ (int)(leftInches * COUNTS_PER_INCH);
            rightFrontTarget = robot.rightFrontMotor.getCurrentPosition()+ (int)(rightInches * COUNTS_PER_INCH);

            robot.leftbackMotor.setTargetPosition(newLeftbackTarget);
            robot.rightBackMotor.setTargetPosition(newRightbackTarget);
            robot.rightFrontMotor.setTargetPosition(rightFrontTarget);
            robot.leftFrontMotor.setTargetPosition(leftFrontTarget);



            // Turn On RUN_TO_POSITION
            robot.leftbackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightBackMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.rightFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.leftFrontMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


            // reset the timeout time and start motion.
            runtime.reset();
            robot.leftbackMotor.setPower(Math.abs(speed));
            robot.rightBackMotor.setPower(Math.abs(speed));
            robot.rightFrontMotor.setPower(Math.abs(speed));
            robot.leftFrontMotor.setPower(Math.abs(speed));


            // keep looping while we are still active, and there is time left, and both motors are running.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (robot.leftbackMotor.isBusy() && robot.rightBackMotor.isBusy()&& robot.rightFrontMotor.isBusy()&& robot.leftFrontMotor.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1",  "Running to %7d :%7d", newLeftbackTarget,  newRightbackTarget);
                telemetry.addData("Path2",  "Running at %7d :%7d",
                        robot.leftbackMotor.getCurrentPosition(),
                        robot.rightBackMotor.getCurrentPosition());
                telemetry.addData("LED", true ? "On" : "Off");
                telemetry.addData("Clear", robot.colorSensor.alpha());
                telemetry.addData("Red  ", robot.colorSensor.red());
                telemetry.addData("Green", robot.colorSensor.green());
                telemetry.addData("Blue ", robot. colorSensor.blue());
                telemetry.update();
            }

            // Stop all motion;
            robot.leftbackMotor.setPower(0);
            robot.rightBackMotor.setPower(0);
            robot.rightFrontMotor.setPower(0);
            robot.leftFrontMotor.setPower(0);

            // Turn off RUN_TO_POSITION
            robot.leftbackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightBackMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.rightFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            robot.leftFrontMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        }
    }
}
