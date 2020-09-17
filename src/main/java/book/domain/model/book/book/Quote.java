package book.domain.model.book.book;

import book.domain.model.link.link.LinkObject;

/**
 * 引用
 */
public class Quote implements LinkObject {
    private String value;
    private String linkId;

    public Quote(String value) {
        this.value = value;

    }

    @Deprecated
    Quote() {
    }

    public static Quote empty() {
        return new Quote();
    }

    public String value() {
        return value;
    }

    @Override
    public String getLinkId() {
        return linkId;
    }
}
