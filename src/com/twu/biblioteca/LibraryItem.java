package com.twu.biblioteca;

class AlreadyCheckedOutException extends Exception {}
class NotCheckedOutException extends Exception {}

public abstract class LibraryItem {

    private boolean checkedOut = false;
    private User holdingCustomer;

    public void checkout(User user) throws AlreadyCheckedOutException {
        if (!checkedOut) {
            checkedOut = true;
            holdingCustomer = user;
        } else {
            throw new AlreadyCheckedOutException();
        }
    }

    public User getHoldingCustomer() {
        return holdingCustomer;
    }

    public void returnItem() throws NotCheckedOutException {
        if (checkedOut) {
            checkedOut = false;
            holdingCustomer = null;
        } else {
            throw new NotCheckedOutException();
        }
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public abstract String getItemInfo();
}
