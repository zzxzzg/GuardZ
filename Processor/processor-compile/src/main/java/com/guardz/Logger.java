package com.guardz;

import com.sun.javafx.binding.StringFormatter;

import org.apache.commons.lang3.StringUtils;

import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;

/**
 * Simplify the messager.
 *
 * @author Alex <a href="mailto:zhilong.liu@aliyun.com">Contact me.</a>
 * @version 1.0
 * @since 16/8/22 上午11:48
 */
public class Logger {
    public static final String PROJECT = "Annotation";
    static final String PREFIX_OF_LOGGER = PROJECT + "::Compiler ";

    private Messager msg;

    public Logger(Messager messager) {
        msg = messager;
    }

    /**
     * Print info log.
     */
    public void info(CharSequence info) {
        if (StringUtils.isNotEmpty(info)) {
            msg.printMessage(Diagnostic.Kind.NOTE, PREFIX_OF_LOGGER + info);
        }
    }

    public void error(CharSequence error) {
        if (StringUtils.isNotEmpty(error)) {
            msg.printMessage(Diagnostic.Kind.ERROR, PREFIX_OF_LOGGER + "An exception is encountered, [" + error + "]");
        }
    }

    public void error(CharSequence error,Object... args) {
        if (StringUtils.isNotEmpty(error)) {
            String str = String.format(error.toString(),args);
            msg.printMessage(Diagnostic.Kind.ERROR, PREFIX_OF_LOGGER + "An exception is encountered, [" + str + "]");
        }
    }

    public void error(Throwable error) {
        if (null != error) {
            msg.printMessage(Diagnostic.Kind.ERROR, PREFIX_OF_LOGGER + "An exception is encountered, [" + error.getMessage() + "]" + "\n" + formatStackTrace(error.getStackTrace()));
        }
    }

    public void warning(CharSequence warning) {
        if (StringUtils.isNotEmpty(warning)) {
            msg.printMessage(Diagnostic.Kind.WARNING, PREFIX_OF_LOGGER + warning);
        }
    }

    private String formatStackTrace(StackTraceElement[] stackTrace) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement element : stackTrace) {
            sb.append("    at ").append(element.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
