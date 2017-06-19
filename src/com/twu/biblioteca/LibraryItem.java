package com.twu.biblioteca;

public abstract class LibraryItem {

    private boolean checkedOut = false;

    public void checkout() throws AlreadyCheckedOutException {
        if (!checkedOut) {
            checkedOut = true;
        } else {
            throw new AlreadyCheckedOutException();
        }
    }

    public void returnItem() throws NotCheckedOutException {
        if (checkedOut) {
            checkedOut = false;
        } else {
            throw new NotCheckedOutException();
        }
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }
}
