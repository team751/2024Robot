package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import frc.lib.util.COTSTalonFXSwerveConstants;
import frc.lib.util.SwerveModuleConstants;

@SuppressWarnings("unused")
public class Constants {
    public static boolean loggingEnabled = false;

    // Everything on the drive train is on the CANivore, so we use this ID for all CTRE configs
    public static String CANivoreID = "2003 Nissan Ultima"; // Don't ask Spencer why this is named this
    public static double stickDeadband = 0.05;
    public static int teamNumber = 751;

    public static class Intake {
        // 1 falcon for intake, 2 NEOs for moving intake TBD gear ratio
        public static int intakeMotorID = 57;
        public static int leftSwivelMotorID = 58;
        public static int rightSwivelMotorID = 59;
        public static int beamBreakDIOPort = 1;

        public static double swivelGearRatio = 15.0;
        public static double intakeSpeed = 30; // units in rotations per second
		public static double ampScoreSpeed = 15.0; // units in rotations per second

		public static double intakeTime = 5.0; // unit in seconds
		public static double minIntakeTime = 1.5;

        public static double intakeRollerRadius = 2.54; // units in centimeters

        public static double kPSwivelController = 0.025;
        public static double kISwivelController = 0.0;
        public static double kDSwivelController = 0.0;

        public static double kSwivelTime = 0.17;

        public static double kSSwivelFeedforward = 0.025;
        public static double kGSwivelFeedforward = 0.19;
        public static double kVSwivelFeedforward = 1.17;

        public static double kSIntakeController = 0.30606;
        public static double kVIntakeController = 0.1152;
        public static double kAIntakeController = 0.0036207;
        public static double kPIntakeController = 0.16228;
        public static double kIIntakeController = 0.0;
        public static double kDIntakeController = 0.0;

        public static double kIntakeAngle = 7.0;
        public static double kMaintenanceAngle = 45.0;
        public static double kAmpAngle = 125.0;
        public static double kRetractedAngle = 135.0;

        public static double kSwivelEncoderZeroOffset = 266;
    }

    public static class Transfer {
        public static int intakeTransferID = 54;
        public static double intakeTransferRadius = 5.08; // units in centimeters

        public static int shooterTransferID = 55;
        public static double shooterTransferRadius = 2.8575; // units in centimeters

        public static int beamBreakDIOPort = 0;

        public static double kSIntakeController = 0.0;
        public static double kVIntakeController = 0.0;
        public static double kPIntakeController = 0.450;

        public static double kSShootController = 3.07;
        public static double kVShootController = 0.02;
        public static double kPShooterController = 0.01;

        public static double maxTransferTime = 3.0; // unit in seconds
        public static double minTransferTime = 1.5;
        public static double intakeTransferSpeed = 20.0; // units in rotations per second
        public static double kTransferSpeed = 20.0; // units in centimeters per second
    }

    public static class Shooter {
        // 2 krakens for shooting, one neo for the transfer belts.
        public static int leftShooterMotorID = 51;
        public static int rightShooterMotorID = 52;

        public static double spinUpTime = 0.5;
        public static double transferSpeed = 20.0; // units in centimeters per second
		public static double feedTime = 2; // seconds

        public static double maxShooterSpeed = 80;// * 0.333; // units in rotations per second
        public static int motionMagicAcceleration = 400; // units in rotations per second squared
        public static int motionMagicJerk = 4000; // units in rotations per second cubed

        public static double scoreAmpSpeed = 29.0; // units in rotations per second

        public static double kSFlyWheelFeedforward = 0.25;
        public static double kVFlyWheelFeedforward = 0.12;
        public static double kAFlyWheelFeedforward = 0.01;

        public static double kPFlyWheelController = 0.11;
        public static double kIFlyWheelController = 0.0;
        public static double kDFlyWheelController = 0.0;

        public static double kProcessNoise = 3.0;
		public static double kMeasurementNoise = 0.01;

        public static double targetDistance = 2.00; // units in meters
    }

    public static class Climber {
        public static int leftClimberMotorID = 61;
        public static int rightClimberMotorID = 62;

        public static double maxClimberHeight = 100.0;
        public static double minClimberHeight = 5.0;

        public static double climberSpeed = 5.0;

