package listener;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.testng.*;


public class TestListener implements ITestListener, ISuiteListener, IInvokedMethodListener {
    private static Logger Log = Logger.getLogger(Log.class.getName());


    @Override
    public void onStart(ISuite arg0) {
        Log.info("About to begin executing Suite " + arg0.getName());

    }


    @Override

    public void onFinish(ISuite arg0) {
        Log.info("About to end executing Suite " + arg0.getName());

    }


    public void onStart(ITestContext arg0) {
        Log.info("About to begin executing Test " + arg0.getName());

    }


    public void onFinish(ITestContext arg0) {
        Log.info("Completed executing test " + arg0.getName());
    }


    public void onTestSuccess(ITestResult arg0) {


        printTestResults(arg0);

    }


    public void onTestFailure(ITestResult arg0) {


        printTestResults(arg0);

    }


    public void onTestStart(ITestResult arg0) {

        System.out.println("The execution of the main test starts now");

    }


    public void onTestSkipped(ITestResult arg0) {

        printTestResults(arg0);

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

    }

    private void printTestResults(ITestResult result) {
        Log.info("Test Method resides in " + result.getTestClass().getName());

        if (result.getParameters().length != 0) {

            String params = null;

            for (Object parameter : result.getParameters()) {

                params += parameter.toString() + ",";

            }
            Reporter.log("Test Method had the following parameters : " + params, true);

        }

        String status = null;

        switch (result.getStatus()) {

            case ITestResult.SUCCESS:

                status = "Pass";

                break;

            case ITestResult.FAILURE:

                status = "Failed";

                break;

            case ITestResult.SKIP:

                status = "Skipped";

        }
        Reporter.log("Test Status: " + status, true);

    }

    public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {

        String textMsg = "About to begin executing following method : " + returnMethodName(arg0.getTestMethod());
        Reporter.log(textMsg, true);

    }


    public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {

        String textMsg = "Completed executing following method : " + returnMethodName(arg0.getTestMethod());
        Reporter.log(textMsg, true);

    }

    private String returnMethodName(ITestNGMethod method) {

        return method.getRealClass().getSimpleName() + "." + method.getMethodName();

    }
}
