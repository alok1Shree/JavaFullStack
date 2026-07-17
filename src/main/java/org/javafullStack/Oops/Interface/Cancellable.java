package org.javafullStack.Oops.Interface;

public interface Cancellable {
    boolean cancel(String reason);
    boolean isCancellable();
    String  getCancellationPolicy();
}
