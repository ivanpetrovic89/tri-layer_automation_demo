package listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * AnnotationTransformer is a TestNG listener class that implements {@link IAnnotationTransformer}.
 * <p>
 * It sets the retry analyzer for the test annotation.
 */

public class AnnotationTransformer implements IAnnotationTransformer {
    /**
     * Overrides the {@link IAnnotationTransformer#transform(ITestAnnotation, Class, Constructor, Method)} method to set the retry analyzer for the test annotation
     * @param  annotation       the annotation to modify
     * @param  testClass        the class where the test method is located
     * @param  testConstructor  the constructor for the test class
     * @param  testMethod       the test method
     */
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod){
        annotation.setRetryAnalyzer(Retry.class);
    }

}
