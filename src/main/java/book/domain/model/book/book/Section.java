package book.domain.model.book.book;

import book.domain.model.link.link.LinkObject;

/**
 * 節
 */
public class Section implements LinkObject {
    private String value;
    private String linkId;

    public Section(String value) {
        this.value = value;

    }

    @Deprecated
    Section() {
    }

    public static Section empty() {
        return new Section();
    }

    public String value() {
        return value;
    }

    @Override
    public String getLinkId() {
        return linkId;
    }
}
