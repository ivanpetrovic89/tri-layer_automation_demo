package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Retry is a TestNG listener class that implements {@link IRetryAnalyzer}.
 * <p>
 * It retries failed test cases for maxTry times in case the test does not pass because of other factors
 * that are not specified in the test case.
 */

public class Retry implements IRetryAnalyzer {
    /**
     * The number of retries that have been attempted
     */
    private int count = 0;

    /**
     * The maximum number of retries to attempt
     */
    private int maxTry = 2;

    /**
     * It retries the test for maxTry times and if the test fails every time it returns
     * that the test has definitely failed.
     *
     * @param  testResult  the result of the test that was run
     * @return             true if the test should be retried, false otherwise
     */
    @Override
    public boolean retry(ITestResult testResult) {
        if(!testResult.isSuccess()){
            if(count<maxTry){
                count++;
                testResult.setStatus(ITestResult.FAILURE);
                return true;
            }else{
                testResult.setStatus(ITestResult.FAILURE);
            }
        }else{
            testResult.setStatus(ITestResult.SUCCESS);
        }
        return false;
    }
}
