/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.LightSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;
import android.graphics.Color;

/**
 * This file illustrates the concept of driving a path based on time.
 * It uses the common Pushbot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 *
 * The code assumes that you do NOT have encoders on the wheels,
 *   otherwise you would use: PushbotAutoDriveByEncoder;
 *
 *   The desired path in this example is:
 *   - Drive forward for 3 seconds
 *   - Spin right for 1.3 seconds
 *   - Drive Backwards for 1 Second
 *   - Stop and close the claw.
 *
 *  The code is written in a simple form with no optimizations.
 *  However, there are several ways that this type of sequence could be streamlined,
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="Pushbot: Auto Drive By Time", group="Pushbot")
@Disabled
public class PushbotAutoDriveByTime_Linear extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareK9bot         robot   = new HardwareK9bot();   // Use a Pushbot's hardware
    private ElapsedTime     runtime = new ElapsedTime();

    static final double     FORWARD_SPEED = 0.6;
    static final double     TURN_SPEED    = 0.5;

    @Override
    public void runOpMode() throws InterruptedException{

        robot.init(hardwareMap);
        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        float hsvValues[] = {0F,0F,0F};
        final float values[] = hsvValues;
        robot.colorSensor.enableLed(false);
        Color.RGBToHSV(robot.colorSensor.red() * 8, robot.colorSensor.green() * 8, robot.colorSensor.blue() * 8 , hsvValues);
        robot.top.scaleRange(0,1);


        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way
       /* robot.leftbackMotor.setPower(-FORWARD_SPEED);
        robot.rightBackMotor.setPower(FORWARD_SPEED);
        robot.leftFrontMotor.setPower(-FORWARD_SPEED);
        robot.rightFrontMotor.setPower(FORWARD_SPEED);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        Thread.sleep(800);
        robot.leftbackMotor.setPower(0);
        robot.rightBackMotor.setPower(0);
        robot.rightFrontMotor.setPower(0);
        robot.leftFrontMotor.setPower(0);
        robot.capball.setPower(0);
        robot.collector.setPower(0.95);
        robot.shooterright.setPower(-0.75);
        robot.shooterleft.setPower(0.75);
        Thread.sleep(900);
        robot.leftbackMotor.setPower(0);
        robot.rightBackMotor.setPower(0);
        robot.rightFrontMotor.setPower(0);
        robot.leftFrontMotor.setPower(0);
        robot.capball.setPower(0);
        robot.collector.setPower(-0.95);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        Thread.sleep(300);
        robot.leftbackMotor.setPower(0);
        robot.rightBackMotor.setPower(0);
        robot.rightFrontMotor.setPower(0);
        robot.leftFrontMotor.setPower(0);
        robot.capball.setPower(0);
        robot.collector.setPower(0.95);
        robot.shooterright.setPower(-0.75);
        robot.shooterleft.setPower(0.75);
        Thread.sleep(900);*/
        /*robot.leftbackMotor.setPower(-FORWARD_SPEED);
        robot.rightBackMotor.setPower(-FORWARD_SPEED);
        robot.leftFrontMotor.setPower(-FORWARD_SPEED);
        robot.rightFrontMotor.setPower(-FORWARD_SPEED);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        Thread.sleep(700);
        robot.leftbackMotor.setPower(-FORWARD_SPEED);
        robot.rightBackMotor.setPower(FORWARD_SPEED);
        robot.leftFrontMotor.setPower(-FORWARD_SPEED);
        robot.rightFrontMotor.setPower(FORWARD_SPEED);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        Thread.sleep(2400);
        robot.leftbackMotor.setPower(0);
        robot.rightBackMotor.setPower(FORWARD_SPEED);
        robot.leftFrontMotor.setPower(0);
        robot.rightFrontMotor.setPower(FORWARD_SPEED);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        Thread.sleep(1400);
        telemetry.addData("LED", true ? "On" : "Off");
        telemetry.addData("Clear", robot.colorSensor.alpha());
        telemetry.addData("Red  ", robot.colorSensor.red());
        telemetry.addData("Green", robot.colorSensor.green());
        telemetry.addData("Blue ", robot. colorSensor.blue());
        telemetry.addData("Hue", hsvValues[0]);
        telemetry.update();
        robot.leftbackMotor.setPower(0.3);
        robot.rightBackMotor.setPower(-0.3);
        robot.leftFrontMotor.setPower(0.3);
        robot.rightFrontMotor.setPower(-0.3);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        Thread.sleep(400);

     while(robot.colorSensor.red()<=2)
       //robot.colorSensor.red()<2 robot.colorSensor.blue()<3
        {
            //robot.colorSensor.red()<2 robot.colorSensor.blue()<3
        robot.leftbackMotor.setPower(-0.3);
        robot.rightBackMotor.setPower(0.3);
        robot.leftFrontMotor.setPower(-0.3);
        robot.rightFrontMotor.setPower(0.3);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        }
        robot.leftbackMotor.setPower(-0.2);
        robot.rightBackMotor.setPower(0.2);
        robot.leftFrontMotor.setPower(-0.2);
        robot.rightFrontMotor.setPower(0.2);
        robot.capball.setPower(0);
        robot.collector.setPower(0);
        robot.shooterright.setPower(0);
        robot.shooterleft.setPower(0);
        sleep(775);
        robot.hit.setPosition(0.15);
        sleep(200);*/
        robot.hit.setPosition(0.00);
        sleep(200);
        telemetry.addData("LED", true ? "On" : "Off");
        telemetry.addData("Clear", robot.colorSensor.alpha());
        telemetry.addData("Red  ", robot.colorSensor.red());
        telemetry.addData("Green", robot.colorSensor.green());
        telemetry.addData("Blue ", robot. colorSensor.blue());
        telemetry.addData("Hue", hsvValues[0]);
        telemetry.update();




    }
}
