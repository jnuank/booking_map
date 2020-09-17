package book.domain.model.book.book;

import book.domain.model.link.link.LinkObject;

/**
 * 章
 */
public class Chapter implements LinkObject {
    private String value;
    private String linkId;

    public Chapter(String value) {
        this.value = value;

    }

    @Deprecated
    Chapter() {
    }

    public static Chapter empty() {
        return new Chapter();
    }

    public String value() {
        return value;
    }

    @Override
    public String getLinkId() {
        return linkId;
    }
}