        public static double kGearRatio = 64.0;
        public static double kSpoolRadius = 1.0; // units in centimeters

        public static double voltage = 12;
    }

    public static class Swerve {
        public static int pdhId = 1;
        public static int pigeonID = 2;
        public static boolean enableFOC = true;

        public static COTSTalonFXSwerveConstants chosenModule = COTSTalonFXSwerveConstants.SDS.MK4i.KrakenX60(COTSTalonFXSwerveConstants.SDS.MK4i.driveRatios.L3);

        /* Drivetrain Constants */
        public static double trackWidth = 0.55245; //21.75 inches // 27 (Frame width) - 2*2.625 (SDS wheel offset) to meters
        public static double wheelBase = 0.55245;
        public static double wheelCircumference = chosenModule.wheelCircumference;

        /* Swerve Kinematics
         * No need to ever change this unless you are not doing a traditional rectangular/square 4 module swerve */
        public final static SwerveDriveKinematics swerveKinematics = new SwerveDriveKinematics(
            new Translation2d(wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(wheelBase / 2.0, -trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, trackWidth / 2.0),
            new Translation2d(-wheelBase / 2.0, -trackWidth / 2.0)
        );

        /* Module Gear Ratios */
        public static double driveGearRatio = chosenModule.driveGearRatio;
        public static double angleGearRatio = chosenModule.angleGearRatio;

        /* Motor Inverts */
        public static InvertedValue angleMotorInvert = chosenModule.angleMotorInvert;
        public static InvertedValue driveMotorInvert = chosenModule.driveMotorInvert;

        /* Angle Encoder Invert */
        public static SensorDirectionValue CANCoderInvert = chosenModule.cancoderInvert;

        /* Swerve Current Limiting */
        public static int angleCurrentLimit = 30;
        public static int angleCurrentThreshold = 40;
        public static double angleCurrentThresholdTime = 0.25;
        public static boolean angleEnableCurrentLimit = true;

        public static int driveCurrentLimit = 40;
        public static int driveCurrentThreshold = 50;
        public static double driveCurrentThresholdTime = 0.1;
        public static boolean driveEnableCurrentLimit = true;

        /* These values are used by the drive falcon to ramp in open loop and closed loop driving.
         * We found a small open loop ramp (0.25) helps with tread wear, tipping, etc */
        public static double openLoopRamp = 0.25;
        public static double closedLoopRamp = 0.0;

        /* Angle Motor PID Values */
        // KP is changed below in Swerve Profiling Values
        public static double angleKP = 50;
        //3.7402;
        public static double angleKI = 0;
        public static double angleKD = 0;

        /* Drive Motor PID Values */
        public static double driveKS = 0.32;
        public static double driveKV = 1.51;
        public static double driveKP = 0.12;
        public static double driveKI = 0.0;
        public static double driveKD = 0.0;

        /* Swerve Profiling Values */
        public static double translationPreciseControlFactor = 0.25;
        public static double rotationPreciseControlFactor = 0.5;
        /** Meters per Second */
        public static double maxSpeed = 5;
        /** Multiplier */
		public static double speedMultiplier = 1;
        public static double spinSpeedMultiplier = 1;
        /** Radians per Second */
        public static double maxAngularVelocity = maxSpeed / 1.6 * spinSpeedMultiplier;

        /* Neutral Modes */
        public static NeutralModeValue angleNeutralMode = NeutralModeValue.Coast;
        public static NeutralModeValue driveNeutralMode = NeutralModeValue.Brake;

        /* Module Specific Constants */

        public static class SwerveModule {
            public int driveMotorID;
            public int angleMotorID;
            public int CANCoderID;
            public Rotation2d angleOffset;
            public SwerveModuleConstants constants;

            public SwerveModule(int driveMotorID, int angleMotorID, int CANCoderID, double moduleAngleOffset){
                this.driveMotorID = driveMotorID;
                this.angleMotorID = angleMotorID;
                this.CANCoderID = CANCoderID;
                this.angleOffset = Rotation2d.fromDegrees(moduleAngleOffset);
                this.constants = new SwerveModuleConstants(driveMotorID, angleMotorID, CANCoderID, angleOffset);
            }
        }

        public static SwerveModule frontLeftModule = new SwerveModule(11, 12, 13, 81.21);
        public static SwerveModule frontRightModule = new SwerveModule(21, 22, 23, 59.41);
        public static SwerveModule backLeftModule = new SwerveModule(31, 32, 33, 79.45);
        public static SwerveModule backRightModule = new SwerveModule(41, 42, 43, 259.10);
    }

    public static class Limelight {
        public static double version = 3.0;
        public static String streamIp = "http://10.7.51.11:5800";
		public static String dashboardIp = "http://10.7.51.11:5801";
        public static String name = "limelight";

        public static double height = 15.61 + 3.75; // inches
        public static double angle = 35;
    }

    public static class CANdle {
        public static int CANdleID = 3;
        public static int LEDCount = 13 + 8; // the 8 is the number of LEDs on the CANdle
    }

    public static class CurrentManager {
        public static double maxCurrent = 180.0;
        public static double maxPercent = 0.8;
        public static double nominalPercent = 0.5;
    }

    public static class Odometry {
        public static double maxLimeTimeout = 0.1; // seconds
        public static double maxLimeSwerveDeviation = 0.1; // meters
        public static double kalmanGain = 0.5; // bro guess too lazy
        public static double limeSwerveMixRatio = 0.8; // 80% limelight, 20% swerve


        public static double kPositionNoiseVar = 0.025;
        public static double kVelocityNoiseVar = 0.025;
        public static double kAccelerationNoiseVar = 0.25;

        public static double kPositionProcessNoise = 0.015;
        public static double kVelocityProcessNoise = 0.015;
        public static double kAccelerationProcessNoise = 0.075;
    }

    public static class AutoConstants {
        public static double kMaxSpeedMetersPerSecond = 1; // 3
        public static double kMaxAccelerationMetersPerSecondSquared = 1; // 3
        public static double kMaxAngularSpeedRadiansPerSecond = Math.PI;
        public static double kMaxAngularSpeedRadiansPerSecondSquared = Math.PI;


        //especially these values
        public static double kPXController = 0.8;
        public static double kPYController = 0.8;
        public static double kPThetaController = 1;

        /* Constraint for the motion profiled robot angle controller */
        public static TrapezoidProfile.Constraints kThetaControllerConstraints =
            new TrapezoidProfile.Constraints(
                kMaxAngularSpeedRadiansPerSecond, kMaxAngularSpeedRadiansPerSecondSquared);
    }

    public static class FieldConstants {
        public static class FieldElements{
            public String name;
            public double x;
            public double y;
            public double z;

            public double minX;
            public double maxX;
            public double minY;
            public double maxY;

            public FieldElements(String name, double x, double y, double z, double minX, double maxX, double minY, double maxY){
                this.name = name;
                this.x = x;
                this.y = y;
                this.z = z;
                this.minX = minX;
                this.maxX = maxX;
                this.minY = minY;
                this.maxY = maxY;
            }

            public Boolean isInFieldElements(Pose2d robotPose){
                return robotPose.getX() > minX && robotPose.getX() < maxX && robotPose.getY() > minY && robotPose.getY() < maxY;
            }
        }
        public static FieldElements[] blue = {
            new FieldElements("Amp", 3.57, 7.94, 0.0, -1.0, 1.0, -1.0, 1.0),
            new FieldElements("Speaker", 0.5, 5.5, 0.0, -1.0, 1.0, -1.0, 1.0),
            new FieldElements("Stage", 0, 5, 0.0, -1.0, 1.0, -1.0, 1.0),
            new FieldElements("Chute", 2.8, 0.78, 0.0, -1.0, 1.0, -1.0, 1.0),
        };

        public static FieldElements[] red = {
            new FieldElements("Amp", 12.99, 7.95, 0.0, -1.0, 1.0, -1.0, 1.0),
            new FieldElements("Speaker", 15.5, 5.75, 0.0, -1.0, 1.0, -1.0, 1.0),
            new FieldElements("Stage", 10.74, 4.02, 0.0, -1.0, 1.0, -1.0, 1.0),
            new FieldElements("Chute", 13.74, 0.80, 0.0, -1.0, 1.0, -1.0, 1.0),
        };
    }
}
